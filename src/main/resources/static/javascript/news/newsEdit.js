window.onload = function() {
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            title: {
                message: '验证失败',
                validators: {
                    notEmpty: {
                        message: '标题不能为空'
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

    app.controller('newsEdit', function ($scope, $http, $location) {
        if ($location.search().id) {
            $scope.productId = $location.search().id;
        }

        $http.get("./newsDetail?id="+$scope.productId).then(function (result) {
            $scope.title = result.data.title;
            $scope.summary = result.data.summary;
            $scope.source = result.data.source;
            $scope.author = result.data.author;
            $scope.isTop = result.data.isTop;
            $scope.isIndex = result.data.isIndex;
            $scope.imageUrl = result.data.imageUrl;
            $scope.id = result.data.id;
            public.fileUpLoad("image", "img",result.data.imageUrl);
            CKEDITOR.instances.content.setData(result.data.content);

            $("#image").on("fileuploaded", function (event, data, previewId, index) {
                var response = data.response;
                $("#imageUrl").val(response.fileName);
                $scope.imageUrl = response.fileName;
            });
        });
        $scope.editNews = function () {
            var bootstrapValidator = $("form").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                $scope.content = CKEDITOR.instances.content.getData();
                var id = $scope.id;
                var title = $scope.title;
                var summary = $scope.summary;
                var imageUrl = $scope.imageUrl;
                var source = $scope.source;
                var author = $scope.author;
                var isTop = $scope.isTop;
                var isIndex = $scope.isIndex;
                var content = $scope.content;


                $scope.formData = {
                    'id': id,
                    'title': title,
                    'summary': summary
                    ,
                    'imageUrl': imageUrl,
                    'source': source,
                    'content': content,
                    "author": author,
                    "isTop": isTop,
                    "isIndex": isIndex
                };

                $http({
                    method: 'POST',
                    url: './newsEdit',
                    data: $.param($scope.formData),
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).success(function (data) {
                    if (data.state == true) {
                        window.location.href = "./news";
                    } else {
                        $scope.flag = true;
                        $scope.message = "用户名或密码错误";
                    }
                });
            }
        };

    })
};