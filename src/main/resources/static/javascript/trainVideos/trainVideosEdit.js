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
    var app = angular.module("myApp", []);
    app.config(['$locationProvider', function($locationProvider) {
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });
    }]);

    app.controller('trainVideosEdit', function ($scope, $http, $location) {
        if ($location.search().id) {
            $scope.id = $location.search().id;
        }

        $http.get("./trainVideosDetail?id="+$scope.id).then(function (result) {
            $scope.categoryId = result.data.categoryId;
            $scope.name = result.data.name;
            $scope.price = result.data.price;
            $scope.mp4Url = result.data.mp4Url;
            $scope.coverImageUrl = result.data.coverImageUrl;
            $scope.viewNum = result.data.viewNum;
            $scope.sortOrder = result.data.sortOrder;
            $scope.summary = result.data.summary;
            $scope.imageUrl = result.data.imageUrl;
            $scope.vedioUrl = result.data.vedioUrl;
            $scope.id = result.data.id;
            $scope.orderBy = result.data.orderBy;
            public.fileUpLoad("image", "img",result.data.imageUrl);
            public.fileUpLoad("vedio", "vedio",result.data.vedioUrl);
            CKEDITOR.instances.content.setData(result.data.content);

            $("#categoryId").select2({
                multiple: false,
                placeholder: "请选择产品分类",
                language: "zh-CN",
                allowClear: true,
                ajax: {
                    type:'GET',
                    url: "./getTrainVideosCateGories",
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
                        $.ajax("./getTrainVideosCateGories?id=" + id, {
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
        $scope.editTrainVideos = function () {
            var bootstrapValidator = $("form").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                $scope.content = CKEDITOR.instances.content.getData();
                var id = $scope.id;
                var categoryId = $scope.categoryId;
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

                $scope.formData = {'id': id,'categoryId': categoryId, 'name': name, 'price': price, 'mp4Url': mp4Url,
                    'summary': summary, 'imageUrl': imageUrl, 'vedioUrl': vedioUrl, 'content': content, 'coverImageUrl': coverImageUrl,
                    'viewNum': viewNum,'sortOrder': sortOrder};

                $http({
                    method: 'POST',
                    url: './trainVideosEdit',
                    data: $.param($scope.formData),
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).success(function (data) {
                    if (data.state == true) {
                        window.location.href = "./trainVideos";
                    } else {
                        $scope.flag = true;
                        $scope.message = "保存成功";
                    }
                });
            };
        }
    })
};