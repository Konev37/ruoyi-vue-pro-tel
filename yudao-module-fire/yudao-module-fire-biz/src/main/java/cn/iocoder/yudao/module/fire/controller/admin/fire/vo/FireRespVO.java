package cn.iocoder.yudao.module.fire.controller.admin.fire.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 消防栓 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FireRespVO {

    @Schema(description = "消防栓id", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("消防栓id")
    private Integer id;

    @Schema(description = "基础设施id", example = "1")
    @ExcelProperty("基础设施id")
    private Integer infrastructureId;

    @Schema(description = "维护日期")
    @ExcelProperty("维护日期")
    private LocalDate maintenanceDate;

    @Schema(description = "维护人")
    @ExcelProperty("维护人")
    private String maintainer;

    @Schema(description = "产品型号")
    @ExcelProperty("产品型号")
    private String productModel;

    @Schema(description = "类型", example = "手动泵")
    @ExcelProperty("类型")
    private String type;

    @Schema(description = "状态", example = "状态")
    @ExcelProperty("状态")
    private String status;

}