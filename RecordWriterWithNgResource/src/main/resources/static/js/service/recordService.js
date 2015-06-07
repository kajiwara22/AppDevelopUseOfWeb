(function(){
    'use strict';
    angular.module('rcw').factory('recordService',function($resource){
        var records = function(){
            return $resource('/api/records');
        };
        var record = function(){
            return $resource('/api/record/:id',{ 'id' : '@id' },{update:{method:'PUT'}});
        };
        var createRecord = function(){
            return $resource('/api/record/create');
        };
        return {
            'records'       :   records,
            'record'        :   record,
            'createRecord'  :   createRecord
        };
    });
}());