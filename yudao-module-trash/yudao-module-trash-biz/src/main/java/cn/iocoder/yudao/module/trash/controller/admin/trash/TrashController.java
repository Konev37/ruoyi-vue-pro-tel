package cn.iocoder.yudao.module.trash.controller.admin.trash;

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

import cn.iocoder.yudao.module.trash.controller.admin.trash.vo.*;
import cn.iocoder.yudao.module.trash.dal.dataobject.trash.TrashDO;
import cn.iocoder.yudao.module.trash.service.trash.TrashService;

@Tag(name = "管理后台 - 垃圾桶")
@RestController
@RequestMapping("/infrastructure/trash")
@Validated
public class TrashController {

    @Resource
    private TrashService trashService;

    @PostMapping("/create")
    @Operation(summary = "创建垃圾桶")
    @PreAuthorize("@ss.hasPermission('infrastructure:trash:create')")
    public CommonResult<Integer> createTrash(@Valid @RequestBody TrashSaveReqVO createReqVO) {
        return success(trashService.createTrash(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新垃圾桶")
    @PreAuthorize("@ss.hasPermission('infrastructure:trash:update')")
    public CommonResult<Boolean> updateTrash(@Valid @RequestBody TrashSaveReqVO updateReqVO) {
        trashService.updateTrash(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除垃圾桶")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('infrastructure:trash:delete')")
    public CommonResult<Boolean> deleteTrash(@RequestParam("id") Integer id) {
        trashService.deleteTrash(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得垃圾桶")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infrastructure:trash:query')")
    public CommonResult<TrashRespVO> getTrash(@RequestParam("id") Integer id) {
        TrashDO trash = trashService.getTrash(id);
        return success(BeanUtils.toBean(trash, TrashRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得垃圾桶分页")
    @PreAuthorize("@ss.hasPermission('infrastructure:trash:query')")
    public CommonResult<PageResult<TrashRespVO>> getTrashPage(@Valid TrashPageReqVO pageReqVO) {
        PageResult<TrashDO> pageResult = trashService.getTrashPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TrashRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出垃圾桶 Excel")
    @PreAuthorize("@ss.hasPermission('infrastructure:trash:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTrashExcel(@Valid TrashPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TrashDO> list = trashService.getTrashPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "垃圾桶.xls", "数据", TrashRespVO.class,
                        BeanUtils.toBean(list, TrashRespVO.class));
    }

}