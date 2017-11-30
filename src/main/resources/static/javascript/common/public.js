
window.public = {
	// 版本号
	systemVersions:'V2.0.0',

	// 分页页码组件
	pageUtil: function($scope){

    	$scope.dataList = [];
		$scope.maxCount = 0;
		$scope.currPage = 1;
		$scope.maxPage =  1;
        $scope.pageSize =  10;
		$scope.pageArr = [1];
		$scope.pageHtml = urlConfig.htmlPage.pageUrl;
	},

    fileUpLoad: function(id,type,fileName){
		var file = [];
		file.push(fileName);
		var filetype = "";
		var priviewFileType = "";
		if(type == "image"){
            filetype = ["jpg", "png", "gif"];
            priviewFileType = 'image';
		}else{
            filetype = ["avi", "rmvb", "rm","asf", "divx", "mpg","mpeg", "mpe", "wmv","mp4", "mkv", "vob"];
            priviewFileType = 'video/mp4';
		}

        $("#"+id+"").fileinput({
            language: 'zh',
            uploadUrl: "./fileUpload",
            uploadAsync: true,
            allowedFileExtensions: filetype,
            dropZoneEnabled: false,
            resizePreference: 'height',
            maxFileCount: 1,
            overwriteInitial: false,
            enctype: 'multipart/form-data',
            autoReplace:true,
            initialPreview:file,
            initialPreviewConfig: [
                {key:1,showDelete: false,type: type,filetype:priviewFileType }
            ],
            initialPreviewFileType: 'image',
            initialPreviewAsData: true,
        });
    },



	// 细项得分筛选组件
	scoreFiltrateUtil:function($scope, count){

		$scope.filtrateTr = "score_filtrate.html";

		$scope.colCount = count;
		$scope.col1Text = "";
		$scope.col2Relation = "";		$scope.col2Num = "";		$scope.col2Order = 0;
		$scope.col3Relation = "";		$scope.col3Num = "";		$scope.col3Order = 0;
		$scope.col4Relation = "";		$scope.col4Num = "";		$scope.col4Order = 0;
		$scope.col5Relation = "";		$scope.col5Num = "";		$scope.col5Order = 0;
		$scope.col6Relation = "";		$scope.col6Num = "";		$scope.col6Order = 0;
		$scope.col7Relation = "";		$scope.col7Num = "";		$scope.col7Order = 0;
		$scope.col8Relation = "";		$scope.col8Num = "";		$scope.col8Order = 0;
		$scope.col9Relation = "";		$scope.col9Num = "";		$scope.col9Order = 0;
		$scope.col10Relation = "";	$scope.col10Num = "";		$scope.col10Order = 0;
		$scope.col11Relation = "";	$scope.col11Num = "";		$scope.col11Order = 0;
		$scope.col12Relation = "";	$scope.col12Num = "";		$scope.col12Order = 0;
		$scope.col13Relation = "";	$scope.col13Num = "";		$scope.col13Order = 0;

		$scope.selected = function(text, colNum){
			$scope["col"+colNum+"Relation"] = text;
		}
		$scope.order = function(colNum){
			$scope["col"+colNum+"Order"] = $scope["col"+colNum+"Order"]==0?1:($scope["col"+colNum+"Order"]==1?2:0);
		}
	},

	// ajax
	ajax:function(param,url,type,success,error){
		
		var errorMsg = "系统错误请重试！"
		var message_403 = "登录超时，请重新登录！";
		if (!success) {   success = function () { }; }
	    if (!error) {  error = function (errorMsg) {  alert(errorMsg)} }

	    $.ajax({
	        url:url , 
	        data: param,
	        type:type,
	        dataType:"json",
	        success:function(result){
	            if (result.success){
	                success(result.data);
	            }else if (result.errCode=='e403'){   
	                window.confirm(message_403);
	                location.href = urlConfig.htmlPage.loginUrl;
	            }else{
	                error(result);
	            }
	        },error: function(XMLHttpRequest, textStatus, errorThrown) {
	        	var errObj = { errMsg: XMLHttpRequest.status + errorMsg };
	            error(errObj);
	        }
	    });
	},

	// 格式化时间参数
	fomatParamDate:function(dateStr){
		
		if(dateStr != null && dateStr != ""){
			var date = new Date(dateStr);
			
			return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
		}else{
			return dateStr;
		}
	},
	
	// 获取页码数组
	getPageArr:function(maxPage, currPage, num){
		
		var arr = []
		if(maxPage <= num){
			for(var i=0; i < maxPage; i++){
				arr[i] = i+1;
			}
		}else if(currPage + num <= maxPage){
			for(var i=0; i < num; i++){
				arr[i] = currPage + i;
			}	
		}else{
			for(var i=0; i < num; i++){
				arr[i] = maxPage - num + i+1;
			}
		}
		
		return arr;
	},
	
	// 过滤页码
	filtrationPage:function(pageNum, maxPage){
		
		var num = 1;
		if(pageNum > 0 && pageNum <= maxPage){
			num = pageNum;
		}else if(pageNum > maxPage){
			num = maxPage;
		}
		return num;
	},

	// 获取URL参数
	getUrlParam: function(url) {
		var theRequest = new Object();   
		if (url.indexOf("?") != -1) {   
			var str = url.substr(1);   
			strs = str.split("&");   
			for(var i = 0; i < strs.length; i ++) {   
				theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
			}   
		}   
		return theRequest;   
	},

	// 获取年份列表
	getYearArr: function(beginYear) {
		if(!public.isNumber(beginYear)) beginYear = 2000;
		var date = new Date();
		var yearArr = [];
		for(; beginYear <= date.getFullYear(); beginYear++){
			yearArr.push(beginYear);
		}
		return yearArr;
	},

	// 获取当前年份
	getCurrYear: function(beginYear) {
		return new Date().getFullYear().toString();
	},

	// 判断是否为数字
	isNumber: function(number){
		return typeof number === 'number';
	}
};

