window.onload = function() {
    var app = angular.module("myApp", []);
/*    app.config(['$stateProvider',function($stateProvider,$urlRouterProvider){
        $urlRouterProvider.html5Mode(true);
        $stateProvider
            .state('edit',{
                url: '/edit',
                templateUrl : './productToEdit',
            });
    }]);*/
    app.controller('customersCtrl', function ($scope, $http) {
        public.pageUtil($scope);

        var _get = function (page,size) {
            $http.get("./List?pageNum="+page+"&pageSize="+size+"").then(function (result) {
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
        $scope.toAddProduct = function() {
             window.location = "./productToAdd";
           /* $state.go('./productToAdd')*/
        };
        $scope.deleteProduct = function(id) {
            $scope.formData = {'id': id};
            $http({
                method: 'POST',
                url: './productDelete',
                data:  $.param($scope.formData),
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function (data) {
                if(data.state == true){
                    _get($scope.currPage,$scope.pageSize,function(){ });
                }else{
                    $scope.flag = true;
                    $scope.message = "删除失败";
                }
            });
        };
    });
};