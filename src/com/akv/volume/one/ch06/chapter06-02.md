# 6.2 Lambda functions
* if we need a pass a piece of code that can be called at some later point of time we can use lambda function
* examples are actionPerformed in ActionListener or compare in Comparator
```
ActionListener
--------------
    public void actionPerformed(ActionEvent e) {

        System.out.println("Current time is" + Instant.ofEpochMilli(e.getWhen()));
        Toolkit.getDefaultToolkit().beep();

    }

Comparator<T>
--------------
    public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
```
* there piece will be executed by Timer or Array sort method.
* Syntax of Lambdas:
```
(String a, String b) -> a.length() - b.length()
```
* if there is no parameter, it can be defined as
```$xslt
() -> {...}
```
* if a type can be inferred, type in a parameter is not required
```$xslt
Comparator<String> comp = (a,b) -> a.length() - b.length()
```
* in case of single parameter, paranthesis is not needed
```$xslt
ActionListener listener = event ->{...}
```
* the return type is not needed for Lambda, it inferred from context
* the lambda function will throw error, if one branch return a value and other doesn't
### 6.2.3 Functional Interface
* an interface with just one abstract method(Functional Interface) can be defined as lambda expression
* Examples are a functional Interface:
```
    comparator<T> -> compare
    ActionListener -> actionPerformed
    Runnable -> run
```
* java.util.function defines all functional interface
* Predicate<T> has a method test(T) -> boolean
* ArrayList has removeIf method which expect Predicate as parameter
* Supplier<T> interface has get method with no parameter
* Suppliers are used for lazy evaluation
### 6.2.4 Method reference
* if a Lambda expression requires just one method call we can use method reference
```$xslt
Timer timer = new Timer(1000, system.out.println(2))
```
can be wtitten as
```$xslt
Timer timer = new Timer(1000, system.out::println)
```
similarly
```$xslt
Arrays.sort(array,String::compareToIgnoreCase
```
* The method expression is of form:
```$xslt
object::instance method   System.out::println           x-> System.out.println(x))
class::instance method    String::CompareToIgnoreCase)  x.CompareToIgoneCase(y)
class::static Method      Math::pow                     (x,y)-> Math.pow(x,y)
```
* a lambda expression can be written as method reference if it invokes just a method call and nothing else
```$xslt
s -> s.length() ==0
```
* the above can not be used as method reference since it invoke a method and also do a comparision
### 6.2.5 Constructor reference
* we can have constructor reference just like method reference
* Person::new is a constructor reference
* if Person is having multiple construct, the correct constructor will depend on context
### 6.2.6 Variable Scope
* The lambda function has code block, parameters and free variables
* a function with free variables are called closure
* Lambda expression can refer variables defined in enclosing scope
* the variables can not be mutated inside lambda expression
* the variables should also not be mutated in enclosing scope
### 6.2.7 Processing Lambda Expression






  
