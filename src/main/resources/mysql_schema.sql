CREATE TABLE IF NOT EXISTS projects (
	id BIGINT auto_increment NOT NULL,
	project_name varchar(255) NOT NULL,
	project_desc varchar(255) NOT NULL,
	project_active BOOL NOT NULL,
	starting_date DATE NULL,
	go_uat_date DATE NULL,
	go_live_date DATE NULL,
	created_on DATETIME NULL,
	modified_on DATETIME NULL,
	CONSTRAINT projects_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;