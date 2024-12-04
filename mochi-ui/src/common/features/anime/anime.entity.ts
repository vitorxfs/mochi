export interface Genre {
  id: number;
  name: string;
}

export interface Anime {
  id: number;
  name: string;
  episodesCount: number;
  score: number;
  reviewsCount: number;
  year: number;
  season: 'SUMMER' | 'FALL' | 'WINTER' | 'SPRING';
  genres: Genre[]
}

export default Anime;
