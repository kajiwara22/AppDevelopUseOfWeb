(function(){
    'use strict';
    angular.module('rcw',['ngResource','n3-pie-chart']).config(function($locationProvider){
        $locationProvider.html5Mode(true);
    });
}());
