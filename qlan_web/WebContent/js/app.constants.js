(function() {
	'use strict';

	angular.module('MetronicApp').constant('Constant', Config());

	/* @ngInject */
	function Config() {
		var config = {};

		/***********************************************************************
		 * HTTP STATUS
		 **********************************************************************/
		config.http = {
			SUCCESS : 0,
			ERROR : 1,
			BUSINESS_ERROR : 400
		};
				config.pageSize = 20;
				config.pageSizes = [ 10, 15, 20, 25 ];

				/**
				 * Thêm cấu hình các white list url không cần add version
				 */
				config.LIST_WHITE_LIST_VERSION_URL = [
						"template/tabs/tab.html", "template/tabs/tabset.html",
						"template/tooltip/tooltip-html-popup.html" ],
				config.inWhiteListAddVersion = function(url) {
					if (url.startsWith(config.BASE_SERVICE_URL)) {
						return true;
					}
					if (url.startsWith('template/')) {
						return true;
					}
					if (url.indexOf('?tsVersion=')) {
						return true;
					}
					for ( var str in config.LIST_WHITE_LIST_VERSION_URL) {
						if (url
								.indexOf(config.LIST_WHITE_LIST_VERSION_URL[str]) >= 0) {
							return true;
						}
					}
				}

		config.ROLE_ID = {
			employee_roleID_CDT_PTGST : 102,// 4 - RoleID 102
			employee_roleID_CDT_DDPN : 103,// 2 - RoleID 103
			employee_roleID_DT_KTTC : 104,// 5 - RoleID 104
			employee_roleID_DT_GDNT : 105,// 3 - RoleID 105
			employee_roleID_DT_PTTC : 106,// 1 - RoleID 106
			employee_roleID_TVTK_DDTV : 107,// 6 - RoleID 107
			employee_roleID_TVTK_CNTK : 108,// 7 - RoleID 108
			employee_roleID_TVGS_GSTC : 109, // 0 - RoleID 109
			employee_roleID_TVGS_PTGST : 110,// 8 - RoleID 110
			employee_roleID_TVGS_DDTVGS : 111,// 9 - RoleID 111
			employee_roleID_CDT_GSTC : 101,// 10 - RoleID 101
			employee_roleID_CDT_DDDVSDCT : 112
		// 11 - RoleID 112
		}

		config.BASE_SERVICE_URL = '/qlan-service/';
		// config.FILE_SERVICE = 'fileservice/uploadATTT';
		// config.DOWNLOAD_SERVICE =
		// '/ktts-service/fileservice/downloadFileATTT?';
		config.FILE_SERVICE_TEMP = 'fileservice/uploadTemp';
		// config.UPLOAD_RS_SERVICE='fileUpload/uploadATTT';
		config.UPLOAD_RS_SERVICE = 'fileservice/uploadATTT';
		config.FILE_SERVICE = 'fileservice/uploadATTT';
		config.DOWNLOAD_SERVICE = API_URL + 'fileservice/downloadFileATTT?';
		config.DOWNLOAD_SERVICE2 = API_URL + 'fileservice/downloadFileATTT2?';
		config.contextPath = "qlan-web";
		config.prefixLanguage = 'js/languages/';
		config.loginUrl = 'authenServiceRest/login';
		config.getUser = function() {
			return this.user;
		}

		config.setUser = function(user) {
			this.user = user;
		}

		config.URL_POPUP = {
			DELETE_POPUP : 'qlan/popup/Delete_Popup.html',
			VOFICE_POPUP : 'qlan/popup/SignVofficePopup.html',
		}

		config.COLUMS_VALIDATE = {
			goods : [ {
				colum : 'Mã hàng',
				field : 'code',
				dataType : "Text"
			}, {
				colum : 'Tên hàng',
				field : 'name',
				dataType : "Text"
			}, {
				colum : 'Đơn vị tính',
				field : 'unit',
				dataType : "Text"
			}, {
				colum : 'Số lượng',
				field : 'qty',
				dataType : "Number"
			} ]
		};
		config.TEMPLATE_URL = [
				{
					key : 'DASH_BOARD',
					title : 'Trang chủ',
					templateUrl : 'qlan/dashbroad/dashbroad.html',
					lazyLoadFiles : [ 'qlan/dashbroad/DashbroadController.js', ]
				},
				{
					key : 'QLAN_ADMIN',
					title : 'Quản trị'
				},
				{
					key : 'QLAN_CHECK_LIST',
					title : 'Kiểm tra danh sách'
				},
				{
					key : 'QLAN_MNG_OC',
					title : 'Xử lý công văn'
				},
				{
					key : 'QLAN_UTILITIES',
					title : 'Tiện ích'
				},
				{
					key : 'QLAN_REPORT',
					title : 'Báo cáo'
				},
				{
					key : 'QLAN_MNG_USER',
					title : 'Quản lý người dùng',
					templateUrl : 'qlan/usersManagement/usersManagementList.html',
					lazyLoadFiles : [
							'qlan/usersManagement/usersManagementController.js',
							'qlan/usersManagement/usersManagementService.js', ]
				},
			{
				key : 'QLAN_MNG_AREAS',
				title : 'Quản lý đơn vị',
				templateUrl : 'qlan/areaManagement/areasManagementList.html',
				lazyLoadFiles : [
					'qlan/areaManagement/areasManagementController.js',
					'qlan/areaManagement/areasManagementService.js',]
			},

			{
				key: 'OBJECT_MANAGEMENT',
				title: 'Quản lý chức năng',
				templateUrl: 'qlan/objectsManagement/objectsManagementList.html',
				lazyLoadFiles: [
					'qlan/objectsManagement/objectsManagementController.js',
					'qlan/objectsManagement/objectsManagementService.js',]
			}
		];

		config.getTemplateUrl = function(key) {
			for ( var i in config.TEMPLATE_URL) {
				if (config.TEMPLATE_URL[i].key == key) {
					return config.TEMPLATE_URL[i];
				}
			}

			return null;
		}

		return config;
	}
	angular.module('MetronicApp').constant('PopupConst', {
		AcceptanceBList : {
			showPopup : 'showPopup'
		},

		CatEmployee : {
			PersonalEvaluation : 'PersonalEvaluation'
		},

		SalaryConfig : {
			adOrg : 'adOrg',
			bpartner : 'bpartner',
			payroll : 'payroll',
			budget : 'budget',
			budgetBHXH : 'budgetBHXH',
			budgetBHYT : 'budgetBHYT',
			budgetBHTN : 'budgetBHTN',
			budgetKPCD : 'budgetKPCD',
			costType : 'costType',
			costTypeOther : 'costTypeOther',
			costTypeBHXH : 'costTypeBHXH',
			costTypeBHYT : 'costTypeBHYT',
			costTypeBHTN : 'costTypeBHTN',
			costTypeKPCD : 'costTypeKPCD',
		},
		CRevaluation : {
			adOrg : 'adOrg',
			department : 'department',
			revenueTypeGain : 'revenueTypeGain',
			revenueTypeLoss : 'revenueTypeLoss',
			costTypeGain : 'costTypeGain',
			costTypeLoss : 'costTypeLoss',
			budgetGain : 'budgetGain',
			budgetLoss : 'budgetLoss',
			profitCenterGain : 'profitCenterGain',
			profitCenterLoss : 'profitCenterLoss',
			costCenterGain : 'costCenterGain',
			costCenterLoss : 'costCenterLoss',
			accountGain : 'accountGain',
			accountLoss : 'accountLoss',
		},
		ApRevaluation : {
			adOrg : 'adOrg',
			department : 'department',
			revenueTypeGain : 'revenueTypeGain',
			revenueTypeLoss : 'revenueTypeLoss',
			costTypeGain : 'costTypeGain',
			costTypeLoss : 'costTypeLoss',
			budgetGain : 'budgetGain',
			budgetLoss : 'budgetLoss',
			profitCenterGain : 'profitCenterGain',
			profitCenterLoss : 'profitCenterLoss',
			costCenterGain : 'costCenterGain',
			costCenterLoss : 'costCenterLoss',
			accountGain : 'accountGain',
			accountLoss : 'accountLoss',
		},
		ArRevenueType : {
			account : 'account',
			cDocumentType : 'cDocumentType'
		},
		InvReceiptPopup : {
			productPopup : 'productPopup'
		},
		OrgCommon : {
			adOrg : 'adOrg',
			assignAdOrg : 'assignAdOrg'
		},
		ArBankAccount : {
			cBank : 'cBank',
			propertyAccount : 'propertyAccount',
			overdraftAccount : 'overdraftAccount',
			cashInTransitAccount : 'cashInTransitAccount'
		},
		CWorkUnit : {
			adOrg : 'adOrg',
			parent : 'parent'
		},
		ArInvoice : {
			sale_region : 'sale_region',
			product : 'product',
			budget : 'budget',
			cost_type : 'cost_type',
			cost_center : 'cost_center',
			profit_center : 'profit_center',
			customer : 'customer',
			customer_rev : 'customer_rev',
			account_rev : 'account_rev',
			arInvoice : 'arInvoice',
			arInvoiceCr : 'arInvoiceCr',
			invoice : 'invoice',
			account : 'account',
			contract : 'contract',
			warehouse : 'warehouse',
			search_product : 'search_product'
		},
		ApAdvanceRequest : {
			paymentOrg : 'paymentOrg',
			copyStament : 'copyStament',
			copyDonvi : 'copyDonvi',
			copyTHTT : 'copyTHTT',
			copyPayroll : 'copyPayroll',
			viewPayroll : 'viewPayroll',
		},
		ApInvoice : {
			apInvoice : 'apInvoice',
			apInvoiceCr : 'apInvoiceCr',
			invoice : 'invoice'
		},
		ApBudgetGroup : {
			adOrg : 'adOrg'
		},
		ApStatementCategory : {
			adOrg : 'adOrg'
		},
		ApStatement : {
			adOrg : 'adOrg',
			assignAdOrg : 'assignAdOrg',
			cDepartment : 'cDepartment',
			cBPartner : 'cBPartner',
			parentStatement : 'parentStatement',
			contract : 'contract',
			project : 'project',
			copyStament : 'copyStament',
			buttonFrom : 'buttonFrom'
		},
		ApStatementLine : {
			cbudgetId : 'cbudgetId',
			cCostTypeId : 'cCostTypeId',
			PaymentScope : 'PaymentScope'
		},
		ApConstruction : {
			adOrg : 'adOrg',
			cConstructionGroup : 'cConstructionGroup',
			aAssert : 'aAssert',
			cProject : 'cProject',
			cContract : 'cContract',
			assignAdOrg : 'assignAdOrg',
		},
		ApConstructionGroup : {
			adOrg : 'adOrg'
		},
		ApConstructionPhase : {
			adOrg : 'adOrg',
			assignAdOrg : 'assignAdOrg',
			cConstructionGroup : 'cConstructionGroup',
		},
		ArTermsOfPayment : {
			adOrg : 'adOrg'
		},
		ArCashFlow : {
			adOrg : 'adOrg',
			parent : 'parent'
		},
		ArProduct : {
			adOrg : 'adOrg',
			uomId : 'uomId',
			productCat : 'productCategory'
		},
		ArBank : {
			location : 'location'
		},
		ArProductType : {
			adOrg : 'adOrg'
		},
		CBpartner : {
			group : 'group',
			bank : 'bank',
			vendor : 'vendor'
		},
		ArProductCategory : {
			adOrg : 'adOrg',
			productType : 'productType',
			warehouseType : 'warehouseType',
			parentId : 'parentId',
			roadAccountId : 'roadAccountId',
			mediateAccountId : 'mediateAccountId',
			cogsAccountId : 'cogsAccountId',
			incomeAccountId : 'incomeAccountId',
			costAccountId : 'costAccountId'
		},
		ArWarehouse : {
			adOrg : 'adOrg',
			department : 'department',
			locatorType : 'locatorType'
		},
		ArCBusinessArea : {
			adOrg : 'adOrg'
		},
		ArCTariff : {
			cTariffContractorType : 'cTariffContractorType',
		},
		ArCTask : {
			cTaskType : 'cTaskType',
			cDeclaredTask : 'cDeclaredTask'
		},
		ArCTax : {
			adOrg : 'adOrg',
			inputTaxAccount : 'inputTaxAccount',
			outputTaxAccount : 'outputTaxAccount',
			taxExpenseAccount : 'taxExpenseAccount',
			taxRevenueAccount : 'taxRevenueAccount'
		},
		ArCTaxGroup : {
			adOrg : 'adOrg',
			inputTaxAccount : 'inputTaxAccount',
			outputTaxAccount : 'outputTaxAccount',
			taxExpenseAccount : 'taxExpenseAccount',
			taxRevenueAccount : 'taxRevenueAccount',
			cCostType : 'cCostType'
		},
		ArCContract : {
			adOrg : 'adOrg',
			cDepartment : 'cDepartment',
			cPartner : 'cPartner',
			cProject : 'cProject',
			cStatement : 'cStatement',
			cSiteCodeInfo : 'cSiteCodeInfo',
			cBank : 'cBank'
		},
		ArLiabilitiesTransferred : {
			adOrg : 'adOrg',
			cDepartment : 'cDepartment',
			cAccountDr : 'cAccountDr',
			cAccountCr : 'cAccountCr',
			cBpartnerDr : 'cBpartnerDr',
			cBpartnerCr : 'cBpartnerCr'
		},
		ArUnpaid : {
			adOrg : 'adOrg',
			cDepartment : 'cDepartment',
			cAccountDr : 'cAccountDr',
			cAccountCr : 'cAccountCr',
			cBpartnerDr : 'cBpartnerDr',
			cBpartnerCr : 'cBpartnerCr'
		},
		ApBankPaymentBill : {
			adOrg : 'adOrg',
			cDepartment : 'cDepartment',
			cBankAccount : 'cBankAccount',
			cAdvanceRequest : 'cAdvanceRequest',
			cAdvanceRequestSearch : 'cAdvanceRequestSearch',
			apInvoice : 'capInvoice',
			cStatement : 'cStatementSearch',
			cContract : 'cContract',
			cProject : 'cProject',
			cProjectPhase : 'cProjectPhase',
			cConstruction : 'cConstruction',
			cConstructionPhase : 'cConstructionPhase',
			cSiteCodeInfo : 'cSiteCodeInfo',
			cService : 'cService',
			cBudget : 'cBudget',
			cCostType : 'cCostType',
			cSalesRegion : 'cSalesRegion',
			cInOutcomeTypeMap : 'cInOutcomeTypeMap',
			cProfitCenter : 'cProfitCenter',
			cCostCenter : 'cCostCenter',
			cAccount : 'cAccount',
			cBPartner : 'cBPartner'
		},
		LocatorType : {
			adOrg : 'adOrg'
		},
		ApKmpGroupBudget : {
			adOrg : 'adOrg'
		},
		GLFactList : {
			orgId : 'orgId',
			departmentId : 'departmentId',
			currencyId : 'currencyId',
			accountDRId : 'accountDRId',
			accountCRId : 'accountCRId',
			bpartnerDRId : 'bpartnerDRId',
			bpartnerCRId : 'bpartnerCRId',
			warehouseDRId : 'warehouseDRId',
			warehouseCRId : 'warehouseCRId',
			costCenterId : 'costCenterId',
			profitCenterId : 'profitCenterId',
			budgetId : 'budgetId',
			costTypeId : 'costTypeId',
			salesRegionId : 'salesRegionId',
			contractId : 'contractId',
			bankAccountId : 'bankAccountId',
			cashFlowId : 'cashFlowId',
			salaryId : 'salaryId',
			payrollId : 'payrollId',
			productId : 'productId',
			statementId : 'statementId',
			projectId : 'projectId',
			projectPhaseId : 'projectPhaseId',
			constructionId : 'constructionId',
			constructionPhaseId : 'constructionPhaseId',
			siteCodeInfoId : 'siteCodeInfoId',
			stationId : 'stationId',
			createdId : 'createdId',
			updatedId : 'updatedId'
		},
		GLPrepaidAllocationEstimate : {
			documentTypeId : 'documentTypeId',
			periodId : 'periodId'
		},
		ArCostType : {
			costtype : 'costtype'
		},
		ApLocation : {
			provide : 'provide',
			district : 'district',
			wards : 'wards'
		},
		ApSiteCodeGroup : {
			siteCodeType : 'siteCodeType',
			adOrg : 'adOrg',
			costtype : 'costtype'
		},
		CostDepartment : {
			costdepartment : 'costdepartment'
		},
		Partner : {
			partner : 'partner'
		},
		CashLine : {
			cashLine : 'cashLine',
			cashLineCr : 'cashLineCr',
			arCashLine : 'arCashLine',
			apCashLine : 'apCashLine'
		},
		ArBankReceipt : {
			nonAcctDepartment : 'nonAcctDepartment',
			partner : 'partner',
			budget : 'budget',
			contract : 'contract',
			costType : 'costType',
			salesRegion : 'salesRegion',
			cashFlow : 'cashFlow',
			profitCenter : 'profitCenter',
			costCenter : 'costCenter',
			period : 'period',
			statement : 'statement',
			advanceReq : 'advanceReq',
			bankAcct : 'bankAcct',
			accountCr : 'accountCr'
		},
		AR_DEPOSITE_BROWSER : {
			popup_id_org : 'popup_id_org',
			popup_id_department : 'popup_id_department',
			popup_id_transfer_org : 'popup_id_transfer_org',
			sale_region : 'sale_region',
			service : 'service',
			PopupCashInBank : 'PopupCashInBank',
			generalStockTransfer : 'generalStockTransfer',
			splitMoney : 'splitMoney'

		},
		cCashInBankLine : {
			cBPastnerDr : 'cBPastnerDr',
			cBPastnerCr : 'cBPastnerCr',
			cAccountDr : 'cAccountDr',
			cAccountCr : 'cAccountCr',
			cContract : 'cContract'
		},
		PopupCashInBank : {
			cBPastnerDr : 'cBPastnerDr',
			cBPastnerCr : 'cBPastnerCr',
			cAccountDr : 'cAccountDr',
			cAccountCr : 'cAccountCr',
			cContract : 'cContract',
			service : 'service',
			sale_region : 'sale_region'
		},
		ApContract : {
			adOrg : 'adOrg',
			cDepartment : 'cDepartment',
			cPartner : 'cPartner',
			cProject : 'cProject',
			cStatement : 'cStatement',
			cSiteCodeInfo : 'cSiteCodeInfo',
			cBank : 'cBank'
		},
		ApClearing : {
			cPartner : 'cPartner',
			cashLine : 'cashLine',
			cashLineCR : 'cashLineCR',
			invoice : 'invoice',
			invoiceCR : 'invoiceCR'
		},
		InvDetailInOutPopup : {
			product : 'product',
			userAlert_warehouse : 'userAlert_warehouse',
			receipt_warehouse : 'receipt_warehouse',
			bpartner_dr : 'bpartner_dr',
			bpartner_cr : 'bpartner_cr',
			account_dr : 'account_dr',
			account_cr : 'account_cr'
		},
		ArClearing : {
			cPartner : 'cPartner',
			cashLine : 'cashLine',
			cashLineCR : 'cashLineCR',
			invoice : 'invoice',
			invoiceCR : 'invoiceCR'
		},
		ApCTask : {
			cTaskType : 'cTaskType',
		},
		ApInvoiceGroup : {
			adOrgId : 'adOrg',
			cDepartment : 'cDepartment',
			cStatement : 'cStatement',
			costCenter : 'costCenter',
			cTaxCategory : 'cTaxCategory',
			cWorkUnit : 'cWorkUnit',
			cLocation : 'cLocation',
			cProduct : 'cProduct',
			cContract : 'cContract',
			cProject : 'cProject',
			cSiteCodeInfo : 'cSiteCodeInfo',
			costType : 'costType',
			cTax : 'cTax',
			cSalary : 'cSalary',
			cContruction : 'cContruction',
			cContructionPhase : 'cContructionPhase',
			cStatementLine : 'cStatementLine',
			cPayroll : 'cPayroll',
			cAccountDr : 'cAccountDr',
			cAccountCr : 'cAccountCr',
			cAccountDistribution : 'cAccountDistribution',
			partnerDr : 'partnerDr',
			cBudget : 'cBudget',
			saleRegion : 'saleRegion',
			paymentBill : 'paymentBill',
			partnerCr : 'partnerCr',
			changeInvoiceGroup : 'changeInvoiceGroup'
		},
		InvuserAlertPopup : {
			profit_center : 'profit_center',
			cost_center : 'cost_center',
			userAlert_warehouse : 'userAlert_warehouse',
			receiptWarehouseId : 'receipt_warehouse',
			bpartner_dr : 'bpartner_dr',
			bpartner_cr : 'bpartner_cr',
			contract : 'contract',
			station : 'station',
			project : 'project',
			project_phase : 'project_phase',
			contruction : 'contruction',
			contruction_phase : 'contruction_phase',
			product : 'product',
			account_dr : 'account_dr',
			account_cr : 'account_cr'
		},
		MInout : {
			cprofitCenterId : 'cprofitCenterId',
			ccostCenterId : 'ccostCenterId',
			userAlertWarehouseId : 'userAlertWarehouseId',
			receiptWarehouseId : 'receiptWarehouseId',
			cbpartnerDrId : 'cbpartnerDrId',
			cbpartnerCrId : 'cbpartnerCrId',
			ccontractId : 'ccontractId',
			cstationId : 'cstationId',
			cprojectId : 'cprojectId',
			cprojectPhaseId : 'cprojectPhaseId',
			cconstructionId : 'cconstructionId',
			cconstructionPhaseId : 'cconstructionPhaseId',
			adOrgId : 'adOrgId',
			cdepartmentId : 'cdepartmentId'
		},
		MInoutInvoice : {
			productId : 'productId'
		},
		// Dodt
		Invcontigency : {
			cAccountDr : 'cAccountDr',
			cAccountCr : 'cAccountCr',
			cbudgetName : 'cbudgetName',
			costType : 'costType',
			cSalesRegion : 'cSalesRegion',
			cCostCenter : 'cCostCenter',
			adOrg : 'adOrg',
			department : 'department'
		},

		ProposalEvaluation : {
			Partner : 'Partner',
			Project : 'Project'
		},

		AcceptanceOfConstructionJobs : {
			showPopupWorkForm : 'showPopupWorkForm'
		},
		BMaterial : {
			showPopup : 'showPopup'
		},

		distanceUnloadedMaterialsList : {
			showNoiDungPS : 'showNoiDungPS'
		},

		MarketPrice : {
			adOrg : 'adOrg',
			productId : 'productId'
		}
	});

	angular.module('MetronicApp').constant('AppConst', {
		AR_INVOICE : {
			Invoice_Table_ID : 1000059,
			Tax_Account_ID : 1000027
		},
		AR_DEPOSITE_BROWSER : {
			document_type_id : 'D00001'
		},
		AR_REVALUATION : {
			Document_Type_Id : 17,
			Status : 'DR'
		},
		C_CONTIGENCY_SALE : {
			Status : 'DR',
			CurrencyName : '1000046'
		}
	});

})();
