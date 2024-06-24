package mu.internal;

import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;
import mu.KMarkerFactory;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.spi.LocationAwareLogger;

/* compiled from: LocationAwareKLogger.kt */
/* loaded from: classes4.dex */
public final class LocationAwareKLogger implements KLogger, Logger {
    public final LocationAwareLogger underlyingLogger;
    public final Marker ENTRY = KMarkerFactory.getMarker("ENTRY");
    public final Marker EXIT = KMarkerFactory.getMarker("EXIT");
    public final Marker THROWING = KMarkerFactory.getMarker("THROWING");
    public final Marker CATCHING = KMarkerFactory.getMarker("CATCHING");

    public LocationAwareKLogger(LocationAwareLogger locationAwareLogger) {
        this.underlyingLogger = locationAwareLogger;
    }

    @Override // org.slf4j.Logger
    public final void debug(String str) {
        LocationAwareLogger locationAwareLogger = this.underlyingLogger;
        if (locationAwareLogger.isDebugEnabled()) {
            locationAwareLogger.log$1();
        }
    }

    @Override // org.slf4j.Logger
    public final void error(String str) {
        LocationAwareLogger locationAwareLogger = this.underlyingLogger;
        if (locationAwareLogger.isErrorEnabled()) {
            locationAwareLogger.log$1();
        }
    }

    @Override // org.slf4j.Logger
    public final String getName() {
        return this.underlyingLogger.getName();
    }

    @Override // org.slf4j.Logger
    public final void info(String str) {
        LocationAwareLogger locationAwareLogger = this.underlyingLogger;
        if (locationAwareLogger.isInfoEnabled()) {
            locationAwareLogger.log$1();
        }
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled() {
        return this.underlyingLogger.isDebugEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled() {
        return this.underlyingLogger.isErrorEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled() {
        return this.underlyingLogger.isInfoEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled() {
        return this.underlyingLogger.isTraceEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled() {
        return this.underlyingLogger.isWarnEnabled();
    }

    @Override // org.slf4j.Logger
    public final void trace(String str) {
        LocationAwareLogger locationAwareLogger = this.underlyingLogger;
        if (locationAwareLogger.isTraceEnabled()) {
            locationAwareLogger.log$1();
        }
    }

    @Override // org.slf4j.Logger
    public final void warn(String str) {
        LocationAwareLogger locationAwareLogger = this.underlyingLogger;
        if (locationAwareLogger.isWarnEnabled()) {
            locationAwareLogger.log$1();
        }
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Throwable th) {
        LocationAwareLogger locationAwareLogger = this.underlyingLogger;
        if (locationAwareLogger.isDebugEnabled()) {
            locationAwareLogger.log$1();
        }
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Throwable th) {
        LocationAwareLogger locationAwareLogger = this.underlyingLogger;
        if (locationAwareLogger.isErrorEnabled()) {
            locationAwareLogger.log$1();
        }
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Throwable th) {
        LocationAwareLogger locationAwareLogger = this.underlyingLogger;
        if (locationAwareLogger.isInfoEnabled()) {
            locationAwareLogger.log$1();
        }
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Throwable th) {
        LocationAwareLogger locationAwareLogger = this.underlyingLogger;
        if (locationAwareLogger.isTraceEnabled()) {
            locationAwareLogger.log$1();
        }
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Throwable th) {
        LocationAwareLogger locationAwareLogger = this.underlyingLogger;
        if (locationAwareLogger.isWarnEnabled()) {
            locationAwareLogger.log$1();
        }
    }

    @Override // mu.KLogger
    public final void debug(Function0<? extends Object> msg) {
        String m;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isDebugEnabled()) {
            try {
                m = String.valueOf(msg.invoke());
            } catch (Exception e) {
                if (!System.getProperties().containsKey("kotlin-logging.throwOnMessageError")) {
                    m = Model$$ExternalSyntheticOutline0.m("Log message invocation failed: ", e);
                } else {
                    throw e;
                }
            }
            debug(m);
        }
    }

    @Override // mu.KLogger
    public final void error(Function0<? extends Object> msg) {
        String m;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isErrorEnabled()) {
            try {
                m = String.valueOf(msg.invoke());
            } catch (Exception e) {
                if (!System.getProperties().containsKey("kotlin-logging.throwOnMessageError")) {
                    m = Model$$ExternalSyntheticOutline0.m("Log message invocation failed: ", e);
                } else {
                    throw e;
                }
            }
            error(m);
        }
    }

    @Override // mu.KLogger
    public final void info(Function0<? extends Object> msg) {
        String m;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isInfoEnabled()) {
            try {
                m = String.valueOf(msg.invoke());
            } catch (Exception e) {
                if (!System.getProperties().containsKey("kotlin-logging.throwOnMessageError")) {
                    m = Model$$ExternalSyntheticOutline0.m("Log message invocation failed: ", e);
                } else {
                    throw e;
                }
            }
            info(m);
        }
    }

    @Override // mu.KLogger
    public final void trace(Function0<? extends Object> msg) {
        String m;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isTraceEnabled()) {
            try {
                m = String.valueOf(msg.invoke());
            } catch (Exception e) {
                if (!System.getProperties().containsKey("kotlin-logging.throwOnMessageError")) {
                    m = Model$$ExternalSyntheticOutline0.m("Log message invocation failed: ", e);
                } else {
                    throw e;
                }
            }
            trace(m);
        }
    }

    @Override // mu.KLogger
    public final void warn(Function0<? extends Object> msg) {
        String m;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isWarnEnabled()) {
            try {
                m = String.valueOf(msg.invoke());
            } catch (Exception e) {
                if (!System.getProperties().containsKey("kotlin-logging.throwOnMessageError")) {
                    m = Model$$ExternalSyntheticOutline0.m("Log message invocation failed: ", e);
                } else {
                    throw e;
                }
            }
            warn(m);
        }
    }

