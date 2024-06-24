package com.animaconnected.secondo.screens.campaigns;

import android.view.View;
import com.animaconnected.secondo.provider.campaign.CampaignProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: CampaignFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.campaigns.CampaignFragment$onCreateView$1$2", f = "CampaignFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CampaignFragment$onCreateView$1$2 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CampaignFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CampaignFragment$onCreateView$1$2(CampaignFragment campaignFragment, Continuation<? super CampaignFragment$onCreateView$1$2> continuation) {
        super(2, continuation);
        this.this$0 = campaignFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CampaignFragment$onCreateView$1$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((CampaignFragment$onCreateView$1$2) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CampaignProvider.INSTANCE.setNotInterested(CampaignProvider.PROMOTION_ID);
            this.this$0.getMainController().goBack();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
