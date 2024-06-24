package com.animaconnected.secondo.provider.login;

import com.animaconnected.cloud.amazon.AWSAmplifyCredentials;
import com.animaconnected.cloud.amazon.AWSAmplifyCredentialsProvider;
import com.animaconnected.future.Future;
import com.animaconnected.future.Promise;
import com.animaconnected.secondo.KronabyApplication;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: AWSAmplifyCredentialsProviderImpl.kt */
/* loaded from: classes3.dex */
public final class AWSAmplifyCredentialsProviderImpl implements AWSAmplifyCredentialsProvider {
    public static final int $stable = 0;

    @Override // com.animaconnected.cloud.amazon.AWSAmplifyCredentialsProvider
    public Future<AWSAmplifyCredentials> getCredentialsProvider() {
        Promise promise = new Promise();
        BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new AWSAmplifyCredentialsProviderImpl$getCredentialsProvider$1(promise, null), 3);
        Future<AWSAmplifyCredentials> future = promise.getFuture();
        Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
        return future;
    }
}
