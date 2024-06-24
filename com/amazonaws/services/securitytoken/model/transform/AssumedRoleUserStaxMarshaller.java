package com.amazonaws.services.securitytoken.model.transform;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.AssumedRoleUser;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
class AssumedRoleUserStaxMarshaller {
    private static AssumedRoleUserStaxMarshaller instance;

    public static AssumedRoleUserStaxMarshaller getInstance() {
        if (instance == null) {
            instance = new AssumedRoleUserStaxMarshaller();
        }
        return instance;
    }

    public void marshall(AssumedRoleUser assumedRoleUser, Request<?> request, String str) {
        if (assumedRoleUser.getAssumedRoleId() != null) {
            request.addParameter(ComposableInvoker$$ExternalSyntheticOutline0.m(str, "AssumedRoleId"), StringUtils.fromString(assumedRoleUser.getAssumedRoleId()));
        }
        if (assumedRoleUser.getArn() != null) {
            request.addParameter(ComposableInvoker$$ExternalSyntheticOutline0.m(str, "Arn"), StringUtils.fromString(assumedRoleUser.getArn()));
        }
    }
}
