package com.animaconnected.cloud;

import android.annotation.SuppressLint;
import android.content.Context;
import com.animaconnected.cloud.amazon.AWSAmplifyCredentialsProvider;
import com.animaconnected.cloud.amazon.AWSCloud;
import com.animaconnected.cloud.amazon.AWSCloudConfig;
import com.animaconnected.cloud.amazon.lambda.SendFeedbackParams;
import com.animaconnected.cloud.util.CloudIfttt;
import com.animaconnected.cloud.util.CloudProductInfo;
import com.animaconnected.cloud.util.CloudProductInfoResponse;
import com.animaconnected.cloud.util.CloudStatusApp;
import com.animaconnected.cloud.util.CloudStatusDevice;
import com.animaconnected.cloud.util.CloudStatusMobile;
import com.animaconnected.cloud.util.CloudStatusResponse;
import com.animaconnected.future.Future;
import java.io.File;
import java.net.URL;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Cloud.kt */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes.dex */
public final class Cloud {
    private AWSCloud sAWSCloud;

    public Cloud(Context context, AWSCloudConfig config, AWSAmplifyCredentialsProvider credentialsProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(credentialsProvider, "credentialsProvider");
        this.sAWSCloud = new AWSCloud(context, config, credentialsProvider);
    }

    public final synchronized Future<Void> downloadFromS3(Map<String, String> map, File file) {
        Future<Void> downloadFromS3;
        downloadFromS3 = this.sAWSCloud.downloadFromS3(map, file);
        Intrinsics.checkNotNullExpressionValue(downloadFromS3, "downloadFromS3(...)");
        return downloadFromS3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getCognitoId(kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.animaconnected.cloud.Cloud$getCognitoId$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.cloud.Cloud$getCognitoId$1 r0 = (com.animaconnected.cloud.Cloud$getCognitoId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.cloud.Cloud$getCognitoId$1 r0 = new com.animaconnected.cloud.Cloud$getCognitoId$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L2f:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.scheduling.DefaultIoScheduler r6 = kotlinx.coroutines.Dispatchers.IO
            com.animaconnected.cloud.Cloud$getCognitoId$2 r2 = new com.animaconnected.cloud.Cloud$getCognitoId$2
            r4 = 0
            r2.<init>(r4)
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            java.lang.String r0 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.cloud.Cloud.getCognitoId(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: getCognitoToken-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m695getCognitoTokenIoAF18A(kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.animaconnected.cloud.Cloud$getCognitoToken$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.cloud.Cloud$getCognitoToken$1 r0 = (com.animaconnected.cloud.Cloud$getCognitoToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.cloud.Cloud$getCognitoToken$1 r0 = new com.animaconnected.cloud.Cloud$getCognitoToken$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L2f:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.scheduling.DefaultIoScheduler r6 = kotlinx.coroutines.Dispatchers.IO
            com.animaconnected.cloud.Cloud$getCognitoToken$2 r2 = new com.animaconnected.cloud.Cloud$getCognitoToken$2
            r4 = 0
            r2.<init>(r4)
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r6 = r6.value
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.cloud.Cloud.m695getCognitoTokenIoAF18A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getCrashBucket() {
        return this.sAWSCloud.getCrashBucket();
    }

    public final synchronized Future<URL> getIftttSetupUrl() {
        Future<URL> iftttSetupUrl;
        iftttSetupUrl = this.sAWSCloud.getIftttSetupUrl();
        Intrinsics.checkNotNullExpressionValue(iftttSetupUrl, "getIftttSetupUrl(...)");
        return iftttSetupUrl;
    }

    public final String getPoolId() {
        return this.sAWSCloud.getPoolId();
    }

    public final synchronized Future<CloudProductInfoResponse> getProductInfo(CloudProductInfo cloudProductInfo) {
        Future<CloudProductInfoResponse> productInfo;
        productInfo = this.sAWSCloud.getProductInfo(cloudProductInfo);
        Intrinsics.checkNotNullExpressionValue(productInfo, "getProductInfo(...)");
        return productInfo;
    }

    public final String getRegion() {
        return this.sAWSCloud.getRegion();
    }

    public final synchronized Future<Boolean> getRemoteDebug(String str, boolean z) {
        Future<Boolean> remoteDebug;
        remoteDebug = this.sAWSCloud.getRemoteDebug(str, z);
        Intrinsics.checkNotNullExpressionValue(remoteDebug, "getRemoteDebug(...)");
        return remoteDebug;
    }

    public final synchronized Future<String> getWhoami(String str) {
        Future<String> whoami;
        whoami = this.sAWSCloud.getWhoami(str);
        Intrinsics.checkNotNullExpressionValue(whoami, "getWhoami(...)");
        return whoami;
    }

    public final void registerEventListener(CloudEventListener cloudEventListener) {
        CloudEventDispatcher.getInstance().registerEventListener(cloudEventListener);
    }

    public final synchronized Future<Void> sendFeedback(SendFeedbackParams sendFeedbackParams) {
        Future<Void> sendFeedback;
        sendFeedback = this.sAWSCloud.sendFeedback(sendFeedbackParams);
        Intrinsics.checkNotNullExpressionValue(sendFeedback, "sendFeedback(...)");
        return sendFeedback;
    }

    public final synchronized Future<Void> sendIftttTriggerPressed(CloudIfttt.ACTION_E r2, CloudIfttt.TRIGGER_E r3, Double d, Double d2) {
        Future<Void> sendIftttTrigger;
        sendIftttTrigger = this.sAWSCloud.sendIftttTrigger(CloudIfttt.action2String(r2), CloudIfttt.trigger2String(r3), d, d2);
        Intrinsics.checkNotNullExpressionValue(sendIftttTrigger, "sendIftttTrigger(...)");
        return sendIftttTrigger;
    }

    public final synchronized Future<CloudStatusResponse> sendStatus(CloudStatusMobile cloudStatusMobile, CloudStatusApp cloudStatusApp, CloudStatusDevice cloudStatusDevice) {
        Future<CloudStatusResponse> sendStatus;
        sendStatus = this.sAWSCloud.sendStatus(cloudStatusMobile, cloudStatusApp, cloudStatusDevice);
        Intrinsics.checkNotNullExpressionValue(sendStatus, "sendStatus(...)");
        return sendStatus;
    }

    public final void unregisterEventListener(CloudEventListener cloudEventListener) {
        CloudEventDispatcher.getInstance().unregisterEventListener(cloudEventListener);
    }

    public final synchronized Future<Void> updateTokens(String str) {
        Future<Void> updateTokens;
        updateTokens = this.sAWSCloud.updateTokens(str);
        Intrinsics.checkNotNullExpressionValue(updateTokens, "updateTokens(...)");
        return updateTokens;
    }

    public final synchronized Future<String> uploadDeviceCrash(File file, String s3Url) {
        Future<String> uploadDeviceCrash;
        Intrinsics.checkNotNullParameter(s3Url, "s3Url");
        uploadDeviceCrash = this.sAWSCloud.uploadDeviceCrash(file, s3Url);
        Intrinsics.checkNotNullExpressionValue(uploadDeviceCrash, "uploadDeviceCrash(...)");
        return uploadDeviceCrash;
    }
}
