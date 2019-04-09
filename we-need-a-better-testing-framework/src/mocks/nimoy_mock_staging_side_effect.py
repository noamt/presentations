from nimoy.specification import Specification
from unittest.mock import Mock

class Example(Specification):
    def example_feature(self):
        with given:
            a = Mock()
        with when:
            a.method_call << [5, 6, 7]
        with then:
            a.method_call() == 5
            a.method_call() == 6
            a.method_call() == 7