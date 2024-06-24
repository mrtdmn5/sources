package com.animaconnected.secondo.screens.debugsettings;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.content.FileProvider;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: DebugCSEMLogsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugCSEMLogsFragment$onCreateView$1$4", f = "DebugCSEMLogsFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugCSEMLogsFragment$onCreateView$1$4 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DebugCSEMLogsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugCSEMLogsFragment$onCreateView$1$4(DebugCSEMLogsFragment debugCSEMLogsFragment, Continuation<? super DebugCSEMLogsFragment$onCreateView$1$4> continuation) {
        super(2, continuation);
        this.this$0 = debugCSEMLogsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugCSEMLogsFragment$onCreateView$1$4(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugCSEMLogsFragment$onCreateView$1$4) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            File zip = CSEMLogsFileSaver.INSTANCE.zip();
            if (zip == null) {
                return Unit.INSTANCE;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            DebugCSEMLogsFragment debugCSEMLogsFragment = this.this$0;
            intent.setType(DfuBaseService.MIME_TYPE_ZIP);
            intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(debugCSEMLogsFragment.requireContext(), zip));
            Context context = this.this$0.getContext();
            if (context != null) {
                context.startActivity(Intent.createChooser(intent, "Share CSEMLogs"));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
