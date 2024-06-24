package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import com.google.common.base.Strings;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SaveableStateHolder.kt */
/* loaded from: classes.dex */
public final class SaveableStateHolderImpl implements SaveableStateHolder {
    public static final SaverKt$Saver$1 Saver = SaverKt.Saver(new Function2<SaverScope, SaveableStateHolderImpl, Map<Object, Map<String, ? extends List<? extends Object>>>>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final Map<Object, Map<String, ? extends List<? extends Object>>> invoke(SaverScope saverScope, SaveableStateHolderImpl saveableStateHolderImpl) {
            SaverScope Saver2 = saverScope;
            SaveableStateHolderImpl it = saveableStateHolderImpl;
            Intrinsics.checkNotNullParameter(Saver2, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            LinkedHashMap mutableMap = MapsKt__MapsKt.toMutableMap(it.savedStates);
            Iterator it2 = it.registryHolders.values().iterator();
            while (it2.hasNext()) {
                ((SaveableStateHolderImpl.RegistryHolder) it2.next()).saveTo(mutableMap);
            }
            if (mutableMap.isEmpty()) {
                return null;
            }
            return mutableMap;
        }
    }, new Function1<Map<Object, Map<String, ? extends List<? extends Object>>>, SaveableStateHolderImpl>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public final SaveableStateHolderImpl invoke(Map<Object, Map<String, ? extends List<? extends Object>>> map) {
            Map<Object, Map<String, ? extends List<? extends Object>>> it = map;
            Intrinsics.checkNotNullParameter(it, "it");
            return new SaveableStateHolderImpl((Map<Object, Map<String, List<Object>>>) it);
        }
    });
    public SaveableStateRegistry parentSaveableStateRegistry;
    public final LinkedHashMap registryHolders;
    public final Map<Object, Map<String, List<Object>>> savedStates;

    /* compiled from: SaveableStateHolder.kt */
    /* loaded from: classes.dex */
    public final class RegistryHolder {
        public final Object key;
        public final SaveableStateRegistryImpl registry;
        public boolean shouldSave;

        public RegistryHolder(final SaveableStateHolderImpl saveableStateHolderImpl, Object key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.shouldSave = true;
            Map<String, List<Object>> map = saveableStateHolderImpl.savedStates.get(key);
            Function1<Object, Boolean> function1 = new Function1<Object, Boolean>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$RegistryHolder$registry$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object it) {
                    boolean z;
                    Intrinsics.checkNotNullParameter(it, "it");
                    SaveableStateRegistry saveableStateRegistry = SaveableStateHolderImpl.this.parentSaveableStateRegistry;
                    if (saveableStateRegistry != null) {
                        z = saveableStateRegistry.canBeSaved(it);
                    } else {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            };
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = SaveableStateRegistryKt.LocalSaveableStateRegistry;
            this.registry = new SaveableStateRegistryImpl(map, function1);
        }

        public final void saveTo(Map<Object, Map<String, List<Object>>> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            if (this.shouldSave) {
                Map<String, List<Object>> performSave = this.registry.performSave();
                boolean isEmpty = performSave.isEmpty();
                Object obj = this.key;
                if (isEmpty) {
                    map.remove(obj);
                } else {
                    map.put(obj, performSave);
                }
            }
        }
    }

    public SaveableStateHolderImpl() {
        this(0);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public final void SaveableStateProvider(final Object key, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int r8) {
        boolean z;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1198538093);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(444418301);
        startRestartGroup.startReusableGroup(key);
        startRestartGroup.startReplaceableGroup(-492369756);
        Object nextSlot = startRestartGroup.nextSlot();
        if (nextSlot == Composer.Companion.Empty) {
            SaveableStateRegistry saveableStateRegistry = this.parentSaveableStateRegistry;
            if (saveableStateRegistry != null) {
                z = saveableStateRegistry.canBeSaved(key);
            } else {
                z = true;
            }
            if (z) {
                nextSlot = new RegistryHolder(this, key);
                startRestartGroup.updateValue(nextSlot);
            } else {
                throw new IllegalArgumentException(("Type of the key " + key + " is not supported. On Android you can only use types which can be stored inside the Bundle.").toString());
            }
        }
        startRestartGroup.end(false);
        final RegistryHolder registryHolder = (RegistryHolder) nextSlot;
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{SaveableStateRegistryKt.LocalSaveableStateRegistry.provides(registryHolder.registry)}, content, startRestartGroup, (r8 & 112) | 8);
        EffectsKt.DisposableEffect(Unit.INSTANCE, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$SaveableStateProvider$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                DisposableEffectScope DisposableEffect = disposableEffectScope;
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final SaveableStateHolderImpl saveableStateHolderImpl = this;
                LinkedHashMap linkedHashMap = saveableStateHolderImpl.registryHolders;
                final Object obj = key;
                if (!linkedHashMap.containsKey(obj)) {
                    saveableStateHolderImpl.savedStates.remove(obj);
                    LinkedHashMap linkedHashMap2 = saveableStateHolderImpl.registryHolders;
                    final SaveableStateHolderImpl.RegistryHolder registryHolder2 = registryHolder;
                    linkedHashMap2.put(obj, registryHolder2);
                    return new DisposableEffectResult() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$SaveableStateProvider$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public final void dispose() {
                            SaveableStateHolderImpl saveableStateHolderImpl2 = saveableStateHolderImpl;
                            SaveableStateHolderImpl.RegistryHolder.this.saveTo(saveableStateHolderImpl2.savedStates);
                            saveableStateHolderImpl2.registryHolders.remove(obj);
                        }
                    };
                }
                throw new IllegalArgumentException(("Key " + obj + " was used multiple times ").toString());
            }
        }, startRestartGroup);
        startRestartGroup.endReusableGroup();
        startRestartGroup.end(false);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$SaveableStateProvider$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r8 | 1);
                    Object obj = key;
                    Function2<Composer, Integer, Unit> function2 = content;
                    SaveableStateHolderImpl.this.SaveableStateProvider(obj, function2, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public final void removeState(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        RegistryHolder registryHolder = (RegistryHolder) this.registryHolders.get(key);
        if (registryHolder != null) {
            registryHolder.shouldSave = false;
        } else {
            this.savedStates.remove(key);
        }
    }

    public SaveableStateHolderImpl(Map<Object, Map<String, List<Object>>> savedStates) {
        Intrinsics.checkNotNullParameter(savedStates, "savedStates");
        this.savedStates = savedStates;
        this.registryHolders = new LinkedHashMap();
    }

    public /* synthetic */ SaveableStateHolderImpl(int r1) {
        this(new LinkedHashMap());
    }
}
