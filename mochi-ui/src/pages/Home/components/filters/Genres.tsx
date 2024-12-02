import { useState } from 'react';

function GenresFilter() {
  const [genres, setGenres] = useState<Record<string, boolean>>({
    'Fantasy': false,
    'Gore': true,
    'Suspense': true,
    'Horror': false,
    'Romance': true,
    'Slice of life': true,
    'Comedy': false
  });

  const handleToggleGenre = (genre: string) => {
    setGenres((prev) => ({
      ...prev,
      [genre]: !prev[genre]
    }))
  }

  return (
    <ul className="flex flex-wrap gap-2">
      {Object.keys(genres).map((genre) => (
        <li>
          <button
            onClick={() => handleToggleGenre(genre)}
            data-selected={genres[genre]}
            className={`
              px-2 py-1 rounded-md
              bg-foreground hover:brightness-125
              data-[selected=true]:bg-primary-0
              data-[selected=true]:text-textinverted
              data-[selected=true]:hover:brightness-90
            `}
          >{genre}</button>
        </li>
      ))}
    </ul>
  )
}

export default GenresFilter;
