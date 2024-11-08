-- 插入区域表数据
INSERT INTO area (name, parent_area_id) VALUES
('区域A', NULL),
('区域B', 1),
('区域C', 1),
('区域D', 2),
('区域E', 2);

-- 插入采集人员表数据
INSERT INTO collector (username, password, area_id, is_admin) VALUES
('user1', 'password1', 1, TRUE),
('user2', 'password2', 2, FALSE),
('user3', 'password3', 3, FALSE),
('user4', 'password4', 4, TRUE),
('user5', 'password5', 5, FALSE);

-- 插入基础设施主表数据
INSERT INTO infrastructure (type, capacity, configuration, address, longitude, latitude, construction_date, area_id, creator_id) VALUES
('消防栓', 1000, '消防设备配置', '地址A', 34.123456, 108.123456, '2022-01-01', 1, 1),
('垃圾桶', 50, '垃圾分类', '地址B', 34.654321, 108.654321, '2022-02-01', 2, 2),
('消防栓', 1200, '消防设备配置', '地址C', 34.234567, 108.234567, '2022-03-01', 3, 3),
('垃圾桶', 60, '垃圾分类', '地址D', 34.345678, 108.345678, '2022-04-01', 4, 4),
('消防栓', 1100, '消防设备配置', '地址E', 34.456789, 108.456789, '2022-05-01', 5, 5),
('垃圾桶', 55, '普通垃圾桶', '地址F', 34.567890, 108.567890, '2022-06-01', 1, 1);

-- 插入消费栓拓展表数据
INSERT INTO fire_hydrant_extension (infrastructure_id, maintenance_date, maintainer, product_model, type, status) VALUES
(1, '2023-01-10', '维护人员A', '型号1', '手动泵', '使用中'),
(3, '2023-02-15', '维护人员B', '型号2', '自动泵', '维修中'),
(5, '2023-03-20', '维护人员C', '型号3', '手动泵', '空闲');

-- 插入垃圾桶拓展表数据
INSERT INTO trash_can_extension (infrastructure_id, has_classification, product_model, status) VALUES
(2, TRUE, '型号A', '空闲'),
(4, TRUE, '型号B', '满载'),
(6, FALSE, '型号C', '损坏');
