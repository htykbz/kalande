window.onload = function() {
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            categoryEnum: {
                message: '验证失败',
                validators: {
                    notEmpty: {
                        message: '请选择分类名称'
                    }
                }
            },
            orderBy: {
                message: '验证失败',
                validators: {
                    notEmpty: {
                        message: '请输入排序号'
                    }
                }
            },
            showIndex: {
                message: '验证失败',
                validators: {
                    notEmpty: {
                        message: '请选择是否显示'
                    }
                }
            },
        }
    });
    var app = angular.module("myApp", []);

    app.config(['$locationProvider', function($locationProvider) {
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });
    }]);

    app.controller('productCategoriesEdit', function ($scope, $http, $location) {
        $scope.categorys = [
            {category : "按功能分", id : 1},
            {category : "按应用分", id : 2}
        ];

        $scope.indexs = [
            {index : "是", id : true},
            {index : "否", id : false}
        ];

        if ($location.search().id) {
            $scope.id = $location.search().id;
        }

        $http.get("./categoriesDetail?id="+$scope.id).then(function (result) {

            $scope.name = result.data.name;
            $scope.imageUrl = result.data.imageUrl;
            $scope.showIndex = result.data.showIndex;
            $scope.id = result.data.id;
            $scope.orderBy = result.data.orderBy;
            $scope.categoryEnum = result.data.categoryEnum;
            public.fileUpLoad("image", "image",result.data.imageUrl);


        });

        //异步上传返回结果处理
        $("#image").on("fileuploaded", function (event, data, previewId, index) {
            var response = data.response;
            $("#imageUrl").val(response.fileName);
            $scope.imageUrl = response.fileName;
        });

        $scope.editCategories = function () {
            var bootstrapValidator = $("form").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                var id = $scope.id;
                var name = $scope.name;
                var orderBy = $scope.orderBy;
                var showIndex = $scope.showIndex;
                var imageUrl = $scope.imageUrl;
                var categoryEnum = $scope.categoryEnum;

                $scope.formData = {
                    'id': id,
                    'name': name,
                    'orderBy': orderBy,
                    'showIndex': showIndex,
                    'imageUrl': imageUrl,
                    'categoryEnum': categoryEnum
                };

                $http({
                    method: 'POST',
                    url: './productCategoriesEdit',
                    data: $.param($scope.formData),
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).success(function (data) {
                    if (data.state == true) {
                        window.location.href = "./productCategories";
                    } else {
                        $scope.flag = true;
                        $scope.message = "保存失败";
                    }
                });
            }
        };
    })
};