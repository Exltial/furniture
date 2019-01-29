/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/index.html',
            name: 'user'
        }
    ]
});

var app = new Vue({
    el: '#app',
    routes: router,
    methods: {
        click: function () {
            router.push({name: 'user'});
        }
    }
});