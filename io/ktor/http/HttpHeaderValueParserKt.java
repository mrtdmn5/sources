package io.ktor.http;

import com.amplifyframework.core.model.ModelIdentifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: HttpHeaderValueParser.kt */
/* loaded from: classes3.dex */
public final class HttpHeaderValueParserKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final List<HeaderValue> parseHeaderValue(String str) {
        int r7;
        int r6;
        List list;
        int r62;
        List list2;
        Pair pair;
        boolean z;
        boolean z2;
        boolean z3;
        EmptyList emptyList = EmptyList.INSTANCE;
        if (str != null) {
            Lazy lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ArrayList<HeaderValue>>() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1
                @Override // kotlin.jvm.functions.Function0
                public final ArrayList<HeaderValue> invoke() {
                    return new ArrayList<>();
                }
            });
            for (int r4 = 0; r4 <= StringsKt__StringsKt.getLastIndex(str); r4 = r7) {
                Lazy lazy2 = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ArrayList<HeaderValueParam>>() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1
                    @Override // kotlin.jvm.functions.Function0
                    public final ArrayList<HeaderValueParam> invoke() {
                        return new ArrayList<>();
                    }
                });
                Integer num = null;
                r7 = r4;
                while (true) {
                    if (r7 <= StringsKt__StringsKt.getLastIndex(str)) {
                        char charAt = str.charAt(r7);
                        if (charAt == ',') {
                            ArrayList arrayList = (ArrayList) lazy.getValue();
                            if (num != null) {
                                r62 = num.intValue();
                            } else {
                                r62 = r7;
                            }
                            String subtrim = subtrim(r4, r62, str);
                            if (lazy2.isInitialized()) {
                                list2 = (List) lazy2.getValue();
                            } else {
                                list2 = emptyList;
                            }
                            arrayList.add(new HeaderValue(subtrim, list2));
                            r7++;
                        } else if (charAt == ';') {
                            if (num == null) {
                                num = Integer.valueOf(r7);
                            }
                            int r72 = r7 + 1;
                            int r8 = r72;
                            while (true) {
                                if (r8 <= StringsKt__StringsKt.getLastIndex(str)) {
                                    char charAt2 = str.charAt(r8);
                                    if (charAt2 == '=') {
                                        int r11 = r8 + 1;
                                        if (str.length() == r11) {
                                            pair = new Pair(Integer.valueOf(r11), "");
                                        } else {
                                            char c = '\"';
                                            if (str.charAt(r11) == '\"') {
                                                int r112 = r11 + 1;
                                                StringBuilder sb = new StringBuilder();
                                                while (true) {
                                                    if (r112 <= StringsKt__StringsKt.getLastIndex(str)) {
                                                        char charAt3 = str.charAt(r112);
                                                        if (charAt3 == c) {
                                                            int r16 = r112 + 1;
                                                            int r3 = r16;
                                                            while (r3 < str.length() && str.charAt(r3) == ' ') {
                                                                r3++;
                                                            }
                                                            if (r3 != str.length() && str.charAt(r3) != ';') {
                                                                z2 = false;
                                                            } else {
                                                                z2 = true;
                                                            }
                                                            if (z2) {
                                                                Integer valueOf = Integer.valueOf(r16);
                                                                String sb2 = sb.toString();
                                                                Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
                                                                pair = new Pair(valueOf, sb2);
                                                                break;
                                                            }
                                                        }
                                                        if (charAt3 == '\\' && r112 < StringsKt__StringsKt.getLastIndex(str) - 2) {
                                                            sb.append(str.charAt(r112 + 1));
                                                            r112 += 2;
                                                        } else {
                                                            sb.append(charAt3);
                                                            r112++;
                                                        }
                                                        c = '\"';
                                                    } else {
                                                        Integer valueOf2 = Integer.valueOf(r112);
                                                        String sb3 = sb.toString();
                                                        Intrinsics.checkNotNullExpressionValue(sb3, "builder.toString()");
                                                        pair = new Pair(valueOf2, ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR.concat(sb3));
                                                        break;
                                                    }
                                                }
                                            } else {
                                                int r32 = r11;
                                                while (true) {
                                                    if (r32 <= StringsKt__StringsKt.getLastIndex(str)) {
                                                        char charAt4 = str.charAt(r32);
                                                        if (charAt4 == ';' || charAt4 == ',') {
                                                            z = true;
                                                        } else {
                                                            z = false;
                                                        }
                                                        if (z) {
                                                            pair = new Pair(Integer.valueOf(r32), subtrim(r11, r32, str));
                                                            break;
                                                        }
                                                        r32++;
                                                    } else {
                                                        pair = new Pair(Integer.valueOf(r32), subtrim(r11, r32, str));
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        int intValue = ((Number) pair.first).intValue();
                                        parseHeaderValueParameter$addParam(lazy2, str, r72, r8, (String) pair.second);
                                        r7 = intValue;
                                    } else {
                                        if (charAt2 == ';' || charAt2 == ',') {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        if (z3) {
                                            parseHeaderValueParameter$addParam(lazy2, str, r72, r8, "");
                                            break;
                                        }
                                        r8++;
                                    }
                                } else {
                                    parseHeaderValueParameter$addParam(lazy2, str, r72, r8, "");
                                    break;
                                }
                            }
                            r7 = r8;
                        } else {
                            r7++;
                        }
                    } else {
                        ArrayList arrayList2 = (ArrayList) lazy.getValue();
                        if (num != null) {
                            r6 = num.intValue();
                        } else {
                            r6 = r7;
                        }
                        String subtrim2 = subtrim(r4, r6, str);
                        if (lazy2.isInitialized()) {
                            list = (List) lazy2.getValue();
                        } else {
                            list = emptyList;
                        }
                        arrayList2.add(new HeaderValue(subtrim2, list));
                    }
                }
            }
            if (lazy.isInitialized()) {
                return (List) lazy.getValue();
            }
            return emptyList;
        }
        return emptyList;
    }

    public static final void parseHeaderValueParameter$addParam(Lazy<? extends ArrayList<HeaderValueParam>> lazy, String str, int r2, int r3, String str2) {
        boolean z;
        String subtrim = subtrim(r2, r3, str);
        if (subtrim.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        lazy.getValue().add(new HeaderValueParam(subtrim, str2));
    }

    public static final String subtrim(int r0, int r1, String str) {
        String substring = str.substring(r0, r1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return StringsKt__StringsKt.trim(substring).toString();
    }
}
