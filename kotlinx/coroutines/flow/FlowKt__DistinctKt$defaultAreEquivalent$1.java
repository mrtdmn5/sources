package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Distinct.kt */
/* loaded from: classes4.dex */
public final class FlowKt__DistinctKt$defaultAreEquivalent$1 extends Lambda implements Function2<Object, Object, Boolean> {
    public static final FlowKt__DistinctKt$defaultAreEquivalent$1 INSTANCE = new FlowKt__DistinctKt$defaultAreEquivalent$1();

    public FlowKt__DistinctKt$defaultAreEquivalent$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Boolean invoke(Object obj, Object obj2) {
        return Boolean.valueOf(Intrinsics.areEqual(obj, obj2));
    }
}
