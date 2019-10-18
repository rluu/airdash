
INSERT INTO ROLE 
	(
		role_id,
		name,
		description,
		create_dttm,
		update_dttm,
		delete_dttm,
		delete_ind
	)
VALUES 
	(
		nextval(role_seq),
		'ADMIN',
		'Administrator.',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		NULL,
		false
	),
	(
		nextval(role_seq),
		'USER',
		'Regular user.',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		NULL,
		false
	);
