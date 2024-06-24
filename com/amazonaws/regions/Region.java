package com.amazonaws.regions;

import androidx.lifecycle.SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class Region {
    private static final String DEFAULT_DOMAIN = "amazonaws.com";
    private final String domain;
    private final String name;
    private final Map<String, String> serviceEndpoints = new HashMap();
    private final Map<String, Boolean> httpSupport = new HashMap();
    private final Map<String, Boolean> httpsSupport = new HashMap();

    public Region(String str, String str2) {
        this.name = str;
        if (str2 != null && !str2.isEmpty()) {
            this.domain = str2;
        } else {
            this.domain = DEFAULT_DOMAIN;
        }
    }

    public static Region getRegion(Regions regions) {
        return RegionUtils.getRegion(regions.getName());
    }

    public <T extends AmazonWebServiceClient> T createClient(Class<T> cls, AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        T newInstance;
        try {
            if (aWSCredentialsProvider == null && clientConfiguration == null) {
                newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            } else if (aWSCredentialsProvider == null) {
                newInstance = cls.getConstructor(ClientConfiguration.class).newInstance(clientConfiguration);
            } else if (clientConfiguration == null) {
                newInstance = cls.getConstructor(AWSCredentialsProvider.class).newInstance(aWSCredentialsProvider);
            } else {
                newInstance = cls.getConstructor(AWSCredentialsProvider.class, ClientConfiguration.class).newInstance(aWSCredentialsProvider, clientConfiguration);
            }
            newInstance.setRegion(this);
            return newInstance;
        } catch (Exception e) {
            throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Couldn't instantiate instance of ", cls), e);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Region)) {
            return false;
        }
        return getName().equals(((Region) obj).getName());
    }

    public String getDomain() {
        return this.domain;
    }

    public Map<String, Boolean> getHttpSupport() {
        return this.httpSupport;
    }

    public Map<String, Boolean> getHttpsSupport() {
        return this.httpsSupport;
    }

    public String getName() {
        return this.name;
    }

    public String getServiceEndpoint(String str) {
        return this.serviceEndpoints.get(str);
    }

    public Map<String, String> getServiceEndpoints() {
        return this.serviceEndpoints;
    }

    public boolean hasHttpEndpoint(String str) {
        if (this.httpSupport.containsKey(str) && this.httpSupport.get(str).booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean hasHttpsEndpoint(String str) {
        if (this.httpsSupport.containsKey(str) && this.httpsSupport.get(str).booleanValue()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public boolean isServiceSupported(String str) {
        return this.serviceEndpoints.containsKey(str);
    }

    public String toString() {
        return getName();
    }

    public static Region getRegion(String str) {
        return RegionUtils.getRegion(str);
    }
}
