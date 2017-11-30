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
                        message: '请填写菜单名称'
                    }
                }
            },
            url: {
                message: '验证失败',
                validators: {
                    notEmpty: {
                        message: '请填写url'
                    }
                },
            },
            orderBy: {
                message: '验证失败',
                validators: {
                    notEmpty: {
                        message: '请填写排序号'
                    }
                }
            },
        }
    });
    function valid() {
        var flag = false;
        var bootstrapValidator = $("form").data('bootstrapValidator');
        bootstrapValidator.validate();
        if (bootstrapValidator.isValid()){
            flag = true;
        }
        return flag;
    }
    var app = angular.module("myApp", []);
    app.controller('customersCtrl', function ($scope, $http) {

        var treeData = null;
        var nodeData = null;
        var btntype=null;

        var initTree = function (selectNodeId) {
            $http.get("./menuTreeData").then(function (result) {
                treeData = result.data;
                console.log(JSON.stringify(treeData));
                var treeView = $("#tree").treeview({
                    data: treeData,
                    showBorder: true,
                    expandIcon: "glyphicon glyphicon-stop",
                    collapseIcon: "glyphicon glyphicon-unchecked",
                    levels: 1,
                    onNodeSelected: function (event, data) {
                        console.log(data.id);
                        nodeData = data;
                        fillDictForm();
                        formReadonly();
                    }
                });
                if(treeData.length==0)
                    return;
                //默认选中第一个节点
                selectNodeId=selectNodeId||0;
                $("#tree").data('treeview').selectNode(selectNodeId);
                $("#tree").data('treeview').expandNode(selectNodeId);
                $("#tree").data('treeview').revealNode(selectNodeId);
            });
        };
        //初始化树
        initTree(0);

        fillDictForm = function(){
            $http.get("./getMenu?id="+nodeData.id).then(function (result) {
                $scope.id = result.data.id;
                $scope.pid = result.data.pid;
                $scope.title = result.data.title;
                $scope.url = result.data.url;
                $scope.summary = result.data.summary;
                $scope.orderBy = result.data.orderBy;
                if(nodeData.parentId == undefined){
                    $scope.parentName = "系统菜单"
                }else{
                    $scope.parentName = $('#tree').treeview('getParent', nodeData.nodeId).text;
                }
            })
        };

        $scope.addRoot = function () {
            btntype = "addRoot";
            formWritable(btntype);
            $scope.parentName ="系统菜单";
            $scope.pid = 0;
            $scope.title = "";
            $scope.url = "";
            $scope.orderBy = "";
            $scope.summary = "";
        };

        $scope.addMenu = function () {
            btntype = "add";
           // fillDictForm(nodeData);
            formWritable(btntype);
            $scope.parentName = nodeData.text;
            $scope.pid = nodeData.id;
            $scope.title = "";
            $scope.url = "";
            $scope.orderBy = "";
            $scope.summary = "";
        };

        $scope.editMenu = function () {
            btntype = "edit";
            fillDictForm(nodeData);
            formWritable(btntype);

        };

        $scope.deleteMenu = function () {
            btntype = "delete";
            fillDictForm(nodeData);
            formReadonly(btntype);
            $(".box-header button[data-btn-type='delete']").removeClass("btn-default").addClass("btn-primary");

            var id = $scope.id;
            $scope.formData = {'id': id};
            $http({
                method: 'POST',
                url: './menuDelete',
                data: $.param($scope.formData),
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function (data) {
                if(data.state == true){
                    var brothers=$("#tree").data("treeview").getSiblings(nodeData.nodeId);
                    if(brothers.length>0)
                        initTree(nodeData.nodeId-1);
                    else{
                        var parent=$("#tree").data("treeview").getParent(nodeData.nodeId);
                        initTree(parent?parent.nodeId:0);
                    }
                }else{
                    $scope.flag = true;
                    $scope.message = "保存失败";
                }
            });

        };

        $scope.saveMenu = function () {
            switch (btntype) {
                case 'add':
                    save('./menuSave');
                    break;
                case 'edit':
                    save('./menuEdit');
                    break;
                case 'addRoot':
                    save('./menuSave');
                    break;
            }
        };
        
        function save(addUrl) {
           if(!valid()){
               return;
           }
            var id = $scope.id;
            var pid = $scope.pid;
            var title = $scope.title;
            var summary = $scope.summary;
            var orderBy = $scope.orderBy;
            var url = $scope.url;

            $scope.formData = {'id': id,'pid': pid,'title': title,'summary': summary,'orderBy': orderBy,'url': url};
            $http({
                method: 'POST',
                url: addUrl,
                data: $.param($scope.formData),
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function (data) {
                if(data.state == true){
                    initTree(nodeData.nodeId);
                }else{
                    $scope.flag = true;
                    $scope.message = "保存失败";
                }
            });
        }

        //设置form为只读
        function formReadonly(){
            //所有文本框只读
            $("input,textarea").attr("readonly","readonly");
            //隐藏取消、保存按钮
            $("#function-form .box-footer").hide();
            //还原新增、编辑、删除按钮样式
            $(".box-header button").removeClass("btn-primary").addClass("btn-default");
            //选择图标按钮只读
            $("#selectIcon").addClass("disabled");
             //还原校验框
             if($("form").data('bootstrapValidator'))
                 $("form").data('bootstrapValidator').resetForm();
        }

        function formWritable(action){
            $("input,textarea").removeAttr("readonly");
            $("#function-form .box-footer").show();
            $(".box-header button").removeClass("btn-primary").addClass("btn-default");
            $("#selectIcon").removeClass("disabled");
            if(action)
                $(".box-header button[data-btn-type='"+action+"']").removeClass("btn-default").addClass("btn-primary");
        }

    });

};


