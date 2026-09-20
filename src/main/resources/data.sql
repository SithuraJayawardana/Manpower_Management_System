-- ==============================================================================
-- Manpower Management System (Labour Placement) - Initial Test Data (Seed Data)
-- ==============================================================================

-- 1. Initial Users (Passwords can be hashed in production)
INSERT INTO users (username, password_hash, full_name, role) VALUES
('admin', 'admin123', 'System Administrator', 'ADMIN'),
('recruiter1', 'recruit123', 'Sarah Jenkins', 'OPERATOR');

-- 2. Client Organizations
INSERT INTO client_organizations (org_name, contact_person, email, phone, address) VALUES
('Apex Construction Ltd', 'Mr. David Miller', 'contact@apexconstruct.com', '+94112345678', '45 Galle Road, Colombo 03'),
('Metro Civil Infrastructure', 'Ms. Amanda Perera', 'projects@metrocivil.lk', '+94117894561', '120 Kandy Road, Kiribathgoda'),
('Greenfield Agro & Warehousing', 'Mr. Rohan Silva', 'operations@greenfield.lk', '+94332211445', '88 Negombo Road, Ja-Ela');

-- 3. Skills Catalog
INSERT INTO skills (skill_name, category, description, standard_daily_rate) VALUES
('Masonry', 'Construction', 'Bricklaying, plastering, and stone masonry work', 4500.00),
('Carpentry', 'Woodwork', 'Framing, formwork, and roofing woodwork', 4200.00),
('Electrical Assistance', 'Utilities', 'Cable laying, conduit fitting, and panel assistance', 4800.00),
('Plumbing Assistance', 'Utilities', 'Pipe fitting, drainage, and plumbing installation', 4000.00),
('General Helper', 'General', 'Material handling, loading/unloading, and site clearance', 3000.00);

-- 4. Labourers
INSERT INTO labourers (nic_or_id, full_name, phone, address, status) VALUES
('199012345678', 'Kamal Gunaratne', '+94771234567', '12 Temple Road, Maharagama', 'AVAILABLE'),
('198598765432', 'Nimal Jayasuriya', '+94719876543', '34 Station Road, Homagama', 'AVAILABLE'),
('199455667788', 'Sunil Wickramasinghe', '+94765544332', '56 Lake Road, Moratuwa', 'AVAILABLE'),
('199233445566', 'Ruwan Fernando', '+94701122334', '78 Cross Street, Panadura', 'AVAILABLE');

-- 5. Labourer Skills (Bridge Table entries)
INSERT INTO labourer_skills (labourer_id, skill_id, proficiency_level) VALUES
(1, 1, 'EXPERT'),    -- Kamal: Masonry (Expert)
(1, 5, 'STANDARD'),  -- Kamal: General Helper
(2, 2, 'EXPERT'),    -- Nimal: Carpentry (Expert)
(2, 1, 'STANDARD'),  -- Nimal: Masonry (Standard)
(3, 3, 'STANDARD'),  -- Sunil: Electrical Assistance
(4, 5, 'STANDARD');  -- Ruwan: General Helper

-- 6. Sample Requisition (Apex Construction requests 2 Masons)
INSERT INTO requisitions (organization_id, skill_id, required_count, start_date, end_date, status, notes) VALUES
(1, 1, 2, '2026-10-01', '2026-10-15', 'OPEN', 'Commercial high-rise brickwork phase 2'),
(2, 3, 1, '2026-10-05', '2026-10-10', 'OPEN', 'Wiring conduit support for warehouse project');

-- 7. Sample Placement (Kamal assigned to Apex Construction requisition)
INSERT INTO placements (requisition_id, labourer_id, start_date, end_date, agreed_daily_wage, status) VALUES
(1, 1, '2026-10-01', '2026-10-15', 4500.00, 'ACTIVE');

-- 8. Sample Attendance Logs for Placement 1
INSERT INTO attendance_logs (placement_id, work_date, status, hours_worked, remarks) VALUES
(1, '2026-10-01', 'PRESENT', 8.0, 'Day 1 foundation work completed'),
(1, '2026-10-02', 'PRESENT', 8.5, 'Overtime 30 mins for safety inspection');
