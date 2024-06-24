package com.animaconnected.cloud.amazon;

import com.animaconnected.future.Future;

/* compiled from: AWSAmplifyCredentials.kt */
/* loaded from: classes.dex */
public interface AWSAmplifyCredentialsProvider {
    Future<AWSAmplifyCredentials> getCredentialsProvider();
}
