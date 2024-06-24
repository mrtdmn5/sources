package com.google.common.io;

import com.google.common.base.Throwables;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.logging.Level;

/* loaded from: classes3.dex */
public final class Closer implements Closeable {
    public static final Suppressor SUPPRESSOR;
    public final ArrayDeque stack = new ArrayDeque(4);
    public final Suppressor suppressor;
    public Throwable thrown;

    /* loaded from: classes3.dex */
    public static final class LoggingSuppressor implements Suppressor {
        public static final LoggingSuppressor INSTANCE = new LoggingSuppressor();

        @Override // com.google.common.io.Closer.Suppressor
        public final void suppress(Closeable closeable, Throwable th, Throwable th2) {
            Closeables.logger.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, th2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class SuppressingSuppressor implements Suppressor {
        public static final SuppressingSuppressor INSTANCE = new SuppressingSuppressor();
        public static final Method addSuppressed;

        static {
            Method method;
            try {
                method = Throwable.class.getMethod("addSuppressed", Throwable.class);
            } catch (Throwable unused) {
                method = null;
            }
            addSuppressed = method;
        }

        @Override // com.google.common.io.Closer.Suppressor
        public final void suppress(Closeable closeable, Throwable th, Throwable th2) {
            if (th == th2) {
                return;
            }
            try {
                addSuppressed.invoke(th, th2);
            } catch (Throwable unused) {
                Closeables.logger.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, th2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface Suppressor {
        void suppress(Closeable closeable, Throwable th, Throwable th2);
    }

    static {
        boolean z;
        Suppressor suppressor;
        if (SuppressingSuppressor.addSuppressed != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            suppressor = SuppressingSuppressor.INSTANCE;
        } else {
            suppressor = LoggingSuppressor.INSTANCE;
        }
        SUPPRESSOR = suppressor;
    }

    public Closer(Suppressor suppressor) {
        suppressor.getClass();
        this.suppressor = suppressor;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Throwable th = this.thrown;
        while (true) {
            ArrayDeque arrayDeque = this.stack;
            if (arrayDeque.isEmpty()) {
                break;
            }
            Closeable closeable = (Closeable) arrayDeque.removeFirst();
            try {
                closeable.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.suppressor.suppress(closeable, th, th2);
                }
            }
        }
        if (this.thrown == null && th != null) {
            Throwables.propagateIfPossible(th);
            throw new AssertionError(th);
        }
    }
}
