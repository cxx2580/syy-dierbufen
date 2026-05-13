import Vue from 'vue'
import VueRouter from 'vue-router'
import Customer from '../views/Customer.vue'
import Product from '../views/Product.vue'
import SalesOrder from '../views/SalesOrder.vue'
import Production from '../views/Production.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/customer'
  },
  {
    path: '/customer',
    name: 'Customer',
    component: Customer
  },
  {
    path: '/product',
    name: 'Product',
    component: Product
  },
  {
    path: '/sales-order',
    name: 'SalesOrder',
    component: SalesOrder
  },
  {
    path: '/production',
    name: 'Production',
    component: Production
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
