package com.viettel.qlan.dao;

import com.viettel.qlan.bo.Area;
import com.viettel.qlan.dto.AreaDTO;
import com.viettel.qlan.utils.ValidateUtils;
import com.viettel.service.base.dao.BaseFWDAOImpl;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository("areasDAO")
public class AreasDAO extends BaseFWDAOImpl<Area, Long> {
    public AreasDAO() {
        this.model = new Area();
    }

    public AreasDAO(Session session) {
        this.session = session;
    }


    @SuppressWarnings("unchecked")
    public List<AreaDTO> doSearch(AreaDTO obj) {
        StringBuilder sql = new StringBuilder( "SELECT " +
                "area.ID AS id," +
                "area.PARENT_ID AS parentId," +
                "area.AREA_CODE AS areaCode," +
                "area.AREA_NAME AS areaName," +
                "area.STATUS AS 'status'," +
                "area.PATH AS 'path',a2.AREA_CODE as parentName " +
                " FROM " +
                " qlan.area " +
                " left join qlan.area as a2 on area.PARENT_ID = a2.id " +
                " where 1=1 " );
        if (StringUtils.isNotEmpty( obj.getAreaCode() )) {
            sql.append( " and upper(area.AREA_CODE) LIKE upper(:checkid) escape '&'  " );
        }
        if (StringUtils.isNotEmpty( obj.getAreaName() )) {
            sql.append( " and upper(area.AREA_NAME) LIKE upper(:checkname) escape '&'  " );

        }
        if (obj.getStatus() != null) {
            sql.append( " and area.STATUS = :checktt " );
        }
        if (obj.getId() != null) {
            sql.append( " and area.ID = :Id " );
        }

        StringBuilder sqlCount = new StringBuilder( "SELECT COUNT(*) FROM (" );
        sqlCount.append( sql.toString() );
        sqlCount.append( ")" );
        sqlCount.append( " as total;" );

        SQLQuery query = getSession().createSQLQuery( sql.toString() );
        SQLQuery queryCount = getSession().createSQLQuery( sqlCount.toString() );

        query.addScalar( "id", new LongType() );
        query.addScalar( "parentId", new LongType() );
        query.addScalar( "areaCode", new StringType() );
        query.addScalar( "areaName", new StringType() );
        query.addScalar( "status", new LongType() );
        query.addScalar( "path", new StringType() );
        query.addScalar( "parentName", new StringType() );


        query.setResultTransformer( Transformers.aliasToBean( AreaDTO.class ) );

        if (StringUtils.isNotEmpty( obj.getAreaCode() )) {
            query.setParameter( "checkid", "%" + ValidateUtils.validateKeySearch(obj.getAreaCode()) + "%" );
            queryCount.setParameter( "checkid", "%" + ValidateUtils.validateKeySearch(obj.getAreaCode()) + "%" );
        }
        if (StringUtils.isNotEmpty( obj.getAreaName() )) {
            query.setParameter( "checkname", "%" + ValidateUtils.validateKeySearch(obj.getAreaName()) + "%" );
            queryCount.setParameter( "checkname", "%" + ValidateUtils.validateKeySearch(obj.getAreaName()) + "%" );
        }
        if (obj.getStatus() != null) {
            query.setParameter( "checktt", obj.getStatus() );
            queryCount.setParameter( "checktt", obj.getStatus() );
        }
        if (obj.getId() != null) {
            query.setParameter( "Id", obj.getId() );
            queryCount.setParameter( "Id", obj.getId() );
        }

        query.setFirstResult( (obj.getPage().intValue() - 1) * obj.getPageSize().intValue() );
        query.setMaxResults( obj.getPageSize().intValue() );
        obj.setTotalRecord( ((BigInteger) queryCount.uniqueResult()).intValue() );
        return query.list();

    }

    @SuppressWarnings("unchecked")
    public List<AreaDTO> doSearchTree() {
        StringBuilder sql = new StringBuilder( "SELECT " +
                "area.ID AS id," +
                "area.PARENT_ID AS parentId," +
                "area.AREA_CODE AS areaCode," +
                "area.AREA_NAME AS areaName," +
                "area.STATUS AS 'status'," +
                "area.PATH AS 'path'" +
                " FROM" +
                " qlan.area " );
        SQLQuery query = getSession().createSQLQuery( sql.toString() );
        query.addScalar( "id", new LongType() );
        query.addScalar( "parentId", new LongType() );
        query.addScalar( "areaCode", new StringType() );
        query.addScalar( "areaName", new StringType() );
        query.addScalar( "status", new LongType() );
        query.addScalar( "path", new StringType() );
        query.setResultTransformer( Transformers.aliasToBean( AreaDTO.class ) );
        return query.list();
    }


