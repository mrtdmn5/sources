package com.animaconnected.watch.storage;

import com.animaconnected.watch.GroupLayer;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.storage.models.BehaviourSlot;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchDb.kt */
@DebugMetadata(c = "com.animaconnected.watch.storage.WatchDb$getBehaviourOnSlot$2", f = "WatchDb.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchDb$getBehaviourOnSlot$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BehaviourSlot>, Object> {
    final /* synthetic */ GroupLayer $groupLayer;
    final /* synthetic */ Slot $slot;
    int label;
    final /* synthetic */ WatchDb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchDb$getBehaviourOnSlot$2(WatchDb watchDb, Slot slot, GroupLayer groupLayer, Continuation<? super WatchDb$getBehaviourOnSlot$2> continuation) {
        super(2, continuation);
        this.this$0 = watchDb;
        this.$slot = slot;
        this.$groupLayer = groupLayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchDb$getBehaviourOnSlot$2(this.this$0, this.$slot, this.$groupLayer, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.getDb().getBehaviourSlotQueries().getBehaviourOnSlot(this.$slot.getId(), this.$groupLayer.getId()).executeAsOneOrNull();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BehaviourSlot> continuation) {
        return ((WatchDb$getBehaviourOnSlot$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
