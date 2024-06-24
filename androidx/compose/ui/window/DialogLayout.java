package androidx.compose.ui.window;

import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.platform.AbstractComposeView;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: AndroidDialog.android.kt */
/* loaded from: classes.dex */
public final class DialogLayout extends AbstractComposeView {
    public final ParcelableSnapshotMutableState content$delegate;
    public boolean shouldCreateCompositionOnAttachedToWindow;
    public boolean usePlatformDefaultWidth;
    public final Window window;

    public DialogLayout(Context context, Window window) {
        super(context, null, 6, 0);
        this.window = window;
        this.content$delegate = Platform.mutableStateOf$default(ComposableSingletons$AndroidDialog_androidKt.f13lambda1);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void Content(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1735448596);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ((Function2) this.content$delegate.getValue()).invoke(startRestartGroup, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.DialogLayout$Content$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r4 | 1);
                    DialogLayout.this.Content(composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void internalOnLayout$ui_release(boolean z, int r2, int r3, int r4, int r5) {
        View childAt;
        super.internalOnLayout$ui_release(z, r2, r3, r4, r5);
        if (this.usePlatformDefaultWidth || (childAt = getChildAt(0)) == null) {
            return;
        }
        this.window.setLayout(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void internalOnMeasure$ui_release(int r3, int r4) {
        if (this.usePlatformDefaultWidth) {
            super.internalOnMeasure$ui_release(r3, r4);
            return;
        }
        super.internalOnMeasure$ui_release(View.MeasureSpec.makeMeasureSpec(MathKt__MathJVMKt.roundToInt(getContext().getResources().getConfiguration().screenWidthDp * getContext().getResources().getDisplayMetrics().density), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(MathKt__MathJVMKt.roundToInt(getContext().getResources().getConfiguration().screenHeightDp * getContext().getResources().getDisplayMetrics().density), Integer.MIN_VALUE));
    }
}
