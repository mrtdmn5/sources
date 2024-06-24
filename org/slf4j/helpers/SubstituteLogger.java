package org.slf4j.helpers;

import java.lang.reflect.Method;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.event.EventRecordingLogger;
import org.slf4j.event.LoggingEvent;
import org.slf4j.event.SubstituteLoggingEvent;

/* loaded from: classes4.dex */
public final class SubstituteLogger implements Logger {
    public volatile Logger _delegate;
    public final boolean createdPostInitialization;
    public Boolean delegateEventAware;
    public final Queue<SubstituteLoggingEvent> eventQueue;
    public EventRecordingLogger eventRecordingLogger;
    public Method logMethodCache;
    public final String name;

    public SubstituteLogger(String str, LinkedBlockingQueue linkedBlockingQueue, boolean z) {
        this.name = str;
        this.eventQueue = linkedBlockingQueue;
        this.createdPostInitialization = z;
    }

    @Override // org.slf4j.Logger
    public final void debug(String str) {
        delegate().debug(str);
    }

    public final Logger delegate() {
        if (this._delegate != null) {
            return this._delegate;
        }
        if (this.createdPostInitialization) {
            return NOPLogger.NOP_LOGGER;
        }
        if (this.eventRecordingLogger == null) {
            this.eventRecordingLogger = new EventRecordingLogger(this, this.eventQueue);
        }
        return this.eventRecordingLogger;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SubstituteLogger.class == obj.getClass() && this.name.equals(((SubstituteLogger) obj).name)) {
            return true;
        }
        return false;
    }

    @Override // org.slf4j.Logger
    public final void error(String str) {
        delegate().error(str);
    }

    @Override // org.slf4j.Logger
    public final String getName() {
        return this.name;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    @Override // org.slf4j.Logger
    public final void info(String str) {
        delegate().info(str);
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled() {
        return delegate().isDebugEnabled();
    }

    public final boolean isDelegateEventAware() {
        Boolean bool = this.delegateEventAware;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.logMethodCache = this._delegate.getClass().getMethod("log", LoggingEvent.class);
            this.delegateEventAware = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.delegateEventAware = Boolean.FALSE;
        }
        return this.delegateEventAware.booleanValue();
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled() {
        return delegate().isErrorEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled() {
        return delegate().isInfoEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled() {
        return delegate().isTraceEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled() {
        return delegate().isWarnEnabled();
    }

    @Override // org.slf4j.Logger
    public final void trace(String str) {
        delegate().trace(str);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str) {
        delegate().warn(str);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Throwable th) {
        delegate().debug(str, th);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Throwable th) {
        delegate().error(str, th);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Throwable th) {
        delegate().info(str, th);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Throwable th) {
        delegate().trace(str, th);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Throwable th) {
        delegate().warn(str, th);
    }
}
