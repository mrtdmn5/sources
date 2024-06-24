package androidx.compose.ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.Owner;
import androidx.core.view.ViewKt$ancestors$1;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.poolingcontainer.PoolingContainerListener;
import com.kronaby.watch.app.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt__SequencesKt;

/* compiled from: ComposeView.android.kt */
/* loaded from: classes.dex */
public abstract class AbstractComposeView extends ViewGroup {
    public WeakReference<CompositionContext> cachedViewTreeCompositionContext;
    public Composition composition;
    public boolean creatingComposition;
    public Function0<Unit> disposeViewCompositionStrategy;
    public boolean isTransitionGroupSet;
    public CompositionContext parentContext;
    public IBinder previousAttachedWindowToken;
    public boolean showLayoutBounds;

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public AbstractComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static boolean isAlive(CompositionContext compositionContext) {
        if ((compositionContext instanceof Recomposer) && ((Recomposer.State) ((Recomposer) compositionContext)._state.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
            return false;
        }
        return true;
    }

    private final void setParentContext(CompositionContext compositionContext) {
        if (this.parentContext != compositionContext) {
            this.parentContext = compositionContext;
            if (compositionContext != null) {
                this.cachedViewTreeCompositionContext = null;
            }
            Composition composition = this.composition;
            if (composition != null) {
                composition.dispose();
                this.composition = null;
                if (isAttachedToWindow()) {
                    ensureCompositionCreated();
                }
            }
        }
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder) {
        if (this.previousAttachedWindowToken != iBinder) {
            this.previousAttachedWindowToken = iBinder;
            this.cachedViewTreeCompositionContext = null;
        }
    }

    public abstract void Content(Composer composer, int r2);

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        checkAddView();
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int r2, ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        return super.addViewInLayout(view, r2, layoutParams);
    }

    public final void checkAddView() {
        if (this.creatingComposition) {
            return;
        }
        throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
    }

    public final void createComposition() {
        boolean z;
        if (this.parentContext == null && !isAttachedToWindow()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            ensureCompositionCreated();
            return;
        }
        throw new IllegalStateException("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.".toString());
    }

    public final void disposeComposition() {
        Composition composition = this.composition;
        if (composition != null) {
            composition.dispose();
        }
        this.composition = null;
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.Lambda, androidx.compose.ui.platform.AbstractComposeView$ensureCompositionCreated$1] */
    public final void ensureCompositionCreated() {
        if (this.composition == null) {
            try {
                this.creatingComposition = true;
                this.composition = Wrapper_androidKt.setContent(this, resolveParentCompositionContext(), ComposableLambdaKt.composableLambdaInstance(-656146368, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.AbstractComposeView$ensureCompositionCreated$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer, Integer num) {
                        Composer composer2 = composer;
                        if ((num.intValue() & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                            AbstractComposeView.this.Content(composer2, 8);
                        }
                        return Unit.INSTANCE;
                    }
                }, true));
            } finally {
                this.creatingComposition = false;
            }
        }
    }

    public final boolean getHasComposition() {
        if (this.composition != null) {
            return true;
        }
        return false;
    }

    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    public final boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public void internalOnLayout$ui_release(boolean z, int r4, int r5, int r6, int r7) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (r6 - r4) - getPaddingRight(), (r7 - r5) - getPaddingBottom());
        }
    }

    public void internalOnMeasure$ui_release(int r6, int r7) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(r6, r7);
            return;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(r6) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(r6)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(r7) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(r7)));
        setMeasuredDimension(getPaddingRight() + getPaddingLeft() + childAt.getMeasuredWidth(), getPaddingBottom() + getPaddingTop() + childAt.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public final boolean isTransitionGroup() {
        if (this.isTransitionGroupSet && !super.isTransitionGroup()) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPreviousAttachedWindowToken(getWindowToken());
        if (getShouldCreateCompositionOnAttachedToWindow()) {
            ensureCompositionCreated();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r2, int r3, int r4, int r5) {
        internalOnLayout$ui_release(z, r2, r3, r4, r5);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        ensureCompositionCreated();
        internalOnMeasure$ui_release(r1, r2);
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int r2) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setLayoutDirection(r2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004a, code lost:            if (r2 != false) goto L30;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.runtime.CompositionContext resolveParentCompositionContext() {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AbstractComposeView.resolveParentCompositionContext():androidx.compose.runtime.CompositionContext");
    }

    public final void setParentCompositionContext(CompositionContext compositionContext) {
        setParentContext(compositionContext);
    }

    public final void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt != null) {
            ((Owner) childAt).setShowLayoutBounds(z);
        }
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean z) {
        super.setTransitionGroup(z);
        this.isTransitionGroupSet = true;
    }

    public final void setViewCompositionStrategy(ViewCompositionStrategy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Function0<Unit> function0 = this.disposeViewCompositionStrategy;
        if (function0 != null) {
            function0.invoke();
        }
        this.disposeViewCompositionStrategy = strategy.installFor(this);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public /* synthetic */ AbstractComposeView(Context context, AttributeSet attributeSet, int r3, int r4) {
        this(context, (r3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View$OnAttachStateChangeListener, androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$listener$1] */
    public AbstractComposeView(Context context, AttributeSet attributeSet, int r4) {
        super(context, attributeSet, r4);
        Intrinsics.checkNotNullParameter(context, "context");
        setClipChildren(false);
        setClipToPadding(false);
        final ?? r2 = new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$listener$1
            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewDetachedFromWindow(View v) {
                boolean z;
                Boolean bool;
                Intrinsics.checkNotNullParameter(v, "v");
                AbstractComposeView abstractComposeView = AbstractComposeView.this;
                Intrinsics.checkNotNullParameter(abstractComposeView, "<this>");
                Iterator it = SequencesKt__SequencesKt.generateSequence(abstractComposeView.getParent(), ViewKt$ancestors$1.INSTANCE).iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object obj = (ViewParent) it.next();
                    if (obj instanceof View) {
                        View view = (View) obj;
                        Intrinsics.checkNotNullParameter(view, "<this>");
                        Object tag = view.getTag(R.id.is_pooling_container_tag);
                        if (tag instanceof Boolean) {
                            bool = (Boolean) tag;
                        } else {
                            bool = null;
                        }
                        if (bool != null) {
                            z = bool.booleanValue();
                        }
                        if (z) {
                            z = true;
                            break;
                        }
                    }
                }
                if (!z) {
                    abstractComposeView.disposeComposition();
                }
            }
        };
        addOnAttachStateChangeListener(r2);
        final ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$poolingContainerListener$1 viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$poolingContainerListener$1 = new ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$poolingContainerListener$1();
        PoolingContainer.getPoolingContainerListenerHolder(this).listeners.add(viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$poolingContainerListener$1);
        this.disposeViewCompositionStrategy = new Function0<Unit>() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                AbstractComposeView abstractComposeView = AbstractComposeView.this;
                abstractComposeView.removeOnAttachStateChangeListener(r2);
                PoolingContainerListener listener = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$poolingContainerListener$1;
                Intrinsics.checkNotNullParameter(listener, "listener");
                PoolingContainer.getPoolingContainerListenerHolder(abstractComposeView).listeners.remove(listener);
                return Unit.INSTANCE;
            }
        };
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int r2) {
        checkAddView();
        super.addView(view, r2);
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int r2, ViewGroup.LayoutParams layoutParams, boolean z) {
        checkAddView();
        return super.addViewInLayout(view, r2, layoutParams, z);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int r2, int r3) {
        checkAddView();
        super.addView(view, r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int r2, ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        super.addView(view, r2, layoutParams);
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }
}
