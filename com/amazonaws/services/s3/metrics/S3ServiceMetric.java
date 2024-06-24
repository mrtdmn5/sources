package com.amazonaws.services.s3.metrics;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.amazonaws.metrics.ServiceMetricType;
import com.amazonaws.metrics.SimpleMetricType;
import com.amazonaws.metrics.ThroughputMetricType;
import com.amazonaws.services.s3.internal.Constants;

/* loaded from: classes.dex */
public class S3ServiceMetric extends SimpleMetricType implements ServiceMetricType {
    public static final S3ThroughputMetric S3_DOWLOAD_THROUGHPUT;
    public static final S3ServiceMetric S3_DOWNLOAD_BYTE_COUNT;
    public static final S3ServiceMetric S3_UPLOAD_BYTE_COUNT;
    public static final S3ThroughputMetric S3_UPLOAD_THROUGHPUT;
    static final String SERVICE_NAME_PREFIX = "S3";
    private static final S3ServiceMetric[] VALUES;
    private final String name;

    /* loaded from: classes.dex */
    public static abstract class S3ThroughputMetric extends S3ServiceMetric implements ThroughputMetricType {
        private S3ThroughputMetric(String str) {
            super(str);
        }
    }

    static {
        S3ThroughputMetric s3ThroughputMetric = new S3ThroughputMetric(metricName(ServiceMetricType.DOWNLOAD_THROUGHPUT_NAME_SUFFIX)) { // from class: com.amazonaws.services.s3.metrics.S3ServiceMetric.1
            @Override // com.amazonaws.metrics.ThroughputMetricType
            public ServiceMetricType getByteCountMetricType() {
                return S3ServiceMetric.S3_DOWNLOAD_BYTE_COUNT;
            }
        };
        S3_DOWLOAD_THROUGHPUT = s3ThroughputMetric;
        S3ServiceMetric s3ServiceMetric = new S3ServiceMetric(metricName(ServiceMetricType.DOWNLOAD_BYTE_COUNT_NAME_SUFFIX));
        S3_DOWNLOAD_BYTE_COUNT = s3ServiceMetric;
        S3ThroughputMetric s3ThroughputMetric2 = new S3ThroughputMetric(metricName(ServiceMetricType.UPLOAD_THROUGHPUT_NAME_SUFFIX)) { // from class: com.amazonaws.services.s3.metrics.S3ServiceMetric.2
            @Override // com.amazonaws.metrics.ThroughputMetricType
            public ServiceMetricType getByteCountMetricType() {
                return S3ServiceMetric.S3_UPLOAD_BYTE_COUNT;
            }
        };
        S3_UPLOAD_THROUGHPUT = s3ThroughputMetric2;
        S3ServiceMetric s3ServiceMetric2 = new S3ServiceMetric(metricName(ServiceMetricType.UPLOAD_BYTE_COUNT_NAME_SUFFIX));
        S3_UPLOAD_BYTE_COUNT = s3ServiceMetric2;
        VALUES = new S3ServiceMetric[]{s3ThroughputMetric, s3ServiceMetric, s3ThroughputMetric2, s3ServiceMetric2};
    }

    private static final String metricName(String str) {
        return ConstraintSet$$ExternalSyntheticOutline0.m(SERVICE_NAME_PREFIX, str);
    }

    public static S3ServiceMetric valueOf(String str) {
        for (S3ServiceMetric s3ServiceMetric : values()) {
            if (s3ServiceMetric.name().equals(str)) {
                return s3ServiceMetric;
            }
        }
        throw new IllegalArgumentException(ConstraintSet$$ExternalSyntheticOutline0.m("No S3ServiceMetric defined for the name ", str));
    }

    public static S3ServiceMetric[] values() {
        return (S3ServiceMetric[]) VALUES.clone();
    }

    @Override // com.amazonaws.metrics.ServiceMetricType
    public String getServiceName() {
        return Constants.S3_SERVICE_DISPLAY_NAME;
    }

    @Override // com.amazonaws.metrics.SimpleMetricType, com.amazonaws.metrics.MetricType
    public String name() {
        return this.name;
    }

    private S3ServiceMetric(String str) {
        this.name = str;
    }
}
