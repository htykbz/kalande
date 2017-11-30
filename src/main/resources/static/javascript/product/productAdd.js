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
    $("#categoryId").select2({
        placeholder: "请选择产品分类",
        language: "zh-CN",//汉化
        allowClear: true,
        ajax: {
            type:'GET',
            url: "./getproductCateGories",
            dataType: 'json',
            data: function (params) {
                params.term = "";
                return {
                    id: params.term, // search term 请求参数 ， 请求框中输入的参数
                    page: params.page
                };
            },
            processResults: function (data) {
                return {
                    results: data
                };
            },
            cache: true
        },
    });
    public.fileUpLoad("image", "image");
/*    public.fileUpLoad("taoBaoQrcodeImage", "img");

    public.fileUpLoad("wechatQrcodeImage", "img");*/

    public.fileUpLoad("vedio", "video");
    var app = angular.module("myApp", []);

    app.controller('productAdd', function ($scope, $http, $location) {

        //异步上传返回结果处理
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

      /*  $("#taoBaoQrcodeImage").on("fileuploaded", function (event, data, previewId, index) {
            var response = data.response;
            $("#taoBaoQrcodeImageUrl").val(response.fileName);
            $scope.taoBaoQrcodeImageUrl = response.fileName;
        });

        $("#wechatQrcodeImage").on("fileuploaded", function (event, data, previewId, index) {
            var response = data.response;
            $("#wechatQrcodeImageUrl").val(response.fileName);
            $scope.wechatQrcodeImageUrl = response.fileName;
        });*/

        $scope.saveProduct = function () {
            var bootstrapValidator = $("form").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                $scope.content = CKEDITOR.instances.content.getData();
                var categoryId = $("#categoryId").select2("val");
                ;
                var title = $scope.title;
                var price = $scope.price;
                var saleNum = $scope.saleNum;
                var summary = $scope.summary;
                var imageUrl = $scope.imageUrl;
                var vedioUrl = $scope.vedioUrl;
                var content = $scope.content;


                $scope.formData = {
                    'categoryId': categoryId, 'title': title, 'price': price, 'saleNum': saleNum, 'summary': summary
                    , 'imageUrl': imageUrl, 'vedioUrl': vedioUrl, 'content': content
                };

                $http({
                    method: 'POST',
                    url: './productSave',
                    data: $.param($scope.formData),
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).success(function (data) {
                    if (data.state == true) {
                        window.location.href = "./product";
                    } else {
                        $scope.flag = true;
                        $scope.message = "保存失败";
                    }
                });
            }
        };
    })
};