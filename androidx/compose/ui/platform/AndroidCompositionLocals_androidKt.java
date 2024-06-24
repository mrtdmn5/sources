package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateRegistryImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.res.ImageVectorCache;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidCompositionLocals.android.kt */
/* loaded from: classes.dex */
public final class AndroidCompositionLocals_androidKt {
    public static final DynamicProvidableCompositionLocal LocalConfiguration = CompositionLocalKt.compositionLocalOf$default(new Function0<Configuration>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalConfiguration$1
        @Override // kotlin.jvm.functions.Function0
        public final Configuration invoke() {
            AndroidCompositionLocals_androidKt.access$noLocalProvidedFor("LocalConfiguration");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalContext = CompositionLocalKt.staticCompositionLocalOf(new Function0<Context>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalContext$1
        @Override // kotlin.jvm.functions.Function0
        public final Context invoke() {
            AndroidCompositionLocals_androidKt.access$noLocalProvidedFor("LocalContext");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalImageVectorCache = CompositionLocalKt.staticCompositionLocalOf(new Function0<ImageVectorCache>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalImageVectorCache$1
        @Override // kotlin.jvm.functions.Function0
        public final ImageVectorCache invoke() {
            AndroidCompositionLocals_androidKt.access$noLocalProvidedFor("LocalImageVectorCache");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalLifecycleOwner = CompositionLocalKt.staticCompositionLocalOf(new Function0<LifecycleOwner>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalLifecycleOwner$1
        @Override // kotlin.jvm.functions.Function0
        public final LifecycleOwner invoke() {
            AndroidCompositionLocals_androidKt.access$noLocalProvidedFor("LocalLifecycleOwner");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalSavedStateRegistryOwner = CompositionLocalKt.staticCompositionLocalOf(new Function0<SavedStateRegistryOwner>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalSavedStateRegistryOwner$1
        @Override // kotlin.jvm.functions.Function0
        public final SavedStateRegistryOwner invoke() {
            AndroidCompositionLocals_androidKt.access$noLocalProvidedFor("LocalSavedStateRegistryOwner");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalView = CompositionLocalKt.staticCompositionLocalOf(new Function0<View>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalView$1
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            AndroidCompositionLocals_androidKt.access$noLocalProvidedFor("LocalView");
            throw null;
        }
    });

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v3, types: [androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1] */
    /* JADX WARN: Type inference failed for: r3v8, types: [androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3, kotlin.jvm.internal.Lambda] */
    public static final void ProvideAndroidCompositionLocals(final AndroidComposeView owner, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int r25) {
        String id;
        LinkedHashMap linkedHashMap;
        final boolean z;
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(1396852028);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final Context context = owner.getContext();
        startRestartGroup.startReplaceableGroup(-492369756);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = Platform.mutableStateOf$default(new Configuration(context.getResources().getConfiguration()));
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        final MutableState mutableState = (MutableState) nextSlot;
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(mutableState);
        Object nextSlot2 = startRestartGroup.nextSlot();
        if (changed || nextSlot2 == composer$Companion$Empty$1) {
            nextSlot2 = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Configuration configuration) {
                    Configuration it = configuration;
                    Intrinsics.checkNotNullParameter(it, "it");
                    mutableState.setValue(new Configuration(it));
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateValue(nextSlot2);
        }
        startRestartGroup.end(false);
        owner.setConfigurationChangeObserver((Function1) nextSlot2);
        startRestartGroup.startReplaceableGroup(-492369756);
        Object nextSlot3 = startRestartGroup.nextSlot();
        if (nextSlot3 == composer$Companion$Empty$1) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            nextSlot3 = new AndroidUriHandler(context);
            startRestartGroup.updateValue(nextSlot3);
        }
        startRestartGroup.end(false);
        final AndroidUriHandler androidUriHandler = (AndroidUriHandler) nextSlot3;
        AndroidComposeView.ViewTreeOwners viewTreeOwners = owner.getViewTreeOwners();
        if (viewTreeOwners != null) {
            startRestartGroup.startReplaceableGroup(-492369756);
            Object nextSlot4 = startRestartGroup.nextSlot();
            SavedStateRegistryOwner owner2 = viewTreeOwners.savedStateRegistryOwner;
            if (nextSlot4 == composer$Companion$Empty$1) {
                Intrinsics.checkNotNullParameter(owner2, "owner");
                Object parent = owner.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                View view = (View) parent;
                Object tag = view.getTag(R.id.compose_view_saveable_id_tag);
                if (tag instanceof String) {
                    id = (String) tag;
                } else {
                    id = null;
                }
                if (id == null) {
                    id = String.valueOf(view.getId());
                }
                Intrinsics.checkNotNullParameter(id, "id");
                final String concat = "SaveableStateRegistry:".concat(id);
                final SavedStateRegistry savedStateRegistry = owner2.getSavedStateRegistry();
                Bundle consumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey(concat);
                if (consumeRestoredStateForKey != null) {
                    linkedHashMap = new LinkedHashMap();
                    Set<String> keySet = consumeRestoredStateForKey.keySet();
                    Intrinsics.checkNotNullExpressionValue(keySet, "this.keySet()");
                    Iterator it = keySet.iterator();
                    while (it.hasNext()) {
                        String key = (String) it.next();
                        Iterator it2 = it;
                        ArrayList parcelableArrayList = consumeRestoredStateForKey.getParcelableArrayList(key);
                        Intrinsics.checkNotNull(parcelableArrayList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Any?> }");
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        linkedHashMap.put(key, parcelableArrayList);
                        it = it2;
                        consumeRestoredStateForKey = consumeRestoredStateForKey;
                    }
                } else {
                    linkedHashMap = null;
                }
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = SaveableStateRegistryKt.LocalSaveableStateRegistry;
                DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$saveableStateRegistry$1 canBeSaved = new Function1<Object, Boolean>() { // from class: androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$saveableStateRegistry$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Object it3) {
                        Intrinsics.checkNotNullParameter(it3, "it");
                        return Boolean.valueOf(DisposableSaveableStateRegistry_androidKt.canBeSavedToBundle(it3));
                    }
                };
                Intrinsics.checkNotNullParameter(canBeSaved, "canBeSaved");
                final SaveableStateRegistryImpl saveableStateRegistryImpl = new SaveableStateRegistryImpl(linkedHashMap, canBeSaved);
                try {
                    savedStateRegistry.registerSavedStateProvider(concat, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$registered$1
                        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
                        public final Bundle saveState() {
                            ArrayList<? extends Parcelable> arrayList;
                            Map<String, List<Object>> performSave = saveableStateRegistryImpl.performSave();
                            Bundle bundle = new Bundle();
                            for (Map.Entry<String, List<Object>> entry : performSave.entrySet()) {
                                String key2 = entry.getKey();
                                List<Object> value = entry.getValue();
                                if (value instanceof ArrayList) {
                                    arrayList = (ArrayList) value;
                                } else {
                                    arrayList = new ArrayList<>(value);
                                }
                                bundle.putParcelableArrayList(key2, arrayList);
                            }
                            return bundle;
                        }
                    });
                    z = true;
                } catch (IllegalArgumentException unused) {
                    z = false;
                }
                DisposableSaveableStateRegistry disposableSaveableStateRegistry = new DisposableSaveableStateRegistry(saveableStateRegistryImpl, new Function0<Unit>() { // from class: androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        if (z) {
                            SavedStateRegistry savedStateRegistry2 = savedStateRegistry;
                            savedStateRegistry2.getClass();
                            String key2 = concat;
                            Intrinsics.checkNotNullParameter(key2, "key");
                            savedStateRegistry2.components.remove(key2);
                        }
                        return Unit.INSTANCE;
                    }
                });
                startRestartGroup.updateValue(disposableSaveableStateRegistry);
                nextSlot4 = disposableSaveableStateRegistry;
            }
            startRestartGroup.end(false);
            final DisposableSaveableStateRegistry disposableSaveableStateRegistry2 = (DisposableSaveableStateRegistry) nextSlot4;
            EffectsKt.DisposableEffect(Unit.INSTANCE, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    DisposableEffectScope DisposableEffect = disposableEffectScope;
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final DisposableSaveableStateRegistry disposableSaveableStateRegistry3 = DisposableSaveableStateRegistry.this;
                    return new DisposableEffectResult() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public final void dispose() {
                            DisposableSaveableStateRegistry.this.onDispose.invoke();
                        }
                    };
                }
            }, startRestartGroup);
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Configuration configuration = (Configuration) mutableState.getValue();
            startRestartGroup.startReplaceableGroup(-485908294);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object nextSlot5 = startRestartGroup.nextSlot();
            if (nextSlot5 == composer$Companion$Empty$1) {
                nextSlot5 = new ImageVectorCache();
                startRestartGroup.updateValue(nextSlot5);
            }
            startRestartGroup.end(false);
            final ImageVectorCache imageVectorCache = (ImageVectorCache) nextSlot5;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object nextSlot6 = startRestartGroup.nextSlot();
            Object obj = nextSlot6;
            if (nextSlot6 == composer$Companion$Empty$1) {
                Configuration configuration2 = new Configuration();
                if (configuration != null) {
                    configuration2.setTo(configuration);
                }
                startRestartGroup.updateValue(configuration2);
                obj = configuration2;
            }
            startRestartGroup.end(false);
            final Configuration configuration3 = (Configuration) obj;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object nextSlot7 = startRestartGroup.nextSlot();
            if (nextSlot7 == composer$Companion$Empty$1) {
                nextSlot7 = new ComponentCallbacks2() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1
                    @Override // android.content.ComponentCallbacks
                    public final void onConfigurationChanged(Configuration configuration4) {
                        Intrinsics.checkNotNullParameter(configuration4, "configuration");
                        Configuration configuration5 = configuration3;
                        int updateFrom = configuration5.updateFrom(configuration4);
                        Iterator<Map.Entry<ImageVectorCache.Key, WeakReference<ImageVectorCache.ImageVectorEntry>>> it3 = imageVectorCache.map.entrySet().iterator();
                        while (it3.hasNext()) {
                            Map.Entry<ImageVectorCache.Key, WeakReference<ImageVectorCache.ImageVectorEntry>> next = it3.next();
                            Intrinsics.checkNotNullExpressionValue(next, "it.next()");
                            ImageVectorCache.ImageVectorEntry imageVectorEntry = next.getValue().get();
                            if (imageVectorEntry == null || Configuration.needNewResources(updateFrom, imageVectorEntry.configFlags)) {
                                it3.remove();
                            }
                        }
                        configuration5.setTo(configuration4);
                    }

                    @Override // android.content.ComponentCallbacks
                    public final void onLowMemory() {
                        imageVectorCache.map.clear();
                    }

                    @Override // android.content.ComponentCallbacks2
                    public final void onTrimMemory(int r1) {
                        imageVectorCache.map.clear();
                    }
                };
                startRestartGroup.updateValue(nextSlot7);
            }
            startRestartGroup.end(false);
            final AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 = (AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1) nextSlot7;
            EffectsKt.DisposableEffect(imageVectorCache, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainImageVectorCache$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    DisposableEffectScope DisposableEffect = disposableEffectScope;
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final Context context2 = context;
                    Context applicationContext = context2.getApplicationContext();
                    final AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$12 = androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1;
                    applicationContext.registerComponentCallbacks(androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$12);
                    return new DisposableEffectResult() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public final void dispose() {
                            context2.getApplicationContext().unregisterComponentCallbacks(androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$12);
                        }
                    };
                }
            }, startRestartGroup);
            startRestartGroup.end(false);
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{LocalConfiguration.provides((Configuration) mutableState.getValue()), LocalContext.provides(context), LocalLifecycleOwner.provides(viewTreeOwners.lifecycleOwner), LocalSavedStateRegistryOwner.provides(owner2), SaveableStateRegistryKt.LocalSaveableStateRegistry.provides(disposableSaveableStateRegistry2), LocalView.provides(owner.getView()), LocalImageVectorCache.provides(imageVectorCache)}, ComposableLambdaKt.composableLambda(startRestartGroup, 1471621628, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3
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
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                        int r5 = ((r25 << 3) & 896) | 72;
                        CompositionLocalsKt.ProvideCommonCompositionLocals(AndroidComposeView.this, androidUriHandler, content, composer3, r5);
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 56);
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        int updateChangedFlags = Strings.updateChangedFlags(r25 | 1);
                        AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals(AndroidComposeView.this, content, composer2, updateChangedFlags);
                        return Unit.INSTANCE;
                    }
                };
                return;
            }
            return;
        }
        throw new IllegalStateException("Called when the ViewTreeOwnersAvailability is not yet in Available state");
    }

    public static final void access$noLocalProvidedFor(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }
}
