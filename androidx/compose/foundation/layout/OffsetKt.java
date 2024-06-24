package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Offset.kt */
/* loaded from: classes.dex */
public final class OffsetKt {
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.compose.foundation.layout.OffsetKt$offset$2] */
    public static final Modifier offset(Modifier modifier, final Function1<? super Density, IntOffset> offset) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(offset, "offset");
        return modifier.then(new OffsetPxElement(offset, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.OffsetKt$offset$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(InspectorInfo inspectorInfo) {
                InspectorInfo $receiver = inspectorInfo;
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                $receiver.properties.set(offset, "offset");
                return Unit.INSTANCE;
            }
        }));
    }
}
