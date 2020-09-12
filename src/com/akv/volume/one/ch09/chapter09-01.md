# 9. Collections
* Collection separate interface with implementation
* A queue interface can have methods like pop,push and size
* there can be several implementations of queue interface such as circular queue or linked list queue
* it is customary to use implementation class while creating the collection and interface as a variable to hold the collection
* the benefit of this approach is we can easily change the implementation with less effort
```$xslt
Queue<Customer> expressLane = new CircularArrayQueue<>(100);
expressLane.add(new Customer("Amit"));
```
* Most of the interface in collection class have corresponding Abstract class which defines default methods so the collection implementor has to define any required method not all interface methods
* now the same can be achieved using default interface method also
### 9.1.2 Collection interface
* Collection interface has two primary method add, iterator
* there are lot of other methods in collection interfaces
* add methods return true if value is add to collection else returns false
* interface methods returns an object which implement Iterator interface
### 9.1.3 Iterator interface
* has 4 method -> hasNext(), Next(), remove() and forEachRemaining()
* at the end of iterator it will raise NoSuchElementException
* so we need to call hasNext() before next()
* Iterating through a collection
    1. get a collection
    2. create an iterator
    3. loop through iterator while hasNext() is true
    4. process each element
* another and more elegant approach is use foreach
```$xslt
for (x: coll){...}
```
* the for each works with any object which implements Iterable interface
* Iterable interface has just one method iterator which return an Iterator
* Collection interface extends iterable interface
* forEachRemaining can be used as Lambda expresssion
```$xslt
iterator.forEachRemaining(element -> do something with element);
```
* we can think of java iterator as being between elements.
* next call, jumps over the next element and return a reference of element just passed.
* iterator.next === inputStream.read
* remove method removes the element returned in last next call
* so iter.next(); iter.remove() is fine but iter.remove(); iter.remove will throw error
### 9.1.4 Generic Utility method
* collection and Iterator are generic
* Collection interface defines a quite useful methods that each implementing class should define
* few collection interface methods are:
  size(), contains(),containsAll(),isEmpty(),add(),AddAll(),remove(),removeAll(),clear(), retainAll(), toArray()
