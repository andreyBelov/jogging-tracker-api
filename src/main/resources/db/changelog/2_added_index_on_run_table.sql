-- liquibase formatted sql

-- changeset belov:1702333312365-1
CREATE INDEX "run_user_id_startDateTime_i" ON run(user_id, start_date_time);