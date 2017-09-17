Agenda
======
* Lambda expression in JAVA 8
* Method reference
* Functional interfaces

Example 1
---------

Show first example 

Example 2
---------

Show second example

What was shown on the examples ?
--------------------------------
* We wrote some code in an anonymous class
* And we passed it to another piece of code
* That executed it “later”
* And in another context (thread)
* We passed code as a parameter
* And we used anonymous class, because it is the only way to do it in Java

Example 1 rewritten with lambda
-------------------------------

Example 2 rewritten with lambda
-------------------------------

Remarks
-------
* One can put modifiers on the parameters of a lambda expression
&nbsp;&nbsp; - The final keyword
&nbsp;&nbsp; - Annotations
* It is not possible to specify the returned type of a lambda expression
* We can also omit the types of the parameters

Method references
=================
* Example with static methods
* Example with instance methods


Functional interfaces
=====================
* A lambda expression is an instance of a functional interface
* A functional interface is an interface with only one method

How does it work
----------------
* The interface is functional, so there is only one method to implement
* The type of the variable gives the type of the lambda expression
* The parameters & return types must be compatible
* The same for the exceptions, if any

Call a lambda expression
------------------------

Definition
----------
* A functional interface is an interface:
    * With only one abstract method
    * Default methods do not count
    * Static methods do not count
    * Methods from the Object class do not count

* A functional interface may be annotated with @FunctionalInterface. It is not mandatory, for legacy reasons
* The compiler will tell us if an annotated interface is functional or not



The java.util.function Package
------------------------------
A new package from Java 8
Four categories:
    1. The Consumers
    2. The Suppliers
    3. The Functions
    4. The Predicates
    
The consumer
------------
* A consumer consumes an object, and does not return anything

The Supplier
------------
* A supplier providesan object, takes no parameter

The functions
-------------
* A function takes an object an returns another object

The Predicates
--------------
* A predicate takes an object an return a boolean 