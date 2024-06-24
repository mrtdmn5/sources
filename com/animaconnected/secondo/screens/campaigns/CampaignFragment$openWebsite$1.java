package com.animaconnected.secondo.screens.campaigns;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CampaignFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.campaigns.CampaignFragment", f = "CampaignFragment.kt", l = {76}, m = "openWebsite")
/* loaded from: classes3.dex */
public final class CampaignFragment$openWebsite$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CampaignFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CampaignFragment$openWebsite$1(CampaignFragment campaignFragment, Continuation<? super CampaignFragment$openWebsite$1> continuation) {
        super(continuation);
        this.this$0 = campaignFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object openWebsite;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        openWebsite = this.this$0.openWebsite(this);
        return openWebsite;
    }
}
