/**
 * Yang Yang <reliveyy@gmail.com>
 * groovy.lang.GString#writeTo(java.io.Writer)
 * http://groovy-lang.org/syntax.html#_special_case_of_interpolating_closure_expressions
 */

doubleVision = { x ->
    println x
}

doubleVision("doubleVision${doubleVision.toString()}")