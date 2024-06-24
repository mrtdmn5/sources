package com.animaconnected.secondo.behaviour.distress;

import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel;
import com.animaconnected.watch.behaviour.distress.DistressInterface;
import com.animaconnected.watch.behaviour.distress.WalkMeHomeState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DistressPlugin.kt */
/* loaded from: classes3.dex */
public final class DistressPlugin$distressInterface$1 implements DistressInterface, DistressModel.OnChangeListener {
    private Function1<? super WalkMeHomeState, Unit> onChangeAction = new Function1<WalkMeHomeState, Unit>() { // from class: com.animaconnected.secondo.behaviour.distress.DistressPlugin$distressInterface$1$onChangeAction$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WalkMeHomeState it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WalkMeHomeState walkMeHomeState) {
            invoke2(walkMeHomeState);
            return Unit.INSTANCE;
        }
    };
    final /* synthetic */ DistressPlugin this$0;

    public DistressPlugin$distressInterface$1(DistressPlugin distressPlugin) {
        this.this$0 = distressPlugin;
    }

    @Override // com.animaconnected.watch.behaviour.distress.DistressInterface
    public void doOnStateChange(Function1<? super WalkMeHomeState, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.onChangeAction = action;
    }

    @Override // com.animaconnected.watch.behaviour.distress.DistressInterface
    public WalkMeHomeState getCurrentState() {
        DistressModel distressModel;
        distressModel = this.this$0.distressModel;
        if (distressModel != null) {
            return distressModel.getState();
        }
        Intrinsics.throwUninitializedPropertyAccessException("distressModel");
        throw null;
    }

    public final Function1<WalkMeHomeState, Unit> getOnChangeAction() {
        return this.onChangeAction;
    }

    @Override // com.animaconnected.secondo.behaviour.distress.model.DistressModel.OnChangeListener
    public void onChanged() {
        DistressModel distressModel;
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.distress.DistressPlugin$distressInterface$1$onChanged$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "DistressInterface onChanged";
            }
        }, 7, (Object) null);
        Function1<? super WalkMeHomeState, Unit> function1 = this.onChangeAction;
        distressModel = this.this$0.distressModel;
        if (distressModel != null) {
            function1.invoke(distressModel.getState());
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("distressModel");
            throw null;
        }
    }

    public final void setOnChangeAction(Function1<? super WalkMeHomeState, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onChangeAction = function1;
    }

    @Override // com.animaconnected.watch.behaviour.distress.DistressInterface
    public void startEmergency() {
        CoroutineScope coroutineScope;
        coroutineScope = this.this$0.scope;
        BuildersKt.launch$default(coroutineScope, null, null, new DistressPlugin$distressInterface$1$startEmergency$1(this.this$0, null), 3);
    }

    @Override // com.animaconnected.watch.behaviour.distress.DistressInterface
    public void startSharingLocation() {
        CoroutineScope coroutineScope;
        coroutineScope = this.this$0.scope;
        BuildersKt.launch$default(coroutineScope, null, null, new DistressPlugin$distressInterface$1$startSharingLocation$1(this.this$0, null), 3);
    }

    @Override // com.animaconnected.watch.behaviour.distress.DistressInterface
    public void stopEmergency() {
        CoroutineScope coroutineScope;
        coroutineScope = this.this$0.scope;
        BuildersKt.launch$default(coroutineScope, null, null, new DistressPlugin$distressInterface$1$stopEmergency$1(this.this$0, null), 3);
    }

    @Override // com.animaconnected.watch.behaviour.distress.DistressInterface
    public void stopSharingLocation() {
        CoroutineScope coroutineScope;
        coroutineScope = this.this$0.scope;
        BuildersKt.launch$default(coroutineScope, null, null, new DistressPlugin$distressInterface$1$stopSharingLocation$1(this.this$0, null), 3);
    }

    @Override // com.animaconnected.secondo.behaviour.distress.model.DistressModel.OnChangeListener
    public void onMissingObserver() {
    }
}
