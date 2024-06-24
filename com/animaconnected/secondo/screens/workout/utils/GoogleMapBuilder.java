package com.animaconnected.secondo.screens.workout.utils;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.IntSize;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.fitness.PolyLineCompress;
import com.google.android.gms.tasks.zzac;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: GoogleMapsGenerator.kt */
/* loaded from: classes3.dex */
final class GoogleMapBuilder {
    private final long imageSize;
    private final List<LocationEntry> locations;
    private final long pathColor;
    private final int resIdMapStyle;
    private final int zoomLevel;

    /* compiled from: GoogleMapsGenerator.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class MapStyle {
        private final String elementType;
        private final String featureType;
        private final List<Styler> stylers;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(GoogleMapBuilder$Styler$$serializer.INSTANCE)};

        /* compiled from: GoogleMapsGenerator.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<MapStyle> serializer() {
                return GoogleMapBuilder$MapStyle$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public MapStyle() {
            this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MapStyle copy$default(MapStyle mapStyle, String str, String str2, List list, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                str = mapStyle.elementType;
            }
            if ((r4 & 2) != 0) {
                str2 = mapStyle.featureType;
            }
            if ((r4 & 4) != 0) {
                list = mapStyle.stylers;
            }
            return mapStyle.copy(str, str2, list);
        }

        public static final /* synthetic */ void write$Self$secondo_kronabyRelease(MapStyle mapStyle, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z;
            boolean z2;
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            boolean z3 = false;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || mapStyle.elementType != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, mapStyle.elementType);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || mapStyle.featureType != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, mapStyle.featureType);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(mapStyle.stylers, EmptyList.INSTANCE)) {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.encodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], mapStyle.stylers);
            }
        }

        public final String component1() {
            return this.elementType;
        }

        public final String component2() {
            return this.featureType;
        }

        public final List<Styler> component3() {
            return this.stylers;
        }

        public final MapStyle copy(String str, String str2, List<Styler> stylers) {
            Intrinsics.checkNotNullParameter(stylers, "stylers");
            return new MapStyle(str, str2, stylers);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MapStyle)) {
                return false;
            }
            MapStyle mapStyle = (MapStyle) obj;
            if (Intrinsics.areEqual(this.elementType, mapStyle.elementType) && Intrinsics.areEqual(this.featureType, mapStyle.featureType) && Intrinsics.areEqual(this.stylers, mapStyle.stylers)) {
                return true;
            }
            return false;
        }

        public final String getElementType() {
            return this.elementType;
        }

        public final String getFeatureType() {
            return this.featureType;
        }

        public final List<Styler> getStylers() {
            return this.stylers;
        }

        public int hashCode() {
            int hashCode;
            String str = this.elementType;
            int r1 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int r0 = hashCode * 31;
            String str2 = this.featureType;
            if (str2 != null) {
                r1 = str2.hashCode();
            }
            return this.stylers.hashCode() + ((r0 + r1) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MapStyle(elementType=");
            sb.append(this.elementType);
            sb.append(", featureType=");
            sb.append(this.featureType);
            sb.append(", stylers=");
            return LocaleList$$ExternalSyntheticOutline0.m(sb, this.stylers, ')');
        }

        public /* synthetic */ MapStyle(int r2, String str, String str2, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if ((r2 & 0) != 0) {
                zzac.throwMissingFieldException(r2, 0, GoogleMapBuilder$MapStyle$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            if ((r2 & 1) == 0) {
                this.elementType = null;
            } else {
                this.elementType = str;
            }
            if ((r2 & 2) == 0) {
                this.featureType = null;
            } else {
                this.featureType = str2;
            }
            if ((r2 & 4) == 0) {
                this.stylers = EmptyList.INSTANCE;
            } else {
                this.stylers = list;
            }
        }

        public MapStyle(String str, String str2, List<Styler> stylers) {
            Intrinsics.checkNotNullParameter(stylers, "stylers");
            this.elementType = str;
            this.featureType = str2;
            this.stylers = stylers;
        }

        public /* synthetic */ MapStyle(String str, String str2, List list, int r5, DefaultConstructorMarker defaultConstructorMarker) {
            this((r5 & 1) != 0 ? null : str, (r5 & 2) != 0 ? null : str2, (r5 & 4) != 0 ? EmptyList.INSTANCE : list);
        }
    }

    /* compiled from: GoogleMapsGenerator.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class Styler {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String color;
        private final String visibility;

        /* compiled from: GoogleMapsGenerator.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Styler> serializer() {
                return GoogleMapBuilder$Styler$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public Styler() {
            this((String) null, (String) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ Styler copy$default(Styler styler, String str, String str2, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = styler.color;
            }
            if ((r3 & 2) != 0) {
                str2 = styler.visibility;
            }
            return styler.copy(str, str2);
        }

        public static final /* synthetic */ void write$Self$secondo_kronabyRelease(Styler styler, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z;
            boolean z2 = false;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || styler.color != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, styler.color);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || styler.visibility != null) {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, styler.visibility);
            }
        }

        public final String component1() {
            return this.color;
        }

        public final String component2() {
            return this.visibility;
        }

        public final Styler copy(String str, String str2) {
            return new Styler(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Styler)) {
                return false;
            }
            Styler styler = (Styler) obj;
            if (Intrinsics.areEqual(this.color, styler.color) && Intrinsics.areEqual(this.visibility, styler.visibility)) {
                return true;
            }
            return false;
        }

        public final String getColor() {
            return this.color;
        }

        public final String getVisibility() {
            return this.visibility;
        }

        public int hashCode() {
            int hashCode;
            String str = this.color;
            int r1 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int r0 = hashCode * 31;
            String str2 = this.visibility;
            if (str2 != null) {
                r1 = str2.hashCode();
            }
            return r0 + r1;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Styler(color=");
            sb.append(this.color);
            sb.append(", visibility=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.visibility, ')');
        }

        public /* synthetic */ Styler(int r2, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((r2 & 0) != 0) {
                zzac.throwMissingFieldException(r2, 0, GoogleMapBuilder$Styler$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            if ((r2 & 1) == 0) {
                this.color = null;
            } else {
                this.color = str;
            }
            if ((r2 & 2) == 0) {
                this.visibility = null;
            } else {
                this.visibility = str2;
            }
        }

        public Styler(String str, String str2) {
            this.color = str;
            this.visibility = str2;
        }

        public /* synthetic */ Styler(String str, String str2, int r4, DefaultConstructorMarker defaultConstructorMarker) {
            this((r4 & 1) != 0 ? null : str, (r4 & 2) != 0 ? null : str2);
        }
    }

    public /* synthetic */ GoogleMapBuilder(long j, List list, long j2, int r6, int r7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, list, j2, r6, r7);
    }

    private final String center() {
        StringBuilder sb = new StringBuilder();
        sb.append(((LocationEntry) CollectionsKt___CollectionsKt.first((List) this.locations)).getLat());
        sb.append(',');
        sb.append(((LocationEntry) CollectionsKt___CollectionsKt.first((List) this.locations)).getLong());
        return sb.toString();
    }

    /* renamed from: copy-sNao6FM$default, reason: not valid java name */
    public static /* synthetic */ GoogleMapBuilder m1022copysNao6FM$default(GoogleMapBuilder googleMapBuilder, long j, List list, long j2, int r14, int r15, int r16, Object obj) {
        long j3;
        List list2;
        long j4;
        int r6;
        int r7;
        if ((r16 & 1) != 0) {
            j3 = googleMapBuilder.imageSize;
        } else {
            j3 = j;
        }
        if ((r16 & 2) != 0) {
            list2 = googleMapBuilder.locations;
        } else {
            list2 = list;
        }
        if ((r16 & 4) != 0) {
            j4 = googleMapBuilder.pathColor;
        } else {
            j4 = j2;
        }
        if ((r16 & 8) != 0) {
            r6 = googleMapBuilder.zoomLevel;
        } else {
            r6 = r14;
        }
        if ((r16 & 16) != 0) {
            r7 = googleMapBuilder.resIdMapStyle;
        } else {
            r7 = r15;
        }
        return googleMapBuilder.m1028copysNao6FM(j3, list2, j4, r6, r7);
    }

    /* renamed from: path-4WTKRHQ, reason: not valid java name */
    private final String m1023path4WTKRHQ(List<LocationEntry> list, long j) {
        int m327toArgb8_81llA = ColorKt.m327toArgb8_81llA(j);
        String format = String.format("0x%06X%02X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & m327toArgb8_81llA), Integer.valueOf(m327toArgb8_81llA >>> 24)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("color:", format, "|weight:6|enc:");
        m.append(PolyLineCompress.INSTANCE.encode(list));
        return m.toString();
    }

    /* renamed from: scale-ozmzZPI, reason: not valid java name */
    private final String m1024scaleozmzZPI(long j) {
        if (((int) (j >> 32)) <= 640 && IntSize.m593getHeightimpl(j) <= 640) {
            return "1";
        }
        return "2";
    }

    /* renamed from: size-ozmzZPI, reason: not valid java name */
    private final String m1025sizeozmzZPI(long j) {
        int r0 = (int) (j >> 32);
        int max = Math.max(r0, IntSize.m593getHeightimpl(j));
        int r2 = 640;
        if (640 > max) {
            r2 = max;
        }
        float f = r2 / max;
        StringBuilder sb = new StringBuilder();
        sb.append((int) (r0 * f));
        sb.append('x');
        sb.append((int) (IntSize.m593getHeightimpl(j) * f));
        return sb.toString();
    }

    /* renamed from: component1-YbymL2g, reason: not valid java name */
    public final long m1026component1YbymL2g() {
        return this.imageSize;
    }

    public final List<LocationEntry> component2() {
        return this.locations;
    }

    /* renamed from: component3-0d7_KjU, reason: not valid java name */
    public final long m1027component30d7_KjU() {
        return this.pathColor;
    }

    public final int component4() {
        return this.zoomLevel;
    }

    public final int component5() {
        return this.resIdMapStyle;
    }

    /* renamed from: copy-sNao6FM, reason: not valid java name */
    public final GoogleMapBuilder m1028copysNao6FM(long j, List<LocationEntry> locations, long j2, int r16, int r17) {
        Intrinsics.checkNotNullParameter(locations, "locations");
        return new GoogleMapBuilder(j, locations, j2, r16, r17, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleMapBuilder)) {
            return false;
        }
        GoogleMapBuilder googleMapBuilder = (GoogleMapBuilder) obj;
        if (IntSize.m592equalsimpl0(this.imageSize, googleMapBuilder.imageSize) && Intrinsics.areEqual(this.locations, googleMapBuilder.locations) && Color.m317equalsimpl0(this.pathColor, googleMapBuilder.pathColor) && this.zoomLevel == googleMapBuilder.zoomLevel && this.resIdMapStyle == googleMapBuilder.resIdMapStyle) {
            return true;
        }
        return false;
    }

    /* renamed from: getImageSize-YbymL2g, reason: not valid java name */
    public final long m1029getImageSizeYbymL2g() {
        return this.imageSize;
    }

    public final List<LocationEntry> getLocations() {
        return this.locations;
    }

    /* renamed from: getPathColor-0d7_KjU, reason: not valid java name */
    public final long m1030getPathColor0d7_KjU() {
        return this.pathColor;
    }

    public final int getResIdMapStyle() {
        return this.resIdMapStyle;
    }

    public final int getZoomLevel() {
        return this.zoomLevel;
    }

    public int hashCode() {
        int m = VectorGroup$$ExternalSyntheticOutline0.m(this.locations, Long.hashCode(this.imageSize) * 31, 31);
        long j = this.pathColor;
        int r3 = Color.$r8$clinit;
        return Integer.hashCode(this.resIdMapStyle) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.zoomLevel, Scale$$ExternalSyntheticOutline0.m(j, m, 31), 31);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ef A[LOOP:0: B:14:0x00e9->B:16:0x00ef, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object makeUrl(kotlin.coroutines.Continuation<? super java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.utils.GoogleMapBuilder.makeUrl(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object parseJsonToMapStyle(Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new GoogleMapBuilder$parseJsonToMapStyle$2(this, null), continuation);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GoogleMapBuilder(imageSize=");
        sb.append((Object) IntSize.m594toStringimpl(this.imageSize));
        sb.append(", locations=");
        sb.append(this.locations);
        sb.append(", pathColor=");
        sb.append((Object) Color.m323toStringimpl(this.pathColor));
        sb.append(", zoomLevel=");
        sb.append(this.zoomLevel);
        sb.append(", resIdMapStyle=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.resIdMapStyle, ')');
    }

    private GoogleMapBuilder(long j, List<LocationEntry> locations, long j2, int r7, int r8) {
        Intrinsics.checkNotNullParameter(locations, "locations");
        this.imageSize = j;
        this.locations = locations;
        this.pathColor = j2;
        this.zoomLevel = r7;
        this.resIdMapStyle = r8;
    }
}
