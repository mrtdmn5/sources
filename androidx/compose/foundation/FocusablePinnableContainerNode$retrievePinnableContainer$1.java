package androidx.compose.foundation;

import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: Focusable.kt */
/* loaded from: classes.dex */
public final class FocusablePinnableContainerNode$retrievePinnableContainer$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Ref$ObjectRef<PinnableContainer> $container;
    public final /* synthetic */ FocusablePinnableContainerNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusablePinnableContainerNode$retrievePinnableContainer$1(Ref$ObjectRef<PinnableContainer> ref$ObjectRef, FocusablePinnableContainerNode focusablePinnableContainerNode) {
        super(0);
        this.$container = ref$ObjectRef;
        this.this$0 = focusablePinnableContainerNode;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.$container.element = CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, PinnableContainerKt.LocalPinnableContainer);
        return Unit.INSTANCE;
    }
}
