package logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Non grails groovy class with a declared Slf4j logging object
 */
class DeclaredSlf4jService {

    private static Logger log = LoggerFactory.getLogger(DeclaredSlf4jService.class)

    void logSomething() {
        println "*********** log in the class ******" + log.dump()
        log.info("Carpe Diem")
    }
}
