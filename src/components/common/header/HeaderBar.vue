<template>
	<div id="headerBar">
		<slot></slot>
	</div>
</template>

<script>
	export default{
		name:"HeaderBar"
	}
</script>

<style scoped>
	#headerBar{
		display: flex;
		width: 100%;
		background-color: rgb(227,228,229);
		box-shadow: 0 -3px 1px rgba(100,100,100,.2);
		border-bottom: rgb(221,221,221) solid 1px;
	}	
</style>
