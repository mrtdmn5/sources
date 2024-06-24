package okhttp3.internal;

import aws.sdk.kotlin.runtime.config.imds.EndpointMode$Companion$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatcherMatchResult;
import kotlin.text.MatcherMatchResult$groupValues$1;
import kotlin.text.MatcherMatchResult$groups$1;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.MediaType;

/* compiled from: -MediaTypeCommon.kt */
/* loaded from: classes4.dex */
public final class _MediaTypeCommonKt {
    public static final Regex TYPE_SUBTYPE = new Regex("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Regex PARAMETER = new Regex(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public static final MediaType commonToMediaType(String str) {
        boolean z;
        String str2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        MatcherMatchResult matchAtPolyfill = _UtilCommonKt.matchAtPolyfill(TYPE_SUBTYPE, str, 0);
        if (matchAtPolyfill != null) {
            String str3 = (String) ((MatcherMatchResult$groupValues$1) matchAtPolyfill.getGroupValues()).get(1);
            Locale locale = Locale.ROOT;
            String lowerCase = str3.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            String lowerCase2 = ((String) ((MatcherMatchResult$groupValues$1) matchAtPolyfill.getGroupValues()).get(2)).toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            ArrayList arrayList = new ArrayList();
            int r0 = matchAtPolyfill.getRange().last;
            while (true) {
                int r02 = r0 + 1;
                if (r02 < str.length()) {
                    MatcherMatchResult matchAtPolyfill2 = _UtilCommonKt.matchAtPolyfill(PARAMETER, str, r02);
                    if (matchAtPolyfill2 != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        MatchGroup matchGroup = matchAtPolyfill2.groups.get(1);
                        String str4 = null;
                        if (matchGroup != null) {
                            str2 = matchGroup.value;
                        } else {
                            str2 = null;
                        }
                        if (str2 == null) {
                            r0 = matchAtPolyfill2.getRange().last;
                        } else {
                            MatcherMatchResult$groups$1 matcherMatchResult$groups$1 = matchAtPolyfill2.groups;
                            MatchGroup matchGroup2 = matcherMatchResult$groups$1.get(2);
                            if (matchGroup2 != null) {
                                str4 = matchGroup2.value;
                            }
                            if (str4 == null) {
                                MatchGroup matchGroup3 = matcherMatchResult$groups$1.get(3);
                                Intrinsics.checkNotNull(matchGroup3);
                                str4 = matchGroup3.value;
                            } else if (StringsKt__StringsJVMKt.startsWith(str4, "'", false) && StringsKt__StringsJVMKt.endsWith(str4, "'", false) && str4.length() > 2) {
                                str4 = str4.substring(1, str4.length() - 1);
                                Intrinsics.checkNotNullExpressionValue(str4, "this as java.lang.String…ing(startIndex, endIndex)");
                            }
                            arrayList.add(str2);
                            arrayList.add(str4);
                            r0 = matchAtPolyfill2.getRange().last;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder("Parameter is not formatted correctly: \"");
                        String substring = str.substring(r02);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        sb.append(substring);
                        sb.append("\" for: \"");
                        sb.append(str);
                        sb.append('\"');
                        throw new IllegalArgumentException(sb.toString().toString());
                    }
                } else {
                    Object[] array = arrayList.toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    return new MediaType(str, lowerCase, lowerCase2, (String[]) array);
                }
            }
        } else {
            throw new IllegalArgumentException(EndpointMode$Companion$$ExternalSyntheticOutline0.m("No subtype found for: \"", str, '\"'));
        }
    }
}
