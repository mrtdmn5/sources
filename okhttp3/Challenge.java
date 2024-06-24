package okhttp3;

import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Challenge.kt */
/* loaded from: classes4.dex */
public final class Challenge {
    public final Map<String, String> authParams;
    public final String scheme;

    public Challenge(String str, Map<String, String> map) {
        String str2;
        this.scheme = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                str2 = key.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str2 = null;
            }
            linkedHashMap.put(str2, value);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = unmodifiableMap;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (Intrinsics.areEqual(challenge.scheme, this.scheme) && Intrinsics.areEqual(challenge.authParams, this.authParams)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.authParams.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.scheme, 899, 31);
    }

    public final String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }
}
