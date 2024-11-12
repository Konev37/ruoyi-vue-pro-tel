package cn.iocoder.yudao.module.infrastructure.controller.admin.infrastr.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 基础设施新增/修改 Request VO")
@Data
public class InfrastructureSaveReqVO {

    @Schema(description = "基础设施id", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer id;

    @Schema(description = "设施类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "消防栓")
    @NotEmpty(message = "设施类型不能为空")
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
    private LocalDateTime constructionDate;

    @Schema(description = "区域id", example = "100")
    private Integer areaId;

    @Schema(description = "创建人id", example = "137")
    private Integer creatorId;

    @Schema(description = "创建时间")
    private LocalDateTime createdAt;

}