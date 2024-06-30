import { createRouter, createWebHistory } from 'vue-router'
import Log_Index from '../views/Log_Index.vue'
import main_view from '../views/main_view.vue'
import user_view from '../views/user_view.vue'
import admin_login from '../views/admin_login.vue'
import admin_index from '../views/admin_index.vue'
import user_consult from '../views/user_consult.vue'
import our_service from '../views/our_service.vue'
import blog from '../views/Blog.vue'


  const routes = [
    // {
    //   path:'/',
    //   redirect:'/Log_Index'
    // },
    {
      // path: '/Log_Index',
      path:'/',
      name: 'Log_Index',
      component: Log_Index
    },
    {
      path: '/main_view',
      name: 'main_view',
      component: main_view
    },
    {
      path:'/user_view',
      name:'user_view',
      component:user_view
    },
    {
      path:'/admin_index',
      name:'admin_index',
      component:admin_index
    },
    {
      path:'/admin_login',
      name:'admin_login',
      component:admin_login
    },
    {
      path:'/user_consult',
      name:'user_consult',
      component:user_consult
    },
    {
      path:'/our_service',
      name:'our_service',
      component:our_service
    },
    {
      path:'/blog',
      name:'blog',
      component:blog
    }
  ]
  
  const router = createRouter({
    history: createWebHistory(),
    routes
  })
  
  export default router
  //路由守卫，如果有token则进入后续页面，没有则需要登陆得到token
  router.beforeEach((to,from,next)=>{
    var token = sessionStorage.getItem('token');
    if(token){
        if(next.path == '/')
          return next('main_view');
      return next();
    }
    if(to.path == '/' || to.path == '/admin_login')
      return next();
    else
      return next('/');
  })