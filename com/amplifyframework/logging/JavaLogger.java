package com.amplifyframework.logging;

import java.util.Objects;

/* loaded from: classes.dex */
final class JavaLogger implements Logger {
    private final String namespace;
    private final LogLevel threshold;

    public JavaLogger(String str, LogLevel logLevel) {
        Objects.requireNonNull(logLevel);
        this.threshold = logLevel;
        Objects.requireNonNull(str);
        this.namespace = str;
    }

    private void log(LogLevel logLevel, String str) {
        log(logLevel, str, null);
    }

    @Override // com.amplifyframework.logging.Logger
    public void debug(String str) {
        LogLevel logLevel = this.threshold;
        LogLevel logLevel2 = LogLevel.DEBUG;
        if (logLevel.above(logLevel2)) {
            return;
        }
        log(logLevel2, str);
    }

    @Override // com.amplifyframework.logging.Logger
    public void error(String str) {
        LogLevel logLevel = this.threshold;
        LogLevel logLevel2 = LogLevel.ERROR;
        if (logLevel.above(logLevel2)) {
            return;
        }
        log(logLevel2, str);
    }

    @Override // com.amplifyframework.logging.Logger
    public String getNamespace() {
        return this.namespace;
    }

    @Override // com.amplifyframework.logging.Logger
    public LogLevel getThresholdLevel() {
        return this.threshold;
    }

    @Override // com.amplifyframework.logging.Logger
    public void info(String str) {
        LogLevel logLevel = this.threshold;
        LogLevel logLevel2 = LogLevel.INFO;
        if (logLevel.above(logLevel2)) {
            return;
        }
        log(logLevel2, str);
    }

    @Override // com.amplifyframework.logging.Logger
    public void verbose(String str) {
        LogLevel logLevel = this.threshold;
        LogLevel logLevel2 = LogLevel.VERBOSE;
        if (logLevel.above(logLevel2)) {
            return;
        }
        log(logLevel2, str);
    }

    @Override // com.amplifyframework.logging.Logger
    public void warn(String str) {
        LogLevel logLevel = this.threshold;
        LogLevel logLevel2 = LogLevel.WARN;
        if (logLevel.above(logLevel2)) {
            return;
        }
        log(logLevel2, str);
    }

    private void log(LogLevel logLevel, String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(logLevel);
        sb.append("/");
        sb.append(this.namespace);
        sb.append(": ");
        sb.append(str);
        if (th != null) {
            sb.append("\n");
            sb.append(th);
        }
        System.out.println(sb.toString());
    }

    @Override // com.amplifyframework.logging.Logger
    public void error(String str, Throwable th) {
        LogLevel logLevel = this.threshold;
        LogLevel logLevel2 = LogLevel.ERROR;
        if (logLevel.above(logLevel2)) {
            return;
        }
        log(logLevel2, str, th);
    }

    @Override // com.amplifyframework.logging.Logger
    public void warn(String str, Throwable th) {
        LogLevel logLevel = this.threshold;
        LogLevel logLevel2 = LogLevel.WARN;
        if (logLevel.above(logLevel2)) {
            return;
        }
        log(logLevel2, str, th);
    }
}
