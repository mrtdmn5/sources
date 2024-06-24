package com.animaconnected.watch.account;

import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AccountHttpClient.kt */
@Serializable
/* loaded from: classes3.dex */
public final class ErrorResponse {
    public static final Companion Companion = new Companion(null);
    private String message;
    private Integer statusCode;
    private Boolean success;

    /* compiled from: AccountHttpClient.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ErrorResponse> serializer() {
            return ErrorResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public ErrorResponse() {
        this((Integer) null, (String) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ErrorResponse copy$default(ErrorResponse errorResponse, Integer num, String str, Boolean bool, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            num = errorResponse.statusCode;
        }
        if ((r4 & 2) != 0) {
            str = errorResponse.message;
        }
        if ((r4 & 4) != 0) {
            bool = errorResponse.success;
        }
        return errorResponse.copy(num, str, bool);
    }

    public static final /* synthetic */ void write$Self$watch_release(ErrorResponse errorResponse, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        Integer num;
        boolean z3 = false;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || (num = errorResponse.statusCode) == null || num.intValue() != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, errorResponse.statusCode);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(errorResponse.message, "")) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, errorResponse.message);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(errorResponse.success, Boolean.FALSE)) {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, errorResponse.success);
        }
    }

    public final Integer component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.message;
    }

    public final Boolean component3() {
        return this.success;
    }

    public final ErrorResponse copy(Integer num, String str, Boolean bool) {
        return new ErrorResponse(num, str, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorResponse)) {
            return false;
        }
        ErrorResponse errorResponse = (ErrorResponse) obj;
        if (Intrinsics.areEqual(this.statusCode, errorResponse.statusCode) && Intrinsics.areEqual(this.message, errorResponse.message) && Intrinsics.areEqual(this.success, errorResponse.success)) {
            return true;
        }
        return false;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        Integer num = this.statusCode;
        int r1 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int r0 = hashCode * 31;
        String str = this.message;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        Boolean bool = this.success;
        if (bool != null) {
            r1 = bool.hashCode();
        }
        return r02 + r1;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setStatusCode(Integer num) {
        this.statusCode = num;
    }

    public final void setSuccess(Boolean bool) {
        this.success = bool;
    }

    public String toString() {
        return "ErrorResponse(statusCode=" + this.statusCode + ", message=" + this.message + ", success=" + this.success + ')';
    }

    public /* synthetic */ ErrorResponse(int r2, Integer num, String str, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if ((r2 & 0) != 0) {
            zzac.throwMissingFieldException(r2, 0, ErrorResponse$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.statusCode = (r2 & 1) == 0 ? 0 : num;
        if ((r2 & 2) == 0) {
            this.message = "";
        } else {
            this.message = str;
        }
        if ((r2 & 4) == 0) {
            this.success = Boolean.FALSE;
        } else {
            this.success = bool;
        }
    }

    public ErrorResponse(Integer num, String str, Boolean bool) {
        this.statusCode = num;
        this.message = str;
        this.success = bool;
    }

    public /* synthetic */ ErrorResponse(Integer num, String str, Boolean bool, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? 0 : num, (r4 & 2) != 0 ? "" : str, (r4 & 4) != 0 ? Boolean.FALSE : bool);
    }
}
