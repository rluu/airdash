
create table users (
	user_id 		bigint			primary key,
	username 		varchar(50)		not null unique,
	password		varchar			not null,
	first_name		varchar(50),
	middle_name		varchar(50),
	last_name		varchar(50),
    email_address	varchar(100),
    email_address_verified_ind	boolean			not null	default false,
	create_dttm		timestamp with time zone	not null,
	update_dttm		timestamp with time zone	not null,
	delete_dttm		timestamp with time zone,
	delete_ind		boolean 					not null	default false,
	account_expired_ind			boolean			not null	default false,
	account_locked_ind			boolean			not null	default false,
	credentials_expired_ind		boolean			not null	default false,
	enable_ind		boolean						not null	default false
);

create table role (
	role_id 		bigint			primary key,
	name 			varchar			not null,
	description		varchar			not null,
	create_dttm		timestamp with time zone	not null,
	update_dttm		timestamp with time zone	not null,
	delete_dttm		timestamp with time zone,
	delete_ind		boolean 					not null	default false
);

create table users_role (
	user_id 		bigint						not null	references users(user_id),
	role_id 		bigint						not null	references role(role_Id),
	create_dttm		timestamp with time zone	not null,
	update_dttm		timestamp with time zone	not null,
	delete_dttm		timestamp with time zone,
	delete_ind		boolean 					not null	default false,
	
	primary key (user_id, role_id)
);

create table email_verification (
	email_verification_id	bigint	primary key,
	user_id					bigint	not null	references users(user_id),
	token					varchar	not null,
	token_expiration_dttm	timestamp with time zone	not null,
	email_address	varchar(100)				not null,
	verified_ind	boolean						not null	default false,
	verified_dttm	boolean						null,
	create_dttm		timestamp with time zone	not null,
	update_dttm		timestamp with time zone	not null,
	delete_dttm		timestamp with time zone,
	delete_ind		boolean 					not null	default false
);

create table location (
	location_id		bigint			primary key,
	name			varchar			not null unique,
	display_name	varchar			not null,
	description		varchar			not null,
	create_dttm		timestamp with time zone	not null,
	update_dttm		timestamp with time zone	not null,
	delete_dttm		timestamp with time zone,
	delete_ind		boolean 					not null	default false
);

create table chart (
	chart_id		bigint			primary key,
	user_id			bigint			not null		references users(user_id),
	location_id		bigint			not null		references location(location_id),
	name			varchar,
	description		varchar,
	create_dttm		timestamp with time zone	not null,
	update_dttm		timestamp with time zone	not null,
	delete_dttm		timestamp with time zone,
	delete_ind		boolean 					not null	default false
);

create table data_point_type (
	data_point_type_id	bigint		primary key,
	name			varchar			not null unique,
	display_name	varchar			not null,
	abbreviation	varchar			not null,
	description		varchar			not null,
	create_dttm		timestamp with time zone	not null,
	update_dttm		timestamp with time zone	not null,
	delete_dttm		timestamp with time zone,
	delete_ind		boolean 					not null	default false
);

create table data_point (
	data_point_id			bigint				primary key,
	chart_id				bigint				not null	references chart(chart_id),
	data_point_type_id		bigint				not null	references data_point_type(data_point_type_id),
	value					double precision	not null,
	acquire_dttm	timestamp with time zone	not null,
	create_dttm		timestamp with time zone	not null,
	update_dttm		timestamp with time zone	not null,
	delete_dttm		timestamp with time zone,
	delete_ind		boolean 					not null	default false
);
create index chart_id_idx on data_point
(
	chart_id
);
create index data_point_acquire_dttm_idx on data_point
(
	acquire_dttm
);
