package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="sync_param")
@Entity
public class SyncParam extends BaseFWModelImpl{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="SYNC_PARAM_ID")
  private Long syncParamId;
  @Column(name= "TABLE_NAME")
  private String tableName;
  @Column(name= "LAST_ROWSCN")
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
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}


}
