/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
      "./src/main/resources/templates/**/*.html",
      "./node_modules/flowbite/**/*.js"

],
  daisyui: {
    themes: [
      {
        mytheme: {

          "primary": "#ca8a04",

          "secondary": "#f59e0b",

          "accent": "#00b0ff",

          "neutral": "#040c13",

          "base-100": "#f3f4f6",

          "info": "#0092ff",

          "success": "#00d77b",

          "warning": "#ff7700",

          "error": "#991b1b",
        },
      },
    ],
  },
  theme: {
    screens: {
      'xs': '320px',
      'xsm': '375px',
      'sm': '480px',
      'md': '768px',
      'lg': '976px',
      'xl': '1440px',
    },
    container: {
      center: true,
    },

    extend: {
    },
  },
  plugins: [
      require("daisyui"),
      require("tw-elements/plugin.cjs")
      //require('flowbite/plugin')
  ],
}

