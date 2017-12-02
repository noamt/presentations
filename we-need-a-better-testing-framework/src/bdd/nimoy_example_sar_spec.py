from nimoy.specification import Specification

class Example(Specification):

    def example_feature(self):
        with setup:
            a = 5
        with when:
            a = a + 1
        with then:
            a == 6
