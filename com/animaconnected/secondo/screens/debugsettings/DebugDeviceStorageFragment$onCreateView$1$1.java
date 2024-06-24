package com.animaconnected.secondo.screens.debugsettings;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.device.WatchIO;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: DebugDeviceStorageFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$onCreateView$1$1", f = "DebugDeviceStorageFragment.kt", l = {53, 54}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugDeviceStorageFragment$onCreateView$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DebugDeviceStorageFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugDeviceStorageFragment$onCreateView$1$1(DebugDeviceStorageFragment debugDeviceStorageFragment, Continuation<? super DebugDeviceStorageFragment$onCreateView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = debugDeviceStorageFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugDeviceStorageFragment$onCreateView$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugDeviceStorageFragment$onCreateView$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DisplayWatch displayWatch;
        Object updateList;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
        } catch (Exception e) {
            ViewKt.toast$default((Fragment) this.this$0, e.toString(), false, 2, (Object) null);
        }
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            displayWatch = this.this$0.watch;
            WatchIO io2 = displayWatch.getIo();
            if (io2 != null) {
                this.label = 1;
                if (io2.writeFormat(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        DebugDeviceStorageFragment debugDeviceStorageFragment = this.this$0;
        this.label = 2;
        updateList = debugDeviceStorageFragment.updateList(this);
        if (updateList == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }
}
