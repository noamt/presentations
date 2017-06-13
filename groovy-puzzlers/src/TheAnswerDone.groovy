/**
 *  Guillaume Laforge <glaforge@gmail.com>
 */

def static theAnswerToLifeTheUniverseAndEverything() {
//    { 42 }
}

println theAnswerToLifeTheUniverseAndEverything()

//1) assert m() == 42 ? // like a open block of code
//        2) assert m()() == 42 ? // returns a closure which when called returns 42
//        3) compilation error? // because open blocks are not supported
//
//        Currently, it's 3, because the parser doesn't really know what you're doing here, it could be an open block of code, or it could be a closure, it's ambiguous.
//
//But it'll work in the "parrot" grammar, and that'll return 42 just like in m() == 42 in 1).
