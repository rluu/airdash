
create table if not exists users (
	user_id 		bigint			primary key,
	username 		varchar(18)		not null unique,
	password_hash 	varchar			not null,
	first_name		varchar(50),
	middle_name		varchar(50),
	last_name		varchar(50),
    email_address	varchar(100),
	create_dttm		timestamp with time zone	not null,
	update_dttm		timestamp with time zone	not null,
	delete_dttm		timestamp with time zone,
	delete_ind		boolean 					not null	default false,
	enable_ind		boolean						not null	default false
);

create table if not exists role (
	role_id 		bigint			primary key,
	name 			varchar			not null,
	description		varchar			not null,
	create_dttm		timestamp with time zone	not null,
	update_dttm		timestamp with time zone	not null,
	delete_dttm		timestamp with time zone,
	delete_ind		boolean 					not null	default false
);

create table if not exists users_role (
	user_id 		bigint						not null	references users(user_id),
	role_id 		bigint						not null	references role(role_Id),
	create_dttm		timestamp with time zone	not null,
	update_dttm		timestamp with time zone	not null,
	delete_dttm		timestamp with time zone,
	delete_ind		boolean 					not null	default false,
	
	primary key (user_id, role_id)
);

create table if not exists user_verification (
	user_verification_id	bigint	primary key,
	user_id					bigint	not null	references users(user_id),
	token					varchar	not null,
	token_expiration_dttm	timestamp with time zone	not null,
	verified_ind	boolean						not null	default false,
	create_dttm		timestamp with time zone	not null,
	update_dttm		timestamp with time zone	not null,
	delete_dttm		timestamp with time zone,
	delete_ind		boolean 					not null	default false,
)