package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Recomposer.kt */
/* loaded from: classes.dex */
public final class Recomposer$performRecompose$1$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ControlledComposition $composition;
    public final /* synthetic */ IdentityArraySet<Object> $modifiedValues;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recomposer$performRecompose$1$1(ControlledComposition controlledComposition, IdentityArraySet identityArraySet) {
        super(0);
        this.$modifiedValues = identityArraySet;
        this.$composition = controlledComposition;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        IdentityArraySet<Object> identityArraySet = this.$modifiedValues;
        Object[] objArr = identityArraySet.values;
        int r0 = identityArraySet.size;
        for (int r2 = 0; r2 < r0; r2++) {
            Object obj = objArr[r2];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            this.$composition.recordWriteOf(obj);
        }
        return Unit.INSTANCE;
    }
}
