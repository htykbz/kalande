window.onload = function() {
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            userName: {
                message: '验证失败',
                validators: {
                    notEmpty: {
                        message: '账号不能为空'
                    }
                }
            },
            password: {
                message: '验证失败',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    }
                }
            },
        }
    });

    var app = angular.module("myApp", []);

    app.controller('loginController', function ($scope, $http, $location) {

        $scope.login = function () {
            var bootstrapValidator = $("form").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                var userName = $scope.userName;
                var password = $scope.password;

                $scope.formData = {'userName': userName, 'password': password};

                $http({
                    method: 'POST',
                    url: './userLogin',
                    data: $.param($scope.formData),
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).success(function (data) {
                    if (data.state == true) {
                       /* modals.correct('密码修改成功');*/
                        window.location.href = "./index";
                    } else {
                        modals.correct('账号密码错误');
                    }
                });
            }
        };
    })
};