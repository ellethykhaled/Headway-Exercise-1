### Running PostgreSQL
1. Pull Docker Image
`docker pull postgres`

2. Build data directory
`mkdir -p ~/srv/postgres`

3. Run docker image
`docker run --rm --name p1 -e POSTGRES_PASSWORD=password -d -v $HOME/srv/postgres:/var/lib/postgresql/data -p 5432:5432 postgres`

### Stopping PostgreSQL
`docker stop p1`

### Logging into Database
* `psql -h localhost -U postgres -d company`

### Creating starter data
`psql -h localhost -U postgres -f db_init.sql`

### Initializing tables
`psql -h localhost -U postgres -d company -f tables_init.sql`

### Inserting students and departments
`psql -h localhost -U postgres -d company -f data_insertion.sql`

### Enrolling students into departments
`psql -h localhost -U postgres -d company -f data_insertion.sql`

### Drop database and tables
`psql -h localhost -U postgres db_drop.sql`