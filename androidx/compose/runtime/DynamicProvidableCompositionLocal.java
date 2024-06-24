package androidx.compose.runtime;

import androidx.compose.runtime.Composer;
import com.google.common.collect.Platform;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompositionLocal.kt */
/* loaded from: classes.dex */
public final class DynamicProvidableCompositionLocal<T> extends ProvidableCompositionLocal<T> {
    public final SnapshotMutationPolicy<T> policy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicProvidableCompositionLocal(SnapshotMutationPolicy<T> policy, Function0<? extends T> defaultFactory) {
        super(defaultFactory);
        Intrinsics.checkNotNullParameter(policy, "policy");
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
        this.policy = policy;
    }

    @Override // androidx.compose.runtime.CompositionLocal
    public final State provided$runtime_release(Object obj, Composer composer) {
        composer.startReplaceableGroup(-84026900);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.Empty) {
            rememberedValue = Platform.mutableStateOf(obj, this.policy);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        mutableState.setValue(obj);
        composer.endReplaceableGroup();
        return mutableState;
    }
}
