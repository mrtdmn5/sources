package com.animaconnected.logger;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.MonotonicTimeSource;
import kotlin.time.TimeSource;

/* compiled from: MeasurementBackend.kt */
/* loaded from: classes.dex */
public final class MeasurementBackendKt {
    private static MeasurementBackend measurementBackend;

    public static final MeasurementBackend getMeasurementBackend() {
        return measurementBackend;
    }

    public static final <T> T measure(Object obj, String tag, String str, Function0<? extends T> body) {
        String str2;
        MeasurementBackend measurementBackend2;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(body, "body");
        MeasurementBackend measurementBackend3 = getMeasurementBackend();
        if (measurementBackend3 != null) {
            str2 = measurementBackend3.begin(tag, str);
        } else {
            str2 = null;
        }
        long read = MonotonicTimeSource.read();
        T invoke = body.invoke();
        TimeSource.Monotonic.ValueTimeMark.m1693elapsedNowUwyO8pc(read);
        if (str2 != null && (measurementBackend2 = getMeasurementBackend()) != null) {
            measurementBackend2.end(str2);
        }
        return invoke;
    }

    public static Object measure$default(Object obj, String tag, String str, Function0 body, int r4, Object obj2) {
        MeasurementBackend measurementBackend2;
        String str2 = null;
        if ((r4 & 2) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(body, "body");
        MeasurementBackend measurementBackend3 = getMeasurementBackend();
        if (measurementBackend3 != null) {
            str2 = measurementBackend3.begin(tag, str);
        }
        long read = MonotonicTimeSource.read();
        Object invoke = body.invoke();
        TimeSource.Monotonic.ValueTimeMark.m1693elapsedNowUwyO8pc(read);
        if (str2 != null && (measurementBackend2 = getMeasurementBackend()) != null) {
            measurementBackend2.end(str2);
        }
        return invoke;
    }

    public static final void prepareMeasurement(MeasurementBackend measurement) {
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        measurementBackend = measurement;
    }
}
