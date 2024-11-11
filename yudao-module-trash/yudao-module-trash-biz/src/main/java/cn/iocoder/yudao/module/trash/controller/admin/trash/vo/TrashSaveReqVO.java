package cn.iocoder.yudao.module.trash.controller.admin.trash.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 垃圾桶新增/修改 Request VO")
@Data
public class TrashSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer id;

    @Schema(description = "基础设施id", example = "2")
    private Integer infrastructureId;

    @Schema(description = "是否有分类功能")
    private Boolean hasClassification;

    @Schema(description = "产品型号")
    private String productModel;

    @Schema(description = "状态", example = "空闲")
    private String status;

}