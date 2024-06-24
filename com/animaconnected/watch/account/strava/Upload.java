package com.animaconnected.watch.account.strava;

import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Upload.kt */
@Serializable
/* loaded from: classes3.dex */
public final class Upload {
    public static final Companion Companion = new Companion(null);
    private final Long activityId;
    private final String error;
    private final String externalId;
    private final Long id;
    private final String idString;
    private final String status;

    /* compiled from: Upload.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Upload> serializer() {
            return Upload$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Upload(int r2, Long l, String str, String str2, String str3, String str4, Long l2, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (r2 & 63)) {
            zzac.throwMissingFieldException(r2, 63, Upload$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.id = l;
        this.idString = str;
        this.externalId = str2;
        this.error = str3;
        this.status = str4;
        this.activityId = l2;
    }

    public static /* synthetic */ Upload copy$default(Upload upload, Long l, String str, String str2, String str3, String str4, Long l2, int r11, Object obj) {
        if ((r11 & 1) != 0) {
            l = upload.id;
        }
        if ((r11 & 2) != 0) {
            str = upload.idString;
        }
        String str5 = str;
        if ((r11 & 4) != 0) {
            str2 = upload.externalId;
        }
        String str6 = str2;
        if ((r11 & 8) != 0) {
            str3 = upload.error;
        }
        String str7 = str3;
        if ((r11 & 16) != 0) {
            str4 = upload.status;
        }
        String str8 = str4;
        if ((r11 & 32) != 0) {
            l2 = upload.activityId;
        }
        return upload.copy(l, str5, str6, str7, str8, l2);
    }

    public static final /* synthetic */ void write$Self$watch_release(Upload upload, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, longSerializer, upload.id);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, upload.idString);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, upload.externalId);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, upload.error);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, upload.status);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, longSerializer, upload.activityId);
    }

    public final Long component1() {
        return this.id;
    }

    public final String component2() {
        return this.idString;
    }

    public final String component3() {
        return this.externalId;
    }

    public final String component4() {
        return this.error;
    }

    public final String component5() {
        return this.status;
    }

    public final Long component6() {
        return this.activityId;
    }

    public final Upload copy(Long l, String str, String str2, String str3, String str4, Long l2) {
        return new Upload(l, str, str2, str3, str4, l2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Upload)) {
            return false;
        }
        Upload upload = (Upload) obj;
        if (Intrinsics.areEqual(this.id, upload.id) && Intrinsics.areEqual(this.idString, upload.idString) && Intrinsics.areEqual(this.externalId, upload.externalId) && Intrinsics.areEqual(this.error, upload.error) && Intrinsics.areEqual(this.status, upload.status) && Intrinsics.areEqual(this.activityId, upload.activityId)) {
            return true;
        }
        return false;
    }

    public final Long getActivityId() {
        return this.activityId;
    }

    public final String getError() {
        return this.error;
    }

    public final String getExternalId() {
        return this.externalId;
    }

    public final Long getId() {
        return this.id;
    }

    public final String getIdString() {
        return this.idString;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        Long l = this.id;
        int r1 = 0;
        if (l == null) {
            hashCode = 0;
        } else {
            hashCode = l.hashCode();
        }
        int r0 = hashCode * 31;
        String str = this.idString;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        String str2 = this.externalId;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        String str3 = this.error;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        String str4 = this.status;
        if (str4 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str4.hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        Long l2 = this.activityId;
        if (l2 != null) {
            r1 = l2.hashCode();
        }
        return r05 + r1;
    }

    public String toString() {
        return "Upload(id=" + this.id + ", idString=" + this.idString + ", externalId=" + this.externalId + ", error=" + this.error + ", status=" + this.status + ", activityId=" + this.activityId + ')';
    }

    public Upload(Long l, String str, String str2, String str3, String str4, Long l2) {
        this.id = l;
        this.idString = str;
        this.externalId = str2;
        this.error = str3;
        this.status = str4;
        this.activityId = l2;
    }

    public static /* synthetic */ void getActivityId$annotations() {
    }

    public static /* synthetic */ void getExternalId$annotations() {
    }

    public static /* synthetic */ void getIdString$annotations() {
    }
}
