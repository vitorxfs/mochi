import { appTheme } from './src/app/theme';
/** @type {import('tailwindcss').Config} */
export default {
  content: ["./src/**/*.{html,js,ts,jsx,tsx}"],
  theme: {
    container: {
      center: true,
      padding: "1rem",
      screens: {
        "2xl": "1080px",
      },
    },
    fontFamily: {
      sans: ['Montserrat', 'sans-serif'],
      icon: ['Material Symbols Outlined']
    },
    extend: {
      colors: {
        background: appTheme.backgroundColor,
        foreground: appTheme.foreground,
        border: appTheme.border,
        inputbg: appTheme.inputBackgroundColor,
        textcolor: appTheme.textColor,
        textinverted: appTheme.textInverted,
        'primary-0': appTheme.primary[0],
        'primary-1': appTheme.primary[1],
        'primary-2': appTheme.primary[2],
        'primary-3': appTheme.primary[3],
      }
    },
  },
  plugins: [],
}

