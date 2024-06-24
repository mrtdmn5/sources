package androidx.compose.foundation.lazy.layout;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayoutPrefetcher.android.kt */
/* loaded from: classes.dex */
public final class LazyLayoutPrefetcher_androidKt {
    public static final void LazyLayoutPrefetcher(final LazyLayoutPrefetchState prefetchState, final LazyLayoutItemContentFactory itemContentFactory, final SubcomposeLayoutState subcomposeLayoutState, Composer composer, final int r7) {
        Intrinsics.checkNotNullParameter(prefetchState, "prefetchState");
        Intrinsics.checkNotNullParameter(itemContentFactory, "itemContentFactory");
        Intrinsics.checkNotNullParameter(subcomposeLayoutState, "subcomposeLayoutState");
        ComposerImpl startRestartGroup = composer.startRestartGroup(1113453182);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        View view = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.LocalView);
        startRestartGroup.startReplaceableGroup(1618982084);
        boolean changed = startRestartGroup.changed(subcomposeLayoutState) | startRestartGroup.changed(prefetchState) | startRestartGroup.changed(view);
        Object nextSlot = startRestartGroup.nextSlot();
        if (changed || nextSlot == Composer.Companion.Empty) {
            startRestartGroup.updateValue(new LazyLayoutPrefetcher(prefetchState, subcomposeLayoutState, itemContentFactory, view));
        }
        startRestartGroup.end(false);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher_androidKt$LazyLayoutPrefetcher$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r7 | 1);
                    LazyLayoutItemContentFactory lazyLayoutItemContentFactory = itemContentFactory;
                    SubcomposeLayoutState subcomposeLayoutState2 = subcomposeLayoutState;
                    LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(LazyLayoutPrefetchState.this, lazyLayoutItemContentFactory, subcomposeLayoutState2, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
