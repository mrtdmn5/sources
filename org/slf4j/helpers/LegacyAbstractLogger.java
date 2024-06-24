package org.slf4j.helpers;

import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.event.Level;

/* loaded from: classes4.dex */
public abstract class LegacyAbstractLogger implements Logger, Serializable {
    @Override // org.slf4j.Logger
    public final void debug(String str) {
        Level level = Level.ERROR;
        handleNormalizedLoggingCall(null);
    }

    @Override // org.slf4j.Logger
    public final void error(String str) {
        Level level = Level.ERROR;
        handleNormalizedLoggingCall(null);
    }

    public abstract void handleNormalizedLoggingCall(Object[] objArr);

    @Override // org.slf4j.Logger
    public final void info(String str) {
        Level level = Level.ERROR;
        handleNormalizedLoggingCall(null);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str) {
        Level level = Level.ERROR;
        handleNormalizedLoggingCall(null);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str) {
        Level level = Level.ERROR;
        handleNormalizedLoggingCall(null);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Throwable th) {
        Level level = Level.ERROR;
        handleNormalizedLoggingCall(null);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Throwable th) {
        Level level = Level.ERROR;
        handleNormalizedLoggingCall(null);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Throwable th) {
        Level level = Level.ERROR;
        handleNormalizedLoggingCall(null);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Throwable th) {
        Level level = Level.ERROR;
        handleNormalizedLoggingCall(null);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Throwable th) {
        Level level = Level.ERROR;
        handleNormalizedLoggingCall(null);
    }
}
