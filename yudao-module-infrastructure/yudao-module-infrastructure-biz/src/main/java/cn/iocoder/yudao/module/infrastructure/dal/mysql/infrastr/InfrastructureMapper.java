package cn.iocoder.yudao.module.infrastructure.dal.mysql.infrastr;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.infrastructure.dal.dataobject.infrastr.InfrastructureDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.infrastructure.controller.admin.infrastr.vo.*;

/**
 * 基础设施 Mapper
 *
 * @author Bagration C
 */
@Mapper
public interface InfrastructureMapper extends BaseMapperX<InfrastructureDO> {

    default PageResult<InfrastructureDO> selectPage(InfrastructurePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<InfrastructureDO>()
                .eqIfPresent(InfrastructureDO::getId, reqVO.getId())
                .eqIfPresent(InfrastructureDO::getType, reqVO.getType())
                .eqIfPresent(InfrastructureDO::getCapacity, reqVO.getCapacity())
                .eqIfPresent(InfrastructureDO::getConfiguration, reqVO.getConfiguration())
                .eqIfPresent(InfrastructureDO::getAddress, reqVO.getAddress())
                .eqIfPresent(InfrastructureDO::getLongitude, reqVO.getLongitude())
                .eqIfPresent(InfrastructureDO::getLatitude, reqVO.getLatitude())
                .betweenIfPresent(InfrastructureDO::getConstructionDate, reqVO.getConstructionDate())
                .eqIfPresent(InfrastructureDO::getAreaId, reqVO.getAreaId())
                .eqIfPresent(InfrastructureDO::getCreatorId, reqVO.getCreatorId())
                .eqIfPresent(InfrastructureDO::getCreatedAt, reqVO.getCreatedAt())
                .orderByDesc(InfrastructureDO::getId));
    }

}