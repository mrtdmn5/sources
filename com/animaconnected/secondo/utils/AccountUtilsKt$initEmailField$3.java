package com.animaconnected.secondo.utils;

import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.screens.settings.FormUiState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: AccountUtils.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.AccountUtilsKt$initEmailField$3", f = "AccountUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AccountUtilsKt$initEmailField$3 extends SuspendLambda implements Function3<FlowCollector<? super FormUiState>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public AccountUtilsKt$initEmailField$3(Continuation<? super AccountUtilsKt$initEmailField$3> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LogKt.debug$default(this.L$0, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.AccountUtilsKt$initEmailField$3.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Something went wrong";
                }
            }, 7, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super FormUiState> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        AccountUtilsKt$initEmailField$3 accountUtilsKt$initEmailField$3 = new AccountUtilsKt$initEmailField$3(continuation);
        accountUtilsKt$initEmailField$3.L$0 = flowCollector;
        return accountUtilsKt$initEmailField$3.invokeSuspend(Unit.INSTANCE);
    }
}
