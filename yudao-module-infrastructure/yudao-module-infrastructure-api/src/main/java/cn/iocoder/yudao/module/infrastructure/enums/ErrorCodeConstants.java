package cn.iocoder.yudao.module.infrastructure.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Infrastr 错误码枚举类
 *
 * Infrastr 系统，使用 1-024-001-001 段
 */
public interface ErrorCodeConstants {

    // ========== 参数配置 1-001-000-000 ==========
    ErrorCode INFRASTRUCTURE_NOT_EXISTS = new ErrorCode(1_024_001_001, "基础设施不存在");

}
