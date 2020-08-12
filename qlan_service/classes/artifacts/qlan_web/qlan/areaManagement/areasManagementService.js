angular.module('MetronicApp').factory('areasManagementService',
    ['$http', '$q', 'RestEndpoint', 'Restangular',

        function ($http, $q, RestEndpoint, Restangular) {
            var serviceUrl = RestEndpoint.AREA_URL;
            return {
                doSearch: doSearch,
                doSearchTTT: doSearchTTT,
                doSearchTree: doSearchTree,
                remove: remove,
                updateAreas: updateAreas,
                addAreas: addAreas
            };

            function doSearch(obj) {
                return Restangular.all(serviceUrl + "/area/doSearch").post(obj);
            }

            function doSearchTTT(obj) {
                return Restangular.all(serviceUrl + "/area/doSearchTT").post(obj);
            }

            function doSearchTree() {
                return Restangular.all(serviceUrl + "/area/doSearchTree").post();
            }

            function remove(obj) {
                return Restangular.all(serviceUrl + "/area/remove").post(obj);
            }

            function updateAreas(obj) {
                return Restangular.all(serviceUrl + "/area/update").post(obj);
            }

            function addAreas(obj) {
                return Restangular.all(serviceUrl + "/area/add").post(obj);
            }

        }]);
