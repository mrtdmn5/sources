package kotlinx.datetime;

import android.content.Context;
import androidx.compose.ui.unit.DensityImpl;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableLambda;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import j$.time.DateTimeException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class TimeZoneKt {
    public static final DensityImpl Density(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DensityImpl(context.getResources().getDisplayMetrics().density, context.getResources().getConfiguration().fontScale);
    }

    public static final void field(StructSerializer structSerializer, SdkFieldDescriptor sdkFieldDescriptor, Object obj, Function2 serializeFn) {
        Intrinsics.checkNotNullParameter(structSerializer, "<this>");
        Intrinsics.checkNotNullParameter(serializeFn, "serializeFn");
        structSerializer.field(sdkFieldDescriptor, new SdkSerializableLambda(obj, serializeFn));
    }

    public static final UtcOffset offsetAt(Instant instant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return new UtcOffset(timeZone.zoneId.getRules().getOffset(instant.value));
    }

    public static final Instant toInstant(LocalDateTime localDateTime, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return new Instant(localDateTime.value.atZone(timeZone.zoneId).toInstant());
    }

    public static final LocalDateTime toLocalDateTime(Instant instant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            return new LocalDateTime(j$.time.LocalDateTime.ofInstant(instant.value, timeZone.zoneId));
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }
}