    @SuppressWarnings("unchecked")
    public List<Long> getID() {
        StringBuilder sql = new StringBuilder( "select distinct a2.ID from area as a1 " +
                "left join qlan.area as a2 on a1.id = a2.PARENT_ID limit 1" );
        SQLQuery query = getSession().createSQLQuery( sql.toString() );
        return query.list();
    }


    @SuppressWarnings("unchecked")
    public List<AreaDTO> TreeAreas(AreaDTO obj, Long id) {
        StringBuilder sql = new StringBuilder( "SELECT " +
                "area.ID AS id," +
                "area.PARENT_ID AS parentId," +
                "area.AREA_CODE AS areaCode," +
                "area.AREA_NAME AS areaName," +
                "area.STATUS AS 'status'," +
                "area.PATH AS 'path'" );
        sql.append( ",(case when PARENT_ID = :parent_Id then (select ae.AREA_CODE from area as ae where ae.ID = :parent_Id) end) AS parentName " );
        sql.append( " FROM qlan.area" );
        sql.append( " where area.PARENT_ID = :parent_Id" );
        StringBuilder sqlCount = new StringBuilder( "SELECT COUNT(*) FROM (" );
        sqlCount.append( sql.toString() );
        sqlCount.append( ")" );
        sqlCount.append( " as total;" );
        SQLQuery query = getSession().createSQLQuery( sql.toString() );
        SQLQuery queryCount = getSession().createSQLQuery( sqlCount.toString() );
        query.addScalar( "id", new LongType() );
        query.addScalar( "parentId", new LongType() );
        query.addScalar( "areaCode", new StringType() );
        query.addScalar( "areaName", new StringType() );
        query.addScalar( "status", new LongType() );
        query.addScalar( "path", new StringType() );
        query.addScalar( "parentName", new StringType() );
        query.setResultTransformer( Transformers.aliasToBean( AreaDTO.class ) );
        if (obj.getId() != null) {
            query.setParameter( "parent_Id", obj.getId() );
            queryCount.setParameter( "parent_Id", obj.getId() );
        } else {
            query.setParameter( "parent_Id", id );
            queryCount.setParameter( "parent_Id", id );
        }
        query.setFirstResult( (obj.getPage().intValue() - 1) * obj.getPageSize().intValue() );
        query.setMaxResults( obj.getPageSize().intValue() );
        obj.setTotalRecord( ((BigInteger) queryCount.uniqueResult()).intValue() );
        return query.list();
    }

    public List<AreaDTO> checkparen(Long id) {
        StringBuilder sql = new StringBuilder( "SELECT " +
                " area.ID AS id," +
                " area.PARENT_ID AS parentId," +
                " area.AREA_CODE AS areaCode," +
                " area.AREA_NAME AS areaName," +
                " area.STATUS AS 'status'," +
                " area.PATH AS 'path'," +
                " a2.AREA_NAME as parentName " +
                " FROM " +
                " qlan.area " +
                " left join " +
                " qlan.area as a2 " +
                " on area.id = a2.PARENT_ID " +
                " where " +
                " area.id =:id " );
        SQLQuery query = getSession().createSQLQuery( sql.toString() );
        query.addScalar( "id", new LongType() );
        query.addScalar( "parentId", new LongType() );
        query.addScalar( "areaCode", new StringType() );
        query.addScalar( "areaName", new StringType() );
        query.addScalar( "status", new LongType() );
        query.addScalar( "path", new StringType() );
        query.addScalar( "parentName", new StringType() );
        query.setResultTransformer( Transformers.aliasToBean( AreaDTO.class ) );

        query.setParameter( "id", id );
        return query.list();
    }

    public void deleteArea(Long Id) {
        StringBuilder sql = new StringBuilder( "DELETE from " +
                " AREA " +
                " where" +
                " ID= :Id " );
        SQLQuery query = getSession().createSQLQuery( sql.toString() );
        query.setParameter( "Id", Id );
        query.executeUpdate();
    }


    public void updateArea(AreaDTO obj) {
        StringBuilder sql = new StringBuilder( "update " +
                " AREA " +
                " set " +
                " AREA_CODE= :areaCode, " +
                " AREA_NAME= :areaName, " +
                " PARENT_ID= :areaParen," +
                " PATH= :areaPath," +
                " STATUS = :areaStatus " +
                " where " +
                " ID = :areaId limit 1" );
        SQLQuery query = getSession().createSQLQuery( sql.toString() );
        query.setParameter( "areaCode", obj.getAreaCode() );
        query.setParameter( "areaName", obj.getAreaName() );
        query.setParameter( "areaParen", obj.getParentId() );
        query.setParameter( "areaPath", obj.getPath() );
        query.setParameter( "areaStatus", obj.getStatus() );
        query.setParameter( "areaId", obj.getId() );
        query.executeUpdate();
    }

