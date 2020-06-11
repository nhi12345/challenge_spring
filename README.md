# challenge_spring
This project was generated with [Spring Boot](https://github.com/spring-projects/spring-boot) version 2.3.0.RELEASE.

# Run Your App Locally
Let's run the app locally first to test that it all works. You must have a Mongo database up and running and accessible on the DATABASE_URL you specified above.

    # Build Your App
    > Task :compileJava
    > Task :processResources UP-TO-DATE
    > Task :classes

    > Task :HelpdeskApplication.main()

    .   ____          _            __ _ _
    /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
    \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
    '  |____| .__|_| |_|_| |_\__, | / / / /
    =========|_|====s==========|___/=/_/_/_/
    :: Spring Boot ::        (v2.3.0.RELEASE)


# Start Your App
Note: you can also start your app using foreman to execute the Procfile. [Read more about foreman and procfiles](http://devcenter.heroku.com/articles/procfile).

# Test it
Go to http://localhost:8080 and test it out by creating a new record.

# Add Authentication
Add email of employee into Authorization to call request

# Connect to database Mongodb
Go to application.properties change Your `spring.data.mongodb.username`, `spring.data.mongodb.password` to connect Your database Mongodb
