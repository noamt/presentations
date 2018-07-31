from nimoy.specification import Specification

class Example(Specification):
    def example_feature(self, value_a, value_b):
        with given:
            a = value_a
            b = value_b
        with expect:
            (a * b % 2) == 0
        with where:
            value_a | value_b
            2       | 5
            2       | 21



