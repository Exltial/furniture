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

var table = new Vue({
    el: '#table',
    data: function () {
        return {
            skuList: [{
                id: '1',
                name: 'joy',
                url: '../static/temp/200x150.jpg'
            }, {
                id: '2',
                name: 'tony',
                url: '../static/temp/200x150.jpg'
            }]
        }
    },
    beforeCreate: function () {
        api.
    }
});
