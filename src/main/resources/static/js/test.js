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
    el: '#app',
    data: {
        message: 'test'
    },
    methods: {
        click: function () {
            var code = sha256(this.message);
            alert(code);
        }
    }
});

var test = new Vue({
    el: '#test',
    methods: {
        test: function () {
            window.alert("Error");
        }
    }
});

var msg = new Vue({
    el: '#message',
    data: {
        userMessage: {
            username: '',
            password: ''
        }
    }
});

var submit = new Vue({
    el: '#submit',
    methods: {
        submit: function () {
            var param = {
                request: JSON.stringify(msg.userMessage)
            };
            //发送 post 请求
            api.submit(param, function (result) {
                if (!result.success) {
                    this.$Message.info(result.message, 10);
                } else {
                    history.back();
                }
            }, function (result) {
            })
        }
    }
});