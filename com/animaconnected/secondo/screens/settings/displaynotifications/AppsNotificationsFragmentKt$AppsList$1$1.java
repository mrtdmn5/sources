package com.animaconnected.secondo.screens.settings.displaynotifications;

import androidx.compose.foundation.lazy.LazyListAnimateScrollScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2;
import androidx.compose.runtime.saveable.SaverKt$Saver$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;

/* compiled from: AppsNotificationsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$1$1", f = "AppsNotificationsFragment.kt", l = {243, 244}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AppsNotificationsFragmentKt$AppsList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $lazyListState;
    int label;

    /* compiled from: AppsNotificationsFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$1$1$1", f = "AppsNotificationsFragment.kt", l = {243}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$1$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(100L, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppsNotificationsFragmentKt$AppsList$1$1(LazyListState lazyListState, Continuation<? super AppsNotificationsFragmentKt$AppsList$1$1> continuation) {
        super(2, continuation);
        this.$lazyListState = lazyListState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppsNotificationsFragmentKt$AppsList$1$1(this.$lazyListState, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            DefaultIoScheduler defaultIoScheduler = Dispatchers.IO;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            if (BuildersKt.withContext(defaultIoScheduler, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        LazyListState lazyListState = this.$lazyListState;
        this.label = 2;
        SaverKt$Saver$1 saverKt$Saver$1 = LazyListState.Saver;
        lazyListState.getClass();
        float f = LazyAnimateScrollKt.TargetDistance;
        LazyListAnimateScrollScope lazyListAnimateScrollScope = lazyListState.animateScrollScope;
        Object scroll = lazyListAnimateScrollScope.scroll(new LazyAnimateScrollKt$animateScrollToItem$2(0, 0, lazyListAnimateScrollScope, null), this);
        if (scroll != coroutineSingletons) {
            scroll = Unit.INSTANCE;
        }
        if (scroll != coroutineSingletons) {
            scroll = Unit.INSTANCE;
        }
        if (scroll == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppsNotificationsFragmentKt$AppsList$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
