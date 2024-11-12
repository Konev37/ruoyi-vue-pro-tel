package cn.iocoder.yudao.module.fire.controller.admin.fire.vo;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 消防栓分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FirePageReqVO extends PageParam {

    @Schema(description = "消防栓id", example = "1")
    private Integer id;

    @Schema(description = "基础设施id", example = "1")
    private Integer infrastructureId;

    @Schema(description = "维护日期")
//    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime maintenanceDate;

    @Schema(description = "维护人")
    private String maintainer;

    @Schema(description = "产品型号")
    private String productModel;

    @Schema(description = "类型", example = "手动泵")
    private String type;

    @Schema(description = "状态", example = "状态")
    private String status;

}