package cn.iocoder.yudao.module.infrastructure.controller.admin.infrastr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.infrastructure.controller.admin.infrastr.vo.*;
import cn.iocoder.yudao.module.infrastructure.dal.dataobject.infrastr.InfrastructureDO;
import cn.iocoder.yudao.module.infrastructure.service.infrastr.InfrastructureService;

@Tag(name = "管理后台 - 基础设施")
@RestController
@RequestMapping("/infrastructure/infrastr")
@Validated
@Slf4j
public class InfrastructureController {

    @Resource
    private InfrastructureService infrastructureService;

    @PostMapping("/create")
    @Operation(summary = "创建基础设施")
    @PreAuthorize("@ss.hasPermission('infrastructure:infrastr:create')")
    public CommonResult<Integer> createInfrastructure(@Valid @RequestBody InfrastructureSaveReqVO createReqVO) {
        return success(infrastructureService.createInfrastructure(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新基础设施")
    @PreAuthorize("@ss.hasPermission('infrastructure:infrastr:update')")
    public CommonResult<Boolean> updateInfrastructure(@Valid @RequestBody InfrastructureSaveReqVO updateReqVO) {
        infrastructureService.updateInfrastructure(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除基础设施")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('infrastructure:infrastr:delete')")
    public CommonResult<Boolean> deleteInfrastructure(@RequestParam("id") Integer id) {
        infrastructureService.deleteInfrastructure(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得基础设施")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infrastructure:infrastr:query')")
    public CommonResult<InfrastructureRespVO> getInfrastructure(@RequestParam("id") Integer id) {
        InfrastructureDO infrastructure = infrastructureService.getInfrastructure(id);
        return success(BeanUtils.toBean(infrastructure, InfrastructureRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得基础设施分页")
    @PreAuthorize("@ss.hasPermission('infrastructure:infrastr:query')")
//    @PermitAll
    public CommonResult<PageResult<InfrastructureRespVO>> getInfrastructurePage(@Valid InfrastructurePageReqVO pageReqVO) {
        PageResult<InfrastructureDO> pageResult = infrastructureService.getInfrastructurePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, InfrastructureRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出基础设施 Excel")
    @PreAuthorize("@ss.hasPermission('infrastructure:infrastr:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportInfrastructureExcel(@Valid InfrastructurePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<InfrastructureDO> list = infrastructureService.getInfrastructurePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "基础设施.xls", "数据", InfrastructureRespVO.class,
                        BeanUtils.toBean(list, InfrastructureRespVO.class));
    }

}