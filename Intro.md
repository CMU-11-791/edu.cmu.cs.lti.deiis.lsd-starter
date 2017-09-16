# The Lappsgrid Services DSL

The Lappsgrid Services DSL is a [Groovy](http://groovy-lang.org) based domain specific language that can be used to quickly prototype, develop, and test LAPPS Grid SOAP web services.  Since Groovy is a JVM language all Java libraries and modules can be used in Groovy, and in turn in LSD scripts.

Groovy is typically easy for Java programmers to pick up as the Groovy compiler also accepts (most) Java syntax, so if you don't know Groovy syntax just use Java syntax. 

## Groovy for Java programmers

- [Syntax](#syntax)
- [Public and Private](#public_and_private)
- [Getters and Setters]()
- [Collections]()
- [Groovy Strings]()
- [File I/O](#file_io)
- [Closures](#further_reading)
- [Further Reading](#further_reading)
 
### Syntax

Many commonly used packages (java.util, java.io, etc) are implicitly imported by default.

Parenthesis are not required around a method call's parameters.  However, they should often be used to improved readability and are required if the Groovy compiler can not fifigure out where they belong, eg nested function calls.

Write to Stdout with `println "hello"` rather than `System.out.println("hello");`

Semi-colons are not required to terminate a statement.  However, they can be used to include more than one statement on a single line.

The value of last statement in a method is used as a return value.

```groovy
void name() {
    "Bob"
}
println name()  // prints "Bob" 
```

### Public and Private

Typically the  `public` and `private` keywords are not required unless you want to override the default behavior of the Groovy compiler.

1. Fields are `private` by default. Getter and setter methods are automatically defined by the compiler.
1. Methods are `public` by default.
1. The class with the same name as the .java file is `public` by default.

This makes defined Java Beans very succinct:

```groovy
// In Person.groovy
class Person {
    String firstName
    String lastName
    Date dateOfBirth    
}
```

### Getters and Setters

As mentioned above, the Groovy compiler will generate `get` and `set` methods for fields.  Fields can also be access directly as if they are `public` and the Groovy compiler will generate calls to the appropriate `get/set` methods.  This works for Java classes as well as Groovy classes.

```groovy
File file = new File("/path/to/my/file.txt")
println file.name  // calls file.getName()
println file.path  // calls file.getPath() 

// Using the Person class from above.
Person person = new Person()
person.firstName = "Bob"  // calls person.setFirstName("Bob")
``` 

### Collections

Groovy provides a short method for declaring ArrayList and HashMap instances:

```groovy
// In Groovy
def list = []
def map = [:]

// In Java
List list = new ArrayList();
HashMap map = new HashMap();
```

It is also possible to initialize a list or hash map when it is declared:
```groovy
def list = ['one', 'two', 'three']
def map = [key1:'value1', key2:'value2']
```

If the keys for a Map are String objects then the key can be used as if it was a property of the Map class.  Array style syntax can also be used to set/get values from the Map.
```groovy
def map = [:]
map.key = 'value1'

// Is the same as
map['key'] = 'value1'

// Is the same as
map.put('key', 'value1')
```

### Groovy Strings

In Groovy single and double quotes are used to declare String objects.

```groovy
String hello = 'Hello world'
String goodbye = "Goodbye cruel world"
```

A String object declared with double quotes is called a *Groovy String* and can perform variable ininterpolation to inject variable values into the String.

```groovy
String name = "Bob"
println "Hello $name"
```

The `$` can be followed by arbitrarily complex Groovy code by including the statement in curly braces:

```groovy
def array = ['Alice', 'Bob', 'Carol']
int i = 0
println "Hello ${array[i+1].toUpperCase()}"
```

### File I/O

The `java.io.File`, `java.io.InputStream`, `java.io.Reader` and a few other classes have a psuedo `text` property that allows the entire byte/character sequence to be read as a single String.

```groovy
new File('/tmp/greet.txt').text = "Hello world"
File f = new File('/tmp/greet.txt')
println "${f.text}"

InputStream stream = this.class.getResourceAsStream("/resources/file.txt")
String text = stream.getText("UTF-8")
```

### Closures

A `Closure` in Groovy is similiar (in syntax at least) to Java's lambdas.  Closures are:

1. are enclosed in curly braces.
1. can be passed parameters.
1. single parameters to closures are named `it` by default.
1. can be assigned to variables or passed as parameters to other functions or closures.

```groovy
def greet = { println "Hello $it" }
greet "Bob"  // Prints "Hello Bob"
```

```groovy
void message(Closure cl) {
    cl("Bob")
}
def greet = { name -> println "Hello $name" }
message(greet)
```

```groovy
message {
    println "Goodbye $it"
}
```

**Note** In the second call to the `message` function above we simply omit the optional parenthesis around the closure that we have defined anonymously.  You will encounter this syntax a lot in Groovy and LSD scripts.

### Further Reader

1. [Groovy home page](http://groovy-lang.org)
1. [Wikipedia page](https://en.wikipedia.org/wiki/Groovy_(programming_language)#History)

