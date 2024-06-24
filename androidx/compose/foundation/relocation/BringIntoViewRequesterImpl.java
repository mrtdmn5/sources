package androidx.compose.foundation.relocation;

import androidx.compose.runtime.collection.MutableVector;

/* compiled from: BringIntoViewRequester.kt */
/* loaded from: classes.dex */
public final class BringIntoViewRequesterImpl implements BringIntoViewRequester {
    public final MutableVector<BringIntoViewRequesterNode> modifiers = new MutableVector<>(new BringIntoViewRequesterNode[16]);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0080, code lost:            if (r11 < r2) goto L17;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007f, code lost:            if (r5 != r1) goto L29;     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // androidx.compose.foundation.relocation.BringIntoViewRequester
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object bringIntoView(androidx.compose.ui.geometry.Rect r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1
            if (r0 == 0) goto L13
            r0 = r12
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = (androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = new androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            int r11 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object[] r4 = r0.L$1
            androidx.compose.ui.geometry.Rect r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r5
            goto L7f
        L30:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L38:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.relocation.BringIntoViewRequesterNode> r12 = r10.modifiers
            int r2 = r12.size
            if (r2 <= 0) goto L82
            T[] r12 = r12.content
            r4 = 0
            r9 = r12
            r12 = r11
            r11 = r4
            r4 = r9
        L48:
            r5 = r4[r11]
            androidx.compose.foundation.relocation.BringIntoViewRequesterNode r5 = (androidx.compose.foundation.relocation.BringIntoViewRequesterNode) r5
            r0.L$0 = r12
            r0.L$1 = r4
            r0.I$0 = r2
            r0.I$1 = r11
            r0.label = r3
            r5.getClass()
            androidx.compose.ui.modifier.ProvidableModifierLocal<androidx.compose.foundation.relocation.BringIntoViewParent> r6 = androidx.compose.foundation.relocation.BringIntoViewKt.ModifierLocalBringIntoViewParent
            java.lang.Object r6 = r5.getCurrent(r6)
            androidx.compose.foundation.relocation.BringIntoViewParent r6 = (androidx.compose.foundation.relocation.BringIntoViewParent) r6
            if (r6 != 0) goto L65
            androidx.compose.foundation.relocation.BringIntoViewResponder_androidKt$defaultBringIntoViewParent$1 r6 = r5.defaultParent
        L65:
            androidx.compose.ui.layout.LayoutCoordinates r7 = r5.getLayoutCoordinates()
            if (r7 != 0) goto L6c
            goto L7a
        L6c:
            androidx.compose.foundation.relocation.BringIntoViewRequesterNode$bringIntoView$2 r8 = new androidx.compose.foundation.relocation.BringIntoViewRequesterNode$bringIntoView$2
            r8.<init>()
            java.lang.Object r5 = r6.bringChildIntoView(r7, r8, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r5 != r6) goto L7a
            goto L7c
        L7a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L7c:
            if (r5 != r1) goto L7f
            return r1
        L7f:
            int r11 = r11 + r3
            if (r11 < r2) goto L48
        L82:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.relocation.BringIntoViewRequesterImpl.bringIntoView(androidx.compose.ui.geometry.Rect, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
