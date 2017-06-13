import groovyx.net.http.HttpBuilder
import groovyx.net.http.JavaHttpBuilder
import groovyx.net.http.ToServer

class Core {
    private HttpBuilder httpBuilder

    void init() {
        httpBuilder = HttpBuilder.configure()
        httpBuilder = HttpBuilder.configure({ c -> new JavaHttpBuilder(c) })
    }

    public static void main(String[] args) {
        HttpBuilder.configure {
            request.uri = 'http://serenity.com/report'
            request.encoder('application/json') { config, ToServer req ->
                def wrapped = "{\"body\":${config.request.body},\"clientId\": \"bla\""
                req.toServer(new ByteArrayInputStream(wrapped.bytes))
            }
        }
    }
}
