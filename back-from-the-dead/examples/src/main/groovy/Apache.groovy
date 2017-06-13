import groovyx.net.http.ApacheHttpBuilder
import groovyx.net.http.HttpBuilder

class Apache {
    private HttpBuilder httpBuilder

    void init() {
        httpBuilder = HttpBuilder.configure({ c ->
            new ApacheHttpBuilder(c)
        })
    }
}