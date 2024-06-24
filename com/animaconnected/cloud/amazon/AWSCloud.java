package com.animaconnected.cloud.amazon;

import android.content.Context;
import com.animaconnected.cloud.amazon.lambda.SendFeedbackParams;
import com.animaconnected.cloud.amazon.lambda.TokenStorageReturn;
import com.animaconnected.cloud.util.CloudProductInfo;
import com.animaconnected.cloud.util.CloudProductInfoResponse;
import com.animaconnected.cloud.util.CloudStatusApp;
import com.animaconnected.cloud.util.CloudStatusDevice;
import com.animaconnected.cloud.util.CloudStatusMobile;
import com.animaconnected.cloud.util.CloudStatusResponse;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public class AWSCloud {
    private static final long LAMBDA_TIMEOUT_MS = 20000;
    private static final long PRODUCT_INFO_TIMEOUT_MS = 10000;
    private final AWSCloudConfig mConfig;
    private final Context mContext;
    private AWSAmplifyCredentialsProvider mCredentialsProvider;
    private AWSLambda mLambda;
    private AWSStorage mStorage;

    public AWSCloud(Context context, AWSCloudConfig aWSCloudConfig, AWSAmplifyCredentialsProvider aWSAmplifyCredentialsProvider) {
        this.mContext = context;
        this.mConfig = aWSCloudConfig;
        this.mCredentialsProvider = aWSAmplifyCredentialsProvider;
    }

    private AWSLambda getLambda() {
        if (this.mLambda == null) {
            this.mLambda = new AWSLambda(this.mContext, this.mConfig, this.mCredentialsProvider);
        }
        return this.mLambda;
    }

    private AWSStorage getStorage() {
        if (this.mStorage == null) {
            this.mStorage = new AWSStorage(this.mContext, this.mConfig, this.mCredentialsProvider);
        }
        return this.mStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$updateTokens$0(TokenStorageReturn tokenStorageReturn) throws IOException {
        return null;
    }

    public Future<Void> downloadFromS3(Map<String, String> map, File file) {
        return getStorage().download(map, file);
    }

    public String getCrashBucket() {
        AWSCloudConfig aWSCloudConfig = this.mConfig;
        if (aWSCloudConfig == null) {
            return null;
        }
        return aWSCloudConfig.getS3UploadDeviceCrashBucket();
    }

    public Future<URL> getIftttSetupUrl() {
        return getLambda().getIftttSetupUrl();
    }

    public String getPoolId() {
        AWSCloudConfig aWSCloudConfig = this.mConfig;
        if (aWSCloudConfig == null) {
            return null;
        }
        return aWSCloudConfig.getPoolId();
    }

    public Future<CloudProductInfoResponse> getProductInfo(CloudProductInfo cloudProductInfo) {
        return getLambda().getProductInfo(cloudProductInfo).timeout(PRODUCT_INFO_TIMEOUT_MS);
    }

    public String getRegion() {
        AWSCloudConfig aWSCloudConfig = this.mConfig;
        if (aWSCloudConfig == null) {
            return null;
        }
        return aWSCloudConfig.getRegion().getName();
    }

    public Future<Boolean> getRemoteDebug(String str, boolean z) {
        return getLambda().getRemoteDebug(str, Boolean.valueOf(z)).timeout(LAMBDA_TIMEOUT_MS);
    }

    public Future<String> getWhoami(String str) {
        return getLambda().getWhoami(str);
    }

    public Future<Void> sendFeedback(SendFeedbackParams sendFeedbackParams) {
        return getLambda().sendFeedback(sendFeedbackParams);
    }

    public Future<Void> sendIftttTrigger(String str, String str2, Double d, Double d2) {
        return getLambda().sendIftttTrigger(str, str2, d, d2);
    }

    public Future<CloudStatusResponse> sendStatus(CloudStatusMobile cloudStatusMobile, CloudStatusApp cloudStatusApp, CloudStatusDevice cloudStatusDevice) {
        return getLambda().sendStatus(cloudStatusMobile, cloudStatusApp, cloudStatusDevice).timeout(LAMBDA_TIMEOUT_MS);
    }

    public Future<Void> updateTokens(String str) {
        return getLambda().updateTokens(str).map(new JDBC3PreparedStatement$$ExternalSyntheticLambda0());
    }

    public Future<String> uploadDeviceCrash(File file, String str) {
        if (!this.mConfig.getCrashReporting()) {
            return FutureUtils.error(new Throwable("Crash reporting to AWS is disabled"));
        }
        return getStorage().uploadDeviceCrash(file, str);
    }
}
