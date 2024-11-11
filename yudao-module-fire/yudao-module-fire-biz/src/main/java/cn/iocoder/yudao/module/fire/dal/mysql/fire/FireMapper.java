package cn.iocoder.yudao.module.fire.dal.mysql.fire;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.fire.dal.dataobject.fire.FireDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.fire.controller.admin.fire.vo.*;

/**
 * 消防栓 Mapper
 *
 * @author Bagration C
 */
@Mapper
public interface FireMapper extends BaseMapperX<FireDO> {

    default PageResult<FireDO> selectPage(FirePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FireDO>()
                .eqIfPresent(FireDO::getId, reqVO.getId())
                .eqIfPresent(FireDO::getInfrastructureId, reqVO.getInfrastructureId())
                .betweenIfPresent(FireDO::getMaintenanceDate, reqVO.getMaintenanceDate())
                .eqIfPresent(FireDO::getMaintainer, reqVO.getMaintainer())
                .eqIfPresent(FireDO::getProductModel, reqVO.getProductModel())
                .eqIfPresent(FireDO::getType, reqVO.getType())
                .eqIfPresent(FireDO::getStatus, reqVO.getStatus())
                .orderByDesc(FireDO::getId));
    }

}