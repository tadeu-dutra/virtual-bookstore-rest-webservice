## JAX-RS Web Service app using Jersey Servlet Container


## Media Types

### a) JSON

curl -X GET "http://localhost:8080/virtual-bookstore/book" \
     -H "Accept: application/json"


### b) XML

curl -X GET "http://localhost:8080/virtual-bookstore/book" \
     -H "Accept: application/xml"

### c) Get By Id

curl -X GET "http://localhost:8080/virtual-bookstore/book/ISBN-1234"

### d) Interface Uniform. All operations done using the same URI. For example:

GET     /book
GET     /book/{id}
- Testar com Accept json and xml
- check status code 200
- check <searchItem> tag with <book> + <links>
POST    /book       needs Content-Type as either json or xml (based on @Consumes annotation). Create tests validating 201, varying Accept and Content-Type with both json and xml. Also, test duplicate id (conflict)
PUT     /book/{id}
DELETE  /book/{id} - should return No Content (void)

### e) Use of the custom BookNotFoundException to return 404

curl -X GET "http://localhost:8080/virtual-bookstore/book/INEXISTENT"

### f) add book

curl -X POST http://localhost:8080/virtual-bookstore/book/ \
     -H "Content-Type: application/xml" \
     -H "Accept: application/xml" \
     --data '
<book id="3">
  <title>Book C</title>
  <isbn>ISBN-5678</isbn>
  <genre>Genre C</genre>
  <price>199.99</price>
  <author id="2">
    <name>Author 2</name>
  </author>
</book>'

curl -X POST http://localhost:8080/virtual-bookstore/book   -H "Content-Type: application/json"   -H "Accept: application/json"   --data '{
    "id": 3,
    "title": "Book C",
    "isbn": "ISBN-5678",
    "genre": "Genre C",
    "price": 199.99,
    "author": [{
      "id": 3,
      "name": "Author 3"
    }]
  }'

### g) Add exception to avoid duplicate book

BookExistentException

### h) update book

curl -X PUT http://localhost:8080/virtual-bookstore/book/ISBN-1234   -H "Content-Type: application/json"   --data '{
    "id": 1,
    "title": "Book X",
    "isbn": "ISBN-1010",
    "genre": "Genre A",
    "price": 1.99,
    "author": [{
      "id": 7,
      "name": "Author 1"
    }]
  }'

### h) removeBook

It will return a 204 status (No Content)


### i) HATEOAS
SearchItem.java - add test to getBookByIsbn

