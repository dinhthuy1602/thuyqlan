angular.module('MetronicApp').factory(
    'objectsManagementService',
    [
            '$http',
            '$q',
            'RestEndpoint',
            'Restangular',
            '$kWindow',
            function($http, $q, RestEndpoint, Restangular, $kWindow) {
                var serviceUrl = RestEndpoint.OBJECTS_URL;
                var factory = {
                    createobjectsManagement : createobjectsManagement,
                    remove : remove,
                    updateobjectsManagement : updateobjectsManagement,
                    doSearch : doSearch,
                    lock: lock,
                    unlock:unlock,
                };

                return factory;

                function createobjectsManagement(obj) {
                    return Restangular.all(serviceUrl + "/objects/add").post(obj);
                }
                function remove(obj) {
                    return Restangular.all(serviceUrl + "/objects/remove").post(obj);
                }
                function updateobjectsManagement(obj) {
                    return Restangular.all(serviceUrl + "/objects/update").post(obj);
                }
                function doSearch(obj) {
                    return Restangular.all(serviceUrl + "/objects/doSearch").post(obj);
                }
                function lock(obj) {
                    return Restangular.all(serviceUrl + "/objects/lock").post(obj);
                }
                function unlock(obj) {
                    return Restangular.all(serviceUrl + "/objects/unlock").post(obj);
                }
            } ]);