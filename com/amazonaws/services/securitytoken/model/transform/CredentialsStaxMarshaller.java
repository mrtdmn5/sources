package com.amazonaws.services.securitytoken.model.transform;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.Credentials;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
class CredentialsStaxMarshaller {
    private static CredentialsStaxMarshaller instance;

    public static CredentialsStaxMarshaller getInstance() {
        if (instance == null) {
            instance = new CredentialsStaxMarshaller();
        }
        return instance;
    }

    public void marshall(Credentials credentials, Request<?> request, String str) {
        if (credentials.getAccessKeyId() != null) {
            request.addParameter(ComposableInvoker$$ExternalSyntheticOutline0.m(str, "AccessKeyId"), StringUtils.fromString(credentials.getAccessKeyId()));
        }
        if (credentials.getSecretAccessKey() != null) {
            request.addParameter(ComposableInvoker$$ExternalSyntheticOutline0.m(str, "SecretAccessKey"), StringUtils.fromString(credentials.getSecretAccessKey()));
        }
        if (credentials.getSessionToken() != null) {
            request.addParameter(ComposableInvoker$$ExternalSyntheticOutline0.m(str, "SessionToken"), StringUtils.fromString(credentials.getSessionToken()));
        }
        if (credentials.getExpiration() != null) {
            request.addParameter(ComposableInvoker$$ExternalSyntheticOutline0.m(str, "Expiration"), StringUtils.fromDate(credentials.getExpiration()));
        }
    }
}
