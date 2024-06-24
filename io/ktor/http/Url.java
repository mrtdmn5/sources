package io.ktor.http;

import java.util.ArrayList;
import java.util.List;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Url.kt */
/* loaded from: classes3.dex */
public final class Url {
    public final SynchronizedLazyImpl encodedFragment$delegate;
    public final SynchronizedLazyImpl encodedPassword$delegate;
    public final SynchronizedLazyImpl encodedPath$delegate;
    public final SynchronizedLazyImpl encodedQuery$delegate;
    public final SynchronizedLazyImpl encodedUser$delegate;
    public final String host;
    public final Parameters parameters;
    public final String password;
    public final List<String> pathSegments;
    public final URLProtocol protocol;
    public final int specifiedPort;
    public final boolean trailingQuery;
    public final String urlString;
    public final String user;

    public Url(URLProtocol protocol, String host, int r3, ArrayList arrayList, Parameters parameters, String str, String str2, String str3, boolean z, String str4) {
        boolean z2;
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.protocol = protocol;
        this.host = host;
        this.specifiedPort = r3;
        this.pathSegments = arrayList;
        this.parameters = parameters;
        this.user = str2;
        this.password = str3;
        this.trailingQuery = z;
        this.urlString = str4;
        boolean z3 = true;
        if (r3 >= 0 && r3 < 65536) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && r3 != 0) {
            z3 = false;
        }
        if (z3) {
            this.encodedPath$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: io.ktor.http.Url$encodedPath$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    Url url = Url.this;
                    if (!url.pathSegments.isEmpty()) {
                        int length = url.protocol.name.length() + 3;
                        String str5 = url.urlString;
                        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str5, '/', length, false, 4);
                        if (indexOf$default != -1) {
                            int indexOfAny = StringsKt__StringsKt.indexOfAny(indexOf$default, str5, false, new char[]{'?', '#'});
                            if (indexOfAny == -1) {
                                String substring = str5.substring(indexOf$default);
                                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                                return substring;
                            }
                            String substring2 = str5.substring(indexOf$default, indexOfAny);
                            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                            return substring2;
                        }
                    }
                    return "";
                }
            });
            this.encodedQuery$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: io.ktor.http.Url$encodedQuery$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    Url url = Url.this;
                    int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) url.urlString, '?', 0, false, 6) + 1;
                    if (indexOf$default == 0) {
                        return "";
                    }
                    String str5 = url.urlString;
                    int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str5, '#', indexOf$default, false, 4);
                    if (indexOf$default2 == -1) {
                        String substring = str5.substring(indexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        return substring;
                    }
                    String substring2 = str5.substring(indexOf$default, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    return substring2;
                }
            });
            LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: io.ktor.http.Url$encodedPathAndQuery$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    Url url = Url.this;
                    int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) url.urlString, '/', url.protocol.name.length() + 3, false, 4);
                    if (indexOf$default == -1) {
                        return "";
                    }
                    String str5 = url.urlString;
                    int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str5, '#', indexOf$default, false, 4);
                    if (indexOf$default2 == -1) {
                        String substring = str5.substring(indexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        return substring;
                    }
                    String substring2 = str5.substring(indexOf$default, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    return substring2;
                }
            });
            this.encodedUser$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: io.ktor.http.Url$encodedUser$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    boolean z4;
                    Url url = Url.this;
                    String str5 = url.user;
                    if (str5 == null) {
                        return null;
                    }
                    if (str5.length() == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        return "";
                    }
                    int length = url.protocol.name.length() + 3;
                    String str6 = url.urlString;
                    String substring = str6.substring(length, StringsKt__StringsKt.indexOfAny(length, str6, false, new char[]{':', '@'}));
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return substring;
                }
            });
            this.encodedPassword$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: io.ktor.http.Url$encodedPassword$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    boolean z4;
                    Url url = Url.this;
                    String str5 = url.password;
                    if (str5 == null) {
                        return null;
                    }
                    if (str5.length() == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        return "";
                    }
                    int length = url.protocol.name.length() + 3;
                    String str6 = url.urlString;
                    String substring = str6.substring(StringsKt__StringsKt.indexOf$default((CharSequence) str6, ':', length, false, 4) + 1, StringsKt__StringsKt.indexOf$default((CharSequence) str6, '@', 0, false, 6));
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return substring;
                }
            });
            this.encodedFragment$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: io.ktor.http.Url$encodedFragment$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    Url url = Url.this;
                    int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) url.urlString, '#', 0, false, 6) + 1;
                    if (indexOf$default == 0) {
                        return "";
                    }
                    String substring = url.urlString.substring(indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    return substring;
                }
            });
            return;
        }
        throw new IllegalArgumentException("port must be between 0 and 65535, or 0 if not set".toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Url.class == obj.getClass() && Intrinsics.areEqual(this.urlString, ((Url) obj).urlString)) {
            return true;
        }
        return false;
    }

    public final int getPort() {
        boolean z;
        Integer valueOf = Integer.valueOf(this.specifiedPort);
        if (valueOf.intValue() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return this.protocol.defaultPort;
    }

    public final int hashCode() {
        return this.urlString.hashCode();
    }

    public final String toString() {
        return this.urlString;
    }
}
