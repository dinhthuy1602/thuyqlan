package com.viettel.qlan.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import java.lang.String;

import org.castor.util.StringUtil;
import org.exolab.castor.mapping.xml.Sql;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import com.viettel.qlan.bo.Objects;
import com.viettel.qlan.dto.ObjectsDTO;
import com.viettel.qlan.dto.RoleObjectDTO;
import com.viettel.qlan.utils.ValidateUtils;
import com.viettel.service.base.dao.BaseFWDAOImpl;

@Repository("objectsDAO")
public class ObjectsDAO extends BaseFWDAOImpl<Objects, Long> {
	public ObjectsDAO() {
		this.model = new Objects();
	}

	public ObjectsDAO(Session session) {
		this.session = session;
	}

	
	
	@SuppressWarnings("unchecked")
	public List<ObjectsDTO> getListObjects(Long userId,Long parentId){
		StringBuilder sql= new StringBuilder("SELECT DISTINCT ");
		sql.append(" obj.OBJECT_ID AS objectId,");
		sql.append(" obj.PARENT_ID AS parentId,");
		sql.append(" obj.`STATUS` AS `status`,");
		sql.append(" obj.ORD AS ord,");
		sql.append(" obj.OBJECT_URL AS objectUrl,");
		sql.append(" obj.OBJECT_NAME AS objectName,");
		sql.append(" obj.DESCRIPTION AS description,");
		sql.append(" obj.OBJECT_TYPE_ID AS objectTypeId,");
		sql.append(" obj.OBJECT_CODE AS objectCode,");
		sql.append(" obj.CREATE_USER AS createUser,");
		sql.append(" obj.CREATE_DATE AS createDate");
		sql.append(" FROM objects AS obj  ");
		
		if(parentId !=null){
			sql.append(" JOIN role_object on obj.OBJECT_ID=role_object.OBJECT_ID");
			sql.append(" JOIN role_user ON role_user.ROLE_ID=role_object.ROLE_ID");
			sql.append(" WHERE role_user.USER_ID=:userId AND role_user.IS_ACTIVE=1 AND role_object.IS_ACTIVE=1 AND obj.`STATUS`=1 ");
			sql.append(" AND obj.PARENT_ID =:parentId ");
		} else {
			sql.append(" WHERE obj.OBJECT_ID IN (SELECT objects.PARENT_ID FROM  objects ");
			sql.append(" JOIN role_object on objects.OBJECT_ID=role_object.OBJECT_ID");
			sql.append(" JOIN role_user ON role_user.ROLE_ID=role_object.ROLE_ID");
			sql.append(" WHERE role_user.USER_ID=:userId AND role_user.IS_ACTIVE=1 AND role_object.IS_ACTIVE=1  ) AND obj.`STATUS`=1 ");
		}
		sql.append(" ORDER BY obj.ORD ");
		
		SQLQuery query= getSession().createSQLQuery(sql.toString());
		
		query.addScalar("objectId", new LongType());
		query.addScalar("parentId", new LongType());
		query.addScalar("status", new LongType());
		query.addScalar("ord", new LongType());
		query.addScalar("objectUrl", new StringType());
		query.addScalar("objectName", new StringType());
		query.addScalar("description", new StringType());
		query.addScalar("objectTypeId", new LongType());
		query.addScalar("objectCode", new StringType());
		query.addScalar("createUser", new StringType());
		query.addScalar("createDate", new DateType());
		
		query.setResultTransformer(Transformers.aliasToBean(ObjectsDTO.class));
		
		query.setParameter("userId", userId);
		if(parentId!=null){
			query.setParameter("parentId", parentId);
		}
		
		return query.list();
	}

