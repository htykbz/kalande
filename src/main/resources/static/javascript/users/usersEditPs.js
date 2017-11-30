window.onload = function() {
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            password: {
                message: '密码无效',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: '密码长度必须在6到30之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: 'The username can only consist of alphabetical, number, dot and underscore'
                    }
                }
            },
            repassword: {
                message: '密码无效',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: '密码长度必须在6到30之间'
                    },
                    identical: {//相同
                        field: 'password',
                        message: '两次密码不一致'
                    },
                    regexp: {//匹配规则
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: 'The username can only consist of alphabetical, number, dot and underscore'
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

    app.controller('usersEditPs', function ($scope, $http, $location) {
        if ($location.search().id) {
            $scope.id = $location.search().id;
        }

        $http.get("./usersDetail?id="+$scope.id).then(function (result) {
            $scope.userName = result.data.userName;
            $scope.oldPwd = result.data.password;
            $scope.userId = result.data.userId;
        });
        $scope.editPwd = function () {
            var bootstrapValidator = $("form").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                var userId = $scope.userId;
                var password = $scope.password;

                $scope.formData = {'userId': userId, 'password': password,}

                $http({
                    method: 'POST',
                    url: './usersEditPs',
                    data: $.param($scope.formData),
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).success(function (data) {
                    if (data.state == true) {
                        modals.correct('密码修改成功');
                    } else {
                        modals.error('密码修改失败');
                    }
                });
            }
        };

    })
};