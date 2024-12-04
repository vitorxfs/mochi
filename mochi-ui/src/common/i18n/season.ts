import Season from '../data-types/season.enum';

export const seasonPtBrMap = new Map([
  [Season.FALL, 'Outono'],
  [Season.WINTER, 'Inverno'],
  [Season.SPRING, 'Primavera'],
  [Season.SUMMER, 'Verão']
]);

export const seasonEnMap = new Map([
  [Season.FALL, 'Fall'],
  [Season.WINTER, 'Winter'],
  [Season.SPRING, 'Spring'],
  [Season.SUMMER, 'Summer']
]);

export const seasonEsMap = new Map([
  [Season.FALL, 'Caer'],
  [Season.WINTER, 'Invierno'],
  [Season.SPRING, 'Primavera'],
  [Season.SUMMER, 'Verano']
]);

export const seasonMapByLang = {
  'pt-br': seasonPtBrMap,
  'es': seasonEsMap,
  'en': seasonEnMap,
}