	public List<ObjectsDTO> doSearch(ObjectsDTO obj){
		StringBuilder sql = new StringBuilder("SELECT "
				+ " obj.OBJECT_ID AS objectId, "
				+ " obj.PARENT_ID AS parentId, "
				+ " obj2.OBJECT_NAME AS parentName, "
				+ " obj.`STATUS` AS `status`, "
				+ " obj.ORD AS ord, "
				+ " obj.OBJECT_URL AS objectUrl, "
				+ " obj.OBJECT_NAME AS objectName, "
				+ " obj.DESCRIPTION AS description, "
				+ " obj.OBJECT_TYPE_ID AS objectTypeId, "
				+ " obj.OBJECT_CODE AS objectCode, "
				+ " obj.CREATE_USER AS createUser, "
				+ " obj.CREATE_DATE AS createDate "

				+ " FROM objects AS obj  "
				+ " left join objects as obj2 "
				+ " on obj.PARENT_ID = obj2.OBJECT_ID "
				+ " WHERE 1=1 ");

		if (StringUtils.isNotEmpty(obj.getObjectCode())) {
			sql.append(" AND upper(obj.OBJECT_CODE) LIKE upper(:objectCode) escape '&'  ");
		}
		if (StringUtils.isNotEmpty(obj.getObjectName())) {
			sql.append(" AND upper(obj.OBJECT_NAME) LIKE upper(:objectName) escape '&'  ");
		}
//		if (StringUtils.isNotEmpty(obj.getParentName())) {
//			sql.append(" AND upper(obj2.OBJECT_NAME) LIKE upper(:parentName) escape '&'  ");
//		}
		if (obj.getParentId() != null) {
			sql.append(" AND obj.PARENT_ID = :parentId ");
		}
		if (obj.getStatus() != null) {
			sql.append(" AND obj.`STATUS` = :status   ");
		}
		if (obj.getObjectTypeId() != null) {
			sql.append(" AND obj.OBJECT_TYPE_ID = :objectTypeId ");
		}

		sql.append("ORDER BY obj.OBJECT_NAME, obj.OBJECT_CODE, obj.ORD asc");

		StringBuilder sqlCount = new StringBuilder("SELECT COUNT(*) FROM (");
		sqlCount.append(sql.toString());
		sqlCount.append(" ) ");
		sqlCount.append(" as objects;");

		SQLQuery query = getSession().createSQLQuery(sql.toString());
		SQLQuery queryCount = getSession().createSQLQuery(sqlCount.toString());

		query.addScalar("objectId", new LongType());
		query.addScalar("parentId", new LongType());
		query.addScalar("status", new LongType());
		query.addScalar("ord", new LongType());
		query.addScalar("objectUrl", new StringType());
		query.addScalar("objectName", new StringType());
		query.addScalar("description", new StringType());
		query.addScalar("objectTypeId", new LongType());
		query.addScalar("objectCode", new StringType());
		query.addScalar("createUser", new StringType());
		query.addScalar("createDate", new DateType());
		query.addScalar("parentName", new StringType());


		query.setResultTransformer(Transformers.aliasToBean(ObjectsDTO.class));

		if(StringUtils.isNotEmpty(obj.getObjectCode())){
			query.setParameter("objectCode", "%" + ValidateUtils.validateKeySearch(obj.getObjectCode()) + "%");
			queryCount.setParameter("objectCode", "%" + ValidateUtils.validateKeySearch(obj.getObjectCode()) + "%");
		}
		if (StringUtils.isNotEmpty(obj.getObjectName())){
			query.setParameter("objectName", "%" + ValidateUtils.validateKeySearch(obj.getObjectName()) + "%");
			queryCount.setParameter("objectName", "%" + ValidateUtils.validateKeySearch(obj.getObjectName()) + "%");
		}
//		if (StringUtils.isNotEmpty(obj.getParentName())){
//			query.setParameter("parentName", "%" + ValidateUtils.validateKeySearch(obj.getParentName()) + "%");
//			queryCount.setParameter("parentName", "%" + ValidateUtils.validateKeySearch(obj.getParentName()) + "%");
//		}
		if(obj.getParentId() != null){
			query.setParameter("parentId", obj.getParentId());
			queryCount.setParameter("parentId", obj.getParentId());
		}
		if(obj.getObjectTypeId() != null){
			query.setParameter("objectTypeId", obj.getObjectTypeId());
			queryCount.setParameter("objectTypeId", obj.getObjectTypeId());
		}
		if(obj.getStatus() != null){
			query.setParameter("status", obj.getStatus());
			queryCount.setParameter("status", obj.getStatus());
		}

		query.setFirstResult((obj.getPage().intValue() - 1) * obj.getPageSize().intValue());
		query.setMaxResults((obj.getPageSize().intValue()));
		obj.setTotalRecord(((BigInteger) queryCount.uniqueResult()).intValue());
		return query.list() ;
	}

