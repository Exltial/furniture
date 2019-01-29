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
            window.location.href = "/index.html";
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

var table = new Vue({
    el: '#table',
    data: function () {
        return {
            skuList: [{}]
        }
    },
    methods: {
        add: function () {
            if (this.skuList.size === 0) {
                this.skuList[0].id = '1';
                this.skuList[0].name = 'joy';
                this.skuList[0].id = '1';

            }
            this.skuList.push({
                id: '2',
                name: 'tony',
                url: 'file:///C:/Users/tanlei24/Desktop/cnaidc.png'
            })
        }
    }
});

var p = new Vue({
    el: '#p',
    data: function () {
        return {
            p: [{}]
        }
    },
    methods: {
        click: function () {
            let param = [{
                a: '1',
                b: 'tony'
            }, {
                a: '1',
                b: 'tony'
            }, {
                a: '1',
                b: 'tony'
            }];
            for (var i = 0; i < param.length; i++) {
                this.p.push(param[i]);
            }
        }
    }
});


let ul = new Vue({
    el: '#ul',
    data: function () {
        return {
            skuList: [{
                a: '1',
                b: '../static/temp/big/keting.jpg'
            }, {
                a: '2',
                b: '../static/temp/big/keting.jpg'
            }]
        }
    },
    methods: {
        click: function (param) {
            alert(param);
        }
    }
});

let apptest = new Vue({
    el: '#btnTest',
    methods: {
        click: function () {
            document.getElementById("uploadFlag").value = 0;
            alert(document.getElementById("uploadFlag").value);
        }
    }
});