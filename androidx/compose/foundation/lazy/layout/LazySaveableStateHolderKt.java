package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import com.google.common.base.Strings;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazySaveableStateHolder.kt */
/* loaded from: classes.dex */
public final class LazySaveableStateHolderKt {
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$LazySaveableStateHolderProvider$1, kotlin.jvm.internal.Lambda] */
    public static final void LazySaveableStateHolderProvider(final Function3<? super SaveableStateHolder, ? super Composer, ? super Integer, Unit> content, Composer composer, final int r9) {
        final int r0;
        int r02;
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(674185128);
        if ((r9 & 14) == 0) {
            if (startRestartGroup.changedInstance(content)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r9;
        } else {
            r0 = r9;
        }
        if ((r0 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = SaveableStateRegistryKt.LocalSaveableStateRegistry;
            final SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) startRestartGroup.consume(staticProvidableCompositionLocal);
            final LazySaveableStateHolder lazySaveableStateHolder = (LazySaveableStateHolder) RememberSaveableKt.rememberSaveable(new Object[]{saveableStateRegistry}, SaverKt.Saver(new Function2<SaverScope, LazySaveableStateHolder, Map<String, ? extends List<? extends Object>>>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$Companion$saver$1
                @Override // kotlin.jvm.functions.Function2
                public final Map<String, ? extends List<? extends Object>> invoke(SaverScope saverScope, LazySaveableStateHolder lazySaveableStateHolder2) {
                    SaverScope Saver = saverScope;
                    LazySaveableStateHolder it = lazySaveableStateHolder2;
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Map<String, List<Object>> performSave = it.performSave();
                    if (performSave.isEmpty()) {
                        return null;
                    }
                    return performSave;
                }
            }, new Function1<Map<String, ? extends List<? extends Object>>, LazySaveableStateHolder>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$Companion$saver$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final LazySaveableStateHolder invoke(Map<String, ? extends List<? extends Object>> map) {
                    Map<String, ? extends List<? extends Object>> restored = map;
                    Intrinsics.checkNotNullParameter(restored, "restored");
                    return new LazySaveableStateHolder(SaveableStateRegistry.this, restored);
                }
            }), new Function0<LazySaveableStateHolder>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$LazySaveableStateHolderProvider$holder$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final LazySaveableStateHolder invoke() {
                    return new LazySaveableStateHolder(SaveableStateRegistry.this, EmptyMap.INSTANCE);
                }
            }, startRestartGroup, 4);
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{staticProvidableCompositionLocal.provides(lazySaveableStateHolder)}, ComposableLambdaKt.composableLambda(startRestartGroup, 1863926504, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$LazySaveableStateHolderProvider$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                        composer3.startReplaceableGroup(15454635);
                        SaveableStateHolderImpl saveableStateHolderImpl = (SaveableStateHolderImpl) RememberSaveableKt.rememberSaveable(new Object[0], SaveableStateHolderImpl.Saver, new Function0<SaveableStateHolderImpl>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderKt$rememberSaveableStateHolder$1
                            @Override // kotlin.jvm.functions.Function0
                            public final SaveableStateHolderImpl invoke() {
                                return new SaveableStateHolderImpl(0);
                            }
                        }, composer3, 4);
                        saveableStateHolderImpl.parentSaveableStateRegistry = (SaveableStateRegistry) composer3.consume(SaveableStateRegistryKt.LocalSaveableStateRegistry);
                        composer3.endReplaceableGroup();
                        LazySaveableStateHolder lazySaveableStateHolder2 = LazySaveableStateHolder.this;
                        lazySaveableStateHolder2.wrappedHolder$delegate.setValue(saveableStateHolderImpl);
                        content.invoke(lazySaveableStateHolder2, composer3, Integer.valueOf(((r0 << 3) & 112) | 8));
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 56);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$LazySaveableStateHolderProvider$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r9 | 1);
                    LazySaveableStateHolderKt.LazySaveableStateHolderProvider(content, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
