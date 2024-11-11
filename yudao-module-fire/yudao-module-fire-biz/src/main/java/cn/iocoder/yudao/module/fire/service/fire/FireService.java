package cn.iocoder.yudao.module.fire.service.fire;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.fire.controller.admin.fire.vo.*;
import cn.iocoder.yudao.module.fire.dal.dataobject.fire.FireDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 消防栓 Service 接口
 *
 * @author Bagration C
 */
public interface FireService {

    /**
     * 创建消防栓
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createFire(@Valid FireSaveReqVO createReqVO);

    /**
     * 更新消防栓
     *
     * @param updateReqVO 更新信息
     */
    void updateFire(@Valid FireSaveReqVO updateReqVO);

    /**
     * 删除消防栓
     *
     * @param id 编号
     */
    void deleteFire(Integer id);

    /**
     * 获得消防栓
     *
     * @param id 编号
     * @return 消防栓
     */
    FireDO getFire(Integer id);

    /**
     * 获得消防栓分页
     *
     * @param pageReqVO 分页查询
     * @return 消防栓分页
     */
    PageResult<FireDO> getFirePage(FirePageReqVO pageReqVO);

}