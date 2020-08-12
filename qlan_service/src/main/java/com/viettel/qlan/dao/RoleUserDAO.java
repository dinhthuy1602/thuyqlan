package com.viettel.qlan.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import com.viettel.qlan.bo.RoleUser;
import com.viettel.qlan.bo.Roles;
import com.viettel.qlan.dto.RolesDTO;
import com.viettel.qlan.dto.UsersDTO;
import com.viettel.qlan.dto.ObjectsDTO;
import com.viettel.qlan.dto.RoleObjectDTO;
import com.viettel.qlan.dto.RoleUserDTO;
import com.viettel.qlan.utils.ValidateUtils;
import com.viettel.service.base.dao.BaseFWDAOImpl;
@Repository("roleUserDAO")
public class RoleUserDAO extends BaseFWDAOImpl<RoleUser, Long> {
	public RoleUserDAO() {
		this.model = new RoleUser();
	}

	public RoleUserDAO(Session session) {
		this.session = session;
	}
}
