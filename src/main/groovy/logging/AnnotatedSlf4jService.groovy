package logging

import groovy.util.logging.Slf4j

/**
 * Non grails groovy class with a annotation for Slf4j
 */
@Slf4j
class AnnotatedSlf4jService {

    void logSomething() {
        println "*********** log in the class ******" + log.dump()
        log.info("Live life to the fullest")
    }
}
