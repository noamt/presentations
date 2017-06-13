/**
 * Joe Wolf <joewolf@gmail.com
 */

int burger = 0
int fries = ++burger++
println "Burger: $burger; Fries:$fries"

/**
 A.  "1 2"
 B.  "2 2"
 C.  "1 1"
 D. Won't run

 * * *

 The answer (at least for me using Groovy 2.4.7 on Java 1.8.0_111) is C.

 A couple interesting things are going on here: a) Groovy allows you to put ++ on both sides of the variable at the same time (?!), and b) when you do that, the increment occurs twice on the original value before the value is reassigned. Perhaps better explained by this:

 class Foo {
 def id = 'x'
 int value
 def next() {
 println "$id : next() called with value $value"
 new Foo(id: 'y', value: value + 1)
 }
 String toString() { "$id : $value" }
 }

 def f = new Foo(value: 1)
 ++f++
 println f

 This prints out
 x : next() called with value 1
 x : next() called with value 1
 y : 2
 */