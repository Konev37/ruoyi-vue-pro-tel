-- 创建区域表
CREATE TABLE area (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    parent_area_id INTEGER REFERENCES area(id)
);

-- 创建采集人员表
CREATE TABLE collector (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    area_id INTEGER REFERENCES area(id),
    is_admin BOOLEAN DEFAULT FALSE
);

-- 创建基础设施主表
CREATE TABLE infrastructure (
    id SERIAL PRIMARY KEY,
    type VARCHAR(50) NOT NULL CHECK (type IN ('消防栓', '垃圾桶')),
    capacity INTEGER,
    configuration TEXT,
    address VARCHAR(255),
    longitude DECIMAL(9, 6),
    latitude DECIMAL(9, 6),
    construction_date DATE,
    area_id INTEGER REFERENCES area(id),
    creator_id INTEGER REFERENCES collector(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 创建消费栓拓展表
CREATE TABLE fire_hydrant_extension (
    id SERIAL PRIMARY KEY,
    infrastructure_id INTEGER REFERENCES infrastructure(id),
    maintenance_date DATE,
    maintainer VARCHAR(50),
    product_model VARCHAR(50),
    type VARCHAR(50) CHECK (type IN ('手动泵', '自动泵')),
    status VARCHAR(50) CHECK (status IN ('使用中', '空闲', '损坏', '维修中'))
);

-- 创建垃圾桶拓展表
CREATE TABLE trash_can_extension (
    id SERIAL PRIMARY KEY,
    infrastructure_id INTEGER REFERENCES infrastructure(id),
    has_classification BOOLEAN,
    product_model VARCHAR(50),
    status VARCHAR(50) CHECK (status IN ('空闲', '满载', '损坏', '维修中'))
);
