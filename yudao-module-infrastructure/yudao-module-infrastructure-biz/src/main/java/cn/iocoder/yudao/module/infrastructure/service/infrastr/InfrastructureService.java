package cn.iocoder.yudao.module.infrastructure.service.infrastr;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.infrastructure.controller.admin.infrastr.vo.*;
import cn.iocoder.yudao.module.infrastructure.dal.dataobject.infrastr.InfrastructureDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 基础设施 Service 接口
 *
 * @author Bagration C
 */
public interface InfrastructureService {

    /**
     * 创建基础设施
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createInfrastructure(@Valid InfrastructureSaveReqVO createReqVO);

    /**
     * 更新基础设施
     *
     * @param updateReqVO 更新信息
     */
    void updateInfrastructure(@Valid InfrastructureSaveReqVO updateReqVO);

    /**
     * 删除基础设施
     *
     * @param id 编号
     */
    void deleteInfrastructure(Integer id);

    /**
     * 获得基础设施
     *
     * @param id 编号
     * @return 基础设施
     */
    InfrastructureDO getInfrastructure(Integer id);

    /**
     * 获得基础设施分页
     *
     * @param pageReqVO 分页查询
     * @return 基础设施分页
     */
    PageResult<InfrastructureDO> getInfrastructurePage(InfrastructurePageReqVO pageReqVO);

}