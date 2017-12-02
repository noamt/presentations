from nimoy.specification import Specification
from unittest.mock import Mock

class Example(Specification):
    def example_feature(self):
        with given:
            a = Mock()
        with when:
            a.method_call('argument')
        with then:
            1 * a.method_call('argument')
