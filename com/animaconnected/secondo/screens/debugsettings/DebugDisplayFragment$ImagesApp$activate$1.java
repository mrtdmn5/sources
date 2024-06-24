package com.animaconnected.secondo.screens.debugsettings;

import com.animaconnected.secondo.R;
import com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DebugDisplayFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$ImagesApp$activate$1", f = "DebugDisplayFragment.kt", l = {180, R.styleable.AppTheme_workoutDetailTintColor, 182, 183, 185, 186}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugDisplayFragment$ImagesApp$activate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DebugDisplayFragment.ImagesApp this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugDisplayFragment$ImagesApp$activate$1(DebugDisplayFragment.ImagesApp imagesApp, Continuation<? super DebugDisplayFragment$ImagesApp$activate$1> continuation) {
        super(2, continuation);
        this.this$0 = imagesApp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DebugDisplayFragment$ImagesApp$activate$1 debugDisplayFragment$ImagesApp$activate$1 = new DebugDisplayFragment$ImagesApp$activate$1(this.this$0, continuation);
        debugDisplayFragment$ImagesApp$activate$1.L$0 = obj;
        return debugDisplayFragment$ImagesApp$activate$1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00d4 -> B:8:0x0058). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$ImagesApp$activate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugDisplayFragment$ImagesApp$activate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
