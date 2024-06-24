package com.amazonaws.services.securitytoken.model.transform;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.FederatedUser;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
class FederatedUserStaxMarshaller {
    private static FederatedUserStaxMarshaller instance;

    public static FederatedUserStaxMarshaller getInstance() {
        if (instance == null) {
            instance = new FederatedUserStaxMarshaller();
        }
        return instance;
    }

    public void marshall(FederatedUser federatedUser, Request<?> request, String str) {
        if (federatedUser.getFederatedUserId() != null) {
            request.addParameter(ComposableInvoker$$ExternalSyntheticOutline0.m(str, "FederatedUserId"), StringUtils.fromString(federatedUser.getFederatedUserId()));
        }
        if (federatedUser.getArn() != null) {
            request.addParameter(ComposableInvoker$$ExternalSyntheticOutline0.m(str, "Arn"), StringUtils.fromString(federatedUser.getArn()));
        }
    }
}
