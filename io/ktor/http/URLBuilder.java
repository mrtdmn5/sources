package io.ktor.http;

import io.ktor.utils.io.charsets.EncodingKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: URLBuilder.kt */
/* loaded from: classes3.dex */
public final class URLBuilder {
    public static final Url originUrl;
    public String encodedFragment;
    public ParametersBuilder encodedParameters;
    public String encodedPassword;
    public List<String> encodedPathSegments;
    public String encodedUser;
    public String host;
    public UrlDecodedParametersBuilder parameters;
    public int port;
    public URLProtocol protocol;
    public boolean trailingQuery;

    static {
        URLBuilder uRLBuilder = new URLBuilder(null);
        URLParserKt.takeFrom(uRLBuilder, "http://localhost");
        originUrl = uRLBuilder.build();
    }

    public URLBuilder() {
        this(null);
    }

    public final void applyOrigin() {
        boolean z;
        if (this.host.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z && !Intrinsics.areEqual(this.protocol.name, "file")) {
            Url url = originUrl;
            this.host = url.host;
            URLProtocol uRLProtocol = this.protocol;
            URLProtocol uRLProtocol2 = URLProtocol.HTTP;
            if (Intrinsics.areEqual(uRLProtocol, URLProtocol.HTTP)) {
                this.protocol = url.protocol;
            }
            if (this.port == 0) {
                this.port = url.specifiedPort;
            }
        }
    }

    public final Url build() {
        String str;
        String str2;
        applyOrigin();
        URLProtocol uRLProtocol = this.protocol;
        String str3 = this.host;
        int r3 = this.port;
        List<String> list = this.encodedPathSegments;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.decodeURLPart$default((String) it.next()));
        }
        Parameters decodeParameters = UrlDecodedParametersBuilderKt.decodeParameters(this.parameters.encodedParametersBuilder);
        String decodeURLQueryComponent$default = CodecsKt.decodeURLQueryComponent$default(this.encodedFragment, 0, 0, false, 15);
        String str4 = this.encodedUser;
        if (str4 != null) {
            str = CodecsKt.decodeURLPart$default(str4);
        } else {
            str = null;
        }
        String str5 = this.encodedPassword;
        if (str5 != null) {
            str2 = CodecsKt.decodeURLPart$default(str5);
        } else {
            str2 = null;
        }
        return new Url(uRLProtocol, str3, r3, arrayList, decodeParameters, decodeURLQueryComponent$default, str, str2, this.trailingQuery, buildString());
    }

    public final String buildString() {
        applyOrigin();
        StringBuilder sb = new StringBuilder(256);
        URLBuilderKt.access$appendTo(this, sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "appendTo(StringBuilder(256)).toString()");
        return sb2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(256);
        URLBuilderKt.access$appendTo(this, sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "appendTo(StringBuilder(256)).toString()");
        return sb2;
    }

    public URLBuilder(Object obj) {
        URLProtocol protocol = URLProtocol.HTTP;
        EmptyList<String> emptyList = EmptyList.INSTANCE;
        Parameters.Companion.getClass();
        EmptyParameters emptyParameters = EmptyParameters.INSTANCE;
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        this.protocol = protocol;
        this.host = "";
        final boolean z = false;
        this.port = 0;
        this.trailingQuery = false;
        this.encodedUser = null;
        this.encodedPassword = null;
        Set<Byte> set = CodecsKt.URL_ALPHABET;
        Charset charset = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter(charset, "charset");
        final StringBuilder sb = new StringBuilder();
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
        CodecsKt.forEach(EncodingKt.encode(newEncoder, "", 0, "".length()), new Function1<Byte, Unit>() { // from class: io.ktor.http.CodecsKt$encodeURLQueryComponent$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Byte b) {
                byte byteValue = b.byteValue();
                StringBuilder sb2 = sb;
                if (byteValue == 32) {
                    if (z) {
                        sb2.append('+');
                    } else {
                        sb2.append("%20");
                    }
                } else if (!CodecsKt.URL_ALPHABET.contains(Byte.valueOf(byteValue)) && (z || !CodecsKt.URL_PROTOCOL_PART.contains(Byte.valueOf(byteValue)))) {
                    sb2.append(CodecsKt.access$percentEncode(byteValue));
                } else {
                    sb2.append((char) byteValue);
                }
                return Unit.INSTANCE;
            }
        });
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        this.encodedFragment = sb2;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(emptyList, 10));
        for (String str : emptyList) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            arrayList.add(CodecsKt.encodeURLPath(str, true));
        }
        this.encodedPathSegments = arrayList;
        ParametersBuilderImpl ParametersBuilder$default = ParametersKt.ParametersBuilder$default();
        UrlDecodedParametersBuilderKt.appendAllEncoded(ParametersBuilder$default, emptyParameters);
        this.encodedParameters = ParametersBuilder$default;
        this.parameters = new UrlDecodedParametersBuilder(ParametersBuilder$default);
    }
}
