package cn.iocoder.yudao.module.trash.controller.admin.trash.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 垃圾桶分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TrashPageReqVO extends PageParam {

    @Schema(description = "id", example = "1")
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