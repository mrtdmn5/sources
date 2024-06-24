package com.amazonaws;

import com.amazonaws.auth.RegionAwareSigner;
import com.amazonaws.auth.Signer;
import com.amazonaws.auth.SignerFactory;
import com.amazonaws.handlers.RequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.http.AmazonHttpClient;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.Classes;
import com.amazonaws.util.StringUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class AmazonWebServiceClient {
    private static final String AMAZON = "Amazon";
    private static final String AWS = "AWS";
    private static final Log LOG = LogFactory.getLog((Class<?>) AmazonWebServiceClient.class);
    public static final boolean LOGGING_AWS_REQUEST_METRIC = true;
    protected AmazonHttpClient client;
    protected ClientConfiguration clientConfiguration;
    protected volatile URI endpoint;
    protected volatile String endpointPrefix;
    private volatile Region region;
    protected final List<RequestHandler2> requestHandler2s;
    private volatile String serviceName;
    private volatile Signer signer;
    private volatile String signerRegionOverride;
    protected long timeOffset;

    public AmazonWebServiceClient(ClientConfiguration clientConfiguration) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    private String computeServiceName() {
        int r2;
        String simpleName = Classes.childClassOf(AmazonWebServiceClient.class, this).getSimpleName();
        String serviceName = ServiceNameFactory.getServiceName(simpleName);
        if (serviceName != null) {
            return serviceName;
        }
        int indexOf = simpleName.indexOf("JavaClient");
        if (indexOf == -1 && (indexOf = simpleName.indexOf("Client")) == -1) {
            throw new IllegalStateException("Unrecognized suffix for the AWS http client class name ".concat(simpleName));
        }
        int indexOf2 = simpleName.indexOf(AMAZON);
        if (indexOf2 == -1) {
            indexOf2 = simpleName.indexOf(AWS);
            if (indexOf2 != -1) {
                r2 = 3;
            } else {
                throw new IllegalStateException("Unrecognized prefix for the AWS http client class name ".concat(simpleName));
            }
        } else {
            r2 = 6;
        }
        if (indexOf2 < indexOf) {
            return StringUtils.lowerCase(simpleName.substring(indexOf2 + r2, indexOf));
        }
        throw new IllegalStateException("Unrecognized AWS http client class name ".concat(simpleName));
    }

    private Signer computeSignerByServiceRegion(String str, String str2, String str3, boolean z) {
        Signer signerByTypeAndService;
        String signerOverride = this.clientConfiguration.getSignerOverride();
        if (signerOverride == null) {
            signerByTypeAndService = SignerFactory.getSigner(str, str2);
        } else {
            signerByTypeAndService = SignerFactory.getSignerByTypeAndService(signerOverride, str);
        }
        if (signerByTypeAndService instanceof RegionAwareSigner) {
            RegionAwareSigner regionAwareSigner = (RegionAwareSigner) signerByTypeAndService;
            if (str3 != null) {
                regionAwareSigner.setRegionName(str3);
            } else if (str2 != null && z) {
                regionAwareSigner.setRegionName(str2);
            }
        }
        synchronized (this) {
            this.region = Region.getRegion(str2);
        }
        return signerByTypeAndService;
    }

    private Signer computeSignerByURI(URI r2, String str, boolean z) {
        if (r2 != null) {
            String serviceNameIntern = getServiceNameIntern();
            return computeSignerByServiceRegion(serviceNameIntern, AwsHostNameUtils.parseRegionName(r2.getHost(), serviceNameIntern), str, z);
        }
        throw new IllegalArgumentException("Endpoint is not set. Use setEndpoint to set an endpoint before performing any request.");
    }

    @Deprecated
    public static boolean isProfilingEnabled() {
        if (System.getProperty(SDKGlobalConfiguration.PROFILING_SYSTEM_PROPERTY) != null) {
            return true;
        }
        return false;
    }

    @Deprecated
    private boolean isRMCEnabledAtClientOrSdkLevel() {
        RequestMetricCollector requestMetricCollector = requestMetricCollector();
        if (requestMetricCollector != null && requestMetricCollector.isEnabled()) {
            return true;
        }
        return false;
    }

    private URI toURI(String str) {
        if (!str.contains("://")) {
            str = this.clientConfiguration.getProtocol().toString() + "://" + str;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Deprecated
    public void addRequestHandler(RequestHandler requestHandler) {
        this.requestHandler2s.add(RequestHandler2.adapt(requestHandler));
    }

    @Deprecated
    public void configSigner(String str, String str2) {
    }

    public ExecutionContext createExecutionContext(AmazonWebServiceRequest amazonWebServiceRequest) {
        return new ExecutionContext(this.requestHandler2s, isRequestMetricsEnabled(amazonWebServiceRequest) || isProfilingEnabled(), this);
    }

    @Deprecated
    public final void endClientExecution(AWSRequestMetrics aWSRequestMetrics, Request<?> request, Response<?> response) {
        endClientExecution(aWSRequestMetrics, request, response, false);
    }

    @Deprecated
    public final RequestMetricCollector findRequestMetricCollector(Request<?> request) {
        RequestMetricCollector requestMetricCollector = request.getOriginalRequest().getRequestMetricCollector();
        if (requestMetricCollector != null) {
            return requestMetricCollector;
        }
        RequestMetricCollector requestMetricsCollector = getRequestMetricsCollector();
        if (requestMetricsCollector == null) {
            return AwsSdkMetrics.getRequestMetricCollector();
        }
        return requestMetricsCollector;
    }

    public String getEndpoint() {
        String str;
        synchronized (this) {
            str = this.endpoint.toString();
        }
        return str;
    }

    public String getEndpointPrefix() {
        return this.endpointPrefix;
    }

    public Regions getRegions() {
        Regions fromName;
        synchronized (this) {
            fromName = Regions.fromName(this.region.getName());
        }
        return fromName;
    }

    @Deprecated
    public RequestMetricCollector getRequestMetricsCollector() {
        return this.client.getRequestMetricCollector();
    }

    @Deprecated
    public String getServiceAbbreviation() {
        return getServiceNameIntern();
    }

    public String getServiceName() {
        return getServiceNameIntern();
    }

    public String getServiceNameIntern() {
        if (this.serviceName == null) {
            synchronized (this) {
                if (this.serviceName == null) {
                    this.serviceName = computeServiceName();
                    return this.serviceName;
                }
            }
        }
        return this.serviceName;
    }

    public Signer getSigner() {
        return this.signer;
    }

    public Signer getSignerByURI(URI r3) {
        return computeSignerByURI(r3, this.signerRegionOverride, true);
    }

    public final String getSignerRegionOverride() {
        return this.signerRegionOverride;
    }

    public long getTimeOffset() {
        return this.timeOffset;
    }

    @Deprecated
    public final boolean isRequestMetricsEnabled(AmazonWebServiceRequest amazonWebServiceRequest) {
        RequestMetricCollector requestMetricCollector = amazonWebServiceRequest.getRequestMetricCollector();
        if (requestMetricCollector != null && requestMetricCollector.isEnabled()) {
            return true;
        }
        return isRMCEnabledAtClientOrSdkLevel();
    }

    @Deprecated
    public void removeRequestHandler(RequestHandler requestHandler) {
        this.requestHandler2s.remove(RequestHandler2.adapt(requestHandler));
    }

    @Deprecated
    public RequestMetricCollector requestMetricCollector() {
        RequestMetricCollector requestMetricCollector = this.client.getRequestMetricCollector();
        if (requestMetricCollector == null) {
            return AwsSdkMetrics.getRequestMetricCollector();
        }
        return requestMetricCollector;
    }

    @Deprecated
    public void setConfiguration(ClientConfiguration clientConfiguration) {
        RequestMetricCollector requestMetricCollector;
        AmazonHttpClient amazonHttpClient = this.client;
        if (amazonHttpClient != null) {
            requestMetricCollector = amazonHttpClient.getRequestMetricCollector();
            amazonHttpClient.shutdown();
        } else {
            requestMetricCollector = null;
        }
        this.clientConfiguration = clientConfiguration;
        this.client = new AmazonHttpClient(clientConfiguration, requestMetricCollector);
    }

    public void setEndpoint(String str) {
        URI r3 = toURI(str);
        Signer computeSignerByURI = computeSignerByURI(r3, this.signerRegionOverride, false);
        synchronized (this) {
            this.endpoint = r3;
            this.signer = computeSignerByURI;
        }
    }

    public void setRegion(Region region) {
        String format;
        if (region != null) {
            String serviceNameIntern = getServiceNameIntern();
            if (region.isServiceSupported(serviceNameIntern)) {
                format = region.getServiceEndpoint(serviceNameIntern);
                int indexOf = format.indexOf("://");
                if (indexOf >= 0) {
                    format = format.substring(indexOf + 3);
                }
            } else {
                format = String.format("%s.%s.%s", getEndpointPrefix(), region.getName(), region.getDomain());
            }
            URI r1 = toURI(format);
            Signer computeSignerByServiceRegion = computeSignerByServiceRegion(serviceNameIntern, region.getName(), this.signerRegionOverride, false);
            synchronized (this) {
                this.endpoint = r1;
                this.signer = computeSignerByServiceRegion;
            }
            return;
        }
        throw new IllegalArgumentException("No region provided");
    }

    public final void setServiceNameIntern(String str) {
        this.serviceName = str;
    }

    public final void setSignerRegionOverride(String str) {
        Signer computeSignerByURI = computeSignerByURI(this.endpoint, str, true);
        synchronized (this) {
            this.signer = computeSignerByURI;
            this.signerRegionOverride = str;
        }
    }

    public void setTimeOffset(int r3) {
        this.timeOffset = r3;
    }

    public void shutdown() {
        this.client.shutdown();
    }

    public AmazonWebServiceClient withTimeOffset(int r1) {
        setTimeOffset(r1);
        return this;
    }

    @Deprecated
    public AmazonWebServiceClient(ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration), null);
    }

    public void addRequestHandler(RequestHandler2 requestHandler2) {
        this.requestHandler2s.add(requestHandler2);
    }

    @Deprecated
    public void configSigner(URI r1) {
    }

    @Deprecated
    public final void endClientExecution(AWSRequestMetrics aWSRequestMetrics, Request<?> request, Response<?> response, boolean z) {
        if (request != null) {
            aWSRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            aWSRequestMetrics.getTimingInfo().endTiming();
            findRequestMetricCollector(request).collectMetrics(request, response);
        }
        if (z) {
            aWSRequestMetrics.log();
        }
    }

    public void removeRequestHandler(RequestHandler2 requestHandler2) {
        this.requestHandler2s.remove(requestHandler2);
    }

    public AmazonWebServiceClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.clientConfiguration = clientConfiguration;
        this.client = new AmazonHttpClient(clientConfiguration, httpClient);
        this.requestHandler2s = new CopyOnWriteArrayList();
    }

    public final ExecutionContext createExecutionContext(Request<?> request) {
        return createExecutionContext(request.getOriginalRequest());
    }

    @Deprecated
    public final ExecutionContext createExecutionContext() {
        return new ExecutionContext(this.requestHandler2s, isRMCEnabledAtClientOrSdkLevel() || isProfilingEnabled(), this);
    }

    @Deprecated
    public AmazonWebServiceClient(ClientConfiguration clientConfiguration, HttpClient httpClient, RequestMetricCollector requestMetricCollector) {
        this.clientConfiguration = clientConfiguration;
        this.client = new AmazonHttpClient(clientConfiguration, httpClient, requestMetricCollector);
        this.requestHandler2s = new CopyOnWriteArrayList();
    }

    @Deprecated
    public void setEndpoint(String str, String str2, String str3) {
        URI r2 = toURI(str);
        Signer computeSignerByServiceRegion = computeSignerByServiceRegion(str2, str3, str3, true);
        synchronized (this) {
            this.signer = computeSignerByServiceRegion;
            this.endpoint = r2;
            this.signerRegionOverride = str3;
        }
    }
}
