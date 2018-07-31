from nimoy.specification import Specification

class MySpec(Specification):

    def regex_assertion(self):
        with given:
            exp = 'The quick brown fox'
        with expect:
            exp @ '.+brown.+'