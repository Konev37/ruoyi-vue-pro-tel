package cn.iocoder.yudao.module.infrastructure.service.infrastr;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.infrastructure.controller.admin.infrastr.vo.*;
import cn.iocoder.yudao.module.infrastructure.dal.dataobject.infrastr.InfrastructureDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.infrastructure.dal.mysql.infrastr.InfrastructureMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.infrastructure.enums.ErrorCodeConstants.*;

/**
 * 基础设施 Service 实现类
 *
 * @author Bagration C
 */
@Service
@Validated
public class InfrastructureServiceImpl implements InfrastructureService {

    @Resource
    private InfrastructureMapper infrastructureMapper;

    @Override
    public Integer createInfrastructure(InfrastructureSaveReqVO createReqVO) {
        // 插入
        InfrastructureDO infrastructure = BeanUtils.toBean(createReqVO, InfrastructureDO.class);
        infrastructureMapper.insert(infrastructure);
        // 返回
        return infrastructure.getId();
    }

    @Override
    public void updateInfrastructure(InfrastructureSaveReqVO updateReqVO) {
        // 校验存在
        validateInfrastructureExists(updateReqVO.getId());
        // 更新
        InfrastructureDO updateObj = BeanUtils.toBean(updateReqVO, InfrastructureDO.class);
        infrastructureMapper.updateById(updateObj);
    }

    @Override
    public void deleteInfrastructure(Integer id) {
        // 校验存在
        validateInfrastructureExists(id);
        // 删除
        infrastructureMapper.deleteById(id);
    }

    private void validateInfrastructureExists(Integer id) {
        if (infrastructureMapper.selectById(id) == null) {
            throw exception(INFRASTRUCTURE_NOT_EXISTS);
        }
    }

    @Override
    public InfrastructureDO getInfrastructure(Integer id) {
        return infrastructureMapper.selectById(id);
    }

    @Override
    public PageResult<InfrastructureDO> getInfrastructurePage(InfrastructurePageReqVO pageReqVO) {
        return infrastructureMapper.selectPage(pageReqVO);
    }

}