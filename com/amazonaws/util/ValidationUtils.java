package com.amazonaws.util;

import java.util.Collection;

/* loaded from: classes.dex */
public class ValidationUtils {
    public static void assertAllAreNull(String str, Object... objArr) {
        for (Object obj : objArr) {
            if (obj != null) {
                throw new IllegalArgumentException(str);
            }
        }
    }

    public static int assertIsPositive(int r1, String str) {
        if (r1 > 0) {
            return r1;
        }
        throw new IllegalArgumentException(String.format("%s must be positive", str));
    }

    public static <T extends Collection<?>> T assertNotEmpty(T t, String str) {
        assertNotNull(t, str);
        if (t.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s cannot be empty", str));
        }
        return t;
    }

    public static <T> T assertNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(String.format("%s cannot be null", str));
    }

    public static void assertParameterNotNull(Object obj, String str) {
        if (obj != null) {
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    public static String assertStringNotEmpty(String str, String str2) {
        assertNotNull(str, str2);
        if (!str.isEmpty()) {
            return str;
        }
        throw new IllegalArgumentException(String.format("%s cannot be empty", str2));
    }

    public static <T> T[] assertNotEmpty(T[] tArr, String str) {
        assertNotNull(tArr, str);
        if (tArr.length != 0) {
            return tArr;
        }
        throw new IllegalArgumentException(String.format("%s cannot be empty", str));
    }
}
