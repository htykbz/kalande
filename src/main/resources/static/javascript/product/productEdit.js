window.onload = function() {
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            categoryId: {
                message: '验证失败',
                validators: {
                    notEmpty: {
                        message: '请选择教学分类'
                    }
                }
            },
            price: {
                message: '验证失败',
                validators: {
                    notEmpty: {
                        message: '请输入价格'
                    }
                }
            },
            saleNum: {
                message: '验证失败',
                validators: {
                    notEmpty: {
                        message: '请输入销量'
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

    app.controller('productEdit', function ($scope, $http, $location) {
        if ($location.search().id) {
            $scope.productId = $location.search().id;
        }

        $http.get("./productDetail?id="+$scope.productId).then(function (result) {

            $scope.product = result.data;
            $scope.imageUrl = result.data.imageUrl;
            $scope.vedioUrl = result.data.vedioUrl;
            $scope.id = result.data.id;
            $scope.orderBy = result.data.orderBy;
            public.fileUpLoad("image", "image",result.data.imageUrl);
            public.fileUpLoad("vedio", "video",result.data.vedioUrl);
            CKEDITOR.instances.content.setData(result.data.content);

            $("#categoryId").select2({
                multiple: false,
                placeholder: "请选择产品分类",
                language: "zh-CN",
                allowClear: true,
                ajax: {
                    type:'GET',
                    url: "./getproductCateGories",
                    dataType: 'json',
                    data: function (params) {
                        params.term = "";
                        return {
                            id: params.term,
                            page: params.page
                        };
                    },
                    processResults: function (data) {
                        return {
                            results: data
                        };
                    },
                },
                initSelection: function(element, callback) {
                    var id = result.data.categoryId;
                    if (id !== "") {
                        $.ajax("./getproductCateGories?id=" + id, {
                            dataType: "json"
                        }).done(function(data) { callback(data); });
                    }
                },
            });

            $("#image").on("fileuploaded", function (event, data, previewId, index) {
                var response = data.response;
                $("#imageUrl").val(response.fileName);
                $scope.imageUrl = response.fileName;
            });

            $("#vedio").on("fileuploaded", function (event, data, previewId, index) {
                var response = data.response;
                $("#vedioUrl").val(response.fileName);
                $scope.vedioUrl = response.fileName;
            });
        });
        $scope.editProduct = function () {
            var bootstrapValidator = $("form").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                $scope.content = CKEDITOR.instances.content.getData();
                var id = $scope.id;
                var categoryId = $scope.product.categoryId;
                var title = $scope.product.title;
                var price = $scope.product.price;
                var saleNum = $scope.product.saleNum;
                var summary = $scope.product.summary;
                var imageUrl = $scope.imageUrl;
                var vedioUrl = $scope.vedioUrl;
                var content = $scope.content;
                var orderBy = $scope.orderBy;


                $scope.formData = {
                    'id': id,
                    'categoryId': categoryId,
                    'title': title,
                    'price': price,
                    'saleNum': saleNum,
                    'summary': summary
                    ,
                    'imageUrl': imageUrl,
                    'vedioUrl': vedioUrl,
                    'content': content,
                    "orderBy": orderBy
                };

                $http({
                    method: 'POST',
                    url: './productEdit',
                    data: $.param($scope.formData),
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).success(function (data) {
                    if (data.state == true) {
                        window.location.href = "./product";
                    } else {
                        $scope.flag = true;
                        $scope.message = "用户名或密码错误";
                    }
                });
            }
        };

    })
};