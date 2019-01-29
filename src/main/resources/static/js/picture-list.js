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

api.getList = function (param, successFn, errorFn) {
    api.post('/pic/list', param, successFn, errorFn)
};
api.deleteById = function (param, successFn, errorFn) {
    api.post('/pic/deleteSku', param, successFn, errorFn)
};

let table = new Vue({
    el: '#table',
    data: function () {
        return {
            skuList: [{}],
            pageNum: 1,
            hasNextPage: '',
            hasPreviousPage: ''
        }
    },
    mounted: function () {
        this.getData();
    },
    methods: {
        nextPage: function () {
            if (this.hasNextPage) {
                this.pageNum = this.pageNum + 1;
                this.getData();
            } else {
                alert("到底了");
            }
        },
        upPage: function () {
            if (this.hasPreviousPage) {
                this.pageNum = this.pageNum - 1;
                this.getData();
            } else {
                alert("到头了");
            }
        },
        getData: function () {
            let _this = this;
            let param = {
                pageNum: _this.pageNum
            };
            api.getList(param, function (res) {
                if (res.total != 0) {
                    _this.skuList = res.list;
                    _this.hasPreviousPage = res.hasPreviousPage;
                    _this.hasNextPage = res.hasNextPage;
                }
            })
        },
        picture_edit: function (name, url, param) {
            var index = layer.open({
                type: 2,
                title: name,
                content: url + "?skuId=" + param
            });
            layer.full(index);
        },
        picture_del: function (skuId) {
            layer.confirm('确认要删除吗？', function () {
                const param = {
                    skuId: skuId
                };
                api.deleteById(param, function (res) {
                    if (res.result) {
                        layer.msg('已删除!', {icon: 1, time: 1000});
                        window.location.href = "/view/toPictureList";
                    } else {
                        layer.msg('删除失败!' + res.errorMsg, {icon: 1, time: 1000});
                        window.location.href = "/view/toPictureList";
                    }
                })
            })
        }
    }
});
