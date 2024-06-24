package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Recomposer.kt */
/* loaded from: classes.dex */
public final class Recomposer$readObserverOf$1 extends Lambda implements Function1<Object, Unit> {
    public final /* synthetic */ ControlledComposition $composition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recomposer$readObserverOf$1(ControlledComposition controlledComposition) {
        super(1);
        this.$composition = controlledComposition;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.$composition.recordReadOf(value);
        return Unit.INSTANCE;
    }
}
