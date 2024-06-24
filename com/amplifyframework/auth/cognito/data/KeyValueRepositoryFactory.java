package com.amplifyframework.auth.cognito.data;

import android.content.Context;
import com.amplifyframework.core.store.EncryptedKeyValueRepository;
import com.amplifyframework.core.store.KeyValueRepository;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: KeyValueRepositoryFactory.kt */
/* loaded from: classes.dex */
public final class KeyValueRepositoryFactory {
    public static /* synthetic */ KeyValueRepository create$default(KeyValueRepositoryFactory keyValueRepositoryFactory, Context context, String str, boolean z, int r4, Object obj) {
        if ((r4 & 4) != 0) {
            z = true;
        }
        return keyValueRepositoryFactory.create(context, str, z);
    }

    public final KeyValueRepository create(Context context, String keyValueRepoID, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyValueRepoID, "keyValueRepoID");
        if (Intrinsics.areEqual(keyValueRepoID, AWSCognitoAuthCredentialStore.awsKeyValueStoreIdentifier)) {
            if (z) {
                return new EncryptedKeyValueRepository(context, keyValueRepoID);
            }
            return new InMemoryKeyValueRepository();
        }
        if (!Intrinsics.areEqual(keyValueRepoID, AWSCognitoLegacyCredentialStore.AWS_KEY_VALUE_STORE_NAMESPACE_IDENTIFIER) && !Intrinsics.areEqual(keyValueRepoID, AWSCognitoLegacyCredentialStore.APP_TOKENS_INFO_CACHE) && !Intrinsics.areEqual(keyValueRepoID, AWSCognitoLegacyCredentialStore.AWS_MOBILE_CLIENT_PROVIDER) && !StringsKt__StringsJVMKt.startsWith(keyValueRepoID, AWSCognitoLegacyCredentialStore.APP_DEVICE_INFO_CACHE, false)) {
            return new InMemoryKeyValueRepository();
        }
        return new LegacyKeyValueRepository(context, keyValueRepoID, false, 4, null);
    }
}
