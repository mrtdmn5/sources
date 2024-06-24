package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.ScrollScope;
import com.animaconnected.secondo.R;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: LazyAnimateScroll.kt */
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", f = "LazyAnimateScroll.kt", l = {R.styleable.AppTheme_stepsHistoryColumnTodayColorActivity, 237}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class LazyAnimateScrollKt$animateScrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ int $index;
    public final /* synthetic */ int $scrollOffset;
    public final /* synthetic */ LazyAnimateScrollScope $this_animateScrollToItem;
    public float F$0;
    public float F$1;
    public float F$2;
    public int I$0;
    public /* synthetic */ Object L$0;
    public Ref$BooleanRef L$1;
    public Ref$ObjectRef L$2;
    public Ref$IntRef L$3;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyAnimateScrollKt$animateScrollToItem$2(int r1, int r2, LazyAnimateScrollScope lazyAnimateScrollScope, Continuation continuation) {
        super(2, continuation);
        this.$index = r1;
        this.$this_animateScrollToItem = lazyAnimateScrollScope;
        this.$scrollOffset = r2;
    }

    public static final boolean access$invokeSuspend$isOvershot(boolean z, LazyAnimateScrollScope lazyAnimateScrollScope, int r2, int r3) {
        if (!z ? !(lazyAnimateScrollScope.getFirstVisibleItemIndex() >= r2 && (lazyAnimateScrollScope.getFirstVisibleItemIndex() != r2 || lazyAnimateScrollScope.getFirstVisibleItemScrollOffset() >= r3)) : !(lazyAnimateScrollScope.getFirstVisibleItemIndex() <= r2 && (lazyAnimateScrollScope.getFirstVisibleItemIndex() != r2 || lazyAnimateScrollScope.getFirstVisibleItemScrollOffset() <= r3))) {
            return true;
        }
        return false;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LazyAnimateScrollScope lazyAnimateScrollScope = this.$this_animateScrollToItem;
        LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$2 = new LazyAnimateScrollKt$animateScrollToItem$2(this.$index, this.$scrollOffset, lazyAnimateScrollScope, continuation);
        lazyAnimateScrollKt$animateScrollToItem$2.L$0 = obj;
        return lazyAnimateScrollKt$animateScrollToItem$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((LazyAnimateScrollKt$animateScrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b8 A[Catch: ItemFoundInScroll -> 0x01a0, TryCatch #7 {ItemFoundInScroll -> 0x01a0, blocks: (B:20:0x00b2, B:22:0x00b8, B:24:0x00be, B:30:0x00e0, B:35:0x0114), top: B:19:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ce A[Catch: ItemFoundInScroll -> 0x0187, TRY_ENTER, TRY_LEAVE, TryCatch #3 {ItemFoundInScroll -> 0x0187, blocks: (B:17:0x0178, B:27:0x00ce), top: B:16:0x0178 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARN: Type inference failed for: r15v0, types: [androidx.compose.animation.core.AnimationState, T] */
    /* JADX WARN: Type inference failed for: r6v11, types: [androidx.compose.animation.core.AnimationState, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0170 -> B:16:0x0178). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r29) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
