app.value("count",50);
app.constant("compName","Capgemini Consulting Services");

app.factory("myFactory",function(){
	//console.log("Factory:" +compName );
	return "Hello!";
	
});


app.service("myService",function(){
	
	this.qube=function(num){
	return num*num*num;
	}
	
	this.fullName=function(fName,lName){
		return fName+" " +lName;
	}
});



app.factory("myFactory",function(){
	
	return "Hello!";
	
});


app.controller("myCtrl",function($scope,count,myFactory,myService,compName){
	
	$scope.num=count+100;
	$scope.myVal=myService.qube(count);
	console.log(myFactory);
	$scope.myName=myService.fullName('tom','Jerry');
	console.log(compName);
	compName="TCS";
	console.log(compName);
	
	//console.log("Count:" + count);
	
});

/*app.service("myService",function(){
	this.fullName=function(fName,lName){
		var firstName=fName.charAt(0).toUpperCase()+fName.substr(1).toLowerCase();
		var lastName=lName.charAt(0).toUpperCase()+lName.substr(1).toLowerCase();
		
		return firstName +" " + lastName;
	}
});
*/

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





















