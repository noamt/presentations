>>> 1*2
2
>>> _*3
6
>>> print(_*4)
24
>>> print(_*5)

# 

# Explanation:
#
# _ is how we access the cached previous output in the python interpreter. print statement sends output to stdout of system.
# It does not return the printed stuff back like a function call return. (It probably returns None).
# Hence, the _ cache is not updated during a print call. It tries to be clever to preserve the old value in cache.
# When we execute _*5, it is actually doing 6*5, not 24*5.