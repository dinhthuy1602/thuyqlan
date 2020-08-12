(function() {
    'use strict';
    var controllerId = 'DashboardController';
    angular.module('MetronicApp').filter('startFrom', function() {
        return function(input, start) {
            start = +start; //parse to int
            return input.slice(start);
        }
        
       
    });

angular.module('MetronicApp').controller(controllerId, function($rootScope, $scope, $http, $timeout,$kWindow, CommonService, Constant,Restangular) {
    $scope.$on('$viewContentLoaded', function() {   
        // initialize core components
        App.initAjax();
    });

    var vm=this;
    vm.obj={};
    // set sidebar closed and body solid layout mode
    $rootScope.settings.layout.pageContentWhite = true;
    $rootScope.settings.layout.pageBodySolid = false;
    $rootScope.settings.layout.pageSidebarClosed = false;
    
    window.confirm = function (message, doYes, caption) {
        caption = caption || 'Xác nhận'
        var windowTemplate = kendo.template($("#windowConfirmTemplate").html());
//        $scope.message= message ;
        var data = { message: message };
        var modalInstance = $kWindow.open({
            options: {
                modal: true,
                title: caption,
                visible: false,
                width: '300',
                height: '150',
                actions: ["close"],
                open: function () {
                    this.wrapper.children('.k-window-content').addClass("fix-footer");
                    
                    $("#confirmPopup_btnCancel" ).click(function() {
                    	modalInstance.dismiss();
                	});
                    
                    $("#confirmPopup_btnConfirm" ).click(function() {
                    	modalInstance.dismiss();
                    	if (doYes && (typeof doYes === "function")) {
                            doYes();
                        }
                	});
                }
            },
           /* template: '<div class="modal-body">'+
    		'<label class="control-label" traslate>{{$scope.message}}</label> </div>  '	+	
    		'<div class="modal-footer">'+
    			'<button id="confirmPopup_btnCancel" type="button" class="btn green btn-outline padding-search" translate>Bỏ qua</button>'+
    			'<button id="confirmPopup_btnConfirm" type="button" class="btn green border-button-tree padding-search-right" translate>Xác nhận</button>'+
    		'</div>'*/
            template: windowTemplate(data)
        });
    };
    
    window.prompt = function (message, caption) {
        caption = caption || 'Nhắc nhở'
        var windowTemplate = kendo.template($("#windowPromptTemplate").html());
        var data = { message: message };
        var modalInstance = $kWindow.open({
            options: {
                modal: true,
                title: caption,
                visible: false,
                width: '350',
                height: '200',
                actions: ["close"],
                open: function () {
                    this.wrapper.children('.k-window-content').addClass("fix-footer");
                    
                    $("#promptPopup_btnCancel" ).click(function() {
                    	modalInstance.dismiss();
                	});           
                }
            },
            template: windowTemplate(data)
        });
    };
    
    
    $(document).ready(function() {
  
    kendo.ui.Tooltip.fn._show = function (show) {
        return function (target) {
            var e = {
                sender: this,
                target: target,
                preventDefault: function () {
                    this.isDefaultPrevented = true;
                }
            };

            if (typeof this.options.beforeShow === "function") {
                this.options.beforeShow.call(this, e);
            }
            if (!e.isDefaultPrevented) {
                show.call(this, target);
            }
        };
    }(kendo.ui.Tooltip.fn._show);
    
   /* var tooltip = $("#MainTabController").kendoTooltip({
        filter: "button",
        width: 120,
        position: "bottom",
        beforeShow: function (e) {
        	if ($(e.target).data("title") === undefined) {
                e.preventDefault();
            }
        },
        show: function (e) {
        	var position = e.sender.options.position;
            if (position == "bottom") {
            	e.sender.popup.element.css("margin-top", "10px");
            } else if(position == "top") {
            	e.sender.popup.element.css("margin-bottom", "10px");
            }
        }
    }).data("kendoTooltip");*/
//    Dashboard.init();
    initChar();
    vm.getCharOneAmount=getCharOneAmount;
    vm.getCharOneTimes=getCharOneTimes;
    vm.getCharTwoWeek=getCharTwoWeek;
    vm.getCharTwoMonth=getCharTwoMonth;
    function initChar(){
//    	getCharOneAmount();
//    	getCharTwoWeek();
//    	getCharThree();
//    	getCharFour();
    	
    }
    //Biểu đồ KPI
function getCharOneTimes(){
    	CommonService.getCharOneTimes(vm.obj).then(
				function(data) {
					  if(document.getElementById("myChartLine")){
					    	
					        new Chart(document.getElementById("myChartLine"), {
					        	  type: 'line',
					        	  data: {
					        		  labels: data.listStockCode,
					        	    datasets: [{ 
					        	        data: data.listKPIAmount,
					        	        label: "Số lượng mã hàng",
					        	        borderColor: "#de4747",
					        	        borderWidth: 1,
					        	        backgroundColor:"#fcecec",
					        	      }
					        	    ]
					        	  },
					        	  options: {
					        	    title: {
					        	      display: true,
					        	    },
					    		   responsive: true,
					    		       maintainAspectRatio: false,
					    		        scales: {
					    		            yAxes: [{
					    		                ticks: {
					    		                    beginAtZero:true
					    		                }
					    		            }]
					    		   },
					        	  legend: {
					                  display: true,
					                  labels: {
					                      fontColor: 'rgb(255, 99, 132)'
					                  },
					                  position:'bottom'
					              }
					        	  }
					        	});
					        
					        }
					
				}, function(errResponse) {
					  if(document.getElementById("myChartLine")){
					    	
					        new Chart(document.getElementById("myChartLine"), {
					        	  type: 'line',
					        	  data: {
					        	    labels: [1500,1600,1700,1750,1800,1850,1900,1950,1999],
					        	    datasets: [{ 
					        	        data: [282,350,411,502,635,809,947,1402,3700],
					        	        label: "Số lượng mã hàng",
					        	        borderColor: "#de4747",
					        	        borderWidth: 1,
					        	        backgroundColor:"#fcecec",
					        	      }
					        	    ]
					        	  },
					        	  options: {
					        	    title: {
					        	      display: true,
					        	    },
					    		   responsive: true,
					    		       maintainAspectRatio: false,
					    		        scales: {
					    		            yAxes: [{
					    		                ticks: {
					    		                    beginAtZero:true
					    		                }
					    		            }]
					    		   },
					        	  legend: {
					                  display: true,
					                  labels: {
					                      fontColor: 'rgb(255, 99, 132)'
					                  },
					                  position:'bottom'
					              }
					        	  }
					        	});
					        
					        }
			});
  
    }
    function getCharOneAmount(){
    	CommonService.getCharOneAmount(vm.obj).then(
				function(data) {
					  if(document.getElementById("myChartLine")){
					    	
					        new Chart(document.getElementById("myChartLine"), {
					        	  type: 'line',
					        	  data: {
					        		  labels: data.listStockCode,
					        	    datasets: [{ 
					        	        data: data.listKPIAmount,
					        	        label: "Số lượng mã hàng",
					        	        borderColor: "#de4747",
					        	        borderWidth: 1,
					        	        backgroundColor:"#fcecec",
					        	      }
					        	    ]
					        	  },
					        	  options: {
					        	    title: {
					        	      display: true,
					        	    },
					    		   responsive: true,
					    		       maintainAspectRatio: false,
					    		        scales: {
					    		            yAxes: [{
					    		                ticks: {
					    		                    beginAtZero:true
					    		                }
					    		            }]
					    		   },
					        	  legend: {
					                  display: true,
					                  labels: {
					                      fontColor: 'rgb(255, 99, 132)'
					                  },
					                  position:'bottom'
					              }
					        	  }
					        	});
					        
					        }
					
				}, function(errResponse) {
					  if(document.getElementById("myChartLine")){
					    	
					        new Chart(document.getElementById("myChartLine"), {
					        	  type: 'line',
					        	  data: {
					        	    labels: [1500,1600,1700,1750,1800,1850,1900,1950,1999],
					        	    datasets: [{ 
					        	        data: [282,350,411,502,635,809,947,1402,3700],
					        	        label: "Số lượng mã hàng",
					        	        borderColor: "#de4747",
					        	        borderWidth: 1,
					        	        backgroundColor:"#fcecec",
					        	      }
					        	    ]
					        	  },
					        	  options: {
					        	    title: {
					        	      display: true,
					        	    },
					    		   responsive: true,
					    		       maintainAspectRatio: false,
					    		        scales: {
					    		            yAxes: [{
					    		                ticks: {
					    		                    beginAtZero:true
					    		                }
					    		            }]
					    		   },
					        	  legend: {
					                  display: true,
					                  labels: {
					                      fontColor: 'rgb(255, 99, 132)'
					                  },
					                  position:'bottom'
					              }
					        	  }
					        	});
					        
					        }
			});
  
    }
    
    /*END Char ONE*/
    
    
    //Biểu đố giao dịch xuất/nhập kho
    function getCharTwoWeek(){
    	CommonService.getCharTwoWeek(vm.obj).then(
				function(data) { 
					if(document.getElementById("myChart")){
				    new Chart(document.getElementById("myChart"), {
				    	  type: 'line',
				    	  data: {
				    	    labels: data.listDay,
				    	    datasets: [{ 
				    	        data: data.listImported,
				    	        label: "Nhập",
				    	        borderColor: "#00b3b5",
				    	        borderWidth: 1,
				    	        backgroundColor:"#cedfdf",
				    	      }, { 
				    	    	  data: data.listExported,
				    	        label: "Xuất",
				    	        borderColor: "#de4747",
				    	        borderWidth: 1,
				    	        backgroundColor:"#fcecec",
				    	      }
				    	    ]
				    	  },
				    	  options: {
				    	    title: {
				    	      display: true,
				    	    },
						   responsive: true,
						       maintainAspectRatio: false,
						        scales: {
						            yAxes: [{
						                ticks: {
						                    beginAtZero:true
						                }
						            }]
						   },
				    	  legend: {
				              display: true,
				              labels: {
				                  fontColor: 'rgb(255, 99, 132)'
				              },
				              position:'bottom'
				          }
				    	  }
				    	});
				    
				    }
					}, function(errResponse) {
					 if(document.getElementById("myChart")){
						    new Chart(document.getElementById("myChart"), {
						    	  type: 'line',
						    	  data: {
						    	    labels: [1500,1600,1700,1750,1800,1850,1900,1950,1999],
						    	    datasets: [{ 
						    	        data: [86,114,106,106,107,111,133,221,783],
						    	        label: "Nhập",
						    	        borderColor: "#00b3b5",
						    	        borderWidth: 1,
						    	        backgroundColor:"#cedfdf",
						    	      }, { 
						    	        data: [282,350,411,502,635,809,947,1402,3700],
						    	        label: "Xuất",
						    	        borderColor: "#de4747",
						    	        borderWidth: 1,
						    	        backgroundColor:"#fcecec",
						    	      }
						    	    ]
						    	  },
						    	  options: {
						    	    title: {
						    	      display: true,
						    	    },
								   responsive: true,
								       maintainAspectRatio: false,
								        scales: {
								            yAxes: [{
								                ticks: {
								                    beginAtZero:true
								                }
								            }]
								   },
						    	  legend: {
						              display: true,
						              labels: {
						                  fontColor: 'rgb(255, 99, 132)'
						              },
						              position:'bottom'
						          }
						    	  }
						    	});
						    
						    }			});
    }
    
    function getCharTwoMonth(){
    	CommonService.getCharTwoMonth(vm.obj).then(
				function(data) { 
					if(document.getElementById("myChart")){
				    new Chart(document.getElementById("myChart"), {
				    	  type: 'line',
				    	  data: {
				    	    labels: data.listDay,
				    	    datasets: [{ 
				    	        data: data.listImported,
				    	        label: "Nhập",
				    	        borderColor: "#00b3b5",
				    	        borderWidth: 1,
				    	        backgroundColor:"#cedfdf",
				    	      }, { 
				    	    	  data: data.listExported,
				    	        label: "Xuất",
				    	        borderColor: "#de4747",
				    	        borderWidth: 1,
				    	        backgroundColor:"#fcecec",
				    	      }
				    	    ]
				    	  },
				    	  options: {
				    	    title: {
				    	      display: true,
				    	    },
						   responsive: true,
						       maintainAspectRatio: false,
						        scales: {
						            yAxes: [{
						                ticks: {
						                    beginAtZero:true
						                }
						            }]
						   },
				    	  legend: {
				              display: true,
				              labels: {
				                  fontColor: 'rgb(255, 99, 132)'
				              },
				              position:'bottom'
				          }
				    	  }
				    	});
				    
				    }
					}, function(errResponse) {
					 if(document.getElementById("myChart")){
						    new Chart(document.getElementById("myChart"), {
						    	  type: 'line',
						    	  data: {
						    	    labels: [1500,1600,1700,1750,1800,1850,1900,1950,1999],
						    	    datasets: [{ 
						    	        data: [86,114,106,106,107,111,133,221,783],
						    	        label: "Nhập",
						    	        borderColor: "#00b3b5",
						    	        borderWidth: 1,
						    	        backgroundColor:"#cedfdf",
						    	      }, { 
						    	        data: [282,350,411,502,635,809,947,1402,3700],
						    	        label: "Xuất",
						    	        borderColor: "#de4747",
						    	        borderWidth: 1,
						    	        backgroundColor:"#fcecec",
						    	      }
						    	    ]
						    	  },
						    	  options: {
						    	    title: {
						    	      display: true,
						    	    },
								   responsive: true,
								       maintainAspectRatio: false,
								        scales: {
								            yAxes: [{
								                ticks: {
								                    beginAtZero:true
								                }
								            }]
								   },
						    	  legend: {
						              display: true,
						              labels: {
						                  fontColor: 'rgb(255, 99, 132)'
						              },
						              position:'bottom'
						          }
						    	  }
						    	});
						    
						    }			});
    }
    
    /*END Char ONE*/
    
    //Biểu đồ yêu cầu mới
    function getCharThree(){
    	CommonService.getCharThree(vm.obj).then(
				function(data) {
					if(document.getElementById("bar-chart-grouped")){
					    new Chart(document.getElementById("bar-chart-grouped"), {
					        type: 'bar',
					        data: {
					        	labels: data.listStockCode,
					          datasets: [
					            {
					              label: "Nhập",
					              backgroundColor: "#bf4d4a",
					              data: data.listImStock
					             
					            }, {
					              label: "Xuất",
					              backgroundColor: "#4177b8",
					              data: data.listOutStock
					            }
					          ]
					        },
					        options: {
					          title: {
					            display: true,
					          },
					          responsive: true,
					          maintainAspectRatio: false,
					           scales: {
					               yAxes: [{
					                   ticks: {
					                       beginAtZero:true
					                   }
					               }]
					           },
					        legend: {
					            display: true,
					            labels: {
					                  fontColor: 'rgb(255, 99, 132)'
					              },
					            position:'bottom'
					        }
					        }
					    });
					    }
					
				}, function(errResponse) {
					if(document.getElementById("bar-chart-grouped")){
					    new Chart(document.getElementById("bar-chart-grouped"), {
					        type: 'bar',
					        data: {
					        	labels: ["1900", "1950", "1999", "2050"],
					          datasets: [
					            {
					              label: "Nhập",
					              backgroundColor: "#bf4d4a",
					              data: [133,221,783,2478]
					            }, {
					              label: "Xuất",
					              backgroundColor: "#4177b8",
					              data: [408,547,675,734]
					            
					            }
					          ]
					        },
					        options: {
					          title: {
					            display: true,
					          },
					          responsive: true,
					          maintainAspectRatio: false,
					           scales: {
					               yAxes: [{
					                   ticks: {
					                       beginAtZero:true
					                   }
					               }]
					           },
					        legend: {
					            display: true,
					            labels: {
					                  fontColor: 'rgb(255, 99, 132)'
					              },
					            position:'bottom'
					        }
					        }
					    });
					    }
			});
    
    };
    //Biểu đồ phiếu xuất nhập chưa hoàn thành
   
    function getCharFour(){
    	 if(document.getElementById("progressBarId")){
    		 var obj={};
    		 CommonService.getCharFour(obj).then(
 					function(data) {
 						vm.ImNotReal=data.imNotReal;
 						vm.ImNotSign=data.imNotSign;
 						vm.ExNotSign=data.exNotSign;
 						vm.ExNotReal=data.exNotReal;
 						vm.ExInRoad=data.exInRoad;
 						
 						vm.ImNotRealRate=data.imNotRealRate;
 						vm.ImNotSignRate=data.imNotSignRate;
 						vm.ExNotSignRate=data.exNotSignRate;
 						vm.ExNotRealRate=data.exNotRealRate;
 						vm.ExInRoadRate=data.exInRoadRate;
 						 ImNotRealRateOne();
 						ImNotRealRateTwo();
 						ImNotRealRateThree();
 						ImNotRealRateFour();
 						ImNotRealRateFive();
 					}, function(errResponse) {
 				});
    		
    	 }
    };
    function ImNotRealRateOne() {
    	var widthProgress = vm.ImNotSignRate + "%";
        var css = document.getElementById("progressbarOne");
        $(css).css("width", widthProgress);
    }
    function ImNotRealRateTwo() {
    	var widthProgress = vm.ImNotRealRate + "%";
        var css = document.getElementById("progressbarTwo");
        $(css).css("width", widthProgress);
    }
    function ImNotRealRateThree() {
    	var widthProgress = vm.ExNotSignRate + "%";
        var css = document.getElementById("progressbarThree");
        $(css).css("width", widthProgress);
    }
    function ImNotRealRateFour() {
    	var widthProgress = vm.ExNotRealRate + "%";
        var css = document.getElementById("progressbarFour");
        $(css).css("width", widthProgress);
    }
    function ImNotRealRateFive() {
    	var widthProgress = vm.ExInRoadRate + "%";
        var css = document.getElementById("progressbarFive");
        $(css).css("width", widthProgress);
    }
    });
  
    
    
});

})();