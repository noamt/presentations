import java.nio.file.Paths

@Grapes([
        @Grab('io.ratpack:ratpack-groovy:1.4.5'),
        @Grab('org.slf4j:slf4j-simple:1.7.21'),
        @GrabExclude('org.codehaus.groovy:groovy-all')
])
import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        get {
            response.headers.add('Date', new Date())
            render "Hello GR8Conf!"
        }
        get("archive.gz") {
            response.headers.add('Content-Type', 'application/gzip')
            response.sendFile(Paths.get('/Users/noam/work/private/presentations/back-from-the-dead/examples/archive.gz.Z'))
        }
    }
}