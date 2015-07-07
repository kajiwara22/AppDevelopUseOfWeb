(function() {
    'use strict';
    angular.module('rcw').controller('d3SampleController', function ($scope) {

        $scope.winValues = [];
        $scope.win= 0;
        var init = function(){
            for (var i=0 ; i<=100 ; i++){
                $scope.winValues.push(i);
            }
        };

        $scope.options = {thickness: 10, mode: 'gauge', total: 100};
        $scope.$watch('win',function(newValue,oldValue){
                $scope.date = [];
                $scope.data = [
                    {label: 'CPU', value: newValue, color: '#d62728', suffix: '%'}
                ];
        });
        $scope.data = [
            {label: 'CPU', value: $scope.win, color: '#d62728', suffix: '%'}
        ];

        init();

    });
}());

