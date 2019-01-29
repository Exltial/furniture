/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

var table = new Vue({
    el: '#table',
    data: function () {
        return {
            skuList: [{
                id: '1',
                price: '2',
                skuUrl: '../static/temp/200x150.jpg',
                skuName: '1',
                skuDescr: 'aa',
                skuType: '4',
                skuSize: '5',
                createTime: 's',
                status: 'd',
                skuId: 'a'
            }, {
                id: '1',
                price: '2',
                skuUrl: '../static/temp/200x150.jpg',
                skuName: '1',
                skuDescr: 'aa',
                skuType: '4',
                skuSize: '5',
                createTime: 's',
                status: 'd',
                skuId: 'b'
            }, {
                id: '1',
                price: '2',
                skuUrl: '../static/temp/200x150.jpg',
                skuName: '1',
                skuDescr: 'aa',
                skuType: '4',
                skuSize: '5',
                createTime: 's',
                status: 'd',
                skuId: 'c'
            }]
        }
    },
    methods: {
        picture_edit: function (name, url, param) {
            var index = layer.open({
                type: 2,
                title: name,
                content: url + "?skuId=" + param
            });
            layer.full(index);
        }
    }
});