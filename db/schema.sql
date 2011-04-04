BEGIN TRANSACTION;
CREATE TABLE member_discounts (member_id INTEGER PRIMARY KEY AUTOINCREMENT, discounts NUMERIC);
CREATE TABLE member_iou (member_id INTEGER PRIMARY KEY AUTOINCREMENT, iou_amount NUMERIC);
CREATE TABLE members (id INTEGER PRIMARY KEY AUTOINCREMENT, first_name TEXT, last_name TEXT, email_address TEXT, last_signup_date TEXT, membership_length TEXT, membership_type TEXT, year_in_school NUMERIC, recieve_email NUMERIC, is_active NUMERIC);
CREATE TABLE schedule (id INTEGER PRIMARY KEY AUTOINCREMENT, day NUMERIC, hour NUMERIC, coordinator_id NUMERIC, number_of_volunteers NUMERIC);
CREATE TABLE shifts (id INTEGER PRIMARY KEY AUTOINCREMENT, start_time TEXT, shift_length NUMERIC, job_type TEXT);
COMMIT;
