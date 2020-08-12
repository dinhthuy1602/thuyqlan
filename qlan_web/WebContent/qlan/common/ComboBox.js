MetronicApp.directive('comboBox',function ($rootScope,Restangular, CommonService,RestEndpoint) {
    return {   
    	
    	require: 'ngModel',
    	restrict:'AE',
        scope: {
        	modelOptions:'=',
        	ngModel:"@"
        },
        link: function ($scope, elem, attrs, ctrl) {
        	 setTimeout(function(){
        	  $('#' + attrs.id).kendoDropDownList({                        
                  dataTextField: $scope.modelOptions.dataTextField,
                  dataValueField:  $scope.modelOptions.dataValueField,
                  dataSource: {
				        serverFiltering: true,
				        transport: {
				            read: {
								type: "POST",
								url: RestEndpoint.BASE_SERVICE_URL + $scope.modelOptions.comboSourceLink,
								contentType: "application/json; charset=utf-8",
								dataType: "json"
				            },
							parameterMap: function(options, operation) {
								return JSON.stringify($scope.modelOptions.param);
							}
				        }
				    },	
                    ignoreCase: false,
	                valuePrimitive: true,
	                optionLabel: $scope.modelOptions.optionLabel
              });
        	  
        	 },10);
        }
    };
});