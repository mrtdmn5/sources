package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.MetricType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class AWSRequestMetricsFullSupport extends AWSRequestMetrics {
    private final Map<String, TimingInfo> eventsBeingProfiled;
    private final Map<String, List<Object>> properties;
    private static final Log LATENCY_LOGGER = LogFactory.getLog("com.amazonaws.latency");
    private static final Object KEY_VALUE_SEPARATOR = "=";
    private static final Object COMMA_SEPARATOR = ", ";

    public AWSRequestMetricsFullSupport() {
        super(TimingInfo.startTimingFullSupport());
        this.properties = new HashMap();
        this.eventsBeingProfiled = new HashMap();
    }

    private void keyValueFormat(Object obj, Object obj2, StringBuilder sb) {
        sb.append(obj);
        sb.append(KEY_VALUE_SEPARATOR);
        sb.append(obj2);
        sb.append(COMMA_SEPARATOR);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void addProperty(String str, Object obj) {
        List<Object> list = this.properties.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.properties.put(str, list);
        }
        list.add(obj);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void endEvent(String str) {
        TimingInfo timingInfo = this.eventsBeingProfiled.get(str);
        if (timingInfo == null) {
            LogFactory.getLog(getClass()).warn("Trying to end an event which was never started: " + str);
            return;
        }
        timingInfo.endTiming();
        this.timingInfo.addSubMeasurement(str, TimingInfo.unmodifiableTimingInfo(timingInfo.getStartTimeNano(), Long.valueOf(timingInfo.getEndTimeNano())));
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public List<Object> getProperty(String str) {
        return this.properties.get(str);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void incrementCounter(String str) {
        this.timingInfo.incrementCounter(str);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public final boolean isEnabled() {
        return true;
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void log() {
        if (LATENCY_LOGGER.isInfoEnabled()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, List<Object>> entry : this.properties.entrySet()) {
                keyValueFormat(entry.getKey(), entry.getValue(), sb);
            }
            for (Map.Entry<String, Number> entry2 : this.timingInfo.getAllCounters().entrySet()) {
                keyValueFormat(entry2.getKey(), entry2.getValue(), sb);
            }
            for (Map.Entry<String, List<TimingInfo>> entry3 : this.timingInfo.getSubMeasurementsByName().entrySet()) {
                keyValueFormat(entry3.getKey(), entry3.getValue(), sb);
            }
            LATENCY_LOGGER.info(sb.toString());
        }
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void setCounter(String str, long j) {
        this.timingInfo.setCounter(str, j);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void startEvent(String str) {
        this.eventsBeingProfiled.put(str, TimingInfo.startTimingFullSupport(System.nanoTime()));
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public List<Object> getProperty(MetricType metricType) {
        return getProperty(metricType.name());
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void incrementCounter(MetricType metricType) {
        incrementCounter(metricType.name());
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void setCounter(MetricType metricType, long j) {
        setCounter(metricType.name(), j);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void startEvent(MetricType metricType) {
        startEvent(metricType.name());
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void addProperty(MetricType metricType, Object obj) {
        addProperty(metricType.name(), obj);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void endEvent(MetricType metricType) {
        endEvent(metricType.name());
    }
}
