# 6 interfaces
### interfaces
* it defines what, but not how
* A class can implement multiple interfaces
* Arrays.sort will sort an array of object if object has implemented comparable method
* a comparable interface has a compareTo method
* All method of an interface are public
* interface will not have instance fields, but can have constant(public static final)
* before java 8, it was not allowed to have method implementation, but now we can have method implemented.
* interface methods will not refer to instance fields
* methods implemented in an interface should have access modifier
* this is in contrast to non-implemneted method which are always public
* while comparing float value, use double.compare(x,y) which will return 1,0 or -1
* x.compareTo(y) == -(y.compareTo(x))
* a interface will not take a new operator to create a instance, but it can be used to create a variable
* we can use instanceOf to check whether a class has implemented an interface
* an interface can inherit from another interface using extends
* before java 8, we can have concrete methods in interface, the approach was to create companion class. such as collection/collections, path/paths
* Now we can have concrete methods in interface
* with Java 9, we can have private helper methods in interface
* we can have default methods in interface such as public int compareTo<T>(T other) { return 0}
* it allows a programmer implementing interface not to worry about implementing trivial methods
### 6.1.6 Resolving conflict
* if the same method is defined in interface, superclass and another interface the rules are:
  1. the superclass method will win if same method in defined in superclass
  2. if multiple interface provide the same method ( unimplemented or default), then we have to override
    public String getName() { return Person.super.getName(); }
  3. if neither interface provide a default implemnetation, the implementing class has to provide one otherwise remain abstract
### 6.1.7 Callback
* callback pattern: perform some action on some event
* programming languages like node uses functions to pass as callback
* java uses object to be passed as callback, the benefit is object is having state also
* refer TimerTest.java class
### 6.1.8 Comparator
* comparator interface has compare method
* it is similar to comparable interface with compareTo method
* compareTo method works on object such as x.compareTo(y)
* compare takes both object in parameters, we have to create an instance to Comparator Class
* Comparator c = new Comparator();
* c.compare(x,y)
* comparator can be used to provide an alternate to string comparision, the default implementation of comparaTo method works on dictionary order
* we can use Comparator to compare based on string length
* refer StringLengthSorting.java
### 6.1.9 Cloneable
* Object copy makes both object referring to same object
* object clone creates a new objects having the same state as original object
* clone method of Object copied field-by-field basic
* this is fine for primitive type, but create problem if object being cloned have some sub object
* if we just copy the reference, both original and clone will have some shared data
* if the sub object is immutable, it is not an issue but mutable sub object is not safe
* in that case, do a deep copy
* to allow cloning, the class must implement a cloneable interface and redefine clone method
* the cloneable interface doesn't define any method -- called tagging interface/marker interface
* the sole purpose of cloneable interface to affirm that developer has understood the cloning process and to use instanceOf
* even if the default clone method is adequate, we still need to implement cloneable interface and override clone method
* the overridden method will be public, throw CloneNotSupportedException and invoke super.clone() method
```$xslt
        public Employee clone() throws CloneNotSupportedException
           {
              return (Employee) super.clone();
           }
```
* use clone method for sub object for deep cloning

 

  

 

