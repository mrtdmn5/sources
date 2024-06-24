package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Recomposer.kt */
/* loaded from: classes.dex */
public final class Recomposer$writeObserverOf$1 extends Lambda implements Function1<Object, Unit> {
    public final /* synthetic */ ControlledComposition $composition;
    public final /* synthetic */ IdentityArraySet<Object> $modifiedValues;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recomposer$writeObserverOf$1(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet) {
        super(1);
        this.$composition = controlledComposition;
        this.$modifiedValues = identityArraySet;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.$composition.recordWriteOf(value);
        IdentityArraySet<Object> identityArraySet = this.$modifiedValues;
        if (identityArraySet != null) {
            identityArraySet.add(value);
        }
        return Unit.INSTANCE;
    }
}
