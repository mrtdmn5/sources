package com.animaconnected.secondo.screens.campaigns;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CampaignFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.campaigns.CampaignFragment$onCreateView$1$1$1", f = "CampaignFragment.kt", l = {58}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CampaignFragment$onCreateView$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CampaignFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CampaignFragment$onCreateView$1$1$1(CampaignFragment campaignFragment, Continuation<? super CampaignFragment$onCreateView$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = campaignFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CampaignFragment$onCreateView$1$1$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object openWebsite;
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
            CampaignFragment campaignFragment = this.this$0;
            this.label = 1;
            openWebsite = campaignFragment.openWebsite(this);
            if (openWebsite == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CampaignFragment$onCreateView$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
