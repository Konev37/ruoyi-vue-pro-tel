package cn.iocoder.yudao.module.fire.controller.admin.fire.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 消防栓新增/修改 Request VO")
@Data
public class FireSaveReqVO {

    @Schema(description = "消防栓id", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer id;

    @Schema(description = "基础设施id", example = "1")
    private Integer infrastructureId;

    @Schema(description = "维护日期")
    private LocalDate maintenanceDate;

    @Schema(description = "维护人")
    private String maintainer;

    @Schema(description = "产品型号")
    private String productModel;

    @Schema(description = "类型", example = "手动泵")
    private String type;

    @Schema(description = "状态", example = "状态")
    private String status;

}