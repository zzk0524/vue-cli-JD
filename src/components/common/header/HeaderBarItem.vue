<template>
	<div class="header-bar-item">
		<slot></slot>
	</div>
</template>

<script>
	export default{
		name:"HeaderBarItem"
	}
</script>

<style scoped>
/*每个item*/
  .header-bar-item{
    
    text-align: center;
    height: 30px;
    font-size: 12px;
    line-height: 30px;
    margin-right: 15px;
    color: #999;
    border:1px solid transparent;
    padding: 0 7px 0 7px;
  }
</style>