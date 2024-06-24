package io.ktor.http;

import io.ktor.util.StringValuesKt;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: URLUtils.kt */
/* loaded from: classes3.dex */
public final class URLUtilsKt {
    public static final Url Url(URLBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        URLBuilder uRLBuilder = new URLBuilder(null);
        takeFrom(uRLBuilder, builder);
        return uRLBuilder.build();
    }

    public static final void takeFrom(URLBuilder uRLBuilder, URLBuilder url) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        URLProtocol uRLProtocol = url.protocol;
        Intrinsics.checkNotNullParameter(uRLProtocol, "<set-?>");
        uRLBuilder.protocol = uRLProtocol;
        String str = url.host;
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        uRLBuilder.host = str;
        uRLBuilder.port = url.port;
        List<String> list = url.encodedPathSegments;
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        uRLBuilder.encodedPathSegments = list;
        uRLBuilder.encodedUser = url.encodedUser;
        uRLBuilder.encodedPassword = url.encodedPassword;
        ParametersBuilderImpl ParametersBuilder$default = ParametersKt.ParametersBuilder$default();
        StringValuesKt.appendAll(ParametersBuilder$default, url.encodedParameters);
        uRLBuilder.encodedParameters = ParametersBuilder$default;
        uRLBuilder.parameters = new UrlDecodedParametersBuilder(ParametersBuilder$default);
        String str2 = url.encodedFragment;
        Intrinsics.checkNotNullParameter(str2, "<set-?>");
        uRLBuilder.encodedFragment = str2;
        uRLBuilder.trailingQuery = url.trailingQuery;
    }
}
