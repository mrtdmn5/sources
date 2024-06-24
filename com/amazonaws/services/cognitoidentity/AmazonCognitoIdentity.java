package com.amazonaws.services.cognitoidentity;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolRequest;
import com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolResult;
import com.amazonaws.services.cognitoidentity.model.DeleteIdentitiesRequest;
import com.amazonaws.services.cognitoidentity.model.DeleteIdentitiesResult;
import com.amazonaws.services.cognitoidentity.model.DeleteIdentityPoolRequest;
import com.amazonaws.services.cognitoidentity.model.DescribeIdentityPoolRequest;
import com.amazonaws.services.cognitoidentity.model.DescribeIdentityPoolResult;
import com.amazonaws.services.cognitoidentity.model.DescribeIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.DescribeIdentityResult;
import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityResult;
import com.amazonaws.services.cognitoidentity.model.GetIdRequest;
import com.amazonaws.services.cognitoidentity.model.GetIdResult;
import com.amazonaws.services.cognitoidentity.model.GetIdentityPoolRolesRequest;
import com.amazonaws.services.cognitoidentity.model.GetIdentityPoolRolesResult;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityResult;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenRequest;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenResult;
import com.amazonaws.services.cognitoidentity.model.GetPrincipalTagAttributeMapRequest;
import com.amazonaws.services.cognitoidentity.model.GetPrincipalTagAttributeMapResult;
import com.amazonaws.services.cognitoidentity.model.ListIdentitiesRequest;
import com.amazonaws.services.cognitoidentity.model.ListIdentitiesResult;
import com.amazonaws.services.cognitoidentity.model.ListIdentityPoolsRequest;
import com.amazonaws.services.cognitoidentity.model.ListIdentityPoolsResult;
import com.amazonaws.services.cognitoidentity.model.ListTagsForResourceRequest;
import com.amazonaws.services.cognitoidentity.model.ListTagsForResourceResult;
import com.amazonaws.services.cognitoidentity.model.LookupDeveloperIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.LookupDeveloperIdentityResult;
import com.amazonaws.services.cognitoidentity.model.MergeDeveloperIdentitiesRequest;
import com.amazonaws.services.cognitoidentity.model.MergeDeveloperIdentitiesResult;
import com.amazonaws.services.cognitoidentity.model.SetIdentityPoolRolesRequest;
import com.amazonaws.services.cognitoidentity.model.SetPrincipalTagAttributeMapRequest;
import com.amazonaws.services.cognitoidentity.model.SetPrincipalTagAttributeMapResult;
import com.amazonaws.services.cognitoidentity.model.TagResourceRequest;
import com.amazonaws.services.cognitoidentity.model.TagResourceResult;
import com.amazonaws.services.cognitoidentity.model.UnlinkDeveloperIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.UnlinkIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.UntagResourceRequest;
import com.amazonaws.services.cognitoidentity.model.UntagResourceResult;
import com.amazonaws.services.cognitoidentity.model.UpdateIdentityPoolRequest;
import com.amazonaws.services.cognitoidentity.model.UpdateIdentityPoolResult;

/* loaded from: classes.dex */
public interface AmazonCognitoIdentity {
    CreateIdentityPoolResult createIdentityPool(CreateIdentityPoolRequest createIdentityPoolRequest) throws AmazonClientException, AmazonServiceException;

    DeleteIdentitiesResult deleteIdentities(DeleteIdentitiesRequest deleteIdentitiesRequest) throws AmazonClientException, AmazonServiceException;

    void deleteIdentityPool(DeleteIdentityPoolRequest deleteIdentityPoolRequest) throws AmazonClientException, AmazonServiceException;

    DescribeIdentityResult describeIdentity(DescribeIdentityRequest describeIdentityRequest) throws AmazonClientException, AmazonServiceException;

    DescribeIdentityPoolResult describeIdentityPool(DescribeIdentityPoolRequest describeIdentityPoolRequest) throws AmazonClientException, AmazonServiceException;

    ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest);

    GetCredentialsForIdentityResult getCredentialsForIdentity(GetCredentialsForIdentityRequest getCredentialsForIdentityRequest) throws AmazonClientException, AmazonServiceException;

    GetIdResult getId(GetIdRequest getIdRequest) throws AmazonClientException, AmazonServiceException;

    GetIdentityPoolRolesResult getIdentityPoolRoles(GetIdentityPoolRolesRequest getIdentityPoolRolesRequest) throws AmazonClientException, AmazonServiceException;

    GetOpenIdTokenResult getOpenIdToken(GetOpenIdTokenRequest getOpenIdTokenRequest) throws AmazonClientException, AmazonServiceException;

    GetOpenIdTokenForDeveloperIdentityResult getOpenIdTokenForDeveloperIdentity(GetOpenIdTokenForDeveloperIdentityRequest getOpenIdTokenForDeveloperIdentityRequest) throws AmazonClientException, AmazonServiceException;

    GetPrincipalTagAttributeMapResult getPrincipalTagAttributeMap(GetPrincipalTagAttributeMapRequest getPrincipalTagAttributeMapRequest) throws AmazonClientException, AmazonServiceException;

    ListIdentitiesResult listIdentities(ListIdentitiesRequest listIdentitiesRequest) throws AmazonClientException, AmazonServiceException;

    ListIdentityPoolsResult listIdentityPools(ListIdentityPoolsRequest listIdentityPoolsRequest) throws AmazonClientException, AmazonServiceException;

    ListTagsForResourceResult listTagsForResource(ListTagsForResourceRequest listTagsForResourceRequest) throws AmazonClientException, AmazonServiceException;

    LookupDeveloperIdentityResult lookupDeveloperIdentity(LookupDeveloperIdentityRequest lookupDeveloperIdentityRequest) throws AmazonClientException, AmazonServiceException;

    MergeDeveloperIdentitiesResult mergeDeveloperIdentities(MergeDeveloperIdentitiesRequest mergeDeveloperIdentitiesRequest) throws AmazonClientException, AmazonServiceException;

    void setEndpoint(String str) throws IllegalArgumentException;

    void setIdentityPoolRoles(SetIdentityPoolRolesRequest setIdentityPoolRolesRequest) throws AmazonClientException, AmazonServiceException;

    SetPrincipalTagAttributeMapResult setPrincipalTagAttributeMap(SetPrincipalTagAttributeMapRequest setPrincipalTagAttributeMapRequest) throws AmazonClientException, AmazonServiceException;

    void setRegion(Region region) throws IllegalArgumentException;

    void shutdown();

    TagResourceResult tagResource(TagResourceRequest tagResourceRequest) throws AmazonClientException, AmazonServiceException;

    void unlinkDeveloperIdentity(UnlinkDeveloperIdentityRequest unlinkDeveloperIdentityRequest) throws AmazonClientException, AmazonServiceException;

    void unlinkIdentity(UnlinkIdentityRequest unlinkIdentityRequest) throws AmazonClientException, AmazonServiceException;

    UntagResourceResult untagResource(UntagResourceRequest untagResourceRequest) throws AmazonClientException, AmazonServiceException;

    UpdateIdentityPoolResult updateIdentityPool(UpdateIdentityPoolRequest updateIdentityPoolRequest) throws AmazonClientException, AmazonServiceException;
}
