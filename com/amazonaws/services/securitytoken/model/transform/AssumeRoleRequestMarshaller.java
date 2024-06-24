package com.amazonaws.services.securitytoken.model.transform;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazonaws.services.securitytoken.model.Tag;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
public class AssumeRoleRequestMarshaller implements Marshaller<Request<AssumeRoleRequest>, AssumeRoleRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AssumeRoleRequest> marshall(AssumeRoleRequest assumeRoleRequest) {
        if (assumeRoleRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(assumeRoleRequest, "AWSSecurityTokenService");
            defaultRequest.addParameter(JsonDocumentFields.ACTION, "AssumeRole");
            defaultRequest.addParameter(JsonDocumentFields.VERSION, "2011-06-15");
            if (assumeRoleRequest.getRoleArn() != null) {
                defaultRequest.addParameter("RoleArn", StringUtils.fromString(assumeRoleRequest.getRoleArn()));
            }
            if (assumeRoleRequest.getRoleSessionName() != null) {
                defaultRequest.addParameter("RoleSessionName", StringUtils.fromString(assumeRoleRequest.getRoleSessionName()));
            }
            int r3 = 1;
            if (assumeRoleRequest.getPolicyArns() != null) {
                int r4 = 1;
                for (PolicyDescriptorType policyDescriptorType : assumeRoleRequest.getPolicyArns()) {
                    String m = SubMenuBuilder$$ExternalSyntheticOutline0.m("PolicyArns.member.", r4);
                    if (policyDescriptorType != null) {
                        PolicyDescriptorTypeStaxMarshaller.getInstance().marshall(policyDescriptorType, defaultRequest, ComposableInvoker$$ExternalSyntheticOutline0.m(m, InstructionFileId.DOT));
                    }
                    r4++;
                }
            }
            if (assumeRoleRequest.getPolicy() != null) {
                defaultRequest.addParameter("Policy", StringUtils.fromString(assumeRoleRequest.getPolicy()));
            }
            if (assumeRoleRequest.getDurationSeconds() != null) {
                defaultRequest.addParameter("DurationSeconds", StringUtils.fromInteger(assumeRoleRequest.getDurationSeconds()));
            }
            if (assumeRoleRequest.getTags() != null) {
                int r42 = 1;
                for (Tag tag : assumeRoleRequest.getTags()) {
                    String m2 = SubMenuBuilder$$ExternalSyntheticOutline0.m("Tags.member.", r42);
                    if (tag != null) {
                        TagStaxMarshaller.getInstance().marshall(tag, defaultRequest, ComposableInvoker$$ExternalSyntheticOutline0.m(m2, InstructionFileId.DOT));
                    }
                    r42++;
                }
            }
            if (assumeRoleRequest.getTransitiveTagKeys() != null) {
                for (String str : assumeRoleRequest.getTransitiveTagKeys()) {
                    String m3 = SubMenuBuilder$$ExternalSyntheticOutline0.m("TransitiveTagKeys.member.", r3);
                    if (str != null) {
                        defaultRequest.addParameter(m3, StringUtils.fromString(str));
                    }
                    r3++;
                }
            }
            if (assumeRoleRequest.getExternalId() != null) {
                defaultRequest.addParameter("ExternalId", StringUtils.fromString(assumeRoleRequest.getExternalId()));
            }
            if (assumeRoleRequest.getSerialNumber() != null) {
                defaultRequest.addParameter("SerialNumber", StringUtils.fromString(assumeRoleRequest.getSerialNumber()));
            }
            if (assumeRoleRequest.getTokenCode() != null) {
                defaultRequest.addParameter("TokenCode", StringUtils.fromString(assumeRoleRequest.getTokenCode()));
            }
            if (assumeRoleRequest.getSourceIdentity() != null) {
                defaultRequest.addParameter("SourceIdentity", StringUtils.fromString(assumeRoleRequest.getSourceIdentity()));
            }
            return defaultRequest;
        }
        throw new AmazonClientException("Invalid argument passed to marshall(AssumeRoleRequest)");
    }
}
