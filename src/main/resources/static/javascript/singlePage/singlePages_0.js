window.onload = function() {
    var app = angular.module("myApp", []);
    /*app.config(['$locationProvider', function($locationProvider) {
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });
    }]);*/

    app.controller('customersCtrl', function ($scope, $http, $location) {
     /*   if ($location.search().singleType) {
            $scope.singleType = $location.search().singleType;
        }*/
        public.pageUtil($scope);

        var _get = function (page,size) {
            $http.get("./singlePageList?pageNum="+page+"&pageSize="+size+"&singleType=0").then(function (result) {
                $scope.dataList = result.data.list;
                $scope.maxCount = result.data.total;
                $scope.currPage = result.data.pageNum;
                $scope.maxPage =Math.ceil($scope.maxCount/$scope.pageSize);
                $scope.pageArr = public.getPageArr($scope.maxPage,$scope.currPage,5);
            });
        };

        //初始化第一页
        _get($scope.currPage,$scope.pageSize,function(){});

        $scope.getData = function(page){
            if (page == 0 || page == ($scope.maxPage+1)) {
                return;
            }
            _get(page,$scope.pageSize,function(){ });
        };

    })
};