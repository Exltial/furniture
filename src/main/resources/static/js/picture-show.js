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

api.getData = function (param, successFn, errorFn) {
    api.post('/pic/getDetailPic', param, successFn, errorFn)
};


let app = new Vue({
    el: '#app',
    data: function () {
        return {
            skuId: '',
            picDetailList: [{}]
        }
    },
    mounted: function () {
        this.getSkuId();
        this.getData();
    },
    methods: {
        getSkuId: function () {
            this.skuId = document.getElementById("skuId").innerText;
        },
        getData: function () {
            let _this = this;
            let param = {
                skuId: _this.skuId
            };
            api.getData(param, function (res) {
                if (res.result) {
                    _this.picDetailList = res.data;
                } else {
                    alert(res.errorMsg);
                }
            })
        },
        editDetails: function (name, url, param) {
            layer.open({
                type: 2,
                title: name,
                content: url + "?skuId=" + param
            });
        }
    }
});