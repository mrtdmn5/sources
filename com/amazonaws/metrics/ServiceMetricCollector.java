package com.amazonaws.metrics;

/* loaded from: classes.dex */
public abstract class ServiceMetricCollector {
    public static final ServiceMetricCollector NONE = new ServiceMetricCollector() { // from class: com.amazonaws.metrics.ServiceMetricCollector.1
        @Override // com.amazonaws.metrics.ServiceMetricCollector
        public boolean isEnabled() {
            return false;
        }

        @Override // com.amazonaws.metrics.ServiceMetricCollector
        public void collectByteThroughput(ByteThroughputProvider byteThroughputProvider) {
        }

        @Override // com.amazonaws.metrics.ServiceMetricCollector
        public void collectLatency(ServiceLatencyProvider serviceLatencyProvider) {
        }
    };

    /* loaded from: classes.dex */
    public interface Factory {
        ServiceMetricCollector getServiceMetricCollector();
    }

    public abstract void collectByteThroughput(ByteThroughputProvider byteThroughputProvider);

    public abstract void collectLatency(ServiceLatencyProvider serviceLatencyProvider);

    public boolean isEnabled() {
        return true;
    }
}
