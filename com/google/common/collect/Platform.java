package com.google.common.collect;

import androidx.compose.runtime.ActualAndroid_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$3;
import androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1;
import androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.StructuralEqualityPolicy;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes3.dex */
public final class Platform {
    public static final MutableState collectAsState(Flow flow, Object obj, CoroutineContext coroutineContext, Composer composer, int r7) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        composer.startReplaceableGroup(-606625098);
        if ((r7 & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        SnapshotStateKt__SnapshotFlowKt$collectAsState$1 snapshotStateKt__SnapshotFlowKt$collectAsState$1 = new SnapshotStateKt__SnapshotFlowKt$collectAsState$1(coroutineContext, flow, null);
        composer.startReplaceableGroup(-1703169085);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.Empty) {
            rememberedValue = mutableStateOf$default(obj);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        EffectsKt.LaunchedEffect(flow, coroutineContext, new SnapshotStateKt__ProduceStateKt$produceState$3(snapshotStateKt__SnapshotFlowKt$collectAsState$1, mutableState, null), composer);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return mutableState;
    }

    public static final MutableVector derivedStateObservers() {
        SnapshotThreadLocal<MutableVector<DerivedStateObserver>> snapshotThreadLocal = SnapshotStateKt__DerivedStateKt.derivedStateObservers;
        MutableVector<DerivedStateObserver> mutableVector = snapshotThreadLocal.get();
        if (mutableVector == null) {
            MutableVector<DerivedStateObserver> mutableVector2 = new MutableVector<>(new DerivedStateObserver[0]);
            snapshotThreadLocal.set(mutableVector2);
            return mutableVector2;
        }
        return mutableVector;
    }

    public static final DerivedSnapshotState derivedStateOf(SnapshotMutationPolicy snapshotMutationPolicy, Function0 function0) {
        SnapshotThreadLocal<Integer> snapshotThreadLocal = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
        return new DerivedSnapshotState(snapshotMutationPolicy, function0);
    }

    public static final SnapshotStateList mutableStateListOf(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        SnapshotStateList snapshotStateList = new SnapshotStateList();
        snapshotStateList.addAll(ArraysKt___ArraysKt.toList(elements));
        return snapshotStateList;
    }

    public static final ParcelableSnapshotMutableState mutableStateOf(Object obj, SnapshotMutationPolicy policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        int r0 = ActualAndroid_androidKt.$r8$clinit;
        return new ParcelableSnapshotMutableState(obj, policy);
    }

    public static /* synthetic */ ParcelableSnapshotMutableState mutableStateOf$default(Object obj) {
        return mutableStateOf(obj, StructuralEqualityPolicy.INSTANCE);
    }

    public static final MutableState rememberUpdatedState(Object obj, Composer composer) {
        composer.startReplaceableGroup(-1058319986);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.Empty) {
            rememberedValue = mutableStateOf$default(obj);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        mutableState.setValue(obj);
        composer.endReplaceableGroup();
        return mutableState;
    }

    public static final SafeFlow snapshotFlow(Function0 function0) {
        return new SafeFlow(new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(function0, null));
    }

    public static final DerivedSnapshotState derivedStateOf(Function0 calculation) {
        SnapshotThreadLocal<Integer> snapshotThreadLocal = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        return new DerivedSnapshotState(null, calculation);
    }

    public static final MutableState collectAsState(StateFlow stateFlow, Composer composer) {
        Intrinsics.checkNotNullParameter(stateFlow, "<this>");
        composer.startReplaceableGroup(-1439883919);
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        MutableState collectAsState = collectAsState(stateFlow, stateFlow.getValue(), emptyCoroutineContext, composer, 0);
        composer.endReplaceableGroup();
        return collectAsState;
    }
}
