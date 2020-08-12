angular.module('MetronicApp').service('searchType', function() {
});
angular
		.module('MetronicApp')
		.factory(
				'CommonService',
				[
						'RestEndpoint',
						'Restangular',
						'$kWindow',
						'Constant',
						'$rootScope',
						'$translate',
						'searchType',
						'$filter',
						'$q',
						'$http',
						function(RestEndpoint, Restangular, $kWindow, Constant,
								$rootScope, $translate, searchType, $filter,$q,$http) {

							var factory = {
								populateDataToGrid : populateDataToGrid,
								populateDataToGridBMaterial : populateDataToGridBMaterial,
								populateDataToGridCT : populateDataToGridCT,
								populateDataToTree : populateDataToTree,
								populateDataToGridplus : populateDataToGridplus,
								openCustomPopup : openCustomPopup,
								closePopup : closePopup,
								dismissPopup : dismissPopup,
								fetchFromURL : fetchFromURL,
								fetchSingleFromURL : fetchSingleFromURL,

								postToUrl : postToUrl,
								goToMenu : goToMenu,
								goTo : goTo,
								getUserInfo : getUserInfo,
								translate : translate,
								populatePopupCreate : populatePopupCreate,
								populatePopupDept : populatePopupDept,
								getDepartment : getDepartment,
								validateImport : validateImport,
								exportFile : exportFile,
								exportReport:exportReport,
								
								login:login,
								changePass:changePass
							};

							var modalInstance;
							var item;

							return factory;
							function translate(text) {

								try {
									return $translate.instant(text);

								} catch (err) {
									return text;
								}

							}
							function getUserInfo() {

								if (Constant.user != null
										&& Constant.user.srvUser != null) {
								let	srvuser = Constant.user.srvUser;
									return {
										groupId : srvuser.groupId,
										groupName : srvuser.groupName,
										groupCode : srvuser.groupCode,
										userId : srvuser.userId
									};
								}
								return {};
							}


							function goToMenu(menuKey, option) {
								var template = Constant.getTemplateUrl(menuKey);
								postal.publish({
									channel : "Tab",
									topic : "open",
									data : template
								});
								$rootScope.$broadcast(option.event, {
									data : option.data
								});
								/*
								 * $rootScope.isCreatAsset = false;
								 * $rootScope.$broadcast("cat.detail.reload");
								 */
							}

							function openOtherForm(recordId) {
								var template = Constant
										.getTemplateUrl('Asset_CatAssetDetail');
								$rootScope.activateResultTab = true;

								postal.publish({
									channel : "Tab",
									topic : "open",
									data : template
								});
							}
							// CommonService.populateDataToGrid(templateUrl,
							// title, vm.gridOptions, vm, popupId,searchtype);
							function populateDataToGrid(templateUrl, gridTitle,
									gridOptions, caller, popupId, searchType,
									isMultiSelect) {
								modalInstance = $kWindow.open({
									options : {
										modal : true,
										title : gridTitle,
										visible : false,
										width : '800',
										height : '550',
										actions : [ "Minimize", "Maximize",
												"Close" ],
										open : function() {
											this.wrapper.children(
													'.k-window-content')
													.addClass("fix-footer");
										}
									},
									templateUrl : templateUrl,
									controller : 'ModalInstanceCtrl',
									resolve : {
										data : function() {
											return gridOptions;
										},
										caller : function() {
											return caller;
										},
										modalInstance : function() {
											return this;
										},
										popupId : function() {
											return popupId;
										},
										searchType : function() {
											return searchType;
										},
										isMultiSelect : function() {
											return isMultiSelect;
										}
									}
								});

								modalInstance.result.then(function(result) {
									dismissPopup();
								});
							}
							// minhpvn -import bien ban phat sinh cong trinh
							function populateDataToGridCT(templateUrl,
									gridTitle, gridOptions, caller, popupId,
									searchType, isMultiSelect) {
								modalInstance = $kWindow.open({
									options : {
										modal : true,
										title : gridTitle,
										visible : false,
										width : '550',
										height : '350',
										actions : [ "Minimize", "Maximize",
												"Close" ],
										open : function() {
											this.wrapper.children(
													'.k-window-content')
													.addClass("fix-footer");
										}
									},
									templateUrl : templateUrl,
									controller : 'ModalInstanceCtrl',
									resolve : {
										data : function() {
											return gridOptions;
										},
										caller : function() {
											return caller;
										},
										modalInstance : function() {
											return this;
										},
										popupId : function() {
											return popupId;
										},
										searchType : function() {
											return searchType;
										},
										isMultiSelect : function() {
											return isMultiSelect;
										}
									}
								});

								modalInstance.result.then(function(result) {
									dismissPopup();
								});
							}
							// minhpvn
							function populateDataToGridBMaterial(templateUrl,
									gridTitle, gridOptions, caller, popupId,
									searchType, isMultiSelect) {
								modalInstance = $kWindow.open({
									options : {
										modal : true,
										title : gridTitle,
										visible : false,
										width : '1250',
										height : '550',
										actions : [ "Minimize", "Maximize",
												"Close" ],
										open : function() {
											this.wrapper.children(
													'.k-window-content')
													.addClass("fix-footer");
										}
									},
									templateUrl : templateUrl,
									controller : 'ModalInstanceCtrl',
									resolve : {
										data : function() {
											return gridOptions;
										},
										caller : function() {
											return caller;
										},
										modalInstance : function() {
											return this;
										},
										popupId : function() {
											return popupId;
										},
										searchType : function() {
											return searchType;
										},
										isMultiSelect : function() {
											return isMultiSelect;
										}
									}
								});

								modalInstance.result.then(function(result) {
									dismissPopup();
								});
							}

							function populateDataToGridplus(templateUrl,
									gridTitle, gridOptions, caller, popupId,
									searchType, isMultiSelect) {
								modalInstance = $kWindow.open({
									options : {
										modal : true,
										title : gridTitle,
										visible : false,
										width : '1000',
										height : '550',
										actions : [ "Minimize", "Maximize",
												"Close" ],
										open : function() {
											this.wrapper.children(
													'.k-window-content')
													.addClass("fix-footer");
										}
									},
									templateUrl : templateUrl,
									controller : 'ModalInstanceCtrl',
									resolve : {
										data : function() {
											return gridOptions;
										},
										caller : function() {
											return caller;
										},
										modalInstance : function() {
											return this;
										},
										popupId : function() {
											return popupId;
										},
										searchType : function() {
											return searchType;
										},
										isMultiSelect : function() {
											return isMultiSelect;
										}
									}
								});

								modalInstance.result.then(function(result) {
									dismissPopup();
								});
							}

							function populateDataToTree(templateUrl,
									tableTitle, treeData, caller, popupId,
									isMultiSelect) {
								modalInstance = $kWindow.open({
									options : {
										modal : true,
										title : tableTitle,
										visible : false,
										width : '650',
										height : '550',
										actions : [ "Minimize", "Maximize",
												"Close" ],
										open : function() {
											this.wrapper.children(
													'.k-window-content')
													.addClass("fix-footer");
										}
									},
									templateUrl : templateUrl,
									controller : 'ModalInstanceCtrl',
									resolve : {
										data : function() {
											return treeData;
										},
										caller : function() {
											return caller;
										},
										modalInstance : function() {
											return this;
										},
										popupId : function() {
											return popupId;
										},
										isMultiSelect : function() {
											return isMultiSelect;
										}
									}
								});

								modalInstance.result.then(function(result) {
									dismissPopup();
								});
							}

							function openCustomPopup(templateUrl, gridTitle,
									gridOptions, caller, popupId,
									controllerName, adOrgId, isMultiSelect) {
								modalInstance = $kWindow.open({
									options : {
										modal : true,
										title : gridTitle,
										visible : false,
										width : '550',
										height : '200',
										actions : [ "Minimize", "Maximize",
												"Close" ],
										open : function() {
											this.wrapper.children(
													'.k-window-content')
													.addClass("fix-footer");
										}
									},
									templateUrl : templateUrl,
									controller : controllerName,
									resolve : {
										data : function() {
											return gridOptions;
										},
										caller : function() {
											return caller;
										},
										modalInstance : function() {
											return this;
										},
										popupId : function() {
											return popupId;
										},
										adOrgId : function() {
											return adOrgId;
										},
										isMultiSelect : function() {
											return isMultiSelect;
										}
									}
								});

								modalInstance.result.then(function(result) {
									dismissPopup();
								});
							}
							function openSplitMoney(templateUrl, gridTitle,
									gridOptions, caller, popupId,
									controllerName, ccashInBankId) {
								modalInstance = $kWindow.open({
									options : {
										modal : true,
										title : gridTitle,
										visible : false,
										width : '350',
										height : '180',
										actions : [ "Minimize", "Maximize",
												"Close" ],
										open : function() {
											this.wrapper.children(
													'.k-window-content')
													.addClass("fix-footer");
										}
									},
									templateUrl : templateUrl,
									controller : controllerName,
									resolve : {
										data : function() {
											return gridOptions;
										},
										caller : function() {
											return caller;
										},
										modalInstance : function() {
											return this;
										},
										popupId : function() {
											return popupId;
										},
										ccashInBankId : function() {
											return ccashInBankId;
										}
									}
								});

								modalInstance.result.then(function(result) {
									dismissPopup();
								});
							}
							function openStockTransfer(templateUrl, gridTitle,
									gridOptions, caller, popupId,
									controllerName, depositbrowser) {
								modalInstance = $kWindow.open({
									options : {
										modal : true,
										title : gridTitle,
										visible : false,
										width : '350',
										height : '150',
										actions : [ "Minimize", "Maximize",
												"Close" ],
										open : function() {
											this.wrapper.children(
													'.k-window-content')
													.addClass("fix-footer");
										}
									},
									templateUrl : templateUrl,
									controller : controllerName,
									resolve : {
										data : function() {
											return gridOptions;
										},
										caller : function() {
											return caller;
										},
										modalInstance : function() {
											return this;
										},
										popupId : function() {
											return popupId;
										},
										depositbrowser : function() {
											return depositbrowser;
										}
									}
								});

								modalInstance.result.then(function(result) {
									dismissPopup();
								});
							}
							function closePopup() {
								$rootScope.popupOpen=false;
								modalInstance.close();
							}

							function dismissPopup() {
								$rootScope.popupOpen=false;
								modalInstance.dismiss('cancel');
							}

							function fetchFromURL(url) {
								return Restangular.all(url).getList();
							}

							function postToUrl(url, data) {
								return Restangular.all(url).post(data);
							}

							function fetchSingleFromURL(url) {
								return Restangular.one(url).get();
							}


							function populatePopupCreate(templateUrl,
									gridTitle, data, caller, windowId,
									isCreateNew, sizeWith, sizeHeight) {
								modalInstance = $kWindow
										.open({
											options : {
												modal : true,
												title : gridTitle,
												visible : false,
												width : sizeWith,
												height : sizeHeight,
												actions : [ "Minimize",
														"Maximize", "Close" ],
												open : function() {
											     
													this.wrapper
															.children(
																	'.k-window-content')
															.addClass(
																	"fix-footer");
													$rootScope.popupOpen=true;
												},
												close : function() {
													// modalInstance = null;
													$rootScope.popupOpen=false;
													$rootScope
															.$broadcast('Popup.CloseClick');
												}
											},
											templateUrl : templateUrl,
											controller : 'PopupCreateNewCtrl',
											resolve : {
												data : function() {
													return data;
												},
												caller : function() {
													return caller;
												},
												modalInstance : function() {
													return this;
												},
												windowId : function() {
													return windowId;
												},
												isCreateNew : function() {
													return isCreateNew;
												},
											}
										});

								modalInstance.result.then(function(result) {
									dismissPopup();
								});
								
							}

							function populatePopupDept(templateUrl, gridTitle,
									gridOptions, data, caller, popupId,
									searchType, isMultiSelect, sizeWith,
									sizeHeight) {
								modalInstance = $kWindow.open({
									options : {
										modal : true,
										title : gridTitle,
										visible : false,
										width : sizeWith,
										height : sizeHeight,
										actions : [ "Minimize", "Maximize",
												"Close" ],
										open : function() {
											this.wrapper.children(
													'.k-window-content')
													.addClass("fix-footer");
										}
									},
									templateUrl : templateUrl,
									controller : 'popupDepartmentController',
									resolve : {
										gridOptions : function() {
											return gridOptions;
										},
										dataTree : function() {
											return data;
										},
										caller : function() {
											return caller;
										},
										modalInstance : function() {
											return this;
										},
										popupId : function() {
											return popupId;
										},
										searchType : function() {
											return searchType;
										},
										isMultiSelect : function() {
											return isMultiSelect;
										}
									}
								});

								modalInstance.result.then(function(result) {
									dismissPopup();
								});
							}

							function getDepartment(obj) {
								return Restangular
										.all(
												"departmentServiceRest/department/getall")
										.post(obj);
							}

							function goTo(menuKey) {


									var template = Constant
											.getTemplateUrl(menuKey);

									postal.publish({
										channel : "Tab",
										topic : "open",
										data : template
									});

							}

							// validate template import

							function validateImport(dataList, validateColums) {
								var objReturn = {}
								objReturn.listData = [];
								if (dataList.hederList.length < validateColums.length) {
									objReturn.msg = "Không đúng biểu mẫu import"
									return objReturn
								} else {
									var str1 = "";
									var str2 = "";
									for (var i = 0; i < validateColums.length; i++) {
										str1 = str1 + validateColums[i].colum;
									}

									for (var j = 0; j < dataList.hederList.length; j++) {
										str2 = str2 + dataList.hederList[j];
									}
									if (str1 !== str2) {
										objReturn.msg = "Không đúng biểu mẫu import"
										return objReturn
									}

								}
								return objReturn;

							}

							// Export common
							function exportFile(kendoGrid, data, listRemove,
									listConvert,FileName) {
								var selectedRow = [];
								kendoGrid.table.find("tr").each(
										function(idx, item) {
											var row = $(item);
											var checkbox = $(
													'[name="gridcheckbox"]',
													row);

											if (checkbox.is(':checked')) {
												// Push id into selectedRow
											/*	var tr = kendoGrid.select()
														.closest("tr");*/
												var dataItem = kendoGrid
														.dataItem(item);
												selectedRow.push(dataItem);
											}
										});
								var datas = [];
								if (obj != null) {
									datas.push(obj);
								} else if (selectedRow.length > 0
										&& obj == null) {
									datas = selectedRow
								} else {
									datas = kendoGrid.dataSource.data();
								}
								var title = [];
								var field = [];
								for (var i = 0; i < kendoGrid.columns.length; i++) {
									var check = true;
									for (var j = 0; j < listRemove.length; j++) {
										if (kendoGrid.columns[i].title == listRemove[j].title) {
											check = false;
										}
									}
									if (check) {
										title.push(kendoGrid.columns[i].title)
										field.push(kendoGrid.columns[i])
									}
								}

								exportExcel(title, buildDataExport(datas, field,
										listConvert), FileName);
							}

							function buildDataExport(data, filed, listConvert) {
								// Row content
								var rData = [];
								$
										.each(
												data,
												function(index, value) {
													var objJson = JSON
															.parse(JSON
																	.stringify(value));
													var item = {
														cells : []
													};
													for (var i = 0; i < filed.length; i++) {
														var objadd = {};
														var check= false;
														for (var j = 0; j < listConvert.length; j++) {
															
															if (filed[i].field == listConvert[j].field) {
																objadd.value = listConvert[j].data[objJson[filed[i].field]];
																check=true;
															}
														}
														if(!check){
														if (filed[i].field == "stt") {
															objadd.value = index + 1;
														} else {
															objadd.value = objJson[filed[i].field];
															
														}
														}
														item.cells.push(objadd);
													}

													rData.push(item);
												});
								return rData;
							}
							
							function exportReport(obj) {
						    	var deferred = $q.defer();
					              $http({
					                    url: RestEndpoint.BASE_SERVICE_URL + "reportServiceRest"+"/exportPdf",
					                    dataType: 'json',
					                    method: 'POST',
					                    data: obj,
					                    headers: {
					                        "Content-Type": "application/json"
					                    },
					                    responseType : 'arraybuffer',//THIS IS IMPORTANT
					                }).success(function(data){
					            	  deferred.resolve(data); 
					              })
					              .error(function(data){
					            	  deferred.reject(data);
					              });
					             return deferred.promise;
					        }

							
							function login(obj) {
					            return Restangular.all("usersService/login").post(obj); 	 
					        }
							
							function changePass(obj) {
					            return Restangular.all("usersService/changePassword").post(obj); 	 
					        }
							
							
						} ]);