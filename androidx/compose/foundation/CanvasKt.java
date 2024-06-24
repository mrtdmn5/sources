package androidx.compose.foundation;

import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Canvas.kt */
/* loaded from: classes.dex */
public final class CanvasKt {
    public static final void Canvas(final Modifier modifier, final Function1<? super DrawScope, Unit> onDraw, Composer composer, final int r5) {
        int r0;
        int r1;
        int r02;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(onDraw, "onDraw");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-932836462);
        if ((r5 & 14) == 0) {
            if (startRestartGroup.changed(modifier)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r5;
        } else {
            r0 = r5;
        }
        if ((r5 & 112) == 0) {
            if (startRestartGroup.changedInstance(onDraw)) {
                r1 = 32;
            } else {
                r1 = 16;
            }
            r0 |= r1;
        }
        if ((r0 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SpacerKt.Spacer(DrawModifierKt.drawBehind(modifier, onDraw), startRestartGroup, 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.CanvasKt$Canvas$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r5 | 1);
                    CanvasKt.Canvas(Modifier.this, onDraw, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
