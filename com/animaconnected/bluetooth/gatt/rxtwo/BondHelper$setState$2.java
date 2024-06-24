package com.animaconnected.bluetooth.gatt.rxtwo;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.animaconnected.bluetooth.gatt.rxtwo.BondHelper;
import com.animaconnected.logger.LogKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BondHelper.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.BondHelper$setState$2", f = "BondHelper.kt", l = {96}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BondHelper$setState$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BondHelper.Result>, Object> {
    final /* synthetic */ Function0<Boolean> $action;
    final /* synthetic */ int $bondState;
    final /* synthetic */ Ref$ObjectRef<BroadcastReceiver> $receiver;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ BondHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BondHelper$setState$2(Function0<Boolean> function0, BondHelper bondHelper, Ref$ObjectRef<BroadcastReceiver> ref$ObjectRef, int r4, Continuation<? super BondHelper$setState$2> continuation) {
        super(2, continuation);
        this.$action = function0;
        this.this$0 = bondHelper;
        this.$receiver = ref$ObjectRef;
        this.$bondState = r4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BondHelper$setState$2 bondHelper$setState$2 = new BondHelper$setState$2(this.$action, this.this$0, this.$receiver, this.$bondState, continuation);
        bondHelper$setState$2.L$0 = obj;
        return bondHelper$setState$2;
    }

    /* JADX WARN: Type inference failed for: r12v6, types: [T, com.animaconnected.bluetooth.gatt.rxtwo.BondHelper$setState$2$1$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Function0<Boolean> function0 = this.$action;
            BondHelper bondHelper = this.this$0;
            Ref$ObjectRef<BroadcastReceiver> ref$ObjectRef = this.$receiver;
            int r5 = this.$bondState;
            this.L$0 = coroutineScope;
            this.L$1 = function0;
            this.L$2 = bondHelper;
            this.L$3 = ref$ObjectRef;
            this.I$0 = r5;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(this));
            cancellableContinuationImpl.initCancellability();
            if (!function0.invoke().booleanValue()) {
                LogKt.debug$default((Object) coroutineScope, "Failed to execute action", bondHelper.getTAG(), (Throwable) null, true, 4, (Object) null);
                cancellableContinuationImpl.resumeWith(BondHelper.Result.Failed);
            } else {
                ref$ObjectRef.element = new BondHelper$setState$2$1$1(bondHelper, r5, cancellableContinuationImpl);
                bondHelper.getContext().registerReceiver(ref$ObjectRef.element, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
            }
            obj = cancellableContinuationImpl.getResult();
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }

    /* JADX WARN: Type inference failed for: r9v6, types: [T, com.animaconnected.bluetooth.gatt.rxtwo.BondHelper$setState$2$1$1] */
    public final Object invokeSuspend$$forInline(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Function0<Boolean> function0 = this.$action;
        BondHelper bondHelper = this.this$0;
        Ref$ObjectRef<BroadcastReceiver> ref$ObjectRef = this.$receiver;
        int r3 = this.$bondState;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(this));
        cancellableContinuationImpl.initCancellability();
        if (!function0.invoke().booleanValue()) {
            LogKt.debug$default((Object) coroutineScope, "Failed to execute action", bondHelper.getTAG(), (Throwable) null, true, 4, (Object) null);
            cancellableContinuationImpl.resumeWith(BondHelper.Result.Failed);
            Unit unit = Unit.INSTANCE;
        } else {
            ref$ObjectRef.element = new BondHelper$setState$2$1$1(bondHelper, r3, cancellableContinuationImpl);
            bondHelper.getContext().registerReceiver(ref$ObjectRef.element, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
        }
        Unit unit2 = Unit.INSTANCE;
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BondHelper.Result> continuation) {
        return ((BondHelper$setState$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
