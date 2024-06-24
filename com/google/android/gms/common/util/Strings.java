package com.google.android.gms.common.util;

import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class Strings {
    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = false)
    public static boolean isEmptyOrWhitespace(String str) {
        if (str != null && !str.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
