package com.animaconnected.secondo.behaviour.ifttt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.DialogMessageKt;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import com.animaconnected.watch.behaviour.types.Ifttt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IftttFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.ifttt.IftttFragment$onCreateView$1$1", f = "IftttFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class IftttFragment$onCreateView$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ IftttFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IftttFragment$onCreateView$1$1(IftttFragment iftttFragment, Continuation<? super IftttFragment$onCreateView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = iftttFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IftttFragment$onCreateView$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((IftttFragment$onCreateView$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ifttt ifttt;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ifttt = this.this$0.ifttt;
            if (ifttt != null) {
                final IftttFragment iftttFragment = this.this$0;
                ifttt.setup(new Function1<String, Unit>() { // from class: com.animaconnected.secondo.behaviour.ifttt.IftttFragment$onCreateView$1$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String str) {
                        if (str != null) {
                            IftttFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        } else {
                            Context requireContext = IftttFragment.this.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                            AccountUtilsKt.showDialogInfo$default(requireContext, DialogMessageKt.getDialogInfo(DialogMessage.NoInternetConnection.INSTANCE), null, 4, null);
                        }
                    }
                });
                return Unit.INSTANCE;
            }
            Intrinsics.throwUninitializedPropertyAccessException("ifttt");
            throw null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
