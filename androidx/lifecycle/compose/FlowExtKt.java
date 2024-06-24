package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$5;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.collect.Platform;
import java.util.Arrays;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: FlowExt.kt */
/* loaded from: classes.dex */
public final class FlowExtKt {
    public static final MutableState collectAsStateWithLifecycle(Flow flow, Object obj, Composer composer, int r9) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        composer.startReplaceableGroup(-1485997211);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) composer.consume(AndroidCompositionLocals_androidKt.LocalLifecycleOwner);
        MutableState collectAsStateWithLifecycle = collectAsStateWithLifecycle(flow, obj, lifecycleOwner.getLifecycle(), Lifecycle.State.STARTED, EmptyCoroutineContext.INSTANCE, composer);
        composer.endReplaceableGroup();
        return collectAsStateWithLifecycle;
    }

    public static final MutableState collectAsStateWithLifecycle(StateFlow stateFlow, Composer composer) {
        Intrinsics.checkNotNullParameter(stateFlow, "<this>");
        composer.startReplaceableGroup(743249048);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) composer.consume(AndroidCompositionLocals_androidKt.LocalLifecycleOwner);
        MutableState collectAsStateWithLifecycle = collectAsStateWithLifecycle(stateFlow, stateFlow.getValue(), lifecycleOwner.getLifecycle(), Lifecycle.State.STARTED, EmptyCoroutineContext.INSTANCE, composer);
        composer.endReplaceableGroup();
        return collectAsStateWithLifecycle;
    }

    public static final MutableState collectAsStateWithLifecycle(Flow flow, Object obj, Lifecycle lifecycle, Lifecycle.State state, CoroutineContext coroutineContext, Composer composer) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        composer.startReplaceableGroup(1977777920);
        Object[] objArr = {flow, lifecycle, state, coroutineContext};
        FlowExtKt$collectAsStateWithLifecycle$1 flowExtKt$collectAsStateWithLifecycle$1 = new FlowExtKt$collectAsStateWithLifecycle$1(lifecycle, state, coroutineContext, flow, null);
        composer.startReplaceableGroup(490154582);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.Empty) {
            rememberedValue = Platform.mutableStateOf$default(obj);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        EffectsKt.LaunchedEffect(Arrays.copyOf(objArr, 4), (Function2) new SnapshotStateKt__ProduceStateKt$produceState$5(flowExtKt$collectAsStateWithLifecycle$1, mutableState, null), composer);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return mutableState;
    }
}
