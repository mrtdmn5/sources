package kotlinx.datetime;

import j$.time.ZoneOffset;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.UtcOffsetSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: UtcOffsetJvm.kt */
@Serializable(with = UtcOffsetSerializer.class)
/* loaded from: classes4.dex */
public final class UtcOffset {
    public static final Companion Companion = new Companion();
    public final ZoneOffset zoneOffset;

    /* compiled from: UtcOffsetJvm.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public final KSerializer<UtcOffset> serializer() {
            return UtcOffsetSerializer.INSTANCE;
        }
    }

    static {
        ZoneOffset UTC = ZoneOffset.UTC;
        Intrinsics.checkNotNullExpressionValue(UTC, "UTC");
        new UtcOffset(UTC);
    }

    public UtcOffset(ZoneOffset zoneOffset) {
        Intrinsics.checkNotNullParameter(zoneOffset, "zoneOffset");
        this.zoneOffset = zoneOffset;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof UtcOffset) {
            if (Intrinsics.areEqual(this.zoneOffset, ((UtcOffset) obj).zoneOffset)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zoneOffset.hashCode();
    }

    public final String toString() {
        String zoneOffset = this.zoneOffset.toString();
        Intrinsics.checkNotNullExpressionValue(zoneOffset, "zoneOffset.toString()");
        return zoneOffset;
    }
}
