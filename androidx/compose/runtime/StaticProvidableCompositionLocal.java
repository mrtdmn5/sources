package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompositionLocal.kt */
/* loaded from: classes.dex */
public final class StaticProvidableCompositionLocal<T> extends ProvidableCompositionLocal<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticProvidableCompositionLocal(Function0<? extends T> defaultFactory) {
        super(defaultFactory);
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
    }

    @Override // androidx.compose.runtime.CompositionLocal
    public final State provided$runtime_release(Object obj, Composer composer) {
        composer.startReplaceableGroup(-1121811719);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        StaticValueHolder staticValueHolder = new StaticValueHolder(obj);
        composer.endReplaceableGroup();
        return staticValueHolder;
    }
}
