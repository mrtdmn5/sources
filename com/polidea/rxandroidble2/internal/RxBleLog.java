package com.polidea.rxandroidble2.internal;

import android.util.Log;
import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.polidea.rxandroidble2.LogOptions$Logger;
import com.polidea.rxandroidble2.internal.logger.LoggerSetup;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class RxBleLog {
    public static final Pattern ANONYMOUS_CLASS = Pattern.compile("\\$\\d+$");
    public static final ThreadLocal<String> NEXT_TAG = new ThreadLocal<>();
    public static final LoggerSetup loggerSetup = new LoggerSetup(new AnonymousClass1());

    /* renamed from: com.polidea.rxandroidble2.internal.RxBleLog$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements LogOptions$Logger {
    }

    public static void d(String str, Object... objArr) {
        throwShade(3, null, str, objArr);
    }

    public static void i(String str, Object... objArr) {
        throwShade(4, null, str, objArr);
    }

    public static boolean isAtLeast(int r1) {
        loggerSetup.getClass();
        if (Integer.MAX_VALUE <= r1) {
            return true;
        }
        return false;
    }

    public static void throwShade(int r4, Throwable th, String str, Object... objArr) {
        String substring;
        LoggerSetup loggerSetup2 = loggerSetup;
        loggerSetup2.getClass();
        if (r4 < Integer.MAX_VALUE) {
            return;
        }
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        if (str != null && str.length() != 0) {
            if (th != null) {
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(str, "\n");
                m.append(Log.getStackTraceString(th));
                str = m.toString();
            }
        } else if (th != null) {
            str = Log.getStackTraceString(th);
        } else {
            return;
        }
        ThreadLocal<String> threadLocal = NEXT_TAG;
        String str2 = threadLocal.get();
        if (str2 != null) {
            threadLocal.remove();
        } else {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length >= 5) {
                String className = stackTrace[4].getClassName();
                Matcher matcher = ANONYMOUS_CLASS.matcher(className);
                if (matcher.find()) {
                    className = matcher.replaceAll("");
                }
                String replace = className.replace("Impl", "").replace("RxBle", "");
                int indexOf = replace.indexOf(36);
                if (indexOf <= 0) {
                    substring = replace.substring(replace.lastIndexOf(46) + 1);
                } else {
                    substring = replace.substring(replace.lastIndexOf(46) + 1, indexOf);
                }
                str2 = ConstraintSet$$ExternalSyntheticOutline0.m("RxBle#", substring);
            } else {
                throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
            }
        }
        int length = str.length();
        LogOptions$Logger logOptions$Logger = loggerSetup2.logger;
        if (length < 4000) {
            ((AnonymousClass1) logOptions$Logger).getClass();
            Log.println(r4, str2, str);
            return;
        }
        for (String str3 : str.split("\n")) {
            ((AnonymousClass1) logOptions$Logger).getClass();
            Log.println(r4, str2, str3);
        }
    }

    public static void v(String str, Object... objArr) {
        throwShade(2, null, str, objArr);
    }

    public static void w(String str, Object... objArr) {
        throwShade(5, null, str, objArr);
    }
}
