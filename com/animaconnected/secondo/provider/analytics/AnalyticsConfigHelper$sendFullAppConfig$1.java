package com.animaconnected.secondo.provider.analytics;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AnalyticsConfigHelper.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper", f = "AnalyticsConfigHelper.kt", l = {66, 67, 68}, m = "sendFullAppConfig")
/* loaded from: classes3.dex */
public final class AnalyticsConfigHelper$sendFullAppConfig$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AnalyticsConfigHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsConfigHelper$sendFullAppConfig$1(AnalyticsConfigHelper analyticsConfigHelper, Continuation<? super AnalyticsConfigHelper$sendFullAppConfig$1> continuation) {
        super(continuation);
        this.this$0 = analyticsConfigHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object sendFullAppConfig;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        sendFullAppConfig = this.this$0.sendFullAppConfig(this);
        return sendFullAppConfig;
    }
}
