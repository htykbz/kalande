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

    public.fileUpLoad("image", "img");

    var app = angular.module("myApp", []);

    app.controller('productAdd', function ($scope, $http, $location) {

        //异步上传返回结果处理
        $("#image").on("fileuploaded", function (event, data, previewId, index) {
            var response = data.response;
            $("#imageUrl").val(response.fileName);
            $scope.imageUrl = response.fileName;
        });

        $scope.saveNews = function () {
            var bootstrapValidator = $("form").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                $scope.content = CKEDITOR.instances.content.getData();
                var title = $scope.title;
                var summary = $scope.summary;
                var imageUrl = $scope.imageUrl;
                var source = $scope.source;
                var author = $scope.author;
                var isTop = null;
                if($scope.isTop != undefined) {
                    isTop = $scope.isTop;
                }else{
                    isTop = false;
                }
                var isIndex = null;
                if($scope.isTop != undefined) {
                    isIndex = $scope.isIndex;
                }else{
                    isIndex = false;
                }
                var content = $scope.content;

                $scope.formData = {
                    'title': title, 'summary': summary, 'imageUrl': imageUrl,
                    'content': content, 'source': source, 'isTop': isTop, 'isIndex': isIndex, 'author': author
                };

                $http({
                    method: 'POST',
                    url: './newsSave',
                    data: $.param($scope.formData),
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).success(function (data) {
                    if (data.state == true) {
                       /* modals.correct('密码修改成功');*/
                        window.location.href = "./news";
                    } else {
                        $scope.flag = true;
                        $scope.message = "保存失败";
                    }
                });
            };
        }
    })
};