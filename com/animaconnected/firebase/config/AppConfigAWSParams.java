package com.animaconnected.firebase.config;

/* compiled from: AppConfigAWSParams.kt */
/* loaded from: classes.dex */
public final class AppConfigAWSParams {
    private boolean crashReport;
    private String lambdaType;
    private String poolId;
    private String region;
    private String s3UploadDeviceCrashBucket;

    public final boolean getCrashReport() {
        return this.crashReport;
    }

    public final String getLambdaType() {
        return this.lambdaType;
    }

    public final String getPoolId() {
        return this.poolId;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getS3UploadDeviceCrashBucket() {
        return this.s3UploadDeviceCrashBucket;
    }

    public final void setCrashReport(boolean z) {
        this.crashReport = z;
    }

    public final void setLambdaType(String str) {
        this.lambdaType = str;
    }

    public final void setPoolId(String str) {
        this.poolId = str;
    }

    public final void setRegion(String str) {
        this.region = str;
    }

    public final void setS3UploadDeviceCrashBucket(String str) {
        this.s3UploadDeviceCrashBucket = str;
    }
}
