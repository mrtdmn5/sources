package com.animaconnected.secondo.screens.settings;

import android.view.View;
import android.widget.Button;
import com.animaconnected.secondo.R;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: CustomerSupportTicketFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.CustomerSupportTicketFragment$onCreateView$1$9$1", f = "CustomerSupportTicketFragment.kt", l = {R.styleable.AppTheme_toolbarTitleTextStyle, R.styleable.AppTheme_topPusherDropZoneNotSelected}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CustomerSupportTicketFragment$onCreateView$1$9$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ Button $this_apply;
    Object L$0;
    int label;
    final /* synthetic */ CustomerSupportTicketFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerSupportTicketFragment$onCreateView$1$9$1(CustomerSupportTicketFragment customerSupportTicketFragment, Button button, Continuation<? super CustomerSupportTicketFragment$onCreateView$1$9$1> continuation) {
        super(2, continuation);
        this.this$0 = customerSupportTicketFragment;
        this.$this_apply = button;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomerSupportTicketFragment$onCreateView$1$9$1(this.this$0, this.$this_apply, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((CustomerSupportTicketFragment$onCreateView$1$9$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00d3  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.CustomerSupportTicketFragment$onCreateView$1$9$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
