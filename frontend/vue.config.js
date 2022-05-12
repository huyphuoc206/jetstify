const { defineConfig } = require("@vue/cli-service");
const apiEndpoint = process.env.VUE_APP_API_ENDPOINT;

module.exports = defineConfig({
  devServer: {
    open: true,
    host: 'localhost',
    port: 3000,
    proxy: {
      '^/api': {
        changeOrigin: true,
        target: apiEndpoint || 'http://localhost:8081/'
      }
    }
  },
  transpileDependencies: ["vuetify"],
});