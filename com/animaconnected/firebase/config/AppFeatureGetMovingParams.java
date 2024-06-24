package com.animaconnected.firebase.config;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AppFeatureGetMovingParams.kt */
@Serializable
/* loaded from: classes.dex */
public final class AppFeatureGetMovingParams {
    public static final Companion Companion = new Companion(null);
    private final int end;
    private final int start;
    private final int timeout;
    private final int window;

    /* compiled from: AppFeatureGetMovingParams.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AppFeatureGetMovingParams> serializer() {
            return AppFeatureGetMovingParams$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public AppFeatureGetMovingParams() {
        this(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AppFeatureGetMovingParams copy$default(AppFeatureGetMovingParams appFeatureGetMovingParams, int r1, int r2, int r3, int r4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            r1 = appFeatureGetMovingParams.timeout;
        }
        if ((r5 & 2) != 0) {
            r2 = appFeatureGetMovingParams.window;
        }
        if ((r5 & 4) != 0) {
            r3 = appFeatureGetMovingParams.start;
        }
        if ((r5 & 8) != 0) {
            r4 = appFeatureGetMovingParams.end;
        }
        return appFeatureGetMovingParams.copy(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void write$Self$firebase_release(AppFeatureGetMovingParams appFeatureGetMovingParams, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || appFeatureGetMovingParams.timeout != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            compositeEncoder.encodeIntElement(0, appFeatureGetMovingParams.timeout, serialDescriptor);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || appFeatureGetMovingParams.window != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            compositeEncoder.encodeIntElement(1, appFeatureGetMovingParams.window, serialDescriptor);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || appFeatureGetMovingParams.start != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            compositeEncoder.encodeIntElement(2, appFeatureGetMovingParams.start, serialDescriptor);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || appFeatureGetMovingParams.end != 0) {
            z4 = true;
        }
        if (z4) {
            compositeEncoder.encodeIntElement(3, appFeatureGetMovingParams.end, serialDescriptor);
        }
    }

    public final int component1() {
        return this.timeout;
    }

    public final int component2() {
        return this.window;
    }

    public final int component3() {
        return this.start;
    }

    public final int component4() {
        return this.end;
    }

    public final AppFeatureGetMovingParams copy(int r2, int r3, int r4, int r5) {
        return new AppFeatureGetMovingParams(r2, r3, r4, r5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppFeatureGetMovingParams)) {
            return false;
        }
        AppFeatureGetMovingParams appFeatureGetMovingParams = (AppFeatureGetMovingParams) obj;
        if (this.timeout == appFeatureGetMovingParams.timeout && this.window == appFeatureGetMovingParams.window && this.start == appFeatureGetMovingParams.start && this.end == appFeatureGetMovingParams.end) {
            return true;
        }
        return false;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getTimeout() {
        return this.timeout;
    }

    public final int getWindow() {
        return this.window;
    }

    public int hashCode() {
        return Integer.hashCode(this.end) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.start, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.window, Integer.hashCode(this.timeout) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFeatureGetMovingParams(timeout=");
        sb.append(this.timeout);
        sb.append(", window=");
        sb.append(this.window);
        sb.append(", start=");
        sb.append(this.start);
        sb.append(", end=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.end, ')');
    }

    public AppFeatureGetMovingParams(int r1, int r2, int r3, int r4) {
        this.timeout = r1;
        this.window = r2;
        this.start = r3;
        this.end = r4;
    }

    public /* synthetic */ AppFeatureGetMovingParams(int r2, int r3, int r4, int r5, int r6, SerializationConstructorMarker serializationConstructorMarker) {
        if ((r2 & 0) != 0) {
            zzac.throwMissingFieldException(r2, 0, AppFeatureGetMovingParams$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        if ((r2 & 1) == 0) {
            this.timeout = 0;
        } else {
            this.timeout = r3;
        }
        if ((r2 & 2) == 0) {
            this.window = 0;
        } else {
            this.window = r4;
        }
        if ((r2 & 4) == 0) {
            this.start = 0;
        } else {
            this.start = r5;
        }
        if ((r2 & 8) == 0) {
            this.end = 0;
        } else {
            this.end = r6;
        }
    }

    public /* synthetic */ AppFeatureGetMovingParams(int r2, int r3, int r4, int r5, int r6, DefaultConstructorMarker defaultConstructorMarker) {
        this((r6 & 1) != 0 ? 0 : r2, (r6 & 2) != 0 ? 0 : r3, (r6 & 4) != 0 ? 0 : r4, (r6 & 8) != 0 ? 0 : r5);
    }
}
