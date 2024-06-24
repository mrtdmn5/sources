package com.amazonaws.mobileconnectors.lambdainvoker;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.util.ClientContext;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.model.InvocationType;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.LogType;
import com.amazonaws.util.Base64;
import com.amazonaws.util.StringUtils;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
class LambdaInvocationHandler implements InvocationHandler {
    private static final Log LOGGER = LogFactory.getLog((Class<?>) LambdaInvocationHandler.class);
    private final LambdaDataBinder binder;
    private final ClientContext clientContext;
    private final AWSLambda lambda;

    public LambdaInvocationHandler(AWSLambda aWSLambda, LambdaDataBinder lambdaDataBinder, ClientContext clientContext) {
        this.lambda = aWSLambda;
        this.binder = lambdaDataBinder;
        this.clientContext = clientContext;
    }

    public InvokeRequest buildInvokeRequest(Method method, Object obj) throws IOException {
        LambdaFunction lambdaFunction = (LambdaFunction) method.getAnnotation(LambdaFunction.class);
        InvokeRequest invokeRequest = new InvokeRequest();
        if (lambdaFunction.functionName().isEmpty()) {
            invokeRequest.setFunctionName(method.getName());
        } else {
            invokeRequest.setFunctionName(lambdaFunction.functionName());
        }
        invokeRequest.setLogType(lambdaFunction.logType());
        if (!LogType.None.toString().equals(lambdaFunction.logType())) {
            invokeRequest.setInvocationType(InvocationType.RequestResponse);
        } else {
            invokeRequest.setInvocationType(lambdaFunction.invocationType());
        }
        if (!lambdaFunction.qualifier().isEmpty()) {
            invokeRequest.setQualifier(lambdaFunction.qualifier());
        }
        ClientContext clientContext = this.clientContext;
        if (clientContext != null) {
            invokeRequest.setClientContext(clientContext.toBase64String());
        }
        invokeRequest.setPayload(ByteBuffer.wrap(this.binder.serialize(obj)));
        return invokeRequest;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Object obj2;
        validateInterfaceMethod(method, objArr);
        if (objArr != null && objArr.length != 0) {
            obj2 = objArr[0];
        } else {
            obj2 = null;
        }
        return processInvokeResult(method, this.lambda.invoke(buildInvokeRequest(method, obj2)));
    }

    public Object processInvokeResult(Method method, InvokeResult invokeResult) throws IOException {
        if (invokeResult.getLogResult() != null) {
            LOGGER.debug(method.getName() + " log: " + new String(Base64.decode(invokeResult.getLogResult()), StringUtils.UTF8));
        }
        if (invokeResult.getFunctionError() == null) {
            if (invokeResult.getStatusCode().intValue() != 204 && !Void.TYPE.equals(method.getReturnType())) {
                return this.binder.deserialize(invokeResult.getPayload().array(), method.getReturnType());
            }
            return null;
        }
        throw new LambdaFunctionException(invokeResult.getFunctionError(), new String(invokeResult.getPayload().array(), StringUtils.UTF8));
    }

    public void validateInterfaceMethod(Method method, Object[] objArr) {
        if (method.getAnnotation(LambdaFunction.class) != null) {
            if (objArr != null && objArr.length > 1) {
                throw new UnsupportedOperationException("LambdaFunctions take either 0 or 1 arguments.");
            }
        } else {
            throw new UnsupportedOperationException("No LambdaFunction annotation for method " + method.getName());
        }
    }
}
