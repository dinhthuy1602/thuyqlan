(function (message) {
    'use strict';
    angular.module('MetronicApp').controller('areasManagementController', ['$scope', 'gettextCatalog',
        'kendoConfig', 'areasManagementService',
        'CommonService', 'Constant', '$rootScope', function areasManagementController($scope, gettextCatalog,
                                                                                      kendoConfig, areasManagementService,
                                                                                      CommonService, Constant, $rootScope) {
            debugger;
            //gettextCatalog : dịch theo tiếng mà thứ tiếng mình định nghĩa
            var vm = this;
            vm.showSearch = true; // doi tuong tim kiem
            vm.isCreateNew = false; // doi tuong tao ra de ko cho nhap ky tu trong
            vm.isDvtt = false;
            vm.areasManagementCreate = {
                status: 2,
                objectTypeId: 2,
                parentName: null
            };
            vm.areasManagementCreateTT = {parentName: null, parentId: null}

            vm.areasManagementSearch = {
                status: null,
                id: null
            };
            vm.areasManagementSearchTT = {
                status: null
            };

            vm.areasManagementEditTT = {}

            vm.areasManagement = {};
            vm.validatorOptions = kendoConfig.get('validatorOptions');
            vm.check = false;


            vm.paren = [
                {id: 0, name: 'Không hoạt động'},
                {id: 1, name: 'Hoạt động'}
            ];
            vm.parenSelectOptions = {
                dataSource: vm.paren,
                dataTextField: "name",
                dataValueField: "id",
                optionLabel: "---Chọn---",
                valuePrimitive: true
            }

            vm.status = [
                {id: 0, name: 'Không hoạt động'},
                {id: 1, name: 'Hoạt động'}
            ];
            vm.statusSelectOptions = {
                dataSource: vm.status,
                dataTextField: "name",
                dataValueField: "id",
                optionLabel: "---Chọn---",
                valuePrimitive: true
            }


            vm.commonSearch = {name: '', code: ''};
            vm.headerTemplate='<div class="dropdown-header row text-center k-widget k-header">' +
                '<p class="col-md-6 text-header-auto border-right-ccc">Mã</p>' +
                '<p class="col-md-6 text-header-auto border-right-ccc">Tên</p>' +
                '</div>';
            vm.template=
                '<div class="row"><div class="col-xs-5" style="padding: 0px 32px 0 0;float:left">#: data.areaCode #</div>' +
                '<div style="padding-left: 10px,width:auto;overflow:hidden;text-align: right;">#: data.areaName #</div></div>';


            function genData(items, parent) {
                let itemArr = [];
                for (let i = 0; i < items.length; i++) {
                    if (items[i].parentId === parent) {
                        let row = items[i];
                        row.id = items[i].id;
                        row.text = items[i].text;
                        row.items = genData(items, items[i].id);
                        itemArr.push(row);
                    }
                }
                return itemArr;
            }

            vm.treeViewOptions = {
                dataSource: [],
                dataTextField: "areaCode",
                loadOnDemand: false,
                expandAll: false,
                dataBound: function (e) {
                },
            }


            vm.openDepartment = openDepartment;

            function openDepartment() {
                areasManagementService.doSearchTree().then(function (result) {
                    // tree menu
                    var data = result;
                    vm.treeView.setDataSource(new kendo.data.HierarchicalDataSource({
                        data: genData(data, 0)
                    }));
                    vm.treeView.dataSource.read();
                });
            }

            vm.getDataParen = getDataParen;

            // đổ data ra Tree bên trái
             function getDataParen() {
                areasManagementService.doSearchTree().then(function (result) {
                    // tree menu
                    var data = result;
                    vm.treeView.setDataSource(new kendo.data.HierarchicalDataSource({
                        data: genData(data, 0)
                    }));
                    var treeview = $("#treeview").data("kendoTreeView");
                    var barDataItem = treeview.dataSource.get(1);
                    var barElement = treeview.findByUid(barDataItem.uid);
                    barElement.addClass("dads");
                    console.log(barElement.attr('aria-selected'));
                    console.log(barElement.dataset);
                    treeview.select(barElement);
                    vm.treeView.dataSource.read();
                });
             }
// Phân trang để genData ra grid
            vm.doSearchTT = doSearchTT;

            function doSearchTT(dataItem) {
                dataItem.page = 1;
                dataItem.pageSize = 5;
                vm.areasManagementSearchTT.parentId = dataItem.parentId;
                vm.areasManagementSearchTT.id = dataItem.id;
                vm.areasManagementSearchTT.status = dataItem.status;
                vm.areasManagementCreateTT.parentName = dataItem.areaCode;
                vm.areasManagementCreateTT.parentId = dataItem.id;
                let gridTT = vm.areasTTManagementGrid;

                if (gridTT) {
                    gridTT.dataSource.query({
                        page: 1,
                        pageSize: 5
                    });
                }
            }
            function datasearch() {
                let grid = vm.areasManagementGrid;
                if (grid) {
                    grid.dataSource.query({
                        page: 1,
                        pageSize: 5
                    });
                }
                let gridTT = vm.areasTTManagementGrid;
                if (gridTT) {
                    gridTT.dataSource.query({
                        page: 1,
                        pageSize: 5
                    });
                }
            }

            vm.doSearch = doSearch;

            function doSearch() {
                if (vm.areasManagementSearch.id != null) {
                    vm.areasManagementSearch.id = null;
                }
                vm.areasManagementCreateTT.parentName = null;
                vm.areasManagementCreateTT.parentId = null;
                vm.areasManagementSearchTT.areaName = vm.areasManagementSearch.areaName;
                vm.areasManagementSearchTT.areaCode = vm.areasManagementSearch.areaCode;
                vm.areasManagementSearchTT.status = vm.areasManagementSearch.status;
                vm.areasManagementSearchTT.id = vm.areasManagementSearch.id;
                vm.check = false;
                datasearch();
            }



            vm.onChangeTree = function (dataItem1) {
                vm.areasManagementSearch.id = dataItem1.id;
                vm.areasManagementSearch.areaName = null;
                vm.areasManagementSearch.areaCode = null;
                vm.areasManagementSearch.status = null;
                vm.areasManagementSearchTT.areaName = dataItem1.areaName;
                vm.areasManagementSearchTT.areaCode = dataItem1.areaCode;
                vm.areasManagementSearchTT.status = dataItem1.status;
                vm.areasManagementSearchTT.id = dataItem1.id;
                vm.areasManagementCreateTT.parentName = dataItem1.areaCode;
                vm.areasManagementCreateTT.parentId = dataItem1.id;
                datasearch();
            }

            initFormData();

            function initFormData() {
                getDataParen();
                fillDataTable([]);
                fillDataTableAreaTT([]);
            }

            vm.dulieu = {};

            function fillDataTable(data) {
                vm.gridOptions = kendoConfig.getGridOptions({
                    autoBind: true, // khi có sự thay đổi thì cái autoBind tự động thay đổi( tự map tới nguồn dữ liệu)
                    sortable: false, // sắp xếp theo cột
                    resizable: true, // thay đổi kích thước cột bằng cách kéo tay
                    columnMenu: true, // ẩn menu cột theo tuỳ chọn
                    toolbar: [  // hiện thị theo hàng giống thanh công cụ
                        {
                            name: "actions",
                            template: /*'<div class="pull-left">' +
                                '<a class="btn btn-qlk padding-search-right addQLK"' +
                                'ng-click="vm.add()" uib-tooltip="Thêm mới" translate><p class="action-button add" aria-hidden="true">Tạo mới</p></a>' +
                                '</div>'
                                +*/
                                '<div class="btn-group pull-right margin_top_button margin_right10">' +
                                '<i data-toggle="dropdown" aria-expanded="false"><i class="fa fa-cog" aria-hidden="true"></i></i>' +
                                '<div class="dropdown-menu hold-on-click dropdown-checkboxes" role="menu">' +
                                '<label ng-repeat="column in vm.areasManagementGrid.columns| filter: vm.gridColumnShowHideFilter">' +
                                '<input type="checkbox" checked="column.hidden" ng-click="vm.showHideColumn(column)"> {{column.title}}' +
                                '</label>' +
                                '</div></div>'
                        }
                    ],
                    dataSource: {
                        serverPaging: true,
                        schema: {
                            total: function (response) {
                                vm.count = response.total;
                                $scope.$apply();
                                return response.total;
                            },
                            data: function (response) {
                                $scope.$apply();
                                if (response.data.length == 0) {
                                    vm.areasManagementCreateTT.parentName = null;
                                    vm.areasManagementCreateTT.parentId = null;
                                }
                                if (response.data.length > 0 && vm.check === false) {
                                    vm.areasManagementCreateTT.parentName = response.data[0].areaCode;
                                    vm.areasManagementCreateTT.parentId = response.data[0].id;
                                    vm.check = true;

                                }
                                if (response.data.length > 0) {
                                    vm.dulieu = response.data[0];
                                }
                                return response.data;
                            },
                        },
                        transport: {
                            read: {
                                // Thuc hien viec goi service
                                url: Constant.BASE_SERVICE_URL + "areaService/area/doSearch",
                                contentType: "application/json; charset=utf-8",
                                type: "POST"
                            },
                            parameterMap: function (options, type, data) {
                                vm.areasManagementSearch.page = options.page
                                vm.areasManagementSearch.pageSize = options.pageSize
                                return JSON.stringify(vm.areasManagementSearch)
                            }
                        },
                        pageSize: 5
                    },
                    noRecords: true, // trạng thái ko có kết quả thì trả về 1 thông báo là getString
                    messages: {
                        noRecords: gettextCatalog.getString("Không có kết quả hiển thị") // dịch theo tiếng mà thứ tiếng mình định nghĩa
                    },
                    pageable: {
                        refresh: false,
                        pageSizes: [5, 10, 15, 20,25],
                        messages: {
                            display: "{0}-{1} của {2} kết quả",
                            itemsPerPage: "kết quả/trang",
                            empty: "Không có kết quả hiển thị"
                        }
                    },

                    columns: [
                        {
                            title: gettextCatalog.getString("TT"),
                            field: "stt",
                            // cong thuc tinh so luong
                            template: dataItem => vm.areasManagementGrid.dataSource.indexOf(dataItem) + 1 +
                                (vm.areasManagementGrid.dataSource._page - 1) * vm.areasManagementGrid.dataSource._pageSize,
                            width: '5%',
                            headerAttributes: {
                                style: "text-align:center; font-weight:Bold;",
                            },
                            attributes: {
                                style: "text-align:center;"
                            },
                        },
                        {
                            title: "Mã đơn vị",
                            field: 'areaCode',
                            width: '20%',
                            headerAttributes: {
                                style: "text-align:center;font-weight:Bold;"
                            },
                            attributes: {
                                style: "text-align:center;"
                            },
                        },
                        {
                            title: "Tên đơn vị",
                            field: 'areaName',
                            width: '20%',
                            headerAttributes: {
                                style: "text-align:center;font-weight:Bold;"
                            },
                            attributes: {
                                style: "text-align:center;"
                            },
                        },
                        {
                            title: "Đơn vị cha",
                            field: 'parentName',
                            width: '20%',
                            headerAttributes: {
                                style: "text-align:center;font-weight:Bold;"
                            },
                            attributes: {
                                style: "text-align:center;"
                            },
                        },

                        {
                            title: "Trạng thái",
                            field: 'status',
                            width: '15%',
                            template:
                                "# if(status == 1){ #" + "#= 'Hoạt động' #" + "# } " +
                                "else if (status == 0) { # " + "#= 'Không hoạt động' #" + "#} " +
                                "#",
                            headerAttributes: {
                                style: "text-align:center;font-weight:Bold;"
                            },
                            attributes: {
                                style: "text-align:center;"
                            },

                        }, {
                            title: "Thao tác",
                            field: "actionss",
                            template: dataItem =>
                                '	<div class="text-center #=areasManagementId#"">' +
                                '		<a  type="button" class="#=areasManagementId# icon_table" uib-tooltip="Cập nhật đơn vị" translate> ' +
                                '			<i class="fa fa-pencil" ng-click=vm.edit(dataItem) aria-hidden="true"></i>' +
                                '		</a> ' +
                                '		<a  type="button" class="#=areasManagementId# icon_table" uib-tooltip="Xem danh sách trực thuộc" translate>' +
                                '			<i ng-click=vm.doSearchTT(dataItem) class="fa fa-search-plus" aria-hidden="true"></i> ' +
                                '		</a> ' +
                                '		<a type="button" class="#=areasManagementId# icon_table" uib-tooltip="Xóa" translate >' +
                                '			<i class="fa fa-trash" ng-click=vm.remove(dataItem) aria-hidden="true" style="color:red;"></i>' +
                                '		</a>' +
                                '	</div>',
                            width: '20%',
                            headerAttributes: {
                                style: "text-align:center;font-weight:Bold;"
                            },
                        }]

                });
            }

            function fillDataTableAreaTT(data) {
                vm.gridOptionsTT = kendoConfig.getGridOptions({
                    autoBind: true, // khi có sự thay đổi thì cái autoBind tự động thay đổi( tự map tới nguồn dữ liệu)
                    sortable: false, // sắp xếp theo cột
                    resizable: true, // thay đổi kích thước cột bằng cách kéo tay
                    columnMenu: false, // ẩn menu cột theo tuỳ chọn
                    toolbar: [  // hiện thị theo hàng giống thanh công cụ
                        {
                            name: "actions",
                            template: '<div class="pull-left">' +
                                '<a class="btn btn-qlk padding-search-right addQLK"' +
                                'ng-click="vm.addTT()" uib-tooltip="Thêm mới" translate><p class="action-button add" aria-hidden="true">Tạo mới</p></a>' +
                                '</div>'
                                +
                                '<div class="btn-group pull-right margin_top_button margin_right10">' +
                                '<i data-toggle="dropdown" aria-expanded="false"><i class="fa fa-cog" aria-hidden="true"></i></i>' +
                                '<div class="dropdown-menu hold-on-click dropdown-checkboxes" role="menu">' +
                                '<label ng-repeat="column in vm.areasTTManagementGrid.columns| filter: vm.gridColumnShowHideFilter">' +
                                '<input type="checkbox" checked="column.hidden" ng-click="vm.showHideColumn(column)"> {{column.title}}' +
                                '</label>' +
                                '</div></div>'

                        }
                    ],
                    dataBound: function (e) {
                    },
                    dataSource: {
                        serverPaging: true, // nếu là true thì nguồn dữ liệu phân trang theo server còn false thì nguồn dữ liệu phân trang theo máy khách
                        schema: {
                            total: function (response) {
                                vm.countTT = response.total;
                                $scope.$apply();
                                return response.total;
                            },
                            data: function (response) {
                                $scope.$apply();
                                if (response.data.length > 0) {
                                    vm.areasManagementSearchTT.id = response.data[0].parentId;
                                    vm.areasManagementCreateTT.parentName = response.data[0].parentName;
                                    vm.areasManagementCreateTT.parentId = response.data[0].parentId;
                                    vm.areasManagementCreateTT.id = response.data[0].id;
                                    vm.check = true;
                                } else {
                                    vm.check = false;
                                }
                                return response.data;
                            },
                        },
                        transport: {
                            read: {
                                url: Constant.BASE_SERVICE_URL + "areaService/area/doSearchTT",
                                contentType: "application/json; charset=utf-8",
                                type: "POST"
                            },
                            parameterMap: function (options, type) {
                                vm.areasManagementSearchTT.page = options.page
                                vm.areasManagementSearchTT.pageSize = options.pageSize
                                return JSON.stringify(vm.areasManagementSearchTT)
                            }
                        },
                        pageSize: 5
                    },
                    noRecords: true, // trạng thái ko có kết quả thì trả về 1 thông báo là getString
                    messages: {
                        noRecords: gettextCatalog.getString("Không có kết quả hiển thị") // dịch theo tiếng mà thứ tiếng mình định nghĩa
                    },
                    pageable: {
                        refresh: false,
                        pageSizes: [5, 10, 15, 20],
                        messages: {
                            display: "{0}-{1} của {2} kết quả",
                            itemsPerPage: "kết quả/trang",
                            empty: "Không có kết quả hiển thị"
                        }
                    },

                    columns: [
                        {
                            title: gettextCatalog.getString("TT"),
                            field: "stt",
                            // template: dataItem => vm.areasTTManagementGrid.dataSource.indexOf(dataItem) + 1 +
                            //     (vm.areasTTManagementGrid.dataSource._page - 1) * vm.areasTTManagementGrid.dataSource._pageSize,
                            template: dataItem => vm.areasManagementGrid.dataSource.indexOf(dataItem) + 1 +
                        (vm.areasManagementGrid.dataSource._page - 1) * vm.areasManagementGrid.dataSource._pageSize,
                            width: "5%",
                            headerAttributes: {
                                style: "text-align:center; font-weight:Bold;",
                            },
                            attributes: {
                                style: "text-align:center;"
                            },
                        },
                        {
                            title: "Mã đơn vị",
                            field: 'areaCode',
                            width: "20%",
                            headerAttributes: {
                                style: "text-align:center;font-weight:Bold;"
                            },
                            attributes: {
                                style: "text-align:center;"
                            },
                        },
                        {
                            title: "Tên đơn vị",
                            field: 'areaName',
                            width: '20%',
                            headerAttributes: {
                                style: "text-align:center;font-weight:Bold;"
                            },
                            attributes: {
                                style: "text-align:center;"
                            },
                        },
                        {
                            title: "Đơn vị cha",
                            field: 'parentName',
                            width: '20%',
                            headerAttributes: {
                                style: "text-align:center;font-weight:Bold;"
                            },
                            attributes: {
                                style: "text-align:center;"
                            },
                        },
                        {
                            title: "Trạng thái",
                            field: 'status',
                            width: '15%',
                            template:
                                "# if(status == 1){ #" + "#= 'Hoạt động' #" + "# } " +
                                "else if (status == 0) { # " + "#= 'Không hoạt động' #" + "#} " +
                                "#",
                            headerAttributes: {
                                style: "text-align:center;font-weight:Bold;"
                            },
                            attributes: {
                                style: "text-align:center;"
                            },

                        }, {
                            title: "Thao tác",
                            field: "actionss",
                            template: dataItem =>
                                '	<div class="text-center #=areasManagementId#"">' +
                                '		<a  type="button" class="#=areasManagementId# icon_table" uib-tooltip="Cập nhật đơn vị" translate> ' +
                                '			<i class="fa fa-pencil" ng-click=vm.edit(dataItem) aria-hidden="true"></i>' +
                                '		</a> ' +
                                '		<a type="button" class="#=areasManagementId# icon_table" uib-tooltip="Xóa" translate >' +
                                '			<i class="fa fa-trash" ng-click=vm.remove(dataItem) aria-hidden="true" style="color:red;"></i>' +
                                '		</a>' +
                                '	</div>',
                            width: '20%',
                            headerAttributes: {
                                style: "text-align:center;font-weight:Bold;"
                            },
                        }]
                });
            }


            vm.add = function add(da) {
                vm.isCreateNew = true;
                vm.areasManagementCreate = {};
                if (da == undefined) {
                    vm.areasManagementCreate.parentName = null;
                } else {
                    vm.areasManagementCreate.parentName = da.paren;
                    vm.areasManagementCreate.parentId = da.id;
                    vm.areasManagementCreate.idcheck = da.id;
                }
                let teamplateUrl = "qlan/areaManagement/areasManagementPopup.html";
                let title = "Thêm mới đơn vị";
                let windowId = "areasManagement";
                CommonService.populatePopupCreate(teamplateUrl, title, vm.areasManagementCreate, vm, windowId, false, '70%', '45%');

            }
            vm.checkHide = false;
            vm.addTT = function addTT() {
                let da = {};
                da.paren = vm.areasManagementCreateTT.parentName;
                da.id = vm.areasManagementCreateTT.parentId;
                da.idto = vm.areasManagementCreateTT.id;
                vm.add(da);
                vm.isCreateNew = false;
                vm.checkHide = true;
            }

            vm.checkEdit = {}

            vm.edit = function edit(dataItem) {
                vm.isCreateNew = false;
                vm.checkHide = false;
                vm.areasManagementEditTT.id = dataItem.id;
                vm.areasManagementEditTT.areaCode = dataItem.areaCode;
                vm.areasManagementEditTT.areaName = dataItem.areaName;
                vm.areasManagementEditTT.parentName = dataItem.parentName;
                vm.areasManagementEditTT.parentId = dataItem.parentId;
                vm.areasManagementEditTT.status = dataItem.status;
                vm.areasManagementCreate = vm.areasManagementEditTT;
                let teamplateUrl = "qlan/areaManagement/areasManagementPopup.html";
                let title = "Cập nhật đơn vị";
                let windowId = "areasManagement"
                CommonService.populatePopupCreate(teamplateUrl, title, vm.areasManagementCreate, vm, windowId, false, '70%', '45%');
            }

            vm.remove = function remove(dataItem) {
                confirm('Xác nhận xóa',
                    function (d) {
                        startLoading();
                        areasManagementService.remove(dataItem).then(function (result) {
                            stopLoading();
                            if (result.error) {
                                toastr.error(result.error)
                                return;
                            }
                            toastr.success("Xóa chức năng thành công!");
                            openDepartment();
                            let currentPage = vm.areasManagementGrid.dataSource.page();
                            let dataSize = vm.areasManagementGrid.dataSource.data().length;
                            if (currentPage > 1 && dataSize == 1) {
                                vm.areasManagementGrid.dataSource.page(currentPage - 1);
                            } else {
                                vm.areasManagementGrid.dataSource.page(currentPage);
                            }
                            let currentPageTT = vm.areasTTManagementGrid.dataSource.page();
                            let dataSizeTT = vm.areasTTManagementGrid.dataSource.data().length;
                            if (currentPageTT > 1 && dataSizeTT == 1) {
                                vm.areasTTManagementGrid.dataSource.page(currentPageTT - 1);
                            } else {
                                vm.areasTTManagementGrid.dataSource.page(currentPageTT);
                            }
                        }, function (errResponse) {
                            stopLoading();
                            if (errResponse.data) {
                                toastr.error(errResponse.statusText);
                            } else {
                                toastr.error(gettextCatalog.getString("Xảy ra lỗi khi cập nhật trạng thái"));
                            }
                        });
                    })
            }
            vm.cancelPopup = function cancelPopup(){
                doSearch();
                CommonService.dismissPopup();
            }

            vm.save = function save() {
                startLoading();
                if (vm.isCreateNew || vm.checkHide) {
                    if (vm.areasManagementCreate.idcheck === vm.areasManagementCreate.parentId || vm.areasManagementCreate.idcheck === undefined) {
                        areasManagementService.addAreas(vm.areasManagementCreate).then(function (result) {
                            stopLoading();
                            if (result.error) {
                                toastr.error(result.error);
                                return;
                            }
                            toastr.success("Thêm mới thành công!");
                            openDepartment();
                            if (vm.checkHide) {
                                doSearchTT(vm.dulieu);
                            } else {
                           //     doSearch();
                            }
                            doSearch();
                            CommonService.dismissPopup();
                        }, function (errResponse) {
                            stopLoading();
                            if (errResponse.data) {
                                toastr.error(errResponse.data.errorMessage);
                            } else {
                                toastr.error(gettextCatalog.getString("Lỗi xuất hiện khi tạo mới người dùng!"));
                            }
                        });
                    } else {
                        stopLoading();
                        toastr.error(gettextCatalog.getString("Xảy ra lỗi khi cập nhật"));
                        CommonService.dismissPopup();
                    }
                } else {
                    areasManagementService.updateAreas(vm.areasManagementCreate).then(function (result) {
                        stopLoading();
                        if (result.error) {
                            toastr.error(result.error);
                            return;
                        }
                        toastr.success("Cập nhật thành công!");
                        openDepartment();
                        if (!vm.checkHide) {
                            doSearchTT(vm.dulieu);
                        } else {
                         //   doSearch();
                        }
                        doSearch();
                        CommonService.dismissPopup();
                    }, function (errResponse) {
                        stopLoading();
                        if (errResponse.data) {
                            toastr.error(errResponse.data.errorMessage);
                        } else {
                            toastr.error(gettextCatalog.getString("Xảy ra lỗi khi cập nhật"));
                        }
                    });
                }
            }

            vm.showHideColumn = function (column) {
                if (angular.isUndefined(column.hidden)) {
                    vm.areasManagementGrid.hideColumn(column);
                    vm.areasTTManagementGrid.hideColumn(column);
                } else if (column.hidden) {
                    vm.areasManagementGrid.showColumn(column);
                    vm.areasTTManagementGrid.showColumn(column);
                } else {
                    vm.areasManagementGrid.hideColumn(column);
                    vm.areasTTManagementGrid.hideColumn(column);
                }
            }

            vm.gridColumnShowHideFilter = function (item) {
                return item.type == null || item.type != 1;
            };

        }])
})();