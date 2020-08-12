package com.viettel.qlan.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.viettel.qlan.bo.ActionAudit;
import com.viettel.service.base.dao.BaseFWDAOImpl;

@Repository("actionAuditDAO")
public class ActionAuditDAO extends BaseFWDAOImpl<ActionAudit, Long> {
	public ActionAuditDAO() {
		this.model = new ActionAudit();
	}

	public ActionAuditDAO(Session session) {
		this.session = session;
	}

	

}
