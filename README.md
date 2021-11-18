### Q1. Describe hashmap internal working in detail. explain worst case scenario in case of collisions.
https://www.baeldung.com/java-hashmap-advanced
https://www.javatpoint.com/working-of-hashmap-in-java
https://www.geeksforgeeks.org/internal-working-of-hashmap-java/

### Q2. In the last class we discussed a situation of deleting an element from the arraylist via DELETE api we created. It led us to discuss various strategies related to removal of an element from an array. Based on that discussion, read about fail safe and fail fast iterators and differentiate between them.
Link: https://www.javatpoint.com/fail-fast-and-fail-safe-iterator-in-java

### Q3. What are dependency injections in spring? What is the role of Autowired?
It is a fundamental aspect of the Spring framework, through which the Spring container “injects” objects into other objects or “dependencies”. It allows for loose coupling of components and moves the responsibility of managing components onto the container.
@Autowired allows Spring to resolve and inject collaborating beans into our bean.
https://www.baeldung.com/spring-dependency-injection
https://www.baeldung.com/spring-autowire

### Q4. What is the difference between a singleton class created by Java vs Spring ?
Java considers something a singleton if it cannot create more than one instance of that class within a given class loader, whereas Spring would consider something a singleton if it cannot create more than one instance of a class within a given container/context.
https://stackoverflow.com/questions/15252284/what-is-the-difference-between-a-spring-singleton-and-a-java-singeletondesign-p

### Q5. What are reflections in java? is it compile time or runtime?
Reflection is an API which is used to examine or modify the behavior of methods, classes, interfaces at runtime.
* The required classes for reflection are provided under java.lang.reflect package.
* Reflection gives us information about the class to which an object belongs and also the methods of that class which can be executed by using the object.
* Through reflection we can invoke methods at runtime irrespective of the access specifier used with them.
<br>https://www.geeksforgeeks.org/reflection-in-java/

### Q6. Implement a thread safe Singleton class. Add comments wherever possible.
```java
/*
https://sourcemaking.com/design_patterns/singleton/java/2
*/
public final class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance(String value) {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

### Q7. What is a garbage collector and why is it used, write a program to invoke it.
Java applications obtain objects in memory as needed. It is the task of garbage collector (GC) in the Java virtual machine (JVM) to automatically determine what memory is no longer being used by a Java application and to recycle this memory for other uses. Because memory is automatically reclaimed in the JVM, Java application developers are not burdened with having to explicitly free memory objects that are not being used. The GC operation is based on the premise that most objects used in the Java code are short-lived and can be reclaimed shortly after their creation.
```java
// Java program to demonstrate requesting
// JVM to run Garbage Collector
public class Test
{
    public static void main(String[] args) throws InterruptedException
    {
        Test t1 = new Test();
        Test t2 = new Test();
        
        // Nullifying the reference variable
        t1 = null;
        
        // requesting JVM for running Garbage Collector
        System.gc();
        
        // Nullifying the reference variable
        t2 = null;
        
        // requesting JVM for running Garbage Collector
        Runtime.getRuntime().gc();
    
    }
    
    @Override
    // finalize method is called on object once
    // before garbage collecting it
    protected void finalize() throws Throwable
    {
        System.out.println("Garbage collector called");
        System.out.println("Object garbage collected : " + this);
    }
}
```
https://www.geeksforgeeks.org/garbage-collection-java/
https://www.javatpoint.com/Garbage-Collection
https://www.eginnovations.com/blog/what-is-garbage-collection-java/

### Q8. What is the use of @SpringBootApplication annotation.
It is used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning. It's same as declaring a class with @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.

### Q9. What is @Bean annotation and what annotation we need to give at class level if we use it for any method.
@Bean is a method level annotation. Name of the method serves as the bean name. It tells Spring about the bean that has to be managed by the Spring container. It is used to explicitly declare a single bean, rather than letting Spring do it automatically. It decouples the declaration of the bean from the class definition, and lets you create and configure beans exactly how you choose.
@Component is a class level annotation. @Component (and @Service and @Repository) are used to auto-detect and auto-configure beans using classpath scanning. There's an implicit one-to-one mapping between the annotated class and the bean (i.e. one bean per class).

### Q10. What DBs have you used. Explain the challenges faced with those DBs.
* `Oracle SQL` started with this, initial learning curve was high as it was first DB.
* `Azure SQL` similar to Oracle SQL. Getting User ID and Password in PROD was pain. Also, authentication mechanism and JDBC driver of STAGE and PROD were different.
* `MongoDB` found difficult initially as it is different from other relational DBs.

### Q11. Difference between row level database and columnar database. Explain with examples.
`Row oriented databases` organize data by record, keeping all of the data associated with a record next to each other in memory. Row oriented databases are the traditional way of organizing data and still provide some key benefits for storing data quickly. They are optimized for reading and writing rows efficiently. eg - Postgres, MySQL.
<br>`Column oriented databases` organize data by field, keeping all of the data associated with a field next to each other in memory. Columnar databases have grown in popularity and provide performance advantages to querying data. They are optimized for reading and computing on columns efficiently. eg - Redshift, BigQuery, Snowflake.

### Q12. Create a spring boot project to modify an in-memory Binary Search Tree(BST). Expose APIs to add, delete and read the values of BST.
* GET http://127.0.0.1:8080/read
* POST http://127.0.0.1:8080/add/20
* DELETE http://127.0.0.1:8080/delete/20
