package io.ktor.http;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: ContentTypes.kt */
/* loaded from: classes3.dex */
public final class ContentType extends HeaderValueWithParameters {
    public static final ContentType Any = new ContentType("*", "*", EmptyList.INSTANCE);
    public final String contentSubtype;
    public final String contentType;

    /* compiled from: ContentTypes.kt */
    /* loaded from: classes3.dex */
    public static final class Application {
        public static final ContentType GZip;
        public static final ContentType Json;
        public static final ContentType OctetStream;

        static {
            EmptyList emptyList = EmptyList.INSTANCE;
            new ContentType("application", "*", emptyList);
            new ContentType("application", "atom+xml", emptyList);
            new ContentType("application", "cbor", emptyList);
            Json = new ContentType("application", "json", emptyList);
            new ContentType("application", "hal+json", emptyList);
            new ContentType("application", "javascript", emptyList);
            OctetStream = new ContentType("application", "octet-stream", emptyList);
            new ContentType("application", "rss+xml", emptyList);
            new ContentType("application", "xml", emptyList);
            new ContentType("application", "xml-dtd", emptyList);
            new ContentType("application", "zip", emptyList);
            GZip = new ContentType("application", "gzip", emptyList);
            new ContentType("application", "x-www-form-urlencoded", emptyList);
            new ContentType("application", "pdf", emptyList);
            new ContentType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet", emptyList);
            new ContentType("application", "vnd.openxmlformats-officedocument.wordprocessingml.document", emptyList);
            new ContentType("application", "vnd.openxmlformats-officedocument.presentationml.presentation", emptyList);
            new ContentType("application", "protobuf", emptyList);
            new ContentType("application", "wasm", emptyList);
            new ContentType("application", "problem+json", emptyList);
            new ContentType("application", "problem+xml", emptyList);
        }
    }

    /* compiled from: ContentTypes.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static ContentType parse(String str) {
            boolean z;
            if (StringsKt__StringsJVMKt.isBlank(str)) {
                return ContentType.Any;
            }
            HeaderValue headerValue = (HeaderValue) CollectionsKt___CollectionsKt.last(HttpHeaderValueParserKt.parseHeaderValue(str));
            String str2 = headerValue.value;
            boolean z2 = false;
            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, '/', 0, false, 6);
            if (indexOf$default == -1) {
                if (Intrinsics.areEqual(StringsKt__StringsKt.trim(str2).toString(), "*")) {
                    return ContentType.Any;
                }
                throw new BadContentTypeFormatException(str);
            }
            String substring = str2.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String obj = StringsKt__StringsKt.trim(substring).toString();
            if (obj.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                String substring2 = str2.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                String obj2 = StringsKt__StringsKt.trim(substring2).toString();
                if (!StringsKt__StringsKt.contains$default(obj, ' ') && !StringsKt__StringsKt.contains$default(obj2, ' ')) {
                    if (obj2.length() == 0) {
                        z2 = true;
                    }
                    if (!z2 && !StringsKt__StringsKt.contains$default(obj2, '/')) {
                        return new ContentType(obj, obj2, headerValue.params);
                    }
                    throw new BadContentTypeFormatException(str);
                }
                throw new BadContentTypeFormatException(str);
            }
            throw new BadContentTypeFormatException(str);
        }
    }

    /* compiled from: ContentTypes.kt */
    /* loaded from: classes3.dex */
    public static final class MultiPart {
        public static final ContentType FormData;

        static {
            EmptyList emptyList = EmptyList.INSTANCE;
            new ContentType("multipart", "*", emptyList);
            new ContentType("multipart", "mixed", emptyList);
            new ContentType("multipart", "alternative", emptyList);
            new ContentType("multipart", "related", emptyList);
            FormData = new ContentType("multipart", "form-data", emptyList);
            new ContentType("multipart", "signed", emptyList);
            new ContentType("multipart", "encrypted", emptyList);
            new ContentType("multipart", "byteranges", emptyList);
        }
    }

    /* compiled from: ContentTypes.kt */
    /* loaded from: classes3.dex */
    public static final class Text {
        public static final ContentType Plain;

        static {
            EmptyList emptyList = EmptyList.INSTANCE;
            new ContentType("text", "*", emptyList);
            Plain = new ContentType("text", "plain", emptyList);
            new ContentType("text", "css", emptyList);
            new ContentType("text", "csv", emptyList);
            new ContentType("text", "html", emptyList);
            new ContentType("text", "javascript", emptyList);
            new ContentType("text", "vcard", emptyList);
            new ContentType("text", "xml", emptyList);
            new ContentType("text", "event-stream", emptyList);
        }
    }

