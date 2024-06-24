package aws.smithy.kotlin.runtime.serde;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SdkFieldDescriptor.kt */
/* loaded from: classes.dex */
public class SdkFieldDescriptor {
    public int index;
    public final SerialKind kind;
    public final Set<FieldTrait> traits;

    public SdkFieldDescriptor() {
        throw null;
    }

    public SdkFieldDescriptor(SerialKind kind, Set set) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        this.kind = kind;
        this.index = 0;
        this.traits = set;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SdkFieldDescriptor.");
        sb.append(this.kind);
        sb.append("(traits=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, CollectionsKt___CollectionsKt.joinToString$default(this.traits, ",", null, null, null, 62), ')');
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public SdkFieldDescriptor(SerialKind kind, FieldTrait... fieldTraitArr) {
        this(kind, ArraysKt___ArraysKt.toSet(fieldTraitArr));
        Intrinsics.checkNotNullParameter(kind, "kind");
    }
}
