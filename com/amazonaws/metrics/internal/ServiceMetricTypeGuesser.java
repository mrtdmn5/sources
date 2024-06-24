package com.amazonaws.metrics.internal;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.amazonaws.Request;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.SimpleThroughputMetricType;
import com.amazonaws.metrics.ThroughputMetricType;

/* loaded from: classes.dex */
public enum ServiceMetricTypeGuesser {
    ;

    public static ThroughputMetricType guessThroughputMetricType(Request<?> request, String str, String str2) {
        if (!AwsSdkMetrics.isMetricsEnabled() || !request.getOriginalRequest().getClass().getName().startsWith("com.amazonaws.services.s3")) {
            return null;
        }
        return new SimpleThroughputMetricType(ConstraintSet$$ExternalSyntheticOutline0.m("S3", str), request.getServiceName(), ConstraintSet$$ExternalSyntheticOutline0.m("S3", str2));
    }
}
