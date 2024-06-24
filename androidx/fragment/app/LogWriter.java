package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
public final class LogWriter extends Writer {
    public final StringBuilder mBuilder = new StringBuilder(128);
    public final String mTag = "FragmentManager";

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        flushBuilder();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        flushBuilder();
    }

    public final void flushBuilder() {
        StringBuilder sb = this.mBuilder;
        if (sb.length() > 0) {
            Log.d(this.mTag, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int r5, int r6) {
        for (int r0 = 0; r0 < r6; r0++) {
            char c = cArr[r5 + r0];
            if (c == '\n') {
                flushBuilder();
            } else {
                this.mBuilder.append(c);
            }
        }
    }
}
