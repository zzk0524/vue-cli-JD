import Vue from 'vue'
import VueRouter from 'vue-router'
const Register = () => import('../views/register/Register.vue')
const Home = () => import('../views/home/Home.vue')
const Login = () => import('../views/login/Login.vue')
const Detail = () => import('../views/detail/Detail.vue')
const Cart = () => import('../views/cart/Cart.vue')
const User = () => import('../views/user/User.vue')
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
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/detail',
    name: 'Detail',
    component: Detail
  },
  {
  	path: '/cart',
    name: 'Cart',
    component: Cart
  },
  {
    path: '/user',
    name: 'User',
    component: User
  }
]

const router = new VueRouter({
	routes,
	mode:'history'
})
export default router