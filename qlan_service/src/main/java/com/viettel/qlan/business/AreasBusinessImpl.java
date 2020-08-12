package com.viettel.qlan.business;

import com.viettel.base.common.BusinessException;
import com.viettel.base.common.UString;
import com.viettel.qlan.bo.Area;
import com.viettel.qlan.dao.AreasDAO;
import com.viettel.qlan.dto.AreaDTO;
import com.viettel.qlan.utils.QlanResource;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import com.viettel.service.base.dto.DataListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service("areasBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)

public class AreasBusinessImpl extends BaseFWBusinessImpl<AreasDAO, AreaDTO, Area> implements AreasBusiness {

    private final int Max_length = 100;
    private final int Min_length = 0;
    private final int Add = 1;
    private final int Edit = 2;

    @Autowired
    AreasDAO areasDAO;


    public AreasBusinessImpl() {
        tModel = new Area();
        tDAO = areasDAO;
    }

    @Override
    public AreasDAO gettDAO() {
        return areasDAO;
    }
    //ktra độ dài tên đơn vị khi nhập
    private boolean checkAreaName(String input) {
        input = input.trim();
        if (input.length() >= Min_length && input.length() <= Max_length) {
            return !UString.check_character_AreaName( input );
        }
        return false;
    }
//ktra độ dài mã đơn vị khi nhập
    private boolean checkAreaCode(String input) {
        input = input.trim();
        if (input.length() >= Min_length && input.length() <= Max_length) {
            int totalCheck = UString.Count_white_space( input );
            if (totalCheck == 0) {
                return !UString.check_character( input );
            }
        }
        return false;
    }

    private boolean checkData(AreaDTO obj, int th) {
        if (checkIn( obj, th )) {
            if (checkAreaCode( obj.getAreaCode() ) && checkAreaName( obj.getAreaName())) {
                return true;
            }
        }
        return false;
    }

      private boolean checkIn(AreaDTO obj, int th) {
        switch (th) {
            case 1: {
                if (obj.getAreaCode() != null && obj.getAreaName() != null && obj.getStatus() != null && (obj.getStatus() == 1 || obj.getStatus() == 0) && ((obj.getParentName() != null && obj.getParentId() != null) || (obj.getParentName() == null && obj.getParentId() == null))) {
                    return true;
                }
                break;
            }
            case 2: {
                //     Khi dữ liệu gửi để sửa mới thì check xem dữ liệu gửi vào có đủ các yêu cầu hay k?( các trường hợp khi sửa:id ,  Mã đơn vị, tên đơn vị, trạng thái ( 0 hoặc 1))
                if (obj.getId() != null && obj.getAreaCode() != null && obj.getAreaName() != null && obj.getStatus() != null && (obj.getStatus() == 1 || obj.getStatus() == 0)) {
                    return true;
                }
                break;
            }
        }
        return false;
    }


    //Kiểm tra lại nếu có sự thay đổi mã đơn vị, tên đơn vị mà không tồn tại
    private boolean checkAddTT(AreaDTO obj) {
        List<AreaDTO> parenId = areasDAO.getParenId( obj.getParentId() );
        if (obj.getParentName() != null) {
            if ((obj.getParentName().equals( parenId.get( 0 ).getAreaName().trim() )) || (obj.getParentName().equals( parenId.get( 0 ).getAreaCode().trim() ))) {
                return true;
            }
        }
        return false;
    }

// đổ data ra Gid cha
    @Override
    public DataListDTO doSearch(AreaDTO obj) {
////        Long id1;
////        List<Long> id = areasDAO.getmaID();
////        id1 = ((Number) id.get( 0 )).longValue();
        List<AreaDTO> ls = areasDAO.doSearch( obj );
        DataListDTO data = new DataListDTO();
        data.setData( ls );
        data.setTotal( obj.getTotalRecord() );
        data.setSize( obj.getTotalRecord() );

        data.setStart(1);

        return data;
    }

    @Override
    public List<AreaDTO> doSearchTree() {
        return areasDAO.doSearchTree();
    }

    @Override
    public List<AreaDTO> getParen(AreaDTO obj) {
        return areasDAO.getParen( obj );
    }

    // đổ data xuống đơn vị trực thuộc
   @Override
    public DataListDTO doSearchTT(AreaDTO obj, HttpServletRequest request) {
        long id1;
        List<Long> id = areasDAO.getID();
        id1 = ((Number) id.get( 0 )).longValue();
        List<AreaDTO> lsparent = areasDAO.doSearch( obj );
        if (obj.getId() == null) {
            if (lsparent.size() > 0) {
                id1 = lsparent.get( 0 ).getId();
            } else {
                id1 = -1;
            }
        }
        List<AreaDTO> ls = areasDAO.TreeAreas( obj, id1 );
        DataListDTO data = new DataListDTO();
        data.setData( ls );
        data.setTotal( obj.getTotalRecord() );
        data.setSize( obj.getTotalRecord() );
        data.setStart( 1 );
        return data;
    }

    @Override
    public Long delete(AreaDTO obj, HttpServletRequest request) {
        boolean check = false;
        List<AreaDTO> parenId = areasDAO.getIDParen( obj.getId() );
        if (parenId.size() > 0) {
            if ((parenId.get( 0 ).getParentId().equals(obj.getParentId())) && (obj.getId().equals( parenId.get( 0 ).getId() ))) {
                List<AreaDTO> ls = areasDAO.checkparen( obj.getId() );
                for (AreaDTO l : ls) {
                    if (l.getParentName() == null) {
                        check = true;
                        break;
                    }
                }
            } else {
                throw new BusinessException( QlanResource.get( "area_loi" ) );
            }
        } else {
            throw new BusinessException( QlanResource.get( "befor_delete" ) );
        }

        if (!check) {
            throw new BusinessException( QlanResource.get( "could_not_be_deleted" ) );
        } else {
            areasDAO.deleteArea( obj.getId() );
        }
        return obj.getId();

    }


    @Override
    public Long updateArea(AreaDTO obj, HttpServletRequest request) {
        if (checkIn( obj, Edit )) {
            List<AreaDTO> parenId = areasDAO.getIDParen( obj.getId() );
            try {
                if (parenId.get( 0 ).getParentId() == obj.getParentId()) {
                    obj.setAreaCode( obj.getAreaCode().toUpperCase() );
                    if (obj.getParentName() != null) {
                        obj.setParentName( obj.getParentName().toUpperCase() );
                    }
                    obj.setAreaName( UString.string_standardized ( obj.getAreaName() ) );
                    areasDAO.updateArea( obj );
                } else {
                    throw new BusinessException( QlanResource.get( "area_loi" ) );
                }
            } catch (Exception e) {
                System.err.println( "Loi!" );
                throw new BusinessException( QlanResource.get( "area_loi" ) );

            }
        } else {
            throw new BusinessException( QlanResource.get( "area_loi" ) );
        }
        return obj.getId();

    }


    @Override
    public Long addArea(AreaDTO obj, HttpServletRequest request) {
        if (obj.getAreaCode() == null){
            throw  new BusinessException(QlanResource.get("no_areacode"));
        }else if(obj.getAreaName() == null){
            throw  new BusinessException(QlanResource.get("no_areaname"));
        }else if(obj.getStatus() == null){
            throw  new BusinessException(QlanResource.get("no_status"));
        }

        if (checkData( obj, Add )) {
            if (obj.getParentId() == null && UString.isNullOrWhitespace( obj.getParentName() )) {
                obj.setParentId( 0L );
            }
           obj.setAreaCode( obj.getAreaCode().toUpperCase() );

//            đưa hết areaCode và areaName về dạng chữ thường
//            obj.setAreaCode( obj.getAreaCode());
//            obj.setAreaCode( obj.getAreaName());
            //        kiem tra xem ma co trong db chua
            List<AreaDTO> ls = areasDAO.checkAreaCode( obj );
            if (ls.size() == 0) {
//                    Kiểm tra parenid truyền vào có trong database k?
                List<AreaDTO> paren = areasDAO.checkParen( obj );
                if (paren.size() > 0) {

                    try {
//                        ((Number) paren.get( 0 ).getId().longValue()) == ((Number) obj.getParentId().longValue()) )
                        if ((paren.get( 0 ).getId().equals( obj.getParentId() )) && checkAddTT( obj )) {
                            if (obj.getParentName() != null) {
                               obj.setParentName( obj.getParentName().toUpperCase() );
                            }
                            obj.setAreaName( UString.string_standardized( obj.getAreaName() ) );
                            areasDAO.addAreas( obj );
                        } else {
                            throw new BusinessException( QlanResource.get( "area_paren" ) );
                        }
                    } catch (Exception e) {
                        System.out.println( "Error" );
                        throw new BusinessException( QlanResource.get( "area_check_paren" ) );
                    }
                }

                else if (obj.getParentId() == 0) {
                    obj.setAreaName( UString.string_standardized( obj.getAreaName() ) );
                //    obj.setAreaName( ( obj.getAreaName() ) );
                    areasDAO.addAreas( obj );
                } else {
                    throw new BusinessException( QlanResource.get( "area_loi" ) );
                }
            } else {
                throw new BusinessException( QlanResource.get( "area_code" ) );
            }
        } else {
            throw new BusinessException( QlanResource.get( "area_error" ) );
        }
        return 1L;
    }

}
