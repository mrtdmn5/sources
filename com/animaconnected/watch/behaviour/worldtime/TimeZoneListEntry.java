package com.animaconnected.watch.behaviour.worldtime;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.animaconnected.watch.strings.KeyString;
import com.google.android.gms.tasks.zzac;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: WorldTime.kt */
@Serializable
/* loaded from: classes3.dex */
public abstract class TimeZoneListEntry {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry.Companion.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return new SealedClassSerializer("com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry", Reflection.getOrCreateKotlinClass(TimeZoneListEntry.class), new KClass[]{Reflection.getOrCreateKotlinClass(PredefinedTimeZoneListEntry.class), Reflection.getOrCreateKotlinClass(SystemTimeZoneListEntry.class)}, new KSerializer[]{TimeZoneListEntry$PredefinedTimeZoneListEntry$$serializer.INSTANCE, TimeZoneListEntry$SystemTimeZoneListEntry$$serializer.INSTANCE}, new Annotation[0]);
        }
    });

    /* compiled from: WorldTime.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) TimeZoneListEntry.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<TimeZoneListEntry> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    /* compiled from: WorldTime.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class PredefinedTimeZoneListEntry extends TimeZoneListEntry {
        public static final Companion Companion = new Companion(null);
        private final String cityKey;
        private final String timeZoneId;

        /* compiled from: WorldTime.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<PredefinedTimeZoneListEntry> serializer() {
                return TimeZoneListEntry$PredefinedTimeZoneListEntry$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PredefinedTimeZoneListEntry(int r3, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(r3, serializationConstructorMarker);
            if (3 != (r3 & 3)) {
                zzac.throwMissingFieldException(r3, 3, TimeZoneListEntry$PredefinedTimeZoneListEntry$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.timeZoneId = str;
            this.cityKey = str2;
        }

        public static /* synthetic */ PredefinedTimeZoneListEntry copy$default(PredefinedTimeZoneListEntry predefinedTimeZoneListEntry, String str, String str2, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = predefinedTimeZoneListEntry.timeZoneId;
            }
            if ((r3 & 2) != 0) {
                str2 = predefinedTimeZoneListEntry.cityKey;
            }
            return predefinedTimeZoneListEntry.copy(str, str2);
        }

        public static final /* synthetic */ void write$Self$watch_release(PredefinedTimeZoneListEntry predefinedTimeZoneListEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            TimeZoneListEntry.write$Self(predefinedTimeZoneListEntry, compositeEncoder, serialDescriptor);
            compositeEncoder.encodeStringElement(serialDescriptor, 0, predefinedTimeZoneListEntry.getTimeZoneId());
            compositeEncoder.encodeStringElement(serialDescriptor, 1, predefinedTimeZoneListEntry.cityKey);
        }

        public final String component1() {
            return this.timeZoneId;
        }

        public final String component2() {
            return this.cityKey;
        }

        public final PredefinedTimeZoneListEntry copy(String timeZoneId, String cityKey) {
            Intrinsics.checkNotNullParameter(timeZoneId, "timeZoneId");
            Intrinsics.checkNotNullParameter(cityKey, "cityKey");
            return new PredefinedTimeZoneListEntry(timeZoneId, cityKey);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PredefinedTimeZoneListEntry)) {
                return false;
            }
            PredefinedTimeZoneListEntry predefinedTimeZoneListEntry = (PredefinedTimeZoneListEntry) obj;
            if (Intrinsics.areEqual(this.timeZoneId, predefinedTimeZoneListEntry.timeZoneId) && Intrinsics.areEqual(this.cityKey, predefinedTimeZoneListEntry.cityKey)) {
                return true;
            }
            return false;
        }

        @Override // com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry
        public KeyString getCity() {
            return WorldTime.Companion.translate(this.cityKey);
        }

        public final String getCityKey() {
            return this.cityKey;
        }

        @Override // com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry
        public String getIdentifier() {
            return this.cityKey;
        }

        @Override // com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry
        public String getTimeZoneId() {
            return this.timeZoneId;
        }

        public int hashCode() {
            return this.cityKey.hashCode() + (this.timeZoneId.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("PredefinedTimeZoneListEntry(timeZoneId=");
            sb.append(this.timeZoneId);
            sb.append(", cityKey=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.cityKey, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PredefinedTimeZoneListEntry(String timeZoneId, String cityKey) {
            super(null);
            Intrinsics.checkNotNullParameter(timeZoneId, "timeZoneId");
            Intrinsics.checkNotNullParameter(cityKey, "cityKey");
            this.timeZoneId = timeZoneId;
            this.cityKey = cityKey;
        }
    }

    /* compiled from: WorldTime.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class SystemTimeZoneListEntry extends TimeZoneListEntry {
        public static final Companion Companion = new Companion(null);
        private final String timeZoneId;

        /* compiled from: WorldTime.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SystemTimeZoneListEntry> serializer() {
                return TimeZoneListEntry$SystemTimeZoneListEntry$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SystemTimeZoneListEntry(int r3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(r3, serializationConstructorMarker);
            if (1 != (r3 & 1)) {
                zzac.throwMissingFieldException(r3, 1, TimeZoneListEntry$SystemTimeZoneListEntry$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            this.timeZoneId = str;
        }

        public static /* synthetic */ SystemTimeZoneListEntry copy$default(SystemTimeZoneListEntry systemTimeZoneListEntry, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = systemTimeZoneListEntry.timeZoneId;
            }
            return systemTimeZoneListEntry.copy(str);
        }

        public static final /* synthetic */ void write$Self$watch_release(SystemTimeZoneListEntry systemTimeZoneListEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            TimeZoneListEntry.write$Self(systemTimeZoneListEntry, compositeEncoder, serialDescriptor);
            compositeEncoder.encodeStringElement(serialDescriptor, 0, systemTimeZoneListEntry.getTimeZoneId());
        }

        public final String component1() {
            return this.timeZoneId;
        }

        public final SystemTimeZoneListEntry copy(String timeZoneId) {
            Intrinsics.checkNotNullParameter(timeZoneId, "timeZoneId");
            return new SystemTimeZoneListEntry(timeZoneId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SystemTimeZoneListEntry) && Intrinsics.areEqual(this.timeZoneId, ((SystemTimeZoneListEntry) obj).timeZoneId)) {
                return true;
            }
            return false;
        }

        @Override // com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry
        public KeyString getCity() {
            return WorldTime.Companion.translate(getTimeZoneId());
        }

        @Override // com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry
        public String getIdentifier() {
            return getTimeZoneId();
        }

        @Override // com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry
        public String getTimeZoneId() {
            return this.timeZoneId;
        }

        public int hashCode() {
            return this.timeZoneId.hashCode();
        }

        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("SystemTimeZoneListEntry(timeZoneId="), this.timeZoneId, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SystemTimeZoneListEntry(String timeZoneId) {
            super(null);
            Intrinsics.checkNotNullParameter(timeZoneId, "timeZoneId");
            this.timeZoneId = timeZoneId;
        }
    }

    public /* synthetic */ TimeZoneListEntry(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract KeyString getCity();

    public abstract String getIdentifier();

    public abstract String getTimeZoneId();

    private TimeZoneListEntry() {
    }

    public /* synthetic */ TimeZoneListEntry(int r1, SerializationConstructorMarker serializationConstructorMarker) {
    }

    public static final /* synthetic */ void write$Self(TimeZoneListEntry timeZoneListEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
