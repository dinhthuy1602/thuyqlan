(function() {
	'use strict';
	var controllerId = 'ChangePasswordController';
	
	angular.module('MetronicApp').controller(controllerId, ChangePasswordController);
	
	function ChangePasswordController($scope, $rootScope, $timeout, gettextCatalog,
			kendoConfig,CommonService, PopupConst, Restangular, RestEndpoint,Constant,$cookies) {
		var vm = this;
        vm.userLogin={};
        vm.validatorOptions = kendoConfig.get('validatorOptions');
        
        
        vm.userLogin.username= $rootScope.username;
        vm.clear=function(){
        	vm.userLogin={};
        }
        
        vm.changePassSubmit=function(){
        	if(vm.validator.validate()){
        		startLoading();
        		CommonService.changePass(vm.userLogin).then(function(result){
        			stopLoading();
        			if(result && result.error){
        				toastr.error(result.message);
        				return;
        			}
        			toastr.success(CommonService.translate("message.success"));
        			$rootScope.$state.go("login");
        		},function(err) {
        			stopLoading();
        			toastr.error(CommonService.translate("message.error"));
        		});
        	}
        }
	}
})();