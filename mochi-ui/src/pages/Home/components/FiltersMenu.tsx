import { appTheme } from '../../../app/theme';
import * as Menu from '../../../common/components/Menu';
import GenresFilter from './filters/Genres';

function FiltersMenu() {
  return (
    <Menu.Root>
      <Menu.Item name="Genres" color={appTheme.primary[0]} defaultOpen>
        <GenresFilter />
      </Menu.Item>
      <Menu.Item name="Season" color={appTheme.primary[1]}>
        TODO
      </Menu.Item>
    </Menu.Root>
  )
}

export default FiltersMenu;
