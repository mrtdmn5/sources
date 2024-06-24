package androidx.compose.ui.platform;

import android.view.ViewGroup;

/* compiled from: Wrapper.android.kt */
/* loaded from: classes.dex */
public final class Wrapper_androidKt {
    public static final ViewGroup.LayoutParams DefaultLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.runtime.Composition setContent(androidx.compose.ui.platform.AbstractComposeView r7, androidx.compose.runtime.CompositionContext r8, androidx.compose.runtime.internal.ComposableLambdaImpl r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.util.concurrent.atomic.AtomicBoolean r0 = androidx.compose.ui.platform.GlobalSnapshotManager.started
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            r3 = 0
            if (r0 == 0) goto L45
            r0 = -1
            r4 = 6
            kotlinx.coroutines.channels.BufferedChannel r0 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r0, r3, r4)
            kotlin.SynchronizedLazyImpl r4 = androidx.compose.ui.platform.AndroidUiDispatcher.Main$delegate
            java.lang.Object r4 = r4.getValue()
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            kotlinx.coroutines.internal.ContextScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r4)
            androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1 r5 = new androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1
            r5.<init>(r0, r3)
            r6 = 3
            kotlinx.coroutines.BuildersKt.launch$default(r4, r3, r3, r5, r6)
            androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$2 r4 = new androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$2
            r4.<init>()
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.lock
            monitor-enter(r0)
            java.util.ArrayList r5 = androidx.compose.runtime.snapshots.SnapshotKt.globalWriteObservers     // Catch: java.lang.Throwable -> L42
            r5.add(r4)     // Catch: java.lang.Throwable -> L42
            monitor-exit(r0)
            androidx.compose.runtime.snapshots.SnapshotKt.access$advanceGlobalSnapshot()
            goto L45
        L42:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        L45:
            int r0 = r7.getChildCount()
            if (r0 <= 0) goto L56
            android.view.View r0 = r7.getChildAt(r1)
            boolean r4 = r0 instanceof androidx.compose.ui.platform.AndroidComposeView
            if (r4 == 0) goto L59
            androidx.compose.ui.platform.AndroidComposeView r0 = (androidx.compose.ui.platform.AndroidComposeView) r0
            goto L5a
        L56:
            r7.removeAllViews()
        L59:
            r0 = r3
        L5a:
            if (r0 != 0) goto L77
            androidx.compose.ui.platform.AndroidComposeView r0 = new androidx.compose.ui.platform.AndroidComposeView
            android.content.Context r4 = r7.getContext()
            java.lang.String r5 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            kotlin.coroutines.CoroutineContext r5 = r8.getEffectCoroutineContext()
            r0.<init>(r4, r5)
            android.view.View r4 = r0.getView()
            android.view.ViewGroup$LayoutParams r5 = androidx.compose.ui.platform.Wrapper_androidKt.DefaultLayoutParams
            r7.addView(r4, r5)
        L77:
            int r7 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r7 < r4) goto L8b
            androidx.compose.ui.platform.WrapperVerificationHelperMethods r7 = androidx.compose.ui.platform.WrapperVerificationHelperMethods.INSTANCE
            java.util.Map r7 = r7.attributeSourceResourceMap(r0)
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r2
            if (r7 == 0) goto L8b
            r1 = r2
        L8b:
            if (r1 == 0) goto Lb4
            java.util.WeakHashMap r7 = new java.util.WeakHashMap
            r7.<init>()
            java.util.Set r7 = java.util.Collections.newSetFromMap(r7)
            r1 = 2131427866(0x7f0b021a, float:1.847736E38)
            r0.setTag(r1, r7)
            androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1 r7 = androidx.compose.ui.platform.InspectableValueKt.NoInspectorInfo
            java.lang.Class<androidx.compose.ui.platform.InspectableValueKt> r7 = androidx.compose.ui.platform.InspectableValueKt.class
            java.lang.String r1 = "isDebugInspectorInfoEnabled"
            java.lang.reflect.Field r7 = r7.getDeclaredField(r1)     // Catch: java.lang.Exception -> Lad
            r7.setAccessible(r2)     // Catch: java.lang.Exception -> Lad
            r7.setBoolean(r3, r2)     // Catch: java.lang.Exception -> Lad
            goto Lb4
        Lad:
            java.lang.String r7 = "Wrapper"
            java.lang.String r1 = "Could not access isDebugInspectorInfoEnabled. Please set explicitly."
            android.util.Log.w(r7, r1)
        Lb4:
            androidx.compose.ui.node.UiApplier r7 = new androidx.compose.ui.node.UiApplier
            androidx.compose.ui.node.LayoutNode r1 = r0.getRoot()
            r7.<init>(r1)
            androidx.compose.runtime.CompositionImpl r7 = androidx.compose.runtime.CompositionKt.Composition(r7, r8)
            android.view.View r8 = r0.getView()
            r1 = 2131428558(0x7f0b04ce, float:1.8478764E38)
            java.lang.Object r8 = r8.getTag(r1)
            boolean r2 = r8 instanceof androidx.compose.ui.platform.WrappedComposition
            if (r2 == 0) goto Ld3
            r3 = r8
            androidx.compose.ui.platform.WrappedComposition r3 = (androidx.compose.ui.platform.WrappedComposition) r3
        Ld3:
            if (r3 != 0) goto Le1
            androidx.compose.ui.platform.WrappedComposition r3 = new androidx.compose.ui.platform.WrappedComposition
            r3.<init>(r0, r7)
            android.view.View r7 = r0.getView()
            r7.setTag(r1, r3)
        Le1:
            r3.setContent(r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.Wrapper_androidKt.setContent(androidx.compose.ui.platform.AbstractComposeView, androidx.compose.runtime.CompositionContext, androidx.compose.runtime.internal.ComposableLambdaImpl):androidx.compose.runtime.Composition");
    }
}
