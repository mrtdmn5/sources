package com.animaconnected.secondo.utils.customersupport;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CustomerSupportTicketUtils.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.customersupport.CustomerSupportTicketUtils", f = "CustomerSupportTicketUtils.kt", l = {54}, m = "createTicket")
/* loaded from: classes3.dex */
public final class CustomerSupportTicketUtils$createTicket$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CustomerSupportTicketUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerSupportTicketUtils$createTicket$1(CustomerSupportTicketUtils customerSupportTicketUtils, Continuation<? super CustomerSupportTicketUtils$createTicket$1> continuation) {
        super(continuation);
        this.this$0 = customerSupportTicketUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createTicket(null, null, null, null, null, null, this);
    }
}
