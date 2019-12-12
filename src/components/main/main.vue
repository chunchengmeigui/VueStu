<!-- eslint-disable -->
<template>
    <div :title="msg">
        <div v-for="item in todos">
            {{item.text}}
        </div>
        {{inputMsg}}：
        <i-input icon="ios-clock-outline" placeholder="请输入..." style="width: 300px" v-model="inputMsg"></i-input>
        <a :href="href">百度</a>
        <br>
        <div>
            <i-button type="primary" @click="modal1 = true">显示对话框{{modal1}}</i-button>
            <Modal v-model="modal1" title="普通的Modal对话框标题" @on-ok="ok" @on-cancel="cancel" :mask-closable="false">
                <p>对话框内容</p>
                <p>对话框内容</p>
                <p>对话框内容</p>
            </Modal>
        </div>
        <div style="margin-top: 30px">
            <Steps :current="current" status="error">
                <Step title="已完成" content="这里是该步骤的描述信息"></Step>
                <Step title="进行中" content="这里是该步骤的描述信息"></Step>
                <Step title="待进行" content="这里是该步骤的描述信息"></Step>
                <Step title="待进行" content="这里是该步骤的描述信息"></Step>
            </Steps>
            <i-button v-on:click="currNum()">下一步</i-button>
        </div>
        <hr/>
        <div style="display: flex;justify-content: space-between">
            <div style="background-color: white;height: 30px">
                合同列表
            </div>
            <div>
                <i-button>查</i-button>
            </div>
        </div>
        <div class="ivu-table">
            <i-table height="400" :columns="tabletitle" :data="data2"></i-table>
        </div>

    </div>
</template>

<script>
    export default {
        components: {},
        data() {
            return {
                msg: "鼠标经过显示",
                todos: [
                    {text: '学习 JavaScript'},
                    {text: '学习 Vue'},
                    {text: '整个牛项目'}
                ],
                inputMsg: '双向绑定',
                href: 'http://www.baidu.com',
                modal1: false,
                current: 0,
                formInline: {
                    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqeC5jb20iLCJ1c2VyR2lkIjoiYTJiOTYzNzk2MThjNGNiYWJhMTFjNjQ0NjMwZmZhZjQiLCJpYXQiOjE1NzYxMzEwMDgsImV4cCI6MTU3NjMwNjIzN30.nJWr2PgMls-iY23q9mudLhdSpkxFBa0KGZzw2JBOBOw",
                    "contractSpecies": 1
                },
                tabletitle: [
                    {
                        title: 'id',
                        key: 'contractId'
                    },
                    {
                        title: '合同名称',
                        key: 'contractNo'
                    },
                    {
                        title: '合同类型',
                        key: 'contractTypeTxt'
                    },
                    {
                        title: '状态',
                        key: 'contractStatusTxt'
                    }
                ],
                data2: []
            };
        },
        beforeCreate() {
            console.log("初始化之前")
        },
        created() {
            this.tableInit();

            console.log('初始化之后')
        }, beforeUpdate() {
            console.log("更新-重新渲染")
        },
        methods: {
            currNum() {
                if (this.current === 4) {
                    this.current = 0;
                } else {
                    this.current += 1;
                }
            },
            ok() {
                this.$Message.info('点击了确定');
            },
            cancel() {
                this.$Message.info('点击了取消');
            },
            tableInit() {
                this.$api.post('http://127.0.0.1:8088/api/admin/v1/contractInfo/getPageList', this.formInline, r => {
                    // window.console.log(r.data);
                    if (r.code == "00") {
                    }
                });
            }
        }
    }
</script>

<style scoped>
    div {
        /*border: 1px seagreen solid;*/
    }
</style>
