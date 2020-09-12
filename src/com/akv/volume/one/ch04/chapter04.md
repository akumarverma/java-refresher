# Charter 4
### 4.1/2/3 Objects and Classes:
      * object declaretion "LocalDate ld;" -> it just declare a object but not initlilized so we can't use it
      * it will throw error if we access methods of object without initialization
      * initialization can be done by new or using assignment( then both refer to same object)
      * factory methods: LocalDate.of(2020,09,10)
      * public, private -> access modifier
      * Instance field should always be private to enforce encaptulation
      * Mutator and accessor -> getters and setters
      * Java compiler find all object referred in file and if need compile it
      * constructor methods can be invoked only through new
      * Constructor -> Same name as class, can have multiple constructor
      * Constructor has no return type and can take parameters
      * Local variables should be have same name as instance variables, they will shadow the instance variables
      * var str = "Amit" --> java 10, str type will be inferred to String
      * can be only used with Local variables, types are needed for parameters and fields
      * NullPointerException -> accessing object when it is not referrring to anything
      * Objects.RequireNotNull can be used in constructor to enforce not null values
      * Implicit and explict parameters -> the object being referred is Implicit parameters(this)
      * anything inside paranthesis are explicit parameters
      * implicit parameters do not occurs in method definition
      * Encaptulation -> private field, public accessor and public mutator
      * Do not write accessor which return reference of mutable objects
      * if object reference need to return, better clone it
      * Objects method can access private data of any object of same class -> a.equals(b)
      * methods of a class can also be private
      * Final instance fields -> must be constructed while initializing the objects, afterwards it can not be changed
      * Immutable class -> not of the methods mutates its fields (String)
      * Final modifiers with Class means object reference can not be changed but its content may change
### 4.4 Static Fields and Methods
      * Static field will have have one copy per class
      * it belong to class and not objects, it will be evaluated first when class loaded
      * should be referred by Class not object
      * Static Constant -> Static final eg. public static final double PI = 3.141414
      * public fields and not recomended but public static final are fine
      * Static methods do not operate on objects -> no this
      * static methods can access static fields, but not instance fields
      * static methods can be invoked by either class or object reference, but Class reference is preferred
      * Use static methods if:
          1. no need to refer instance fields or methods. static methods parameters are enough to compute
          2. need to access only static fields
      * Static factory methods used to construct objects such as LocalDate.of()
      * why factory method not constructor:
          1. constructor name are same as Class name. at times, we need to get different instance of the same class
             such as NumberFormat.getCurrencyInstance() and NumberFormat.getPercentInstance()
          2. Using factory method, we can return different type of objects
             can return DecimalFormat a subclass of NumberFormat
      * main is static claas and entrypoint of the a class. 
      * every class can have a main method for the sake of unit testing
### 4.5 Method Parameters
      * Call by value and call by reference
      * Java always passes parameters using call by value
      * method parameters -> primitive and Object
      * primitive type value changed in method will be effect calling method
      * but object type parameters will impact since while calling the method, Java create a copy of reference and invoke
      * method, so original and copied both refers to same object and hence value can be changed in called methods.
      * object can't be referred to different object in method
### 4.6 object construction
      * class can have multiple constructor
      * overloading occurs if several methods have same name but different parameters
      * Java allows all method overloading including constructor, method name + parameters types -> signature
      * return value is not part of signature
      * objects variables are initialized to default values(0, false and null -> Numbers, boolean, object). 
      * this behaviour is different from local variables
      * if there is no constructor for a class, a default no argument constructor is always supplier which will set the
      * instance variabled to default values
      * if a class has constructor with parameters but no constructor with empty argument, java will not supply a empty
      * parameter constructor and hence object can't be created with empty parameter call of constructor
      * field can also be initialized as part of declaration such as int x = 0; this will be invoked before constructor call
      * constructor parameter name (aName) -> name = aName; or (name) -> this.name -> name
      * if first line of constrctor invokes this(...) it means it invokes another constructor of same class
      * Values can also be initialized in initialization blocks
      * the initialization block will run first follwed by constructor code
      * Order of initialization:
          1. invoke other constructor method in first line using this(...)
          2. initialize the variables to default values
          3. execute variables and block initialization
          4. constructor code will be invoked
          to initialize a static field, either supply initial value or use static initialization block
### 4.7 Packages
      * Package is used to ensure uniqueness of class such as java.util.Date vs java.sql.Date
      * used reversed domain name to give package name
      * A class can use all classes of the package and public class of another package
      * a class can be used with fully qualified name or with shorter name using import
      * we can import whole package or specific class (using *)
      * * is used to import single package, we can't write java.*.*
      * use organize imports to get a explicit list of imports
      * if there is a conflict in import, use fully qualified name
      * import static java.lang.System.out -> import all static fields and methods
      * package name should be first line, followed by imports, followed by rest of class code
      * if package is missing, object will be tagged to unnamed package
      * object files should be stored in directory structure matching package name
      * compiler works on files com/akv/..., JVM loads class with . seperators
      * compiler will not check directory, it will compile the class, but will fail while executing if the file is not in proper directory
      * if there is no access modifier for class or field or method, the scope will be Package. it means it will be accessed
      * by all method in package
      * variables should be private -> having package scope violates encaptulation
      * starting with JDK1.2, it is not allowed to put any class in package starting with java.
### 4.7.6 Class path
      * jar file -> contains classes and subdirectories in compressed format
      * jar files saves space and improve performance
      * jar file uses ZIP to organize classes and directories
      * JVM searches class files as:
          1. look into standard java API class
          2. if not found, it will look into class directory folder, eg. /home/user/classdir/com/akv/Employee.class
          3. look for com/akv/Employee.class starting from current directory
          4. look into archive directory
      * class path:
        /home/user/classdir:.:/home/user/archives/archive.jar
      
      * setting class path:
        java -classpath /home/user/classdir:.:/home/user/archives/archive.jar MyProg
      
      * class path can also be se using CLASSPATH environment variable, but not recommended since global setting can easily be forget
 
### 4.9 Documentation
      * javadoc -> generate html document of class
      * Javadoc extract information from modules, packages, public class and interfaces, public and protected fields
      * and public/protected methods and constructor
      * documnetation comments can have tags @author @params
      * first line should be summary line
      * it can contains html syntax such as <em>,<ul><image>
      * class commented should come after import and before class itself
      * method can have tags such as @params, @return and @throws
      * use javadoc -d docDirectory nameOfPackage to generate documentation
      
### 4.10 Class Design
      * Keep data private
      * always initialize data
      * don't use too many primitive types, refactor in multiple class
      * Not all fields need accessor/mutator
      * refactor class so that it should not have multiple responsibility
      * Class name should be noun representing responsibility
      * perfer immutable classes
      

### revision
      * class path
      * jar files
      * documentation


### Exercises:
      * field initilization, static,param 