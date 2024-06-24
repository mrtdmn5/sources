package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: CollectionDescriptors.kt */
/* loaded from: classes4.dex */
public final class LinkedHashSetClassDesc extends ListLikeDescriptor {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkedHashSetClassDesc(SerialDescriptor elementDesc) {
        super(elementDesc);
        Intrinsics.checkNotNullParameter(elementDesc, "elementDesc");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getSerialName() {
        return "kotlin.collections.LinkedHashSet";
    }
}
