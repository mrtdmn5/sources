package io.ktor.utils.io.internal;

import aws.sdk.kotlin.runtime.endpoint.functions.FunctionsKt;
import aws.sdk.kotlin.runtime.endpoint.functions.PartitionConfig;
import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters;
import aws.sdk.kotlin.services.cognitoidentity.endpoints.internal.PartitionsKt;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.client.endpoints.EndpointProvider;
import aws.smithy.kotlin.runtime.client.endpoints.EndpointProviderException;
import aws.smithy.kotlin.runtime.net.UrlBuilder;
import aws.smithy.kotlin.runtime.net.UrlParserKt$urlParseImpl$1;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: Utils.kt */
/* loaded from: classes3.dex */
public final class UtilsKt implements EndpointProvider {
    public static final int getIOIntProperty(int r1, String str) {
        String str2;
        Integer intOrNull;
        try {
            str2 = System.getProperty("io.ktor.utils.io.".concat(str));
        } catch (SecurityException unused) {
            str2 = null;
        }
        if (str2 != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2)) != null) {
            return intOrNull.intValue();
        }
        return r1;
    }

    @Override // aws.smithy.kotlin.runtime.client.endpoints.EndpointProvider
    public Object resolveEndpoint(Object obj, Continuation continuation) {
        PartitionConfig partition;
        Endpoint endpoint;
        EndpointParameters endpointParameters = (EndpointParameters) obj;
        String str = endpointParameters.endpoint;
        Boolean bool = endpointParameters.useDualStack;
        Boolean bool2 = endpointParameters.useFips;
        if (str != null) {
            Boolean bool3 = Boolean.TRUE;
            if (!Intrinsics.areEqual(bool2, bool3)) {
                if (!Intrinsics.areEqual(bool, bool3)) {
                    String url = endpointParameters.endpoint;
                    Intrinsics.checkNotNullParameter(url, "url");
                    UrlParserKt$urlParseImpl$1 urlParserKt$urlParseImpl$1 = new UrlParserKt$urlParseImpl$1(url);
                    UrlBuilder urlBuilder = new UrlBuilder();
                    urlParserKt$urlParseImpl$1.invoke(urlBuilder);
                    return new Endpoint(urlBuilder.build());
                }
                throw new EndpointProviderException("Invalid Configuration: Dualstack and custom endpoint are not supported");
            }
            throw new EndpointProviderException("Invalid Configuration: FIPS and custom endpoint are not supported");
        }
        String str2 = endpointParameters.region;
        if (str2 != null && (partition = FunctionsKt.partition(str2, PartitionsKt.defaultPartitions)) != null) {
            Boolean bool4 = Boolean.TRUE;
            boolean areEqual = Intrinsics.areEqual(bool2, bool4);
            String str3 = partition.dualStackDnsSuffix;
            Boolean bool5 = partition.supportsDualStack;
            Boolean bool6 = partition.supportsFIPS;
            if (areEqual && Intrinsics.areEqual(bool, bool4)) {
                if (Intrinsics.areEqual(bool4, bool6) && Intrinsics.areEqual(bool4, bool5)) {
                    String url2 = "https://cognito-identity-fips." + str2 + '.' + str3;
                    Intrinsics.checkNotNullParameter(url2, "url");
                    UrlParserKt$urlParseImpl$1 urlParserKt$urlParseImpl$12 = new UrlParserKt$urlParseImpl$1(url2);
                    UrlBuilder urlBuilder2 = new UrlBuilder();
                    urlParserKt$urlParseImpl$12.invoke(urlBuilder2);
                    return new Endpoint(urlBuilder2.build());
                }
                throw new EndpointProviderException("FIPS and DualStack are enabled, but this partition does not support one or both");
            }
            boolean areEqual2 = Intrinsics.areEqual(bool2, bool4);
            String str4 = partition.dnsSuffix;
            if (areEqual2) {
                if (Intrinsics.areEqual(bool4, bool6)) {
                    String url3 = "https://cognito-identity-fips." + str2 + '.' + str4;
                    Intrinsics.checkNotNullParameter(url3, "url");
                    UrlParserKt$urlParseImpl$1 urlParserKt$urlParseImpl$13 = new UrlParserKt$urlParseImpl$1(url3);
                    UrlBuilder urlBuilder3 = new UrlBuilder();
                    urlParserKt$urlParseImpl$13.invoke(urlBuilder3);
                    endpoint = new Endpoint(urlBuilder3.build());
                } else {
                    throw new EndpointProviderException("FIPS is enabled but this partition does not support FIPS");
                }
            } else {
                if (Intrinsics.areEqual(bool, bool4)) {
                    if (Intrinsics.areEqual(bool4, bool5)) {
                        String url4 = "https://cognito-identity." + str2 + '.' + str3;
                        Intrinsics.checkNotNullParameter(url4, "url");
                        UrlParserKt$urlParseImpl$1 urlParserKt$urlParseImpl$14 = new UrlParserKt$urlParseImpl$1(url4);
                        UrlBuilder urlBuilder4 = new UrlBuilder();
                        urlParserKt$urlParseImpl$14.invoke(urlBuilder4);
                        return new Endpoint(urlBuilder4.build());
                    }
                    throw new EndpointProviderException("DualStack is enabled but this partition does not support DualStack");
                }
                String url5 = "https://cognito-identity." + str2 + '.' + str4;
                Intrinsics.checkNotNullParameter(url5, "url");
                UrlParserKt$urlParseImpl$1 urlParserKt$urlParseImpl$15 = new UrlParserKt$urlParseImpl$1(url5);
                UrlBuilder urlBuilder5 = new UrlBuilder();
                urlParserKt$urlParseImpl$15.invoke(urlBuilder5);
                endpoint = new Endpoint(urlBuilder5.build());
            }
            return endpoint;
        }
        throw new EndpointProviderException("Invalid Configuration: Missing Region");
    }
}
