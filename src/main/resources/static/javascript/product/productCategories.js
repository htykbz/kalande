window.onload = function() {
    var app = angular.module("myApp", []);

/*    app.config(['$routeProvider',function($routeProvider){
        $routeProvider.when('/edit/:id',{
            templateUrl:'./productToEdit',
            controller:'productEdit'
        })
    }]);*/

    app.controller('customersCtrl', function ($scope, $http) {
        public.pageUtil($scope);

        var _get = function (page,size) {
            $http.get("./productCategoriesList?pageNum="+page+"&pageSize="+size+"").then(function (result) {
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

        $scope.toAddProductCategories = function() {
             window.location = "./productCategoriesToAdd";
        };

        $scope.deleteCategories = function(id) {
            $scope.formData = {'id': id};
            $http({
                method: 'POST',
                url: './productCategoriesDelete',
                data:  $.param($scope.formData),
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function (data) {
                if(data.state == true){
                    window.location.href="./productCategories";
                }else{
                    $scope.flag = true;
                    $scope.message = "删除失败";
                }
            });
        };
    })
};