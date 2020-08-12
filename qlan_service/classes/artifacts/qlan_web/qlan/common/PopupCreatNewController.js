/* Modal Controller */
MetronicApp.controller('PopupCreateNewCtrl', [
		'$scope',
		'data',
		'caller',
		'modalInstance',
		'windowId',
		'isCreateNew',
		'CommonService',
		'SearchService',
		'PopupConst',
		'RestEndpoint',
		'$localStorage',
		'$rootScope',
		function($scope, data, caller, modalInstance, windowId, isCreateNew,
				CommonService, SearchService, PopupConst, RestEndpoint,
				$localStorage, $rootScope) {
          
			$rootScope.flag=false;
			$scope.data = data;
			$scope.modalInstance = modalInstance;
			$scope.windowId = windowId;
			$scope.caller = caller;
			$scope.cancel = cancel;
			$scope.save = save;
			$scope.remove = remove;
			$scope.isCreateNew = isCreateNew;
			$scope.saveConfig = saveConfig;
			$scope.validatorOptions = kendoConfig.get('validatorOptions');

			function cancel() {
				CommonService.dismissPopup();
				// caller.cancel();
			}
			$scope.$watch(function() {
		        return $rootScope.popupOpen;
		    }, function(popupOpen) {
		    	if (popupOpen) {
		    		var arr=[];
		    		$("div").find("[kendo-window]").find('input, select, textarea').each(
						    function(index){  
						        if(!$(this).context.disabled && !$(this).context.readonly){
						        	arr.push($(this));
						        }
						    }
						);
		    		setTimeout(function(){arr[0].focus()},1000);
		    	}
		    }, true)
			
			
			function save() {
				if ($scope.validator.validate()) {
					
				caller.save($scope.data, $scope.isCreateNew);
				} else{
					var errIds=$.map($scope.validator._errors,function(value,index) {
						  return [index];
						});
					var errMsg=$.map($scope.validator._errors,function(value,index) {
						  return [value];
						});
					$("#"+errIds[0]).focus();	
					toastr.error(errMsg[0]);
				}
			}
			
			function saveConfig() {
				if ($scope.validator.validate()) {
				caller.saveConfig();
				}
			}
			
			function remove(){
				if ($scope.validator.validate()) {
					caller.remove($scope.data);
					}
			}

		} ]);