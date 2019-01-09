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

var app = new Vue({
    el: '#userMsg',
    data: {
        message: {
            userName: '',
            passWord: ''
        }
    },
    methods: {
        submit: function () {
            this.message.userName = sha256(this.message.userName);
            this.message.passWord = sha256(this.message.passWord);
            var param = {
                request: JSON.stringify(this.message)
            };
            api.submit(param, function (res) {
                if (res.result === true) {
                    window.location.href = "/view/toIndex"
                } else
                    alert("登录失败!" + res.errorMsg);
            })
        }
    }
});
