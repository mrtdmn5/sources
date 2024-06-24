package com.animaconnected.secondo.screens.onboarding;

import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.productinfo.ProductInfoProvider;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Onboarding.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.Onboarding$updateProductInfo$1", f = "Onboarding.kt", l = {672}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Onboarding$updateProductInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Onboarding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Onboarding$updateProductInfo$1(Onboarding onboarding, Continuation<? super Onboarding$updateProductInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = onboarding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Onboarding$updateProductInfo$1 onboarding$updateProductInfo$1 = new Onboarding$updateProductInfo$1(this.this$0, continuation);
        onboarding$updateProductInfo$1.L$0 = obj;
        return onboarding$updateProductInfo$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        String str;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope = coroutineScope2;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            ProductInfoProvider productInfoProvider = ProductInfoProvider.INSTANCE;
            this.L$0 = coroutineScope3;
            this.label = 1;
            if (productInfoProvider.updateProductInfo(false, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            coroutineScope = coroutineScope3;
        }
        str = Onboarding.TAG;
        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
        LogKt.debug$default((Object) coroutineScope, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$updateProductInfo$1.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "updateProductInfo done.";
            }
        }, 6, (Object) null);
        Onboarding onboarding = this.this$0;
        Onboarding.State state = Onboarding.State.WAITING_PRODUCT_INFO;
        Onboarding.setHandled$default(onboarding, state, false, 2, null);
        if (this.this$0.getState() == state) {
            this.this$0.updateState();
        }
        this.this$0.updateProductInfoStarted = false;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Onboarding$updateProductInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
