# springboot-rxjava
Java Springboot + H2 Reactive + Spring 5 Routes + Docker

This is a sample project to demonstrate the use of Spring 5 routes.
Instead of Spring Web features, we use Spring Routes.

This project uses H2 in-memory DB to persist the data.

It uses JPA but the call is converted into Reactive way to process the data.

To run this project, 
`docker build -t sjarvind28/spring5-routes-example .`<br>
`docker images` - To view the newly created image
`docker run -p 8080:8080 sjarvind28/spring5-routes-example`

Then access it via <br>
**GET:**
http://localhost:8080/vendors/all <br>
http://localhost:8080/vendor/2

**POST:**
http://localhost:8080/vendor/create <br>
Content-Type: application/json <br>
Body:
{
  "vendorName": "spring5 router"
}
