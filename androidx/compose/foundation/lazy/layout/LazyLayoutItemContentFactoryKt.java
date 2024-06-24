package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: LazyLayoutItemContentFactory.kt */
/* loaded from: classes.dex */
public final class LazyLayoutItemContentFactoryKt {
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactoryKt$SkippableItem$1, kotlin.jvm.internal.Lambda] */
    /* renamed from: access$SkippableItem-JVlU9Rs */
    public static final void m101access$SkippableItemJVlU9Rs(final LazyLayoutItemProvider lazyLayoutItemProvider, final Object obj, final int r9, final Object obj2, Composer composer, final int r12) {
        final int r0;
        int r1;
        int r13;
        int r14;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1439843069);
        if ((r12 & 14) == 0) {
            if (startRestartGroup.changed(lazyLayoutItemProvider)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r12;
        } else {
            r0 = r12;
        }
        if ((r12 & 112) == 0) {
            if (startRestartGroup.changed(obj)) {
                r14 = 32;
            } else {
                r14 = 16;
            }
            r0 |= r14;
        }
        if ((r12 & 896) == 0) {
            if (startRestartGroup.changed(r9)) {
                r13 = 256;
            } else {
                r13 = 128;
            }
            r0 |= r13;
        }
        if ((r12 & 7168) == 0) {
            if (startRestartGroup.changed(obj2)) {
                r1 = 2048;
            } else {
                r1 = 1024;
            }
            r0 |= r1;
        }
        if ((r0 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ((SaveableStateHolder) obj).SaveableStateProvider(obj2, ComposableLambdaKt.composableLambda(startRestartGroup, 980966366, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactoryKt$SkippableItem$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    if ((num.intValue() & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        int r5 = r0;
                        int r52 = ((r5 << 6) & 896) | ((r5 >> 6) & 14) | 64;
                        LazyLayoutItemProvider.this.Item(r9, obj2, composer3, r52);
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 568);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactoryKt$SkippableItem$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    LazyLayoutItemContentFactoryKt.m101access$SkippableItemJVlU9Rs(LazyLayoutItemProvider.this, obj, r9, obj2, composer2, Strings.updateChangedFlags(r12 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
