/**
 * @davidnortonjr
 */
//TODO: WHY???
String method(Map args, int arg, String... varargs) {
    "${args}|${arg}|${varargs}"
}

println method(3, 'hello', prop: 42, 'world', '!!!')