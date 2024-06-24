package com.google.firebase.crashlytics.internal.stacktrace;

/* loaded from: classes3.dex */
public final class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy {
    public final MiddleOutStrategy middleOutStrategy = new MiddleOutStrategy();
    public final StackTraceTrimmingStrategy[] trimmingStrategies;

    public MiddleOutFallbackStrategy(StackTraceTrimmingStrategy... stackTraceTrimmingStrategyArr) {
        this.trimmingStrategies = stackTraceTrimmingStrategyArr;
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public final StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= 1024) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (StackTraceTrimmingStrategy stackTraceTrimmingStrategy : this.trimmingStrategies) {
            if (stackTraceElementArr2.length <= 1024) {
                break;
            }
            stackTraceElementArr2 = stackTraceTrimmingStrategy.getTrimmedStackTrace(stackTraceElementArr);
        }
        if (stackTraceElementArr2.length > 1024) {
            return this.middleOutStrategy.getTrimmedStackTrace(stackTraceElementArr2);
        }
        return stackTraceElementArr2;
    }
}
