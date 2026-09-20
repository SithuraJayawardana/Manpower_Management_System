-- ==============================================================================
-- Manpower Management System (Labour Placement) - Database Schema
-- Normalized to 3NF (Third Normal Form)
-- Compatible with MySQL (WAMP Server)
-- ==============================================================================

-- 1. Users Table (Authentication & User Roles)
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'OPERATOR',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Client Organizations Table
CREATE TABLE IF NOT EXISTS client_organizations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    org_name VARCHAR(120) NOT NULL,
    contact_person VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL,
    address TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. Skills Catalog Table
CREATE TABLE IF NOT EXISTS skills (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    skill_name VARCHAR(50) NOT NULL UNIQUE,
    category VARCHAR(50),
    description VARCHAR(255),
    standard_daily_rate DECIMAL(10, 2) NOT NULL DEFAULT 0.00
);

-- 4. Labourers Table
CREATE TABLE IF NOT EXISTS labourers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nic_or_id VARCHAR(30) NOT NULL UNIQUE,
    full_name VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address TEXT,
    status VARCHAR(20) NOT NULL DEFAULT 'AVAILABLE', -- AVAILABLE, ASSIGNED, INACTIVE
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 5. Labourer Skills Bridge Table (Resolves M:N relationship to satisfy 3NF)
CREATE TABLE IF NOT EXISTS labourer_skills (
    labourer_id BIGINT NOT NULL,
    skill_id BIGINT NOT NULL,
    proficiency_level VARCHAR(20) DEFAULT 'STANDARD', -- BEGINNER, STANDARD, EXPERT
    PRIMARY KEY (labourer_id, skill_id),
    CONSTRAINT fk_ls_labourer FOREIGN KEY (labourer_id) REFERENCES labourers(id) ON DELETE CASCADE,
    CONSTRAINT fk_ls_skill FOREIGN KEY (skill_id) REFERENCES skills(id) ON DELETE RESTRICT
);

-- 6. Requisitions Table (Manpower Requests from Client Organizations)
CREATE TABLE IF NOT EXISTS requisitions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    organization_id BIGINT NOT NULL,
    skill_id BIGINT NOT NULL,
    required_count INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'OPEN', -- OPEN, PARTIALLY_FILLED, FULFILLED, CANCELLED
    notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_req_org FOREIGN KEY (organization_id) REFERENCES client_organizations(id) ON DELETE RESTRICT,
    CONSTRAINT fk_req_skill FOREIGN KEY (skill_id) REFERENCES skills(id) ON DELETE RESTRICT
);

-- 7. Placements Table (Assigning a Labourer to fulfill a Requisition)
CREATE TABLE IF NOT EXISTS placements (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    requisition_id BIGINT NOT NULL,
    labourer_id BIGINT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    agreed_daily_wage DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE', -- ACTIVE, COMPLETED, TERMINATED
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_placement_req FOREIGN KEY (requisition_id) REFERENCES requisitions(id) ON DELETE RESTRICT,
    CONSTRAINT fk_placement_labourer FOREIGN KEY (labourer_id) REFERENCES labourers(id) ON DELETE RESTRICT
);

-- 8. Attendance Logs Table (Tracking Daily Work & Billing per Placement)
CREATE TABLE IF NOT EXISTS attendance_logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    placement_id BIGINT NOT NULL,
    work_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PRESENT', -- PRESENT, ABSENT, HALF_DAY
    hours_worked DECIMAL(4, 1) NOT NULL DEFAULT 8.0,
    remarks VARCHAR(255),
    logged_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_att_placement FOREIGN KEY (placement_id) REFERENCES placements(id) ON DELETE CASCADE,
    CONSTRAINT uq_placement_date UNIQUE (placement_id, work_date)
);