    @Override // mu.KLogger
    public final void debug(Throwable th, Function0<? extends Object> msg) {
        String m;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isDebugEnabled()) {
            try {
                m = String.valueOf(msg.invoke());
            } catch (Exception e) {
                if (!System.getProperties().containsKey("kotlin-logging.throwOnMessageError")) {
                    m = Model$$ExternalSyntheticOutline0.m("Log message invocation failed: ", e);
                } else {
                    throw e;
                }
            }
            debug(m, th);
        }
    }

    @Override // mu.KLogger
    public final void error(Throwable th, Function0<? extends Object> msg) {
        String m;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isErrorEnabled()) {
            try {
                m = String.valueOf(msg.invoke());
            } catch (Exception e) {
                if (!System.getProperties().containsKey("kotlin-logging.throwOnMessageError")) {
                    m = Model$$ExternalSyntheticOutline0.m("Log message invocation failed: ", e);
                } else {
                    throw e;
                }
            }
            error(m, th);
        }
    }

    @Override // mu.KLogger
    public final void info(Throwable th, Function0<? extends Object> msg) {
        String m;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isInfoEnabled()) {
            try {
                m = String.valueOf(msg.invoke());
            } catch (Exception e) {
                if (!System.getProperties().containsKey("kotlin-logging.throwOnMessageError")) {
                    m = Model$$ExternalSyntheticOutline0.m("Log message invocation failed: ", e);
                } else {
                    throw e;
                }
            }
            info(m, th);
        }
    }

    @Override // mu.KLogger
    public final void trace(Throwable th, Function0<? extends Object> msg) {
        String m;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isTraceEnabled()) {
            try {
                m = String.valueOf(msg.invoke());
            } catch (Exception e) {
                if (!System.getProperties().containsKey("kotlin-logging.throwOnMessageError")) {
                    m = Model$$ExternalSyntheticOutline0.m("Log message invocation failed: ", e);
                } else {
                    throw e;
                }
            }
            trace(m, th);
        }
    }

    @Override // mu.KLogger
    public final void warn(Throwable th, Function0<? extends Object> msg) {
        String m;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isWarnEnabled()) {
            try {
                m = String.valueOf(msg.invoke());
            } catch (Exception e) {
                if (!System.getProperties().containsKey("kotlin-logging.throwOnMessageError")) {
                    m = Model$$ExternalSyntheticOutline0.m("Log message invocation failed: ", e);
                } else {
                    throw e;
                }
            }
            warn(m, th);
        }
    }
}
