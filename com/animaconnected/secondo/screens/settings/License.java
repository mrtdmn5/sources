package com.animaconnected.secondo.screens.settings;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: OpenSourceLicenses.kt */
@Serializable
/* loaded from: classes3.dex */
public final class License {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String license;
    private final String license_url;

    /* compiled from: OpenSourceLicenses.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<License> serializer() {
            return License$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ License(int r2, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (r2 & 3)) {
            zzac.throwMissingFieldException(r2, 3, License$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.license = str;
        this.license_url = str2;
    }

    public static /* synthetic */ License copy$default(License license, String str, String str2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            str = license.license;
        }
        if ((r3 & 2) != 0) {
            str2 = license.license_url;
        }
        return license.copy(str, str2);
    }

    public static final /* synthetic */ void write$Self$secondo_kronabyRelease(License license, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, license.license);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, license.license_url);
    }

    public final String component1() {
        return this.license;
    }

    public final String component2() {
        return this.license_url;
    }

    public final License copy(String str, String str2) {
        return new License(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof License)) {
            return false;
        }
        License license = (License) obj;
        if (Intrinsics.areEqual(this.license, license.license) && Intrinsics.areEqual(this.license_url, license.license_url)) {
            return true;
        }
        return false;
    }

    public final String getLicense() {
        return this.license;
    }

    public final String getLicense_url() {
        return this.license_url;
    }

    public int hashCode() {
        int hashCode;
        String str = this.license;
        int r1 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = hashCode * 31;
        String str2 = this.license_url;
        if (str2 != null) {
            r1 = str2.hashCode();
        }
        return r0 + r1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("License(license=");
        sb.append(this.license);
        sb.append(", license_url=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.license_url, ')');
    }

    public License(String str, String str2) {
        this.license = str;
        this.license_url = str2;
    }
}
