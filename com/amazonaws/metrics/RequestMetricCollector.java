package com.amazonaws.metrics;

import com.amazonaws.Request;
import com.amazonaws.Response;

/* loaded from: classes.dex */
public abstract class RequestMetricCollector {
    public static final RequestMetricCollector NONE = new RequestMetricCollector() { // from class: com.amazonaws.metrics.RequestMetricCollector.1
        @Override // com.amazonaws.metrics.RequestMetricCollector
        public boolean isEnabled() {
            return false;
        }

        @Override // com.amazonaws.metrics.RequestMetricCollector
        public void collectMetrics(Request<?> request, Response<?> response) {
        }
    };

    /* loaded from: classes.dex */
    public interface Factory {
        RequestMetricCollector getRequestMetricCollector();
    }

    public abstract void collectMetrics(Request<?> request, Response<?> response);

    public boolean isEnabled() {
        return true;
    }
}
