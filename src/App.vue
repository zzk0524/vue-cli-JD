<template>
  <div id="app">
    <main-header-Bar></main-header-Bar>
    <main-header></main-header>
    <main-banner></main-banner>
  </div>
</template>

<script>
/*页面最上部的导航栏*/
import MainHeaderBar from 'components/content/mainHeader/MainHeaderBar.vue';
/*头部*/
import MainHeader from 'components/content/mainHeader/MainHeader.vue';
/*banner*/
import MainBanner from 'components/content/mainBanner/MainBanner.vue';

export default {
  name: 'App',
  components: {
    MainHeaderBar,
    MainHeader,
    MainBanner
  }
}
</script>

<style>
/*导入最基础的样式*/
	@import "assets/css/base.css";

</style>
