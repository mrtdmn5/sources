package com.google.android.gms.measurement.internal;

import aws.sdk.kotlin.runtime.AwsServiceException;
import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.awsprotocol.ErrorDetails;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.util.AttributeKey;
import aws.smithy.kotlin.runtime.util.AttributesImpl;
import com.amazonaws.services.s3.Headers;
import com.google.android.gms.internal.measurement.zznz;
import com.google.android.gms.internal.measurement.zzoa;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzcc implements zzdq {
    public static final /* synthetic */ zzcc zza = new zzcc();

    public static final void setAseErrorMetadata(AwsServiceException exception, HttpResponse response, ErrorDetails errorDetails) {
        String str;
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(response, "response");
        AttributesImpl attributesImpl = exception.getSdkErrorMetadata().attributes;
        AttributeKey<String> key = ServiceErrorMetadata.ErrorCode;
        String str2 = null;
        if (errorDetails != null) {
            str = errorDetails.code;
        } else {
            str = null;
        }
        Intrinsics.checkNotNullParameter(attributesImpl, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (str != null) {
            attributesImpl.set(key, str);
        }
        AttributesImpl attributesImpl2 = exception.getSdkErrorMetadata().attributes;
        AttributeKey<String> key2 = ServiceErrorMetadata.ErrorMessage;
        if (errorDetails != null) {
            str2 = errorDetails.message;
        }
        Intrinsics.checkNotNullParameter(attributesImpl2, "<this>");
        Intrinsics.checkNotNullParameter(key2, "key");
        if (str2 != null) {
            attributesImpl2.set(key2, str2);
        }
        AttributesImpl attributesImpl3 = exception.getSdkErrorMetadata().attributes;
        AttributeKey<String> key3 = ServiceErrorMetadata.RequestId;
        String str3 = response.headers.get(Headers.REQUEST_ID);
        Intrinsics.checkNotNullParameter(attributesImpl3, "<this>");
        Intrinsics.checkNotNullParameter(key3, "key");
        if (str3 != null) {
            attributesImpl3.set(key3, str3);
        }
        exception.getSdkErrorMetadata().attributes.set(ServiceErrorMetadata.ProtocolResponse, response);
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(((zzoa) zznz.zza.zzb.zza()).zzc());
    }
}
