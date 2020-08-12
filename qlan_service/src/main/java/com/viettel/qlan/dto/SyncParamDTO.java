package com.viettel.qlan.dto;

import com.viettel.qlan.bo.SyncParam;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */


public class SyncParamDTO extends QlanBaseDTO<SyncParam>{

  private Long syncParamId;

  private String tableName;

  private Long lastRowscn;

  public Long getSyncParamId() {
    return syncParamId;
  }

  public void setSyncParamId(Long syncParamId) {
    this.syncParamId = syncParamId;
  }
  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public Long getLastRowscn() {
    return lastRowscn;
  }

  public void setLastRowscn(Long lastRowscn) {
    this.lastRowscn = lastRowscn;
  }
  @Override
  public String toString() {
  	return "sync_param{"+
     "tableName :" + tableName + ","+
     "lastRowscn :" + lastRowscn + ","+
   "}";
  }

@Override
public String catchName() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Long getFWModelId() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public SyncParam toModel() {
	// TODO Auto-generated method stub
	return null;
}


}
