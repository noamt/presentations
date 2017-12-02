from nimoy.specification import Specification

class Example(Specification):
    def example_feature(self):
        with given:
            a = value_of_a
            b = value_of_b
        with expect:
            (a * b % 2) == 0
        with where:
            value_of_a = [2, 2]
            value_of_b = [5, 21]
