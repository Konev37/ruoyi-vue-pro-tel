package cn.iocoder.yudao.module.trash.service.trash;

import cn.iocoder.yudao.module.trash.service.trash.TrashService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.trash.controller.admin.trash.vo.*;
import cn.iocoder.yudao.module.trash.dal.dataobject.trash.TrashDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.trash.dal.mysql.trash.TrashMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.trash.enums.ErrorCodeConstants.*;

/**
 * 垃圾桶 Service 实现类
 *
 * @author Bagration C
 */
@Service
@Validated
public class TrashServiceImpl implements TrashService {

    @Resource
    private TrashMapper trashMapper;

    @Override
    public Integer createTrash(TrashSaveReqVO createReqVO) {
        // 插入
        TrashDO trash = BeanUtils.toBean(createReqVO, TrashDO.class);
        trashMapper.insert(trash);
        // 返回
        return trash.getId();
    }

    @Override
    public void updateTrash(TrashSaveReqVO updateReqVO) {
        // 校验存在
        validateTrashExists(updateReqVO.getId());
        // 更新
        TrashDO updateObj = BeanUtils.toBean(updateReqVO, TrashDO.class);
        trashMapper.updateById(updateObj);
    }

    @Override
    public void deleteTrash(Integer id) {
        // 校验存在
        validateTrashExists(id);
        // 删除
        trashMapper.deleteById(id);
    }

    private void validateTrashExists(Integer id) {
        if (trashMapper.selectById(id) == null) {
            throw exception(TRASH_NOT_EXISTS);
        }
    }

    @Override
    public TrashDO getTrash(Integer id) {
        return trashMapper.selectById(id);
    }

    @Override
    public PageResult<TrashDO> getTrashPage(TrashPageReqVO pageReqVO) {
        return trashMapper.selectPage(pageReqVO);
    }

}