-- 菜单 SQL
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status, component_name
)
VALUES (
    10030, '垃圾桶管理', '', 2, 0, 10003,
    'trash', '', 'infrastructure/trash/index', 0, 'Trash'
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
    10031, '垃圾桶查询', 'infrastructure:trash:query', 3, 1, 10030,
    '', '', '', 0
);
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
   10032, '垃圾桶创建', 'infrastructure:trash:create', 3, 2, 10030,
    '', '', '', 0
);
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    10033, '垃圾桶更新', 'infrastructure:trash:update', 3, 3, 10030,
    '', '', '', 0
);
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    10034, '垃圾桶删除', 'infrastructure:trash:delete', 3, 4, 10030,
    '', '', '', 0
);
INSERT INTO system_menu(
    id, name, permission, type, sort, parent_id,
    path, icon, component, status
)
VALUES (
    10035, '垃圾桶导出', 'infrastructure:trash:export', 3, 5, 10030,
    '', '', '', 0
);