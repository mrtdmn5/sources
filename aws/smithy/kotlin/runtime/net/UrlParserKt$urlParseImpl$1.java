package aws.smithy.kotlin.runtime.net;

import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.net.Scheme;
import com.amplifyframework.core.model.ModelIdentifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: UrlParser.kt */
/* loaded from: classes.dex */
public final class UrlParserKt$urlParseImpl$1 extends Lambda implements Function1<UrlBuilder, Unit> {
    public final /* synthetic */ String $url;

    /* compiled from: UrlParser.kt */
    /* renamed from: aws.smithy.kotlin.runtime.net.UrlParserKt$urlParseImpl$1$1 */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String str) {
            boolean z;
            boolean z2;
            boolean z3;
            String substring;
            Integer num;
            String it = str;
            Intrinsics.checkNotNullParameter(it, "it");
            boolean z4 = false;
            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) it, '[', 0, false, 6);
            int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) it, ']', 0, false, 6);
            int lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default(it, ":", 6);
            if (indexOf$default2 != -1) {
                lastIndexOf$default = indexOf$default2 + 1;
            } else if (lastIndexOf$default == -1) {
                lastIndexOf$default = it.length();
            }
            if ((indexOf$default == -1 && indexOf$default2 == -1) || indexOf$default < indexOf$default2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (indexOf$default <= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (indexOf$default2 != -1 && indexOf$default2 != lastIndexOf$default - 1) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        if (indexOf$default != -1) {
                            substring = StringsKt__StringsKt.substring(it, RangesKt___RangesKt.until(indexOf$default + 1, indexOf$default2));
                        } else {
                            substring = StringsKt__StringsKt.substring(it, RangesKt___RangesKt.until(0, lastIndexOf$default));
                        }
                        String urlDecodeComponent$default = aws.smithy.kotlin.runtime.util.text.TextKt.urlDecodeComponent$default(substring);
                        if (indexOf$default != -1 && indexOf$default2 != -1) {
                            if (TextKt.parseIpv6OrNull(urlDecodeComponent$default) != null) {
                                z4 = true;
                            }
                            if (!z4) {
                                throw new IllegalArgumentException("non-ipv6 host was enclosed in []-brackets");
                            }
                        }
                        Host parse = Host.Companion.parse(urlDecodeComponent$default);
                        if (lastIndexOf$default != -1 && lastIndexOf$default != it.length()) {
                            String substring2 = it.substring(lastIndexOf$default + 1);
                            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                            num = Integer.valueOf(Integer.parseInt(substring2));
                        } else {
                            num = null;
                        }
                        UrlBuilder urlBuilder = UrlBuilder.this;
                        urlBuilder.getClass();
                        urlBuilder.host = parse;
                        if (num == null) {
                            num = Integer.valueOf(urlBuilder.scheme.defaultPort);
                        }
                        urlBuilder.port = num;
                        return Unit.INSTANCE;
                    }
                    throw new IllegalArgumentException("unexpected characters after ]".toString());
                }
                throw new IllegalArgumentException("unexpected characters before [".toString());
            }
            throw new IllegalArgumentException("unmatched [ or ]".toString());
        }
    }

    /* compiled from: UrlParser.kt */
    /* renamed from: aws.smithy.kotlin.runtime.net.UrlParserKt$urlParseImpl$1$2 */
    /* loaded from: classes.dex */
    public final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String str) {
            String it = str;
            Intrinsics.checkNotNullParameter(it, "it");
            String concat = "/".concat(aws.smithy.kotlin.runtime.util.text.TextKt.urlDecodeComponent$default(it));
            UrlBuilder urlBuilder = UrlBuilder.this;
            urlBuilder.getClass();
            Intrinsics.checkNotNullParameter(concat, "<set-?>");
            urlBuilder.path = concat;
            return Unit.INSTANCE;
        }
    }

    /* compiled from: UrlParser.kt */
    /* renamed from: aws.smithy.kotlin.runtime.net.UrlParserKt$urlParseImpl$1$3 */
    /* loaded from: classes.dex */
    public final class AnonymousClass3 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String str) {
            String it = str;
            Intrinsics.checkNotNullParameter(it, "it");
            for (Map.Entry entry : aws.smithy.kotlin.runtime.util.text.TextKt.splitAsQueryString(it).entrySet()) {
                String str2 = (String) entry.getKey();
                List list = (List) entry.getValue();
                QueryParametersBuilder queryParametersBuilder = UrlBuilder.this.parameters;
                String urlDecodeComponent$default = aws.smithy.kotlin.runtime.util.text.TextKt.urlDecodeComponent$default(str2);
                List list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(aws.smithy.kotlin.runtime.util.text.TextKt.urlDecodeComponent$default((String) it2.next()));
                }
                queryParametersBuilder.appendAll(urlDecodeComponent$default, arrayList);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlParserKt$urlParseImpl$1(String str) {
        super(1);
        this.$url = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(UrlBuilder urlBuilder) {
        final UrlBuilder invoke = urlBuilder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        String access$captureUntilAndSkip = UrlParserKt.access$captureUntilAndSkip(UrlParserKt.access$captureUntilAndSkip(this.$url, "://", new Function1<String, Unit>() { // from class: aws.smithy.kotlin.runtime.net.UrlParserKt$urlParseImpl$1$next$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(String str) {
                String it = str;
                Intrinsics.checkNotNullParameter(it, "it");
                Scheme scheme = Scheme.HTTPS;
                Scheme parse = Scheme.Companion.parse(it);
                UrlBuilder urlBuilder2 = UrlBuilder.this;
                urlBuilder2.getClass();
                urlBuilder2.scheme = parse;
                return Unit.INSTANCE;
            }
        }), "@", new Function1<String, Unit>() { // from class: aws.smithy.kotlin.runtime.net.UrlParserKt$urlParseImpl$1$next$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(String str) {
                String it = str;
                Intrinsics.checkNotNullParameter(it, "it");
                UrlBuilder.this.userInfo = UrlKt.UserInfo(it);
                return Unit.INSTANCE;
            }
        });
        String access$capture = UrlParserKt.access$capture(access$captureUntilAndSkip, RangesKt___RangesKt.until(0, UrlParserKt.access$firstIndexOrEnd(access$captureUntilAndSkip, "/", "?", ModelIdentifier.Helper.PRIMARY_KEY_DELIMITER)), new Function1<String, Unit>() { // from class: aws.smithy.kotlin.runtime.net.UrlParserKt$urlParseImpl$1.1
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(String str) {
                boolean z;
                boolean z2;
                boolean z3;
                String substring;
                Integer num;
                String it = str;
                Intrinsics.checkNotNullParameter(it, "it");
                boolean z4 = false;
                int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) it, '[', 0, false, 6);
                int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) it, ']', 0, false, 6);
                int lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default(it, ":", 6);
                if (indexOf$default2 != -1) {
                    lastIndexOf$default = indexOf$default2 + 1;
                } else if (lastIndexOf$default == -1) {
                    lastIndexOf$default = it.length();
                }
                if ((indexOf$default == -1 && indexOf$default2 == -1) || indexOf$default < indexOf$default2) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (indexOf$default <= 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (indexOf$default2 != -1 && indexOf$default2 != lastIndexOf$default - 1) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            if (indexOf$default != -1) {
                                substring = StringsKt__StringsKt.substring(it, RangesKt___RangesKt.until(indexOf$default + 1, indexOf$default2));
                            } else {
                                substring = StringsKt__StringsKt.substring(it, RangesKt___RangesKt.until(0, lastIndexOf$default));
                            }
                            String urlDecodeComponent$default = aws.smithy.kotlin.runtime.util.text.TextKt.urlDecodeComponent$default(substring);
                            if (indexOf$default != -1 && indexOf$default2 != -1) {
                                if (TextKt.parseIpv6OrNull(urlDecodeComponent$default) != null) {
                                    z4 = true;
                                }
                                if (!z4) {
                                    throw new IllegalArgumentException("non-ipv6 host was enclosed in []-brackets");
                                }
                            }
                            Host parse = Host.Companion.parse(urlDecodeComponent$default);
                            if (lastIndexOf$default != -1 && lastIndexOf$default != it.length()) {
                                String substring2 = it.substring(lastIndexOf$default + 1);
                                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                                num = Integer.valueOf(Integer.parseInt(substring2));
                            } else {
                                num = null;
                            }
                            UrlBuilder urlBuilder2 = UrlBuilder.this;
                            urlBuilder2.getClass();
                            urlBuilder2.host = parse;
                            if (num == null) {
                                num = Integer.valueOf(urlBuilder2.scheme.defaultPort);
                            }
                            urlBuilder2.port = num;
                            return Unit.INSTANCE;
                        }
                        throw new IllegalArgumentException("unexpected characters after ]".toString());
                    }
                    throw new IllegalArgumentException("unexpected characters before [".toString());
                }
                throw new IllegalArgumentException("unmatched [ or ]".toString());
            }
        });
        if (StringsKt__StringsJVMKt.startsWith(access$capture, "/", false)) {
            access$capture = UrlParserKt.access$capture(access$capture, RangesKt___RangesKt.until(1, UrlParserKt.access$firstIndexOrEnd(access$capture, "?", ModelIdentifier.Helper.PRIMARY_KEY_DELIMITER)), new Function1<String, Unit>() { // from class: aws.smithy.kotlin.runtime.net.UrlParserKt$urlParseImpl$1.2
                public AnonymousClass2() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(String str) {
                    String it = str;
                    Intrinsics.checkNotNullParameter(it, "it");
                    String concat = "/".concat(aws.smithy.kotlin.runtime.util.text.TextKt.urlDecodeComponent$default(it));
                    UrlBuilder urlBuilder2 = UrlBuilder.this;
                    urlBuilder2.getClass();
                    Intrinsics.checkNotNullParameter(concat, "<set-?>");
                    urlBuilder2.path = concat;
                    return Unit.INSTANCE;
                }
            });
        }
        if (StringsKt__StringsJVMKt.startsWith(access$capture, "?", false)) {
            access$capture = UrlParserKt.access$capture(access$capture, RangesKt___RangesKt.until(1, UrlParserKt.access$firstIndexOrEnd(access$capture, ModelIdentifier.Helper.PRIMARY_KEY_DELIMITER)), new Function1<String, Unit>() { // from class: aws.smithy.kotlin.runtime.net.UrlParserKt$urlParseImpl$1.3
                public AnonymousClass3() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(String str) {
                    String it = str;
                    Intrinsics.checkNotNullParameter(it, "it");
                    for (Map.Entry entry : aws.smithy.kotlin.runtime.util.text.TextKt.splitAsQueryString(it).entrySet()) {
                        String str2 = (String) entry.getKey();
                        List list = (List) entry.getValue();
                        QueryParametersBuilder queryParametersBuilder = UrlBuilder.this.parameters;
                        String urlDecodeComponent$default = aws.smithy.kotlin.runtime.util.text.TextKt.urlDecodeComponent$default(str2);
                        List list2 = list;
                        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
                        Iterator it2 = list2.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(aws.smithy.kotlin.runtime.util.text.TextKt.urlDecodeComponent$default((String) it2.next()));
                        }
                        queryParametersBuilder.appendAll(urlDecodeComponent$default, arrayList);
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        if (StringsKt__StringsKt.startsWith$default((CharSequence) access$capture, '#') && access$capture.length() > 1) {
            String substring = access$capture.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            invoke.fragment = aws.smithy.kotlin.runtime.util.text.TextKt.urlDecodeComponent$default(substring);
        }
        return Unit.INSTANCE;
    }
}
