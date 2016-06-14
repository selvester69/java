var app=angular.module("myView",["ngRoute"]);

app.config(function($routeProvider){
	$routeProvider
	.when('/',{
		//template:"<h1>MainPage</h1>"
		templateUrl:'main.html',
		controller:'mainCtrl'
	})
	.when('/create',{
		//template:"<h1>Create Page</h1>"
		templateUrl:'create.html'
	})
	.when('/update',{
		//template:"<h1>Update Page</h1>"
		templateUrl:'update.html'
	})
	.when('/listAll',{
		//template:"<h1>Listall Page</h1>"
		templateUrl:'ListAll.html',
		controller:'custCtrl'
	})
	.when('/logout',{
		template:"<h1>LogOut Page</h1>"
	});
	
});

app.controller("mainCtrl",function($scope){
	$scope.msg="Welcome To MainPage";
});

app.controller("custCtrl",function($scope,$http){
	
	
	$http.get('http://localhost:8083/Day-June-13-AngularJS/pages/customer')
		.success(function(response){
			$scope.customers=response;
		})
		.error(function(errMsg){
			$scope.errmsg=errMsg;
		});
	
	
});

app.filter("custFilter",function(){
	return function(cname){
		
		var cname=cname.charAt(0).toUpperCase()+cname.substr(1).toLowerCase();
		
		return cname;
	};
});

