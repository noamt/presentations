import groovyx.net.http.FromServer
import groovyx.net.http.HttpBuilder

import java.time.ZonedDateTime

class HeaderParse {

    public static void main(String[] args) {
        ZonedDateTime date = HttpBuilder.configure {
            request.uri = 'http://localhost:5050'
        }.head(ZonedDateTime) {
            response.success { FromServer resp ->
                resp.headers.find({ h -> h.key == 'Date' }).parse()
            }
        }
        println "Class: ${date.class}, date: ${date}"
    }
}