* defining all method in implementing class would be a pain so Java has defined as AbstractCollection class which implement most of the methods except:
* size() and iterator() -> there tow method will be defined by implementing class
* but defined all other method in terms of these 2 abstract methods  
* A concrete collection has to only define iterator and size method, but they can reuse others
* if concrete collection has more specific implementation of any method, they can override
### 9.2 Interfaces in Collection framework
* iterable -> collection -> list, set-> sortedSet -> navigableSet, queue-> deque
* map-> sortedMap-> navigableMap
* iterator -> ListIterator
* RandomAccess
* Map hold key/value pair, put() and get() to add and remove elements
* List is orderedCollection, we can access elements of list in two ways
* used integer Index or through Iterator
* accessing Integer index is random access whereas accessing through iterator is sequential access
* List interface has methods such as -> add(), remove(), get(), set(
* add element will add element before iterator position
* there are two list implementations: backed by array and linked list
* Array backed are good for random access but not efficient for adding, removing element at middle
* Linked list is good for inserting element at middle, but poor for random access, search is always sequential
* RandomAccess interface has no method(also a tagging/marker interface like cloneable), it is used to test whether a collection supports random access
* Set doesn't allow duplicate( add will return false for duplicates)
* equals method should be defined such that two sets should be equal is having same element irrespective of order
* similarly, hasCode should be defined to have same hashCode for sets having same element
* SortedSet and sortedMap defines a comparator for sorting sets and map
* NavigableSet and NavigableMap defines methods for searching and traversing sets and maps
* TreeSet and TreeMap implement NavigableSet and NavigableMap

### 9.3 Concrete Collections
#### LinkedList
* removing element from middle of array and ArrayList are expensive
* in java linked list are doubly link list
* adding and removing elements from linked list are inexpensive
* LinkedList.add() method add element to the end of list
* in order to add elements at the middle, it has to be position dependent
* position dependent add method is a property of Iterator.
* Collection library supplies a ListIterator which has position dependent add method
```$xslt
interface ListIterator<E> extends Iterator<E>
{
   void add(E element);
   . . .
}
```
* ListIterator add method returns void NOT true/false
* it has previous and hasPrevious() method in addition to next() and hasNext() method
* linked list class has a listIterator method which return an object implementing listIterator
* Add method will add an element before the iterator method
* we can issue multiple add element, and they will be added in same order
* if linked list is just initialized, the add method will add element at the beginning of list
* if the iterator has passed last element, the new item will be added to tail of list
* a list of n will have N+1 iterator position -> |ABC, A|BC, AB|C, ABC
* remove() will remove last fetched element from left or right depending on call of next() or Previous() call
* successive call of remove throw exception
* set method will replace an existing element
* concurrent modification on List will throw ConcurrentModificationException 
* we can have multiple read iterators, but only one write/update iterator
* concurrent modification is detected by a simple way:
* each collection and iterators keep track of mutating operations. if both are different they will raise ConcurrentModificationException
* The detection is only structural and detect only add and remove, it ignore set operation
* Linkedlist are not efficient for random access, the get(n) will traverse the list till n-1 position
* the get method has a slight optimization, if n > size()/2, it will traverse from last
#### ArrayList
* ArrayList is backed by an array which size is dynamically allocated
* it is very efficient for random access
* it is similar to legacy Vector Class,the difference is all methods in vector class is synchronized
* if the collection is being used by a single thread it is better to use ArrayList
#### HashSet
* hashset doesn't have duplicates, we don't have control over the order
* Hash table is an important data structure where element are stores based on their hash value
* hash tables are implemented as array of linked list,each element of array is called a bucket
* bucket of an element =  has code % bucket size( ie, 76268 % 128 =108)
* if the bucket is empty, the simply insert element in bucket
* if bucket is not empty, it is has collision, then he have to look into all element in list in order to insert element
* with Java 8, hash table changed from linked list to balanced tree
* bucket count is power of 2, any value for hash table is rounded to power of 2
* if the bucket is filled, it will be rehashed. 
* in this process, a new table will be created with double of size, element will be inserted and old hash table will be discarded.
* has tabled will have a load factor (.75), it hash table is 75% filled, it will be rehashed
* Set implements hash table, it redefines contains method for fast performance
* modifying the element value will change the hash code and hence the element will not longer be found in old position
#### TreeSet
* element in treeSet is sorted. TreeSet is implemented as red-black tree.
* each time an element is added to treeSet, it is stored in correct position
* adding element is TreeSet is a bit slow than hashSet, but still much faster than ArrayList and LinkedList
* it is log2N to find a place for new element, it means a new element in a Set of 1000 will need 10 comparision
* in order to use TreeSet, element of set must have implemented comparable interface
* Can we always use TreeSet over HashSet??
* if sorting is not a requirement, use hashSet
* sometimes it is difficult to implement compare method, it may be ambiguous so better to use hashSet in this case
* with Java6, treeSet also implement NavigableSet which provides many methods for locating elements and backward traversals
#### queues and deques
* a double-ended queue allows adding and removing items from head or tail
* adding/removing element in middle is not permitted
* java 6 provided deque interface, it is implemented by ArrayDeque and linkedList
* queue methods
    * add()/offer() -> add element at the end
    * remove()/poll() -> remove element from head
    * element()/peek() -> return elements without removal
* deque
    * addFirst/AddList/Offerfirst/OfferLast
    * removeFirst/removeLast/PollFirst/PollLast
    * getFirst/getLast/peekFirst/peekLast
#### Priority Queues
* A priority queue retrieve elements in sorted order
* remove method will get the smallest elements from the queue
* it is implemented as heap where the smallest element gravitate to the root of queue
* like TreeSet, elements of priority queue must implement comparable interface or a Comparator object

### Exercises
* Implement treeSet with a comparable interface and with comparator

