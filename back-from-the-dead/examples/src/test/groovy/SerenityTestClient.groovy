import groovyx.net.http.ChainedHttpConfig
import groovyx.net.http.HttpBuilder
import groovyx.net.http.HttpObjectConfig

import java.util.concurrent.Executor

/**
 * Created by noam on 31/05/2017.
 */
class SerenityTestClient extends HttpBuilder {

    private List requestLog

    protected SerenityTestClient(HttpObjectConfig objectConfig, List requestLog) {
        super(objectConfig)
        this.requestLog = requestLog
        println 'Test Client: Initializing'
    }

    @Override
    protected Object doGet(ChainedHttpConfig config) {
        println 'Test Client: Getting'
        requestLog << config.request.uri.toURI().toString()
        return 'Shiny!'
    }

    @Override
    protected Object doHead(ChainedHttpConfig config) {
        return null
    }

    @Override
    protected Object doPost(ChainedHttpConfig config) {
        return null
    }

    @Override
    protected Object doPut(ChainedHttpConfig config) {
        return null
    }

    @Override
    protected Object doDelete(ChainedHttpConfig config) {
        return null
    }

    @Override
    protected ChainedHttpConfig getObjectConfig() {
        return null
    }

    @Override
    Executor getExecutor() {
        return null
    }

    @Override
    void close() throws IOException {

    }
}
