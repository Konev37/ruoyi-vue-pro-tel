package cn.iocoder.yudao.module.infrastructure.controller.admin.infrastr.vo;

import lombok.*;

import java.time.LocalDate;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 基础设施分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InfrastructurePageReqVO extends PageParam {

    @Schema(description = "基础设施id", example = "1")
    private Integer id;

    @Schema(description = "设施类型", example = "消防栓")
    private String type;

    @Schema(description = "设施容量", example = "100")
    private Integer capacity;

    @Schema(description = "设施配置")
    private String configuration;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "经度")
    private BigDecimal longitude;

    @Schema(description = "纬度")
    private BigDecimal latitude;

    @Schema(description = "建设时间")
//    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime constructionDate;

    @Schema(description = "区域id", example = "100")
    private Integer areaId;

    @Schema(description = "创建人id", example = "137")
    private Integer creatorId;

    @Schema(description = "创建时间")
    private LocalDateTime createdAt;

}