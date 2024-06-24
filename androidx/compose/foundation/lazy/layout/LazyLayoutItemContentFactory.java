package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayoutItemContentFactory.kt */
/* loaded from: classes.dex */
public final class LazyLayoutItemContentFactory {
    public final Function0<LazyLayoutItemProvider> itemProvider;
    public final LinkedHashMap lambdasCache;
    public final SaveableStateHolder saveableStateHolder;

    /* compiled from: LazyLayoutItemContentFactory.kt */
    /* loaded from: classes.dex */
    public final class CachedItemContent {
        public Function2<? super Composer, ? super Integer, Unit> _content;
        public final Object contentType;
        public int index;
        public final Object key;
        public final /* synthetic */ LazyLayoutItemContentFactory this$0;

        public CachedItemContent(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, int r3, Object key, Object obj) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.this$0 = lazyLayoutItemContentFactory;
            this.key = key;
            this.contentType = obj;
            this.index = r3;
        }
    }

    public LazyLayoutItemContentFactory(SaveableStateHolder saveableStateHolder, LazyLayoutKt$LazyLayout$3$itemContentFactory$1$1 lazyLayoutKt$LazyLayout$3$itemContentFactory$1$1) {
        Intrinsics.checkNotNullParameter(saveableStateHolder, "saveableStateHolder");
        this.saveableStateHolder = saveableStateHolder;
        this.itemProvider = lazyLayoutKt$LazyLayout$3$itemContentFactory$1$1;
        this.lambdasCache = new LinkedHashMap();
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r6v5, types: [androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1, kotlin.jvm.internal.Lambda] */
    public final Function2 getContent(Object key, int r7, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        LinkedHashMap linkedHashMap = this.lambdasCache;
        final CachedItemContent cachedItemContent = (CachedItemContent) linkedHashMap.get(key);
        if (cachedItemContent != null && cachedItemContent.index == r7 && Intrinsics.areEqual(cachedItemContent.contentType, obj)) {
            Function2<? super Composer, ? super Integer, Unit> function2 = cachedItemContent._content;
            if (function2 == null) {
                final LazyLayoutItemContentFactory lazyLayoutItemContentFactory = cachedItemContent.this$0;
                ComposableLambdaImpl composableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(1403994769, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer, Integer num) {
                        boolean z;
                        Composer composer2 = composer;
                        if ((num.intValue() & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                            LazyLayoutItemContentFactory lazyLayoutItemContentFactory2 = LazyLayoutItemContentFactory.this;
                            LazyLayoutItemProvider invoke = lazyLayoutItemContentFactory2.itemProvider.invoke();
                            final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent2 = cachedItemContent;
                            int r1 = cachedItemContent2.index;
                            int itemCount = invoke.getItemCount();
                            Object obj2 = cachedItemContent2.key;
                            if ((r1 >= itemCount || !Intrinsics.areEqual(invoke.getKey(r1), obj2)) && (r1 = invoke.getIndex(obj2)) != -1) {
                                cachedItemContent2.index = r1;
                            }
                            int r2 = r1;
                            if (r2 != -1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            composer2.startReusableGroup(Boolean.valueOf(z));
                            boolean changed = composer2.changed(z);
                            if (z) {
                                LazyLayoutItemContentFactoryKt.m101access$SkippableItemJVlU9Rs(invoke, lazyLayoutItemContentFactory2.saveableStateHolder, r2, cachedItemContent2.key, composer2, 0);
                            } else {
                                composer2.deactivateToEndGroup(changed);
                            }
                            composer2.endReusableGroup();
                            EffectsKt.DisposableEffect(obj2, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                    DisposableEffectScope DisposableEffect = disposableEffectScope;
                                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                    final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent3 = LazyLayoutItemContentFactory.CachedItemContent.this;
                                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$2$invoke$$inlined$onDispose$1
                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                        public final void dispose() {
                                            LazyLayoutItemContentFactory.CachedItemContent.this._content = null;
                                        }
                                    };
                                }
                            }, composer2);
                        }
                        return Unit.INSTANCE;
                    }
                }, true);
                cachedItemContent._content = composableLambdaInstance;
                return composableLambdaInstance;
            }
            return function2;
        }
        final CachedItemContent cachedItemContent2 = new CachedItemContent(this, r7, key, obj);
        linkedHashMap.put(key, cachedItemContent2);
        Function2<? super Composer, ? super Integer, Unit> function22 = cachedItemContent2._content;
        if (function22 == null) {
            final LazyLayoutItemContentFactory lazyLayoutItemContentFactory2 = cachedItemContent2.this$0;
            ComposableLambdaImpl composableLambdaInstance2 = ComposableLambdaKt.composableLambdaInstance(1403994769, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer, Integer num) {
                    boolean z;
                    Composer composer2 = composer;
                    if ((num.intValue() & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                        LazyLayoutItemContentFactory lazyLayoutItemContentFactory22 = LazyLayoutItemContentFactory.this;
                        LazyLayoutItemProvider invoke = lazyLayoutItemContentFactory22.itemProvider.invoke();
                        final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent22 = cachedItemContent2;
                        int r1 = cachedItemContent22.index;
                        int itemCount = invoke.getItemCount();
                        Object obj2 = cachedItemContent22.key;
                        if ((r1 >= itemCount || !Intrinsics.areEqual(invoke.getKey(r1), obj2)) && (r1 = invoke.getIndex(obj2)) != -1) {
                            cachedItemContent22.index = r1;
                        }
                        int r2 = r1;
                        if (r2 != -1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        composer2.startReusableGroup(Boolean.valueOf(z));
                        boolean changed = composer2.changed(z);
                        if (z) {
                            LazyLayoutItemContentFactoryKt.m101access$SkippableItemJVlU9Rs(invoke, lazyLayoutItemContentFactory22.saveableStateHolder, r2, cachedItemContent22.key, composer2, 0);
                        } else {
                            composer2.deactivateToEndGroup(changed);
                        }
                        composer2.endReusableGroup();
                        EffectsKt.DisposableEffect(obj2, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                DisposableEffectScope DisposableEffect = disposableEffectScope;
                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent3 = LazyLayoutItemContentFactory.CachedItemContent.this;
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$2$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public final void dispose() {
                                        LazyLayoutItemContentFactory.CachedItemContent.this._content = null;
                                    }
                                };
                            }
                        }, composer2);
                    }
                    return Unit.INSTANCE;
                }
            }, true);
            cachedItemContent2._content = composableLambdaInstance2;
            return composableLambdaInstance2;
        }
        return function22;
    }

    public final Object getContentType(Object obj) {
        if (obj == null) {
            return null;
        }
        CachedItemContent cachedItemContent = (CachedItemContent) this.lambdasCache.get(obj);
        if (cachedItemContent != null) {
            return cachedItemContent.contentType;
        }
        LazyLayoutItemProvider invoke = this.itemProvider.invoke();
        int index = invoke.getIndex(obj);
        if (index == -1) {
            return null;
        }
        return invoke.getContentType(index);
    }
}
