window.onload = function() {
    $("#categoryId").select2({
        placeholder: "请选择教学分类",
         language: "zh-CN",//汉化
        allowClear: true,
        ajax: {
            type:'GET',
            url: "./getTrainVideosCateGories",
            dataType: 'json',
            data: function (params) {
                params.term = "";
                return {
                    id: params.term, // search term 请求参数 ， 请求框中输入的参数
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
            viewNum: {
                message: '验证失败',
                validators: {
                    notEmpty: {
                        message: '请输入显示顺序'
                    }
                }
            },
        }
    });
    public.fileUpLoad("image", "img");
    public.fileUpLoad("vedio", "vedio");
    var app = angular.module("myApp", []);

    app.controller('trainVideosAdd', function ($scope, $http, $location) {

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
        $scope.saveTrainVideos = function () {
            var bootstrapValidator = $("form").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                $scope.content = CKEDITOR.instances.content.getData();
                var categoryId = $("#categoryId").select2("val");
                var name = $scope.name;
                var price = $scope.price;
                var mp4Url = $scope.mp4Url;
                var coverImageUrl = $scope.coverImageUrl;
                var sortOrder = $scope.sortOrder;
                var viewNum = $scope.viewNum;
                var summary = $scope.summary;
                var imageUrl = $scope.imageUrl;
                var vedioUrl = $scope.vedioUrl;
                var content = $scope.content;


                $scope.formData = {'categoryId': categoryId, 'name': name, 'price': price, 'mp4Url': mp4Url,
                    'summary': summary, 'imageUrl': imageUrl, 'vedioUrl': vedioUrl, 'content': content, 'coverImageUrl': coverImageUrl,
                    'viewNum': viewNum,'sortOrder': sortOrder};

                $http({
                    method: 'POST',
                    url: './trainVideosSave',
                    data: $.param($scope.formData),
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).success(function (data) {
                    if (data.state == true) {
                        window.location.href = "./trainVideos";
                    } else {
                        $scope.flag = true;
                        $scope.message = "保存失败";
                    }
                });
            };
        }
    })
};