package com.amplifyframework.auth.cognito.data;

import android.content.Context;
import com.amplifyframework.core.store.KeyValueRepository;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.AuthConfiguration;
import com.amplifyframework.statemachine.codegen.data.AuthCredentialStore;
import com.amplifyframework.statemachine.codegen.data.DeviceMetadata;
import com.amplifyframework.statemachine.codegen.data.IdentityPoolConfiguration;
import com.amplifyframework.statemachine.codegen.data.UserPoolConfiguration;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.Json;

/* compiled from: AWSCognitoAuthCredentialStore.kt */
/* loaded from: classes.dex */
public final class AWSCognitoAuthCredentialStore implements AuthCredentialStore {
    public static final Companion Companion = new Companion(null);
    private static final String Key_ASFDevice = "asfDevice";
    private static final String Key_DeviceMetadata = "deviceMetadata";
    private static final String Key_Session = "session";
    public static final String awsKeyValueStoreIdentifier = "com.amplify.credentialStore";
    private final AuthConfiguration authConfiguration;
    private final Context context;
    private KeyValueRepository keyValue;

    /* compiled from: AWSCognitoAuthCredentialStore.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AWSCognitoAuthCredentialStore(Context context, AuthConfiguration authConfiguration, boolean z, KeyValueRepositoryFactory keyValueRepoFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(authConfiguration, "authConfiguration");
        Intrinsics.checkNotNullParameter(keyValueRepoFactory, "keyValueRepoFactory");
        this.context = context;
        this.authConfiguration = authConfiguration;
        this.keyValue = keyValueRepoFactory.create(context, awsKeyValueStoreIdentifier, z);
    }

    private final AmplifyCredential.ASFDevice deserializeASFDevice(String str) {
        AmplifyCredential.ASFDevice aSFDevice;
        if (str != null) {
            try {
                Json.Default r1 = Json.Default;
                Object decodeFromString = r1.decodeFromString(ExceptionsKt.serializer(r1.serializersModule, Reflection.typeOf(AmplifyCredential.ASFDevice.class)), str);
                Intrinsics.checkNotNull(decodeFromString, "null cannot be cast to non-null type com.amplifyframework.statemachine.codegen.data.AmplifyCredential.ASFDevice");
                aSFDevice = (AmplifyCredential.ASFDevice) decodeFromString;
            } catch (Exception unused) {
                return new AmplifyCredential.ASFDevice(null);
            }
        } else {
            aSFDevice = null;
        }
        if (aSFDevice == null) {
            return new AmplifyCredential.ASFDevice(null);
        }
        return aSFDevice;
    }

    private final AmplifyCredential deserializeCredential(String str) {
        AmplifyCredential amplifyCredential;
        if (str != null) {
            try {
                Json.Default r0 = Json.Default;
                Object decodeFromString = r0.decodeFromString(ExceptionsKt.serializer(r0.serializersModule, Reflection.typeOf(AmplifyCredential.class)), str);
                Intrinsics.checkNotNull(decodeFromString, "null cannot be cast to non-null type com.amplifyframework.statemachine.codegen.data.AmplifyCredential");
                amplifyCredential = (AmplifyCredential) decodeFromString;
            } catch (Exception unused) {
                return AmplifyCredential.Empty.INSTANCE;
            }
        } else {
            amplifyCredential = null;
        }
        if (amplifyCredential == null) {
            return AmplifyCredential.Empty.INSTANCE;
        }
        return amplifyCredential;
    }

    private final DeviceMetadata deserializeMetadata(String str) {
        DeviceMetadata deviceMetadata;
        if (str != null) {
            try {
                Json.Default r0 = Json.Default;
                Object decodeFromString = r0.decodeFromString(ExceptionsKt.serializer(r0.serializersModule, Reflection.typeOf(DeviceMetadata.class)), str);
                Intrinsics.checkNotNull(decodeFromString, "null cannot be cast to non-null type com.amplifyframework.statemachine.codegen.data.DeviceMetadata");
                deviceMetadata = (DeviceMetadata) decodeFromString;
            } catch (Exception unused) {
                return DeviceMetadata.Empty.INSTANCE;
            }
        } else {
            deviceMetadata = null;
        }
        if (deviceMetadata == null) {
            return DeviceMetadata.Empty.INSTANCE;
        }
        return deviceMetadata;
    }

    private final String generateKey(String str) {
        String str2;
        UserPoolConfiguration userPool = this.authConfiguration.getUserPool();
        if (userPool != null) {
            str2 = "amplify." + userPool.getPoolId();
        } else {
            str2 = "amplify";
        }
        IdentityPoolConfiguration identityPool = this.authConfiguration.getIdentityPool();
        if (identityPool != null) {
            str2 = str2 + '.' + identityPool.getPoolId();
        }
        return str2 + '.' + str;
    }

    private final String serializeASFDevice(AmplifyCredential.ASFDevice aSFDevice) {
        Json.Default r0 = Json.Default;
        return r0.encodeToString(ExceptionsKt.serializer(r0.serializersModule, Reflection.typeOf(AmplifyCredential.ASFDevice.class)), aSFDevice);
    }

    private final String serializeCredential(AmplifyCredential amplifyCredential) {
        Json.Default r0 = Json.Default;
        return r0.encodeToString(ExceptionsKt.serializer(r0.serializersModule, Reflection.typeOf(AmplifyCredential.class)), amplifyCredential);
    }

    private final String serializeMetaData(DeviceMetadata deviceMetadata) {
        Json.Default r0 = Json.Default;
        return r0.encodeToString(ExceptionsKt.serializer(r0.serializersModule, Reflection.typeOf(DeviceMetadata.class)), deviceMetadata);
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public void deleteASFDevice() {
        this.keyValue.remove(generateKey(Key_ASFDevice));
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public void deleteCredential() {
        this.keyValue.remove(generateKey(Key_Session));
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public void deleteDeviceKeyCredential(String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        this.keyValue.remove(generateKey(username.concat(".deviceMetadata")));
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public AmplifyCredential.ASFDevice retrieveASFDevice() {
        return deserializeASFDevice(this.keyValue.get(generateKey(Key_ASFDevice)));
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public AmplifyCredential retrieveCredential() {
        return deserializeCredential(this.keyValue.get(generateKey(Key_Session)));
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public DeviceMetadata retrieveDeviceMetadata(String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        return deserializeMetadata(this.keyValue.get(generateKey(username.concat(".deviceMetadata"))));
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public void saveASFDevice(AmplifyCredential.ASFDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        this.keyValue.put(generateKey(Key_ASFDevice), serializeASFDevice(device));
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public void saveCredential(AmplifyCredential credential) {
        Intrinsics.checkNotNullParameter(credential, "credential");
        this.keyValue.put(generateKey(Key_Session), serializeCredential(credential));
    }

    @Override // com.amplifyframework.statemachine.codegen.data.AuthCredentialStore
    public void saveDeviceMetadata(String username, DeviceMetadata deviceMetadata) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(deviceMetadata, "deviceMetadata");
        this.keyValue.put(generateKey(username.concat(".deviceMetadata")), serializeMetaData(deviceMetadata));
    }

    public /* synthetic */ AWSCognitoAuthCredentialStore(Context context, AuthConfiguration authConfiguration, boolean z, KeyValueRepositoryFactory keyValueRepositoryFactory, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, authConfiguration, (r5 & 4) != 0 ? true : z, (r5 & 8) != 0 ? new KeyValueRepositoryFactory() : keyValueRepositoryFactory);
    }
}
