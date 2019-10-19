
INSERT INTO users
	(
		user_id,
		username,
		password,
		first_name,
		middle_name,
		last_name,
		email_address,
		email_address_verified_ind,
		create_dttm,
		update_dttm,
		delete_dttm,
		delete_ind,
		account_expired_ind,
		account_locked_ind,
		credentials_expired_ind,
		enable_ind
	)
VALUES
	(
		nextval('users_seq'),
		'ryanadmin',
		'password',
		'RyanAdminFirst',
		'RyanAdminMiddle',
		'RyanAdminLast',
		'RyanAdmin@ryan.com',
		false,
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		NULL,
		FALSE,
		false,
		false,
		false,
		TRUE
	),
	(
		nextval('users_seq'),
		'ryanuser',
		'password',
		'RyanUserFirst',
		'RyanUserMiddle',
		'RyanUserLast',
		'RyanUser@ryan.com',
		false,
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		NULL,
		FALSE,
		false,
		false,
		false,
		TRUE
	);



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
		nextval('role_seq'),
		'ADMIN',
		'Administrator.',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		NULL,
		false
	),
	(
		nextval('role_seq'),
		'USER',
		'Regular user.',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		NULL,
		false
	);


INSERT INTO users_role
	(
		user_id,
		role_id,
		create_dttm,
		update_dttm,
		delete_dttm,
		delete_ind
	)
VALUES
	(
		(SELECT user_id FROM users WHERE username = 'ryanadmin'),
		(SELECT role_id FROM role WHERE name = 'ADMIN'),
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		NULL,
		false
	),
	(
		(SELECT user_id FROM users WHERE username = 'ryanuser'),
		(SELECT role_id FROM role WHERE name = 'USER'),
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		NULL,
		false
	);
