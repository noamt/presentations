/**
 * https://twitter.com/youriackx/status/826429896029327361
 *
 * /Users/noam/.ideaLibSources/groovy-2.4.9-sources.jar!/org/codehaus/groovy/runtime/DefaultGroovyMethods.java:14299
 * /Users/noam/.ideaLibSources/groovy-2.4.9-sources.jar!/org/codehaus/groovy/runtime/typehandling/NumberMath.java:92
 *
 */

def thing1 = 0 % 20
def thing2 = 0 % (20 / 1)
println thing1 == thing2