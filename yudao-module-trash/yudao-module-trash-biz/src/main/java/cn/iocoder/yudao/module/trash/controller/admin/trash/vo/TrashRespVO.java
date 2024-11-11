package cn.iocoder.yudao.module.trash.controller.admin.trash.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 垃圾桶 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TrashRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("id")
    private Integer id;

    @Schema(description = "基础设施id", example = "2")
    @ExcelProperty("基础设施id")
    private Integer infrastructureId;

    @Schema(description = "是否有分类功能")
    @ExcelProperty("是否有分类功能")
    private Boolean hasClassification;

    @Schema(description = "产品型号")
    @ExcelProperty("产品型号")
    private String productModel;

    @Schema(description = "状态", example = "空闲")
    @ExcelProperty("状态")
    private String status;

}