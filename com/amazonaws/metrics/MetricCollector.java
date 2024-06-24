package com.amazonaws.metrics;

/* loaded from: classes.dex */
public abstract class MetricCollector {
    public static final MetricCollector NONE = new MetricCollector() { // from class: com.amazonaws.metrics.MetricCollector.1
        @Override // com.amazonaws.metrics.MetricCollector
        public RequestMetricCollector getRequestMetricCollector() {
            return RequestMetricCollector.NONE;
        }

        @Override // com.amazonaws.metrics.MetricCollector
        public ServiceMetricCollector getServiceMetricCollector() {
            return ServiceMetricCollector.NONE;
        }

        @Override // com.amazonaws.metrics.MetricCollector
        public boolean isEnabled() {
            return false;
        }

        @Override // com.amazonaws.metrics.MetricCollector
        public boolean start() {
            return true;
        }

        @Override // com.amazonaws.metrics.MetricCollector
        public boolean stop() {
            return true;
        }
    };

    /* loaded from: classes.dex */
    public interface Factory {
        MetricCollector getInstance();
    }

    public abstract RequestMetricCollector getRequestMetricCollector();

    public abstract ServiceMetricCollector getServiceMetricCollector();

    public abstract boolean isEnabled();

    public abstract boolean start();

    public abstract boolean stop();
}
