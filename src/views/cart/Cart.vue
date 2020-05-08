<template>
	<div></div>
</template>
<script>
	export default{
		name:"Cart",
		mounted(){
			console.log(this.$route.params.currentuser);
			console.log(this.$route.params.currentgood);
			console.log(this.$route.params.goodnum);
			
		}
	}
</script>
<style scoped></style>