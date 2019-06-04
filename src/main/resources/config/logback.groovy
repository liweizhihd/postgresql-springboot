package config

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.util.FileSize

appender("Console", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    }
}

appender("R", RollingFileAppender) {
    file = "/data/logs/postgresdemo/info.log"
    encoder(PatternLayoutEncoder) {
        pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    }
    rollingPolicy(SizeAndTimeBasedRollingPolicy) {
        fileNamePattern = "/data/logs/postgresdemo/info_%d{yyyy-MM-dd}.%i.log"
        maxFileSize = "10KB"
        maxHistory = 30
        totalSizeCap = FileSize.valueOf("500MB")
    }
}

logger("io.netty", Level.WARN)
logger("ch.qos.logback", Level.WARN)
logger("org.quartz", Level.ERROR)
logger("org.apache.ibatis", Level.ERROR)
logger("org.apache.ignite", Level.ERROR)
logger("com.example.postgresdemo.dao", Level.DEBUG)

root(Level.valueOf("INFO"), ["Console", "R"])