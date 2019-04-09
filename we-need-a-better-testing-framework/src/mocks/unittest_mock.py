from unittest import mock
from mock import Mock

def test_mocks():
    teh_mock = Mock()

    teh_mock.do_it()
    assert teh_mock.do_it.call_count == 1

    teh_mock.do_another.return_value = 5
    assert teh_mock.do_another() == 5