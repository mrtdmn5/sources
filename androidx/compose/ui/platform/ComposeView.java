package androidx.compose.ui.platform;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposeView.android.kt */
/* loaded from: classes.dex */
public final class ComposeView extends AbstractComposeView {
    public final ParcelableSnapshotMutableState content;
    public boolean shouldCreateCompositionOnAttachedToWindow;

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public ComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void Content(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(420213850);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Function2 function2 = (Function2) this.content.getValue();
        if (function2 != null) {
            function2.invoke(startRestartGroup, 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.ComposeView$Content$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r4 | 1);
                    ComposeView.this.Content(composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.compose.ui.platform.ComposeView";
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.shouldCreateCompositionOnAttachedToWindow = true;
        this.content.setValue(content);
        if (isAttachedToWindow()) {
            createComposition();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ComposeView(android.content.Context r2, android.util.AttributeSet r3, int r4) {
        /*
            r1 = this;
            r4 = r4 & 2
            r0 = 0
            if (r4 == 0) goto L6
            r3 = r0
        L6:
            java.lang.String r4 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            r4 = 0
            r1.<init>(r2, r3, r4)
            androidx.compose.runtime.ParcelableSnapshotMutableState r2 = com.google.common.collect.Platform.mutableStateOf$default(r0)
            r1.content = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.ComposeView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public static /* synthetic */ void getShouldCreateCompositionOnAttachedToWindow$annotations() {
    }
}
