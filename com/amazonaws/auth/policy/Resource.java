package com.amazonaws.auth.policy;

/* loaded from: classes.dex */
public class Resource {
    private final String resource;

    public Resource(String str) {
        this.resource = str;
    }

    public String getId() {
        return this.resource;
    }
}
