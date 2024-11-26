-- 菜单 SQL
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    10010, '基础设施管理', '', 2, 0, 10003,
    'infrastructure', '', 'infrastructure/infrastr/index', 0, 'Infrastructure'
);

-- 按钮父菜单ID
-- 暂时只支持 MySQL。如果你是 Oracle、PostgreSQL、SQLServer 的话，需要手动修改 @parentId 的部分的代码
-- SELECT @parentId := LAST_INSERT_ID();
DO $$

-- DECLARE
--     parentId int8;
BEGIN
-- SELECT currval(pg_get_serial_sequence('system_menu', 'id')) INTO parentId;

-- 按钮 SQL
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    10007, '基础设施查询', 'base:infrastructure:query', 3, 1, 10010,
    '', '', '', 0
);
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    10008, '基础设施创建', 'base:infrastructure:create', 3, 2, 10010,
    '', '', '', 0
);
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    10009, '基础设施更新', 'base:infrastructure:update', 3, 3, 10010,
    '', '', '', 0
);
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    10010, '基础设施删除', 'base:infrastructure:delete', 3, 4, 10010,
    '', '', '', 0
);
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    10011, '基础设施导出', 'base:infrastructure:export', 3, 5, 10010,
    '', '', '', 0
);

END $$;