import groovyx.net.http.ChainedHttpConfig
import groovyx.net.http.FromServer
import groovyx.net.http.HttpBuilder

import java.util.zip.GZIPInputStream

class ContentParse {
    public static void main(String[] args) {
        def inflated = HttpBuilder.configure {
            request.uri = 'http://localhost:5050/archive.gz'
        }.get(String){
            response.parser('application/gzip') { ChainedHttpConfig cfg, FromServer fs ->
                def inflaterStream = new GZIPInputStream(fs.inputStream)
                inflaterStream.getText('UTF-8')
            }
        }
        println inflated
    }
}
