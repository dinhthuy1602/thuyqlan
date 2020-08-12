package com.viettel.qlan.business;

import com.viettel.qlan.bo.Objects;
import com.viettel.qlan.dto.ObjectsDTO;
import com.viettel.service.base.dto.DataListDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ObjectsBusiness {
    DataListDTO doSearch(ObjectsDTO obj);
    List<ObjectsDTO> autoSearchObjects (ObjectsDTO obj);
    List<ObjectsDTO> autoSearchObjectsPopup (ObjectsDTO obj);
    Long add(ObjectsDTO obj, HttpServletRequest request) throws Exception;
    Long updateObjects(ObjectsDTO obj, HttpServletRequest request) throws Exception;
    Long lock(ObjectsDTO objectsDTO, HttpServletRequest request) throws Exception;
    Long unlock(ObjectsDTO objectsDTO, HttpServletRequest request) throws Exception;
    Long deleteObjects(ObjectsDTO obj, HttpServletRequest request) throws Exception;
}
