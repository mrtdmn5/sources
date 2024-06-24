package okhttp3.internal.platform.android;

import android.util.Log;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: AndroidLog.kt */
/* loaded from: classes4.dex */
public final class AndroidLogHandler extends Handler {
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    @Override // java.util.logging.Handler
    public final void publish(LogRecord record) {
        int r1;
        int min;
        Intrinsics.checkNotNullParameter(record, "record");
        CopyOnWriteArraySet<Logger> copyOnWriteArraySet = AndroidLog.configuredLoggers;
        String loggerName = record.getLoggerName();
        Intrinsics.checkNotNullExpressionValue(loggerName, "record.loggerName");
        if (record.getLevel().intValue() > Level.INFO.intValue()) {
            r1 = 5;
        } else if (record.getLevel().intValue() == Level.INFO.intValue()) {
            r1 = 4;
        } else {
            r1 = 3;
        }
        String message = record.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "record.message");
        Throwable thrown = record.getThrown();
        String str = AndroidLog.knownLoggers.get(loggerName);
        if (str == null) {
            str = StringsKt___StringsKt.take(23, loggerName);
        }
        if (Log.isLoggable(str, r1)) {
            if (thrown != null) {
                message = message + '\n' + Log.getStackTraceString(thrown);
            }
            int length = message.length();
            int r6 = 0;
            while (r6 < length) {
                int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) message, '\n', r6, false, 4);
                if (indexOf$default == -1) {
                    indexOf$default = length;
                }
                while (true) {
                    min = Math.min(indexOf$default, r6 + 4000);
                    String substring = message.substring(r6, min);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(r1, str, substring);
                    if (min >= indexOf$default) {
                        break;
                    } else {
                        r6 = min;
                    }
                }
                r6 = min + 1;
            }
        }
    }

    @Override // java.util.logging.Handler
    public final void close() {
    }

    @Override // java.util.logging.Handler
    public final void flush() {
    }
}
