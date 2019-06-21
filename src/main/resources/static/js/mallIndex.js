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

api.getSkudList = function (param, successFn, errorFn) {
    api.post('/sku/getList', param, successFn, errorFn)
};

let table = new Vue({
    el: '#table',
    data: function () {
        return {
            skuList: [{}]
        }
    },
    mounted: function () {
        this.getData();
    },
    methods: {
        getData: function () {
            let _this = this;
            api.getSkudList(null, function (res) {
                if (res.result) {
                    _this.skuList = res.data;
                }
            })
        }
    }
});
