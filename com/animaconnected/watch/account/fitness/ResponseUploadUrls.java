package com.animaconnected.watch.account.fitness;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: FitnessHttpClient.kt */
@Serializable
/* loaded from: classes3.dex */
public final class ResponseUploadUrls {
    private final List<Data> data;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(ResponseUploadUrls$Data$$serializer.INSTANCE)};

    /* compiled from: FitnessHttpClient.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ResponseUploadUrls> serializer() {
            return ResponseUploadUrls$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* compiled from: FitnessHttpClient.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class Data {
        public static final Companion Companion = new Companion(null);
        private final String date;
        private final String url;

        /* compiled from: FitnessHttpClient.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Data> serializer() {
                return ResponseUploadUrls$Data$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Data(int r2, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (r2 & 3)) {
                zzac.throwMissingFieldException(r2, 3, ResponseUploadUrls$Data$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.date = str;
            this.url = str2;
        }

        public static /* synthetic */ Data copy$default(Data data, String str, String str2, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = data.date;
            }
            if ((r3 & 2) != 0) {
                str2 = data.url;
            }
            return data.copy(str, str2);
        }

        public static final /* synthetic */ void write$Self$watch_release(Data data, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.encodeStringElement(serialDescriptor, 0, data.date);
            compositeEncoder.encodeStringElement(serialDescriptor, 1, data.url);
        }

        public final String component1() {
            return this.date;
        }

        public final String component2() {
            return this.url;
        }

        public final Data copy(String date, String url) {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(url, "url");
            return new Data(date, url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            if (Intrinsics.areEqual(this.date, data.date) && Intrinsics.areEqual(this.url, data.url)) {
                return true;
            }
            return false;
        }

        public final String getDate() {
            return this.date;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode() + (this.date.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Data(date=");
            sb.append(this.date);
            sb.append(", url=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.url, ')');
        }

        public Data(String date, String url) {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(url, "url");
            this.date = date;
            this.url = url;
        }
    }

    public /* synthetic */ ResponseUploadUrls(int r2, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 == (r2 & 1)) {
            this.data = list;
        } else {
            zzac.throwMissingFieldException(r2, 1, ResponseUploadUrls$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResponseUploadUrls copy$default(ResponseUploadUrls responseUploadUrls, List list, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            list = responseUploadUrls.data;
        }
        return responseUploadUrls.copy(list);
    }

    public final List<Data> component1() {
        return this.data;
    }

    public final ResponseUploadUrls copy(List<Data> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new ResponseUploadUrls(data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ResponseUploadUrls) && Intrinsics.areEqual(this.data, ((ResponseUploadUrls) obj).data)) {
            return true;
        }
        return false;
    }

    public final List<Data> getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return LocaleList$$ExternalSyntheticOutline0.m(new StringBuilder("ResponseUploadUrls(data="), this.data, ')');
    }

    public ResponseUploadUrls(List<Data> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }
}
