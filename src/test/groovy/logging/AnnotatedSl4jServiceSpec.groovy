package logging

import com.google.common.collect.ImmutableList
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification
import uk.org.lidalia.slf4jext.Level
import uk.org.lidalia.slf4jtest.LoggingEvent
import uk.org.lidalia.slf4jtest.TestLogger
import uk.org.lidalia.slf4jtest.TestLoggerFactory

class AnnotatedSl4jServiceSpec extends Specification implements ServiceUnitTest<AnnotatedSl4jService> {

    def cleanup() {
        TestLoggerFactory.clear()
    }

    void "verify logging with sl4j-test"() {
        when:
        TestLogger logger = TestLoggerFactory.getTestLogger("logging.AnnotatedSl4jService")

        service.logSomething()

        ImmutableList<LoggingEvent> loggingEvents = logger.getLoggingEvents()

        then:
        loggingEvents.size() == 1
        loggingEvents[0].message == "Live life to the fullest"
        loggingEvents[0].level == Level.INFO
    }
}
