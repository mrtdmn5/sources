package com.amazonaws.services.securitytoken.model.transform;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.Tag;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
class TagStaxMarshaller {
    private static TagStaxMarshaller instance;

    public static TagStaxMarshaller getInstance() {
        if (instance == null) {
            instance = new TagStaxMarshaller();
        }
        return instance;
    }

    public void marshall(Tag tag, Request<?> request, String str) {
        if (tag.getKey() != null) {
            request.addParameter(ComposableInvoker$$ExternalSyntheticOutline0.m(str, "Key"), StringUtils.fromString(tag.getKey()));
        }
        if (tag.getValue() != null) {
            request.addParameter(ComposableInvoker$$ExternalSyntheticOutline0.m(str, "Value"), StringUtils.fromString(tag.getValue()));
        }
    }
}
