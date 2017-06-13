import groovyx.net.http.HttpBuilder
import groovyx.net.http.OkHttpBuilder

class Ok {
    private HttpBuilder httpBuilder

    void init() {
        httpBuilder = HttpBuilder.configure({ c ->
            new OkHttpBuilder(c)
        })
    }
}