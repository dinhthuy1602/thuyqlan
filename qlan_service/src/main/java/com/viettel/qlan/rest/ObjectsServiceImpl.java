package com.viettel.qlan.rest;

import com.viettel.base.common.BusinessException;
import com.viettel.qlan.business.ObjectsBusinessImpl;
import com.viettel.qlan.dto.ObjectsDTO;
import com.viettel.service.base.dto.DataListDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ObjectsServiceImpl extends AbstractRsService implements ObjectsService {

    @Autowired
    ObjectsBusinessImpl objectsBusinessImpl;

    @Override
    public Response doSearch(ObjectsDTO obj) {
        DataListDTO data = objectsBusinessImpl.doSearch(obj);
        return Response.ok(data).build();
    }

    @Override
    public Response autoSearch(ObjectsDTO obj) {
        List<ObjectsDTO> data = objectsBusinessImpl.autoSearchObjects(obj);
        return Response.ok(data).build();
    }

    @Override
    public Response autoSearchPopup(ObjectsDTO obj) {
        List<ObjectsDTO> data = objectsBusinessImpl.autoSearchObjectsPopup(obj);
        return Response.ok(data).build();
    }

    @Override
    public Response add(ObjectsDTO obj) throws Exception {
        if (obj != null) {
            try {
                return Response.ok(objectsBusinessImpl.add(obj, request)).build();
            } catch (BusinessException e) {
                return Response.ok().entity(Collections.singletonMap("error", e.getMessage())).build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Override
    public Response update(ObjectsDTO obj) throws Exception {
        if (obj != null) {
            try {
                return Response.ok(objectsBusinessImpl.updateObjects(obj, request)).build();
            } catch (Exception e) {
                return Response.ok().entity(Collections.singletonMap("error", e.getMessage())).build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Override
    public Response remove(ObjectsDTO obj) throws Exception {
        if (obj != null) {
            try {
                Long id = objectsBusinessImpl.deleteObjects(obj, request);
                return Response.ok(id).build();
            } catch (BusinessException e) {
                return Response.ok().entity(Collections.singletonMap("error", e.getMessage())).build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Override
    public Response lock(ObjectsDTO obj) throws Exception {
        //objectsBusinessImpl.lock(obj,request);
        if (obj != null) {
            try {
                Long id = objectsBusinessImpl.lock(obj, request);
                return Response.ok(id).build();
            } catch (Exception e) {
                return Response.ok().entity(Collections.singletonMap("error", e.getMessage())).build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Override
    public Response unlock(ObjectsDTO obj) throws Exception {
        if (obj != null) {
            try {
                Long id = objectsBusinessImpl.unlock(obj, request);
                return Response.ok(id).build();
            } catch (Exception e) {
                return Response.ok().entity(Collections.singletonMap("error", e.getMessage())).build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
