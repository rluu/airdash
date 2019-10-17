


create table if not exists users (
	id 				bigint			primary key,
	username 		varchar(18)		not null,
	password_hash 	varchar,
	first_name		varchar(50),
	middle_name		varchar(50),
	last_name		varchar(50),
	create_dttm		timestamp with time zone	not null,
	update_dttm		timestamp with time zone	not null,
	delete_dttm		timestamp with time zone,
	delete_ind		boolean default false		not null
);
