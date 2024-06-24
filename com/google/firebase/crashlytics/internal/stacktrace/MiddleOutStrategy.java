package com.google.firebase.crashlytics.internal.stacktrace;

/* loaded from: classes3.dex */
public final class MiddleOutStrategy implements StackTraceTrimmingStrategy {
    public final int trimmedSize = 1024;

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public final StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int r1 = this.trimmedSize;
        if (length <= r1) {
            return stackTraceElementArr;
        }
        int r0 = r1 / 2;
        int r2 = r1 - r0;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[r1];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, r2);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - r0, stackTraceElementArr2, r2, r0);
        return stackTraceElementArr2;
    }
}
