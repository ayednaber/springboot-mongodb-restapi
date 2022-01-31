# Building REST API using Spring Boot and MongoDB

To get the files needed for this Spring Boot application, we will navigate to start.spring.io, where we will add the following dependencies:
- Spring Web
- Spring Data MongoDB (NoSQL and Testing (2 dependencies))
- Lombok


## Creating a Docker container for our MongoDB Database
Now, in order to use MongoDB in this case, we will load that from a Docker container.
Therefore, we must make sure that we download Docker Desktop, and then once that is intalled,
visit the following URL: https://raw.githubusercontent.com/amigoscode/mongodb-course/main/docker-compose.yaml

We copy the contents of that file and place it in a file called `docker-compose.yaml`

We place that inside our parent directory, and then we click the green button to run the container, which runs the `docker compose` command,
and starts MongoDB. Another option than running it from the UI like we did is typing the following in the terminal:

`docker compose -f docker-compose.yaml -d`, where -d means detached.

Another part of the `docker-compose.yaml` file is mongoexpress, where if we visit `localhost:8081`, we see our database up and running!
![Mongo Express](readmeimages/mongoexpress.png)

## Creating our Database
Inside src/main/resources, in our `application.properties` file,
we define the following properties for our database:
The username and password are also defined as environment variables in our docker compose yaml file.

```
spring.data.mongodb.authentication-database=admin
spring.data.mongodb.username=rootuser
spring.data.mongodb.password=rootpass
spring.data.mongodb.database=amigoscode
spring.data.mongodb.port=27017
spring.data.mongodb.host=localhost
```
As for the database name, we defined it to be "amigoscode", so we go to our Mongo Express, and we create a database with that name.
![Creating DB in Mongo Express](readmeimages/creatingdb.png)

Now that we defined a connection with our database, if we run our Spring Boot application, it will run successfully, unlike before where it showed a few errors.

## Defining Collections/Documents in our Database
We are trying to have entries in our new database that will look like this:
![Sample Student Entry](readmeimages/samplestudent.png)
Therefore, in our src/main/java/com.example.demomongo, we will create a Student class and we will define all of the above properties.
Note that Gender was defined as an enum class, and Address was also defined as a separate class (since it is a nested document).




