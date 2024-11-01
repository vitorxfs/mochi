function Home() {
  return (
    <div className="container max-w-screen-2xl">
      <header className="gap-8 grid grid-cols-10 h-28 items-center">
        <div className="col-span-3 text-center">
          mochi
        </div>
        <div className="col-span-7">
          <button>back</button>
        </div>
      </header>

      <main className="gap-8 grid grid-cols-10">
        <div className="col-span-3">
           <h1 className="text-2xl">menu</h1>
        </div>
        <div className="col-span-7">
          <h1 className="text-2xl">Hello World</h1>
        </div>
      </main>
    </div>
  )
}

export default Home;



