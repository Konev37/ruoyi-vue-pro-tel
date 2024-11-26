-- 菜单 SQL
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status, component_name
)
VALUES (
    10020, '消防栓管理', '', 2, 0, 10003,
    'fire', '', 'infrastructure/fire/index', 0, 'Fire'
);

-- 按钮父菜单ID
-- 暂时只支持 MySQL。如果你是 Oracle、PostgreSQL、SQLServer 的话，需要手动修改 @parentId 的部分的代码
-- SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    10021, '消防栓查询', 'infrastructure:fire:query', 3, 1, 10020,
    '', '', '', 0
);
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    10022, '消防栓创建', 'infrastructure:fire:create', 3, 2, 10020,
    '', '', '', 0
);
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    10023, '消防栓更新', 'infrastructure:fire:update', 3, 3, 10020,
    '', '', '', 0
);
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    10024, '消防栓删除', 'infrastructure:fire:delete', 3, 4, 10020,
    '', '', '', 0
);
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    10025, '消防栓导出', 'infrastructure:fire:export', 3, 5, 10020,
    '', '', '', 0
);