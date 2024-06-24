package androidx.work;

import android.util.Log;

/* loaded from: classes.dex */
public abstract class Logger {
    public static Logger sLogger;

    /* loaded from: classes.dex */
    public static class LogcatLogger extends Logger {
        public final int mLoggingLevel;

        public LogcatLogger(int loggingLevel) {
            this.mLoggingLevel = loggingLevel;
        }

        @Override // androidx.work.Logger
        public final void debug(String tag, String message, Throwable... throwables) {
            if (this.mLoggingLevel <= 3) {
                if (throwables.length >= 1) {
                    Log.d(tag, message, throwables[0]);
                } else {
                    Log.d(tag, message);
                }
            }
        }

        @Override // androidx.work.Logger
        public final void error(String tag, String message, Throwable... throwables) {
            if (this.mLoggingLevel <= 6) {
                if (throwables.length >= 1) {
                    Log.e(tag, message, throwables[0]);
                } else {
                    Log.e(tag, message);
                }
            }
        }

        @Override // androidx.work.Logger
        public final void info(String tag, String message, Throwable... throwables) {
            if (this.mLoggingLevel <= 4) {
                if (throwables.length >= 1) {
                    Log.i(tag, message, throwables[0]);
                } else {
                    Log.i(tag, message);
                }
            }
        }

        @Override // androidx.work.Logger
        public final void warning(String tag, String message, Throwable... throwables) {
            if (this.mLoggingLevel <= 5) {
                if (throwables.length >= 1) {
                    Log.w(tag, message, throwables[0]);
                } else {
                    Log.w(tag, message);
                }
            }
        }
    }

    public static synchronized Logger get() {
        Logger logger;
        synchronized (Logger.class) {
            if (sLogger == null) {
                sLogger = new LogcatLogger(3);
            }
            logger = sLogger;
        }
        return logger;
    }

    public static String tagWithPrefix(String tag) {
        int length = tag.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= 20) {
            sb.append(tag.substring(0, 20));
        } else {
            sb.append(tag);
        }
        return sb.toString();
    }

    public abstract void debug(String tag, String message, Throwable... throwables);

    public abstract void error(String tag, String message, Throwable... throwables);

    public abstract void info(String tag, String message, Throwable... throwables);

    public abstract void warning(String tag, String message, Throwable... throwables);
}
