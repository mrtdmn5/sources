package com.j256.ormlite.logger;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes3.dex */
public final class ConsoleLogBackend implements LogBackend {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public final String className;

    /* loaded from: classes3.dex */
    public static class ConsoleLogBackendFactory implements LogBackendFactory {
        @Override // com.j256.ormlite.logger.LogBackendFactory
        public final LogBackend createLogBackend(String str) {
            return new ConsoleLogBackend(str);
        }
    }

    public ConsoleLogBackend(String str) {
        this.className = str;
    }

    @Override // com.j256.ormlite.logger.LogBackend
    public final boolean isLevelEnabled(Level level) {
        return true;
    }

    @Override // com.j256.ormlite.logger.LogBackend
    public final void log(Level level, String str) {
        String str2 = this.className + ' ' + level + ' ' + str + LINE_SEPARATOR;
        if (Level.WARNING.isEnabled(level)) {
            System.err.print(str2);
        } else {
            System.out.print(str2);
        }
    }

    @Override // com.j256.ormlite.logger.LogBackend
    public final void log(Level level, String str, Exception exc) {
        log(level, str);
        if (exc != null) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            log(level, stringWriter.toString());
        }
    }
}
