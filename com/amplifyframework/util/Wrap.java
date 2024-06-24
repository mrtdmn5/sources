package com.amplifyframework.util;

import com.amplifyframework.core.model.ModelIdentifier;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
public final class Wrap {
    private Wrap() {
    }

    public static String inBackticks(String str) {
        if (Empty.check(str)) {
            return str;
        }
        return zzav$$ExternalSyntheticOutline0.m("`", str, "`");
    }

    public static String inBraces(String str) {
        if (str == null) {
            return null;
        }
        return zzav$$ExternalSyntheticOutline0.m("{", str, "}");
    }

    public static String inDoubleQuotes(String str) {
        if (str == null) {
            return null;
        }
        return zzav$$ExternalSyntheticOutline0.m(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR, str, ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR);
    }

    public static String inParentheses(String str) {
        if (str == null) {
            return null;
        }
        return zzav$$ExternalSyntheticOutline0.m("(", str, ")");
    }

    public static String inPrettyBraces(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        return " " + inBraces("\n" + str2 + str3 + str + "\n" + str2);
    }

    public static String inSingleQuotes(String str) {
        if (str == null) {
            return null;
        }
        return zzav$$ExternalSyntheticOutline0.m("'", str, "'");
    }
}
