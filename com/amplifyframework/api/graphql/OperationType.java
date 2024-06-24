package com.amplifyframework.api.graphql;

/* loaded from: classes.dex */
public enum OperationType {
    QUERY("query"),
    MUTATION("mutation"),
    SUBSCRIPTION("subscription");

    private final String name;

    OperationType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
