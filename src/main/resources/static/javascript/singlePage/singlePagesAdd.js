window.onload = function() {
    public.fileUpLoad("image", "image");
    var app = angular.module("myApp", []);

    app.controller('singlePageAdd', function ($scope, $http, $location) {

        //异步上传返回结果处理
        $("#image").on("fileuploaded", function (event, data, previewId, index) {
            var response = data.response;
            $("#imageUrl").val(response.fileName);
            $scope.imageUrl = response.fileName;
        });

        $scope.saveSinglePage = function () {
            $scope.content = CKEDITOR.instances.content.getData();
            var title = $scope.title;
            var summary = $scope.summary;
            var source = $scope.source;
            var author = $scope.author;
            var imageUrl = $scope.imageUrl;
            var singleType = 2;
            var content = $scope.content;

            $scope.formData = {'title': title,'summary': summary,'source': source,'author': author,'imageUrl': imageUrl
                ,'singleType': singleType,'content': content};

            $http({
                method: 'POST',
                url: './singlePageSave',
                data: $.param($scope.formData),
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function (data) {
                if(data.state == true){
                    window.location.href="./singlePages2";
                }else{
                    $scope.flag = true;
                    $scope.message = "新增失败";
                }
            });
        };
    })
};