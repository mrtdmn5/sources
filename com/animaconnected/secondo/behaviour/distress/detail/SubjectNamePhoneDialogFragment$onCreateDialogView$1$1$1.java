package com.animaconnected.secondo.behaviour.distress.detail;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SubjectNamePhoneDialogFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.detail.SubjectNamePhoneDialogFragment$onCreateDialogView$1$1$1", f = "SubjectNamePhoneDialogFragment.kt", l = {27}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SubjectNamePhoneDialogFragment$onCreateDialogView$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SubjectNamePhoneDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectNamePhoneDialogFragment$onCreateDialogView$1$1$1(SubjectNamePhoneDialogFragment subjectNamePhoneDialogFragment, Continuation<? super SubjectNamePhoneDialogFragment$onCreateDialogView$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = subjectNamePhoneDialogFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectNamePhoneDialogFragment$onCreateDialogView$1$1$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DistressPresenter distressPresenter;
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
            distressPresenter = this.this$0.distressPresenter;
            if (distressPresenter != null) {
                this.label = 1;
                obj = distressPresenter.requestInvitation(this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("distressPresenter");
                throw null;
            }
        }
        if (((Boolean) obj).booleanValue()) {
            this.this$0.dismissed = true;
            this.this$0.dismiss();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SubjectNamePhoneDialogFragment$onCreateDialogView$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
