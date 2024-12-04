import { appTheme } from '../../app/theme';
import Season from '../data-types/season.enum';
import { seasonEnMap, seasonEsMap, seasonPtBrMap } from '../i18n/season';

export interface Anime {
  id: number;
  score: number;
  episodesCount: number;
  reviewsCount: number;
  name: string;
  season: Season;
  year: number;
  genres: { id: number, name: string }[];
  posterUrl?: string;
}

function AnimeItem({ anime }: { anime: Anime }) {
  const score = anime.score;

  const genres = Array.from(new Set(anime.genres));

  const lang = 'pt-br';

  const seasonMapByLang = {
    'pt-br': seasonPtBrMap,
    'es': seasonEsMap,
    'en': seasonEnMap,
  }

  return (
    <div className="flex gap-2">
      <img
        className="w-36 h-56 rounded-2xl shadow"
        src={anime.posterUrl || 'https://placehold.co/141x226'}
        alt={`Poster do anime ${anime.name}`}
        loading='lazy'
      />

      <div className="flex flex-col">
        <p className="text-xs">
          <span className="font-icon">
            star
          </span>{' '}
          <span className="font-bold align-baseline">
            {score}
          </span>{' '}
          - {anime.reviewsCount} users
        </p>

        <h2 className="text-lg font-bold">{anime.name}</h2>

        <p className="-mt-1 text-sm">{seasonMapByLang[lang].get(anime.season)}{' '}{anime.year}</p>

        <ul className="flex flex-wrap mt-3 gap-2 text-textinverted">
          {genres.map((genre, idx) => (
            <li
              className="text-xs font-medium px-1 py-[0.25rem] rounded-md"
              style={{ backgroundColor: appTheme.primary[idx%(appTheme.primary.length)]}}
              key={genre.id}
            >
              {genre.name}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default AnimeItem;
