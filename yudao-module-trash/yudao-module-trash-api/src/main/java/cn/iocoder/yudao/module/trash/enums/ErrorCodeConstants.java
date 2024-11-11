package cn.iocoder.yudao.module.trash.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Trash 错误码枚举类
 * <p>
 * Trash 系统，使用 1-024-003-001 段
 */
public interface ErrorCodeConstants {

    // ========== 参数配置 1-001-000-000 ==========
    ErrorCode TRASH_NOT_EXISTS = new ErrorCode(1_024_003_001, "垃圾桶不存在");

}
