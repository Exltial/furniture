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
        }
    }
});
