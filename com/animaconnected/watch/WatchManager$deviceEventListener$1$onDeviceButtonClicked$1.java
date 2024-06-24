package com.animaconnected.watch;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.device.BehaviourListener;
import com.animaconnected.watch.device.Button;
import com.animaconnected.watch.device.ButtonAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchManager.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchManager$deviceEventListener$1$onDeviceButtonClicked$1", f = "WatchManager.kt", l = {117}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchManager$deviceEventListener$1$onDeviceButtonClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ButtonAction $action;
    final /* synthetic */ Button $button;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchManager$deviceEventListener$1$onDeviceButtonClicked$1(WatchManager watchManager, Button button, ButtonAction buttonAction, Continuation<? super WatchManager$deviceEventListener$1$onDeviceButtonClicked$1> continuation) {
        super(2, continuation);
        this.this$0 = watchManager;
        this.$button = button;
        this.$action = buttonAction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchManager$deviceEventListener$1$onDeviceButtonClicked$1 watchManager$deviceEventListener$1$onDeviceButtonClicked$1 = new WatchManager$deviceEventListener$1$onDeviceButtonClicked$1(this.this$0, this.$button, this.$action, continuation);
        watchManager$deviceEventListener$1$onDeviceButtonClicked$1.L$0 = obj;
        return watchManager$deviceEventListener$1$onDeviceButtonClicked$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Slot slot;
        Set set;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                slot = (Slot) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Slot slotFromButtonIndex$watch_release = this.this$0.getBehaviours().getSlotFromButtonIndex$watch_release(this.$button, this.$action);
            LogKt.debug$default((Object) coroutineScope, "Slot triggered: " + slotFromButtonIndex$watch_release + " action: " + this.$action.getReadableName(), (String) null, (Throwable) null, false, 14, (Object) null);
            if (slotFromButtonIndex$watch_release == Slot.Unknown) {
                LogKt.debug$default((Object) coroutineScope, "Got bad button index: " + this.$button, (String) null, (Throwable) null, false, 14, (Object) null);
                return Unit.INSTANCE;
            }
            WatchManager watchManager = this.this$0;
            ButtonAction buttonAction = this.$action;
            this.L$0 = slotFromButtonIndex$watch_release;
            this.label = 1;
            obj = watchManager.handleHybridWatchButton(slotFromButtonIndex$watch_release, buttonAction, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
            slot = slotFromButtonIndex$watch_release;
        }
        Pair pair = (Pair) obj;
        Behaviour behaviour = (Behaviour) pair.first;
        boolean booleanValue = ((Boolean) pair.second).booleanValue();
        set = this.this$0.eventListeners;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : set) {
            if (obj2 instanceof BehaviourListener) {
                arrayList.add(obj2);
            }
        }
        ButtonAction buttonAction2 = this.$action;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((BehaviourListener) it.next()).onButtonClicked(slot, behaviour, buttonAction2, booleanValue);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchManager$deviceEventListener$1$onDeviceButtonClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
