package com.sinotopia.pay.notify.dao;


import com.sinotopia.pay.common.core.dao.BaseDao;
import com.sinotopia.pay.notify.entity.RpNotifyRecordLog;


/**
 * @功能说明:
 * @创建者: Peter
 * @创建时间: 16/6/2  上午11:20
 * @公司名称:www.sinotopia.com
 * @版本:V1.0
 */
public interface RpNotifyRecordLogDao extends BaseDao<RpNotifyRecordLog> {


    int deleteByPrimaryKey(String id);

    int insertSelective(RpNotifyRecordLog record);

    RpNotifyRecordLog selectByPrimaryKey(String id);


    int updateByPrimaryKey(RpNotifyRecordLog record);
}