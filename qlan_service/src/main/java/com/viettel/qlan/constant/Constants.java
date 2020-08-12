package com.viettel.qlan.constant;

import java.util.HashMap;

import com.viettel.qlan.utils.QlanResource;

public class Constants {
	public static final int DOC_REPORT = 0;
	public static final int PDF_REPORT = 1;
	public static final int EXCEL_REPORT = 2;
	public static final int HTML_REPORT = 3;
	public static final String TIME_DELAY ="TIME_DELAY";
	public static final String PPC ="PPC";
	public static final String WL ="WL";
	public static final String LEVEL ="LEVEL";
	
	
	public interface ACTION_AUDIT_TYPE {
		public final Long INSERT = 1L;
		public final Long UPDATE = 2L;
		public final Long DELETE = 3L;
		public final Long LOCK = 4L;
		public final Long UNLOCK = 5L;
		public final Long RESET = 6L;
	}
	
	public static final HashMap<Long, String> ACTION_AUDIT_DES = new HashMap<Long, String>();
	static {
		ACTION_AUDIT_DES.put(1l, QlanResource.get("audit.insert"));
		ACTION_AUDIT_DES.put(2l, QlanResource.get("audit.update"));
		ACTION_AUDIT_DES.put(3l, QlanResource.get("audit.delete"));
		ACTION_AUDIT_DES.put(4l, QlanResource.get("audit.lock"));
		ACTION_AUDIT_DES.put(5l, QlanResource.get("audit.unlock"));
		ACTION_AUDIT_DES.put(6l, QlanResource.get("audit.reset"));
	}
	/*public interface ACTION_AUDIT_DES {
	
		
		public final String INSERT = "Thêm mới bản ghi ";
		public final String UPDATE = "Cập nhật bản ghi ";
		public final String DELETE = "Xóa bản ghi ";
		public final String LOCK = "Khóa bản ghi ";
		public final String UNLOCK = "Mở khóa ";
		public final String RESET = "Reset mật khẩu ";
	}*/
	public static final String ROLE_CODE_EXITS ="role_code_exits";
	public static final String ROLE_TABLE ="role_table";
	public static final String DELETE_ERROR_REF_ROLE ="delete_error_ref_role";
	public static final String DELETE_SELECTED_MESSAGE ="delete_selected_message";
	public static final String MNG_OBJECTS ="mng_objects";
	public static final String OBJECT_TABLE ="object_table";
	public static final String OBJECT_CODE_EXITS ="objects_code_exits";
	public static final String STAFF_CODE_EXITS ="staff_code_exits";
	public static final String MNG_USER_ALERT ="mng_user_alert";
	public static final String USER_ALERTS_TABLE ="user_alert_table";
	public static final String DELETE_ERROR_USER ="delete_error_user";
	public static final String ERROR_UPDATE_STATUS ="error_update_status";
	public static final String DELETE_ERROR_REF_USER ="delete_error_ref_user";
	public static final String MNG_ROLES ="mng_roles";
	public static final String AP_PARAM_TABLE ="ap_param_table";
	public static final String TIME_DELAY_MESSAGE ="time_delay";
	public static final String EMPLOYEE_CODE_EXITS ="employee_code_exits";
	public static final String STAFF_CBV_TABLE ="staff_cbv_table";
	public static final String MNG_EMPLOYEE_CBV ="mng_employee_cbv";
	public static final String ERROR_DELETE_EMPLOYEE ="error_delete_employee";
	public static final String TEMPLATE_IMPORT_STAFF ="template_import_staff";
	public static final String TEMPLATE_EXPORT_DETAIL ="template_export_detail";
	public static final String TEMPLATE_EXPORT_JOB ="template_export_job";
	public static final String TEMPLATE_EXPORT_WEEK ="template_export_week";
	public static final String STARTDATE_MESSAGE ="startDate_message";
	public static final String ENDDATE_MESSAGE ="endDate_message";
	public static final String MAT="mat";
	public static final String KHONGMAT="khongmat";
	public static final String TUYETMAT="tuyetmat";
	public static final String TOIMAT="toimat";
}
