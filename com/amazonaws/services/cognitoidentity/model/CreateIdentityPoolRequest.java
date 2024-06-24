package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CreateIdentityPoolRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean allowClassicFlow;
    private Boolean allowUnauthenticatedIdentities;
    private List<CognitoIdentityProvider> cognitoIdentityProviders;
    private String developerProviderName;
    private String identityPoolName;
    private Map<String, String> identityPoolTags;
    private List<String> openIdConnectProviderARNs;
    private List<String> samlProviderARNs;
    private Map<String, String> supportedLoginProviders;

    public CreateIdentityPoolRequest addIdentityPoolTagsEntry(String str, String str2) {
        if (this.identityPoolTags == null) {
            this.identityPoolTags = new HashMap();
        }
        if (!this.identityPoolTags.containsKey(str)) {
            this.identityPoolTags.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public CreateIdentityPoolRequest addSupportedLoginProvidersEntry(String str, String str2) {
        if (this.supportedLoginProviders == null) {
            this.supportedLoginProviders = new HashMap();
        }
        if (!this.supportedLoginProviders.containsKey(str)) {
            this.supportedLoginProviders.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public CreateIdentityPoolRequest clearIdentityPoolTagsEntries() {
        this.identityPoolTags = null;
        return this;
    }

    public CreateIdentityPoolRequest clearSupportedLoginProvidersEntries() {
        this.supportedLoginProviders = null;
        return this;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateIdentityPoolRequest)) {
            return false;
        }
        CreateIdentityPoolRequest createIdentityPoolRequest = (CreateIdentityPoolRequest) obj;
        if (createIdentityPoolRequest.getIdentityPoolName() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getIdentityPoolName() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (createIdentityPoolRequest.getIdentityPoolName() != null && !createIdentityPoolRequest.getIdentityPoolName().equals(getIdentityPoolName())) {
            return false;
        }
        if (createIdentityPoolRequest.getAllowUnauthenticatedIdentities() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getAllowUnauthenticatedIdentities() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (createIdentityPoolRequest.getAllowUnauthenticatedIdentities() != null && !createIdentityPoolRequest.getAllowUnauthenticatedIdentities().equals(getAllowUnauthenticatedIdentities())) {
            return false;
        }
        if (createIdentityPoolRequest.getAllowClassicFlow() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getAllowClassicFlow() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (createIdentityPoolRequest.getAllowClassicFlow() != null && !createIdentityPoolRequest.getAllowClassicFlow().equals(getAllowClassicFlow())) {
            return false;
        }
        if (createIdentityPoolRequest.getSupportedLoginProviders() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getSupportedLoginProviders() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (createIdentityPoolRequest.getSupportedLoginProviders() != null && !createIdentityPoolRequest.getSupportedLoginProviders().equals(getSupportedLoginProviders())) {
            return false;
        }
        if (createIdentityPoolRequest.getDeveloperProviderName() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getDeveloperProviderName() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (createIdentityPoolRequest.getDeveloperProviderName() != null && !createIdentityPoolRequest.getDeveloperProviderName().equals(getDeveloperProviderName())) {
            return false;
        }
        if (createIdentityPoolRequest.getOpenIdConnectProviderARNs() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getOpenIdConnectProviderARNs() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (createIdentityPoolRequest.getOpenIdConnectProviderARNs() != null && !createIdentityPoolRequest.getOpenIdConnectProviderARNs().equals(getOpenIdConnectProviderARNs())) {
            return false;
        }
        if (createIdentityPoolRequest.getCognitoIdentityProviders() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (getCognitoIdentityProviders() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z13 ^ z14) {
            return false;
        }
        if (createIdentityPoolRequest.getCognitoIdentityProviders() != null && !createIdentityPoolRequest.getCognitoIdentityProviders().equals(getCognitoIdentityProviders())) {
            return false;
        }
        if (createIdentityPoolRequest.getSamlProviderARNs() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (getSamlProviderARNs() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z15 ^ z16) {
            return false;
        }
        if (createIdentityPoolRequest.getSamlProviderARNs() != null && !createIdentityPoolRequest.getSamlProviderARNs().equals(getSamlProviderARNs())) {
            return false;
        }
        if (createIdentityPoolRequest.getIdentityPoolTags() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (getIdentityPoolTags() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 ^ z18) {
            return false;
        }
        if (createIdentityPoolRequest.getIdentityPoolTags() == null || createIdentityPoolRequest.getIdentityPoolTags().equals(getIdentityPoolTags())) {
            return true;
        }
        return false;
    }

    public Boolean getAllowClassicFlow() {
        return this.allowClassicFlow;
    }

    public Boolean getAllowUnauthenticatedIdentities() {
        return this.allowUnauthenticatedIdentities;
    }

    public List<CognitoIdentityProvider> getCognitoIdentityProviders() {
        return this.cognitoIdentityProviders;
    }

    public String getDeveloperProviderName() {
        return this.developerProviderName;
    }

    public String getIdentityPoolName() {
        return this.identityPoolName;
    }

    public Map<String, String> getIdentityPoolTags() {
        return this.identityPoolTags;
    }

    public List<String> getOpenIdConnectProviderARNs() {
        return this.openIdConnectProviderARNs;
    }

    public List<String> getSamlProviderARNs() {
        return this.samlProviderARNs;
    }

    public Map<String, String> getSupportedLoginProviders() {
        return this.supportedLoginProviders;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int r1 = 0;
        if (getIdentityPoolName() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityPoolName().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getAllowUnauthenticatedIdentities() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAllowUnauthenticatedIdentities().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getAllowClassicFlow() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getAllowClassicFlow().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getSupportedLoginProviders() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getSupportedLoginProviders().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getDeveloperProviderName() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getDeveloperProviderName().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getOpenIdConnectProviderARNs() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getOpenIdConnectProviderARNs().hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        if (getCognitoIdentityProviders() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getCognitoIdentityProviders().hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        if (getSamlProviderARNs() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getSamlProviderARNs().hashCode();
        }
        int r08 = (r07 + hashCode8) * 31;
        if (getIdentityPoolTags() != null) {
            r1 = getIdentityPoolTags().hashCode();
        }
        return r08 + r1;
    }

    public Boolean isAllowClassicFlow() {
        return this.allowClassicFlow;
    }

    public Boolean isAllowUnauthenticatedIdentities() {
        return this.allowUnauthenticatedIdentities;
    }

    public void setAllowClassicFlow(Boolean bool) {
        this.allowClassicFlow = bool;
    }

    public void setAllowUnauthenticatedIdentities(Boolean bool) {
        this.allowUnauthenticatedIdentities = bool;
    }

    public void setCognitoIdentityProviders(Collection<CognitoIdentityProvider> collection) {
        if (collection == null) {
            this.cognitoIdentityProviders = null;
        } else {
            this.cognitoIdentityProviders = new ArrayList(collection);
        }
    }

    public void setDeveloperProviderName(String str) {
        this.developerProviderName = str;
    }

    public void setIdentityPoolName(String str) {
        this.identityPoolName = str;
    }

    public void setIdentityPoolTags(Map<String, String> map) {
        this.identityPoolTags = map;
    }

    public void setOpenIdConnectProviderARNs(Collection<String> collection) {
        if (collection == null) {
            this.openIdConnectProviderARNs = null;
        } else {
            this.openIdConnectProviderARNs = new ArrayList(collection);
        }
    }

    public void setSamlProviderARNs(Collection<String> collection) {
        if (collection == null) {
            this.samlProviderARNs = null;
        } else {
            this.samlProviderARNs = new ArrayList(collection);
        }
    }

    public void setSupportedLoginProviders(Map<String, String> map) {
        this.supportedLoginProviders = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityPoolName() != null) {
            sb.append("IdentityPoolName: " + getIdentityPoolName() + ",");
        }
        if (getAllowUnauthenticatedIdentities() != null) {
            sb.append("AllowUnauthenticatedIdentities: " + getAllowUnauthenticatedIdentities() + ",");
        }
        if (getAllowClassicFlow() != null) {
            sb.append("AllowClassicFlow: " + getAllowClassicFlow() + ",");
        }
        if (getSupportedLoginProviders() != null) {
            sb.append("SupportedLoginProviders: " + getSupportedLoginProviders() + ",");
        }
        if (getDeveloperProviderName() != null) {
            sb.append("DeveloperProviderName: " + getDeveloperProviderName() + ",");
        }
        if (getOpenIdConnectProviderARNs() != null) {
            sb.append("OpenIdConnectProviderARNs: " + getOpenIdConnectProviderARNs() + ",");
        }
        if (getCognitoIdentityProviders() != null) {
            sb.append("CognitoIdentityProviders: " + getCognitoIdentityProviders() + ",");
        }
        if (getSamlProviderARNs() != null) {
            sb.append("SamlProviderARNs: " + getSamlProviderARNs() + ",");
        }
        if (getIdentityPoolTags() != null) {
            sb.append("IdentityPoolTags: " + getIdentityPoolTags());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateIdentityPoolRequest withAllowClassicFlow(Boolean bool) {
        this.allowClassicFlow = bool;
        return this;
    }

    public CreateIdentityPoolRequest withAllowUnauthenticatedIdentities(Boolean bool) {
        this.allowUnauthenticatedIdentities = bool;
        return this;
    }

    public CreateIdentityPoolRequest withCognitoIdentityProviders(CognitoIdentityProvider... cognitoIdentityProviderArr) {
        if (getCognitoIdentityProviders() == null) {
            this.cognitoIdentityProviders = new ArrayList(cognitoIdentityProviderArr.length);
        }
        for (CognitoIdentityProvider cognitoIdentityProvider : cognitoIdentityProviderArr) {
            this.cognitoIdentityProviders.add(cognitoIdentityProvider);
        }
        return this;
    }

    public CreateIdentityPoolRequest withDeveloperProviderName(String str) {
        this.developerProviderName = str;
        return this;
    }

    public CreateIdentityPoolRequest withIdentityPoolName(String str) {
        this.identityPoolName = str;
        return this;
    }

    public CreateIdentityPoolRequest withIdentityPoolTags(Map<String, String> map) {
        this.identityPoolTags = map;
        return this;
    }

    public CreateIdentityPoolRequest withOpenIdConnectProviderARNs(String... strArr) {
        if (getOpenIdConnectProviderARNs() == null) {
            this.openIdConnectProviderARNs = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.openIdConnectProviderARNs.add(str);
        }
        return this;
    }

    public CreateIdentityPoolRequest withSamlProviderARNs(String... strArr) {
        if (getSamlProviderARNs() == null) {
            this.samlProviderARNs = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.samlProviderARNs.add(str);
        }
        return this;
    }

    public CreateIdentityPoolRequest withSupportedLoginProviders(Map<String, String> map) {
        this.supportedLoginProviders = map;
        return this;
    }

    public CreateIdentityPoolRequest withCognitoIdentityProviders(Collection<CognitoIdentityProvider> collection) {
        setCognitoIdentityProviders(collection);
        return this;
    }

    public CreateIdentityPoolRequest withOpenIdConnectProviderARNs(Collection<String> collection) {
        setOpenIdConnectProviderARNs(collection);
        return this;
    }

    public CreateIdentityPoolRequest withSamlProviderARNs(Collection<String> collection) {
        setSamlProviderARNs(collection);
        return this;
    }
}
