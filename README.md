# Lappsgrid Services DSL Starter Pack

Use this project to test your LSD installation and write [LSD scripts](Intro.md) in any IDE that supports Groovy and Maven projects.

## Test the project

Open the *Example* class in the `src/main/groovy` directory and run the `main` method.  The `main` method does the following:

1. Creates a LIF [Container](http://wiki.lappsgrid.org/org.lappsgrid.serialization/groovydoc/org/lappsgrid/serialization/lif/Container.html) object and sets the `text` and `language` properties
1. Creates a  [Data](http://wiki.lappsgrid.org/org.lappsgrid.serialization/groovydoc/org/lappsgrid/serialization/Data.html) object and adds the above container as the `payload`.
1. Creates two [service clients](http://wiki.lappsgrid.org/org.lappsgrid.client/apidocs/org/lappsgrid/client/ServiceClient.html); one that calls a Stanford tokenizer and another that calls a Stanford part of speech tagger.
1. Calls each of the above services in turn.  The output of the tokenizer is passed directly to the part of speech tagger.
1. Parses the JSON returned from the part of speech tagger back into a `Data` object.
1. Iterates over all of the [Annotation](http://wiki.lappsgrid.org/org.lappsgrid.serialization/groovydoc/org/lappsgrid/serialization/lif/Annotation.html) objects and prints out a few features of each.

# Create a new script

When you want to develop a new script:
 
1. create a new Groovy class in the `src/main/groovy` directory.
1. add a `static void main(String[] args)` method to the class created above.
1. copy/paste all the import statement from the top of the `Example` class.








