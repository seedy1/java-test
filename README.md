# My solution to the exercise

## How to Run The Program
1. docker pull melol/matawan-javatest-img found [here](https://hub.docker.com/r/melol/matawan-javatest-img)
2. docker run --publish 8081:8081 melol/matawan-javatest-img
3. Use postman/curl/web browser to make a
> GET request to http://localhost:8081/api/teams

 or

> POST request to http://localhost:8081/api/teams with the following body example
```json

{
  "name": "Lille",
  "acronym": "LLL",
  "budget": 50000,
  "players": [
    {
      "name": "LL Player One",
      "position": "Forward"
    },
    {
      "name": "LL Player Two",
      "position": "Midfielder"
    }
  ]
}

```

or a simple example with no players
```json
{
  "name": "Paris SG",
  "acronym": "PSG",
  "budget": 8000000
}
```

- p.s. you can clone the repo and install java 7/8 with maven and simply press run on your 
favorite java IDE.


## Technical Choices
### Architecture
- This was simple as after I read the problem it gave all the classics requirements of an MVC.

### Technical choices.
**Spring Data JPA**: Provides easy integration with the database.
  `H2 Database`: An in-memory database for simplicity in development and testing. Setting up and migrating a database or docker compose would have been more idea but with t
the time requirement it was easier to have a seeded inmemory database which can easily be changed by 
applying new settings in the `application.yaml file`

**Lombok**: Reduces boilerplate code for getters, setters, toStrings and constructors.

**Docker**: Ensures the application runs consistently across different environments.

**File Structure**: for the current and future size of the application this is a good file structure, and 
it makes it easy to find files.

## What I would add in future
1. routes to get some metrics like get total players in the league, average and total budget for teams and player 
salaries.
2. CI/CD: GitHub CI actions to build test and update docker image in the registry directly.
3. More unit and integration test
4. Error handling 
