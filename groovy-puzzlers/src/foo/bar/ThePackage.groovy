/**
 * https://github.com/bsideup
 */

package foo.bar

class Something {
    static String prop = 321
}

def foo = [ bar: [Something: [ prop: 123 ] ] ]

println foo.bar.Something.prop
