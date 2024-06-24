package com.animaconnected.bluetooth.gatt.rxtwo;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.animaconnected.bluetooth.gatt.rxtwo.BondHelper;
import com.animaconnected.bluetooth.util.Bonding;
import com.animaconnected.logger.LogKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BondHelper.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.BondHelper$bond$$inlined$setState$1", f = "BondHelper.kt", l = {96}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BondHelper$bond$$inlined$setState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BondHelper.Result>, Object> {
    final /* synthetic */ int $bondState;
    final /* synthetic */ Ref$ObjectRef $receiver;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ BondHelper this$0;
    final /* synthetic */ BondHelper this$0$inline_fun;

    /* compiled from: BondHelper.kt */
    /* renamed from: com.animaconnected.bluetooth.gatt.rxtwo.BondHelper$bond$$inlined$setState$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ int $bondState;
        final /* synthetic */ CancellableContinuation $continuation;
        final /* synthetic */ BondHelper this$0;

        public AnonymousClass1(BondHelper bondHelper, int r2, CancellableContinuation cancellableContinuation) {
            this.this$0 = bondHelper;
            this.$bondState = r2;
            this.$continuation = cancellableContinuation;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context1, Intent intent) {
            BondHelper.Result result;
            Intrinsics.checkNotNullParameter(context1, "context1");
            Intrinsics.checkNotNullParameter(intent, "intent");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice == null || !Intrinsics.areEqual(bluetoothDevice, this.this$0.getBluetoothDevice())) {
                return;
            }
            int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
            if (intExtra == 10 || intExtra == 12) {
                if (intExtra == this.$bondState) {
                    result = BondHelper.Result.Success;
                } else {
                    result = BondHelper.Result.Failed;
                }
                LogKt.debug$default((Object) this, "Reached state: " + result, this.this$0.getTAG(), (Throwable) null, true, 4, (Object) null);
                this.$continuation.resumeWith(result);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BondHelper$bond$$inlined$setState$1(BondHelper bondHelper, Ref$ObjectRef ref$ObjectRef, int r3, Continuation continuation, BondHelper bondHelper2) {
        super(2, continuation);
        this.this$0$inline_fun = bondHelper;
        this.$receiver = ref$ObjectRef;
        this.$bondState = r3;
        this.this$0 = bondHelper2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BondHelper$bond$$inlined$setState$1 bondHelper$bond$$inlined$setState$1 = new BondHelper$bond$$inlined$setState$1(this.this$0$inline_fun, this.$receiver, this.$bondState, continuation, this.this$0);
        bondHelper$bond$$inlined$setState$1.L$0 = obj;
        return bondHelper$bond$$inlined$setState$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, com.animaconnected.bluetooth.gatt.rxtwo.BondHelper$bond$$inlined$setState$1$1] */
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
            BondHelper bondHelper = this.this$0$inline_fun;
            Ref$ObjectRef ref$ObjectRef = this.$receiver;
            int r4 = this.$bondState;
            this.L$0 = coroutineScope;
            this.L$1 = bondHelper;
            this.L$2 = ref$ObjectRef;
            this.I$0 = r4;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(this));
            cancellableContinuationImpl.initCancellability();
            if (!Bonding.getInstance().createBondToDevice(this.this$0.getBluetoothDevice())) {
                LogKt.debug$default((Object) coroutineScope, "Failed to execute action", bondHelper.getTAG(), (Throwable) null, true, 4, (Object) null);
                cancellableContinuationImpl.resumeWith(BondHelper.Result.Failed);
            } else {
                ref$ObjectRef.element = new AnonymousClass1(bondHelper, r4, cancellableContinuationImpl);
                bondHelper.getContext().registerReceiver((BroadcastReceiver) ref$ObjectRef.element, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
            }
            obj = cancellableContinuationImpl.getResult();
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.animaconnected.bluetooth.gatt.rxtwo.BondHelper$bond$$inlined$setState$1$1] */
    public final Object invokeSuspend$$forInline(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        BondHelper bondHelper = this.this$0$inline_fun;
        Ref$ObjectRef ref$ObjectRef = this.$receiver;
        int r2 = this.$bondState;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(this));
        cancellableContinuationImpl.initCancellability();
        if (!Bonding.getInstance().createBondToDevice(this.this$0.getBluetoothDevice())) {
            LogKt.debug$default((Object) coroutineScope, "Failed to execute action", bondHelper.getTAG(), (Throwable) null, true, 4, (Object) null);
            cancellableContinuationImpl.resumeWith(BondHelper.Result.Failed);
        } else {
            ref$ObjectRef.element = new AnonymousClass1(bondHelper, r2, cancellableContinuationImpl);
            bondHelper.getContext().registerReceiver((BroadcastReceiver) ref$ObjectRef.element, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
        }
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BondHelper.Result> continuation) {
        return ((BondHelper$bond$$inlined$setState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
