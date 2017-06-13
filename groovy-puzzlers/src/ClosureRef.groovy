//https://github.com/jespersm

// Some variables
String hello = "hello"
String nothing = null
// You all know these, right?
println "Length of hello: ${hello.length()}"
println "Safe length of nothing: ${nothing?.length()}"

// You probably know the method closure, too, yes?
def lengthClosure = hello.&length
println "Length of hello: ${lengthClosure()}"

// How about this - what happens next?
def safeLengthClosure = nothing.&length //TODO: turn to nothing?.&length
println "Safe length of nothing: ${safeLengthClosure()}"

// A. Prints "Safe length of nothing: null"
// B. Prints "Safe length of nothing: 0"
// C. Compilation failure?
// D. java.lang.NullPointerException: Cannot invoke method call() on null object

//TODO ASK andres