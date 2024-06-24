package com.amplifyframework.logging;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class BroadcastLogger implements Logger {
    private final List<Logger> delegates;

    public BroadcastLogger(List<Logger> list) {
        this.delegates = new ArrayList(list);
    }

    @Override // com.amplifyframework.logging.Logger
    @SuppressLint({"LogConditional"})
    public void debug(String str) {
        Iterator<Logger> it = this.delegates.iterator();
        while (it.hasNext()) {
            it.next().debug(str);
        }
    }

    @Override // com.amplifyframework.logging.Logger
    public void error(String str) {
        Iterator<Logger> it = this.delegates.iterator();
        while (it.hasNext()) {
            it.next().error(str);
        }
    }

    @Override // com.amplifyframework.logging.Logger
    public String getNamespace() {
        if (this.delegates.isEmpty()) {
            return "";
        }
        return this.delegates.get(0).getNamespace();
    }

    @Override // com.amplifyframework.logging.Logger
    public LogLevel getThresholdLevel() {
        if (!this.delegates.isEmpty()) {
            return this.delegates.get(0).getThresholdLevel();
        }
        throw new IllegalStateException("Cannot get threshold level for BroadcastLogger with no registered loggers.");
    }

    @Override // com.amplifyframework.logging.Logger
    @SuppressLint({"LogConditional"})
    public void info(String str) {
        Iterator<Logger> it = this.delegates.iterator();
        while (it.hasNext()) {
            it.next().info(str);
        }
    }

    @Override // com.amplifyframework.logging.Logger
    @SuppressLint({"LogConditional"})
    public void verbose(String str) {
        Iterator<Logger> it = this.delegates.iterator();
        while (it.hasNext()) {
            it.next().verbose(str);
        }
    }

    @Override // com.amplifyframework.logging.Logger
    public void warn(String str) {
        Iterator<Logger> it = this.delegates.iterator();
        while (it.hasNext()) {
            it.next().warn(str);
        }
    }

    @Override // com.amplifyframework.logging.Logger
    public void error(String str, Throwable th) {
        Iterator<Logger> it = this.delegates.iterator();
        while (it.hasNext()) {
            it.next().error(str, th);
        }
    }

    @Override // com.amplifyframework.logging.Logger
    public void warn(String str, Throwable th) {
        Iterator<Logger> it = this.delegates.iterator();
        while (it.hasNext()) {
            it.next().warn(str, th);
        }
    }
}
