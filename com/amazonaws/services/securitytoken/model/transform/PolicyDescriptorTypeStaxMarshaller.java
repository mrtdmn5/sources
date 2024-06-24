package com.amazonaws.services.securitytoken.model.transform;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
class PolicyDescriptorTypeStaxMarshaller {
    private static PolicyDescriptorTypeStaxMarshaller instance;

    public static PolicyDescriptorTypeStaxMarshaller getInstance() {
        if (instance == null) {
            instance = new PolicyDescriptorTypeStaxMarshaller();
        }
        return instance;
    }

    public void marshall(PolicyDescriptorType policyDescriptorType, Request<?> request, String str) {
        if (policyDescriptorType.getArn() != null) {
            request.addParameter(ComposableInvoker$$ExternalSyntheticOutline0.m(str, "arn"), StringUtils.fromString(policyDescriptorType.getArn()));
        }
    }
}
