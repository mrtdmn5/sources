package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaverKt$Saver$1;
import kotlin.jvm.functions.Function0;

/* compiled from: LazyListState.kt */
/* loaded from: classes.dex */
public final class LazyListStateKt {
    public static final LazyListState rememberLazyListState(Composer composer) {
        composer.startReplaceableGroup(1470655220);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final int r0 = 0;
        Object[] objArr = new Object[0];
        SaverKt$Saver$1 saverKt$Saver$1 = LazyListState.Saver;
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed((Object) 0) | composer.changed((Object) 0);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.Empty) {
            rememberedValue = new Function0<LazyListState>() { // from class: androidx.compose.foundation.lazy.LazyListStateKt$rememberLazyListState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final LazyListState invoke() {
                    return new LazyListState(r0, r0);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazyListState lazyListState = (LazyListState) RememberSaveableKt.rememberSaveable(objArr, saverKt$Saver$1, (Function0) rememberedValue, composer, 4);
        composer.endReplaceableGroup();
        return lazyListState;
    }
}
