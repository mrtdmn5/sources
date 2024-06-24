package com.animaconnected.secondo.screens.settings;

import android.view.View;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: CustomerSupportTicketFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.CustomerSupportTicketFragment$onCreateView$1$10", f = "CustomerSupportTicketFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CustomerSupportTicketFragment$onCreateView$1$10 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CustomerSupportTicketFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerSupportTicketFragment$onCreateView$1$10(CustomerSupportTicketFragment customerSupportTicketFragment, Continuation<? super CustomerSupportTicketFragment$onCreateView$1$10> continuation) {
        super(2, continuation);
        this.this$0 = customerSupportTicketFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomerSupportTicketFragment$onCreateView$1$10(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((CustomerSupportTicketFragment$onCreateView$1$10) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getMainController().goBack();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
