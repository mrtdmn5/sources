package com.j256.ormlite.logger;

import com.amazonaws.services.s3.internal.Constants;
import java.io.Serializable;
import java.lang.reflect.Array;

/* loaded from: classes3.dex */
public final class Logger {
    public static final Object UNKNOWN_ARG = new Object();
    public final LogBackend backend;

    public Logger(LogBackend logBackend) {
        this.backend = logBackend;
    }

    public static void appendArg(Object obj, StringBuilder sb) {
        if (obj != UNKNOWN_ARG) {
            if (obj == null) {
                sb.append(Constants.NULL_VERSION_ID);
                return;
            }
            if (obj.getClass().isArray()) {
                sb.append('[');
                int length = Array.getLength(obj);
                for (int r1 = 0; r1 < length; r1++) {
                    if (r1 > 0) {
                        sb.append(", ");
                    }
                    appendArg(Array.get(obj, r1), sb);
                }
                sb.append(']');
                return;
            }
            sb.append(obj.toString());
        }
    }

    public final void debug(Object obj, String str) {
        Level level = Level.DEBUG;
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj2, obj2, null);
    }

    public final void logIfEnabled(Level level, Exception exc, String str, Object obj, Object obj2, Object obj3, Object[] objArr) {
        Object obj4 = UNKNOWN_ARG;
        LogBackend logBackend = this.backend;
        if (logBackend.isLevelEnabled(level)) {
            StringBuilder sb = null;
            int r3 = 0;
            int r4 = 0;
            while (true) {
                int indexOf = str.indexOf("{}", r3);
                if (indexOf == -1) {
                    break;
                }
                if (sb == null) {
                    sb = new StringBuilder(128);
                }
                sb.append((CharSequence) str, r3, indexOf);
                r3 = indexOf + 2;
                if (objArr == null) {
                    if (r4 == 0) {
                        appendArg(obj, sb);
                    } else if (r4 == 1) {
                        appendArg(obj2, sb);
                    } else if (r4 == 2) {
                        appendArg(obj3, sb);
                    } else if (r4 == 3) {
                        appendArg(obj4, sb);
                    }
                } else if (r4 < objArr.length) {
                    appendArg(objArr[r4], sb);
                }
                r4++;
            }
            if (sb != null) {
                sb.append((CharSequence) str, r3, str.length());
                str = sb.toString();
            }
            if (exc == null) {
                logBackend.log(level, str);
            } else {
                logBackend.log(level, str, exc);
            }
        }
    }

    public final void trace(Object obj, String str) {
        Level level = Level.TRACE;
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj2, obj2, null);
    }

    public final void debug(Object obj, Object obj2, String str) {
        logIfEnabled(Level.DEBUG, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public final void trace(Object obj, Object obj2, String str) {
        logIfEnabled(Level.TRACE, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public final void debug(String str, Object obj, Object obj2, Serializable serializable) {
        logIfEnabled(Level.DEBUG, null, str, obj, obj2, serializable, null);
    }

    public final void trace(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Level.TRACE, null, str, obj, obj2, obj3, null);
    }
}
