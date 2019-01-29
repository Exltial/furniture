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

api.update = function (param, successFn, errorFn) {
    api.post('/pic/updateSku', param, successFn, errorFn)
};
api.updateWithFile = function (param, successFn, errorFn) {
    api.post('/pic/updateSku?uploadFlag=1', param, successFn, errorFn)
};
api.getDataBySkuId = function (param, successFn, errorFn) {
    api.post('/pic/getSkuById', param, successFn, errorFn)
};

let app = new Vue({
    el: '#table',
    data: function () {
        return {
            message: {
                skuName: '',
                price: '',
                skuType: '',
                skuSize: '',
                skuDescr: '',
                skuId: ''
            }
        }
    },
    methods: {
        save: function () {
            let param = {
                request: JSON.stringify(this.message)
            };
            const uploadFlag = document.getElementById("uploadFlag").value;
            if (this.message.skuName == '') {
                alert("请填写名称")
            }
            else if (this.message.price == '') {
                alert("请填写价格")
            }
            else if (this.message.skuType == '') {
                alert("请填写类型")
            }
            else if (this.message.skuSize == '') {
                alert("请填写尺寸")
            }
            else {
                if (uploadFlag == 1) {
                    api.updateWithFile(param, function (res) {
                        if (res.result) {
                            alert("保存成功");
                            window.location.href = "/view/toPictureList";
                        } else {
                            alert("保存失败,e=" + res.errorMsg);
                        }
                    })
                } else {
                    api.update(param, function (res) {
                        if (res.result) {
                            alert("保存成功");
                            window.location.href = "/view/toPictureList";
                        } else {
                            alert("保存失败,e=" + res.errorMsg);
                        }
                    })
                }

            }
        },
        getDataBySkuId: function (skuId) {
            let _this = this;
            const param = {
                skuId: skuId
            };
            api.getDataBySkuId(param, function (res) {
                if (res.result) {
                    _this.message = res.data;
                }
            })
        }
    },
    mounted: function () {
        const skuId = document.getElementById("skuId").innerText;
        this.message.skuId = skuId;
        this.getDataBySkuId(skuId);
    }
});