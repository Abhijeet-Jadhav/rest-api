Filters are used for authentication.
For using filters you need to implement an interface.
There are two types of filter:
1. Request Filter - implement ContainerRequestFilter
2. Response Filter - implement ContainerResponseFilter

Response filters get executed on success and failure of API calls.

REST APIs are stateless, we cannot have session-cookie based authentication.


Basic Auth:
Look for specific key in request header.


