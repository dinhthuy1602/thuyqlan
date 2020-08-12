/***
GLobal Directives
***/

MetronicApp.directive('onChangeFile', ['$rootScope',function() {
  return {
    restrict: 'A',    
    link: function (scope, element, attrs) {
      var onChangeFunc = scope.$eval(attrs.onChangeFile);
      element.bind('change', onChangeFunc);
    }
  };
}]);




// Route State Load Spinner(used on page or content load)
MetronicApp.directive('ngSpinnerBar', ['$rootScope',
    function($rootScope) {
        return {
            link: function(scope, element, attrs) {
                // by defult hide the spinner bar
                //element.addClass('hide'); // hide spinner bar by default

                // display the spinner bar whenever the route changes(the content part started loading)
                $rootScope.$on('$stateChangeStart', function() {
                	//HANHLS1 -su dung de bo viec load
                	if($rootScope.authenticatedUser!=null){
                		element.removeClass('hide'); // show spinner bar
                	}
                	
                });

                // hide the spinner bar on rounte change success(after the content loaded)
                $rootScope.$on('$stateChangeSuccess', function() {
                	element.addClass('hide'); // hide spinner bar
                	//if($rootScope.authenticatedUser!=null){// giữ nguyên button load nếu chưa đăng nhập                		
                		$('body').removeClass('page-on-load'); // remove page loading indicator
                    //}
                    Layout.setSidebarMenuActiveLink('match'); // activate selected link in the sidebar menu
                   
                    // auto scorll to page top
                    setTimeout(function () {
                        App.scrollTop(); // scroll to the top on content load
                    }, $rootScope.settings.layout.pageAutoScrollOnLoad);     
                });

                // handle errors
                $rootScope.$on('$stateNotFound', function() {
                    element.addClass('hide'); // hide spinner bar
                });

                // handle errors
                $rootScope.$on('$stateChangeError', function() {
                    element.addClass('hide'); // hide spinner bar
                });
            }
        };
    }
])

// Handle global LINK click
MetronicApp.directive('a', function() {
    return {
        restrict: 'E',
        link: function(scope, elem, attrs) {
            if (attrs.ngClick || attrs.href === '' || attrs.href === '#') {
                elem.on('click', function(e) {
                    e.preventDefault(); // prevent link click for above criteria
                });
            }
        }
    };
});

// Handle Dropdown Hover Plugin Integration
MetronicApp.directive('dropdownMenuHover', function () {
  return {
    link: function (scope, elem) {
      elem.dropdownHover();
    }
  };  
});


MetronicApp.directive('format', ['$filter', function ($filter) {
    return {   
    	require: 'ngModel',
        scope: {
        	ngModel:"@"        	        
        },
        link: function ($scope, elem, attrs, ctrl) {
        	var symbol="";
        	var fractionSize=0;
            if (!ctrl) return;

            ctrl.$formatters.unshift(function (a) {
            	if(attrs.symbol){
            		symbol=attrs.symbol;
            	}
            	if(attrs.fractionSize){
            		fractionSize=attrs.fractionSize;
            	}            	
                return $filter(attrs.format)(ctrl.$modelValue,symbol,fractionSize);
            });

            elem.bind('blur', function(event) {
                var plainNumber = elem.val().replace(/[^\d|\-+|\.+]/g, '');             
             
                elem.val($filter(attrs.format)(plainNumber,symbol,fractionSize));
            });
        }
    };
}]);
MetronicApp.directive('vtCurrency', ['$filter', function ($filter) {
    return {   
    	
    	require: 'ngModel',
    	restrict:'AE',
//        scope: {
//        	ngModel:"@"        	        
//        },
        link: function ($scope, elem, attrs, ctrl) {
        	var symbol="";
        	var fractionSize=0;
            if (!ctrl) return;

            ctrl.$formatters.unshift(function (a) {
            	if(attrs.symbol){
            		symbol=attrs.symbol;
            	}
            	if(attrs.fractionSize){
            		fractionSize=attrs.fractionSize;
            	}            	
            	if(ctrl.$modelValue==null){
            		return "";
            	}
                return $filter('currency')(ctrl.$modelValue,'',fractionSize )+symbol;
            });

            elem.bind('blur', function(event) {
                var plainNumber = elem.val().replace(/[^\d|\-+|\.+]/g, '');             
             
                elem.val($filter('currency')(plainNumber,symbol,fractionSize));
            });

        }
    };
}]);

