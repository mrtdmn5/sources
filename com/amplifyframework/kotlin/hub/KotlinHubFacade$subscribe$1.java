package com.amplifyframework.kotlin.hub;

import androidx.compose.ui.draw.AlphaKt;
import com.amplifyframework.hub.HubCategoryBehavior;
import com.amplifyframework.hub.HubChannel;
import com.amplifyframework.hub.HubEvent;
import com.amplifyframework.hub.HubEventFilter;
import com.amplifyframework.hub.HubSubscriber;
import com.amplifyframework.hub.SubscriptionToken;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: KotlinHubFacade.kt */
@DebugMetadata(c = "com.amplifyframework.kotlin.hub.KotlinHubFacade$subscribe$1", f = "KotlinHubFacade.kt", l = {38}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class KotlinHubFacade$subscribe$1 extends SuspendLambda implements Function2<ProducerScope<? super HubEvent<?>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ HubChannel $channel;
    final /* synthetic */ HubEventFilter $filter;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KotlinHubFacade this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinHubFacade$subscribe$1(KotlinHubFacade kotlinHubFacade, HubChannel hubChannel, HubEventFilter hubEventFilter, Continuation<? super KotlinHubFacade$subscribe$1> continuation) {
        super(2, continuation);
        this.this$0 = kotlinHubFacade;
        this.$channel = hubChannel;
        this.$filter = hubEventFilter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KotlinHubFacade$subscribe$1 kotlinHubFacade$subscribe$1 = new KotlinHubFacade$subscribe$1(this.this$0, this.$channel, this.$filter, continuation);
        kotlinHubFacade$subscribe$1.L$0 = obj;
        return kotlinHubFacade$subscribe$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HubCategoryBehavior hubCategoryBehavior;
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
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            hubCategoryBehavior = this.this$0.delegate;
            final SubscriptionToken subscribe = hubCategoryBehavior.subscribe(this.$channel, this.$filter, new HubSubscriber() { // from class: com.amplifyframework.kotlin.hub.KotlinHubFacade$subscribe$1$$ExternalSyntheticLambda0
                @Override // com.amplifyframework.hub.HubSubscriber
                public final void onEvent(HubEvent hubEvent) {
                    AlphaKt.trySendBlocking(ProducerScope.this, hubEvent);
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe, "delegate.subscribe(chann…) { trySendBlocking(it) }");
            final KotlinHubFacade kotlinHubFacade = this.this$0;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.amplifyframework.kotlin.hub.KotlinHubFacade$subscribe$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HubCategoryBehavior hubCategoryBehavior2;
                    hubCategoryBehavior2 = KotlinHubFacade.this.delegate;
                    hubCategoryBehavior2.unsubscribe(subscribe);
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super HubEvent<?>> producerScope, Continuation<? super Unit> continuation) {
        return ((KotlinHubFacade$subscribe$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
