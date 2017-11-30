window.urlConfig = urlConfigFn();
function urlConfigFn(){

	var frontrAction = "/font";
	var superviseAction = "/supervise";

	return {
	    htmlPage:{
	      /*  loginUrl: basePath + "/page/front/login.html",*/
	        pageUrl: basePath + "/javascript/template/page.html",
			/*frontHeaderHtml: basePath+"/page/template/front_header.html",
			superviseHeaderHtml:basePath+"/page/template/supervise_header.html",
	        footerHtml: basePath+"/page/template/footer.html",
	        loginUrl: basePath + "/page/front/login.html",
	        pageUrl: basePath + "/page/template/page.html",
	        frontHeaderHtml: basePath + "/page/template/front_header.html",
	        superviseHeaderHtml: basePath + "/page/template/supervise_header.html",
	        footerHtml: basePath + "/page/template/footer.html",*/
	    },
	    frontrAction:{
			loginUrl: basePath + frontrAction + "/login",
	    },
	    superviseAction:{

	    }
	}
};