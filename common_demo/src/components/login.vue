<template>
    <div>
        login page----{{this.$route.query.aa}}
<hr>
        <div v-text="this.$route.query.aa.length>4?this.$route.query.aa:'试试'"></div>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data(){
            return{
            }
        },mounted() {
        }
    }
</script>

<style scoped>

</style>