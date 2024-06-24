package kotlinx.serialization;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SerializationExceptions.kt */
/* loaded from: classes4.dex */
public final class MissingFieldException extends SerializationException {
    public final List<String> missingFields;

    public MissingFieldException() {
        throw null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissingFieldException(List missingFields, String str, MissingFieldException missingFieldException) {
        super(str, missingFieldException);
        Intrinsics.checkNotNullParameter(missingFields, "missingFields");
        this.missingFields = missingFields;
    }

    public MissingFieldException(String str) {
        this(CollectionsKt__CollectionsKt.listOf(str), zzav$$ExternalSyntheticOutline0.m("Field '", str, "' is required, but it was missing"), null);
    }
}
