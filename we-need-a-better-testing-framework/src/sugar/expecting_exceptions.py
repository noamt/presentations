from nimoy.specification import Specification

class MySpec(Specification):

    def my_feature_method(self):
        with given:
            # Setup
        with when:
            raise Exception('Whaaaaat')
        with then:
            err = thrown(Exception)
            str(err[1]) == 'Whaaaaat'