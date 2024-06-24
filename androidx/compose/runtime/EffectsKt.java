package androidx.compose.runtime;

import androidx.compose.runtime.Composer;
import java.util.Arrays;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.internal.ContextScope;

/* compiled from: Effects.kt */
/* loaded from: classes.dex */
public final class EffectsKt {
    public static final DisposableEffectScope InternalDisposableEffectScope = new DisposableEffectScope();

    public static final void DisposableEffect(Object obj, Function1 effect, Composer composer) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        composer.startReplaceableGroup(-1371986847);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.Empty) {
            composer.updateRememberedValue(new DisposableEffectImpl(effect));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final void LaunchedEffect(Object obj, Function2 block, Composer composer) {
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(1179185413);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.Empty) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, block));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final void SideEffect(Function0 effect, Composer composer) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        composer.startReplaceableGroup(-1288466761);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.recordSideEffect(effect);
        composer.endReplaceableGroup();
    }

    public static final ContextScope createCompositionCoroutineScope(Composer composer) {
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        Intrinsics.checkNotNullParameter(composer, "composer");
        Job.Key key = Job.Key.$$INSTANCE;
        CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
        return CoroutineScopeKt.CoroutineScope(applyCoroutineContext.plus(new JobImpl((Job) applyCoroutineContext.get(key))).plus(emptyCoroutineContext));
    }

    public static final void LaunchedEffect(Object obj, Object obj2, Function2 block, Composer composer) {
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(590241125);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(obj) | composer.changed(obj2);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.Empty) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, block));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final void LaunchedEffect(Object[] keys, Function2 function2, Composer composer) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        composer.startReplaceableGroup(-139560008);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
        Object[] copyOf = Arrays.copyOf(keys, keys.length);
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (Object obj : copyOf) {
            z |= composer.changed(obj);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.Empty) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, function2));
        }
        composer.endReplaceableGroup();
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
        composer.endReplaceableGroup();
    }
}
