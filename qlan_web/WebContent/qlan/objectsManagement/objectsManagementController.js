(function() {
    'use strict';
    var controllerId = 'objectsManagementController';

    angular.module('MetronicApp').controller(controllerId, objectsManagementController);

    function objectsManagementController($scope, $rootScope, $timeout, gettextCatalog,
                                       kendoConfig, $kWindow,objectsManagementService,
                                       CommonService, PopupConst, Restangular, RestEndpoint,Constant) {
        var vm = this;
        vm.caller = vm;
        vm.showSearch = true;
        vm.isCreateNew = false;
        vm.showDetail = false;
        vm.options =[0];
        vm.removeItem=removeItem;
        vm.objectsManagementSearch={
            status: null,
       		objectTypeId: null,
//             deptId:null
        };
        vm.objectsManagementCreate={
            status: 2,
            objectTypeId: 2,
            // parentName: "",
            // parentId: 0
            ord: Object,
        };

        vm.objectsManagementCreate2={
        };
        vm.objectsManagement={};
        vm.validatorOptions = kendoConfig.get('validatorOptions');
        initFormData();
        function initFormData() {
            fillDataTable([]);
            //getParent();
        }

        vm.commonSearch={name: '', code: ''};

        vm.headerTemplate='<div class="dropdown-header row text-center k-widget k-header">' +
            '<p class="col-md-6 text-header-auto border-right-ccc">Mã</p>' +
            '<p class="col-md-6 text-header-auto border-right-ccc">Tên</p>' +
            '</div>';
        vm.template='<div class="row"><div class="col-xs-5" style="padding: 0px 32px 0px 0px; float:left">#: data.objectCode #</div>' +
            '<div style="padding-left: 10px,width:auto;overflow:hidden;text-align: right;">#: data.objectName #</div></div>';
        vm.status = [
            {id:0,name:'Bị khóa'},
            {id:1,name:'Hoạt động'}
        ];
        vm.statusSelectOptions = {
            dataSource: vm.status,
            dataTextField: "name",
            dataValueField: "id",
            optionLabel: "---Chọn---",
            valuePrimitive: true
        }
        vm.objectTypeId = [
            {id:0,name:'Module'},
            {id:1,name:'Component'},
        ];
        vm.objectTypeIdSelectOptions = {
            dataSource: vm.objectTypeId,
            dataTextField: "name",
            dataValueField: "id",
            optionLabel: "---Chọn---",
            valuePrimitive: true
        }

        vm.doSearch= doSearch;
        function doSearch(){
            //debugger
            vm.showDetail = false;
            var grid =vm.objectsManagementGrid;
            if(grid){
                grid.dataSource.query({
                    page: 1,
                    pageSize: 10
                });
            }
        }


        function fillDataTable(data) {
            vm.gridOptions = kendoConfig.getGridOptions({
                autoBind: true,
                sortable: false,
                resizable: true,
                columnMenu: false,
                toolbar: [
                    {
                        name: "actions",
                        template: '<div class=" pull-left ">'+
                            '<a class="btn btn-qlk padding-search-right addQLK"'+
                            'ng-click="vm.add()" uib-tooltip="Thêm mới" translate><p class="action-button add" aria-hidden="true">Thêm mới</p></a>'+
                            '</div>'+
                            '<div class="btn-group pull-right margin_top_button margin_right10" uib-tooltip="Cài đặt danh sách">'+
                            '<i data-toggle="dropdown" aria-expanded="false"><i class="fa fa-cog" aria-hidden="true"></i></i>'+
                            '<div class="dropdown-menu hold-on-click dropdown-checkboxes" role="menu">'+
                            '<label ng-repeat="column in vm.objectsManagementGrid.columns| filter: vm.gridColumnShowHideFilter">'+
                            '<input type="checkbox" checked="column.hidden" ng-click="vm.showHideColumn(column)"> {{column.title}}'+
                            '</label>'+
                            '</div></div>'

                    }
                ],
                dataBound: function (e) {
                },
                dataSource:{
                    serverPaging: true,
                    schema: {
                        total: function (response) {
                            vm.count = response.total;
                            return response.total;
                        },
                        data: function (response) {
                            return response.data;
                        },
                    },
                    transport: {
                        read: {
                            // Thuc hien viec goi service
                            url: Constant.BASE_SERVICE_URL + "objectsService/objects/doSearch",
                            contentType: "application/json; charset=utf-8",
                            type: "POST"
                        },
                        parameterMap: function (options, type) {
                           // debugger;
                            vm.objectsManagementSearch.page = options.page
                            vm.objectsManagementSearch.pageSize = options.pageSize
                            return JSON.stringify(vm.objectsManagementSearch)
                        }
                    },
                    pageSize: 10
                },
                noRecords: true,
                messages: {
                    noRecords : gettextCatalog.getString("Không có kết quả hiển thị")
                },
                pageable: {
                    refresh: false,
                    pageSizes: [10, 15, 20, 25],
                    messages: {
                        display: "{0}-{1} của {2} kết quả",
                        itemsPerPage: "kết quả/trang",
                        empty: "Không có kết quả hiển thị"
                    }
                },

                columns: [
                     {
                        title: gettextCatalog.getString("TT"),
                        field:"stt",
                        template: dataItem =>vm.objectsManagementGrid.dataSource.indexOf(dataItem) + 1+
                            (vm.objectsManagementGrid.dataSource._page -1 ) *vm.objectsManagementGrid.dataSource._pageSize ,
                        width: 30,
                        headerAttributes: {
                            style: "text-align:center; font-weight:Bold;",
                        },
                        attributes: {
                            style: "text-align:right;"
                        },
                    },
                    {
                        title: "Mã chức năng",
                        field: 'objectCode',
                        width: 130,
                        headerAttributes: {
                            style: "text-align:center;font-weight:Bold;"
                        },
                        attributes: {
                            style: "text-align:left;"
                        },
                    },
                    {
                        title: "Tên chức năng",
                        field: 'objectName',
                        width: 130,
                        headerAttributes: {
                            style: "text-align:center;font-weight:Bold;"
                        },
                        attributes: {
                            style: "text-align:left;"
                        },
                    },
                    {
                        title: "Chức năng cha",
                        field: 'parentName',
                        width: 130,
                        headerAttributes: {
                            style: "text-align:center;font-weight:Bold;"
                        },
                        attributes: {
                            style: "text-align:left;"
                        },
                    },
                    {
                        title: "Đường dẫn",
                        field: 'objectUrl',
                        width: 130,
                        headerAttributes: {
                            style: "text-align:center;font-weight:Bold;"
                        },
                        attributes: {
                            style: "text-align:left;"
                        },
                    },
                    {
                        title: "Loại chức năng",
                        field: 'objectTypeId',
                        width: 90,
                        template :
                            "# if(objectTypeId == 0){ #" + "#= 'Module' #" + "# } " +
                            "else if (objectTypeId == 1) { # " + "#= 'Component' #"+ "#} " +
                            "#",
                        headerAttributes: {
                            style: "text-align:center;font-weight:Bold;"
                        },
                        attributes: {
                            style: "text-align:left;"
                        },
                    },
                    {
                        title: "Thứ tự",
                        field: 'ord',
                        width: 80,
                        headerAttributes: {
                            style: "text-align:center;font-weight:Bold;"
                        },
                        attributes: {
                            style: "text-align:right;"
                        },
                    },
                    {
                        title: "Mô tả",
                        field: 'description',
                        width: 150,
                        headerAttributes: {
                            style: "text-align:center;font-weight:Bold;"
                        },
                        attributes: {
                            style: "text-align:left;"
                        },
                    },
                    {
                        title: "Trạng thái",
                        field: 'status',
                        width: 90,
                        template :
                            "# if(status == 1){ #" + "#= 'Hoạt động' #" + "# } " +
                            "else if (status == 0) { # " + "#= 'Bị khóa' #"+ "#} " +
                            "#",
                        headerAttributes: {
                            style: "text-align:center;font-weight:Bold;"
                        },
                        attributes: {
                            style: "text-align:left;"
                        },

                    },
                    {
                        title: "Thao tác",
                        template:dataItem =>
                            '	<div class="text-center #=objectsManagementId#"">'+
                            '		<a  type="button" class="#=objectsManagementId# icon_table" uib-tooltip="Cập nhật chức năng" translate style="border: 2px;"> '+
                            '			<i class="fa fa-pencil" ng-click=vm.edit(dataItem) aria-hidden="true" ></i>'+
                            '		</a> '+

                            '		<a  ng-if="dataItem.status==1" type="button" class="#=objectsManagementId# icon_table" uib-tooltip="Khóa chức năng" translate style="border: 2px;"> '+
                            '			<i class="fa fa-lock" ng-click=vm.lock(dataItem) aria-hidden="true" style="color: #ff0000;"></i>'+
                            '		</a> '+

                            '		<a  ng-if="dataItem.status==0"  type="button" class="#=objectsManagementId# icon_table" uib-tooltip="Mở khóa chức năng" translate style="border: 2px;"> '+
                            '			<i class="fa fa-unlock" ng-click=vm.unlock(dataItem) aria-hidden="true" ></i>'+
                            '		</a> '+

                            '		<a type="button" class="#=objectsManagementId# icon_table" uib-tooltip="Xóa chức năg" translate style="border: 2px">'+
                            '			<i class="fa fa-trash" ng-click=vm.remove(dataItem) aria-hidden="true" style="color:#46841f;"></i>'+
                            '		</a>'+
                            '	</div>',
                        width: 120,
                        field:"actionss",
                        headerAttributes: {
                            style: "text-align:center;font-weight:Bold;"
                        },
                    }]
            });
        }
        vm.add = function add(){
            vm.isCreateNew = true;
            vm.objectsManagementCreate = {};
            var teamplateUrl="qlan/objectsManagement/objectsManagementPopup.html";
            var title="Thêm mới Chức năng";
            var windowId="objectsManagement";
            CommonService.populatePopupCreate(teamplateUrl,title,{},vm,windowId,true,'80%','60%');
        }

        vm.edit = function edit(dataItem){
            vm.isCreateNew = false;
            vm.objectsManagementCreate2.objectId = dataItem.objectId;
            vm.objectsManagementCreate2.objectCode = dataItem.objectCode;
            vm.objectsManagementCreate2.objectName = dataItem.objectName;
            vm.objectsManagementCreate2.parentName = dataItem.parentName;
            vm.objectsManagementCreate2.objectUrl = dataItem.objectUrl;
            vm.objectsManagementCreate2.ord = dataItem.ord;
            vm.objectsManagementCreate2.description = dataItem.description;
            vm.objectsManagementCreate2.objectTypeId = dataItem.objectTypeId;
            vm.objectsManagementCreate2.status = dataItem.status;

            vm.objectsManagementCreate.objectId = vm.objectsManagementCreate2.objectId;
            vm.objectsManagementCreate.objectCode = vm.objectsManagementCreate2.objectCode;
            vm.objectsManagementCreate.objectName = vm.objectsManagementCreate2.objectName;
            vm.objectsManagementCreate.parentName = vm.objectsManagementCreate2.parentName;
            vm.objectsManagementCreate.objectUrl = vm.objectsManagementCreate2.objectUrl;
            vm.objectsManagementCreate.ord = vm.objectsManagementCreate2.ord;
            vm.objectsManagementCreate.description = vm.objectsManagementCreate2.description;
            vm.objectsManagementCreate.objectTypeId = vm.objectsManagementCreate2.objectTypeId;
            vm.objectsManagementCreate.status = vm.objectsManagementCreate2.status;

            vm.disableParentName = false;
            var teamplateUrl="qlan/objectsManagement/objectsManagementPopup.html";
            var title="Cập nhật Chức năng";
            var windowId="objectsManagement"
            CommonService.populatePopupCreate(teamplateUrl,title,vm.objectsManagementCreate,vm,windowId,false,'80%','60%');
        }


        vm.cancelPopup = function cancelPopup(){
            //startLoading();
            doSearch();
            CommonService.dismissPopup();
        }
        vm.ValidateNumber = function (input) {
            if (input != "" && null != input) {
                let value = input;
                let ch= /[a-zA-ZẠ-ỹáàạảãâấầậẩẫăắằặẳẵÁÀẠẢÃÂẤẦẬẨẪĂẮẰẶẲẴéèẹẻẽêếềệểễÉÈẸẺẼÊẾỀỆỂỄóòọỏõôốồộổỗơớờợởỡÓÒỌỎÕÔỐỒỘỔỖƠỚỜỢỞỠúùụủũưứừựửữÚÙỤỦŨƯỨỪỰỬỮíìịỉĩÍÌỊỈĨđĐýỳỵỷỹÝỲỴỶỸ!@#$%^&*()+\=\[\]{};':"_\\|,.<>\-\\/?]/;
                let check = ch.test(value);
                return !check;
            }
            return true;
        },
            vm.tam = Object,
        vm.save= function save(){
            startLoading();
            if(vm.isCreateNew==true) {
                vm.tam = vm.objectsManagementCreate.ord;
                if(vm.ValidateNumber(vm.tam)==false){
                    vm.objectsManagementCreate.ord = -1;
                }
                objectsManagementService.createobjectsManagement(vm.objectsManagementCreate).then(function(result){

                    stopLoading();
                    if(result.error){
                        vm.objectsManagementCreate.ord = null;
                        toastr.error(result.error);
                        return;
                    }

                    toastr.success("Thêm mới thành công!");
                    doSearch();
                    CommonService.dismissPopup();
                }, function(errResponse){

                    stopLoading();
                    if (errResponse.data) {
                        toastr.error(errResponse.data.errorMessage);
                    } else {
                        toastr.error(gettextCatalog.getString("Lỗi xuất hiện khi tạo mới chức năng!"));
                    }
                });
            } else {
                if (vm.objectsManagementCreate.objectId == 200 && vm.objectsManagementCreate.status==0){
                    stopLoading();
                    toastr.error(gettextCatalog.getString("Không khóa chức năng Quản lý Chức Năng"));
                    vm.objectsManagementCreate.status=1;
                    return ;
                }
                vm.tam = vm.objectsManagementCreate.ord;
                if(vm.ValidateNumber(vm.tam)==false){
                    vm.objectsManagementCreate.ord = -1;
                }
                objectsManagementService.updateobjectsManagement(vm.objectsManagementCreate).then(function(result){
                    stopLoading();
                    if(result.error){
                        vm.objectsManagementCreate.ord = null;
                        toastr.error(result.error);
                        return;
                    }
                    toastr.success("Cập nhật thành công!");
                    doSearch();
                    CommonService.dismissPopup();
                }, function(errResponse){
                    stopLoading();
                    if (errResponse.data) {
                        toastr.error(errResponse.data.errorMessage);
                    } else {
                        toastr.error(gettextCatalog.getString("Xảy ra lỗi khi cập nhật"));
                    }
                });
            }

        }

        vm.remove = function remove(data)
        {
            vm.objectsManagementCreate =data;
            confirm('Bạn có chắc chắn muốn xóa không',function (d){
                startLoading();
                if (vm.objectsManagementCreate.objectId == 200){
                    stopLoading();
                    toastr.error(gettextCatalog.getString("Không xóa chức năng Quản lý Chức Năng"));
                    $('#objectsManagementGrid').data('kendo-grid').dataSource.read();
                    $('#objectsManagementGrid').data('kendo-grid').refresh();
                    return ;
                }
                objectsManagementService.remove(vm.objectsManagementCreate).then(function(result){
                    stopLoading();
                    if(result.error){
                        toastr.error(result.error);
                        $('#objectsManagementGrid').data('kendo-grid').dataSource.read();
                        $('#objectsManagementGrid').data('kendo-grid').refresh();
                        return ;
                    }
                    toastr.success("Bản ghi được xóa!");
                    doSearch();
                    var currentPage = vm.objectsManagementGrid.dataSource.page();
                    var dataSize = vm.objectsManagementGrid.dataSource.data().length;
                    if (currentPage > 1 && dataSize==1 ) {
                        vm.objectsManagementGrid.dataSource.page(currentPage - 1);
                    } else {
                        vm.objectsManagementGrid.dataSource.page(currentPage);
                    }

                }, function(errResponse){
                    stopLoading();
                    if (errResponse.data) {
                        toastr.error(errResponse.data.errorMessage);
                    } else {
                        toastr.error(gettextCatalog.getString("Xảy ra lỗi khi cập nhật trạng thái"));
                    }
                });
            });
        }

        vm.lock = function lock(data)
        {
            vm.objectsManagementCreate =data;
            confirm('Xác nhận khóa',function (d){
                startLoading();
                if (vm.objectsManagementCreate.objectId == 200){
                    stopLoading();
                    toastr.error(gettextCatalog.getString("Không khóa chức năng Quản lý Chức Năng"));
                    return ;
                }
                objectsManagementService.lock(vm.objectsManagementCreate).then(function(result){
                    stopLoading();
                    if(result.error){
                        toastr.error(result.error);
                        $('#objectsManagementGrid').data('kendo-grid').dataSource.read();
                        $('#objectsManagementGrid').data('kendo-grid').refresh();
                        return ;
                    }
                    toastr.success("Khóa chức năng thành công!");
                    $('#objectsManagementGrid').data('kendo-grid').dataSource.read();
                    $('#objectsManagementGrid').data('kendo-grid').refresh();
                }, function(errResponse){
                    stopLoading();
                    if (errResponse.data) {
                        toastr.error(errResponse.data.errorMessage);
                    } else {
                        toastr.error(gettextCatalog.getString("Xảy ra lỗi khi cập nhật trạng thái"));
                    }
                });
            });
        }

        vm.unlock = function unlock(data)
        {
            vm.objectsManagementCreate =data;
            confirm('Xác nhận mở khóa',function (d){
                startLoading();
                objectsManagementService.unlock(vm.objectsManagementCreate).then(function(result){
                    stopLoading();
                    if(result.error){
                        toastr.error(result.error)
                        return ;
                    }
                    toastr.success("Mở khóa chức năng thành công!");
                    $('#objectsManagementGrid').data('kendo-grid').dataSource.read();
                    $('#objectsManagementGrid').data('kendo-Grid').refresh();
                    // var currentPage = vm.objectsManagementGrid.dataSource.page();
                    // var dataSize = vm.objectsManagementGrid.dataSource.data().length;
                    // if (currentPage > 1 && dataSize==1 ) {
                    //     vm.objectsManagementGrid.dataSource.page(currentPage - 1);
                    // } else {
                    //     vm.objectsManagementGrid.dataSource.page(currentPage);
                    // }

                }, function(errResponse){
                    stopLoading();
                    if (errResponse.data) {
                        toastr.error(errResponse.data.errorMessage);
                    } else {
                        toastr.error(gettextCatalog.getString("Xảy ra lỗi khi cập nhật trạng thái"));
                    }
                });
            });
        }


        vm.showHideColumn=function(column){
            if (angular.isUndefined(column.hidden)) {
                vm.objectsManagementGrid.hideColumn(column);
            } else if (column.hidden) {
                vm.objectsManagementGrid.showColumn(column);
            } else {
                vm.objectsManagementGrid.hideColumn(column);
            }
        }
    }
})();