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

// See src/test/lsd/AnotherExample.lsd to see what this looks like as a LSD script.
class AnotherExample {

    // Put your LSD script here.  Copy this as the main body of your script.
    void run() {
        def setup = new Helper(action:'setup')
        def magic = new Helper(action:'do some magic here')
        def cleanup = new Helper(action: 'cleanup')
        act(setup, magic, cleanup)
    }

    // Paste this and any other helpers to the bottom of the script.
    void act(Helper... actions) {
        actions.each { it.help() }
    }

    // Do not include this in your script.
    static void main(String[] args) {
        new AnotherExample().run()
    }
}

// Paste this (and any other helper classes) to the end of the script.
class Helper {
    String action

    void help() {
        println "Performing $action"
    }
}