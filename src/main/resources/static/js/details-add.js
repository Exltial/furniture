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

api.saveDetail = function (param, successFn, errorFn) {
    api.post('/pic/addSkuDetail', param, successFn, errorFn)
};


let app = new Vue({
    el: '#table',
    data: function () {
        return {
            message: {
                skuId: ''
            }
        }
    },
    methods: {
        save: function () {
            this.message.skuId = document.getElementById("skuId").innerText;
            let param = {
                request: JSON.stringify(this.message)
            };
            const uploadFlag = document.getElementById("uploadFlag").value;
            if (uploadFlag != 1) {
                alert("请上传图片")
            }
            else {
                api.saveDetail(param, function (res) {
                    if (res.result) {
                        alert("保存成功");
                        window.location.href = "/view/toPictureShow?skuId=" + document.getElementById("skuId").innerText;
                    } else {
                        alert("保存失败,e=" + res.errorMsg);
                    }
                })
            }
        }
    }
});