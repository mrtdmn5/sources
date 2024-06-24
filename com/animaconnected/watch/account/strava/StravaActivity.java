package com.animaconnected.watch.account.strava;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: StravaActivity.kt */
@Serializable
/* loaded from: classes3.dex */
public final class StravaActivity {
    public static final Companion Companion = new Companion(null);
    private final int commute;
    private final String description;
    private final float distance;
    private final int elapsedTime;
    private final String name;
    private final String sportType;
    private final String startDateLocal;
    private final int trainer;
    private final String type;

    /* compiled from: StravaActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<StravaActivity> serializer() {
            return StravaActivity$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ StravaActivity(int r2, String str, String str2, String str3, int r6, String str4, String str5, float f, int r10, int r11, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (r2 & 15)) {
            zzac.throwMissingFieldException(r2, 15, StravaActivity$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.name = str;
        this.sportType = str2;
        this.startDateLocal = str3;
        this.elapsedTime = r6;
        if ((r2 & 16) == 0) {
            this.type = "";
        } else {
            this.type = str4;
        }
        if ((r2 & 32) == 0) {
            this.description = "";
        } else {
            this.description = str5;
        }
        if ((r2 & 64) == 0) {
            this.distance = 0.0f;
        } else {
            this.distance = f;
        }
        if ((r2 & 128) == 0) {
            this.trainer = 0;
        } else {
            this.trainer = r10;
        }
        if ((r2 & 256) == 0) {
            this.commute = 0;
        } else {
            this.commute = r11;
        }
    }

    public static /* synthetic */ StravaActivity copy$default(StravaActivity stravaActivity, String str, String str2, String str3, int r14, String str4, String str5, float f, int r18, int r19, int r20, Object obj) {
        String str6;
        String str7;
        String str8;
        int r5;
        String str9;
        String str10;
        float f2;
        int r9;
        int r1;
        if ((r20 & 1) != 0) {
            str6 = stravaActivity.name;
        } else {
            str6 = str;
        }
        if ((r20 & 2) != 0) {
            str7 = stravaActivity.sportType;
        } else {
            str7 = str2;
        }
        if ((r20 & 4) != 0) {
            str8 = stravaActivity.startDateLocal;
        } else {
            str8 = str3;
        }
        if ((r20 & 8) != 0) {
            r5 = stravaActivity.elapsedTime;
        } else {
            r5 = r14;
        }
        if ((r20 & 16) != 0) {
            str9 = stravaActivity.type;
        } else {
            str9 = str4;
        }
        if ((r20 & 32) != 0) {
            str10 = stravaActivity.description;
        } else {
            str10 = str5;
        }
        if ((r20 & 64) != 0) {
            f2 = stravaActivity.distance;
        } else {
            f2 = f;
        }
        if ((r20 & 128) != 0) {
            r9 = stravaActivity.trainer;
        } else {
            r9 = r18;
        }
        if ((r20 & 256) != 0) {
            r1 = stravaActivity.commute;
        } else {
            r1 = r19;
        }
        return stravaActivity.copy(str6, str7, str8, r5, str9, str10, f2, r9, r1);
    }

