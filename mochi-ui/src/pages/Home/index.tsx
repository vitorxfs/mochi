import { useQuery } from '@tanstack/react-query';

// TODO: Create import alias
import { AnimeApiImpl } from '../../common/features/anime/anime.api';
import AnimeItem from '../../common/components/AnimeItem';
import AnimeService from '../../common/features/anime/anime.service';
import FiltersMenu from './components/FiltersMenu';
import Header from './components/Header';

const animeService = new AnimeService(new AnimeApiImpl());

function Home() {
  const { data, isLoading } = useQuery({
    queryKey: ['home-paged-animes'],
    queryFn: () => animeService.findAnimes()
  });

  return (
    <div className="container max-w-screen-2xl">
      <Header />

      <main className="gap-8 grid grid-cols-10">
        <div className="col-span-3">
          <FiltersMenu />
        </div>

        <div className="col-span-7 grid grid-cols-6 gap-x-4 gap-y-8">
          {data && data.content.map((anime) => (
            <div
              className="col-span-6 sm:col-span-3 2xl:col-span-2"
              key={anime.id}
            >
              <AnimeItem anime={anime} />
            </div>
          ))}

          {isLoading && <span>Loading...</span>}
        </div>
      </main>
    </div>
  )
}

export default Home;



