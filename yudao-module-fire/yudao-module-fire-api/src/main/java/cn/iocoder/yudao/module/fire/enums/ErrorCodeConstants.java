package cn.iocoder.yudao.module.fire.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Infrastr 错误码枚举类
 * <p>
 * Infrastr 系统，使用 1-024-001-001 段
 */
public interface ErrorCodeConstants {

    // ========== 参数配置 1-001-000-000 ==========
    ErrorCode FIRE_NOT_EXISTS = new ErrorCode(1_024_002_001, "消防栓不存在");

}
