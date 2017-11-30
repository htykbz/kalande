window.onload = function() {

    var app = angular.module("myApp", []);
    app.config(['$locationProvider', function($locationProvider) {
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });
    }]);

    app.controller('singlePageEdit', function ($scope, $http, $location) {
        if ($location.search().id) {
            $scope.id = $location.search().id;
        }

        $http.get("./singlePageDetail?id="+$scope.id).then(function (result) {

            $scope.title = result.data.title;
            $scope.summary = result.data.summary;
            $scope.imageUrl = result.data.imageUrl;
            $scope.id = result.data.id;
            $scope.singleType = result.data.singleType;
            $scope.source = result.data.source;
            $scope.author = result.data.author;
            $scope.isDeleted = result.data.isDeleted;
            $scope.createTime = result.data.createTime;
            public.fileUpLoad("image", "image",result.data.imageUrl);
            CKEDITOR.instances.content.setData(result.data.content);

            $("#image").on("fileuploaded", function (event, data, previewId, index) {
                var response = data.response;
                $("#imageUrl").val(response.fileName);
                $scope.imageUrl = response.fileName;
            });

        });

        $scope.editSinglePage = function () {
            $scope.content = CKEDITOR.instances.content.getData();
            var id = $scope.id;
            var title = $scope.title;
            var singleType = $scope.singleType;
            var summary = $scope.summary;
            var imageUrl = $scope.imageUrl;
            var source = $scope.source;
            var author = $scope.author;
            var content = $scope.content;

            $scope.formData = {'id': id,'singleType': singleType,'title': title,'source': source,'author': author,'summary': summary
                ,'imageUrl': imageUrl,'content': content};

            $http({
                method: 'POST',
                url: './singlePageEdit',
                data: $.param($scope.formData),
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function (data) {
                if(data.state == true){
                    if(singleType == 4) {
                        window.location.href = "./singlePages";
                    }else{
                        window.location.href = "./singlePages0";
                    }
                }else{
                    $scope.flag = true;
                    $scope.message = "修改失败";
                }
            });
        };

    })
};