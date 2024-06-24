package com.amplifyframework.devmenu;

import android.util.Log;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.logging.LogLevel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes.dex */
public final class LogEntry implements Comparable<LogEntry> {
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    private final Date date;
    private final LogLevel logLevel;
    private final String message;
    private final String namespace;
    private final Throwable throwable;

    public LogEntry(Date date, String str, String str2, Throwable th, LogLevel logLevel) {
        Objects.requireNonNull(date);
        this.date = date;
        Objects.requireNonNull(logLevel);
        this.logLevel = logLevel;
        this.namespace = str;
        this.message = str2;
        this.throwable = th;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LogEntry.class != obj.getClass()) {
            return false;
        }
        LogEntry logEntry = (LogEntry) obj;
        if (this.date.equals(logEntry.getDate()) && ObjectsCompat$Api19Impl.equals(this.namespace, logEntry.getNamespace()) && ObjectsCompat$Api19Impl.equals(this.message, logEntry.getMessage()) && this.logLevel == logEntry.getLogLevel() && ObjectsCompat$Api19Impl.equals(this.throwable, logEntry.getThrowable())) {
            return true;
        }
        return false;
    }

    public Date getDate() {
        return this.date;
    }

    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    public String getMessage() {
        return this.message;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public int hashCode() {
        int r1;
        int r12;
        int hashCode = getDate().hashCode() * 31;
        int r2 = 0;
        if (getNamespace() != null) {
            r1 = getNamespace().hashCode();
        } else {
            r1 = 0;
        }
        int r0 = (hashCode + r1) * 31;
        if (getMessage() != null) {
            r12 = getMessage().hashCode();
        } else {
            r12 = 0;
        }
        int r02 = (r0 + r12) * 31;
        if (getThrowable() != null) {
            r2 = getThrowable().hashCode();
        }
        return getLogLevel().hashCode() + ((r02 + r2) * 31);
    }

    public String toString() {
        String stackTraceString;
        Locale locale = Locale.US;
        String format = new SimpleDateFormat(DATE_TIME_FORMAT, locale).format(this.date);
        Throwable th = this.throwable;
        if (th == null) {
            stackTraceString = "";
        } else {
            stackTraceString = Log.getStackTraceString(th);
        }
        if (!stackTraceString.isEmpty() && !stackTraceString.endsWith("\n")) {
            stackTraceString = stackTraceString.concat("\n");
        }
        return String.format(locale, "[%s] %s %s: %s\n%s", this.logLevel.name(), format, this.namespace, this.message, stackTraceString);
    }

    @Override // java.lang.Comparable
    public int compareTo(LogEntry logEntry) {
        return getDate().compareTo(logEntry.getDate());
    }
}
