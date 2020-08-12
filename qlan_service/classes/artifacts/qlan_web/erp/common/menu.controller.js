(function() {
	'use strict';

	var controllerId = 'MenuController';

	angular.module('MetronicApp').controller(controllerId, MenuController);

	/* @ngInject */
	function MenuController($scope, $rootScope, Constant, $http,Restangular,CommonService) {
		var vm = this;
		$scope.Constant = Constant;
		
		$scope.$watch(function() {
	         return $rootScope.authenticatedUser;
	    },  function(casUser){
	    	if(casUser==null){
	    		return ;
	    	}
			console.log(casUser);
			vm.menuObjects=casUser.listObject;
			
		//	Constant.setUser(user);			
		})


		vm.goTo = goTo;
		
		/*
		 * get menu text - neu vsa tra ve null thi
		 */
		vm.getMenuText=function(obj){
            try {
                var template = Constant.getTemplateUrl(obj.objectUrl);
                if(template==null){
        			return obj.objectName  + CommonService.translate("undeploy");
                }
                return template.title;
            }catch(err){
				console.debug(err);
                return "N/A";
            }
        }
		
		/* Handle action client on a menu item */
		function goTo(menuKey) {
			var template = Constant.getTemplateUrl(menuKey);
			// setArParams(menuKey);
			// setIdCheckbox(menuKey);
			// setApParams(menuKey);
			
			console.debug("postal", postal);
			postal.publish({
				channel : "Tab",
				topic   : "open",
				data    : template
			});
		}
//		vm.activeHomePage=activeHomePage;
//		function activeHomePage() {
//			
//			// setArParams(menuKey);
//			// setIdCheckbox(menuKey);
//			// setApParams(menuKey);
//			
//			
//			postal.publish({
//				channel : "Tab",
//				topic   : "active"
//				
//			});
//		}
		
	}
})();