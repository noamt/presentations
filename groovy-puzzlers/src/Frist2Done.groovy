/**
 * https://github.com/jlstrater
 */


def l1 = [1,2,3]
def l2 = []
def l3 = null

println "${l1?.first()}; ${l2?.getAt(0)}; ${l3?.first()}"

//This will output:
//
//A.) 1
//null
//null
//B.) 1
//[]
//null
//C.) No Such Element Exception
//D.) Null Pointer Exception
//
//
//Answer: C.  Null safe on a list checks for a null but not the empty list.
//
//Instead, use:
//
//println l2?.getAt(0)