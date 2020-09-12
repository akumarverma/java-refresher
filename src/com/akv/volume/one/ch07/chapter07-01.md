# Exeptions
* Issues:
    1. user input error
    2. device error
    3. physical limitation
    4. Code errors
* All exception is an instance of throwable
* throwable -> error, exceptions
* Errors -> internal error or resource exhaustion
* we can't handle Errors, don;t throw errors
* Exception also split into runtime exceptions and others
* RuntimeTimeException means -> a programming error, such as:
    1. a bad cast
    2. null pointer exception
    3. Index out of bound error
* the other sort of error occurs due to some bad condition such as:
    1. Reading a file, not existing
    2. reading a file past end of line
    3. database connection issue
* Thumb rule == if it is RunTimeException -> our fault
* unchecked exception are Errors and RuntimeException
* Checked exceptions are Other exceptions such as IOException
* The compiler checks that we provide exception handler for checked exception
### 7.1.2 Declaring checked exception
* The methods should not only advertise its return type but also errors such as
```$xslt
Public FileInputStream(String fileName) throws FileNotFoundException
```
* The above will return a file object or throws a FileNotFoundException
* if exception occurs, the constructor will not create object
* the invoking process should handle the error
* when to advertise exceptions:
    1. you call a method that throws a checked exception
    2. you detect a error and throws a checked exception
* Other possibilities:
    1. Programming errors: Index out of bound error
    2. Internal errors
* there is no need to advertise these.
* an Exception derived from Error is beyond our control so no need to advertise
* an exception derived from RunTimeError should be handled in method and hence should not be advertised
```$xslt
public f() thorws ArrayIndexOutOfBoundsException
```
* the above is bad practice, we should be handling this in our code
* if a method throws more than one error, we should list all in method header
```$xslt
public Image LoadImage(String s) throws FileNotFoundException,EOFException
```
* if a method fails to declare checked exception, compiler will raise error
* if case of checked exceptions, we can either advertise exceptions or handles the exception
* if case of inheritance, subclass can't throws a more general exception, it can throw a more specific error
* if superclass doesn't advertise an checked exception, the subclass can't advertise exceptions
* when a method declares that it can throw an exception, it can thorw an exception of that class or any of its subclass
* if a method declares a IOException, it can throw a FileNotFoundException which is a subclass of IOException
### 7.1.3 Throwing an Exception
* Steps to raising exceptions:
    1. Find an appropriate exception class
    2. create an instance of exception class
    3. throw exception
    4. declare/handle exception in method
```$xslt
throw new EOFException()
```
or
```$xslt
Exception e = new EOFException()
throw e
```
* then declare this exception in method header
```$xslt
public f() thorws IOException
```
* Once the exception is raised, it will exit the method so no need to bother about dedault return type
### 7.1.4 create  Exception Class
* Create a exception class by extending Exception or a subclass of Exception
* give a default constructor and a details constructor with message
* toString method of Throwable returns a string with detailed error message for debugging purpose
### 7.2 Catching Exceptions
* to catch an exception , use try/catch bock
* if an exception occurs in try block, it will look into matching clause in catch block
* on exception, it will stop execution of try block and start executing catch block
* if no exception occurs in try, catch block will be skipped
* if a method throws an exception of type not having in catch, it will exit immediately
* there is a tradeoff between throwing a checked exception and handling it
* if we know how to handle it, catch it otherwise better to advertise it so that caller can take care of it
* when we propagate an exception it is better to declare it in method header so caller should be aware of it
* you can have multiple catch block, each catch block handle a different exception
* use e.getMessage() to get details about exception
* use e.getClass().getName() to get the name of exception
* we can have multiple exceptions in the same clause using |
    catch (FileNotFoundException | HostNotFoundException)
* when catching multiple exception, the exception variable is final
### 7.2.3. Rethrowing and chaining Exception.
* we can throw an exception in catch block
* normally we do it to modify the exception type
* when developing a subSystem, it is wise to hide internal exception and report subsystem specific exception
* it is also wise to set the original error as root cause of the exception
```$xslt
catch(SQLException original){
e = new ServletException();
e.initCause(original);
throw e;
}
```
* when the exception is caught, the original error can be retrieved as:
```$xslt
Throwable original = catghtException.getCause() 
```
* the approach allows raising high-level exception in subsystems without loosing original exception details
* sometimes we just want to log the exception and re-raise the exception
```$xslt
catch(Exception e){
Logger.log(level, message,e);
throw e;
}
```
### 7.2.4 Finally
* finally clause is used to release resources acquired by method.
* it will always be executed irrespective of the exception scenarios
* we can also use finally clause without catch
* finally clause should not return value, if finally clause has return value it will return in unexpected result.
* the result in finally will mask the result returned by try or catch block
### 7.2.5 Try with resource
```$xslt
try( Resource res = ...){
...
}
```
* when the try block close, it will automatically call res.close
* try with resource is an alternate of try/catch finally
* the resource should implement autoCloseable interface which only has a close method
    "void close() throws Exception"
* we can specify multiple resource in try clause( input and output Stream)
* with Java 9, we can also use previously defined final variable in try clause
* try with resource is elegant then try/catch finally in the sense if finally also throws an exception
* if close method in try with resource throws an exception, the original exception is re-thrown
* the exception caused by closed is suppressed and added to the list of originals with addSuppressed method
* the suppressed errors can be retrieved by getSuppresed method
* A try-with resource statement itself have a catch and even finally clause.
* it will be executed after close method
### 7.2.6 Analyzing stack trace
* A stack trace is list of all pending methods at any point in execution
* to get stack trace use printStackTrace method of Throwable class
* ???
### 7.3 Tips for exception handling
* Don't micromanage exceptions
* make good use of exception class. don't always raise RuntimeException, use appropriate subclass or user defined exception
* don't shut up exception like catch (exception e) {}
* propagate errors whenever necessary
* general rule -> "throw early- catch later"



