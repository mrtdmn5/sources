package androidx.compose.ui.platform;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewCompositionStrategy.android.kt */
/* loaded from: classes.dex */
public interface ViewCompositionStrategy {

    /* compiled from: ViewCompositionStrategy.android.kt */
    /* loaded from: classes.dex */
    public static final class DisposeOnDetachedFromWindow implements ViewCompositionStrategy {
        public static final DisposeOnDetachedFromWindow INSTANCE = new DisposeOnDetachedFromWindow();

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1, android.view.View$OnAttachStateChangeListener] */
        @Override // androidx.compose.ui.platform.ViewCompositionStrategy
        public final Function0<Unit> installFor(final AbstractComposeView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            final ?? r0 = new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1
                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewAttachedToWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewDetachedFromWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    AbstractComposeView.this.disposeComposition();
                }
            };
            view.addOnAttachStateChangeListener(r0);
            return new Function0<Unit>() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    AbstractComposeView.this.removeOnAttachStateChangeListener(r0);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    Function0<Unit> installFor(AbstractComposeView abstractComposeView);
}
