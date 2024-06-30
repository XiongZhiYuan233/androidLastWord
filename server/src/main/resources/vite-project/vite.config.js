import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import createProxyMiddleware from 'http-proxy-middleware'
// import autoImportPlugin from '@opentiny/unplugin-tiny-vue'




// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server:{
    port:'5174',
    // host:'192.168.1.5',
    proxy:{
      '/api':{
        target:'http://localhost:8080',
        changeOrigin:true,
        rewrite:(path) => path.replace(/^\/api/,'')
    },
    '/ws':{
      target:'ws://localhost:8080',
        changeOrigin:true,
        rewrite:(path) => path.replace(/^\/ws/,'')
    }
  },
  // define: {
  //   'process.env': { ...process.env }
  // }
  // configureServer: (server) => {
  //   // 创建自定义的 WebSocket 代理
  //   server.middlewares.use(
  //     '/api',
  //     httpProxyMiddleware({ target: 'ws://localhost:8080', ws: true })
  //   );
}
})
