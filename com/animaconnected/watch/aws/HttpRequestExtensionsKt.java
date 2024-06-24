package com.animaconnected.watch.aws;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.amazonaws.http.HttpHeader;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.notification.model.Contact;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.CodecsKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLBuilderKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.datetime.TimeZone;
import okio.ByteString;

/* compiled from: HttpRequestExtensions.kt */
/* loaded from: classes3.dex */
public final class HttpRequestExtensionsKt {
    private static final String SIGNING_ALGORITHM = "AWS4-HMAC-SHA256";
    private static final String XAmzDate = "x-amz-date";
    private static final String XAmzSecurityToken = "X-Amz-Security-Token";

    private static final String awsAuthorizationHeader(HttpRequestBuilder httpRequestBuilder, String str, String str2, String str3, String str4) {
        return StringsKt__StringsJVMKt.replace$default(StringsKt__IndentKt.trimMargin("\n    |AWS4-HMAC-SHA256 Credential=" + str + '/' + credentialScope(httpRequestBuilder, str3, str4) + ",\n    |SignedHeaders=" + signedHeaders(httpRequestBuilder) + ",\n    |Signature=" + signature(httpRequestBuilder, str2, str3, str4) + "\n    ", "|"), "\n", "");
    }

    private static final String awsDateHeader(HttpRequestBuilder httpRequestBuilder) {
        String str = httpRequestBuilder.headers.get("x-amz-date");
        if (str != null) {
            return str;
        }
        throw new NoSuchElementException("Request cannot be signed without having the x-amz-date header");
    }

    private static final String awsDateHeaderShort(HttpRequestBuilder httpRequestBuilder) {
        String str = httpRequestBuilder.headers.get("x-amz-date");
        if (str != null) {
            return StringsKt__StringsKt.substring(str, new IntRange(0, 7));
        }
        throw new NoSuchElementException("Request cannot be signed without having the x-amz-date header");
    }

