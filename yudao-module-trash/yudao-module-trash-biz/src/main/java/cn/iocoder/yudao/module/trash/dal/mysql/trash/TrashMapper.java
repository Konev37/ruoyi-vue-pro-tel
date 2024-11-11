package cn.iocoder.yudao.module.trash.dal.mysql.trash;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.trash.dal.dataobject.trash.TrashDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.trash.controller.admin.trash.vo.*;

/**
 * 垃圾桶 Mapper
 *
 * @author Bagration C
 */
@Mapper
public interface TrashMapper extends BaseMapperX<TrashDO> {

    default PageResult<TrashDO> selectPage(TrashPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TrashDO>()
                .eqIfPresent(TrashDO::getId, reqVO.getId())
                .eqIfPresent(TrashDO::getInfrastructureId, reqVO.getInfrastructureId())
                .eqIfPresent(TrashDO::getHasClassification, reqVO.getHasClassification())
                .eqIfPresent(TrashDO::getProductModel, reqVO.getProductModel())
                .eqIfPresent(TrashDO::getStatus, reqVO.getStatus())
                .apply("EXISTS (SELECT 1 FROM infrastructure i WHERE i.id = trash_can.infrastructure_id)") // 添加 area_id 和 dept_id 的比较条件
                .orderByAsc(TrashDO::getId));
    }

}