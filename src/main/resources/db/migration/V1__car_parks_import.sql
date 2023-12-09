/* CREATE TABLE car_parks if not exist */
CREATE TABLE IF NOT EXISTS car_parks (
	car_park_no varchar(10) NOT NULL,
	address TEXT,
	x_coord decimal,
	y_coord decimal ,
	car_park_type varchar(50) ,
	type_of_parking_system varchar(50) ,
	short_term_parking varchar(50) ,
	free_parking varchar(50),
	night_parking varchar(5),
	car_park_decks int4,
	gantry_height decimal,
	car_park_basement varchar(1),
	
	CONSTRAINT car_parks_pkey PRIMARY KEY (car_park_no)
);

CREATE TABLE IF NOT EXISTS carpark_availability (

	carpark_number varchar(10) NOT NULL,
	total_lots int8,
	lot_type  varchar(1),
	lots_available int8 ,
	update_datetime timestamp ,
	
	CONSTRAINT carpark_availability_pkey PRIMARY KEY (carpark_number)
);