//using stream-groovy

def fridge = Stream.from(["coke", "coke", "coke", "coke"])

def open = { drink ->
  "Open ${drink}"
}
fridge.take(2).collect(open)