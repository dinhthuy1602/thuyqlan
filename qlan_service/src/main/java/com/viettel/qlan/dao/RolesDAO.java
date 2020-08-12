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

import com.viettel.qlan.bo.Roles;
import com.viettel.qlan.dto.RolesDTO;
import com.viettel.qlan.dto.UsersDTO;
import com.viettel.qlan.dto.ObjectsDTO;
import com.viettel.qlan.dto.RoleObjectDTO;
import com.viettel.qlan.dto.RoleUserDTO;
import com.viettel.qlan.utils.ValidateUtils;
import com.viettel.service.base.dao.BaseFWDAOImpl;
@Repository("rolesDAO")
public class RolesDAO extends BaseFWDAOImpl<Roles, Long> {
	public RolesDAO() {
		this.model = new Roles();
	}

	public RolesDAO(Session session) {
		this.session = session;
	}

	 @SuppressWarnings("unchecked")
		public List<RolesDTO> getForAutoCompleteRoles(RolesDTO obj) {
			String sql = "select o.ROLE_ID AS roleId," + 
					"o.`STATUS` status," + 
					"o.ROLE_NAME roleName," + 
					
					"o.ROLE_CODE roleCode, " 
					+ "o.DESCRIPTION  description "
					+ " from roles o "
					+ "WHERE o.status=:status  ";
			if(obj.getListId().size()>0){
				sql+=" and o.ROLE_ID NOT IN (:listId)";
			}
			
			StringBuilder stringBuilder = new StringBuilder(sql);
			
				if(StringUtils.isNotEmpty(obj.getRoleName())){
				stringBuilder.append(" AND (upper(o.ROLE_NAME) LIKE upper(:name) escape '&' OR upper(o.ROLE_CODE) LIKE upper(:name) escape '&')");
				}
			
			stringBuilder.append(" ORDER BY o.ROLE_CODE");
			stringBuilder.append(" LIMIT 10 ");
			
			SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());
			query.addScalar("description", new StringType());
			query.addScalar("roleName", new StringType());
			query.addScalar("roleCode", new StringType());
			query.addScalar("roleId", new LongType());
			query.addScalar("status", new LongType());
		
			query.setResultTransformer(Transformers.aliasToBean(RolesDTO.class));

			if (StringUtils.isNotEmpty(obj.getRoleName())) {
				query.setParameter("name", "%" + ValidateUtils.validateKeySearch(obj.getRoleName()) + "%");
			}
			
			if(obj.getListId().size()>0) {
				query.setParameterList("listId", obj.getListId());
			}
			query.setParameter("status",1L);
			return query.list();
		}
	 
	 @SuppressWarnings("unchecked")
		public List<RoleUserDTO> getListRoleByUserId(Long userId) {
			String sql = "select o.ROLE_ID AS roleId," + 
					"o.`STATUS` status," + 
					"o.ROLE_NAME roleName," + 
					"o.ROLE_CODE roleCode, "
					+ "o.DESCRIPTION  description,"
					+ "ru.USER_ID  userId" 
					+ " from roles o "
					+ " JOIN role_user ru ON ru.ROLE_ID=o.ROLE_ID "
					+ " WHERE o.status=1 AND  ru.USER_ID=:userId ";
			
			StringBuilder stringBuilder = new StringBuilder(sql);
			
			
			stringBuilder.append(" ORDER BY o.ROLE_CODE");
			
			SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());
			query.addScalar("description", new StringType());
			query.addScalar("roleName", new StringType());
			query.addScalar("roleCode", new StringType());
			query.addScalar("roleId", new LongType());
			query.addScalar("status", new LongType());
			query.addScalar("userId", new LongType());
		
			query.setResultTransformer(Transformers.aliasToBean(RoleUserDTO.class));
			query.setLong("userId", userId);
			return query.list();
		}
	 
}
