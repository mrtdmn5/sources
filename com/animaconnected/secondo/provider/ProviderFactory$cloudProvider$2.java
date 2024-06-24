package com.animaconnected.secondo.provider;

import android.content.Context;
import com.animaconnected.cloud.Cloud;
import com.animaconnected.cloud.CloudEvent;
import com.animaconnected.cloud.amazon.AWSCloudConfig;
import com.animaconnected.firebase.config.AppConfigAWSParams;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.provider.login.AWSAmplifyCredentialsProviderImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ProviderFactory.kt */
/* loaded from: classes3.dex */
public final class ProviderFactory$cloudProvider$2 extends Lambda implements Function0<Cloud> {
    public static final ProviderFactory$cloudProvider$2 INSTANCE = new ProviderFactory$cloudProvider$2();

    public ProviderFactory$cloudProvider$2() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(CloudEvent event) {
        String str;
        Intrinsics.checkNotNullParameter(event, "event");
        Throwable throwable = event.getThrowable();
        if (throwable != null) {
            str = throwable.getMessage();
        } else {
            str = null;
        }
        ProviderFactory.getAppAnalytics().cloudEvent(event.getFeature(), event.getName(), event.getType(), str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Cloud invoke() {
        Context applicationContext;
        Context applicationContext2;
        RemoteConfigController.Companion companion = RemoteConfigController.Companion;
        ProviderFactory providerFactory = ProviderFactory.INSTANCE;
        applicationContext = providerFactory.getApplicationContext();
        AppConfigAWSParams appConfigAwsParams = companion.getInstance(applicationContext).getAppConfigAwsParams();
        String poolId = appConfigAwsParams.getPoolId();
        if (poolId == null) {
            poolId = "";
        }
        String region = appConfigAwsParams.getRegion();
        if (region == null) {
            region = "";
        }
        String lambdaType = appConfigAwsParams.getLambdaType();
        String str = lambdaType == null ? "" : lambdaType;
        String s3UploadDeviceCrashBucket = appConfigAwsParams.getS3UploadDeviceCrashBucket();
        String str2 = s3UploadDeviceCrashBucket != null ? s3UploadDeviceCrashBucket : "";
        if (ProviderFactory.getPoolIdProvider().isOnSandbox()) {
            poolId = PoolIdProvider.SANDBOX_IDENTITY_POOL_ID;
            region = PoolIdProvider.SANDBOX_REGION;
            str2 = PoolIdProvider.SANDBOX_CRASH_BUCKET;
        }
        AWSCloudConfig aWSCloudConfig = new AWSCloudConfig(poolId, region, str, appConfigAwsParams.getCrashReport(), str2);
        applicationContext2 = providerFactory.getApplicationContext();
        Cloud cloud = new Cloud(applicationContext2, aWSCloudConfig, new AWSAmplifyCredentialsProviderImpl());
        cloud.registerEventListener(new ProviderFactory$cloudProvider$2$$ExternalSyntheticLambda0());
        return cloud;
    }
}
