package io.ktor.http;

import com.animaconnected.secondo.notification.model.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: URLBuilder.kt */
/* loaded from: classes3.dex */
public final class URLBuilderKt {
    public static final void access$appendTo(URLBuilder uRLBuilder, StringBuilder sb) {
        List list;
        sb.append(uRLBuilder.protocol.name);
        String str = uRLBuilder.protocol.name;
        if (Intrinsics.areEqual(str, "file")) {
            CharSequence charSequence = uRLBuilder.host;
            CharSequence encodedPath = getEncodedPath(uRLBuilder);
            sb.append("://");
            sb.append(charSequence);
            if (!StringsKt__StringsKt.startsWith$default(encodedPath, '/')) {
                sb.append('/');
            }
            sb.append(encodedPath);
            return;
        }
        if (Intrinsics.areEqual(str, "mailto")) {
            StringBuilder sb2 = new StringBuilder();
            String str2 = uRLBuilder.encodedUser;
            String str3 = uRLBuilder.encodedPassword;
            if (str2 != null) {
                sb2.append(str2);
                if (str3 != null) {
                    sb2.append(':');
                    sb2.append(str3);
                }
                sb2.append("@");
            }
            CharSequence sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
            CharSequence charSequence2 = uRLBuilder.host;
            sb.append(":");
            sb.append(sb3);
            sb.append(charSequence2);
            return;
        }
        sb.append("://");
        sb.append(getAuthority(uRLBuilder));
        String encodedPath2 = getEncodedPath(uRLBuilder);
        ParametersBuilder encodedQueryParameters = uRLBuilder.encodedParameters;
        boolean z = uRLBuilder.trailingQuery;
        Intrinsics.checkNotNullParameter(encodedPath2, "encodedPath");
        Intrinsics.checkNotNullParameter(encodedQueryParameters, "encodedQueryParameters");
        boolean z2 = true;
        if ((!StringsKt__StringsJVMKt.isBlank(encodedPath2)) && !StringsKt__StringsJVMKt.startsWith(encodedPath2, "/", false)) {
            sb.append('/');
        }
        sb.append((CharSequence) encodedPath2);
        if (!encodedQueryParameters.isEmpty() || z) {
            sb.append("?");
        }
        Set<Map.Entry<String, List<String>>> entries = encodedQueryParameters.entries();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str4 = (String) entry.getKey();
            List list2 = (List) entry.getValue();
            if (list2.isEmpty()) {
                list = CollectionsKt__CollectionsKt.listOf(new Pair(str4, null));
            } else {
                List list3 = list2;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list3, 10));
                Iterator it2 = list3.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new Pair(str4, (String) it2.next()));
                }
                list = arrayList2;
            }
            CollectionsKt__ReversedViewsKt.addAll(list, arrayList);
        }
        CollectionsKt___CollectionsKt.joinTo$default(arrayList, sb, Contact.PHONE_NUMBERS_DELIMITER, new Function1<Pair<? extends String, ? extends String>, CharSequence>() { // from class: io.ktor.http.URLUtilsKt$appendUrlFullPath$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Pair<? extends String, ? extends String> pair) {
                Pair<? extends String, ? extends String> it3 = pair;
                Intrinsics.checkNotNullParameter(it3, "it");
                String str5 = (String) it3.first;
                B b = it3.second;
                if (b != 0) {
                    return str5 + '=' + String.valueOf(b);
                }
                return str5;
            }
        }, 60);
        if (uRLBuilder.encodedFragment.length() <= 0) {
            z2 = false;
        }
        if (z2) {
            sb.append('#');
            sb.append(uRLBuilder.encodedFragment);
        }
    }

    public static final String getAuthority(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String str = uRLBuilder.encodedUser;
        String str2 = uRLBuilder.encodedPassword;
        if (str != null) {
            sb2.append(str);
            if (str2 != null) {
                sb2.append(':');
                sb2.append(str2);
            }
            sb2.append("@");
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        sb.append(sb3);
        sb.append(uRLBuilder.host);
        int r1 = uRLBuilder.port;
        if (r1 != 0 && r1 != uRLBuilder.protocol.defaultPort) {
            sb.append(":");
            sb.append(String.valueOf(uRLBuilder.port));
        }
        String sb4 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        return sb4;
    }

    public static final String getEncodedPath(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        List<String> list = uRLBuilder.encodedPathSegments;
        if (list.isEmpty()) {
            return "";
        }
        boolean z = true;
        if (list.size() == 1) {
            if (((CharSequence) CollectionsKt___CollectionsKt.first((List) list)).length() != 0) {
                z = false;
            }
            if (z) {
                return "/";
            }
            return (String) CollectionsKt___CollectionsKt.first((List) list);
        }
        return CollectionsKt___CollectionsKt.joinToString$default(list, "/", null, null, null, 62);
    }

    public static final void setEncodedPath(URLBuilder uRLBuilder, String value) {
        List<String> mutableList;
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt__StringsJVMKt.isBlank(value)) {
            mutableList = EmptyList.INSTANCE;
        } else if (Intrinsics.areEqual(value, "/")) {
            mutableList = URLParserKt.ROOT_PATH;
        } else {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) StringsKt__StringsKt.split$default(0, 6, value, new char[]{'/'}));
        }
        Intrinsics.checkNotNullParameter(mutableList, "<set-?>");
        uRLBuilder.encodedPathSegments = mutableList;
    }
}
