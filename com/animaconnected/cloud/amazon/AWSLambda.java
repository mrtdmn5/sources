package com.animaconnected.cloud.amazon;

import android.content.Context;
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaInvokerFactory;
import com.animaconnected.cloud.CloudEvent;
import com.animaconnected.cloud.CloudEventDispatcher;
import com.animaconnected.cloud.amazon.AWSCloudConfig;
import com.animaconnected.cloud.amazon.lambda.GetProductInfoParams;
import com.animaconnected.cloud.amazon.lambda.GetProductInfoReturn;
import com.animaconnected.cloud.amazon.lambda.IftttParams;
import com.animaconnected.cloud.amazon.lambda.IftttReturn;
import com.animaconnected.cloud.amazon.lambda.LambdaFunctions;
import com.animaconnected.cloud.amazon.lambda.RemoteDebugParams;
import com.animaconnected.cloud.amazon.lambda.RemoteDebugReturn;
import com.animaconnected.cloud.amazon.lambda.SendFeedbackParams;
import com.animaconnected.cloud.amazon.lambda.SendStatusDestinationParams;
import com.animaconnected.cloud.amazon.lambda.SendStatusDestinationReturn;
import com.animaconnected.cloud.amazon.lambda.TokenStorageParams;
import com.animaconnected.cloud.amazon.lambda.TokenStorageReturn;
import com.animaconnected.cloud.amazon.lambda.WhoamiParams;
import com.animaconnected.cloud.amazon.lambda.WhoamiReturn;
import com.animaconnected.cloud.util.CloudIfttt;
import com.animaconnected.cloud.util.CloudIftttStatus;
import com.animaconnected.cloud.util.CloudProductInfo;
import com.animaconnected.cloud.util.CloudProductInfoResponse;
import com.animaconnected.cloud.util.CloudStatusApp;
import com.animaconnected.cloud.util.CloudStatusDevice;
import com.animaconnected.cloud.util.CloudStatusMobile;
import com.animaconnected.cloud.util.CloudStatusResponse;
import com.animaconnected.future.FailCallback;
import com.animaconnected.future.FlatMapCallback;
import com.animaconnected.future.Future;
import com.animaconnected.future.runner.BackgroundRunner;
import com.animaconnected.future.runner.SequentialBackgroundRunner;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Callable;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda1;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda4;
import org.sqlite.jdbc3.JDBC3Statement$$ExternalSyntheticLambda0;
import org.sqlite.jdbc3.JDBC3Statement$$ExternalSyntheticLambda1;

/* loaded from: classes.dex */
public class AWSLambda {
    private final AWSCloudConfig mConfig;
    private final Context mContext;
    private final AWSAmplifyCredentialsProvider mCredentialsProvider;
    private LambdaFunctions mLambdaFunctions;
    private final AWSCloudConfig.LambdaType mLambdaType;
    private final BackgroundRunner mRunner = new SequentialBackgroundRunner();
    private final CloudEventDispatcher mEventDispatcher = CloudEventDispatcher.getInstance();

    public AWSLambda(Context context, AWSCloudConfig aWSCloudConfig, AWSAmplifyCredentialsProvider aWSAmplifyCredentialsProvider) {
        this.mContext = context;
        this.mConfig = aWSCloudConfig;
        this.mCredentialsProvider = aWSAmplifyCredentialsProvider;
        this.mLambdaType = aWSCloudConfig.getLambdaType();
    }

