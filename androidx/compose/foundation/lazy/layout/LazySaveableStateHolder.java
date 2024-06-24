package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import com.animaconnected.dfu.dfu.utils.DfuConstants;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazySaveableStateHolder.kt */
/* loaded from: classes.dex */
public final class LazySaveableStateHolder implements SaveableStateRegistry, SaveableStateHolder {
    public final LinkedHashSet previouslyComposedKeys;
    public final ParcelableSnapshotMutableState wrappedHolder$delegate;
    public final SaveableStateRegistry wrappedRegistry;

    public LazySaveableStateHolder(final SaveableStateRegistry saveableStateRegistry, Map<String, ? extends List<? extends Object>> map) {
        Function1<Object, Boolean> function1 = new Function1<Object, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                boolean z;
                Intrinsics.checkNotNullParameter(it, "it");
                SaveableStateRegistry saveableStateRegistry2 = SaveableStateRegistry.this;
                if (saveableStateRegistry2 != null) {
                    z = saveableStateRegistry2.canBeSaved(it);
                } else {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        };
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = SaveableStateRegistryKt.LocalSaveableStateRegistry;
        this.wrappedRegistry = new SaveableStateRegistryImpl(map, function1);
        this.wrappedHolder$delegate = Platform.mutableStateOf$default(null);
        this.previouslyComposedKeys = new LinkedHashSet();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public final void SaveableStateProvider(final Object key, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int r6) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-697180401);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        SaveableStateHolder saveableStateHolder = (SaveableStateHolder) this.wrappedHolder$delegate.getValue();
        if (saveableStateHolder != null) {
            saveableStateHolder.SaveableStateProvider(key, content, startRestartGroup, (r6 & 112) | DfuConstants.UNKNOWN_DFU_15_ERROR);
            EffectsKt.DisposableEffect(key, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$SaveableStateProvider$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    DisposableEffectScope DisposableEffect = disposableEffectScope;
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final LazySaveableStateHolder lazySaveableStateHolder = LazySaveableStateHolder.this;
                    LinkedHashSet linkedHashSet = lazySaveableStateHolder.previouslyComposedKeys;
                    final Object obj = key;
                    linkedHashSet.remove(obj);
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$SaveableStateProvider$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public final void dispose() {
                            LazySaveableStateHolder.this.previouslyComposedKeys.add(obj);
                        }
                    };
                }
            }, startRestartGroup);
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$SaveableStateProvider$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        int updateChangedFlags = Strings.updateChangedFlags(r6 | 1);
                        Object obj = key;
                        Function2<Composer, Integer, Unit> function2 = content;
                        LazySaveableStateHolder.this.SaveableStateProvider(obj, function2, composer2, updateChangedFlags);
                        return Unit.INSTANCE;
                    }
                };
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final boolean canBeSaved(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.wrappedRegistry.canBeSaved(value);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Object consumeRestored(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.wrappedRegistry.consumeRestored(key);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Map<String, List<Object>> performSave() {
        SaveableStateHolder saveableStateHolder = (SaveableStateHolder) this.wrappedHolder$delegate.getValue();
        if (saveableStateHolder != null) {
            Iterator it = this.previouslyComposedKeys.iterator();
            while (it.hasNext()) {
                saveableStateHolder.removeState(it.next());
            }
        }
        return this.wrappedRegistry.performSave();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final SaveableStateRegistry.Entry registerProvider(String key, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.wrappedRegistry.registerProvider(key, function0);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public final void removeState(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        SaveableStateHolder saveableStateHolder = (SaveableStateHolder) this.wrappedHolder$delegate.getValue();
        if (saveableStateHolder != null) {
            saveableStateHolder.removeState(key);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
