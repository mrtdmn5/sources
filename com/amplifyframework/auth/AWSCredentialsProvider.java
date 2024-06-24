package com.amplifyframework.auth;

import com.amplifyframework.auth.AWSCredentials;
import com.amplifyframework.core.Consumer;

/* compiled from: AWSCredentialsProvider.kt */
/* loaded from: classes.dex */
public interface AWSCredentialsProvider<T extends AWSCredentials> {
    void fetchAWSCredentials(Consumer<T> consumer, Consumer<AuthException> consumer2);
}
