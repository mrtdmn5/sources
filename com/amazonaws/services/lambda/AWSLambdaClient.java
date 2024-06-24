package com.amazonaws.services.lambda;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.http.JsonResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.transform.EC2AccessDeniedExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.EC2ThrottledExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.EC2UnexpectedExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.EFSIOExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.EFSMountConnectivityExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.EFSMountFailureExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.EFSMountTimeoutExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.ENILimitReachedExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.InvalidParameterValueExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.InvalidRequestContentExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.InvalidRuntimeExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.InvalidSecurityGroupIDExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.InvalidSubnetIDExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.InvalidZipFileExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.InvokeRequestMarshaller;
import com.amazonaws.services.lambda.model.transform.InvokeResultJsonUnmarshaller;
import com.amazonaws.services.lambda.model.transform.KMSAccessDeniedExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.KMSDisabledExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.KMSInvalidStateExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.KMSNotFoundExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.RequestTooLargeExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.ResourceConflictExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.ResourceNotReadyExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.ServiceExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.SnapStartExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.SnapStartNotReadyExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.SnapStartTimeoutExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.SubnetIPAddressLimitReachedExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.TooManyRequestsExceptionUnmarshaller;
import com.amazonaws.services.lambda.model.transform.UnsupportedMediaTypeExceptionUnmarshaller;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import com.animaconnected.cloud.CloudEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AWSLambdaClient extends AmazonWebServiceClient implements AWSLambda {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    @Deprecated
    public AWSLambdaClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    private void init() {
        ArrayList arrayList = new ArrayList();
        this.jsonErrorUnmarshallers = arrayList;
        arrayList.add(new EC2AccessDeniedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new EC2ThrottledExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new EC2UnexpectedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new EFSIOExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new EFSMountConnectivityExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new EFSMountFailureExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new EFSMountTimeoutExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ENILimitReachedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidParameterValueExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidRequestContentExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidRuntimeExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidSecurityGroupIDExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidSubnetIDExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidZipFileExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new KMSAccessDeniedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new KMSDisabledExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new KMSInvalidStateExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new KMSNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new RequestTooLargeExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceConflictExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceNotReadyExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ServiceExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new SnapStartExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new SnapStartNotReadyExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new SnapStartTimeoutExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new SubnetIPAddressLimitReachedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new TooManyRequestsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UnsupportedMediaTypeExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        setEndpoint("lambda.us-east-1.amazonaws.com");
        this.endpointPrefix = CloudEvent.CLOUD_FEATURE_LAMBDA;
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/lambda/request.handlers"));
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/lambda/request.handler2s"));
    }

    @Override // com.amazonaws.services.lambda.AWSLambda
    @Deprecated
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amazonaws.services.lambda.AWSLambda
    public InvokeResult invoke(InvokeRequest invokeRequest) throws AmazonServiceException, AmazonClientException {
        Response<?> response;
        ExecutionContext createExecutionContext = createExecutionContext(invokeRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        Request<?> request = null;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<InvokeRequest> marshall = new InvokeRequestMarshaller().marshall(invokeRequest);
                    try {
                        marshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response<?> invoke = invoke(marshall, new JsonResponseHandler(new InvokeResultJsonUnmarshaller()), createExecutionContext);
                        InvokeResult invokeResult = (InvokeResult) invoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, marshall, invoke, true);
                        return invokeResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            request = invokeRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, true);
            throw th;
        }
    }

    @Deprecated
    public AWSLambdaClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AWSLambdaClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AWSLambdaClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this(new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public AWSLambdaClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AWSLambdaClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AWSLambdaClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    public AWSLambdaClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(adjustClientConfiguration(clientConfiguration), httpClient);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> httpResponseHandler, ExecutionContext executionContext) {
        request.setEndpoint(this.endpoint);
        request.setTimeOffset(this.timeOffset);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.CredentialsRequestTime;
        awsRequestMetrics.startEvent(field);
        try {
            AWSCredentials credentials = this.awsCredentialsProvider.getCredentials();
            awsRequestMetrics.endEvent(field);
            AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
            if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
                credentials = originalRequest.getRequestCredentials();
            }
            executionContext.setCredentials(credentials);
            return this.client.execute(request, httpResponseHandler, new JsonErrorResponseHandler(this.jsonErrorUnmarshallers), executionContext);
        } catch (Throwable th) {
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
            throw th;
        }
    }

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }
}
