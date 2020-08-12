/* global toastr:false, moment:false */
(function() {
	'use strict';

	angular.module('MetronicApp').constant('RestEndpoint', RestEndpoint());

	/* @ngInject */
	function RestEndpoint() {
		var endpoints = {
			BASE_SERVICE_URL : '/qlan-service/',
			USERALERT_URL:"userAlertServiceRest/userAlert",
			AREA_URL : "areaService",
			DEPT_URL: "deptServiceRest/dept",
			APPARAM_URL: "apParamServiceRest/apParam",
			MANAGEREMPLOYEECBV_URL: "staffCbvServiceRest/staffCbv",
			OBJECTS_URL: "objectsService",
			USERS_URL: "usersService",
			ROLES_URL: "rolesServiceRest/roles"
		};
		return endpoints;
	}
})();
