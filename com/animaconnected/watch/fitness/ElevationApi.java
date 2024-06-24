package com.animaconnected.watch.fitness;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ElevationApi.kt */
/* loaded from: classes3.dex */
public final class ElevationApi {
    public static final ElevationApi INSTANCE = new ElevationApi();
    private static final int maxLocations = 500;
    private static final int samples = 500;

    /* compiled from: ElevationApi.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class RestResult {
        private final String error_message;
        private final List<RestResultEntry> results;
        private final String status;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(ElevationApi$RestResultEntry$$serializer.INSTANCE), null, null};

        /* compiled from: ElevationApi.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<RestResult> serializer() {
                return ElevationApi$RestResult$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ RestResult(int r3, List list, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (r3 & 3)) {
                zzac.throwMissingFieldException(r3, 3, ElevationApi$RestResult$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.results = list;
            this.status = str;
            if ((r3 & 4) == 0) {
                this.error_message = null;
            } else {
                this.error_message = str2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RestResult copy$default(RestResult restResult, List list, String str, String str2, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                list = restResult.results;
            }
            if ((r4 & 2) != 0) {
                str = restResult.status;
            }
            if ((r4 & 4) != 0) {
                str2 = restResult.error_message;
            }
            return restResult.copy(list, str, str2);
        }

        public static final /* synthetic */ void write$Self$watch_release(RestResult restResult, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z = false;
            compositeEncoder.encodeSerializableElement(serialDescriptor, 0, $childSerializers[0], restResult.results);
            compositeEncoder.encodeStringElement(serialDescriptor, 1, restResult.status);
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || restResult.error_message != null) {
                z = true;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, restResult.error_message);
            }
        }

        public final List<RestResultEntry> component1() {
            return this.results;
        }

        public final String component2() {
            return this.status;
        }

        public final String component3() {
            return this.error_message;
        }

        public final RestResult copy(List<RestResultEntry> results, String status, String str) {
            Intrinsics.checkNotNullParameter(results, "results");
            Intrinsics.checkNotNullParameter(status, "status");
            return new RestResult(results, status, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RestResult)) {
                return false;
            }
            RestResult restResult = (RestResult) obj;
            if (Intrinsics.areEqual(this.results, restResult.results) && Intrinsics.areEqual(this.status, restResult.status) && Intrinsics.areEqual(this.error_message, restResult.error_message)) {
                return true;
            }
            return false;
        }

        public final String getError_message() {
            return this.error_message;
        }

        public final List<RestResultEntry> getResults() {
            return this.results;
        }

        public final String getStatus() {
            return this.status;
        }

        public int hashCode() {
            int hashCode;
            int m = TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.status, this.results.hashCode() * 31, 31);
            String str = this.error_message;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return m + hashCode;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("RestResult(results=");
            sb.append(this.results);
            sb.append(", status=");
            sb.append(this.status);
            sb.append(", error_message=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.error_message, ')');
        }

        public RestResult(List<RestResultEntry> results, String status, String str) {
            Intrinsics.checkNotNullParameter(results, "results");
            Intrinsics.checkNotNullParameter(status, "status");
            this.results = results;
            this.status = status;
            this.error_message = str;
        }

        public /* synthetic */ RestResult(List list, String str, String str2, int r4, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, str, (r4 & 4) != 0 ? null : str2);
        }
    }

    private ElevationApi() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f2 A[Catch: Exception -> 0x0184, TryCatch #3 {Exception -> 0x0184, blocks: (B:15:0x00f2, B:17:0x010f, B:18:0x0124, B:20:0x012a, B:22:0x014c, B:24:0x0153, B:31:0x015f, B:33:0x016e, B:34:0x0175, B:47:0x00c9, B:58:0x0183, B:71:0x0070, B:63:0x017e, B:64:0x0181, B:54:0x0178), top: B:70:0x0070, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x016e A[Catch: Exception -> 0x0184, TryCatch #3 {Exception -> 0x0184, blocks: (B:15:0x00f2, B:17:0x010f, B:18:0x0124, B:20:0x012a, B:22:0x014c, B:24:0x0153, B:31:0x015f, B:33:0x016e, B:34:0x0175, B:47:0x00c9, B:58:0x0183, B:71:0x0070, B:63:0x017e, B:64:0x0181, B:54:0x0178), top: B:70:0x0070, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /* JADX WARN: Type inference failed for: r1v12, types: [kotlinx.serialization.StringFormat] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getElevation(java.util.List<com.animaconnected.watch.fitness.LocationEntry> r19, java.lang.String r20, kotlin.coroutines.Continuation<? super java.util.List<com.animaconnected.watch.fitness.Elevation>> r21) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.ElevationApi.getElevation(java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: ElevationApi.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class RestResultEntry {
        public static final Companion Companion = new Companion(null);
        private final double elevation;
        private final RestResultLocation location;
        private final Double resolution;

        /* compiled from: ElevationApi.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<RestResultEntry> serializer() {
                return ElevationApi$RestResultEntry$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public RestResultEntry(double d, RestResultLocation location, Double d2) {
            Intrinsics.checkNotNullParameter(location, "location");
            this.elevation = d;
            this.location = location;
            this.resolution = d2;
        }

        public static /* synthetic */ RestResultEntry copy$default(RestResultEntry restResultEntry, double d, RestResultLocation restResultLocation, Double d2, int r5, Object obj) {
            if ((r5 & 1) != 0) {
                d = restResultEntry.elevation;
            }
            if ((r5 & 2) != 0) {
                restResultLocation = restResultEntry.location;
            }
            if ((r5 & 4) != 0) {
                d2 = restResultEntry.resolution;
            }
            return restResultEntry.copy(d, restResultLocation, d2);
        }

        public static final /* synthetic */ void write$Self$watch_release(RestResultEntry restResultEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z = false;
            compositeEncoder.encodeDoubleElement(serialDescriptor, 0, restResultEntry.elevation);
            compositeEncoder.encodeSerializableElement(serialDescriptor, 1, ElevationApi$RestResultLocation$$serializer.INSTANCE, restResultEntry.location);
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(restResultEntry.resolution, Double.valueOf(0.0d))) {
                z = true;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, DoubleSerializer.INSTANCE, restResultEntry.resolution);
            }
        }

        public final double component1() {
            return this.elevation;
        }

        public final RestResultLocation component2() {
            return this.location;
        }

        public final Double component3() {
            return this.resolution;
        }

        public final RestResultEntry copy(double d, RestResultLocation location, Double d2) {
            Intrinsics.checkNotNullParameter(location, "location");
            return new RestResultEntry(d, location, d2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RestResultEntry)) {
                return false;
            }
            RestResultEntry restResultEntry = (RestResultEntry) obj;
            if (Double.compare(this.elevation, restResultEntry.elevation) == 0 && Intrinsics.areEqual(this.location, restResultEntry.location) && Intrinsics.areEqual(this.resolution, restResultEntry.resolution)) {
                return true;
            }
            return false;
        }

        public final double getElevation() {
            return this.elevation;
        }

        public final RestResultLocation getLocation() {
            return this.location;
        }

        public final Double getResolution() {
            return this.resolution;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = (this.location.hashCode() + (Double.hashCode(this.elevation) * 31)) * 31;
            Double d = this.resolution;
            if (d == null) {
                hashCode = 0;
            } else {
                hashCode = d.hashCode();
            }
            return hashCode2 + hashCode;
        }

        public String toString() {
            return "RestResultEntry(elevation=" + this.elevation + ", location=" + this.location + ", resolution=" + this.resolution + ')';
        }

        public /* synthetic */ RestResultEntry(int r2, double d, RestResultLocation restResultLocation, Double d2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (r2 & 3)) {
                zzac.throwMissingFieldException(r2, 3, ElevationApi$RestResultEntry$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.elevation = d;
            this.location = restResultLocation;
            if ((r2 & 4) == 0) {
                this.resolution = Double.valueOf(0.0d);
            } else {
                this.resolution = d2;
            }
        }

        public /* synthetic */ RestResultEntry(double d, RestResultLocation restResultLocation, Double d2, int r5, DefaultConstructorMarker defaultConstructorMarker) {
            this(d, restResultLocation, (r5 & 4) != 0 ? Double.valueOf(0.0d) : d2);
        }
    }

    /* compiled from: ElevationApi.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class RestResultLocation {
        public static final Companion Companion = new Companion(null);
        private final double lat;
        private final double lng;

        /* compiled from: ElevationApi.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<RestResultLocation> serializer() {
                return ElevationApi$RestResultLocation$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public RestResultLocation(double d, double d2) {
            this.lat = d;
            this.lng = d2;
        }

        public static /* synthetic */ RestResultLocation copy$default(RestResultLocation restResultLocation, double d, double d2, int r5, Object obj) {
            if ((r5 & 1) != 0) {
                d = restResultLocation.lat;
            }
            if ((r5 & 2) != 0) {
                d2 = restResultLocation.lng;
            }
            return restResultLocation.copy(d, d2);
        }

        public static final /* synthetic */ void write$Self$watch_release(RestResultLocation restResultLocation, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.encodeDoubleElement(serialDescriptor, 0, restResultLocation.lat);
            compositeEncoder.encodeDoubleElement(serialDescriptor, 1, restResultLocation.lng);
        }

        public final double component1() {
            return this.lat;
        }

        public final double component2() {
            return this.lng;
        }

        public final RestResultLocation copy(double d, double d2) {
            return new RestResultLocation(d, d2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RestResultLocation)) {
                return false;
            }
            RestResultLocation restResultLocation = (RestResultLocation) obj;
            if (Double.compare(this.lat, restResultLocation.lat) == 0 && Double.compare(this.lng, restResultLocation.lng) == 0) {
                return true;
            }
            return false;
        }

        public final double getLat() {
            return this.lat;
        }

        public final double getLng() {
            return this.lng;
        }

        public int hashCode() {
            return Double.hashCode(this.lng) + (Double.hashCode(this.lat) * 31);
        }

        public String toString() {
            return "RestResultLocation(lat=" + this.lat + ", lng=" + this.lng + ')';
        }

        public /* synthetic */ RestResultLocation(int r2, double d, double d2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (r2 & 3)) {
                zzac.throwMissingFieldException(r2, 3, ElevationApi$RestResultLocation$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.lat = d;
            this.lng = d2;
        }
    }
}
