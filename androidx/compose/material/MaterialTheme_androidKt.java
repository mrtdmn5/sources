package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaterialTheme.android.kt */
/* loaded from: classes.dex */
public final class MaterialTheme_androidKt {
    public static final void PlatformMaterialTheme(final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int r5) {
        int r0;
        int r02;
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1322912246);
        if ((r5 & 14) == 0) {
            if (startRestartGroup.changedInstance(content)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r5;
        } else {
            r0 = r5;
        }
        if ((r0 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            content.invoke(startRestartGroup, Integer.valueOf(r0 & 14));
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MaterialTheme_androidKt$PlatformMaterialTheme$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r5 | 1);
                    MaterialTheme_androidKt.PlatformMaterialTheme(content, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