	public List<ObjectsDTO> autoSearchObjects(ObjectsDTO obj){
		StringBuilder sql = new StringBuilder("SELECT "
				+ " obj.OBJECT_ID AS objectId, "
				+ " obj.OBJECT_NAME AS objectName, "
				+ " obj.OBJECT_CODE AS objectCode "
				+ " FROM objects AS obj  "
				+ " WHERE 1=1 ");

		if (StringUtils.isNotEmpty(obj.getParentName())) {
			sql.append(" AND upper(obj.OBJECT_CODE) LIKE upper(:parentName) escape '&'  ");
			sql.append(" OR upper(obj.OBJECT_NAME) LIKE upper(:parentName) escape '&'  ");
		}

		sql.append("ORDER BY obj.OBJECT_CODE, obj.OBJECT_NAME");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("objectId", new LongType());
		query.addScalar("objectName", new StringType());
		query.addScalar("objectCode", new StringType());


		if(StringUtils.isNotEmpty(obj.getParentName())){
			query.setParameter("parentName", "%" + ValidateUtils.validateKeySearch(obj.getParentName()) + "%");
		}

		query.setResultTransformer(Transformers.aliasToBean(ObjectsDTO.class));

		return query.list() ;
	}

	public List<ObjectsDTO> autoSearchObjectsPopup(ObjectsDTO obj){
		StringBuilder sql = new StringBuilder("SELECT "
				+ " obj.OBJECT_ID AS objectId, "
				+ " obj.OBJECT_NAME AS objectName, "
				+ " obj.OBJECT_CODE AS objectCode "
				+ " FROM objects AS obj  "
				+ " WHERE obj.PARENT_ID IS NULL ");

		if (StringUtils.isNotEmpty(obj.getParentName())) {
			sql.append(" AND upper(obj.OBJECT_CODE) LIKE upper(:parentName) escape '&'  ");
			sql.append(" OR upper(obj.OBJECT_NAME) LIKE upper(:parentName) escape '&'  ");
		}

		sql.append("ORDER BY obj.OBJECT_CODE, obj.OBJECT_NAME");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("objectId", new LongType());
		query.addScalar("objectName", new StringType());
		query.addScalar("objectCode", new StringType());


		if(StringUtils.isNotEmpty(obj.getParentName())){
			query.setParameter("parentName", "%" + ValidateUtils.validateKeySearch(obj.getParentName()) + "%");
		}

		query.setResultTransformer(Transformers.aliasToBean(ObjectsDTO.class));
		return query.list() ;
	}

	public ObjectsDTO getObjectsInfoByCode(ObjectsDTO objectsDTO){
		StringBuilder sql = new StringBuilder("SELECT "
				+ " obj.OBJECT_ID AS objectId, "
				+ " obj.PARENT_ID AS parentId, "
				+ " obj2.OBJECT_NAME AS parentName, "
				+ " obj.`STATUS` AS `status`, "
				+ " obj.ORD AS ord, "
				+ " obj.OBJECT_URL AS objectUrl, "
				+ " obj.OBJECT_NAME AS objectName, "
				+ " obj.DESCRIPTION AS description, "
				+ " obj.OBJECT_TYPE_ID AS objectTypeId, "
				+ " obj.OBJECT_CODE AS objectCode, "
				+ " obj.CREATE_USER AS createUser, "
				+ " obj.CREATE_DATE AS createDate "
				+ " FROM objects AS obj  "
				+ " left join objects as obj2 "
				+ " on obj.PARENT_ID = obj2.OBJECT_ID "
				+ " WHERE upper(obj.OBJECT_CODE) = upper(:object_code) ");
		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("objectId", new LongType());
		query.addScalar("parentId", new LongType());
		query.addScalar("status", new LongType());
		query.addScalar("ord", new LongType());
		query.addScalar("objectUrl", new StringType());
		query.addScalar("objectName", new StringType());
		query.addScalar("description", new StringType());
		query.addScalar("objectTypeId", new LongType());
		query.addScalar("objectCode", new StringType());
		query.addScalar("createUser", new StringType());
		query.addScalar("createDate", new DateType());
		query.addScalar("parentName", new StringType());

		query.setResultTransformer(Transformers.aliasToBean(ObjectsDTO.class));
		query.setParameter("object_code", objectsDTO.getObjectCode() );

		return (ObjectsDTO) query.uniqueResult();
	}

