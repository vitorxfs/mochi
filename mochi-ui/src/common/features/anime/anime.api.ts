import { isNil, omitBy } from 'lodash';
import PagedList from '../../data-types/paged-list';
import Anime from './anime.entity';
import Season from '../../data-types/season.enum';

export interface AnimeFilters {
  name?: string;
  genreIds?: number[];
}

export interface AnimeApi {
  list(filters?: AnimeFilters): Promise<PagedList<Anime>>;
}

type RawSeason = 'FALL' | 'WINTER' | 'SUMMER' | 'SPRING';

export class AnimeApiImpl implements AnimeApi {
  constructor() {}

  async list(filters?: AnimeFilters): Promise<PagedList<Anime>> {
    let query = ''
    if (filters) {
      query = '?'+this.buildQueryString(filters);
    }
    const res = await fetch('http://localhost:8080/animes'+query);
    const body = await res.json();

    return {
      ...body,
      content: body.content.map((item: { season: string; }) => ({
        ...item,
        season: Season[item.season as RawSeason],
      }))
    };
  }

  private buildQueryString(filters: AnimeFilters): string {
    const filtersWithNoUndefined = omitBy({
      name: filters.name,
      genreIds: filters.genreIds?.join(','),
    }, isNil) as Record<string, string>;

    const urlSearchParams = new URLSearchParams(filtersWithNoUndefined);

    return urlSearchParams.toString();
  }
}

export default AnimeApi;
