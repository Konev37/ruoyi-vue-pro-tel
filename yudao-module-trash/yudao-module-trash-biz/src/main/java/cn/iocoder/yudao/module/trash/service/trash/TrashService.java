package cn.iocoder.yudao.module.trash.service.trash;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.trash.controller.admin.trash.vo.*;
import cn.iocoder.yudao.module.trash.dal.dataobject.trash.TrashDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 垃圾桶 Service 接口
 *
 * @author Bagration C
 */
public interface TrashService {

    /**
     * 创建垃圾桶
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createTrash(@Valid TrashSaveReqVO createReqVO);

    /**
     * 更新垃圾桶
     *
     * @param updateReqVO 更新信息
     */
    void updateTrash(@Valid TrashSaveReqVO updateReqVO);

    /**
     * 删除垃圾桶
     *
     * @param id 编号
     */
    void deleteTrash(Integer id);

    /**
     * 获得垃圾桶
     *
     * @param id 编号
     * @return 垃圾桶
     */
    TrashDO getTrash(Integer id);

    /**
     * 获得垃圾桶分页
     *
     * @param pageReqVO 分页查询
     * @return 垃圾桶分页
     */
    PageResult<TrashDO> getTrashPage(TrashPageReqVO pageReqVO);

}