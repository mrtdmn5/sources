package com.amplifyframework.core.model;

/* loaded from: classes.dex */
public final class PrimaryKey {
    private static final String ID = "id";

    private PrimaryKey() {
    }

    public static String fieldName() {
        return "id";
    }

    public static boolean matches(Object obj) {
        if ((obj instanceof String) && fieldName().equals(obj)) {
            return true;
        }
        return false;
    }
}
