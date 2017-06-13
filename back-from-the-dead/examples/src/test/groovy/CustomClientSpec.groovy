import groovyx.net.http.HttpBuilder
import spock.lang.Specification

/**
 * Created by noam on 31/05/2017.
 */
class CustomClientSpec extends Specification {

    public 'Serenity, What\'s your status?'() {
        given:
        def requestLog = []
        def configuration = HttpBuilder.configure({ c -> new SerenityTestClient(c, requestLog) }) {
            request.uri = 'http://serenity.com'
        }

        when:
        def result = configuration.get(String) {
            request.uri.path = '/status'
        }

        then:
        result == 'Shiny!'
        requestLog.size() == 1
        requestLog.first() == '/status'
    }
}
