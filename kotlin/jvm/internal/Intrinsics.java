package kotlin.jvm.internal;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.Arrays;
import kotlin.UninitializedPropertyAccessException;

/* loaded from: classes.dex */
public final class Intrinsics {

    /* loaded from: classes.dex */
    public static class Kotlin {
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void checkExpressionValueIsNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str.concat(" must not be null"));
        sanitizeStackTrace(Intrinsics.class.getName(), illegalStateException);
        throw illegalStateException;
    }

    public static void checkNotNull(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        sanitizeStackTrace(Intrinsics.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static void checkNotNullExpressionValue(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        sanitizeStackTrace(Intrinsics.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static void checkNotNullParameter(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(createParameterIsNullExceptionMessage(str));
        sanitizeStackTrace(Intrinsics.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static void checkParameterIsNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(createParameterIsNullExceptionMessage(str));
        sanitizeStackTrace(Intrinsics.class.getName(), illegalArgumentException);
        throw illegalArgumentException;
    }

    public static int compare(int r0, int r1) {
        if (r0 < r1) {
            return -1;
        }
        if (r0 == r1) {
            return 0;
        }
        return 1;
    }

    public static String createParameterIsNullExceptionMessage(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Intrinsics.class.getName();
        int r2 = 0;
        while (!stackTrace[r2].getClassName().equals(name)) {
            r2++;
        }
        while (stackTrace[r2].getClassName().equals(name)) {
            r2++;
        }
        StackTraceElement stackTraceElement = stackTrace[r2];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + InstructionFileId.DOT + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void reifiedOperationMarker() {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void sanitizeStackTrace(String str, RuntimeException runtimeException) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int r2 = -1;
        for (int r3 = 0; r3 < length; r3++) {
            if (str.equals(stackTrace[r3].getClassName())) {
                r2 = r3;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, r2 + 1, length));
    }

    public static void throwUninitializedPropertyAccessException(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(zzav$$ExternalSyntheticOutline0.m("lateinit property ", str, " has not been initialized"));
        sanitizeStackTrace(Intrinsics.class.getName(), uninitializedPropertyAccessException);
        throw uninitializedPropertyAccessException;
    }

    public static boolean areEqual(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str);
        sanitizeStackTrace(Intrinsics.class.getName(), nullPointerException);
        throw nullPointerException;
    }
}
