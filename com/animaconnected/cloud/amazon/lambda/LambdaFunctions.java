package com.animaconnected.cloud.amazon.lambda;

import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunction;

/* loaded from: classes.dex */
public interface LambdaFunctions {
    @LambdaFunction(functionName = "Ifttt")
    IftttReturn getIftt(IftttParams iftttParams);

    @LambdaFunction(functionName = "Ifttt", qualifier = "STABLE")
    IftttReturn getIfttStable(IftttParams iftttParams);

    @LambdaFunction(functionName = "ProductInfo")
    GetProductInfoReturn getProductInfo(GetProductInfoParams getProductInfoParams);

    @LambdaFunction(functionName = "ProductInfo", qualifier = "STABLE")
    GetProductInfoReturn getProductInfoStable(GetProductInfoParams getProductInfoParams);

    @LambdaFunction(functionName = "RemoteDebug")
    RemoteDebugReturn getRemoteDebug(RemoteDebugParams remoteDebugParams);

    @LambdaFunction(functionName = "RemoteDebug", qualifier = "STABLE")
    RemoteDebugReturn getRemoteDebugStable(RemoteDebugParams remoteDebugParams);

    @LambdaFunction(functionName = "Whoami")
    WhoamiReturn getWhoami(WhoamiParams whoamiParams);

    @LambdaFunction(functionName = "Whoami", qualifier = "STABLE")
    WhoamiReturn getWhoamiStable(WhoamiParams whoamiParams);

    @LambdaFunction(functionName = "Feedback")
    void sendFeedback(SendFeedbackParams sendFeedbackParams);

    @LambdaFunction(functionName = "Feedback", qualifier = "STABLE")
    void sendFeedbackStable(SendFeedbackParams sendFeedbackParams);

    @LambdaFunction(functionName = "AppStatus")
    SendStatusDestinationReturn sendStatus(SendStatusDestinationParams sendStatusDestinationParams);

    @LambdaFunction(functionName = "AppStatus", qualifier = "STABLE")
    SendStatusDestinationReturn sendStatusStable(SendStatusDestinationParams sendStatusDestinationParams);

    @LambdaFunction(functionName = "TokenStorage")
    TokenStorageReturn updateTokens(TokenStorageParams tokenStorageParams);

    @LambdaFunction(functionName = "TokenStorage", qualifier = "STABLE")
    TokenStorageReturn updateTokensStable(TokenStorageParams tokenStorageParams);
}
