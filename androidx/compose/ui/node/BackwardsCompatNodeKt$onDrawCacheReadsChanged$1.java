package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: BackwardsCompatNode.kt */
/* loaded from: classes.dex */
public final class BackwardsCompatNodeKt$onDrawCacheReadsChanged$1 extends Lambda implements Function1<BackwardsCompatNode, Unit> {
    public static final BackwardsCompatNodeKt$onDrawCacheReadsChanged$1 INSTANCE = new BackwardsCompatNodeKt$onDrawCacheReadsChanged$1();

    public BackwardsCompatNodeKt$onDrawCacheReadsChanged$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(BackwardsCompatNode backwardsCompatNode) {
        BackwardsCompatNode it = backwardsCompatNode;
        Intrinsics.checkNotNullParameter(it, "it");
        it.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(it);
        return Unit.INSTANCE;
    }
}
