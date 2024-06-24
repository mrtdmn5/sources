package com.amazonaws.services.s3.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class CORSRule {
    private List<String> allowedHeaders;
    private List<AllowedMethods> allowedMethods;
    private List<String> allowedOrigins;
    private List<String> exposedHeaders;
    private String id;
    private int maxAgeSeconds;

    /* loaded from: classes.dex */
    public enum AllowedMethods {
        GET("GET"),
        PUT("PUT"),
        HEAD("HEAD"),
        POST("POST"),
        DELETE("DELETE");

        private final String AllowedMethod;

        AllowedMethods(String str) {
            this.AllowedMethod = str;
        }

        public static AllowedMethods fromValue(String str) throws IllegalArgumentException {
            for (AllowedMethods allowedMethods : values()) {
                String allowedMethods2 = allowedMethods.toString();
                if (allowedMethods2 == null && str == null) {
                    return allowedMethods;
                }
                if (allowedMethods2 != null && allowedMethods2.equals(str)) {
                    return allowedMethods;
                }
            }
            throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("Cannot create enum from ", str, " value!"));
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.AllowedMethod;
        }
    }

    public List<String> getAllowedHeaders() {
        return this.allowedHeaders;
    }

    public List<AllowedMethods> getAllowedMethods() {
        return this.allowedMethods;
    }

    public List<String> getAllowedOrigins() {
        return this.allowedOrigins;
    }

    public List<String> getExposedHeaders() {
        return this.exposedHeaders;
    }

    public String getId() {
        return this.id;
    }

    public int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public void setAllowedHeaders(List<String> list) {
        this.allowedHeaders = list;
    }

    public void setAllowedMethods(List<AllowedMethods> list) {
        this.allowedMethods = list;
    }

    public void setAllowedOrigins(List<String> list) {
        this.allowedOrigins = list;
    }

    public void setExposedHeaders(List<String> list) {
        this.exposedHeaders = list;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMaxAgeSeconds(int r1) {
        this.maxAgeSeconds = r1;
    }

    public CORSRule withAllowedHeaders(List<String> list) {
        this.allowedHeaders = list;
        return this;
    }

    public CORSRule withAllowedMethods(List<AllowedMethods> list) {
        this.allowedMethods = list;
        return this;
    }

    public CORSRule withAllowedOrigins(List<String> list) {
        this.allowedOrigins = list;
        return this;
    }

    public CORSRule withExposedHeaders(List<String> list) {
        this.exposedHeaders = list;
        return this;
    }

    public CORSRule withId(String str) {
        this.id = str;
        return this;
    }

    public CORSRule withMaxAgeSeconds(int r1) {
        this.maxAgeSeconds = r1;
        return this;
    }

    public void setAllowedHeaders(String... strArr) {
        this.allowedHeaders = Arrays.asList(strArr);
    }

    public void setAllowedMethods(AllowedMethods... allowedMethodsArr) {
        this.allowedMethods = Arrays.asList(allowedMethodsArr);
    }

    public void setAllowedOrigins(String... strArr) {
        this.allowedOrigins = Arrays.asList(strArr);
    }

    public void setExposedHeaders(String... strArr) {
        this.exposedHeaders = Arrays.asList(strArr);
    }
}