    private static final String canonicalHeaders(HttpRequestBuilder httpRequestBuilder) {
        return CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt___CollectionsKt.sortedWith(httpRequestBuilder.headers.entries(), new Comparator() { // from class: com.animaconnected.watch.aws.HttpRequestExtensionsKt$canonicalHeaders$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                String str = (String) ((Map.Entry) t).getKey();
                Locale locale = Locale.ROOT;
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = ((String) ((Map.Entry) t2).getKey()).toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                return BorderStrokeKt.compareValues(lowerCase, lowerCase2);
            }
        }), "\n", null, null, new Function1<Map.Entry<? extends String, ? extends List<? extends String>>, CharSequence>() { // from class: com.animaconnected.watch.aws.HttpRequestExtensionsKt$canonicalHeaders$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends List<? extends String>> entry) {
                return invoke2((Map.Entry<String, ? extends List<String>>) entry);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Map.Entry<String, ? extends List<String>> entry) {
                Intrinsics.checkNotNullParameter(entry, "entry");
                String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(entry.getValue(), ",", null, null, new Function1<String, CharSequence>() { // from class: com.animaconnected.watch.aws.HttpRequestExtensionsKt$canonicalHeaders$2$values$1
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return StringsKt__StringsKt.trim(it).toString();
                    }
                }, 30);
                StringBuilder sb = new StringBuilder();
                String lowerCase = entry.getKey().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                sb.append(lowerCase);
                sb.append(':');
                sb.append(joinToString$default);
                return sb.toString();
            }
        }, 30);
    }

    private static final String canonicalQueryString(HttpRequestBuilder httpRequestBuilder) {
        Set<Map.Entry<String, List<String>>> entries = httpRequestBuilder.url.parameters.entries();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new Pair(str, (String) it2.next()));
            }
            CollectionsKt__ReversedViewsKt.addAll(arrayList2, arrayList);
        }
        boolean z = false;
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt___CollectionsKt.sortedWith(arrayList, BorderStrokeKt.compareBy(new Function1<Pair<? extends String, ? extends String>, Comparable<?>>() { // from class: com.animaconnected.watch.aws.HttpRequestExtensionsKt$canonicalQueryString$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Comparable<?> invoke2(Pair<String, String> it3) {
                Intrinsics.checkNotNullParameter(it3, "it");
                return it3.first;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Comparable<?> invoke(Pair<? extends String, ? extends String> pair) {
                return invoke2((Pair<String, String>) pair);
            }
        }, new Function1<Pair<? extends String, ? extends String>, Comparable<?>>() { // from class: com.animaconnected.watch.aws.HttpRequestExtensionsKt$canonicalQueryString$3
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Comparable<?> invoke2(Pair<String, String> it3) {
                Intrinsics.checkNotNullParameter(it3, "it");
                return it3.second;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Comparable<?> invoke(Pair<? extends String, ? extends String> pair) {
                return invoke2((Pair<String, String>) pair);
            }
        })), Contact.PHONE_NUMBERS_DELIMITER, null, null, new Function1<Pair<? extends String, ? extends String>, CharSequence>() { // from class: com.animaconnected.watch.aws.HttpRequestExtensionsKt$canonicalQueryString$4
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Pair<String, String> pair) {
                Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
                return CodecsKt.encodeURLParameter(pair.first, false) + '=' + CodecsKt.encodeURLParameter(pair.second, false);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Pair<? extends String, ? extends String> pair) {
                return invoke2((Pair<String, String>) pair);
            }
        }, 30);
        if (joinToString$default.length() == 0) {
            z = true;
        }
        if (z) {
            return "";
        }
        return joinToString$default;
    }

    private static final String canonicalRequest(HttpRequestBuilder httpRequestBuilder) {
        return StringsKt__IndentKt.trimMargin("\n    |" + httpRequestBuilder.method.value + "\n    |" + canonicalUri(httpRequestBuilder) + "\n    |" + canonicalQueryString(httpRequestBuilder) + "\n    |" + canonicalHeaders(httpRequestBuilder) + "\n    |\n    |" + signedHeaders(httpRequestBuilder) + "\n    |" + hashedPayload(httpRequestBuilder) + "\n    ", "|");
    }

    private static final String canonicalUri(HttpRequestBuilder httpRequestBuilder) {
        boolean z;
        String encodedPath = URLBuilderKt.getEncodedPath(httpRequestBuilder.url);
        if (encodedPath.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "/";
        }
        return encodedPath;
    }

    private static final String credentialScope(HttpRequestBuilder httpRequestBuilder, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(awsDateHeaderShort(httpRequestBuilder));
        sb.append('/');
        sb.append(str);
        sb.append('/');
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, str2, "/aws4_request");
    }

    private static final String hashedPayload(HttpRequestBuilder httpRequestBuilder) {
        Object obj = httpRequestBuilder.body;
        if (obj instanceof String) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            return HashingKt.hash((String) obj);
        }
        return HashingKt.hash("");
    }

    private static final String signature(HttpRequestBuilder httpRequestBuilder, String str, String str2, String str3) {
        ByteString byteString = ByteString.EMPTY;
        return ByteString.Companion.of$default(HashingKt.hmacSha256(HashingKt.hmacSha256(HashingKt.hmacSha256(HashingKt.hmacSha256(HashingKt.hmacSha256(ConstraintSet$$ExternalSyntheticOutline0.m("AWS4", str), awsDateHeaderShort(httpRequestBuilder)), str2), str3), "aws4_request"), stringToSign(httpRequestBuilder, str2, str3))).hex();
    }

    public static final void signed(HttpRequestBuilder httpRequestBuilder, String accessKeyId, String secretKey, String securityToken, String region, String service) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        HeadersBuilder headersBuilder = httpRequestBuilder.headers;
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        Intrinsics.checkNotNullParameter(securityToken, "securityToken");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(service, "service");
        try {
            DateFormatter iso8601Formatter = DateTimeFormattersKt.getIso8601Formatter(ServiceLocator.INSTANCE.getStringsBackend());
            long epochMilliseconds = DateTimeUtilsKt.now().toEpochMilliseconds();
            TimeZone.Companion.getClass();
            String format$default = DateFormatter.format$default(iso8601Formatter, epochMilliseconds, TimeZone.UTC, false, 4, null);
            List<String> list = HttpHeaders.UnsafeHeadersList;
            headersBuilder.append(HttpHeader.HOST, "api.apps.festinagroup.com");
            headersBuilder.append("x-amz-date", format$default);
            headersBuilder.append(XAmzSecurityToken, securityToken);
            headersBuilder.append(HttpHeader.AUTHORIZATION, awsAuthorizationHeader(httpRequestBuilder, accessKeyId, secretKey, region, service));
        } catch (Exception e) {
            LogKt.debug$default((Object) httpRequestBuilder, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.aws.HttpRequestExtensionsKt$signed$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Failed to add AWS authentication headers to the HTTP request. Error: "));
                }
            }, 7, (Object) null);
        }
    }

    private static final String signedHeaders(HttpRequestBuilder httpRequestBuilder) {
        Set<Map.Entry<String, List<String>>> entries = httpRequestBuilder.headers.entries();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(entries, 10));
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            String lowerCase = ((String) ((Map.Entry) it.next()).getKey()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            arrayList.add(lowerCase);
        }
        return CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt___CollectionsKt.sorted(arrayList), ";", null, null, null, 62);
    }

    private static final String stringToSign(HttpRequestBuilder httpRequestBuilder, String str, String str2) {
        return StringsKt__IndentKt.trimMargin("\n    |AWS4-HMAC-SHA256\n    |" + awsDateHeader(httpRequestBuilder) + "\n    |" + credentialScope(httpRequestBuilder, str, str2) + "\n    |" + HashingKt.hash(canonicalRequest(httpRequestBuilder)) + "\n    ", "|");
    }
}
