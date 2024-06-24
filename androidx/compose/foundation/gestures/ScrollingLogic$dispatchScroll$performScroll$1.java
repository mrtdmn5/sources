package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Scrollable.kt */
/* loaded from: classes.dex */
public final class ScrollingLogic$dispatchScroll$performScroll$1 extends Lambda implements Function1<Offset, Offset> {
    public final /* synthetic */ int $source;
    public final /* synthetic */ ScrollScope $this_dispatchScroll;
    public final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$dispatchScroll$performScroll$1(ScrollingLogic scrollingLogic, int r2, ScrollScope scrollScope) {
        super(1);
        this.this$0 = scrollingLogic;
        this.$source = r2;
        this.$this_dispatchScroll = scrollScope;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Offset invoke(Offset offset) {
        long j;
        long j2;
        long j3 = offset.packedValue;
        ScrollingLogic scrollingLogic = this.this$0;
        NestedScrollDispatcher value = scrollingLogic.nestedScrollDispatcher.getValue();
        NestedScrollNode parent$ui_release = value.getParent$ui_release();
        if (parent$ui_release != null) {
            j = parent$ui_release.mo53onPreScrollOzD1aCk(this.$source, j3);
        } else {
            j = Offset.Zero;
        }
        long j4 = j;
        long m261minusMKHz9U = Offset.m261minusMKHz9U(j3, j4);
        boolean z = scrollingLogic.reverseDirection;
        if (z) {
            j2 = Offset.m263timestuRUvjQ(-1.0f, m261minusMKHz9U);
        } else {
            j2 = m261minusMKHz9U;
        }
        long m58toOffsettuRUvjQ = scrollingLogic.m58toOffsettuRUvjQ(this.$this_dispatchScroll.scrollBy(scrollingLogic.m57toFloatk4lQ0M(j2)));
        if (z) {
            m58toOffsettuRUvjQ = Offset.m263timestuRUvjQ(-1.0f, m58toOffsettuRUvjQ);
        }
        long j5 = m58toOffsettuRUvjQ;
        return new Offset(Offset.m262plusMKHz9U(Offset.m262plusMKHz9U(j4, j5), value.m404dispatchPostScrollDzOQY0M(this.$source, j5, Offset.m261minusMKHz9U(m261minusMKHz9U, j5))));
    }
}
