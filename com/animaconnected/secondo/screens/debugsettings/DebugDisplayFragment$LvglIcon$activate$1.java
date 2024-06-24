package com.animaconnected.secondo.screens.debugsettings;

import com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment;
import com.animaconnected.watch.image.Mitmap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DebugDisplayFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$LvglIcon$activate$1", f = "DebugDisplayFragment.kt", l = {230, 231}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugDisplayFragment$LvglIcon$activate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DebugDisplayFragment.LvglIcon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugDisplayFragment$LvglIcon$activate$1(DebugDisplayFragment.LvglIcon lvglIcon, Continuation<? super DebugDisplayFragment$LvglIcon$activate$1> continuation) {
        super(2, continuation);
        this.this$0 = lvglIcon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugDisplayFragment$LvglIcon$activate$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DebugDisplayFragment.LvglIcon lvglIcon;
        Object invalidate;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lvglIcon = (DebugDisplayFragment.LvglIcon) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            lvglIcon = this.this$0;
            this.L$0 = lvglIcon;
            this.label = 1;
            obj = lvglIcon.getKronabyIconAsMitmap(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        lvglIcon.mitmap = (Mitmap) obj;
        DebugDisplayFragment.LvglIcon lvglIcon2 = this.this$0;
        this.L$0 = null;
        this.label = 2;
        invalidate = lvglIcon2.invalidate(this);
        if (invalidate == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugDisplayFragment$LvglIcon$activate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
