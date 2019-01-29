/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

Vue.http.options.emulateJSON = true;
var api = {};
api.post = function (url, query, successFn, errorFn) {
    Vue.http.post(url, query)
        .then(function (res) {
            successFn(res.data);
        }, function () {
            errorFn();
        })
        .catch(function () {
        })
};
api.get = function (url, successFn, errorFn) {
    Vue.http.get(url)
        .then(function (res) {
            successFn(res.data);
        }, function () {
            errorFn();
        })
        .catch(function () {
        })
};

api.submit = function (param, successFn, errorFn) {
    api.post('/login/validate', param, successFn, errorFn)
};


const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/view/toIndex',
            name: 'index'
        }
    ]
});

var app = new Vue({
    el: '#userMsg',
    data: function () {
        return {
            message: {
                userName: '',
                passWord: ''
            }
        }
    },
    router: router,
    methods: {
        submit: function () {
            let userName = sha256(this.message.userName);
            let passWord = sha256(this.message.passWord);
            let userMsg = {
                userName: userName,
                passWord: passWord
            };
            var param = {
                request: JSON.stringify(userMsg)
            };
            api.submit(param, function (res) {
                var _this = this;
                if (res.result === true) {
                    window.location.href = "/view/toIndex";
                } else
                    alert("登录失败!" + res.errorMsg);
            })
        }
    }
});
