package io.ktor.http.auth;

import io.ktor.http.CodecsKt;
import io.ktor.http.HeaderValueParam;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.parsing.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: HttpAuthHeader.kt */
/* loaded from: classes3.dex */
public abstract class HttpAuthHeader {
    public final String authScheme;

    /* compiled from: HttpAuthHeader.kt */
    /* loaded from: classes3.dex */
    public static final class Parameterized extends HttpAuthHeader {
        public final HeaderValueEncoding encoding;
        public final List<HeaderValueParam> parameters;

        /* compiled from: HttpAuthHeader.kt */
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] r0 = new int[HeaderValueEncoding.values().length];
                try {
                    r0[HeaderValueEncoding.QUOTED_WHEN_REQUIRED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    r0[HeaderValueEncoding.QUOTED_ALWAYS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    r0[HeaderValueEncoding.URI_ENCODE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = r0;
            }
        }

        public Parameterized() {
            throw null;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Parameterized(String str, List<HeaderValueParam> list, HeaderValueEncoding encoding) {
            super(str);
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            this.parameters = list;
            this.encoding = encoding;
            for (HeaderValueParam headerValueParam : list) {
                if (!HttpAuthHeaderKt.token68Pattern.matches(headerValueParam.name)) {
                    throw new ParseException("parameter name should be a token but it is " + headerValueParam.name);
                }
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Parameterized)) {
                return false;
            }
            Parameterized parameterized = (Parameterized) obj;
            if (!StringsKt__StringsJVMKt.equals(parameterized.authScheme, this.authScheme) || !Intrinsics.areEqual(parameterized.parameters, this.parameters)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String lowerCase = this.authScheme.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return ArraysKt___ArraysKt.toList(new Object[]{lowerCase, this.parameters}).hashCode();
        }

        @Override // io.ktor.http.auth.HttpAuthHeader
        public final String render$1() {
            final HeaderValueEncoding encoding = this.encoding;
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            List<HeaderValueParam> list = this.parameters;
            boolean isEmpty = list.isEmpty();
            String str = this.authScheme;
            if (!isEmpty) {
                return CollectionsKt___CollectionsKt.joinToString$default(list, ", ", str + ' ', null, new Function1<HeaderValueParam, CharSequence>() { // from class: io.ktor.http.auth.HttpAuthHeader$Parameterized$render$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(HeaderValueParam headerValueParam) {
                        HeaderValueParam it = headerValueParam;
                        Intrinsics.checkNotNullParameter(it, "it");
                        StringBuilder sb = new StringBuilder();
                        sb.append(it.name);
                        sb.append('=');
                        HttpAuthHeader.Parameterized.this.getClass();
                        int r1 = HttpAuthHeader.Parameterized.WhenMappings.$EnumSwitchMapping$0[encoding.ordinal()];
                        String str2 = it.value;
                        if (r1 != 1) {
                            if (r1 != 2) {
                                if (r1 == 3) {
                                    str2 = CodecsKt.encodeURLParameter(str2, false);
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                str2 = HeaderValueWithParametersKt.quote(str2);
                            }
                        } else {
                            Set<Character> set = HeaderValueWithParametersKt.HeaderFieldValueSeparators;
                            Intrinsics.checkNotNullParameter(str2, "<this>");
                            if (HeaderValueWithParametersKt.needQuotes(str2)) {
                                str2 = HeaderValueWithParametersKt.quote(str2);
                            }
                        }
                        sb.append(str2);
                        return sb.toString();
                    }
                }, 28);
            }
            return str;
        }
    }

    /* compiled from: HttpAuthHeader.kt */
    /* loaded from: classes3.dex */
    public static final class Single extends HttpAuthHeader {
        public final String blob;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Single(String str, String blob) {
            super(str);
            Intrinsics.checkNotNullParameter(blob, "blob");
            this.blob = blob;
            if (HttpAuthHeaderKt.token68Pattern.matches(blob)) {
            } else {
                throw new ParseException("Invalid blob value: it should be token68, but instead it is ".concat(blob));
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Single)) {
                return false;
            }
            Single single = (Single) obj;
            if (!StringsKt__StringsJVMKt.equals(single.authScheme, this.authScheme) || !StringsKt__StringsJVMKt.equals(single.blob, this.blob)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            Locale locale = Locale.ROOT;
            String lowerCase = this.authScheme.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            String lowerCase2 = this.blob.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return ArraysKt___ArraysKt.toList(new Object[]{lowerCase, lowerCase2}).hashCode();
        }

        @Override // io.ktor.http.auth.HttpAuthHeader
        public final String render$1() {
            return this.authScheme + ' ' + this.blob;
        }
    }

    public HttpAuthHeader(String str) {
        this.authScheme = str;
        if (HttpAuthHeaderKt.token68Pattern.matches(str)) {
        } else {
            throw new ParseException("Invalid authScheme value: it should be token, but instead it is ".concat(str));
        }
    }

    public abstract String render$1();

    public final String toString() {
        return render$1();
    }
}
