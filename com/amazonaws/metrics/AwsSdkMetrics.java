package com.amazonaws.metrics;

import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.MetricCollector;
import com.amazonaws.regions.Regions;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSServiceMetrics;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public enum AwsSdkMetrics {
    ;

    public static final String AWS_CREDENTAIL_PROPERTIES_FILE = "credentialFile";
    public static final String CLOUDWATCH_REGION = "cloudwatchRegion";
    private static final boolean DEFAULT_METRICS_ENABLED;
    private static final String DEFAULT_METRIC_COLLECTOR_FACTORY = "com.amazonaws.metrics.internal.cloudwatch.DefaultMetricCollectorFactory";
    public static final String DEFAULT_METRIC_NAMESPACE = "AWSSDK/Java";
    public static final String EXCLUDE_MACHINE_METRICS = "excludeMachineMetrics";
    public static final String HOST_METRIC_NAME = "hostMetricName";
    public static final String INCLUDE_PER_HOST_METRICS = "includePerHostMetrics";
    public static final String JVM_METRIC_NAME = "jvmMetricName";
    private static final String MBEAN_OBJECT_NAME = "com.amazonaws.management:type=AwsSdkMetrics";
    public static final String METRIC_NAME_SPACE = "metricNameSpace";
    public static final String METRIC_QUEUE_SIZE = "metricQueueSize";
    public static final String QUEUE_POLL_TIMEOUT_MILLI = "getQueuePollTimeoutMilli";
    private static final int QUEUE_POLL_TIMEOUT_MILLI_MINUMUM = 1000;
    private static final MetricRegistry REGISTRY;
    public static final String USE_SINGLE_METRIC_NAMESPACE = "useSingleMetricNamespace";
    private static volatile String credentialFile = null;
    private static volatile AWSCredentialsProvider credentialProvider = null;
    private static boolean dirtyEnabling = false;
    private static volatile String hostMetricName = null;
    private static volatile String jvmMetricName = null;
    private static volatile boolean machineMetricsExcluded = false;
    private static volatile MetricCollector mc = null;
    private static volatile String metricNameSpace = "AWSSDK/Java";
    private static volatile Integer metricQueueSize;
    private static volatile boolean perHostMetricsIncluded;
    private static volatile Long queuePollTimeoutMilli;
    private static volatile Regions region;
    private static volatile boolean singleMetricNamespace;

    /* loaded from: classes.dex */
    public static class MetricRegistry {
        private final Set<MetricType> metricTypes;
        private volatile Set<MetricType> readOnly;

        public MetricRegistry() {
            HashSet hashSet = new HashSet();
            this.metricTypes = hashSet;
            hashSet.add(AWSRequestMetrics.Field.ClientExecuteTime);
            hashSet.add(AWSRequestMetrics.Field.Exception);
            hashSet.add(AWSRequestMetrics.Field.HttpClientRetryCount);
            hashSet.add(AWSRequestMetrics.Field.HttpRequestTime);
            hashSet.add(AWSRequestMetrics.Field.RequestCount);
            hashSet.add(AWSRequestMetrics.Field.RetryCount);
            hashSet.add(AWSRequestMetrics.Field.HttpClientSendRequestTime);
            hashSet.add(AWSRequestMetrics.Field.HttpClientReceiveResponseTime);
            hashSet.add(AWSServiceMetrics.HttpClientGetConnectionTime);
            syncReadOnly();
        }

        private void syncReadOnly() {
            this.readOnly = Collections.unmodifiableSet(new HashSet(this.metricTypes));
        }

        public boolean addMetricType(MetricType metricType) {
            boolean add;
            synchronized (this.metricTypes) {
                add = this.metricTypes.add(metricType);
                if (add) {
                    syncReadOnly();
                }
            }
            return add;
        }

        public <T extends MetricType> boolean addMetricTypes(Collection<T> collection) {
            boolean addAll;
            synchronized (this.metricTypes) {
                addAll = this.metricTypes.addAll(collection);
                if (addAll) {
                    syncReadOnly();
                }
            }
            return addAll;
        }

        public Set<MetricType> predefinedMetrics() {
            return this.readOnly;
        }

        public boolean removeMetricType(MetricType metricType) {
            boolean remove;
            synchronized (this.metricTypes) {
                remove = this.metricTypes.remove(metricType);
                if (remove) {
                    syncReadOnly();
                }
            }
            return remove;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0009, code lost:            if (r3.size() == 0) goto L29;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public <T extends com.amazonaws.metrics.MetricType> void setMetricTypes(java.util.Collection<T> r3) {
            /*
                r2 = this;
                java.util.Set<com.amazonaws.metrics.MetricType> r0 = r2.metricTypes
                monitor-enter(r0)
                if (r3 == 0) goto Lb
                int r1 = r3.size()     // Catch: java.lang.Throwable -> L2b
                if (r1 != 0) goto L1b
            Lb:
                java.util.Set<com.amazonaws.metrics.MetricType> r1 = r2.metricTypes     // Catch: java.lang.Throwable -> L2b
                int r1 = r1.size()     // Catch: java.lang.Throwable -> L2b
                if (r1 != 0) goto L15
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
                return
            L15:
                if (r3 != 0) goto L1b
                java.util.List r3 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> L2b
            L1b:
                java.util.Set<com.amazonaws.metrics.MetricType> r1 = r2.metricTypes     // Catch: java.lang.Throwable -> L2b
                r1.clear()     // Catch: java.lang.Throwable -> L2b
                boolean r3 = r2.addMetricTypes(r3)     // Catch: java.lang.Throwable -> L2b
                if (r3 != 0) goto L29
                r2.syncReadOnly()     // Catch: java.lang.Throwable -> L2b
            L29:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
                return
            L2b:
                r3 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.metrics.AwsSdkMetrics.MetricRegistry.setMetricTypes(java.util.Collection):void");
        }
    }

    static {
        boolean z;
        String property = System.getProperty(SDKGlobalConfiguration.DEFAULT_METRICS_SYSTEM_PROPERTY);
        if (property != null) {
            z = true;
        } else {
            z = false;
        }
        DEFAULT_METRICS_ENABLED = z;
        if (z) {
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            for (String str : property.split(",")) {
                String trim = str.trim();
                if (!z2 && EXCLUDE_MACHINE_METRICS.equals(trim)) {
                    z2 = true;
                } else if (!z3 && INCLUDE_PER_HOST_METRICS.equals(trim)) {
                    z3 = true;
                } else if (!z4 && USE_SINGLE_METRIC_NAMESPACE.equals(trim)) {
                    z4 = true;
                } else {
                    String[] split = trim.split("=");
                    if (split.length == 2) {
                        String trim2 = split[0].trim();
                        String trim3 = split[1].trim();
                        try {
                            if (AWS_CREDENTAIL_PROPERTIES_FILE.equals(trim2)) {
                                setCredentialFile0(trim3);
                            } else if (CLOUDWATCH_REGION.equals(trim2)) {
                                region = Regions.fromName(trim3);
                            } else if (METRIC_QUEUE_SIZE.equals(trim2)) {
                                Integer num = new Integer(trim3);
                                if (num.intValue() >= 1) {
                                    metricQueueSize = num;
                                } else {
                                    throw new IllegalArgumentException("metricQueueSize must be at least 1");
                                }
                            } else if (QUEUE_POLL_TIMEOUT_MILLI.equals(trim2)) {
                                Long l = new Long(trim3);
                                if (l.intValue() >= QUEUE_POLL_TIMEOUT_MILLI_MINUMUM) {
                                    queuePollTimeoutMilli = l;
                                } else {
                                    throw new IllegalArgumentException("getQueuePollTimeoutMilli must be at least 1000");
                                }
                            } else if (METRIC_NAME_SPACE.equals(trim2)) {
                                metricNameSpace = trim3;
                            } else if (JVM_METRIC_NAME.equals(trim2)) {
                                jvmMetricName = trim3;
                            } else if (HOST_METRIC_NAME.equals(trim2)) {
                                hostMetricName = trim3;
                            } else {
                                LogFactory.getLog((Class<?>) AwsSdkMetrics.class).debug("Ignoring unrecognized parameter: " + trim);
                            }
                        } catch (Exception e) {
                            LogFactory.getLog((Class<?>) AwsSdkMetrics.class).debug("Ignoring failure", e);
                        }
                    } else {
                        continue;
                    }
                }
            }
            machineMetricsExcluded = z2;
            perHostMetricsIncluded = z3;
            singleMetricNamespace = z4;
        }
        REGISTRY = new MetricRegistry();
    }

    public static boolean add(MetricType metricType) {
        if (metricType == null) {
            return false;
        }
        return REGISTRY.addMetricType(metricType);
    }

    public static <T extends MetricType> boolean addAll(Collection<T> collection) {
        if (collection != null && collection.size() != 0) {
            return REGISTRY.addMetricTypes(collection);
        }
        return false;
    }

    public static void disableMetrics() {
        setMetricCollector(MetricCollector.NONE);
    }

    public static synchronized boolean enableDefaultMetrics() {
        synchronized (AwsSdkMetrics.class) {
            if (mc == null || !mc.isEnabled()) {
                if (!dirtyEnabling) {
                    dirtyEnabling = true;
                    try {
                        try {
                            MetricCollector factory = ((MetricCollector.Factory) Class.forName(DEFAULT_METRIC_COLLECTOR_FACTORY).newInstance()).getInstance();
                            if (factory != null) {
                                setMetricCollector(factory);
                                return true;
                            }
                        } catch (Exception e) {
                            LogFactory.getLog((Class<?>) AwsSdkMetrics.class).warn("Failed to enable the default metrics", e);
                        }
                    } finally {
                        dirtyEnabling = false;
                    }
                } else {
                    throw new IllegalStateException("Reentrancy is not allowed");
                }
            }
            return false;
        }
    }

    public static String getCredentailFile() {
        return credentialFile;
    }

    public static AWSCredentialsProvider getCredentialProvider() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getClassName().equals(DEFAULT_METRIC_COLLECTOR_FACTORY)) {
                return credentialProvider;
            }
        }
        SecurityException securityException = new SecurityException();
        LogFactory.getLog((Class<?>) AwsSdkMetrics.class).warn("Illegal attempt to access the credential provider", securityException);
        throw securityException;
    }

    public static String getHostMetricName() {
        return hostMetricName;
    }

    public static MetricCollector getInternalMetricCollector() {
        return mc;
    }

    public static String getJvmMetricName() {
        return jvmMetricName;
    }

    public static <T extends MetricCollector> T getMetricCollector() {
        if (mc == null && isDefaultMetricsEnabled()) {
            enableDefaultMetrics();
        }
        if (mc == null) {
            return (T) MetricCollector.NONE;
        }
        return (T) mc;
    }

    public static String getMetricNameSpace() {
        return metricNameSpace;
    }

    public static Integer getMetricQueueSize() {
        return metricQueueSize;
    }

    public static Set<MetricType> getPredefinedMetrics() {
        return REGISTRY.predefinedMetrics();
    }

    public static Long getQueuePollTimeoutMilli() {
        return queuePollTimeoutMilli;
    }

    public static Regions getRegion() {
        return region;
    }

    public static <T extends RequestMetricCollector> T getRequestMetricCollector() {
        if (mc == null && isDefaultMetricsEnabled()) {
            enableDefaultMetrics();
        }
        if (mc == null) {
            return (T) RequestMetricCollector.NONE;
        }
        return (T) mc.getRequestMetricCollector();
    }

    public static <T extends ServiceMetricCollector> T getServiceMetricCollector() {
        if (mc == null && isDefaultMetricsEnabled()) {
            enableDefaultMetrics();
        }
        if (mc == null) {
            return (T) ServiceMetricCollector.NONE;
        }
        return (T) mc.getServiceMetricCollector();
    }

    public static boolean isDefaultMetricsEnabled() {
        return DEFAULT_METRICS_ENABLED;
    }

    public static boolean isMachineMetricExcluded() {
        return machineMetricsExcluded;
    }

    public static boolean isMetricsEnabled() {
        MetricCollector metricCollector = mc;
        if (metricCollector != null && metricCollector.isEnabled()) {
            return true;
        }
        return false;
    }

    public static boolean isPerHostMetricEnabled() {
        String trim;
        if (perHostMetricsIncluded) {
            return true;
        }
        String str = hostMetricName;
        if (str == null) {
            trim = "";
        } else {
            trim = str.trim();
        }
        if (trim.length() > 0) {
            return true;
        }
        return false;
    }

    public static boolean isPerHostMetricIncluded() {
        return perHostMetricsIncluded;
    }

    public static boolean isSingleMetricNamespace() {
        return singleMetricNamespace;
    }

    public static boolean remove(MetricType metricType) {
        if (metricType == null) {
            return false;
        }
        return REGISTRY.removeMetricType(metricType);
    }

    public static <T extends MetricType> void set(Collection<T> collection) {
        REGISTRY.setMetricTypes(collection);
    }

    public static void setCredentialFile(String str) throws IOException {
        setCredentialFile0(str);
    }

    private static void setCredentialFile0(String str) throws IOException {
        PropertiesCredentials propertiesCredentials = new PropertiesCredentials(new File(str));
        synchronized (AwsSdkMetrics.class) {
            credentialProvider = new AWSCredentialsProvider() { // from class: com.amazonaws.metrics.AwsSdkMetrics.1
                public AnonymousClass1() {
                }

                @Override // com.amazonaws.auth.AWSCredentialsProvider
                public AWSCredentials getCredentials() {
                    return PropertiesCredentials.this;
                }

                @Override // com.amazonaws.auth.AWSCredentialsProvider
                public void refresh() {
                }
            };
            credentialFile = str;
        }
    }

    public static synchronized void setCredentialProvider(AWSCredentialsProvider aWSCredentialsProvider) {
        synchronized (AwsSdkMetrics.class) {
            credentialProvider = aWSCredentialsProvider;
        }
    }

    public static void setHostMetricName(String str) {
        hostMetricName = str;
    }

    public static void setJvmMetricName(String str) {
        jvmMetricName = str;
    }

    public static void setMachineMetricsExcluded(boolean z) {
        machineMetricsExcluded = z;
    }

    public static synchronized void setMetricCollector(MetricCollector metricCollector) {
        synchronized (AwsSdkMetrics.class) {
            MetricCollector metricCollector2 = mc;
            mc = metricCollector;
            if (metricCollector2 != null) {
                metricCollector2.stop();
            }
        }
    }

    public static void setMetricNameSpace(String str) {
        if (str != null && str.trim().length() != 0) {
            metricNameSpace = str;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void setMetricQueueSize(Integer num) {
        metricQueueSize = num;
    }

    public static void setPerHostMetricsIncluded(boolean z) {
        perHostMetricsIncluded = z;
    }

    public static void setQueuePollTimeoutMilli(Long l) {
        queuePollTimeoutMilli = l;
    }

    public static void setRegion(Regions regions) {
        region = regions;
    }

    public static void setSingleMetricNamespace(boolean z) {
        singleMetricNamespace = z;
    }

    /* renamed from: com.amazonaws.metrics.AwsSdkMetrics$1 */
    /* loaded from: classes.dex */
    public static class AnonymousClass1 implements AWSCredentialsProvider {
        public AnonymousClass1() {
        }

        @Override // com.amazonaws.auth.AWSCredentialsProvider
        public AWSCredentials getCredentials() {
            return PropertiesCredentials.this;
        }

        @Override // com.amazonaws.auth.AWSCredentialsProvider
        public void refresh() {
        }
    }
}
