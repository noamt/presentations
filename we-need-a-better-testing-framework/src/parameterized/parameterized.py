import pytest

@pytest.mark.parametrize("script,result", [
    ("2 * 21", 42),
    ("int(0.1337 * 10000)", 1337),
])
def test_eval(script, result):
    assert eval(script) == result
