package org.slf4j.helpers;

/* loaded from: classes4.dex */
public final class NOPLogger extends NamedLoggerBase {
    public static final NOPLogger NOP_LOGGER = new NOPLogger();

    @Override // org.slf4j.Logger
    public final void debug(String str) {
    }

    @Override // org.slf4j.Logger
    public final void error(String str) {
    }

    @Override // org.slf4j.Logger
    public final String getName() {
        return "NOP";
    }

    @Override // org.slf4j.Logger
    public final void info(String str) {
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final void trace(String str) {
    }

    @Override // org.slf4j.Logger
    public final void warn(String str) {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Throwable th) {
    }
}
