# Charter 5
### 5.1 Super class, subclass:
      * "is-a" is hallmark for inheritance(extends keyword)
      * superclass, baseclass, parentclass -> subclass, derived class or childclass
      * super and sub comes from set theory, employee is superset of Managers
      * sub class can invoke parent class methods, we only need to define differences
      * subclass can override super class method
      * subclass don't have direct access of superclass private fields
      * need to use accessor -> super.getSalary()
      * super vs this -> super is not a reference of object
      * subclass constrctor can use super() to invoke super class constructor
      * Since super private members are not directly accesible from sub class, it must be initialized through super
      * super must be first statement in sub class constructor
      * if subclass do not invoke super class constructor, a empty constructor will be invoked
      * if super class don't have empty paramaters constructor, the compiler will error
      * purpose of this: implicit parameter, invoke another constructor of same class
      * purpose of supler: call super class methods and constructors
      * var employees = new Employee[3] --> we can store employee and managers in this array
      * the getSalary method will call either Employee or Manager getSalary depending upon the object  being referred
### 5.1.5 Polymorphism
      * the appropriate call of different method at runtime is called dynamic binding
      * The JVM know actual type of object being referred and call appropriate method
      * a variable of Empyolee type can refer to either employee or manager class object
      * object variables are polymorphic
          * Manager manager = new Manager(...)
          * Employee[] employees = new Employee(3)
          * employees[0] = manager   // this is ok
          * but employee[0].setBonus will not compile since employee is of Class Employee that does not have setBonus method
      * we can't assign a superclass reference to subClass eg, Manager[] manager = new Employee(3) -> will not compile
      * the reason is all employees are not manager
      * it is allowed to convert a array of subclass to array of superclass
          * Manager[] bosses = new Manager[3]
          * Employee[] employees = bosses
      * but assigning a employee will throw a runtime exception(ArrayStoreException)
          * employee[0] = new Employee(...) -> runtime error
### 5.1.6 Understanding method call x.f(args)
      * the complier looks for f in current class as well as super class
      * comipler will try to find unique f among the condidates eg. f(String), f(Int)
      * things can be complicated due to conversion (int to Long, Manager to employee)
      * if multiple method matches, compiler will throw error
      * name and parameter type list defines signature
      * if subclass has same signature as super, it is called override
      * return type does not contribute to signature
      * we should override the method in subclass with the same access level
### 5.1.7 Final class and methods
      * final class -> will not allow subclassing
      * methods can also be final, it means it can not be overridden
      * a final field can not be mutated after initialization
      * String is final class-> no subclassing possible
      * inling -> e.getName => e.name -> complier translation
      * if method is overridden, the inling will not take place
      * if method is short, frequently used and not overridden -> just in time compiler will inline it
### 5.1.8 Casting
      * forcing a conversion from one type to another
      * casting is needed to get full capacity of a actual type, Manager boss = (Manager) staff[0] to invoke getBonus method
      * subclass reference to superclass variable -> promising less eg. Employee boss = new Manager()
      * superclass reference to subclass variable -> promising more eg. Manager emp = new Employee()  --> not allowed 
      * at runtime, it will raise ClassCastException.
      * before casting, test eg, boss InstanceOf(Employee)
      * we can use cast in same inheritence hierarchy
      * casting is not a good practice, better to minimize the use of cast and isntanceOf
### 5.1.9 Abstract Class
      * if a method is abstract then there is no need to define it
      * a class with abstract method must be abstract
      * a abstract class can have concrete methods and fields
      * a abstract class can not be instaitiated, but we can define variables of abstract class
      * A class can be abstract even if there is no abstract method
      * a subclass can implement abstract method or be abstract
### 5.1.10 Protected Access
      * A subclass cannot access private member of this superclass
      * protected allow subclass accessing fields of superclass but in same package
      * subclass in other package will not have access of protected members
      * private -> accessible inside class
      * public -> accessible to the world
      * protected -> accessible to subclass inside package
      * default  -> accessible to package

### revision
      * Polymorphism, method call


### Exercises:
      * Polymorphism, method call