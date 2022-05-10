const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  devServer: {
    open: true,
    port: 3000,
    proxy: {
      '^/api': {
        changeOrigin: true,
        target: 'http://localhost:8081/'
      }
    }
  },
  transpileDependencies: ["vuetify"],
});
