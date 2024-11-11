package cn.iocoder.yudao.module.fire.service.fire;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.fire.controller.admin.fire.vo.*;
import cn.iocoder.yudao.module.fire.dal.dataobject.fire.FireDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.fire.dal.mysql.fire.FireMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.fire.enums.ErrorCodeConstants.*;

/**
 * 消防栓 Service 实现类
 *
 * @author Bagration C
 */
@Service
@Validated
public class FireServiceImpl implements FireService {

    @Resource
    private FireMapper fireMapper;

    @Override
    public Integer createFire(FireSaveReqVO createReqVO) {
        // 插入
        FireDO fire = BeanUtils.toBean(createReqVO, FireDO.class);
        fireMapper.insert(fire);
        // 返回
        return fire.getId();
    }

    @Override
    public void updateFire(FireSaveReqVO updateReqVO) {
        // 校验存在
        validateFireExists(updateReqVO.getId());
        // 更新
        FireDO updateObj = BeanUtils.toBean(updateReqVO, FireDO.class);
        fireMapper.updateById(updateObj);
    }

    @Override
    public void deleteFire(Integer id) {
        // 校验存在
        validateFireExists(id);
        // 删除
        fireMapper.deleteById(id);
    }

    private void validateFireExists(Integer id) {
        if (fireMapper.selectById(id) == null) {
            throw exception(FIRE_NOT_EXISTS);
        }
    }

    @Override
    public FireDO getFire(Integer id) {
        return fireMapper.selectById(id);
    }

    @Override
    public PageResult<FireDO> getFirePage(FirePageReqVO pageReqVO) {
        return fireMapper.selectPage(pageReqVO);
    }

}