package com.animaconnected.watch;

import androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda2;
import com.animaconnected.watch.device.Command;
import com.animaconnected.watch.device.WatchIO;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider$readDiagnostics$1", f = "WatchProvider.kt", l = {670}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchProvider$readDiagnostics$1 extends SuspendLambda implements Function1<Continuation<? super Map<String, ? extends String>>, Object> {
    final /* synthetic */ boolean $statusDiagDisabled;
    int label;
    final /* synthetic */ WatchProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$readDiagnostics$1(boolean z, WatchProvider watchProvider, Continuation<? super WatchProvider$readDiagnostics$1> continuation) {
        super(1, continuation);
        this.$statusDiagDisabled = z;
        this.this$0 = watchProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new WatchProvider$readDiagnostics$1(this.$statusDiagDisabled, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Map<String, ? extends String>> continuation) {
        return invoke2((Continuation<? super Map<String, String>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WatchIO io2;
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
            if (!this.$statusDiagDisabled) {
                io2 = this.this$0.getIo();
                Intrinsics.checkNotNull(io2);
                boolean hasDiagnosticPages = this.this$0.getCapabilities().getHasDiagnosticPages();
                this.label = 1;
                obj = io2.readDiagnostics(hasDiagnosticPages, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                return Rgb$$ExternalSyntheticLambda2.m(Command.STATUS_DIAG, "disabled");
            }
        }
        return (Map) obj;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Map<String, String>> continuation) {
        return ((WatchProvider$readDiagnostics$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
