import groovyx.net.http.HttpBuilder
import groovyx.net.http.HttpVerb

import static groovyx.net.http.HttpVerb.*

class InterceptResponse {

    public static void main(String[] args) {
        def result = HttpBuilder.configure {
            request.uri = 'http://localhost:5050'
            HttpVerb[] verbs = [GET, POST, PUT, DELETE]
            execution.interceptor(verbs) { cfg, fx ->
                def result = fx.apply(cfg)
                println "Full body response: ${result}"
                "magic:marker:${result}"
            }
        }
        .get()
        println result
    }
}
