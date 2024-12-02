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
      }
    },
  },
  plugins: [],
}

