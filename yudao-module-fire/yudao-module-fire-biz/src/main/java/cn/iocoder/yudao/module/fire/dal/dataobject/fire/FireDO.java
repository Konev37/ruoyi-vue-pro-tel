package cn.iocoder.yudao.module.fire.dal.dataobject.fire;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.TelDO;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 消防栓 DO
 *
 * @author Bagration C
 */
@TableName("fire_hydrant")
@KeySequence("fire_hydrant_extension_id_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FireDO extends TelDO {

    /**
     * 消防栓id
     */
    @TableId
    private Integer id;
    /**
     * 基础设施id
     */
    private Integer infrastructureId;
    /**
     * 维护日期
     */
    private LocalDateTime maintenanceDate;
    /**
     * 维护人
     */
    private String maintainer;
    /**
     * 产品型号
     */
    private String productModel;
    /**
     * 类型
     */
    private String type;
    /**
     * 状态
     */
    private String status;

}