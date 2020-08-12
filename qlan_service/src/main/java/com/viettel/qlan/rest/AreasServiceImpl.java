package com.viettel.qlan.rest;

import com.viettel.base.common.BusinessException;
import com.viettel.qlan.business.AreasBusinessImpl;
import com.viettel.qlan.dto.AreaDTO;
import com.viettel.qlan.utils.QlanResource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import java.util.Collections;

public class AreasServiceImpl extends AbstractRsService implements AreasService {

    @Autowired
    private AreasBusinessImpl areasBusinessImpl;


    @Override
    public Response doSearch(AreaDTO obj) {
        return Response.ok( areasBusinessImpl.doSearch( obj ) ).build();
    }

    @Override
    public Response getParen(AreaDTO obj) {
        return Response.ok( areasBusinessImpl.getParen(obj) ).build();
    }

    @Override
    public Response doSearchTree() {
        return Response.ok( areasBusinessImpl.doSearchTree() ).build();
    }

    @Override
    public Response doSearchTT(AreaDTO obj) {
        return Response.ok( areasBusinessImpl.doSearchTT( obj, request ) ).build();
    }

    @Override
    public Response remove(AreaDTO obj) throws Exception {
        if (obj.getId() != null) {
            try {
                Long id = areasBusinessImpl.delete( obj, request );
                return Response.ok( id ).build();
            } catch (BusinessException e) {
                return Response.ok().entity( Collections.singletonMap( "error", e.getMessage() ) ).build();
            }
        } else {
            return Response.status( Response.Status.BAD_REQUEST ).build();
        }
    }

    @Override
    public Response update(AreaDTO obj) throws Exception {
        if (obj != null) {
            try {
                Long id = areasBusinessImpl.updateArea( obj, request );
                return Response.ok( id ).build();
            } catch (BusinessException e) {
                return Response.ok().entity( Collections.singletonMap( "error", e.getMessage() ) ).build();
            }
        } else {
            return Response.status( Response.Status.BAD_REQUEST ).build();
        }

    }

    @Override
    public Response add(AreaDTO obj) throws Exception {
        if (obj != null) {
            try {
                Long id = areasBusinessImpl.addArea( obj, request );
                return Response.ok( id ).build();
            } catch (BusinessException e) {
                return Response.ok().entity( Collections.singletonMap( "error", e.getMessage() ) ).build();
            }
        } else {
            return Response.status( Response.Status.BAD_REQUEST ).build();
        }
    }
}
