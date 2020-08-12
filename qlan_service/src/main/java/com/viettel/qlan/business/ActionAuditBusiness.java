package com.viettel.qlan.business;

import javax.servlet.http.HttpServletRequest;

import com.viettel.qlan.bo.ActionAudit;
import com.viettel.qlan.dto.ActionAuditDTO;
import com.viettel.service.base.business.BaseFWBusiness;

public interface ActionAuditBusiness extends BaseFWBusiness<ActionAuditDTO, ActionAudit> {
	 
    
    
    Long insertOrUpdate(ActionAuditDTO dto);
    

	void trackingAdjustment(Long auditTypeId,String tableName, Long recordId, Object newObj, Object oldObj, String des, 
			HttpServletRequest request);
    
    /**
     * ImsCommonConstant.ADJ_HISTORY_TYPE.ADJ_TYPE_EDIT
     * ImsCommonConstant.ADJ_HISTORY_TYPE.ADJ_TYPE_DELETE
     * 
     * @param adjType
     * @param tableName
     * @param fieldName
     * @param recordId
     * @param description
     */
}
