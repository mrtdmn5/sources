package okhttp3;

import com.animaconnected.secondo.R;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal._UtilCommonKt;
import okio.Buffer;

/* compiled from: HttpUrl.kt */
/* loaded from: classes4.dex */
public final class HttpUrl {
    public static final Companion Companion = new Companion();
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String fragment;
    public final String host;
    public final boolean isHttps;
    public final String password;
    public final List<String> pathSegments;
    public final int port;
    public final List<String> queryNamesAndValues;
    public final String scheme;
    public final String url;
    public final String username;

    /* compiled from: HttpUrl.kt */
    /* loaded from: classes4.dex */
    public static final class Builder {
        public String encodedFragment;
        public final ArrayList encodedPathSegments;
        public ArrayList encodedQueryNamesAndValues;
        public String host;
        public String scheme;
        public String encodedUsername = "";
        public String encodedPassword = "";
        public int port = -1;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str;
            String str2 = this.scheme;
            if (str2 != null) {
                String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(this.encodedUsername, 0, 0, false, 7);
                String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(this.encodedPassword, 0, 0, false, 7);
                String str3 = this.host;
                if (str3 != null) {
                    int effectivePort = effectivePort();
                    ArrayList arrayList2 = this.encodedPathSegments;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList2, 10));
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(Companion.percentDecode$okhttp$default((String) it.next(), 0, 0, false, 7));
                    }
                    ArrayList<String> arrayList4 = this.encodedQueryNamesAndValues;
                    String str4 = null;
                    if (arrayList4 != null) {
                        arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList4, 10));
                        for (String str5 : arrayList4) {
                            if (str5 != null) {
                                str = Companion.percentDecode$okhttp$default(str5, 0, 0, true, 3);
                            } else {
                                str = null;
                            }
                            arrayList.add(str);
                        }
                    } else {
                        arrayList = null;
                    }
                    String str6 = this.encodedFragment;
                    if (str6 != null) {
                        str4 = Companion.percentDecode$okhttp$default(str6, 0, 0, false, 7);
                    }
                    return new HttpUrl(str2, percentDecode$okhttp$default, percentDecode$okhttp$default2, str3, effectivePort, arrayList3, arrayList, str4, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public final int effectivePort() {
            int r0 = this.port;
            if (r0 == -1) {
                String str = this.scheme;
                Intrinsics.checkNotNull(str);
                if (Intrinsics.areEqual(str, "http")) {
                    return 80;
                }
                if (!Intrinsics.areEqual(str, "https")) {
                    return -1;
                }
                return 443;
            }
            return r0;
        }

        public final void encodedQuery(String str) {
            ArrayList arrayList;
            if (str != null) {
                arrayList = Companion.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(str, 0, 0, " \"'<>#", true, false, true, false, null, 211));
            } else {
                arrayList = null;
            }
            this.encodedQueryNamesAndValues = arrayList;
        }

        /* JADX WARN: Code restructure failed: missing block: B:200:0x028d, code lost:            if (r2 != 0) goto L164;     */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:            if (r10 == ':') goto L58;     */
        /* JADX WARN: Removed duplicated region for block: B:209:0x02f4  */
        /* JADX WARN: Removed duplicated region for block: B:211:0x02f9  */
        /* JADX WARN: Removed duplicated region for block: B:212:0x0448  */
        /* JADX WARN: Removed duplicated region for block: B:214:0x02f6  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0307  */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 4 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void parse$okhttp(okhttp3.HttpUrl r27, java.lang.String r28) {
            /*
                Method dump skipped, instructions count: 1173
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.parse$okhttp(okhttp3.HttpUrl, java.lang.String):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:            if (r1 != false) goto L17;     */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0098, code lost:            if (r1 != r3) goto L43;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String toString() {
            /*
                Method dump skipped, instructions count: 294
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.toString():java.lang.String");
        }
    }

    /* compiled from: HttpUrl.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        /* JADX WARN: Code restructure failed: missing block: B:73:0x00f7, code lost:            if (isPercentEncoded(r11, r5, r0) == false) goto L94;     */
        /* JADX WARN: Removed duplicated region for block: B:97:0x01b4 A[LOOP:2: B:95:0x01ae->B:97:0x01b4, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String canonicalize$okhttp$default(java.lang.String r18, int r19, int r20, java.lang.String r21, boolean r22, boolean r23, boolean r24, boolean r25, java.nio.charset.Charset r26, int r27) {
            /*
                Method dump skipped, instructions count: 498
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset, int):java.lang.String");
        }

        public static int defaultPort(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (Intrinsics.areEqual(scheme, "http")) {
                return 80;
            }
            if (Intrinsics.areEqual(scheme, "https")) {
                return 443;
            }
            return -1;
        }

        public static boolean isPercentEncoded(int r2, int r3, String str) {
            int r0 = r2 + 2;
            if (r0 < r3 && str.charAt(r2) == '%' && _UtilCommonKt.parseHexDigit(str.charAt(r2 + 1)) != -1 && _UtilCommonKt.parseHexDigit(str.charAt(r0)) != -1) {
                return true;
            }
            return false;
        }

        public static String percentDecode$okhttp$default(String str, int r8, int r9, boolean z, int r11) {
            int r3;
            if ((r11 & 1) != 0) {
                r8 = 0;
            }
            if ((r11 & 2) != 0) {
                r9 = str.length();
            }
            if ((r11 & 4) != 0) {
                z = false;
            }
            Intrinsics.checkNotNullParameter(str, "<this>");
            int r112 = r8;
            while (r112 < r9) {
                char charAt = str.charAt(r112);
                if (charAt != '%' && (charAt != '+' || !z)) {
                    r112++;
                } else {
                    Buffer buffer = new Buffer();
                    buffer.m1737writeUtf8(r8, r112, str);
                    while (r112 < r9) {
                        int codePointAt = str.codePointAt(r112);
                        if (codePointAt == 37 && (r3 = r112 + 2) < r9) {
                            int parseHexDigit = _UtilCommonKt.parseHexDigit(str.charAt(r112 + 1));
                            int parseHexDigit2 = _UtilCommonKt.parseHexDigit(str.charAt(r3));
                            if (parseHexDigit != -1 && parseHexDigit2 != -1) {
                                buffer.m1734writeByte((parseHexDigit << 4) + parseHexDigit2);
                                r112 = Character.charCount(codePointAt) + r3;
                            }
                            buffer.writeUtf8CodePoint(codePointAt);
                            r112 += Character.charCount(codePointAt);
                        } else {
                            if (codePointAt == 43 && z) {
                                buffer.m1734writeByte(32);
                                r112++;
                            }
                            buffer.writeUtf8CodePoint(codePointAt);
                            r112 += Character.charCount(codePointAt);
                        }
                    }
                    return buffer.readUtf8();
                }
            }
            String substring = str.substring(r8, r9);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public static ArrayList toQueryNamesAndValues$okhttp(String str) {
            ArrayList arrayList = new ArrayList();
            int r2 = 0;
            while (r2 <= str.length()) {
                int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '&', r2, false, 4);
                if (indexOf$default == -1) {
                    indexOf$default = str.length();
                }
                int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, '=', r2, false, 4);
                if (indexOf$default2 != -1 && indexOf$default2 <= indexOf$default) {
                    String substring = str.substring(r2, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    String substring2 = str.substring(indexOf$default2 + 1, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                } else {
                    String substring3 = str.substring(r2, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring3);
                    arrayList.add(null);
                }
                r2 = indexOf$default + 1;
            }
            return arrayList;
        }
    }

    public HttpUrl(String str, String str2, String str3, String str4, int r5, ArrayList arrayList, ArrayList arrayList2, String str5, String str6) {
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = r5;
        this.pathSegments = arrayList;
        this.queryNamesAndValues = arrayList2;
        this.fragment = str5;
        this.url = str6;
        this.isHttps = Intrinsics.areEqual(str, "https");
    }

    public final String encodedPassword() {
        boolean z;
        if (this.password.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String substring = str.substring(StringsKt__StringsKt.indexOf$default((CharSequence) str, ':', length, false, 4) + 1, StringsKt__StringsKt.indexOf$default((CharSequence) str, '@', 0, false, 6));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedPath() {
        int length = this.scheme.length() + 3;
        String str = this.url;
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '/', length, false, 4);
        String substring = str.substring(indexOf$default, _UtilCommonKt.delimiterOffset(indexOf$default, str.length(), str, "?#"));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final ArrayList encodedPathSegments() {
        int length = this.scheme.length() + 3;
        String str = this.url;
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '/', length, false, 4);
        int delimiterOffset = _UtilCommonKt.delimiterOffset(indexOf$default, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf$default < delimiterOffset) {
            int r0 = indexOf$default + 1;
            int delimiterOffset2 = _UtilCommonKt.delimiterOffset('/', r0, delimiterOffset, str);
            String substring = str.substring(r0, delimiterOffset2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(substring);
            indexOf$default = delimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        String str = this.url;
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '?', 0, false, 6) + 1;
        String substring = str.substring(indexOf$default, _UtilCommonKt.delimiterOffset('#', indexOf$default, str.length(), str));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedUsername() {
        boolean z;
        if (this.username.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String substring = str.substring(length, _UtilCommonKt.delimiterOffset(length, str.length(), str, ":@"));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof HttpUrl) && Intrinsics.areEqual(((HttpUrl) obj).url, this.url)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.url.hashCode();
    }

    public final String redact() {
        Builder builder;
        try {
            builder = new Builder();
            builder.parse$okhttp(this, "/...");
        } catch (IllegalArgumentException unused) {
            builder = null;
        }
        Intrinsics.checkNotNull(builder);
        builder.encodedUsername = Companion.canonicalize$okhttp$default("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
        builder.encodedPassword = Companion.canonicalize$okhttp$default("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
        return builder.build().url;
    }

    public final String toString() {
        return this.url;
    }

    public final URI uri() {
        String substring;
        String str;
        String str2;
        Builder builder = new Builder();
        String str3 = this.scheme;
        builder.scheme = str3;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        int defaultPort = Companion.defaultPort(str3);
        int r3 = this.port;
        if (r3 == defaultPort) {
            r3 = -1;
        }
        builder.port = r3;
        ArrayList arrayList = builder.encodedPathSegments;
        arrayList.clear();
        arrayList.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        String str4 = null;
        if (this.fragment == null) {
            substring = null;
        } else {
            String str5 = this.url;
            substring = str5.substring(StringsKt__StringsKt.indexOf$default((CharSequence) str5, '#', 0, false, 6) + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        }
        builder.encodedFragment = substring;
        String str6 = builder.host;
        if (str6 != null) {
            Pattern compile = Pattern.compile("[\"<>^`{|}]");
            Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
            str = compile.matcher(str6).replaceAll("");
            Intrinsics.checkNotNullExpressionValue(str, "replaceAll(...)");
        } else {
            str = null;
        }
        builder.host = str;
        int size = arrayList.size();
        for (int r9 = 0; r9 < size; r9++) {
            arrayList.set(r9, Companion.canonicalize$okhttp$default((String) arrayList.get(r9), 0, 0, "[]", true, true, false, false, null, 227));
        }
        ArrayList arrayList2 = builder.encodedQueryNamesAndValues;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int r32 = 0; r32 < size2; r32++) {
                String str7 = (String) arrayList2.get(r32);
                if (str7 != null) {
                    str2 = Companion.canonicalize$okhttp$default(str7, 0, 0, "\\^`{|}", true, true, true, false, null, 195);
                } else {
                    str2 = null;
                }
                arrayList2.set(r32, str2);
            }
        }
        String str8 = builder.encodedFragment;
        if (str8 != null) {
            str4 = Companion.canonicalize$okhttp$default(str8, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, R.styleable.AppTheme_tabSelectIndicatorColor);
        }
        builder.encodedFragment = str4;
        String builder2 = builder.toString();
        try {
            return new URI(builder2);
        } catch (URISyntaxException e) {
            try {
                Pattern compile2 = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                Intrinsics.checkNotNullExpressionValue(compile2, "compile(...)");
                String replaceAll = compile2.matcher(builder2).replaceAll("");
                Intrinsics.checkNotNullExpressionValue(replaceAll, "replaceAll(...)");
                URI create = URI.create(replaceAll);
                Intrinsics.checkNotNullExpressionValue(create, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }
}
