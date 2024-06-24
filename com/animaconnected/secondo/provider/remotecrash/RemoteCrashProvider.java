package com.animaconnected.secondo.provider.remotecrash;

import android.util.Log;
import com.animaconnected.cloud.Cloud;
import com.animaconnected.future.AlwaysCallback;
import com.animaconnected.future.FailCallback;
import com.animaconnected.future.FlatMapCallback;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureUtils;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceInfo;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes3.dex */
public class RemoteCrashProvider {
    private static final String TAG = "RemoteCrashProvider";
    private final Cloud mCloud;
    private boolean mFetching = false;
    private final WatchProvider mWatchProvider;

    public RemoteCrashProvider(Cloud cloud, WatchProvider watchProvider) {
        this.mCloud = cloud;
        this.mWatchProvider = watchProvider;
    }

    public static /* synthetic */ Boolean lambda$crashDeviceIfNeeded$0(Boolean bool) throws IOException {
        return Boolean.TRUE;
    }

    public /* synthetic */ Future lambda$crashDeviceIfNeeded$1(String str, Boolean bool) throws Exception {
        boolean isConnected = this.mWatchProvider.isConnected();
        if (isConnected && bool.booleanValue()) {
            Log.d(TAG, "Remote crash device...");
            return this.mCloud.getRemoteDebug(str, true).map(new RemoteCrashProvider$$ExternalSyntheticLambda0());
        }
        Log.d(TAG, "Don't crash device, connected: " + isConnected + ", forceCrash: " + bool);
        return FutureUtils.just(Boolean.FALSE);
    }

    public /* synthetic */ void lambda$crashDeviceIfNeeded$2(Boolean bool) {
        if (bool.booleanValue()) {
            this.mWatchProvider.writeHardFault(true);
        }
    }

    public static /* synthetic */ void lambda$crashDeviceIfNeeded$3(Throwable th) {
        Log.d(TAG, "Remote crash failed: ", th);
    }

    public /* synthetic */ void lambda$crashDeviceIfNeeded$4() {
        this.mFetching = false;
    }

    public /* synthetic */ void lambda$crashDeviceIfNeeded$5(Map map) {
        final String str = (String) map.get(DeviceInfo.SerialNumber);
        this.mCloud.getRemoteDebug(str, false).flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.provider.remotecrash.RemoteCrashProvider$$ExternalSyntheticLambda1
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$crashDeviceIfNeeded$1;
                lambda$crashDeviceIfNeeded$1 = RemoteCrashProvider.this.lambda$crashDeviceIfNeeded$1(str, (Boolean) obj);
                return lambda$crashDeviceIfNeeded$1;
            }
        }).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.remotecrash.RemoteCrashProvider$$ExternalSyntheticLambda2
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                RemoteCrashProvider.this.lambda$crashDeviceIfNeeded$2((Boolean) obj);
            }
        }).fail(new RemoteCrashProvider$$ExternalSyntheticLambda3()).always(new AlwaysCallback() { // from class: com.animaconnected.secondo.provider.remotecrash.RemoteCrashProvider$$ExternalSyntheticLambda4
            @Override // com.animaconnected.future.AlwaysCallback
            public final void onFinished() {
                RemoteCrashProvider.this.lambda$crashDeviceIfNeeded$4();
            }
        });
    }

    public /* synthetic */ void lambda$crashDeviceIfNeeded$6(Throwable th) {
        this.mFetching = false;
        Log.d(TAG, "Failed to fetch serial number from device", th);
    }

    public void crashDeviceIfNeeded() {
        if (this.mFetching) {
            Log.d(TAG, "Already checking if device needs to be crashed.");
        } else {
            this.mFetching = true;
            this.mWatchProvider.getDeviceInformation().success(new RemoteCrashProvider$$ExternalSyntheticLambda5(0, this)).fail(new FailCallback() { // from class: com.animaconnected.secondo.provider.remotecrash.RemoteCrashProvider$$ExternalSyntheticLambda6
                @Override // com.animaconnected.future.FailCallback
                public final void onFail(Throwable th) {
                    RemoteCrashProvider.this.lambda$crashDeviceIfNeeded$6(th);
                }
            });
        }
    }
}
