function Header() {
  const handleBack = () => {
    history.back();
  }

  return (
    <header className="gap-8 grid grid-cols-10 h-28 items-center">
      <div className="col-span-3 flex justify-center">
        <img src="/assets/logo.svg" alt="Homepage"/>
      </div>
      <div className="col-span-7">
        <button
          className={`
            font-icon
            w-10 h-10 flex items-center justify-center
            bg-inputbg border border-border
            rounded-md`
          }
          aria-label="Go back"
          onClick={handleBack}
        >
          chevron_left
        </button>
      </div>
    </header>
  )
}

export default Header;
