package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.Signer;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetricsFullSupport;
import java.net.URI;
import java.util.List;

/* loaded from: classes.dex */
public class ExecutionContext {
    private final AmazonWebServiceClient awsClient;
    private final AWSRequestMetrics awsRequestMetrics;
    private String contextUserAgent;
    private AWSCredentials credentials;
    private final List<RequestHandler2> requestHandler2s;

    @Deprecated
    public ExecutionContext(boolean z) {
        this(null, z, null);
    }

    @Deprecated
    public AWSRequestMetrics getAwsRequestMetrics() {
        return this.awsRequestMetrics;
    }

    public String getContextUserAgent() {
        return this.contextUserAgent;
    }

    public AWSCredentials getCredentials() {
        return this.credentials;
    }

    public List<RequestHandler2> getRequestHandler2s() {
        return this.requestHandler2s;
    }

    public Signer getSignerByURI(URI r2) {
        AmazonWebServiceClient amazonWebServiceClient = this.awsClient;
        if (amazonWebServiceClient == null) {
            return null;
        }
        return amazonWebServiceClient.getSignerByURI(r2);
    }

    public void setContextUserAgent(String str) {
        this.contextUserAgent = str;
    }

    public void setCredentials(AWSCredentials aWSCredentials) {
        this.credentials = aWSCredentials;
    }

    public ExecutionContext() {
        this(null, false, null);
    }

    public ExecutionContext(List<RequestHandler2> list, boolean z, AmazonWebServiceClient amazonWebServiceClient) {
        this.requestHandler2s = list;
        this.awsRequestMetrics = z ? new AWSRequestMetricsFullSupport() : new AWSRequestMetrics();
        this.awsClient = amazonWebServiceClient;
    }

    public void setSigner(Signer signer) {
    }
}
