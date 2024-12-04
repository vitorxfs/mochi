import PagedList from '../../data-types/paged-list';
import { AnimeApi } from './anime.api'
import Anime from './anime.entity';

export class AnimeService {
  private animeApi: AnimeApi;

  constructor(animeApi: AnimeApi) {
    this.animeApi = animeApi;
  }

  findAnimes(): Promise<PagedList<Anime>> {
    return this.animeApi.list()
  }
}

export default AnimeService;
