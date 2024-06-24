package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: BackwardsCompatNode.kt */
/* loaded from: classes.dex */
public final class BackwardsCompatNodeKt$updateModifierLocalConsumer$1 extends Lambda implements Function1<BackwardsCompatNode, Unit> {
    public static final BackwardsCompatNodeKt$updateModifierLocalConsumer$1 INSTANCE = new BackwardsCompatNodeKt$updateModifierLocalConsumer$1();

    public BackwardsCompatNodeKt$updateModifierLocalConsumer$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(BackwardsCompatNode backwardsCompatNode) {
        BackwardsCompatNode it = backwardsCompatNode;
        Intrinsics.checkNotNullParameter(it, "it");
        it.updateModifierLocalConsumer();
        return Unit.INSTANCE;
    }
}