    private Future<IftttReturn> getIfttt(final IftttParams iftttParams) {
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "call", "getIfttt"));
        return getLambdaFunctions().flatMap(new FlatMapCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda14
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$getIfttt$21;
                lambda$getIfttt$21 = AWSLambda.this.lambda$getIfttt$21(iftttParams, (LambdaFunctions) obj);
                return lambda$getIfttt$21;
            }
        }).fail(new FailCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda15
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                AWSLambda.this.lambda$getIfttt$22(th);
            }
        });
    }

    private Future<LambdaFunctions> getLambdaFunctions() {
        return this.mCredentialsProvider.getCredentialsProvider().map(new AWSLambda$$ExternalSyntheticLambda2(this));
    }

    public /* synthetic */ IftttReturn lambda$getIfttt$20(LambdaFunctions lambdaFunctions, IftttParams iftttParams) throws Exception {
        if (this.mLambdaType == AWSCloudConfig.LambdaType.STABLE) {
            return lambdaFunctions.getIfttStable(iftttParams);
        }
        return lambdaFunctions.getIftt(iftttParams);
    }

    public /* synthetic */ Future lambda$getIfttt$21(final IftttParams iftttParams, final LambdaFunctions lambdaFunctions) throws Exception {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                IftttReturn lambda$getIfttt$20;
                lambda$getIfttt$20 = AWSLambda.this.lambda$getIfttt$20(lambdaFunctions, iftttParams);
                return lambda$getIfttt$20;
            }
        });
    }

    public /* synthetic */ void lambda$getIfttt$22(Throwable th) {
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "error", "getIfttt", th));
    }

    public static /* synthetic */ URL lambda$getIftttSetupUrl$14(IftttReturn iftttReturn) throws IOException {
        return new URL(iftttReturn.getUrl());
    }

    public /* synthetic */ void lambda$getIftttSetupUrl$15(Throwable th) {
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "error", "getIftttSetupUrl", th));
    }

    public static /* synthetic */ CloudIftttStatus lambda$getIftttStatus$16(IftttReturn iftttReturn) throws IOException {
        return new CloudIftttStatus(iftttReturn.getConnection());
    }

    public /* synthetic */ void lambda$getIftttStatus$17(Throwable th) {
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "error", "getIftttStatus", th));
    }

    public /* synthetic */ LambdaFunctions lambda$getLambdaFunctions$0(AWSAmplifyCredentials aWSAmplifyCredentials) throws IOException {
        LambdaFunctions lambdaFunctions = (LambdaFunctions) LambdaInvokerFactory.builder().context(this.mContext.getApplicationContext()).region(this.mConfig.getRegion()).credentialsProvider(aWSAmplifyCredentials).build().build(LambdaFunctions.class);
        this.mLambdaFunctions = lambdaFunctions;
        return lambdaFunctions;
    }

    public /* synthetic */ GetProductInfoReturn lambda$getProductInfo$5(LambdaFunctions lambdaFunctions, GetProductInfoParams getProductInfoParams) throws Exception {
        if (this.mLambdaType == AWSCloudConfig.LambdaType.STABLE) {
            return lambdaFunctions.getProductInfoStable(getProductInfoParams);
        }
        return lambdaFunctions.getProductInfo(getProductInfoParams);
    }

    public /* synthetic */ Future lambda$getProductInfo$6(final GetProductInfoParams getProductInfoParams, final LambdaFunctions lambdaFunctions) throws Exception {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda10
            @Override // java.util.concurrent.Callable
            public final Object call() {
                GetProductInfoReturn lambda$getProductInfo$5;
                lambda$getProductInfo$5 = AWSLambda.this.lambda$getProductInfo$5(lambdaFunctions, getProductInfoParams);
                return lambda$getProductInfo$5;
            }
        });
    }

    public /* synthetic */ void lambda$getProductInfo$7(Throwable th) {
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "error", "getProductInfo", th));
    }

    public /* synthetic */ void lambda$getRemoteDebug$10(Throwable th) {
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "error", "getRemoteDebug", th));
    }

    public /* synthetic */ RemoteDebugReturn lambda$getRemoteDebug$8(LambdaFunctions lambdaFunctions, RemoteDebugParams remoteDebugParams) throws Exception {
        if (this.mLambdaType == AWSCloudConfig.LambdaType.STABLE) {
            return lambdaFunctions.getRemoteDebugStable(remoteDebugParams);
        }
        return lambdaFunctions.getRemoteDebug(remoteDebugParams);
    }

    public /* synthetic */ Future lambda$getRemoteDebug$9(final RemoteDebugParams remoteDebugParams, final LambdaFunctions lambdaFunctions) throws Exception {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final Object call() {
                RemoteDebugReturn lambda$getRemoteDebug$8;
                lambda$getRemoteDebug$8 = AWSLambda.this.lambda$getRemoteDebug$8(lambdaFunctions, remoteDebugParams);
                return lambda$getRemoteDebug$8;
            }
        });
    }

    public /* synthetic */ WhoamiReturn lambda$getWhoami$11(LambdaFunctions lambdaFunctions, WhoamiParams whoamiParams) throws Exception {
        if (this.mLambdaType == AWSCloudConfig.LambdaType.STABLE) {
            return lambdaFunctions.getWhoamiStable(whoamiParams);
        }
        return lambdaFunctions.getWhoami(whoamiParams);
    }

    public /* synthetic */ Future lambda$getWhoami$12(final WhoamiParams whoamiParams, final LambdaFunctions lambdaFunctions) throws Exception {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda19
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WhoamiReturn lambda$getWhoami$11;
                lambda$getWhoami$11 = AWSLambda.this.lambda$getWhoami$11(lambdaFunctions, whoamiParams);
                return lambda$getWhoami$11;
            }
        });
    }

    public /* synthetic */ void lambda$getWhoami$13(Throwable th) {
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "error", "getWhoami", th));
    }

    public /* synthetic */ Void lambda$sendFeedback$26(LambdaFunctions lambdaFunctions, SendFeedbackParams sendFeedbackParams) throws Exception {
        if (this.mLambdaType == AWSCloudConfig.LambdaType.STABLE) {
            lambdaFunctions.sendFeedbackStable(sendFeedbackParams);
            return null;
        }
        lambdaFunctions.sendFeedback(sendFeedbackParams);
        return null;
    }

    public /* synthetic */ Future lambda$sendFeedback$27(final SendFeedbackParams sendFeedbackParams, final LambdaFunctions lambdaFunctions) throws Exception {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void lambda$sendFeedback$26;
                lambda$sendFeedback$26 = AWSLambda.this.lambda$sendFeedback$26(lambdaFunctions, sendFeedbackParams);
                return lambda$sendFeedback$26;
            }
        });
    }

    public /* synthetic */ void lambda$sendFeedback$28(Throwable th) {
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "error", "sendFeedback", th));
    }

    public static /* synthetic */ Void lambda$sendIftttTrigger$18(IftttReturn iftttReturn) throws IOException {
        return null;
    }

    public /* synthetic */ void lambda$sendIftttTrigger$19(Throwable th) {
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "error", "sendIftttTrigger", th));
    }

    public /* synthetic */ SendStatusDestinationReturn lambda$sendStatus$1(LambdaFunctions lambdaFunctions, SendStatusDestinationParams sendStatusDestinationParams) throws Exception {
        if (this.mLambdaType == AWSCloudConfig.LambdaType.STABLE) {
            return lambdaFunctions.sendStatusStable(sendStatusDestinationParams);
        }
        return lambdaFunctions.sendStatus(sendStatusDestinationParams);
    }

    public /* synthetic */ Future lambda$sendStatus$2(final SendStatusDestinationParams sendStatusDestinationParams, final LambdaFunctions lambdaFunctions) throws Exception {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                SendStatusDestinationReturn lambda$sendStatus$1;
                lambda$sendStatus$1 = AWSLambda.this.lambda$sendStatus$1(lambdaFunctions, sendStatusDestinationParams);
                return lambda$sendStatus$1;
            }
        });
    }

    public static /* synthetic */ CloudStatusResponse lambda$sendStatus$3(SendStatusDestinationReturn sendStatusDestinationReturn) throws IOException {
        return new CloudStatusResponse(sendStatusDestinationReturn.getAppStatus(), sendStatusDestinationReturn.getDeviceStatus(), sendStatusDestinationReturn.getDownloadInfo(), sendStatusDestinationReturn.getRevision(), sendStatusDestinationReturn.getItemId());
    }

    public /* synthetic */ void lambda$sendStatus$4(Throwable th) {
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "error", "sendStatus", th));
    }

    public /* synthetic */ TokenStorageReturn lambda$updateTokens$23(LambdaFunctions lambdaFunctions, String str) throws Exception {
        if (this.mLambdaType == AWSCloudConfig.LambdaType.STABLE) {
            return lambdaFunctions.updateTokensStable(new TokenStorageParams(str));
        }
        return lambdaFunctions.updateTokens(new TokenStorageParams(str));
    }

    public /* synthetic */ Future lambda$updateTokens$24(final String str, final LambdaFunctions lambdaFunctions) throws Exception {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                TokenStorageReturn lambda$updateTokens$23;
                lambda$updateTokens$23 = AWSLambda.this.lambda$updateTokens$23(lambdaFunctions, str);
                return lambda$updateTokens$23;
            }
        });
    }

    public /* synthetic */ void lambda$updateTokens$25(Throwable th) {
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "error", "updateTokens", th));
    }

    public Future<URL> getIftttSetupUrl() {
        IftttParams iftttParams = new IftttParams(CloudIfttt.action2String(CloudIfttt.ACTION_E.SETUP), null, null, null);
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "call", "getIftttSetupUrl"));
        return getIfttt(iftttParams).map(new JDBC3PreparedStatement$$ExternalSyntheticLambda3()).fail(new FailCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda5
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                AWSLambda.this.lambda$getIftttSetupUrl$15(th);
            }
        });
    }

    public Future<CloudIftttStatus> getIftttStatus(String str) {
        IftttParams iftttParams = new IftttParams(str, null, null, null);
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "call", "getIftttStatus"));
        return getIfttt(iftttParams).map(new AWSLambda$$ExternalSyntheticLambda11()).fail(new FailCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda12
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                AWSLambda.this.lambda$getIftttStatus$17(th);
            }
        });
    }

    public Future<CloudProductInfoResponse> getProductInfo(CloudProductInfo cloudProductInfo) {
        final GetProductInfoParams getProductInfoParams = new GetProductInfoParams(cloudProductInfo.getSerialNumber(), cloudProductInfo.getItemId(), cloudProductInfo.getBucket(), cloudProductInfo.getPlatform());
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "call", "getProductInfo"));
        return getLambdaFunctions().flatMap(new FlatMapCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda6
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$getProductInfo$6;
                lambda$getProductInfo$6 = AWSLambda.this.lambda$getProductInfo$6(getProductInfoParams, (LambdaFunctions) obj);
                return lambda$getProductInfo$6;
            }
        }).map(new JDBC3PreparedStatement$$ExternalSyntheticLambda4()).fail(new FailCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda7
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                AWSLambda.this.lambda$getProductInfo$7(th);
            }
        });
    }

    public Future<Boolean> getRemoteDebug(String str, Boolean bool) {
        final RemoteDebugParams remoteDebugParams = new RemoteDebugParams(str, bool);
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "call", "getRemoteDebug"));
        return getLambdaFunctions().flatMap(new FlatMapCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda16
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$getRemoteDebug$9;
                lambda$getRemoteDebug$9 = AWSLambda.this.lambda$getRemoteDebug$9(remoteDebugParams, (LambdaFunctions) obj);
                return lambda$getRemoteDebug$9;
            }
        }).map(new AWSLambda$$ExternalSyntheticLambda17()).fail(new FailCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda18
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                AWSLambda.this.lambda$getRemoteDebug$10(th);
            }
        });
    }

    public Future<String> getWhoami(String str) {
        final WhoamiParams whoamiParams = new WhoamiParams(str);
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "call", "getWhoami"));
        return getLambdaFunctions().flatMap(new FlatMapCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$getWhoami$12;
                lambda$getWhoami$12 = AWSLambda.this.lambda$getWhoami$12(whoamiParams, (LambdaFunctions) obj);
                return lambda$getWhoami$12;
            }
        }).map(new JDBC3PreparedStatement$$ExternalSyntheticLambda1()).fail(new FailCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda1
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                AWSLambda.this.lambda$getWhoami$13(th);
            }
        });
    }

    public Future<Void> sendFeedback(final SendFeedbackParams sendFeedbackParams) {
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "call", "sendFeedback"));
        return getLambdaFunctions().flatMap(new FlatMapCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda25
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$sendFeedback$27;
                lambda$sendFeedback$27 = AWSLambda.this.lambda$sendFeedback$27(sendFeedbackParams, (LambdaFunctions) obj);
                return lambda$sendFeedback$27;
            }
        }).fail(new AWSLambda$$ExternalSyntheticLambda26(0, this));
    }

    public Future<Void> sendIftttTrigger(String str, String str2, Double d, Double d2) {
        IftttParams iftttParams = new IftttParams(str, str2, d, d2);
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "call", "sendIftttTrigger"));
        return getIfttt(iftttParams).map(new JDBC3Statement$$ExternalSyntheticLambda1()).fail(new FailCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda22
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                AWSLambda.this.lambda$sendIftttTrigger$19(th);
            }
        });
    }

    public Future<CloudStatusResponse> sendStatus(CloudStatusMobile cloudStatusMobile, CloudStatusApp cloudStatusApp, CloudStatusDevice cloudStatusDevice) {
        SendStatusDestinationParams sendStatusDestinationParams = new SendStatusDestinationParams(cloudStatusMobile, cloudStatusApp, cloudStatusDevice);
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "call", "sendStatus"));
        return getLambdaFunctions().flatMap(new JDBC3Statement$$ExternalSyntheticLambda0(this, sendStatusDestinationParams)).map(new AWSLambda$$ExternalSyntheticLambda20()).fail(new FailCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda21
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                AWSLambda.this.lambda$sendStatus$4(th);
            }
        });
    }

    public Future<TokenStorageReturn> updateTokens(final String str) {
        this.mEventDispatcher.notify(new CloudEvent(CloudEvent.CLOUD_FEATURE_LAMBDA, "call", "updateTokens"));
        return getLambdaFunctions().flatMap(new FlatMapCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda23
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$updateTokens$24;
                lambda$updateTokens$24 = AWSLambda.this.lambda$updateTokens$24(str, (LambdaFunctions) obj);
                return lambda$updateTokens$24;
            }
        }).fail(new FailCallback() { // from class: com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda24
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                AWSLambda.this.lambda$updateTokens$25(th);
            }
        });
    }
}
