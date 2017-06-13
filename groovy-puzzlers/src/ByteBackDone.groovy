/**
 * https://issues.apache.org/jira/browse/GROOVY-5652
 */

String burger = 'burgers'
Long bites = 1

def m = [(burger): [bites]]
println m