package androidx.compose.ui.viewinterop;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: AndroidViewHolder.android.kt */
/* loaded from: classes.dex */
public final class AndroidViewHolder$runUpdate$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ AndroidViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder$runUpdate$1(ViewFactoryHolder viewFactoryHolder) {
        super(0);
        this.this$0 = viewFactoryHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        AndroidViewHolder androidViewHolder = this.this$0;
        if (androidViewHolder.hasUpdateBlock) {
            androidViewHolder.snapshotObserver.observeReads(androidViewHolder, androidViewHolder.onCommitAffectingUpdate, androidViewHolder.getUpdate());
        }
        return Unit.INSTANCE;
    }
}
