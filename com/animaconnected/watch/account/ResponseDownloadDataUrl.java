package com.animaconnected.watch.account;

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

/* compiled from: AccountHttpClient.kt */
@Serializable
/* loaded from: classes3.dex */
public final class ResponseDownloadDataUrl {
    public static final Companion Companion = new Companion(null);
    private final Data data;

    /* compiled from: AccountHttpClient.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ResponseDownloadDataUrl> serializer() {
            return ResponseDownloadDataUrl$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* compiled from: AccountHttpClient.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class Data {
        public static final Companion Companion = new Companion(null);
        private final Long expirationTime;
        private final String url;

        /* compiled from: AccountHttpClient.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Data> serializer() {
                return ResponseDownloadDataUrl$Data$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public Data() {
            this((String) null, (Long) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ Data copy$default(Data data, String str, Long l, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = data.url;
            }
            if ((r3 & 2) != 0) {
                l = data.expirationTime;
            }
            return data.copy(str, l);
        }

        public static final /* synthetic */ void write$Self$watch_release(Data data, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z;
            boolean z2 = false;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || data.url != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, data.url);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || data.expirationTime != null) {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, data.expirationTime);
            }
        }

        public final String component1() {
            return this.url;
        }

        public final Long component2() {
            return this.expirationTime;
        }

        public final Data copy(String str, Long l) {
            return new Data(str, l);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            if (Intrinsics.areEqual(this.url, data.url) && Intrinsics.areEqual(this.expirationTime, data.expirationTime)) {
                return true;
            }
            return false;
        }

        public final Long getExpirationTime() {
            return this.expirationTime;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int hashCode;
            String str = this.url;
            int r1 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int r0 = hashCode * 31;
            Long l = this.expirationTime;
            if (l != null) {
                r1 = l.hashCode();
            }
            return r0 + r1;
        }

        public String toString() {
            return "Data(url=" + this.url + ", expirationTime=" + this.expirationTime + ')';
        }

        public /* synthetic */ Data(int r2, String str, Long l, SerializationConstructorMarker serializationConstructorMarker) {
            if ((r2 & 0) != 0) {
                zzac.throwMissingFieldException(r2, 0, ResponseDownloadDataUrl$Data$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            if ((r2 & 1) == 0) {
                this.url = null;
            } else {
                this.url = str;
            }
            if ((r2 & 2) == 0) {
                this.expirationTime = null;
            } else {
                this.expirationTime = l;
            }
        }

        public Data(String str, Long l) {
            this.url = str;
            this.expirationTime = l;
        }

        public /* synthetic */ Data(String str, Long l, int r4, DefaultConstructorMarker defaultConstructorMarker) {
            this((r4 & 1) != 0 ? null : str, (r4 & 2) != 0 ? null : l);
        }
    }

    public /* synthetic */ ResponseDownloadDataUrl(int r2, Data data, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 == (r2 & 1)) {
            this.data = data;
        } else {
            zzac.throwMissingFieldException(r2, 1, ResponseDownloadDataUrl$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
    }

    public static /* synthetic */ ResponseDownloadDataUrl copy$default(ResponseDownloadDataUrl responseDownloadDataUrl, Data data, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            data = responseDownloadDataUrl.data;
        }
        return responseDownloadDataUrl.copy(data);
    }

    public final Data component1() {
        return this.data;
    }

    public final ResponseDownloadDataUrl copy(Data data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new ResponseDownloadDataUrl(data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ResponseDownloadDataUrl) && Intrinsics.areEqual(this.data, ((ResponseDownloadDataUrl) obj).data)) {
            return true;
        }
        return false;
    }

    public final Data getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "ResponseDownloadDataUrl(data=" + this.data + ')';
    }

    public ResponseDownloadDataUrl(Data data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }
}
