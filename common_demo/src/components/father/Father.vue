<template>
    <div style="background-color: green">
        <p>这是父组件--</p>
        <input v-model="msg" />
        <Child :msg="this.msg" style="background-color: coral"></Child>
    </div>
</template>

<script>
    import Child from "../child/Child";

    export default {
        name: "Father",
        components: {
            Child
        },
        data() {
            return {
                msg:"这是father传递的值"
            }
        }
    }
</script>

<style scoped>

</style>