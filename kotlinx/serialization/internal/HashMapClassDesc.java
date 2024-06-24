package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: CollectionDescriptors.kt */
/* loaded from: classes4.dex */
public final class HashMapClassDesc extends MapLikeDescriptor {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashMapClassDesc(SerialDescriptor keyDesc, SerialDescriptor valueDesc) {
        super("kotlin.collections.HashMap", keyDesc, valueDesc);
        Intrinsics.checkNotNullParameter(keyDesc, "keyDesc");
        Intrinsics.checkNotNullParameter(valueDesc, "valueDesc");
    }
}
