package com.amazonaws.services.securitytoken.model.transform;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.services.securitytoken.model.GetFederationTokenRequest;
import com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazonaws.services.securitytoken.model.Tag;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
public class GetFederationTokenRequestMarshaller implements Marshaller<Request<GetFederationTokenRequest>, GetFederationTokenRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<GetFederationTokenRequest> marshall(GetFederationTokenRequest getFederationTokenRequest) {
        if (getFederationTokenRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(getFederationTokenRequest, "AWSSecurityTokenService");
            defaultRequest.addParameter(JsonDocumentFields.ACTION, "GetFederationToken");
            defaultRequest.addParameter(JsonDocumentFields.VERSION, "2011-06-15");
            if (getFederationTokenRequest.getName() != null) {
                defaultRequest.addParameter("Name", StringUtils.fromString(getFederationTokenRequest.getName()));
            }
            if (getFederationTokenRequest.getPolicy() != null) {
                defaultRequest.addParameter("Policy", StringUtils.fromString(getFederationTokenRequest.getPolicy()));
            }
            int r3 = 1;
            if (getFederationTokenRequest.getPolicyArns() != null) {
                int r4 = 1;
                for (PolicyDescriptorType policyDescriptorType : getFederationTokenRequest.getPolicyArns()) {
                    String m = SubMenuBuilder$$ExternalSyntheticOutline0.m("PolicyArns.member.", r4);
                    if (policyDescriptorType != null) {
                        PolicyDescriptorTypeStaxMarshaller.getInstance().marshall(policyDescriptorType, defaultRequest, ComposableInvoker$$ExternalSyntheticOutline0.m(m, InstructionFileId.DOT));
                    }
                    r4++;
                }
            }
            if (getFederationTokenRequest.getDurationSeconds() != null) {
                defaultRequest.addParameter("DurationSeconds", StringUtils.fromInteger(getFederationTokenRequest.getDurationSeconds()));
            }
            if (getFederationTokenRequest.getTags() != null) {
                for (Tag tag : getFederationTokenRequest.getTags()) {
                    String m2 = SubMenuBuilder$$ExternalSyntheticOutline0.m("Tags.member.", r3);
                    if (tag != null) {
                        TagStaxMarshaller.getInstance().marshall(tag, defaultRequest, ComposableInvoker$$ExternalSyntheticOutline0.m(m2, InstructionFileId.DOT));
                    }
                    r3++;
                }
            }
            return defaultRequest;
        }
        throw new AmazonClientException("Invalid argument passed to marshall(GetFederationTokenRequest)");
    }
}
