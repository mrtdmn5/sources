package com.amplifyframework.auth.cognito.asf;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import java.util.Map;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserContextDataProvider.kt */
/* loaded from: classes.dex */
public final class UserContextDataProvider {
    private static final String CONTEXT_DATA = "contextData";
    private static final String DATA_PAYLOAD = "payload";
    private static final String SIGNATURE = "signature";
    private static final String TIMESTAMP_MILLI_SEC = "timestamp";
    private static final String USERNAME = "username";
    private static final String USER_POOL_ID = "userPoolId";
    private static final String VERSION_KEY = "version";
    private static final String VERSION_VALUE = "ANDROID20171114";
    private ContextDataAggregator aggregator;
    private final String clientId;
    private final Context context;
    private final String poolId;
    private final String timestamp;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "UserContextDataProvider";

    /* compiled from: UserContextDataProvider.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public UserContextDataProvider(Context context, String poolId, String clientId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(poolId, "poolId");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        this.context = context;
        this.poolId = poolId;
        this.clientId = clientId;
        this.timestamp = String.valueOf(System.currentTimeMillis());
    }

    private final String getEncodedResponse(JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonResponse.toString()");
        byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 0);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(bytes, Base64.DEFAULT)");
        return encodeToString;
    }

    private final JSONObject getJsonPayload(Map<String, String> map, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CONTEXT_DATA, new JSONObject(map));
        jSONObject.put(USERNAME, str);
        jSONObject.put(USER_POOL_ID, str2);
        jSONObject.put("timestamp", this.timestamp);
        return jSONObject;
    }

    private final JSONObject getJsonResponse(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(DATA_PAYLOAD, str);
        jSONObject.put(SIGNATURE, str2);
        jSONObject.put("version", VERSION_VALUE);
        return jSONObject;
    }

    public final String getEncodedContextData(String username, final String deviceId) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        try {
            ContextDataAggregator contextDataAggregator = (ContextDataAggregator) LazyKt__LazyJVMKt.lazy(new Function0<ContextDataAggregator>() { // from class: com.amplifyframework.auth.cognito.asf.UserContextDataProvider$getEncodedContextData$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ContextDataAggregator invoke() {
                    return new ContextDataAggregator(deviceId);
                }
            }).getValue();
            this.aggregator = contextDataAggregator;
            if (contextDataAggregator != null) {
                String jSONObject = getJsonPayload(contextDataAggregator.getAggregatedData(this.context), username, this.poolId).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "payload.toString()");
                return getEncodedResponse(getJsonResponse(jSONObject, SignatureGenerator.Companion.getSignature(jSONObject, this.clientId, VERSION_VALUE)));
            }
            Intrinsics.throwUninitializedPropertyAccessException("aggregator");
            throw null;
        } catch (Exception unused) {
            Log.e(TAG, "Exception in creating JSON from context data");
            return null;
        }
    }
}
