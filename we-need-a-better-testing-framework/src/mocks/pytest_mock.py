from unittest import mock
from mock import Mock

def test_mocks():
    teh_mock = Mock()

    teh_mock.do_it(1)
    teh_mock.do_it(2)
    teh_mock.do_it(3)

    assert teh_mock.do_it.call_count == 3
