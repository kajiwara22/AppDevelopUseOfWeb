(function(){
    'use strict';
    angular.module('rcw').controller('indexController',function($scope,$location,recordService){

        /**
         * 指定した文字列の長さと現在の文字列長に応じてクラス名を返す
         * @param targetModel 対象文字列
         * @param targetLength 最大文字列長
         * @return targetModelの文字長に応じたクラス名
         */
        var lengthCheck = function(targetModel ,targetLength){
            if(angular.isUndefined(targetModel)){
                return 'text-muted';
            }else{
                var warningLength = parseInt(targetLength * 0.9);
                if(targetModel.length > targetLength){
                    return 'text-danger';
                }else if(targetModel.length > warningLength){
                    return 'text-warning';
                }else{
                    return 'text-muted';
                }
            }
        };

        var getRecord = function(){
            if($location.url().match(/ajaxIndex/)){
                $scope.records = recordService.records().query();
            }
        };

        var deleteRecord = function(id){
            recordService.record().delete({'id':id}).$promise.then(function(){
                initRecordForm();
            });
        };

        var selectEditTargetRecord = function(record){
            $scope.editRecord = true;
            $scope.editTargetRecord = record;
            $scope.record = record.record;
            $scope.title = record.title;
        };

        var initRecordForm = function(){
            $scope.editRecord = false;
            $scope.record = '';
            $scope.title = '';
            if(angular.isDefined($scope.form) && angular.isFunction($scope.form.$setPristine)){
                $scope.form.$setPristine();
            }
            $scope.editTargetRecord = null;
            getRecord();
        };

        var createRecord = function(){
            var record = {
                'title'     :   $scope.title,
                'record'    :   $scope.record
            };
            recordService.createRecord().save(record).$promise.then(function(){
                initRecordForm();
            });
        };

        var releaseTargetRecord = function(){
            $scope.editRecord = false;
            $scope.record = '';
            $scope.title = '';
            $scope.editTargetRecord = null;
            if(angular.isDefined($scope.form) && angular.isFunction($scope.form.$setPristine)){
                $scope.form.$setPristine();
            }
        };

        var updateRecord = function(){
            $scope.editTargetRecord.record = $scope.record;
            $scope.editTargetRecord.title = $scope.title;
            recordService.record().update($scope.editTargetRecord).$promise.then(function(){
                initRecordForm();
            });
        };

        $scope.lengthCheck = lengthCheck;
        $scope.deleteRecord  = deleteRecord;
        $scope.createRecord = createRecord;
        $scope.selectEditTargetRecord = selectEditTargetRecord;
        $scope.updateRecord = updateRecord;
        $scope.releaseTargetRecord = releaseTargetRecord;
        initRecordForm();

    });
}());
