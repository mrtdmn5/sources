package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.platform.AbstractComposeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidView.android.kt */
/* loaded from: classes.dex */
public final class ViewFactoryHolder<T extends View> extends AndroidViewHolder {
    public final NestedScrollDispatcher dispatcher;
    public Function1<? super T, Unit> releaseBlock;
    public Function1<? super T, Unit> resetBlock;
    public SaveableStateRegistry.Entry savableRegistryEntry;
    public final SaveableStateRegistry saveStateRegistry;
    public final T typedView;
    public Function1<? super T, Unit> updateBlock;

    public ViewFactoryHolder() {
        throw null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ViewFactoryHolder(android.content.Context r8, kotlin.jvm.functions.Function1<? super android.content.Context, ? extends T> r9, androidx.compose.runtime.CompositionContext r10, androidx.compose.runtime.saveable.SaveableStateRegistry r11, int r12) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.Object r9 = r9.invoke(r8)
            android.view.View r9 = (android.view.View) r9
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r6 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
            r6.<init>()
            r0 = r7
            r1 = r8
            r2 = r10
            r3 = r12
            r4 = r6
            r5 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            r7.typedView = r9
            r7.dispatcher = r6
            r7.saveStateRegistry = r11
            r8 = 0
            r7.setClipChildren(r8)
            java.lang.String r8 = java.lang.String.valueOf(r12)
            r10 = 0
            if (r11 == 0) goto L34
            java.lang.Object r12 = r11.consumeRestored(r8)
            goto L35
        L34:
            r12 = r10
        L35:
            boolean r0 = r12 instanceof android.util.SparseArray
            if (r0 == 0) goto L3c
            r10 = r12
            android.util.SparseArray r10 = (android.util.SparseArray) r10
        L3c:
            if (r10 == 0) goto L41
            r9.restoreHierarchyState(r10)
        L41:
            if (r11 == 0) goto L4f
            androidx.compose.ui.viewinterop.ViewFactoryHolder$registerSaveStateProvider$1 r9 = new androidx.compose.ui.viewinterop.ViewFactoryHolder$registerSaveStateProvider$1
            r9.<init>(r7)
            androidx.compose.runtime.saveable.SaveableStateRegistry$Entry r8 = r11.registerProvider(r8, r9)
            r7.setSavableRegistryEntry(r8)
        L4f:
            androidx.compose.ui.viewinterop.AndroidView_androidKt$NoOpUpdate$1 r8 = androidx.compose.ui.viewinterop.AndroidView_androidKt.NoOpUpdate
            r7.updateBlock = r8
            r7.resetBlock = r8
            r7.releaseBlock = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.ViewFactoryHolder.<init>(android.content.Context, kotlin.jvm.functions.Function1, androidx.compose.runtime.CompositionContext, androidx.compose.runtime.saveable.SaveableStateRegistry, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSavableRegistryEntry(SaveableStateRegistry.Entry entry) {
        SaveableStateRegistry.Entry entry2 = this.savableRegistryEntry;
        if (entry2 != null) {
            entry2.unregister();
        }
        this.savableRegistryEntry = entry;
    }

    public final NestedScrollDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final Function1<T, Unit> getReleaseBlock() {
        return this.releaseBlock;
    }

    public final Function1<T, Unit> getResetBlock() {
        return this.resetBlock;
    }

    public /* bridge */ /* synthetic */ AbstractComposeView getSubCompositionView() {
        return null;
    }

    public final Function1<T, Unit> getUpdateBlock() {
        return this.updateBlock;
    }

    public final void setReleaseBlock(Function1<? super T, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.releaseBlock = value;
        setRelease(new Function0<Unit>(this) { // from class: androidx.compose.ui.viewinterop.ViewFactoryHolder$releaseBlock$1
            public final /* synthetic */ ViewFactoryHolder<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                ViewFactoryHolder<T> viewFactoryHolder = this.this$0;
                viewFactoryHolder.getReleaseBlock().invoke(viewFactoryHolder.typedView);
                viewFactoryHolder.setSavableRegistryEntry(null);
                return Unit.INSTANCE;
            }
        });
    }

    public final void setResetBlock(Function1<? super T, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.resetBlock = value;
        setReset(new Function0<Unit>(this) { // from class: androidx.compose.ui.viewinterop.ViewFactoryHolder$resetBlock$1
            public final /* synthetic */ ViewFactoryHolder<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                ViewFactoryHolder<T> viewFactoryHolder = this.this$0;
                viewFactoryHolder.getResetBlock().invoke(viewFactoryHolder.typedView);
                return Unit.INSTANCE;
            }
        });
    }

    public final void setUpdateBlock(Function1<? super T, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.updateBlock = value;
        setUpdate(new Function0<Unit>(this) { // from class: androidx.compose.ui.viewinterop.ViewFactoryHolder$updateBlock$1
            public final /* synthetic */ ViewFactoryHolder<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                ViewFactoryHolder<T> viewFactoryHolder = this.this$0;
                viewFactoryHolder.getUpdateBlock().invoke(viewFactoryHolder.typedView);
                return Unit.INSTANCE;
            }
        });
    }

    public View getViewRoot() {
        return this;
    }
}
