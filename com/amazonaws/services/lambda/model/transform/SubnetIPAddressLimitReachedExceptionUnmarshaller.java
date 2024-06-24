package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.SubnetIPAddressLimitReachedException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class SubnetIPAddressLimitReachedExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public SubnetIPAddressLimitReachedExceptionUnmarshaller() {
        super(SubnetIPAddressLimitReachedException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("SubnetIPAddressLimitReachedException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        SubnetIPAddressLimitReachedException subnetIPAddressLimitReachedException = (SubnetIPAddressLimitReachedException) super.unmarshall(jsonErrorResponse);
        subnetIPAddressLimitReachedException.setErrorCode("SubnetIPAddressLimitReachedException");
        subnetIPAddressLimitReachedException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return subnetIPAddressLimitReachedException;
    }
}
