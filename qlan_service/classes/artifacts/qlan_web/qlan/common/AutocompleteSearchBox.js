angular.module('MetronicApp').directive('autoSearch', function ($rootScope,RestEndpoint, CommonService, gettextCatalog, $http) {
	var tempSelectValue = null;
    var tempSelectName = null;
	var selectionProcessed = false;
    var searchAutocompleteMinLength = 1;
    return {
	    restrict: 'AE',
	    scope: {
	        modelLabel: "@",
	        modelId: '=',
			modelIdd: '=',
	        modelName: '=',
	        caller: '=',
			modelDisabled:'=',
	        req:"@",
	        msg:"@",
	        iddiv:"@",
	        idlable:"@",
	        disabled:'=',
	        searchtype:"=", 
	        popupId: "=",
	        popupType: '=',
	        popupSourceLink: '=',
	        headerTemplate:'=',
	        templateAuto:'=',
	        page:'=',
	        pageSize:'=',
	        templateUrl:'=',
	        eventchange: "@",
	        change:"@",
	        comboId: "@",
	        comboSourceLink: "@",
	        comboName: "@",
	        comboValue: "@",
	        comboCode: "@",
			comboSearch: '=',
			comboGrid: '=',
	      	eventClick: '&',
	      	eventBlur: '&',
	      	eventChange: '&',
	      	eventCopy: '&',
	      	eventCut: '&',
	      	eventDbllick: '&',
	      	eventFocus: '&',
	      	eventKeydown: '&',
	      	eventKeypress: '&',
	      	eventKeyup: '&',
	      	eventMousedown: '&',
	      	eventMouseenter: '&',
	      	eventMouseleave: '&',
	      	eventMousemove: '&',
	      	eventMouseover: '&',
	      	eventMouseup: '&',
	      	eventPaste: '&'
	    },
	    template: '<div class="form-group col-md-6" id="{{iddiv}}">'+
				        '<label id="{{idlable}}" class="col-md-4 control-label {{req}}">{{modelLabel}}</label>'+
				        '<div class="col-md-8">'+
				                '<input type="hidden" ng-model="modelId" />'+
				                '<input id="{{comboId}}" ng-disabled="modelDisabled" name="{{comboId}}" class="form-control width100" ng-model="modelName" data-required-msg="{{modelLabel}} không được để trống">' +
				            '<span data-for="{{comboId}}" class="k-invalid-msg"></span>'+
				        '</div>'+
				        
				    '</div>',
	    replace: true,
	    link: function($scope, element, attrs, ctrl) {	        
	       
	        

	        setTimeout(function(){
	        	//debugger;
				if(attrs.req){
	        		$('#' + attrs.comboId).attr("required", "true");
	        	}
	        	
	        	if (attrs.comboSourceLink != undefined) {
                    $('#' + attrs.comboId).kendoAutoComplete({                        
                        dataTextField: attrs.comboName,
                        dataValueField: attrs.comboValue,
                        headerTemplate : $scope.headerTemplate,
                        footerTemplate: 'Total #: instance.dataSource.total() # items found',
                        template : $scope.templateAuto,
                        dataSource: {
							// schema: {
							// 	data: function (response) {
							// 		return response.data;
							// 	},
							// },

							// schema: {
							// 	data: (response) => {
							// 		response.slice = () => JSON.parse(JSON.stringify(response));
							// 		return response.data;
							// 	},
							// },
					        serverFiltering: true,
					        type: "json",
					        transport: {
					            read: {
									type: "POST",
									url: RestEndpoint.BASE_SERVICE_URL + attrs.comboSourceLink,
									contentType: "application/json; charset=utf-8",
									dataType: "json"
					            },
								parameterMap: function(options, operation) {
									//modelName là cái người dùng nhập
									if ($scope.modelName==null || $scope.modelName===""){
										$scope.modelId=null;
									}
									$scope.comboSearch.name = $scope.modelName;
									 $scope.comboSearch.parentName = $scope.modelName;
									 $scope.comboSearch.parentId = $scope.modelId;

									/*if ($scope.modelIdd != null){
										//
									}*/
									$scope.comboSearch.name = $scope.modelName;
									$scope.comboSearch.isSize = true;
									return JSON.stringify($scope.comboSearch);
								}
					        }
					    },
					    minLength: 1,
			            suggest: true,	
                        filter: "contains",
                        select: function (e) {
	                        var dataItem = this.dataItem(e.item.index());
	                        selectionProcessed = true;
			            	navigateTo(dataItem);
			            	if (dataItem != null && dataItem[attrs.comboValue] == 0) {
			            		e.preventDefault();
			            	}
	                    },
			            open: function(e) {
	                        selectionProcessed = false;
	                    },
	                    change: function (e) {
	                        if (!selectionProcessed) {
	                            selectionProcessed = true;
	                            processSearch();
	                        } else {
	                            selectionProcessed = false;
	                        }
	                    }                        
                    });
	                
	                $('#' + attrs.comboId).keypress(function(event) {
			        	if (event.which == kendo.keys.ENTER) {
	                        if (!selectionProcessed) {
	                            selectionProcessed = true;
	                            processSearch();
	                        } else {
	                            selectionProcessed = false;
	                        }
	                    }
			        });
	                
	                function processSearch() {
	                    var autocomplete = $('#' + attrs.comboId).data('kendoAutoComplete');
	                    var searchDataItem = null;
	                    if (autocomplete.value() != "") {
	                        if (autocomplete.value().length >= searchAutocompleteMinLength) {
	                            autocomplete.search(autocomplete.value());
	                            if (autocomplete.dataItem(0) != undefined) {
	                                searchDataItem = autocomplete.dataItem(0);
	                            }
	                        }
	                    }
	                    navigateTo(searchDataItem);                   
	                }
	                
	                function navigateTo(item) {
	                    if (item != null) {
	                    	if (item[attrs.comboValue] != 0) {
	                    		$scope.$apply(function () {
	                    			$scope.modelId = item[attrs.comboValue];
		                            $scope.modelName = item[attrs.comboName];
		        	                $('#' + attrs.comboId).data('kendoAutoComplete').value(item[attrs.comboName]);
		                        });
	        	               
								if (typeof attrs.eventchange !== "undefined" && attrs.eventchange != null){
									$rootScope.$broadcast(attrs.eventchange, $scope.modelId);
								}
	                    	}                             
	                    } else {
	                    	$scope.$apply(function () {
	                    		$scope.modelId = null;
		                        $scope.modelName = null;
	                        });	                    	
	                    	$('#' + attrs.comboId).data('kendoAutoComplete').value(null);
	                    }
	                }
		        }
	        }, 10);
	         	        
	    }
	  };
 });