    public static final /* synthetic */ void write$Self$watch_release(StravaActivity stravaActivity, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        compositeEncoder.encodeStringElement(serialDescriptor, 0, stravaActivity.name);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, stravaActivity.sportType);
        compositeEncoder.encodeStringElement(serialDescriptor, 2, stravaActivity.startDateLocal);
        compositeEncoder.encodeIntElement(3, stravaActivity.elapsedTime, serialDescriptor);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(stravaActivity.type, "")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            compositeEncoder.encodeStringElement(serialDescriptor, 4, stravaActivity.type);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(stravaActivity.description, "")) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            compositeEncoder.encodeStringElement(serialDescriptor, 5, stravaActivity.description);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || Float.compare(stravaActivity.distance, 0.0f) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            compositeEncoder.encodeFloatElement(serialDescriptor, 6, stravaActivity.distance);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || stravaActivity.trainer != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            compositeEncoder.encodeIntElement(7, stravaActivity.trainer, serialDescriptor);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || stravaActivity.commute != 0) {
            z5 = true;
        }
        if (z5) {
            compositeEncoder.encodeIntElement(8, stravaActivity.commute, serialDescriptor);
        }
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.sportType;
    }

    public final String component3() {
        return this.startDateLocal;
    }

    public final int component4() {
        return this.elapsedTime;
    }

    public final String component5() {
        return this.type;
    }

    public final String component6() {
        return this.description;
    }

    public final float component7() {
        return this.distance;
    }

    public final int component8() {
        return this.trainer;
    }

    public final int component9() {
        return this.commute;
    }

    public final StravaActivity copy(String name, String sportType, String startDateLocal, int r15, String type, String description, float f, int r19, int r20) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sportType, "sportType");
        Intrinsics.checkNotNullParameter(startDateLocal, "startDateLocal");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(description, "description");
        return new StravaActivity(name, sportType, startDateLocal, r15, type, description, f, r19, r20);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StravaActivity)) {
            return false;
        }
        StravaActivity stravaActivity = (StravaActivity) obj;
        if (Intrinsics.areEqual(this.name, stravaActivity.name) && Intrinsics.areEqual(this.sportType, stravaActivity.sportType) && Intrinsics.areEqual(this.startDateLocal, stravaActivity.startDateLocal) && this.elapsedTime == stravaActivity.elapsedTime && Intrinsics.areEqual(this.type, stravaActivity.type) && Intrinsics.areEqual(this.description, stravaActivity.description) && Float.compare(this.distance, stravaActivity.distance) == 0 && this.trainer == stravaActivity.trainer && this.commute == stravaActivity.commute) {
            return true;
        }
        return false;
    }

    public final int getCommute() {
        return this.commute;
    }

    public final String getDescription() {
        return this.description;
    }

    public final float getDistance() {
        return this.distance;
    }

    public final int getElapsedTime() {
        return this.elapsedTime;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSportType() {
        return this.sportType;
    }

    public final String getStartDateLocal() {
        return this.startDateLocal;
    }

    public final int getTrainer() {
        return this.trainer;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return Integer.hashCode(this.commute) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.trainer, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.distance, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.description, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.type, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.elapsedTime, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.startDateLocal, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.sportType, this.name.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StravaActivity(name=");
        sb.append(this.name);
        sb.append(", sportType=");
        sb.append(this.sportType);
        sb.append(", startDateLocal=");
        sb.append(this.startDateLocal);
        sb.append(", elapsedTime=");
        sb.append(this.elapsedTime);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", distance=");
        sb.append(this.distance);
        sb.append(", trainer=");
        sb.append(this.trainer);
        sb.append(", commute=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.commute, ')');
    }

    public StravaActivity(String name, String sportType, String startDateLocal, int r5, String type, String description, float f, int r9, int r10) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sportType, "sportType");
        Intrinsics.checkNotNullParameter(startDateLocal, "startDateLocal");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(description, "description");
        this.name = name;
        this.sportType = sportType;
        this.startDateLocal = startDateLocal;
        this.elapsedTime = r5;
        this.type = type;
        this.description = description;
        this.distance = f;
        this.trainer = r9;
        this.commute = r10;
    }

    public /* synthetic */ StravaActivity(String str, String str2, String str3, int r17, String str4, String str5, float f, int r21, int r22, int r23, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, r17, (r23 & 16) != 0 ? "" : str4, (r23 & 32) != 0 ? "" : str5, (r23 & 64) != 0 ? 0.0f : f, (r23 & 128) != 0 ? 0 : r21, (r23 & 256) != 0 ? 0 : r22);
    }

    public static /* synthetic */ void getElapsedTime$annotations() {
    }

    public static /* synthetic */ void getSportType$annotations() {
    }

    public static /* synthetic */ void getStartDateLocal$annotations() {
    }
}
