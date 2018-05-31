package logging

import com.google.common.collect.ImmutableList
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification
import uk.org.lidalia.slf4jext.Level
import uk.org.lidalia.slf4jtest.LoggingEvent
import uk.org.lidalia.slf4jtest.TestLogger
import uk.org.lidalia.slf4jtest.TestLoggerFactory

class AgeServiceSpec extends Specification implements ServiceUnitTest<AgeService> {

    def cleanup() {
        TestLoggerFactory.clear()
    }

    void "test service prints to console"() {
        when:
        service.offerAgeAdvice(15)

        then:
        1 == 1
    }

    void "verify logging with slf4j-test"() {
        when:
        TestLogger logger = TestLoggerFactory.getTestLogger("logging.AgeService")

        service.offerAgeAdvice(-1)

        ImmutableList<LoggingEvent> loggingEvents = logger.getLoggingEvents()

        then:
        loggingEvents.size() == 1
        loggingEvents[0].message == "You cannot be -1 years old!"
        loggingEvents[0].level == Level.ERROR
    }
}
