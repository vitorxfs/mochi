import FiltersMenu from './components/FiltersMenu';
import Header from './components/Header';

function Home() {
  return (
    <div className="container max-w-screen-2xl">
      <Header />

      <main className="gap-8 grid grid-cols-10">
        <div className="col-span-3">
          <FiltersMenu />
        </div>
        <div className="col-span-7">
          <h1 className="text-2xl">Hello World</h1>
        </div>
      </main>
    </div>
  )
}

export default Home;



