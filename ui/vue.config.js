module.exports = {
  publicPath: "/",
  devServer: {
    port: 3454
  },
  pluginOptions: {
    i18n: {
      locale: 'tr',
      fallbackLocale: 'tr',
      localeDir: 'locales',
      enableInSFC: true
    }
  }
};
