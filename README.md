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







