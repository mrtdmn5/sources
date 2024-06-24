package io.ktor.http.auth;

import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.text.Regex;

/* compiled from: HttpAuthHeader.kt */
/* loaded from: classes3.dex */
public final class HttpAuthHeaderKt {
    public static final Set<Character> TOKEN_EXTRA = SetsKt__SetsKt.setOf((Object[]) new Character[]{'!', '#', '$', '%', '&', '\'', '*', '+', '-', '.', '^', '_', '`', '|', '~'});
    public static final Set<Character> TOKEN68_EXTRA = SetsKt__SetsKt.setOf((Object[]) new Character[]{'-', '.', '_', '~', '+', '/'});
    public static final Regex token68Pattern = new Regex("[a-zA-Z0-9\\-._~+/]+=*");
    public static final Regex escapeRegex = new Regex("\\\\.");

    public static final boolean isToken(char c) {
        boolean z;
        boolean z2;
        boolean z3;
        if ('a' <= c && c < '{') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        if ('A' <= c && c < '[') {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return true;
        }
        if ('0' <= c && c < ':') {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 || TOKEN_EXTRA.contains(Character.valueOf(c))) {
            return true;
        }
        return false;
    }

    public static final Integer nextChallengeIndex(ArrayList arrayList, HttpAuthHeader httpAuthHeader, int r4, String str) {
        if (r4 != str.length() && str.charAt(r4) != ',') {
            return null;
        }
        arrayList.add(httpAuthHeader);
        if (r4 == str.length()) {
            return -1;
        }
        if (str.charAt(r4) == ',') {
            return Integer.valueOf(r4 + 1);
        }
        throw new IllegalStateException("".toString());
    }

    public static final int skipSpaces(int r2, String str) {
        while (r2 < str.length() && str.charAt(r2) == ' ') {
            r2++;
        }
        return r2;
    }
}
