# What is a framework in Java
- It provides readymade architecture.
- It represents a set of classes and interfaces.
- It is optional.
## What is Collection framework
The Collection framework represents a unified architecture for storing and manipulating a group of objects. It has:

Interfaces and its implementations, i.e., classes
<br>Algorithm
![alt text](https://static.javatpoint.com/images/java-collection-hierarchy.png)

# Methods of Collection interface
| Method  | Description |
| ------------- | ------------- |
| public boolean add(E e)  | It is used to insert an element in this collection.  |
| public boolean addAll(Collection<? extends E> c)  | It is used to insert the specified collection elements in the invoking collection.  |
|public boolean remove(Object element)  | It is used to delete an element from the collection.  |
| public boolean removeAll(Collection<?> c)  | It is used to delete all the elements of the specified collection from the invoking collection.  |
| default boolean removeIf(Predicate<? super E> filter)  | It is used to delete all the elements of the collection that satisfy the specified predicate.  |
| public int size() | It returns the total number of elements in the collection. |
public void clear()	It removes the total number of elements from the collection.
9	public boolean contains(Object element)	| It is used to search an element.
|	public boolean containsAll(Collection<?> c)	| It is used to search the specified collection in the collection. |
|	public Iterator iterator()	| It returns an iterator. |
|	public Object[] toArray()	| It converts collection into array. |
|	public <T> T[] toArray(T[] a)	| It converts collection into array. Here, the runtime type of the returned array is that of the specified array. |
|	public boolean isEmpty()	| It checks if collection is empty. |
|	default Stream<E> parallelStream()	| It returns a possibly parallel Stream with the collection as its source. |
|	default Stream<E> stream()	| It returns a sequential Stream with the collection as its source. |
|	default Spliterator<E> spliterator()	| It generates a Spliterator over the specified elements in the collection. |
|	public boolean equals(Object element)	| It matches two collections. |
|	public int hashCode()	| It returns the hash code number of the collection. |

# Iterator interface
Iterator interface provides the facility of iterating the elements in a forward direction only.

There are only three methods in the Iterator interface. They are:

| No.	| Method	    | Description   |
|-------| ------------- | ------------- |
| 1	| public boolean hasNext()	| It returns true if the iterator has more elements otherwise it returns false. |
|2	| public Object next()	| It returns the element and moves the cursor pointer to the next element. |
| 3	| public void remove()	| It removes the last elements returned by the iterator. It is less used. |


# Iterable Interface
- The Iterable interface is the root interface for all the collection classes.
-  The Collection interface extends the Iterable interface and therefore all the subclasses of Collection interface also implement the Iterable interface.

It contains only one abstract method. i.e.,


# Collection Interface
The Collection interface is the interface which is implemented by all the classes in the collection framework. It declares the methods that every collection will have. In other words, we can say that the Collection interface builds the foundation on which the collection framework depends.

Some of the methods of Collection interface are Boolean add ( Object obj), Boolean addAll ( Collection c), void clear(), etc. which are implemented by all the subclasses of Collection interface.