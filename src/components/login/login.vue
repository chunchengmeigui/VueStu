<!-- eslint-disable -->
<template>
    <div>
        <Row>
            <i-col span="24">
                <Card style="">
                    <p slot="title">登录</p>
                    <Form ref="formInline" :model="formInline" :rules="ruleInline">
                        <FormItem prop="user">
                            <label>
                                <Input type="text" v-model="formInline.user" placeholder="Username">
                                    <Icon type="ios-person-outline" slot="prepend"></Icon>
                                </Input>
                            </label>
                        </FormItem>

                        <FormItem prop="password">
                            <Input type="password" v-model="formInline.password" placeholder="Password">
                                <Icon type="ios-lock-outline" slot="prepend"></Icon>
                            </Input>
                        </FormItem>
                        <FormItem prop="code">
                            <Row>
                                <i-col span="12">
                                    <Input type="text" v-model="formInline.code" placeholder="code"
                                           style="width: 200px;"></Input>
                                </i-col>
                                <i-col span="12">
                                    <img  src="../../static/img/code.png"/>
                                </i-col>
                            </Row>
                        </FormItem>
                        <FormItem>
                            <Button type="primary" @click="handleSubmit('formInline')">登录</Button>
                        </FormItem>
                    </Form>
                </Card>
            </i-col>
        </Row>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                formInline: {
                    user: 'admin',
                    password: '123',
                    code: "1"
                },
                ruleInline: {
                    user: [
                        {required: true, message: '账号不能为空', trigger: 'blur'}
                    ],
                    code: [
                        {required: true, message: '验证码不能为空', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '密码不能为空', trigger: 'blur'},
                        {
                            type: 'string',
                            min: 3,
                            message: 'The password length cannot be less than 3 bits',
                            trigger: 'blur'
                        }
                    ]
                }
            }
        },
        methods: {
            handleSubmit(name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        if (this.formInline.user === "admin" && this.formInline.password === "123") {
                            this.$router.push({name: 'Main'});
                        }else {
                            this.$Message.error('账号或密码错误!');
                        }
                    }
                    else {
                        this.$Message.error('必填项不能为空!');
                    }
                })
            },
            toXxxRoute: function(){
                this.$router.push('/main')
            }
        }
    }
</script>
