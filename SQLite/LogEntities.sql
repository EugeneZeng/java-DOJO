CREATE TABLE LogEntities (
	id INTEGER NOT NULL,
	ip TEXT NOT NULL,
	requestTime INTEGER,
	requestMethod TEXT,
	requestPath TEXT,
	requestVersion TEXT,
	requestStatus INTEGER,
	requestFromUrl TEXT,
	terminalName TEXT,
	terminalVersion TEXT,
	terminalDescription TEXT,
	updateTime INTEGER
) ;
