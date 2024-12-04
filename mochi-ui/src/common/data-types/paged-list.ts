export interface PagedList<T> {
  content: T[];
  pageable: {
    pageNumber: number;
    pageSize: number;
    offset: number;
  }
  totalPages: 1,
  last: boolean;
  first: boolean;
  empty: boolean;
}

export default PagedList
