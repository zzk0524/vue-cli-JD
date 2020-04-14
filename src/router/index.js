import Vue from 'vue'
import VueRouter from 'vue-router'
const Register = () => import('../views/register/Register.vue')
const Home = () => import('../views/home/Home.vue')
Vue.use(VueRouter)
	
const routes = [
  {
  	path:'',
  	redirect:'/home'
  },
  {
    path: '/home',
    name: 'Home',
    component: Home
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  }
]

const router = new VueRouter({
	routes,
	mode:'history'
})
export default router