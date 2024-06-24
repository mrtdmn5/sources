package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.TimingInfo;
import com.amazonaws.util.URIBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class AmazonHttpClient {
    private static final String HEADER_SDK_RETRY_INFO = "aws-sdk-retry";
    private static final String HEADER_SDK_TRANSACTION_ID = "aws-sdk-invocation-id";
    private static final String HEADER_USER_AGENT = "User-Agent";
    private static final int HTTP_STATUS_MULTIPLE_CHOICES = 300;
    private static final int HTTP_STATUS_OK = 200;
    private static final int HTTP_STATUS_REQ_TOO_LONG = 413;
    private static final int HTTP_STATUS_SERVICE_UNAVAILABLE = 503;
    private static final int HTTP_STATUS_TEMP_REDIRECT = 307;
    private static final long TIME_MILLISEC = 1000;
    final ClientConfiguration config;
    final HttpClient httpClient;
    private final HttpRequestFactory requestFactory;
    private final RequestMetricCollector requestMetricCollector;
    private static final Log REQUEST_LOG = LogFactory.getLog("com.amazonaws.request");
    static final Log log = LogFactory.getLog((Class<?>) AmazonHttpClient.class);

    public AmazonHttpClient(ClientConfiguration clientConfiguration) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    public static String createUserAgentString(String str, String str2) {
        if (str.contains(str2)) {
            return str;
        }
        return str.trim() + " " + str2.trim();
    }

    private String getServerDateFromException(String str) {
        int indexOf;
        int indexOf2 = str.indexOf("(");
        if (str.contains(" + 15")) {
            indexOf = str.indexOf(" + 15");
        } else {
            indexOf = str.indexOf(" - 15");
        }
        return str.substring(indexOf2 + 1, indexOf);
    }

    private <T extends Throwable> T handleUnexpectedFailure(T t, AWSRequestMetrics aWSRequestMetrics) {
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.Exception;
        aWSRequestMetrics.incrementCounter(field);
        aWSRequestMetrics.addProperty(field, t);
        return t;
    }

    private boolean isRequestSuccessful(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        if (statusCode >= 200 && statusCode < 300) {
            return true;
        }
        return false;
    }

    private static boolean isTemporaryRedirect(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        String str = httpResponse.getHeaders().get(HttpHeader.LOCATION);
        if (statusCode == HTTP_STATUS_TEMP_REDIRECT && str != null && !str.isEmpty()) {
            return true;
        }
        return false;
    }

    private long pauseBeforeNextRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int r5, RetryPolicy retryPolicy) {
        int r52 = (r5 - 1) - 1;
        long delayBeforeNextRetry = retryPolicy.getBackoffStrategy().delayBeforeNextRetry(amazonWebServiceRequest, amazonClientException, r52);
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Retriable error detected, will retry in " + delayBeforeNextRetry + "ms, attempt number: " + r52);
        }
        try {
            Thread.sleep(delayBeforeNextRetry);
            return delayBeforeNextRetry;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AmazonClientException(e.getMessage(), e);
        }
    }

    private boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, InputStream inputStream, AmazonClientException amazonClientException, int r6, RetryPolicy retryPolicy) {
        int r62 = r6 - 1;
        int maxErrorRetry = this.config.getMaxErrorRetry();
        if (maxErrorRetry < 0 || !retryPolicy.isMaxErrorRetryInClientConfigHonored()) {
            maxErrorRetry = retryPolicy.getMaxErrorRetry();
        }
        if (r62 >= maxErrorRetry) {
            return false;
        }
        if (inputStream != null && !inputStream.markSupported()) {
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("Content not repeatable");
            }
            return false;
        }
        return retryPolicy.getRetryCondition().shouldRetry(amazonWebServiceRequest, amazonClientException, r62);
    }

    public void afterError(Request<?> request, Response<?> response, List<RequestHandler2> list, AmazonClientException amazonClientException) {
        Iterator<RequestHandler2> it = list.iterator();
        while (it.hasNext()) {
            it.next().afterError(request, response, amazonClientException);
        }
    }

    public <T> void afterResponse(Request<?> request, List<RequestHandler2> list, Response<T> response, TimingInfo timingInfo) {
        Iterator<RequestHandler2> it = list.iterator();
        while (it.hasNext()) {
            it.next().afterResponse(request, response);
        }
    }

    public <T> Response<T> execute(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponseHandler<AmazonServiceException> httpResponseHandler2, ExecutionContext executionContext) {
        Response<T> response;
        if (request.getHostPrefix() != null) {
            try {
                URI endpoint = request.getEndpoint();
                request.setEndpoint(URIBuilder.builder(endpoint).host(request.getHostPrefix() + endpoint.getHost()).build());
            } catch (URISyntaxException e) {
                Log log2 = log;
                if (log2.isDebugEnabled()) {
                    log2.debug("Failed to prepend host prefix: " + e.getMessage(), e);
                }
            }
        }
        if (executionContext != null) {
            List<RequestHandler2> requestHandler2s = requestHandler2s(request, executionContext);
            AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
            try {
                response = executeHelper(request, httpResponseHandler, httpResponseHandler2, executionContext);
                try {
                    afterResponse(request, requestHandler2s, response, awsRequestMetrics.getTimingInfo().endTiming());
                    return response;
                } catch (AmazonClientException e2) {
                    e = e2;
                    afterError(request, response, requestHandler2s, e);
                    throw e;
                }
            } catch (AmazonClientException e3) {
                e = e3;
                response = null;
            }
        } else {
            throw new AmazonClientException("Internal SDK Error: No execution context parameter specified.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x03be A[Catch: all -> 0x0444, TRY_ENTER, TryCatch #16 {all -> 0x0444, blocks: (B:44:0x03b4, B:47:0x03be, B:48:0x03d4, B:50:0x0417, B:64:0x0443, B:244:0x0365, B:245:0x036a), top: B:43:0x03b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0417 A[Catch: all -> 0x0444, TRY_LEAVE, TryCatch #16 {all -> 0x0444, blocks: (B:44:0x03b4, B:47:0x03be, B:48:0x03d4, B:50:0x0417, B:64:0x0443, B:244:0x0365, B:245:0x036a), top: B:43:0x03b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0443 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v58, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6, types: [long] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> com.amazonaws.Response<T> executeHelper(com.amazonaws.Request<?> r27, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonWebServiceResponse<T>> r28, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonServiceException> r29, com.amazonaws.http.ExecutionContext r30) {
        /*
            Method dump skipped, instructions count: 1120
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.AmazonHttpClient.executeHelper(com.amazonaws.Request, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.ExecutionContext):com.amazonaws.Response");
    }

    public void finalize() throws Throwable {
        shutdown();
        super.finalize();
    }

    public RequestMetricCollector getRequestMetricCollector() {
        return this.requestMetricCollector;
    }

    @Deprecated
    public ResponseMetadata getResponseMetadataForRequest(AmazonWebServiceRequest amazonWebServiceRequest) {
        return null;
    }

    public AmazonServiceException handleErrorResponse(Request<?> request, HttpResponseHandler<AmazonServiceException> httpResponseHandler, HttpResponse httpResponse) throws IOException {
        AmazonServiceException amazonServiceException;
        int statusCode = httpResponse.getStatusCode();
        try {
            amazonServiceException = httpResponseHandler.handle(httpResponse);
            REQUEST_LOG.debug("Received error response: " + amazonServiceException.toString());
        } catch (Exception e) {
            if (statusCode == HTTP_STATUS_REQ_TOO_LONG) {
                amazonServiceException = new AmazonServiceException("Request entity too large");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(HTTP_STATUS_REQ_TOO_LONG);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Client);
                amazonServiceException.setErrorCode("Request entity too large");
            } else if (statusCode == HTTP_STATUS_SERVICE_UNAVAILABLE && "Service Unavailable".equalsIgnoreCase(httpResponse.getStatusText())) {
                amazonServiceException = new AmazonServiceException("Service unavailable");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(HTTP_STATUS_SERVICE_UNAVAILABLE);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Service);
                amazonServiceException.setErrorCode("Service unavailable");
            } else {
                if (e instanceof IOException) {
                    throw ((IOException) e);
                }
                throw new AmazonClientException("Unable to unmarshall error response (" + e.getMessage() + "). Response Code: " + statusCode + ", Response Text: " + httpResponse.getStatusText() + ", Response Headers: " + httpResponse.getHeaders(), e);
            }
        }
        amazonServiceException.setStatusCode(statusCode);
        amazonServiceException.setServiceName(request.getServiceName());
        amazonServiceException.fillInStackTrace();
        return amazonServiceException;
    }

    public <T> T handleResponse(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponse httpResponse, ExecutionContext executionContext) throws IOException {
        try {
            AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
            AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ResponseProcessingTime;
            awsRequestMetrics.startEvent(field);
            try {
                AmazonWebServiceResponse<T> handle = httpResponseHandler.handle(httpResponse);
                awsRequestMetrics.endEvent(field);
                if (handle != null) {
                    Log log2 = REQUEST_LOG;
                    if (log2.isDebugEnabled()) {
                        log2.debug("Received successful response: " + httpResponse.getStatusCode() + ", AWS Request ID: " + handle.getRequestId());
                    }
                    awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, handle.getRequestId());
                    return handle.getResult();
                }
                throw new RuntimeException("Unable to unmarshall response metadata. Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText());
            } catch (Throwable th) {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
                throw th;
            }
        } catch (CRC32MismatchException e) {
            throw e;
        } catch (IOException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new AmazonClientException("Unable to unmarshall response (" + e3.getMessage() + "). Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText(), e3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    public long parseClockSkewOffset(HttpResponse httpResponse, AmazonServiceException amazonServiceException) {
        Date parseRFC822Date;
        Date date = new Date();
        String str = httpResponse.getHeaders().get("Date");
        try {
            if (str != 0) {
                try {
                    if (!str.isEmpty()) {
                        parseRFC822Date = DateUtils.parseRFC822Date(str);
                        long time = date.getTime() - parseRFC822Date.getTime();
                        str = 1000;
                        return time / TIME_MILLISEC;
                    }
                } catch (RuntimeException e) {
                    e = e;
                    str = 0;
                    log.warn("Unable to parse clock skew offset from response: " + str, e);
                    return 0L;
                }
            }
            parseRFC822Date = DateUtils.parseCompressedISO8601Date(getServerDateFromException(amazonServiceException.getMessage()));
            long time2 = date.getTime() - parseRFC822Date.getTime();
            str = 1000;
            return time2 / TIME_MILLISEC;
        } catch (RuntimeException e2) {
            e = e2;
        }
    }

    public List<RequestHandler2> requestHandler2s(Request<?> request, ExecutionContext executionContext) {
        List<RequestHandler2> requestHandler2s = executionContext.getRequestHandler2s();
        if (requestHandler2s == null) {
            return Collections.emptyList();
        }
        for (RequestHandler2 requestHandler2 : requestHandler2s) {
            if (requestHandler2 instanceof CredentialsRequestHandler) {
                ((CredentialsRequestHandler) requestHandler2).setCredentials(executionContext.getCredentials());
            }
            requestHandler2.beforeRequest(request);
        }
        return requestHandler2s;
    }

    public void resetRequestAfterError(Request<?> request, Exception exc) {
        if (request.getContent() == null) {
            return;
        }
        if (request.getContent().markSupported()) {
            try {
                request.getContent().reset();
                return;
            } catch (IOException unused) {
                throw new AmazonClientException("Encountered an exception and couldn't reset the stream to retry", exc);
            }
        }
        throw new AmazonClientException("Encountered an exception and stream is not resettable", exc);
    }

    public void setUserAgent(Request<?> request) {
        String str;
        RequestClientOptions requestClientOptions;
        String clientMarker;
        String str2 = ClientConfiguration.DEFAULT_USER_AGENT;
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (originalRequest != null && (requestClientOptions = originalRequest.getRequestClientOptions()) != null && (clientMarker = requestClientOptions.getClientMarker(RequestClientOptions.Marker.USER_AGENT)) != null) {
            str = createUserAgentString(str2, clientMarker);
        } else {
            str = str2;
        }
        if (!str2.equals(this.config.getUserAgent())) {
            str = createUserAgentString(str, this.config.getUserAgent());
        }
        if (this.config.getUserAgentOverride() != null) {
            str = this.config.getUserAgentOverride();
        }
        request.addHeader("User-Agent", str);
    }

    public void shutdown() {
        this.httpClient.shutdown();
    }

    @Deprecated
    public AmazonHttpClient(ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration), requestMetricCollector);
    }

    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.requestFactory = new HttpRequestFactory();
        this.config = clientConfiguration;
        this.httpClient = httpClient;
        this.requestMetricCollector = null;
    }

    @Deprecated
    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient, RequestMetricCollector requestMetricCollector) {
        this.requestFactory = new HttpRequestFactory();
        this.config = clientConfiguration;
        this.httpClient = httpClient;
        this.requestMetricCollector = requestMetricCollector;
    }
}
