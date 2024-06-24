package com.amazonaws.services.securitytoken.model.transform;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
public class AssumeRoleWithWebIdentityRequestMarshaller implements Marshaller<Request<AssumeRoleWithWebIdentityRequest>, AssumeRoleWithWebIdentityRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AssumeRoleWithWebIdentityRequest> marshall(AssumeRoleWithWebIdentityRequest assumeRoleWithWebIdentityRequest) {
        if (assumeRoleWithWebIdentityRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(assumeRoleWithWebIdentityRequest, "AWSSecurityTokenService");
            defaultRequest.addParameter(JsonDocumentFields.ACTION, "AssumeRoleWithWebIdentity");
            defaultRequest.addParameter(JsonDocumentFields.VERSION, "2011-06-15");
            if (assumeRoleWithWebIdentityRequest.getRoleArn() != null) {
                defaultRequest.addParameter("RoleArn", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getRoleArn()));
            }
            if (assumeRoleWithWebIdentityRequest.getRoleSessionName() != null) {
                defaultRequest.addParameter("RoleSessionName", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getRoleSessionName()));
            }
            if (assumeRoleWithWebIdentityRequest.getWebIdentityToken() != null) {
                defaultRequest.addParameter("WebIdentityToken", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getWebIdentityToken()));
            }
            if (assumeRoleWithWebIdentityRequest.getProviderId() != null) {
                defaultRequest.addParameter("ProviderId", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getProviderId()));
            }
            if (assumeRoleWithWebIdentityRequest.getPolicyArns() != null) {
                int r2 = 1;
                for (PolicyDescriptorType policyDescriptorType : assumeRoleWithWebIdentityRequest.getPolicyArns()) {
                    String m = SubMenuBuilder$$ExternalSyntheticOutline0.m("PolicyArns.member.", r2);
                    if (policyDescriptorType != null) {
                        PolicyDescriptorTypeStaxMarshaller.getInstance().marshall(policyDescriptorType, defaultRequest, ComposableInvoker$$ExternalSyntheticOutline0.m(m, InstructionFileId.DOT));
                    }
                    r2++;
                }
            }
            if (assumeRoleWithWebIdentityRequest.getPolicy() != null) {
                defaultRequest.addParameter("Policy", StringUtils.fromString(assumeRoleWithWebIdentityRequest.getPolicy()));
            }
            if (assumeRoleWithWebIdentityRequest.getDurationSeconds() != null) {
                defaultRequest.addParameter("DurationSeconds", StringUtils.fromInteger(assumeRoleWithWebIdentityRequest.getDurationSeconds()));
            }
            return defaultRequest;
        }
        throw new AmazonClientException("Invalid argument passed to marshall(AssumeRoleWithWebIdentityRequest)");
    }
}
