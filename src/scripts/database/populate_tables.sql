
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

insert into location
	(
		location_id,
		name,
		display_name,
		description,
		create_dttm,
		update_dttm,
		delete_dttm,
		delete_ind
	)
	values
	(
		nextval('location_seq'),
		'HOME BEDROOM',
		'Home Bedroom',
		'',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		null,
		false
	),
	(
		nextval('location_seq'),
		'HOME OFFICE',
		'Home Office',
		'',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		null,
		false
	),
	(
		nextval('location_seq'),
		'HOME LIVING ROOM',
		'Home Living Room',
		'',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		null,
		false
	),
	(
		nextval('location_seq'),
		'HOME KITCHEN',
		'Home Kitchen',
		'',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		null,
		false
	),
	(
		nextval('location_seq'),
		'WORK OFFICE',
		'Work Office',
		'',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		null,
		false
	),
	(
		nextval('location_seq'),
		'OTHER',
		'Other Location',
		'Other undefined location.',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		null,
		false
	);


insert into chart 
	(
		chart_id,
		user_id,
		location_id,
		name,
		description,
		create_dttm,
		update_dttm,
		delete_dttm,
		delete_ind
	)
values
	(
		nextval('chart_seq'),
		(SELECT user_id FROM users WHERE username = 'ryanuser'),
		(SELECT location_id FROM location WHERE name = 'HOME BEDROOM'),
		'Home Bedroom',
		'',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		null,
		false
	),
	(
		nextval('chart_seq'),
		(SELECT user_id FROM users WHERE username = 'ryanuser'),
		(SELECT location_id FROM location WHERE name = 'HOME OFFICE'),
		'Home Office',
		'',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		null,
		false
	),
	(
		nextval('chart_seq'),
		(SELECT user_id FROM users WHERE username = 'ryanuser'),
		(SELECT location_id FROM location WHERE name = 'HOME LIVING ROOM'),
		'Home Living Room',
		'',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		null,
		false
	),
	(
		nextval('chart_seq'),
		(SELECT user_id FROM users WHERE username = 'ryanuser'),
		(SELECT location_id FROM location WHERE name = 'HOME KITCHEN'),
		'Home Kitchen',
		'',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		null,
		false
	),
	(
		nextval('chart_seq'),
		(SELECT user_id FROM users WHERE username = 'ryanuser'),
		(SELECT location_id FROM location WHERE name = 'WORK OFFICE'),
		'Work Office',
		'',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		null,
		false
	),
	(
		nextval('chart_seq'),
		(SELECT user_id FROM users WHERE username = 'ryanuser'),
		(SELECT location_id FROM location WHERE name = 'OTHER'),
		'Other',
		'',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		null,
		false
	);

insert into data_point_type 
	(
		data_point_type_id,
		name,
		display_name,
		abbreviation,
		description,
		create_dttm,
		update_dttm,
		delete_dttm,
		delete_ind
	)
	values
	(
		nextval('data_point_type_seq'),
		'TEMPERATURE CELCIUS',
		'Temperature in Degrees Celcius',
		'Temp. °C',
		'',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		null,
		false
	),
	(
		nextval('data_point_type_seq'),
		'CARBON DIOXIDE PPM',
		'Carbon Dioxide in PPM',
		'CO₂ PPM',
		'Carbon Dioxide in Parts Per Million',
		CURRENT_TIMESTAMP,
		CURRENT_TIMESTAMP,
		null,
		false
	);

