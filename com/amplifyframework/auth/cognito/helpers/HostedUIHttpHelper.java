package com.amplifyframework.auth.cognito.helpers;

import com.amazonaws.services.s3.internal.Constants;
import com.amplifyframework.auth.cognito.exceptions.service.InvalidGrantException;
import com.amplifyframework.auth.cognito.exceptions.service.ParseTokenException;
import com.amplifyframework.auth.exceptions.ServiceException;
import com.amplifyframework.statemachine.codegen.data.CognitoUserPoolTokens;
import com.animaconnected.secondo.notification.model.Contact;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: HostedUIHttpHelper.kt */
/* loaded from: classes.dex */
public final class HostedUIHttpHelper {
    public static final HostedUIHttpHelper INSTANCE = new HostedUIHttpHelper();
    private static final Json json = JsonKt.Json$default(new Function1<JsonBuilder, Unit>() { // from class: com.amplifyframework.auth.cognito.helpers.HostedUIHttpHelper$json$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.ignoreUnknownKeys = true;
        }
    });

    private HostedUIHttpHelper() {
    }

    private final CognitoUserPoolTokens parseTokenResponse(String str) {
        boolean z;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            try {
                Json json2 = json;
                FetchTokenResponse fetchTokenResponse = (FetchTokenResponse) json2.decodeFromString(ExceptionsKt.serializer(json2.serializersModule, Reflection.typeOf(FetchTokenResponse.class)), str);
                String error = fetchTokenResponse.getError();
                if (error != null) {
                    if (Intrinsics.areEqual(error, "invalid_grant")) {
                        throw new InvalidGrantException(error);
                    }
                    throw new ServiceException(error, "Sorry, we don't have a suggested fix for this error yet.", null, 4, null);
                }
                return new CognitoUserPoolTokens(fetchTokenResponse.getIdToken(), fetchTokenResponse.getAccessToken(), fetchTokenResponse.getRefreshToken(), fetchTokenResponse.getExpiration());
            } catch (Exception e) {
                String message = e.getMessage();
                if (message == null) {
                    message = "An unknown service error has occurred";
                }
                throw new ServiceException(message, "Sorry, we don't have a suggested fix for this error yet.", e);
            }
        }
        throw new ParseTokenException();
    }

    public final CognitoUserPoolTokens fetchTokens(URL url, Map<String, String> headerParams, Map<String, String> bodyParams) throws Exception {
        InputStream responseStream;
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headerParams, "headerParams");
        Intrinsics.checkNotNullParameter(bodyParams, "bodyParams");
        URLConnection openConnection = url.openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setDoOutput(true);
        ArrayList arrayList = new ArrayList(headerParams.size());
        for (Map.Entry<String, String> entry : headerParams.entrySet()) {
            httpsURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            arrayList.add(Unit.INSTANCE);
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        try {
            ArrayList arrayList2 = new ArrayList(bodyParams.size());
            for (Map.Entry<String, String> entry2 : bodyParams.entrySet()) {
                arrayList2.add(URLEncoder.encode(entry2.getKey(), Constants.DEFAULT_ENCODING) + '=' + URLEncoder.encode(entry2.getValue(), Constants.DEFAULT_ENCODING));
            }
            dataOutputStream.writeBytes(CollectionsKt___CollectionsKt.joinToString$default(arrayList2, Contact.PHONE_NUMBERS_DELIMITER, null, null, null, 62));
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(dataOutputStream, null);
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode >= 200 && responseCode < 500) {
                if (responseCode < 300) {
                    responseStream = httpsURLConnection.getInputStream();
                } else {
                    responseStream = httpsURLConnection.getErrorStream();
                }
                Intrinsics.checkNotNullExpressionValue(responseStream, "responseStream");
                Reader inputStreamReader = new InputStreamReader(responseStream, Charsets.UTF_8);
                if (inputStreamReader instanceof BufferedReader) {
                    bufferedReader = (BufferedReader) inputStreamReader;
                } else {
                    bufferedReader = new BufferedReader(inputStreamReader, DfuBaseService.ERROR_REMOTE_MASK);
                }
                try {
                    String readText = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    return parseTokenResponse(readText);
                } finally {
                }
            } else {
                String responseMessage = httpsURLConnection.getResponseMessage();
                Intrinsics.checkNotNullExpressionValue(responseMessage, "connection.responseMessage");
                throw new ServiceException(responseMessage, "Sorry, we don't have a suggested fix for this error yet.", null, 4, null);
            }
        } finally {
        }
    }
}
