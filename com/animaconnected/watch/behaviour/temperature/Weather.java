package com.animaconnected.watch.behaviour.temperature;

import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: WeatherHttpClient.kt */
@Serializable
/* loaded from: classes3.dex */
public final class Weather {
    private final Current current;
    private final List<Daily> daily;
    private final List<Hourly> hourly;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(Daily$$serializer.INSTANCE), new ArrayListSerializer(Hourly$$serializer.INSTANCE)};

    /* compiled from: WeatherHttpClient.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Weather> serializer() {
            return Weather$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Weather() {
        this((Current) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Weather copy$default(Weather weather, Current current, List list, List list2, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            current = weather.current;
        }
        if ((r4 & 2) != 0) {
            list = weather.daily;
        }
        if ((r4 & 4) != 0) {
            list2 = weather.hourly;
        }
        return weather.copy(current, list, list2);
    }

    public static final /* synthetic */ void write$Self$watch_release(Weather weather, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        boolean z3 = false;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || weather.current != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, Current$$serializer.INSTANCE, weather.current);
        }
        boolean shouldEncodeElementDefault = compositeEncoder.shouldEncodeElementDefault(serialDescriptor);
        EmptyList emptyList = EmptyList.INSTANCE;
        if (shouldEncodeElementDefault || !Intrinsics.areEqual(weather.daily, emptyList)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], weather.daily);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(weather.hourly, emptyList)) {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], weather.hourly);
        }
    }

    public final Current component1() {
        return this.current;
    }

    public final List<Daily> component2() {
        return this.daily;
    }

    public final List<Hourly> component3() {
        return this.hourly;
    }

    public final Weather copy(Current current, List<Daily> daily, List<Hourly> hourly) {
        Intrinsics.checkNotNullParameter(daily, "daily");
        Intrinsics.checkNotNullParameter(hourly, "hourly");
        return new Weather(current, daily, hourly);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Weather)) {
            return false;
        }
        Weather weather = (Weather) obj;
        if (Intrinsics.areEqual(this.current, weather.current) && Intrinsics.areEqual(this.daily, weather.daily) && Intrinsics.areEqual(this.hourly, weather.hourly)) {
            return true;
        }
        return false;
    }

    public final Current getCurrent() {
        return this.current;
    }

    public final List<Daily> getDaily() {
        return this.daily;
    }

    public final List<Hourly> getHourly() {
        return this.hourly;
    }

    public int hashCode() {
        int hashCode;
        Current current = this.current;
        if (current == null) {
            hashCode = 0;
        } else {
            hashCode = current.hashCode();
        }
        return this.hourly.hashCode() + VectorGroup$$ExternalSyntheticOutline0.m(this.daily, hashCode * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Weather(current=");
        sb.append(this.current);
        sb.append(", daily=");
        sb.append(this.daily);
        sb.append(", hourly=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.hourly, ')');
    }

    public /* synthetic */ Weather(int r2, Current current, List list, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((r2 & 0) != 0) {
            zzac.throwMissingFieldException(r2, 0, Weather$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        if ((r2 & 1) == 0) {
            this.current = null;
        } else {
            this.current = current;
        }
        int r3 = r2 & 2;
        EmptyList emptyList = EmptyList.INSTANCE;
        if (r3 == 0) {
            this.daily = emptyList;
        } else {
            this.daily = list;
        }
        if ((r2 & 4) == 0) {
            this.hourly = emptyList;
        } else {
            this.hourly = list2;
        }
    }

    public Weather(Current current, List<Daily> daily, List<Hourly> hourly) {
        Intrinsics.checkNotNullParameter(daily, "daily");
        Intrinsics.checkNotNullParameter(hourly, "hourly");
        this.current = current;
        this.daily = daily;
        this.hourly = hourly;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ Weather(com.animaconnected.watch.behaviour.temperature.Current r2, java.util.List r3, java.util.List r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r1 = this;
            r6 = r5 & 1
            if (r6 == 0) goto L5
            r2 = 0
        L5:
            r6 = r5 & 2
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
            if (r6 == 0) goto Lc
            r3 = r0
        Lc:
            r5 = r5 & 4
            if (r5 == 0) goto L11
            r4 = r0
        L11:
            r1.<init>(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.temperature.Weather.<init>(com.animaconnected.watch.behaviour.temperature.Current, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
