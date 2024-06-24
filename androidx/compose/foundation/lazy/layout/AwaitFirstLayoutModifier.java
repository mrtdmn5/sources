package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Unit;
import kotlin.coroutines.SafeContinuation;

/* compiled from: AwaitFirstLayoutModifier.kt */
/* loaded from: classes.dex */
public final class AwaitFirstLayoutModifier implements OnGloballyPositionedModifier {
    public SafeContinuation continuation;
    public boolean wasPositioned;

    @Override // androidx.compose.ui.layout.OnGloballyPositionedModifier
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        if (!this.wasPositioned) {
            this.wasPositioned = true;
            SafeContinuation safeContinuation = this.continuation;
            if (safeContinuation != null) {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
            this.continuation = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object waitForFirstLayout(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1 r0 = (androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1 r0 = new androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.coroutines.Continuation r0 = r0.L$1
            kotlin.ResultKt.throwOnFailure(r5)
            goto L54
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            boolean r5 = r4.wasPositioned
            if (r5 != 0) goto L5b
            kotlin.coroutines.SafeContinuation r5 = r4.continuation
            r0.getClass()
            r0.L$1 = r5
            r0.label = r3
            kotlin.coroutines.SafeContinuation r2 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)
            r2.<init>(r0)
            r4.continuation = r2
            java.lang.Object r0 = r2.getOrThrow()
            if (r0 != r1) goto L53
            return r1
        L53:
            r0 = r5
        L54:
            if (r0 == 0) goto L5b
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r0.resumeWith(r5)
        L5b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier.waitForFirstLayout(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
