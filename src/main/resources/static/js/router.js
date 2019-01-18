/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */
let app = new Vue({
    el: '#app',
    methods: {
        click: function () {
            router.go({path: '/add'});
        }
    }
});

var App = Vue.extend();
var router = new VueRouter();
router.map({
    '/add': {
        component: app
    }
});
router.redirect({
    '*': '/'
});
router.start(App, '#app');