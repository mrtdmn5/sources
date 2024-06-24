package com.amplifyframework.devmenu;

import android.annotation.SuppressLint;
import com.amplifyframework.logging.LogLevel;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.util.Immutable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class PersistentLogger implements Logger {
    private static final int MAX_NUM_LOGS = 500;
    private final List<LogEntry> logs;
    private final String namespace;

    public PersistentLogger(String str) {
        Objects.requireNonNull(str);
        this.namespace = str;
        this.logs = new LinkedList();
    }

    private void addToLogs(String str, Throwable th, LogLevel logLevel) {
        if (this.logs.size() == 500) {
            this.logs.remove(0);
        }
        this.logs.add(new LogEntry(new Date(), this.namespace, str, th, logLevel));
    }

    @Override // com.amplifyframework.logging.Logger
    @SuppressLint({"LogConditional"})
    public void debug(String str) {
        addToLogs(str, null, LogLevel.DEBUG);
    }

    @Override // com.amplifyframework.logging.Logger
    public void error(String str) {
        addToLogs(str, null, LogLevel.ERROR);
    }

    public List<LogEntry> getLogs() {
        return Immutable.of(this.logs);
    }

    @Override // com.amplifyframework.logging.Logger
    public String getNamespace() {
        return this.namespace;
    }

    @Override // com.amplifyframework.logging.Logger
    public LogLevel getThresholdLevel() {
        return LogLevel.VERBOSE;
    }

    @Override // com.amplifyframework.logging.Logger
    @SuppressLint({"LogConditional"})
    public void info(String str) {
        addToLogs(str, null, LogLevel.INFO);
    }

    @Override // com.amplifyframework.logging.Logger
    @SuppressLint({"LogConditional"})
    public void verbose(String str) {
        addToLogs(str, null, LogLevel.VERBOSE);
    }

    @Override // com.amplifyframework.logging.Logger
    public void warn(String str) {
        addToLogs(str, null, LogLevel.WARN);
    }

    @Override // com.amplifyframework.logging.Logger
    public void error(String str, Throwable th) {
        addToLogs(str, th, LogLevel.ERROR);
    }

    @Override // com.amplifyframework.logging.Logger
    public void warn(String str, Throwable th) {
        addToLogs(str, th, LogLevel.WARN);
    }
}
