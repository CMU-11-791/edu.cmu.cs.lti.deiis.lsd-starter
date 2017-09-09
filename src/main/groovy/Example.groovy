/*
 * Copyright (c) 2017. Carnegie Mellon University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

import org.lappsgrid.api.*
import org.lappsgrid.core.*
import org.lappsgrid.client.*
import org.lappsgrid.serialization.*
import org.lappsgrid.serialization.lif.*
import org.lappsgrid.serialization.datasource.*
import org.lappsgrid.metadata.*

import static org.lappsgrid.discriminator.Discriminators.*

class Example {

    // Put your LSD script here.  When your script is running copy
    // it into an .lsd script and run it with the LSD interpreter.
    //
    // If needed an LSD script can contain methods and define new classes.
    static void main(String[] args) {
        def tokenizer = new ServiceClient("http://vassar.lappsgrid.org/invoker/anc:stanford.tokenizer_2.1.0-SNAPSHOT", "tester", "tester")
        def tagger = new ServiceClient("http://vassar.lappsgrid.org/invoker/anc:stanford.tagger_2.1.0-SNAPSHOT", "tester", "tester")

        Container container = new Container()
        container.text = "Karen flew to New York."
        container.language = "en"
        Data data = new Data(Uri.LIF, container)

        println "Running the tokenizer"
        String json = tokenizer.execute(data.asJson())
        println "Running the tagger"
        json = tagger.execute(json)

        // One way to pretty pring JSON
        println groovy.json.JsonOutput.prettyPrint(json)

        // Another way to pretty print JSON
        data = Serializer.parse(json)
        println data.asPrettyJson()

        // Iterate over all annotations in the last view and print some features.
        container = new Container(data.payload)
        container.views[-1].annotations.each { Annotation a ->
            println "${a.id} ${a.features.pos} ${a.features.word}"
        }
    }
}
