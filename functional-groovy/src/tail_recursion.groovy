@groovy.transform.TailRecursive
Integer sumCash(List<Integer> cashProvided, Integer totalCashGiven = 0) {
    if (!cashProvided) {
        return totalCashGiven
    } else {
        return sumCash(
            cashProvided.tail(),
            cashProvided.head() + totalCashGiven
        )
    }
}

sumCash([1, 5, 22, 3])