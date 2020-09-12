# Charter 5
### 5.2 Object, The cosmic superclass:
    * Object is ancestor of all java class, no need to inherit it explicitly using extends
    * Arrays are also object
    * Object obj = new Employee(...), use cast to get a employee instance
    * defines method like equals, hashcode, toString, ==, !=
    * equals method in Objects compares references
    * equality rules: reflexive, symmetric,transitive, consistant, for any non null reference x.equals(null) should be false
    * rules for good equala method:
        1. name the parameter as otherObject, later cast it to Other
        2. test this is equals to otherobject, retuern true
        3. test otherObject is null, return false
        4.1. compare getClass of this and otherObject
             if (this.getClass() != otherObject.getClass()) return false
        4.2  check instanceOf
             if !(otherObject istanceof(ClassName) return false
        5. cast otherObject as ClassName
        6. compare fields, primitive types with == and objects with equals
    * HashCode
    * is a integer value derived from object
    * hascode in objects is derived from memory address
    * same objects will have same hashCode
    * if we have defined equals, we should be defining hashCode also
    * equals and hashCode should be compitable, if equals is defined using employee ID, hascode should also be defined
      using employee ID
    * use Arrays.hashCode and Arrays.Equals for Arrays
    * toString: 
    * normally it should be ClassName[FieldNames: values]
    * use getClass.getName to get class name
    * whenever we have + on String, the java will invoke toString on other operand
    * s.toString === ""+ s
    * System.out.println(x) also invokes x.toString()
    * Arrays inherit toString from Objects, to get String representation use Arrays.toString(x)
    * for multidimensional array use Arrays.deepToString
    * toString is great logging tool, use either with System.out.println or Logger
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
### 5.3 Generic ArrayList
      * ArrayList allows elements to be added or removed without capacity consideration
      * ArrayList is generic class with type parameter ArrayList<Employee>
      * ArrayList<Employee> employees = new ArrayList<>()
      * <> is called diamond operator
      * ArrayList internally manage a array, if array is full it will be automatically create a big array
        and copy elements to new Array
      * the size of arrayList can be specified with ensureCapacity()
      * there is difference in array and ArrayList capacity. Array[100] allocated 100 spaces
        whereas ArrayList with 100 capacity is blank.
      * timeToSize removes any unused space in ArrayList
      * use set method to replace whereas add to add element.
      * don't use set if element is not already available
      * use toArray to move arrayList to Arrays
      * ArrayList is not efficient for adding and removing element in middle of list, if this is needed use LinkedList
### 5.4 Object wrappers and autoboxing
      * all primitive types has a corersponding wrapper class
      * type parameter in generic cannot be primitive type
      * but we can use ArrayList<Integer>
      * ArrayList<Integer> is far less efficient than int[] because each value is wrapped inside object
      * list.add(3) converts to list.add(Integer.valueOf(3))
      * the above conversion is called autoboxing
      * conversely, when we do int x = List.get(i) , it translate to list.get(i).getValue()
      * it is called unboxing
      * Integer x = 3, x++, compiler do the unboxing and autoboxing transparently
      * the wrapper objects should be compared with equals since they are objects
      * if arithmetic involves, Integer and Dobule, Integer will be unboxed, promoted to double, boxed to Double
      * boxing and unboxing is done by compliler not by JVM
      * Integer.parseInt(s) is a staic method to convert a String into integer
      * wrapper classes are immutable
### 5.5 Varying number of parameters
      * printf takes variable number of parameters
      * ellipsis ... means a method can take variable number of parameters
      * the printf takes two parameters, format string and object[]
      * object ... is same as object[]
      * in case of printf, compiler bundles each parameters into an array and do autoboxing whenever needed
      * printf definition: public PrintStream printf(String fmt, Object... args) { return format(fmt, args);
      * printf call: System.out.printf("%d %s", new Object[] { new Integer(1), "widgets" } );
      * it is legal to pass an array as last parameter of a method with variable parameters
### 5.6 Enumerations
      * public enum Size(SMALL, MEDIUM,LARGE, EXTRA_LARGE)
      * the enum is actually a class with four instances
      * it is not possible to create any more instances
      * you can have constructors, fields, method with enum type
      * the constructor of enum type is always private, it is error to declare it public or protected
      * enum methos are toString, valueOf,ordinal

### revision
      * Reflection


### Exercises:
      * Enumeration,reflection
