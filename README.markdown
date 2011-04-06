# Food Co-op #

## Initializing the database ##

1. Download and install [SQLite 3](http://www.sqlite.org/download.html)
2. Run the following command in the "db" folder in the project root
	directory: `cat schema.sql | sqlite3 database.sqlite3`

### Loading test data ###

Run the following command in the "db" folder in the project root
directory: `cat test_data.sql | sqlite3 database.sqlite3`