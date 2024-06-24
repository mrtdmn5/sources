package androidx.compose.ui.input.nestedscroll;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NestedScrollNode.kt */
/* loaded from: classes.dex */
public final class NestedScrollNode$updateDispatcherFields$1 extends Lambda implements Function0<CoroutineScope> {
    public final /* synthetic */ NestedScrollNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollNode$updateDispatcherFields$1(NestedScrollNode nestedScrollNode) {
        super(0);
        this.this$0 = nestedScrollNode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final CoroutineScope invoke() {
        return this.this$0.getNestedCoroutineScope();
    }
}