MetronicApp.directive('filterMenu', ['$filter', function ($filter) {	
	 return {   
	    	
	    	require: 'ngModel',
	    	restrict:'AE',
	    	scope:{
	    		parentMenu:'@'
	    		
	    	},
	    	 link: function ($scope, elem, attrs, ctrl) {
	         	return "";
	         }
	 }
	 
}]);

MetronicApp.directive('simpleUploadFile', function(Constant,Restangular,$timeout) {
	  return {
	    restrict: 'E',
	    transclude: true,
	    replace: true,
        require: '^?ngModel',
	    scope:{
	    	list:'=',	
	    	attachName:'=',
	    	item:'=',
	    	multiple:'=',
	    	readonly:'=',
	    },
	    template:'<div><div class="input-group input-group-file">'
			+'<input type="file"  accept=".doc, .xls, .pdf"  style="display: none;" />'												 
			+'<input type="text" class="form-control att file" placeholder="Chọn file..." ng-model="attachName" readonly/>'												
			+'<span class="input-group-btn">'
			+'<button class="btn btn-default btn-sm" type="button" style="padding-bottom: 3px; padding-top: 2px;" onclick="angular.element(this).scope().btnClickChangeFile(this)">Browser</button>'
				+'</span>'
				//+'<a href="downloadFile" ng-click="downloadFile" />{{attachName}}</>'												
				
			+'</div>'
			+'<div class="list-attach-files" ng-if="listFiles.length>0" > <div class="item-attach-item" ng-repeat="item in listFiles">'
			+' <i class=" ace-icon fa fa-file"></i>'
			+' <a href="javascript:;" ng-click="downloadFile($index)" title="{{item.fileName}}">{{item.fileName}}</a>'
			+'<button type="button" class="btn btn-link" ng-click="removeFile($index)" title="Xóa file" ng-if="!readonly"><i class="fa fa-remove red"></i></button>'
			+'</div></div></div>',
	  
	    link: function (scope, element, attrs,ngModel) {
	    	 scope.listFiles=[];
	    	/*if(scope.multiple == undefined){
	    		scope.multiple=true;
	    	}else{*/
	    		scope.multiple=false;//Hiện tại loại file hỗ trợ là not multiple
	    	//}
    		if(scope.list ==undefined){
    			scope.list=[];
    		}else if(scope.list.length==0){
    			scope.list=[];
    		}
			scope.loadFiles=function(){
				if(!scope.multiple){
					if(scope.item){
						if(scope.item.fileName){
							scope.listFiles.push({
								'fileName':scope.item.fileName,
								'fileNameEncrypt':scope.item.attachIdEncrypted,                			                			
								'type':2//Loại trả về fileNameEncrypt
							})
						};
					}
				
				 }else{
					 angular.forEach(scope.list, function (item) {
						 
		                    //scope.listId.push(v.endcodeAttachId);
		                    scope.listFiles.push({
		                    	'fileName':item.fileName,
	                			'fileNameEncrypt':item.fileNameEncrypt,                			
	                			
	                    		'type':2//Loại trả về fileNameEncrypt	
		                    });
						
		               });
				 }
	    		}
			
		 
	    	scope.downloadFile=function(index){
	    		var url=Constant.DOWNLOAD_SERVICE+scope.list[index].fileNameEncrypt;
	    		downloadFileWithUrl(url);
	    		
	    	}
	    	scope.removeFile=function(index){
	    		if(scope.listFiles){
	    			scope.listFiles.splice(index,1);
	    		}
	    	}
	    	scope.changeFile=function(e){
	    		console.log('changeFile');
	    		//scope.changeAttachFile();
	    		var fileName = event.target.files[0].name;				
		        var formData = new FormData();
				var assetUpload = event.target.files[0];
				formData.append('assetUpload', assetUpload);
				var fileSize = ((assetUpload.size/1024)/1024).toFixed(4);
				if(fileSize<20){					
				}
	    		Restangular.one(Constant.UPLOAD_RS_SERVICE).withHttpConfig(
						{
							transformRequest : angular.identity
						}).customPOST(formData, '', undefined, {
					'Content-Type' : 'multipart/form-data'
				}).then(function(successResponse) {					
					if(successResponse.length>0){							
//						 //scope.$apply(function () {
                            if(!scope.multiple){
                            	var object={
                        			'fileName':fileName,
                        			'fileNameEncrypt':successResponse[0],
                        			'fileSize':fileSize,
                        			
                            		'type':1//Loại trả về fileNameEncrypt	
                            	}
                            	scope.list=[];
                            	scope.list.push(object);
                            
                            	 ngModel.$setViewValue(successResponse[0]);
                                scope.attachName=fileName;
                            }
                            	
                            //}
                        //});
					}
				});
	    	}
	    	scope.btnClickChangeFile=function(element){
	    		console.log(element);
	    		angular.element(element).parent().prev().prev().bind('change',scope.changeFile);
	    		angular.element(element).parent().prev().prev().click();
	    	}
	    	scope.changeAttachFile=function(event){
	    		
	    	}
	    	 $timeout(function () {
                 scope.loadFiles();
             }, 0);
	     
	    }
	  };
	});