    public void addAreas(AreaDTO obj) {
        StringBuilder sql = new StringBuilder( "insert " +
                " into " +
                " AREA " +
                " (AREA_CODE, AREA_NAME, PARENT_ID, PATH, STATUS, ID) " +
                " values " +
                " (:areaCode, :areaName, :areaParen, :areaPath, :areaStatus, :areaId) " );
        SQLQuery query = getSession().createSQLQuery( sql.toString() );
        query.setParameter( "areaCode", obj.getAreaCode() );
        query.setParameter( "areaName", obj.getAreaName() );
        query.setParameter( "areaParen", obj.getParentId() );
        query.setParameter( "areaPath", obj.getPath() );
        query.setParameter( "areaStatus", obj.getStatus() );
        query.setParameter( "areaId", obj.getId() );
        query.executeUpdate();
    }

    public static void main(String[] args) {
        String a = new String( "TP Hà Nội " );
        String b = "TP Hà Nội";
        System.out.println( a.equals( null ) );
    }
//auto search
    public List<AreaDTO> getParen(AreaDTO obj) {
        StringBuilder sql = new StringBuilder( "SELECT ID as id, " +
                " AREA_CODE AS areaCode ,AREA_NAME AS areaName FROM qlan.area where 1 = 1 " );
        if (StringUtils.isNotEmpty( obj.getName() )) {
            sql.append( " and upper(area.AREA_CODE) LIKE upper(:checkid) escape '&'  " );
            sql.append( " or upper(area.AREA_NAME) LIKE upper(:checkid) escape '&'  " );
        }
        SQLQuery query = getSession().createSQLQuery( sql.toString() );

        query.addScalar("id", new LongType());
        query.addScalar( "areaCode", new StringType() );
        query.addScalar( "areaName", new StringType() );

    /*    if (StringUtils.isNotEmpty( obj.getName() )) {
            query.setParameter( "checkid", "%" + ValidateUtils.validateKeySearch(obj.getName()) + "%" );
        }*/
        if (StringUtils.isNotEmpty( obj.getName() )) {
            query.setParameter( "checkid", "%" + ValidateUtils.validateKeySearch(obj.getName()) + "%" );
        }
        query.setResultTransformer( Transformers.aliasToBean( AreaDTO.class ) );
        return query.list();
    }


    public List<AreaDTO> getParenId(Long id) {
        StringBuilder sql = new StringBuilder( " SELECT " +
                " distinct area.AREA_CODE as areaCode," +
                " area.AREA_NAME as areaName " +
                " FROM " +
                " qlan.area " +
                " where " +
                " area.ID = :dulieu " );

        SQLQuery query = getSession().createSQLQuery( sql.toString() );

        query.addScalar( "areaCode", new StringType() );
        query.addScalar( "areaName", new StringType() );
        query.setResultTransformer( Transformers.aliasToBean( AreaDTO.class ) );
        query.setParameter( "dulieu", id );

        return query.list();
    }


    //    kiểm tra xem data có mã nguyên liệu hay chưa
    public List<AreaDTO> checkAreaCode(AreaDTO obj) {
        StringBuilder sql = new StringBuilder( "SELECT area.AREA_CODE AS areaCode FROM qlan.area where 1=1 " );
        if (obj.getAreaCode() != null) {
            sql.append( " and AREA_CODE =:Code" );
        }
        SQLQuery query = getSession().createSQLQuery( sql.toString() );
        if (obj.getAreaCode() != null) {
            query.setParameter( "Code", obj.getAreaCode() );
        }
        query.addScalar( "areaCode", new StringType() );
        query.setResultTransformer( Transformers.aliasToBean( AreaDTO.class ) );
        return query.list();
    }

    public List<AreaDTO> checkParen(AreaDTO obj) {
        StringBuilder sql = new StringBuilder( "SELECT distinct ID AS id FROM qlan.area where 1=1 " );
        if (obj.getParentId() != null) {
            sql.append( " and ID =:id " );
            sql.append( " limit 1" );

        }
        if (obj.getParentId() == null) {
            sql.append( " limit 0" );
        }

        SQLQuery query = getSession().createSQLQuery( sql.toString() );
        if (obj.getParentId() != null) {
            query.setParameter( "id", obj.getParentId() );
        }
        query.addScalar( "id", new LongType() );
        query.setResultTransformer( Transformers.aliasToBean( AreaDTO.class ) );
        return query.list();
    }

    // kiem tra khi cap nhat ma bi thay doi du lieu cha
    public List<AreaDTO> getIDParen(Long id) {
        StringBuilder sql = new StringBuilder( " SELECT area.ID AS id,area.PARENT_ID AS parentId,area.AREA_CODE AS areaCode FROM qlan.area where area.id = :Id " );


        SQLQuery query = getSession().createSQLQuery( sql.toString() );

        query.addScalar( "id", new LongType() );
        query.addScalar( "parentId", new LongType() );
        query.addScalar( "areaCode", new StringType() );

        query.setResultTransformer( Transformers.aliasToBean( AreaDTO.class ) );
        query.setParameter( "Id", id );

        return query.list();
    }
}

