angular.module('MetronicApp').factory(
		'usersManagementService',
		[
				'$http',
				'$q',
				'RestEndpoint',
				'Restangular',
				'$kWindow',
				function($http, $q, RestEndpoint, Restangular, $kWindow) {
					var serviceUrl = RestEndpoint.USERS_URL;
					var factory = {
						createusersManagement : createusersManagement,
						remove : remove,
						updateusersManagement : updateusersManagement,
						doSearch : doSearch,
						getParent : getParent,
						lock: lock,
						unlock:unlock,
						resetPass:resetPass,
						getListRoleByUserId:getListRoleByUserId,
						insertUserRoleData:insertUserRoleData
					};

					return factory;

					function createusersManagement(obj) {
						return Restangular.all(serviceUrl + "/users/add").post(obj);
					}
					function remove(obj) {
						return Restangular.all(serviceUrl + "/users/remove").post(obj);
					}

					function updateusersManagement(obj) {
						return Restangular.all(serviceUrl + "/users/update").post(obj);
					}

					function doSearch(obj) {
						return Restangular.all(serviceUrl + "/users/doSearch").post(obj);
					}
					function getParent() {
						return Restangular.all(serviceUrl + "/getParent").post();
					}
					function lock(obj) {
						return Restangular.all(serviceUrl + "/users/lock").post(obj);
					}
					function unlock(obj) {
						return Restangular.all(serviceUrl + "/users/unlock").post(obj);
					}
					function resetPass(obj) {
						return Restangular.all(serviceUrl + "/users/resetPass").post(obj);
					}
					
					function getListRoleByUserId(id) {
						return Restangular.all(serviceUrl + "/users/getListRoleByUserId").post(id);
					}
					
					function insertUserRoleData(obj) {
						return Restangular.all(serviceUrl + "/users/insertUserRoleData").post(obj);
					}
				} ]);