MetronicApp.directive('uploadFile',function ( $timeout, $compile){
	 return {
         restrict: 'E',
         transclude: true,
         replace: true,
         require: '^?ngModel',
         scope:{
        	 list: '=',
        	 saveUrl:'='
        	  /*only: '@',
        	  maxFiles: '@',
              maxSize: '@',
              maxSizeText: '@',
              fileType: '@'*/
         },
         template:'<input name="files"'
             +'type="file"    kendo-upload="uploader" k-select="onSelect" k-options="options" k-upload="onUpload" k-progress="onProgress" '              
              //+' k-async="{ saveUrl: {{saveUrl}},  autoUpload: true }" '
                /* +' '
                 +' k-upload="onUpload"'
                 +' k-success="onSucess"'+
                 +' k-template="listFileTemplate"'   */             
                 +'/>',
         link: function (scope, element, attrs, ngModel){
        	// scope.saveUrl="/ktts-service/fileservice/uploadATTT";
        	 	if(scope.saveUrl== undefined){
        	 		scope.saveUrl='/qlan-service/fileservice/uploadATTT';
        	 	}
        	   scope.onSelect = function(e) {
                   var message = $.map(e.files, function(file) { return file.name; }).join(", ");
                   console.log("event :: select (" + message + ")");
               }
        	   
        	  scope.options={        		  
        			  async:{ saveUrl: scope.saveUrl, removeUrl: 'remove', autoUpload: true },
        			  progress:scope.onProgress,
        			  template: "<span class='k-progress'>{{getPercen(files[0])}}</span>"
                      +'<div><span class="k-filename">#=name#</span>'                      
                      //+"<h4 class='file-heading file-name-heading'>Name: #=name#</h4>"
                      //+"<h4 class='file-heading file-size-heading'>Size: #=size# bytes</h4>" +
//                      		+"<strong class='k-upload-status'>" +
//                      				+"</strong>"
                      				+"</div>"
                      		//""                    
                  
        	  
        	  };
        	   
               //vm.listFiles=[{"name":"test.jpg"}];
               //scope.listFileTemplate=$scope.getTemplateBySelector("#fileTemplate");
               scope.onSucess=function(e){
               	   for (var i = 0; i < e.files.length; i++) {
               		   scope.$apply(function(){        			   
       	        		   	vm.listFiles.push(e.files[i]);
       	        		   }
               		   );
               	   }
               	 //  $scope.setValueToModel();
               }
               scope.getPercen=function(file){
            	   console.log(file);
            	   if(file.percentComplete !=undefined){
            		   return file.percentComplete;
            	   }
            	   return 1;
            	   //return file.percentComplete;
            	   
               }
               scope.onProgress=function(ev) {
	        	   var progress = ev.percentComplete;	
	        	   for(var i=0;i<ev.files.length;i++){
	        		   ev.files[0].percentComplete=ev.percentComplete;
	        		   scope.$apply(function(){        			   
	        			   ev.files[0].percentComplete;
      	        		   }
              		   );
	        	   }
	        	   console.log(ev.percentComplete);
        	   }
               scope.onUpload=function(e) {

                   var xhr = e.XMLHttpRequest; 
                   xhr.addEventListener("readystatechange", function(e) {
                       if (xhr.readyState == 1 /* OPENED */) {
                           xhr.setRequestHeader('X-CSRF-TOKEN', readCookie('XSRF-TOKEN'));
                       }
                   });
                   console.log("Upload :: " );
                   //console.log("Upload :: " + getFileInfo(e));
               };
        		 
         }
	 }
});
MetronicApp.directive("floatingNumberOnly", function() {
	  return {
	    require: 'ngModel',
	    link: function(scope, ele, attr, ctrl) {

	      ctrl.$parsers.push(function(inputValue) {
	        console.log(inputValue);
	        var pattern = new RegExp("(^[0-9]{1,9})+(\.[0-9]{1,4})?$", "g");
	        if (inputValue == '')
	          return '';
	        var dotPattern = /^[.]*$/;

	        if (dotPattern.test(inputValue)) {
	          console.log("inside dot Pattern");
	          ctrl.$setViewValue('');
	          ctrl.$render();
	          return '';
	        }

	        var newInput = inputValue.replace(/[^0-9.]/g, '');
	        // newInput=inputValue.replace(/.+/g,'.');

	        if (newInput != inputValue) {
	          ctrl.$setViewValue(newInput);
	          ctrl.$render();
	        }
	        //******************************************
	        //***************Note***********************
	        /*** If a same function call made twice,****
	         *** erroneous result is to be expected ****/
	        //******************************************
	        //******************************************

	        var result;
	        var dotCount;
	        var newInputLength = newInput.length;
	        if (result = (pattern.test(newInput))) {
	          console.log("pattern " + result);
	          dotCount = newInput.split(".").length - 1; // count of dots present
	          if (dotCount == 0 && newInputLength > 9) { //condition to restrict "integer part" to 9 digit count
	            newInput = newInput.slice(0, newInputLength - 1);
	            ctrl.$setViewValue(newInput);
	            ctrl.$render();
	          }
	        } else { //pattern failed
	          console.log("pattern " + result);
	          // console.log(newInput.length);

	          dotCount = newInput.split(".").length - 1; // count of dots present
	          console.log("dotCount  :  " + dotCount);
	          if (newInputLength > 0 && dotCount > 1) { //condition to accept min of 1 dot
	            console.log("length>0");
	            newInput = newInput.slice(0, newInputLength - 1);
	            console.log("newInput  : " + newInput);

	          }
	          if ((newInput.slice(newInput.indexOf(".") + 1).length) > 4) { //condition to restrict "fraction part" to 4 digit count only.
	            newInput = newInput.slice(0, newInputLength - 1);
	            console.log("newInput  : " + newInput);

	          }
	          ctrl.$setViewValue(newInput);
	          ctrl.$render();
	        }

	        return newInput;
	      });
	    }
	  };
	});
	
MetronicApp.directive('formatDate', ['$filter', function ($filter) {
      return {
          require: '?ngModel',
          link: function (scope, element, attrs, ctrl) {

						element.kendoMaskedTextBox({
							mask : "00/00/0000"
						});
						element.kendoDatePicker({
							format : "dd/MM/yyyy"
						});
						element.closest(".k-datepicker").add(element).removeClass("k-textbox");
        	  
          }
      };
  }]);	