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
                .eqIfPresent(FireDO::getId, reqVO.getId()) // 如果 reqVO.getId() 不为空，则添加 id 等值查询条件
                .eqIfPresent(FireDO::getInfrastructureId, reqVO.getInfrastructureId()) // 如果 reqVO.getInfrastructureId() 不为空，则添加 infrastructureId 等值查询条件
//                .betweenIfPresent(FireDO::getMaintenanceDate, reqVO.getMaintenanceDate()) // 如果 reqVO.getMaintenanceDate() 不为空，则添加 maintenanceDate 范围查询条件
                .eqIfPresent(FireDO::getMaintenanceDate, reqVO.getMaintenanceDate()) // 如果 reqVO.getMaintenanceCycle() 不为空，则添加 maintenanceCycle 等值查询条件
                .eqIfPresent(FireDO::getMaintainer, reqVO.getMaintainer()) // 如果 reqVO.getMaintainer() 不为空，则添加 maintainer 等值查询条件
                .eqIfPresent(FireDO::getProductModel, reqVO.getProductModel()) // 如果 reqVO.getProductModel() 不为空，则添加 productModel 等值查询条件
                .eqIfPresent(FireDO::getType, reqVO.getType()) // 如果 reqVO.getType() 不为空，则添加 type 等值查询条件
                .eqIfPresent(FireDO::getStatus, reqVO.getStatus()) // 如果 reqVO.getStatus() 不为空，则添加 status 等值查询条件
                .apply("EXISTS (SELECT 1 FROM infrastructure i WHERE i.id = fire_hydrant.infrastructure_id)") // 添加 area_id 和 dept_id 的比较条件
                .orderByAsc(FireDO::getId)); // 按 id 字段升序排序
    }

}