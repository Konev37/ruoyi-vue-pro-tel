package cn.iocoder.yudao.module.fire.controller.admin.fire;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

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

import cn.iocoder.yudao.module.fire.controller.admin.fire.vo.*;
import cn.iocoder.yudao.module.fire.dal.dataobject.fire.FireDO;
import cn.iocoder.yudao.module.fire.service.fire.FireService;

@Tag(name = "管理后台 - 消防栓")
@RestController
@RequestMapping("/infrastructure/fire")
@Validated
public class FireController {

    @Resource
    private FireService fireService;

    @PostMapping("/create")
    @Operation(summary = "创建消防栓")
//    @PreAuthorize("@ss.hasPermission('infrastructure:fire:create')")
    public CommonResult<Integer> createFire(@Valid @RequestBody FireSaveReqVO createReqVO) {
        return success(fireService.createFire(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新消防栓")
//    @PreAuthorize("@ss.hasPermission('infrastructure:fire:update')")
    public CommonResult<Boolean> updateFire(@Valid @RequestBody FireSaveReqVO updateReqVO) {
        fireService.updateFire(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除消防栓")
    @Parameter(name = "id", description = "编号", required = true)
//    @PreAuthorize("@ss.hasPermission('infrastructure:fire:delete')")
    public CommonResult<Boolean> deleteFire(@RequestParam("id") Integer id) {
        fireService.deleteFire(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得消防栓")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
//    @PreAuthorize("@ss.hasPermission('infrastructure:fire:query')")
    public CommonResult<FireRespVO> getFire(@RequestParam("id") Integer id) {
        FireDO fire = fireService.getFire(id);
        return success(BeanUtils.toBean(fire, FireRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得消防栓分页")
//    @PreAuthorize("@ss.hasPermission('infrastructure:fire:query')")
    public CommonResult<PageResult<FireRespVO>> getFirePage(@Valid FirePageReqVO pageReqVO) {
        PageResult<FireDO> pageResult = fireService.getFirePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FireRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出消防栓 Excel")
//    @PreAuthorize("@ss.hasPermission('infrastructure:fire:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportFireExcel(@Valid FirePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<FireDO> list = fireService.getFirePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "消防栓.xls", "数据", FireRespVO.class,
                        BeanUtils.toBean(list, FireRespVO.class));
    }

}