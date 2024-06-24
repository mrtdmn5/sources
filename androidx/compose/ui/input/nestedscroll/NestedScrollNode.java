package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.modifier.SingleLocalMap;
import androidx.transition.PathMotion;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NestedScrollNode.kt */
/* loaded from: classes.dex */
public final class NestedScrollNode extends Modifier.Node implements ModifierLocalModifierNode, NestedScrollConnection {
    public NestedScrollConnection connection;
    public final SingleLocalMap providedValues;
    public NestedScrollDispatcher resolvedDispatcher;

    public NestedScrollNode(NestedScrollConnection connection, NestedScrollDispatcher nestedScrollDispatcher) {
        boolean z;
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.connection = connection;
        this.resolvedDispatcher = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        ProvidableModifierLocal<NestedScrollNode> providableModifierLocal = NestedScrollNodeKt.ModifierLocalNestedScroll;
        SingleLocalMap singleLocalMap = new SingleLocalMap(providableModifierLocal);
        if (providableModifierLocal == singleLocalMap.key) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            singleLocalMap.value$delegate.setValue(this);
            this.providedValues = singleLocalMap;
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final CoroutineScope getNestedCoroutineScope() {
        NestedScrollNode nestedScrollNode;
        if (this.isAttached) {
            nestedScrollNode = (NestedScrollNode) getCurrent(NestedScrollNodeKt.ModifierLocalNestedScroll);
        } else {
            nestedScrollNode = null;
        }
        if (nestedScrollNode != null) {
            return nestedScrollNode.getNestedCoroutineScope();
        }
        CoroutineScope coroutineScope = this.resolvedDispatcher.scope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    public final NestedScrollConnection getParentConnection() {
        if (this.isAttached) {
            return (NestedScrollConnection) getCurrent(NestedScrollNodeKt.ModifierLocalNestedScroll);
        }
        return null;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public final PathMotion getProvidedValues() {
        return this.providedValues;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        NestedScrollDispatcher nestedScrollDispatcher = this.resolvedDispatcher;
        nestedScrollDispatcher.modifierLocalNode = this;
        nestedScrollDispatcher.calculateNestedScrollScope = new NestedScrollNode$updateDispatcherFields$1(this);
        this.resolvedDispatcher.scope = getCoroutineScope();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        NestedScrollDispatcher nestedScrollDispatcher = this.resolvedDispatcher;
        if (nestedScrollDispatcher.modifierLocalNode == this) {
            nestedScrollDispatcher.modifierLocalNode = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo51onPostFlingRZ2iAVY(long r18, long r20, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r22
            boolean r2 = r1 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1
            if (r2 == 0) goto L17
            r2 = r1
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1 r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1 r2 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r9 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r2.label
            r10 = 2
            r4 = 1
            if (r3 == 0) goto L44
            if (r3 == r4) goto L38
            if (r3 != r10) goto L30
            long r2 = r2.J$0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L87
        L30:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L38:
            long r3 = r2.J$1
            long r5 = r2.J$0
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r7 = r2.L$0
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r3
            r11 = r5
            goto L62
        L44:
            kotlin.ResultKt.throwOnFailure(r1)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r3 = r0.connection
            r2.L$0 = r0
            r11 = r18
            r2.J$0 = r11
            r13 = r20
            r2.J$1 = r13
            r2.label = r4
            r4 = r18
            r6 = r20
            r8 = r2
            java.lang.Object r1 = r3.mo51onPostFlingRZ2iAVY(r4, r6, r8)
            if (r1 != r9) goto L61
            return r9
        L61:
            r7 = r0
        L62:
            androidx.compose.ui.unit.Velocity r1 = (androidx.compose.ui.unit.Velocity) r1
            long r4 = r1.packedValue
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r3 = r7.getParentConnection()
            if (r3 == 0) goto L8f
            long r6 = androidx.compose.ui.unit.Velocity.m607plusAH228Gc(r11, r4)
            long r11 = androidx.compose.ui.unit.Velocity.m606minusAH228Gc(r13, r4)
            r1 = 0
            r2.L$0 = r1
            r2.J$0 = r4
            r2.label = r10
            r13 = r4
            r4 = r6
            r6 = r11
            r8 = r2
            java.lang.Object r1 = r3.mo51onPostFlingRZ2iAVY(r4, r6, r8)
            if (r1 != r9) goto L86
            return r9
        L86:
            r2 = r13
        L87:
            androidx.compose.ui.unit.Velocity r1 = (androidx.compose.ui.unit.Velocity) r1
            long r4 = r1.packedValue
            r15 = r2
            r1 = r4
            r4 = r15
            goto L94
        L8f:
            r13 = r4
            long r4 = androidx.compose.ui.unit.Velocity.Zero
            r1 = r4
            r4 = r13
        L94:
            long r1 = androidx.compose.ui.unit.Velocity.m607plusAH228Gc(r4, r1)
            androidx.compose.ui.unit.Velocity r3 = new androidx.compose.ui.unit.Velocity
            r3.<init>(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.mo51onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public final long mo52onPostScrollDzOQY0M(int r9, long j, long j2) {
        long j3;
        long mo52onPostScrollDzOQY0M = this.connection.mo52onPostScrollDzOQY0M(r9, j, j2);
        NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            j3 = parentConnection.mo52onPostScrollDzOQY0M(r9, Offset.m262plusMKHz9U(j, mo52onPostScrollDzOQY0M), Offset.m261minusMKHz9U(j2, mo52onPostScrollDzOQY0M));
        } else {
            int r92 = Offset.$r8$clinit;
            j3 = Offset.Zero;
        }
        return Offset.m262plusMKHz9U(mo52onPostScrollDzOQY0M, j3);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo159onPreFlingQWom1Mo(long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            long r7 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L70
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            long r7 = r0.J$0
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L53
        L3c:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r9 = r6.getParentConnection()
            if (r9 == 0) goto L58
            r0.L$0 = r6
            r0.J$0 = r7
            r0.label = r4
            java.lang.Object r9 = r9.mo159onPreFlingQWom1Mo(r7, r0)
            if (r9 != r1) goto L52
            return r1
        L52:
            r2 = r6
        L53:
            androidx.compose.ui.unit.Velocity r9 = (androidx.compose.ui.unit.Velocity) r9
            long r4 = r9.packedValue
            goto L5b
        L58:
            long r4 = androidx.compose.ui.unit.Velocity.Zero
            r2 = r6
        L5b:
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r9 = r2.connection
            long r7 = androidx.compose.ui.unit.Velocity.m606minusAH228Gc(r7, r4)
            r2 = 0
            r0.L$0 = r2
            r0.J$0 = r4
            r0.label = r3
            java.lang.Object r9 = r9.mo159onPreFlingQWom1Mo(r7, r0)
            if (r9 != r1) goto L6f
            return r1
        L6f:
            r7 = r4
        L70:
            androidx.compose.ui.unit.Velocity r9 = (androidx.compose.ui.unit.Velocity) r9
            long r0 = r9.packedValue
            long r7 = androidx.compose.ui.unit.Velocity.m607plusAH228Gc(r7, r0)
            androidx.compose.ui.unit.Velocity r9 = new androidx.compose.ui.unit.Velocity
            r9.<init>(r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.mo159onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public final long mo53onPreScrollOzD1aCk(int r4, long j) {
        long j2;
        NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            j2 = parentConnection.mo53onPreScrollOzD1aCk(r4, j);
        } else {
            int r0 = Offset.$r8$clinit;
            j2 = Offset.Zero;
        }
        return Offset.m262plusMKHz9U(j2, this.connection.mo53onPreScrollOzD1aCk(r4, Offset.m261minusMKHz9U(j, j2)));
    }
}
