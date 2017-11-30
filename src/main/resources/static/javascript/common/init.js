/**
 * Created by Administrator on 2016/11/4.
 */

//系统公共配置
(function (){
    //系统跟路径
    window.basePath = getBasePath();
    var config = getConfig();
    // for(var i = 0; i < config.length; i++){
    //     createJS(config[i]);
    // }

    //JS加载
    function getConfig(){
        return config = [
            {src: window.basePath + '/bower_components/angular-1.5.8/angular.js'},
            {src: window.basePath + '/bower_components/angular-1.5.8/angular-route.js'},
            {src: window.basePath + '/bower_components/bootstrap/dist/js/bootstrap.min.js'},
            {src: window.basePath + '/bower_components/bootstrap-fileInput-4.3.2/js/plugins/canvas-to-blob.js'},
            {src: window.basePath + '/bower_components/bootstrap-fileInput-4.3.2/js/fileinput.js'},
            {src: window.basePath + '/bower_components/bootstrap-fileInput-4.3.2/js/locales/zh.js'},
            {src: window.basePath + '/javascript/common/public.js'},
            {src: window.basePath + '/javascript/common/urlConfig.js'}
        ];
    }
    function createJS(jsObj) {
        var node = document.createElement('script');
        node.setAttribute('type', jsObj.type || 'text/javascript');
        node.setAttribute('src', jsObj.src);
        //node.setAttribute('async', false);
        document.getElementsByTagName("head")[0].appendChild(node);
        return node;
    }

    function getBasePath(){
        var strFullPath = window.document.location.href;
        var strPath = window.document.location.pathname;
        var pos = strFullPath.indexOf(strPath);
        var basePath = strFullPath.substring(0,pos) + strPath.substring(0,strPath.substr(1).indexOf('/')+1)
        return basePath;
    }

})();
//angular初始化
function appInit(app) {
    app.controller("header", function ($scope, $rootScope,$http) {

        $scope.frontHeader = urlConfig.htmlPage.frontHeaderHtml;
        $scope.superviseHeader = urlConfig.htmlPage.superviseHeaderHtml;
//        $scope.username = localStorage.getItem("username")?localStorage.getItem("username"):"未知用户";
        $scope.userName = localStorage.getItem("userName")?localStorage.getItem("userName"):"未知用户";

        //注销
        $scope.closeUserFn = function(){
        	public.ajax({}, urlConfig.publicAction.logout, "POST",
        		function (data){
        			location.href = urlConfig.htmlPage.loginUrl;
        		},
        		function (result){
        			alert(result.errMsg);
        		}
        	);
        }

        //注销
        $scope.closeUserFn = function(){
            $http({
                method:"POST",
                url:"/admin/logout"
            }).success(function(data){
                if(data=="success"){
                    window.location.href="/";
                }else{
                    alert("系统错误请重试！");
                }
            })
        }

    });
    app.controller("footer", function ($scope) {

        $scope.footerHtml = urlConfig.htmlPage.footerHtml;
        $scope.versions = public.systemVersions;
    });
    return app;
}
