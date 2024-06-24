package com.j256.ormlite.logger;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import com.j256.ormlite.logger.ConsoleLogBackend;
import com.j256.ormlite.logger.LocalLogBackend;
import com.j256.ormlite.logger.NullLogBackend;

/* loaded from: classes3.dex */
public enum LogBackendType implements LogBackendFactory {
    SLF4J("com.j256.ormlite.logger.Slf4jLoggingLogBackend$Slf4jLoggingLogBackendFactory"),
    ANDROID("com.j256.ormlite.android.AndroidLogBackend$AndroidLogBackendFactory"),
    LOGBACK("com.j256.ormlite.logger.LogbackLogBackend$LogbackLogBackendFactory"),
    COMMONS_LOGGING("com.j256.ormlite.logger.CommonsLoggingLogBackend$CommonsLoggingLogBackendFactory"),
    LOG4J2("com.j256.ormlite.logger.Log4j2LogBackend$Log4j2LogBackendFactory"),
    LOG4J("com.j256.ormlite.logger.Log4jLogBackend$Log4jLogBackendFactory"),
    LOCAL(new LocalLogBackend.LocalLogBackendFactory()),
    CONSOLE(new ConsoleLogBackend.ConsoleLogBackendFactory()),
    JAVA_UTIL("com.j256.ormlite.logger.JavaUtilLogBackend$JavaUtilLogBackendFactory"),
    NULL(new NullLogBackend.NullLogBackendFactory());

    private final LogBackendFactory factory;

    LogBackendType(LogBackendFactory logBackendFactory) {
        this.factory = logBackendFactory;
    }

    private LogBackendFactory detectFactory(String str) {
        try {
            LogBackendFactory logBackendFactory = (LogBackendFactory) Class.forName(str).newInstance();
            logBackendFactory.createLogBackend("test").isLevelEnabled(Level.INFO);
            return logBackendFactory;
        } catch (Throwable th) {
            LocalLogBackend localLogBackend = new LocalLogBackend("LogBackendType." + this);
            Level level = Level.WARNING;
            StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Unable to get new instance of class ", str, ", so had to use local log: ");
            m.append(th.getMessage());
            localLogBackend.printMessage(level, m.toString(), null);
            return new LocalLogBackend.LocalLogBackendFactory();
        }
    }

    @Override // com.j256.ormlite.logger.LogBackendFactory
    public LogBackend createLogBackend(String str) {
        return this.factory.createLogBackend(str);
    }

    public boolean isAvailable() {
        if (this != LOCAL && (this == NULL || (this.factory instanceof LocalLogBackend.LocalLogBackendFactory))) {
            return false;
        }
        return true;
    }

    LogBackendType(String str) {
        this.factory = detectFactory(str);
    }
}