	public ObjectsDTO getObjectsInfoById(ObjectsDTO objectsDTO){
		StringBuilder sql = new StringBuilder("SELECT "
				+ " obj.OBJECT_ID AS objectId, "
				+ " obj.PARENT_ID AS parentId, "
				+ " obj2.OBJECT_NAME AS parentName, "
				+ " obj.`STATUS` AS `status`, "
				+ " obj.ORD AS ord, "
				+ " obj.OBJECT_URL AS objectUrl, "
				+ " obj.OBJECT_NAME AS objectName, "
				+ " obj.DESCRIPTION AS description, "
				+ " obj.OBJECT_TYPE_ID AS objectTypeId, "
				+ " obj.OBJECT_CODE AS objectCode, "
				+ " obj.CREATE_USER AS createUser, "
				+ " obj.CREATE_DATE AS createDate "
				+ " FROM objects AS obj  "
				+ " left join objects as obj2 "
				+ " on obj.PARENT_ID = obj2.OBJECT_ID "
				+ " WHERE upper(obj.OBJECT_ID) = upper(:object_id) ");
		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("objectId", new LongType());
		query.addScalar("parentId", new LongType());
		query.addScalar("status", new LongType());
		query.addScalar("ord", new LongType());
		query.addScalar("objectUrl", new StringType());
		query.addScalar("objectName", new StringType());
		query.addScalar("description", new StringType());
		query.addScalar("objectTypeId", new LongType());
		query.addScalar("objectCode", new StringType());
		query.addScalar("createUser", new StringType());
		query.addScalar("createDate", new DateType());
		query.addScalar("parentName", new StringType());

		query.setResultTransformer(Transformers.aliasToBean(ObjectsDTO.class));
		query.setParameter("object_id", objectsDTO.getObjectId() );

		return (ObjectsDTO) query.uniqueResult();
	}

	public void lockObject(Long objectId){
		StringBuilder sql = new StringBuilder("UPDATE objects SET STATUS = 0 WHERE OBJECT_ID = :objectId");
		SQLQuery query= getSession().createSQLQuery(sql.toString());
		query.setParameter("objectId", objectId);
		query.executeUpdate();
	}

	public void unlockObject(Long objectId){
		StringBuilder sql = new StringBuilder("UPDATE objects SET STATUS = 1 WHERE OBJECT_ID =:objectId");
		SQLQuery query= getSession().createSQLQuery(sql.toString());
		query.setParameter("objectId", objectId);
		query.executeUpdate();
	}

	public List<ObjectsDTO> checkRolesObject(Long objectId){

		StringBuilder sql = new StringBuilder("SELECT "
				+" obj.OBJECT_ID AS objectId,"
				+" obj.PARENT_ID AS parentId,"
				+" obj.STATUS AS status, "
				+" obj.`ORD` AS ord, "
				+" obj.OBJECT_URL AS objectUrl, "
				+" obj.OBJECT_NAME AS objectName, "
				+" obj.`DESCRIPTION` AS `description`, "
				+" obj.OBJECT_TYPE_ID AS objectTypeId, "
				+" obj.OBJECT_CODE AS objectCode, "
				+" obj.CREATE_USER AS createUser, "
				+" obj.CREATE_DATE AS createDate "
				+" FROM qlan.objects obj "
				+" INNER JOIN qlan.role_object as robj "
				+" ON obj.OBJECT_ID = robj.OBJECT_ID "
				+" WHERE upper(obj.OBJECT_ID) = upper(:id) "
		);

		SQLQuery query= getSession().createSQLQuery(sql.toString());

		query.addScalar("objectId", new LongType());
		query.addScalar("parentId", new LongType());
		query.addScalar("status", new LongType());
		query.addScalar("ord", new LongType());
		query.addScalar("objectUrl", new StringType());
		query.addScalar("objectName", new StringType());
		query.addScalar("description", new StringType());
		query.addScalar("objectTypeId", new LongType());
		query.addScalar("objectCode", new StringType());
		query.addScalar("createUser", new StringType());
		query.addScalar("createDate", new DateType());

		query.setResultTransformer(Transformers.aliasToBean(ObjectsDTO.class));
		query.setParameter("id", objectId );

		return query.list() ;
	}
}
