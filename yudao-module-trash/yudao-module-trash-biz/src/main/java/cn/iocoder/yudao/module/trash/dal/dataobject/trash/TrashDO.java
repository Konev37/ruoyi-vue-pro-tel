package cn.iocoder.yudao.module.trash.dal.dataobject.trash;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.TelDO;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 垃圾桶 DO
 *
 * @author Bagration C
 */
@TableName("trash_can")
@KeySequence("trash_can_extension_id_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrashDO extends TelDO {

    /**
     * id
     */
    @TableId
    private Integer id;
    /**
     * 基础设施id
     */
    private Integer infrastructureId;
    /**
     * 是否有分类功能
     */
    private Boolean hasClassification;
    /**
     * 产品型号
     */
    private String productModel;
    /**
     * 状态
     */
    private String status;

}