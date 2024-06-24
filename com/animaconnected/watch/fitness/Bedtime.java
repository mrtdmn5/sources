package com.animaconnected.watch.fitness;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: FitnessData.kt */
@Serializable
/* loaded from: classes3.dex */
public final class Bedtime {
    public static final Companion Companion = new Companion(null);
    private final int hour;
    private final int minute;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bedtime defaultBedtime() {
            int r3 = 0;
            return new Bedtime(r3, r3, 3, (DefaultConstructorMarker) null);
        }

        public final KSerializer<Bedtime> serializer() {
            return Bedtime$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Bedtime() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.Bedtime.<init>():void");
    }

    public static /* synthetic */ Bedtime copy$default(Bedtime bedtime, int r1, int r2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            r1 = bedtime.hour;
        }
        if ((r3 & 2) != 0) {
            r2 = bedtime.minute;
        }
        return bedtime.copy(r1, r2);
    }

    public static final /* synthetic */ void write$Self$watch_release(Bedtime bedtime, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeIntElement(0, bedtime.hour, serialDescriptor);
        compositeEncoder.encodeIntElement(1, bedtime.minute, serialDescriptor);
    }

    public final int component1() {
        return this.hour;
    }

    public final int component2() {
        return this.minute;
    }

    public final Bedtime copy(int r2, int r3) {
        return new Bedtime(r2, r3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Bedtime)) {
            return false;
        }
        Bedtime bedtime = (Bedtime) obj;
        if (this.hour == bedtime.hour && this.minute == bedtime.minute) {
            return true;
        }
        return false;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMinute() {
        return this.minute;
    }

    public int hashCode() {
        return Integer.hashCode(this.minute) + (Integer.hashCode(this.hour) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Bedtime(hour=");
        sb.append(this.hour);
        sb.append(", minute=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.minute, ')');
    }

    public Bedtime(int r1, int r2) {
        this.hour = r1;
        this.minute = r2;
    }

    public /* synthetic */ Bedtime(int r2, int r3, int r4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((r2 & 0) != 0) {
            zzac.throwMissingFieldException(r2, 0, Bedtime$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.hour = (r2 & 1) == 0 ? 22 : r3;
        if ((r2 & 2) == 0) {
            this.minute = 0;
        } else {
            this.minute = r4;
        }
    }

    public /* synthetic */ Bedtime(int r1, int r2, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this((r3 & 1) != 0 ? 22 : r1, (r3 & 2) != 0 ? 0 : r2);
    }

    public static /* synthetic */ void getHour$annotations() {
    }

    public static /* synthetic */ void getMinute$annotations() {
    }
}
