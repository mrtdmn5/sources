package com.animaconnected.secondo.screens.workout.utils;

import androidx.lifecycle.FlowExtKt$flowWithLifecycle$1;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.watch.CommonFlow;
import com.google.common.collect.Hashing;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: BaseFragmentUtils.kt */
/* loaded from: classes3.dex */
public final class BaseFragmentUtilsKt {
    public static final <T> void collectSafely(BaseFragment baseFragment, CommonFlow<T> flow, Function1<? super Throwable, Unit> onError, Function1<? super Flow<? extends T>, ? extends Flow<? extends T>> flowArgs, CoroutineScope scope, Function1<? super T, Unit> onEach) {
        Intrinsics.checkNotNullParameter(baseFragment, "<this>");
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(flowArgs, "flowArgs");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onEach, "onEach");
        FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new BaseFragmentUtilsKt$collectSafely$3(onEach, null), flowArgs.invoke(flow)), new BaseFragmentUtilsKt$collectSafely$4(onError, null)), scope);
    }

    public static /* synthetic */ void collectSafely$default(final BaseFragment baseFragment, CommonFlow commonFlow, Function1 function1, Function1 function12, CoroutineScope coroutineScope, Function1 function13, int r12, Object obj) {
        if ((r12 & 2) != 0) {
            function1 = new Function1<Throwable, Unit>() { // from class: com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt$collectSafely$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable throwable) {
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    String name = BaseFragment.this.getName();
                    if (name == null) {
                        name = "";
                    }
                    LogKt.debug$default((Object) BaseFragment.this, "Exception from flow collect, maybe watch was just closed?", name, throwable, false, 8, (Object) null);
                }
            };
        }
        Function1 function14 = function1;
        if ((r12 & 4) != 0) {
            function12 = new Function1() { // from class: com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt$collectSafely$2
                @Override // kotlin.jvm.functions.Function1
                public final Flow invoke(Flow it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it;
                }
            };
        }
        Function1 function15 = function12;
        if ((r12 & 8) != 0) {
            coroutineScope = Hashing.getLifecycleScope(baseFragment);
        }
        collectSafely(baseFragment, commonFlow, function14, function15, coroutineScope, function13);
    }

    public static final <T> void collectSafelyOnStarted(final BaseFragment baseFragment, CommonFlow<T> flow, Function1<? super T, Unit> onEach) {
        Intrinsics.checkNotNullParameter(baseFragment, "<this>");
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(onEach, "onEach");
        collectSafely$default(baseFragment, flow, null, new Function1<Flow<? extends T>, Flow<? extends T>>() { // from class: com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt$collectSafelyOnStarted$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Flow<T> invoke(Flow<? extends T> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Lifecycle lifecycle = BaseFragment.this.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
                Lifecycle.State minActiveState = Lifecycle.State.STARTED;
                Intrinsics.checkNotNullParameter(minActiveState, "minActiveState");
                return FlowKt.callbackFlow(new FlowExtKt$flowWithLifecycle$1(lifecycle, minActiveState, it, null));
            }
        }, null, onEach, 10, null);
    }

    public static final Job launchOnStarted(LifecycleOwner lifecycleOwner, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return BuildersKt.launch$default(Hashing.getLifecycleScope(lifecycleOwner), null, null, new BaseFragmentUtilsKt$launchOnStarted$1(lifecycleOwner, block, null), 3);
    }
}
