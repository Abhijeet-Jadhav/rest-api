# Build REST API from scratch 

**Server:** Netty

**Framework:** Jersey 

**Underlying Library:** JAX-RS

**POJOs to JSON and vice-versa:** Jackson (Contains class which implements MessageBodyWriter)
Accept the Class type as argumentd to bind to request body.

**Project/Dependency management system:** Gradle

REST API Application = Application Code + Jersey framework
Jersey framework = JAX-RS (interfaces and annotations) + Implementation Classes

#### Jersey
Jersey is the reference implementation of JAX-RS specification.
JAX-RS is an specification (just a definition) and Jersey is a JAX-RS implementation.

#### Filters Vs Interceptors
* Filter: used to modify the request and response params (headers, URIs)
eg. SecurityFilter, LoggingFilter

* Interceptor: used to manipulate entities (input and output streams)
eg Gzip - to encode the body of message

#### MessageBodyReader Vs MessageBodyWriter

MessageBodyReader : Payload to POJO
MessageBodyWriter : POJO to Payload
 
#### HATEOS
The responses have links that control the application state of the client. 
HATEOAS stands for Hypertext As The Engine Of Application State. 
It means that hypertext should be used to find your way through the API.
 
#### Structure
Model Classes:
Contains the Data

Service Classes:
Manipulate the Data

Resource Classes:
Call the service from Resource class.

POST is done on a collections URL.
PUT is done on a instance URL.

#### @Context annotation
@Context can be used to obtain contextual Java types related to the request or response.
This annotation is used to inject information into a class field, bean property or method parameter.

#### Content Negotiation
Accept header maps to @Produces annotation
Content-Type header maps to @Consumes annotation  

Injecting parameters to member variables:
@QueryParam("name") private String queryParam;
@PathParam("path") private String pathParam;
only works if you override getClasses() of Application class.

Using getSingletons() it will fail because: Singleton resources are instantiated during application startup. So, you
cannot inject request-specific information to their member variables.

## param converters
Jersey does conversion for string in URL to primitive data types.
But we need to use Param Converters to convert data type to custom types.
So, you need to implement ParamConverter and ParamConverterProvider for this.
Jersey searches for some converter to convert from string to instance hence we need to implement ParamConverterProvider.

String -> ParamConverter -> Instance

## Providers
They are used to modify the behaviour of your application at runtime.





