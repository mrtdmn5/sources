package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: Swipeable.kt */
/* loaded from: classes.dex */
public final class SwipeableState$animateTo$2 implements FlowCollector<Map<Float, Object>> {
    public final /* synthetic */ AnimationSpec<Float> $anim;
    public final /* synthetic */ Object $targetValue;
    public final /* synthetic */ SwipeableState<Object> this$0;

    public SwipeableState$animateTo$2(Object obj, SwipeableState<Object> swipeableState, AnimationSpec<Float> animationSpec) {
        this.$targetValue = obj;
        this.this$0 = swipeableState;
        this.$anim = animationSpec;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: emit, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit2(java.util.Map<java.lang.Float, java.lang.Object> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState$animateTo$2.emit2(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final /* bridge */ /* synthetic */ Object emit(Map<Float, Object> map, Continuation continuation) {
        return emit2(map, (Continuation<? super Unit>) continuation);
    }
}
