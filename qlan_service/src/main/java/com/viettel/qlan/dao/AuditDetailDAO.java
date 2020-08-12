package com.viettel.qlan.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.viettel.qlan.bo.AuditDetail;
import com.viettel.service.base.dao.BaseFWDAOImpl;

@Repository("auditDetailDAO")
public class AuditDetailDAO extends BaseFWDAOImpl<AuditDetail, Long> {
	public AuditDetailDAO() {
		this.model = new AuditDetail();
	}

	public AuditDetailDAO(Session session) {
		this.session = session;
	}

	

}
