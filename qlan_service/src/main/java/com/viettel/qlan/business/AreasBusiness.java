package com.viettel.qlan.business;

import com.viettel.qlan.dto.AreaDTO;
import com.viettel.service.base.dto.DataListDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AreasBusiness {
    DataListDTO doSearch(AreaDTO obj);
    DataListDTO doSearchTT(AreaDTO obj, HttpServletRequest request);
    List<AreaDTO> doSearchTree();
    Long delete(AreaDTO areaDTO, HttpServletRequest request);
    Long updateArea(AreaDTO obj, HttpServletRequest request);
    Long addArea(AreaDTO obj, HttpServletRequest request);
    List<AreaDTO> getParen(AreaDTO obj);


}
