package com.amplifyframework.auth;

import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import com.amplifyframework.annotations.InternalApiWarning;
import com.amplifyframework.core.Consumer;
import kotlin.coroutines.Continuation;

/* compiled from: AuthCredentialsProvider.kt */
@InternalApiWarning
/* loaded from: classes.dex */
public interface AuthCredentialsProvider extends CredentialsProvider {
    void getAccessToken(Consumer<String> consumer, Consumer<Exception> consumer2);

    /* synthetic */ Object getCredentials(Continuation continuation);

    Object getIdentityId(Continuation<? super String> continuation);
}
