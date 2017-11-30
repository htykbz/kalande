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

    app.controller('trainingsEdit', function ($scope, $http, $location) {
        if ($location.search().id) {
            $scope.id = $location.search().id;
        }

        $http.get("./trainingsDetail?id="+$scope.id).then(function (result) {
            $scope.categoryId = result.data.categoryId;
            $scope.title = result.data.title;
            $scope.price = result.data.price;
            $scope.source = result.data.source;
            $scope.author = result.data.author;
            $scope.viewNum = result.data.viewNum;
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
                    url: "./getTrainingsCateGories",
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
                    // the input tag has a value attribute preloaded that points to a preselected repository's id
                    // this function resolves that id attribute to an object that select2 can render
                    // using its formatResult renderer - that way the repository name is shown preselected
                    var id = result.data.categoryId;
                    if (id !== "") {
                        $.ajax("./getTrainingsCateGories?id=" + id, {
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
        $scope.editTrainings = function () {
            var bootstrapValidator = $("form").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                $scope.content = CKEDITOR.instances.content.getData();
                var id = $scope.id;
                var categoryId = $scope.categoryId;
                var title = $scope.title;
                var price = $scope.price;
                var source = $scope.source;
                var author = $scope.author;
                var viewNum = $scope.viewNum;
                var summary = $scope.summary;
                var imageUrl = $scope.imageUrl;
                var vedioUrl = $scope.vedioUrl;
                var content = $scope.content;


                $scope.formData = {
                    'id': id,
                    'categoryId': categoryId,
                    'title': title,
                    'price': price,
                    'source': source,
                    'summary': summary
                    ,
                    'imageUrl': imageUrl,
                    'vedioUrl': vedioUrl,
                    'content': content,
                    'author': author,
                    'viewNum': viewNum,
                };

                $http({
                    method: 'POST',
                    url: './trainingsEdit',
                    data: $.param($scope.formData),
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).success(function (data) {
                    if (data.state == true) {
                        window.location.href = "./Trainings";
                    } else {
                        $scope.flag = true;
                        $scope.message = "保存成功";
                    }
                });
            };
        }
    })
};