    public ContentType(String str, String str2, String str3, List<HeaderValueParam> list) {
        super(str3, list);
        this.contentType = str;
        this.contentSubtype = str2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ContentType) {
            ContentType contentType = (ContentType) obj;
            if (StringsKt__StringsJVMKt.equals(this.contentType, contentType.contentType) && StringsKt__StringsJVMKt.equals(this.contentSubtype, contentType.contentSubtype)) {
                if (Intrinsics.areEqual(this.parameters, contentType.parameters)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Locale locale = Locale.ROOT;
        String lowerCase = this.contentType.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int hashCode = lowerCase.hashCode();
        String lowerCase2 = this.contentSubtype.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return (this.parameters.hashCode() * 31) + lowerCase2.hashCode() + (hashCode * 31) + hashCode;
    }

    public final boolean match(ContentType pattern) {
        boolean z;
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        String str = pattern.contentType;
        if (!Intrinsics.areEqual(str, "*") && !StringsKt__StringsJVMKt.equals(str, this.contentType)) {
            return false;
        }
        String str2 = pattern.contentSubtype;
        if (!Intrinsics.areEqual(str2, "*") && !StringsKt__StringsJVMKt.equals(str2, this.contentSubtype)) {
            return false;
        }
        Iterator<HeaderValueParam> it = pattern.parameters.iterator();
        do {
            z = true;
            if (!it.hasNext()) {
                return true;
            }
            HeaderValueParam next = it.next();
            String str3 = next.name;
            boolean areEqual = Intrinsics.areEqual(str3, "*");
            String str4 = next.value;
            if (areEqual) {
                if (!Intrinsics.areEqual(str4, "*")) {
                    List<HeaderValueParam> list = this.parameters;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it2 = list.iterator();
                        while (it2.hasNext()) {
                            if (StringsKt__StringsJVMKt.equals(((HeaderValueParam) it2.next()).value, str4)) {
                                break;
                            }
                        }
                    }
                    z = false;
                }
            } else {
                String parameter = parameter(str3);
                if (Intrinsics.areEqual(str4, "*")) {
                    if (parameter != null) {
                    }
                    z = false;
                } else {
                    z = StringsKt__StringsJVMKt.equals(parameter, str4);
                }
            }
        } while (z);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:            if (kotlin.text.StringsKt__StringsJVMKt.equals(r1.value, r8) != false) goto L26;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final io.ktor.http.ContentType withParameter(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.util.List<io.ktor.http.HeaderValueParam> r0 = r6.parameters
            int r1 = r0.size()
            r2 = 0
            if (r1 == 0) goto L5f
            r3 = 1
            if (r1 == r3) goto L48
            r1 = r0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r4 = r1 instanceof java.util.Collection
            if (r4 == 0) goto L22
            r4 = r1
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L22
            goto L5f
        L22:
            java.util.Iterator r1 = r1.iterator()
        L26:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L5f
            java.lang.Object r4 = r1.next()
            io.ktor.http.HeaderValueParam r4 = (io.ktor.http.HeaderValueParam) r4
            java.lang.String r5 = r4.name
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.equals(r5, r7)
            if (r5 == 0) goto L44
            java.lang.String r4 = r4.value
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r8)
            if (r4 == 0) goto L44
            r4 = r3
            goto L45
        L44:
            r4 = r2
        L45:
            if (r4 == 0) goto L26
            goto L5e
        L48:
            java.lang.Object r1 = r0.get(r2)
            io.ktor.http.HeaderValueParam r1 = (io.ktor.http.HeaderValueParam) r1
            java.lang.String r4 = r1.name
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r7)
            if (r4 == 0) goto L5f
            java.lang.String r1 = r1.value
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.equals(r1, r8)
            if (r1 == 0) goto L5f
        L5e:
            r2 = r3
        L5f:
            if (r2 == 0) goto L62
            return r6
        L62:
            io.ktor.http.ContentType r1 = new io.ktor.http.ContentType
            java.util.Collection r0 = (java.util.Collection) r0
            io.ktor.http.HeaderValueParam r2 = new io.ktor.http.HeaderValueParam
            r2.<init>(r7, r8)
            java.util.ArrayList r7 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r0, r2)
            java.lang.String r8 = r6.contentSubtype
            java.lang.String r0 = r6.content
            java.lang.String r2 = r6.contentType
            r1.<init>(r2, r8, r0, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.ContentType.withParameter(java.lang.String, java.lang.String):io.ktor.http.ContentType");
    }

    public /* synthetic */ ContentType(String str, String str2) {
        this(str, str2, EmptyList.INSTANCE);
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public ContentType(String contentType, String contentSubtype, List<HeaderValueParam> parameters) {
        this(contentType, contentSubtype, contentType + '/' + contentSubtype, parameters);
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentSubtype, "contentSubtype");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
    }
}
