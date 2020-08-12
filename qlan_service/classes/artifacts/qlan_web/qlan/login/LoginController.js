(function() {
	'use strict';
	var controllerId = 'LoginController';
	
	angular.module('MetronicApp').controller(controllerId, LoginController);
	
	function LoginController($scope, $rootScope, $timeout, gettextCatalog,
			kendoConfig,CommonService, PopupConst, Restangular, RestEndpoint,Constant,$cookies) {
		var vm = this;
        vm.userLogin={};
		vm.check=true;
        vm.validatorOptions = kendoConfig.get('validatorOptions');
        vm.login=CommonService.translate("login.btn.login");
        vm.reset=CommonService.translate("login.btn.reset");
        document.addEventListener('keyup', function(event) {
        	  if ($("#login-form").length>0 && event.code == 'Enter') {
        		  $("#loginForm").click();
        	  }
        	});
        
        if($cookies.get('remember')){
        	vm.userLogin.username=$cookies.get('username');
        	vm.userLogin.password=$cookies.get('password');
        }
        
        vm.submit=function(){
        	if(vm.validator.validate()){
        		if(vm.check){
        			$cookies.put('username', vm.userLogin.username);
        			$cookies.put('password', vm.userLogin.password);
        			$cookies.put('remember', true);
        		} else {
        			$cookies.put('username', "");
        			$cookies.put('password', "");
        			$cookies.put('remember', false);
        		}
        		startLoading();
        		CommonService.login(vm.userLogin).then(function(result){
        			stopLoading();
        			if(result && !result.error && result.errorCode===200001){
        				toastr.remove();
        				toastr.warning(result.message);
        				$rootScope.username=vm.userLogin.username
        				window.location="/qlan-web/#/changePassword"
        					return;
        			}
        			if(result && result.error){
        				toastr.remove();
        				toastr.error(result.message);
        				
        				return;
        			}
        			
        			$rootScope.userName="";
        			$rootScope.authenticatedUser=result.data;
        			$rootScope.$state.go("index");
        		},function(error){
        			stopLoading();
        			toastr.remove();
        			toastr.error(result.message);
        		});
        	}
        }
        vm.clear=function(){
        	vm.userLogin={};
        }
        vm.changePass=function(){
        	$rootScope.$state.go("changePass");
        }
        
      
	}
})();