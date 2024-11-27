package cn.iocoder.yudao.module.infrastructure.dal.dataobject.infrastr;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.TelDO;
import lombok.*;

import java.time.LocalDate;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 基础设施 DO
 *
 * @author Bagration C
 */
@TableName("infrastructure")
@KeySequence("infrastructure_id_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfrastructureDO extends TelDO {

    /**
     * 基础设施id
     */
    @TableId
    private Integer id;
    /**
     * 设施类型
     */
    private String type;
    /**
     * 设施容量
     */
    private Integer capacity;
    /**
     * 设施配置
     */
    private String configuration;
    /**
     * 地址
     */
    private String address;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 建设时间
     */
    private LocalDateTime constructionDate;
    /**
     * 区域名称
     */
    private String areaName;
    /**
     * 创建人名称
     */
    private String creatorName;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

}