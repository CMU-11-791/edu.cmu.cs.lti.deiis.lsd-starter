# Lappsgrid Services DSL Start

The Lappsgrid Services DSL is a Groovy based domain specific language that can be used to quickly prototype, develop, and test LAPPS Grid SOAP web services.  Since Groovy is a JVM language all Java libraries and modules can be used in Groovy, and in turn in LSD scripts.

Groovy is typically easy for Java programmers to pick up as the Groovy compiler also accepts (most) Java syntax, so if you don't know Groovy syntax just use Java syntax. 

More information on Groovy can be found [here](http://groovy-lang.org).

## Groovy for Java programmers

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
Note that Groovy does not require that lines be terminated with a semi-colon.

It is also possible to initialize a list or hash map when it is declared:
```groovy
def list = ['one', 'two', 'three']
def map = [key1:'value1', key2:'value2']
```

The the keys for a Map are String objects then the key can be used as if it was a property of the Map class.  Array style syntax can also be used to set/get values from the Map.
```groovy
def map = [:]
map.key = 'value1'

// Is the same as
map['key'] = 'value1'

// Is the same as
map.put('key', 'value1')
```

### Groovy String

In Groovy single quotes can be used to declare String objects.

```groovy
String hello = 'Hello world'
String goodbye = "Goodbye cruel world"
```



