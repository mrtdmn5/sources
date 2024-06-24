package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.screens.debugsettings.MsgPackFragment;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: MsgPackFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$CommandList$1$1$1$1", f = "MsgPackFragment.kt", l = {R.styleable.AppTheme_stepsHistoryHintRoundnessDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MsgPackFragment$CommandList$1$1$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MsgPackFragment.Command $command;
    final /* synthetic */ Function1<MsgPackFragment.Command, Unit> $onCommandClicked;
    final /* synthetic */ Function1<MsgPackFragment.Command, Unit> $onCommandLongPress;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MsgPackFragment$CommandList$1$1$1$1(Function1<? super MsgPackFragment.Command, Unit> function1, MsgPackFragment.Command command, Function1<? super MsgPackFragment.Command, Unit> function12, Continuation<? super MsgPackFragment$CommandList$1$1$1$1> continuation) {
        super(2, continuation);
        this.$onCommandLongPress = function1;
        this.$command = command;
        this.$onCommandClicked = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MsgPackFragment$CommandList$1$1$1$1 msgPackFragment$CommandList$1$1$1$1 = new MsgPackFragment$CommandList$1$1$1$1(this.$onCommandLongPress, this.$command, this.$onCommandClicked, continuation);
        msgPackFragment$CommandList$1$1$1$1.L$0 = obj;
        return msgPackFragment$CommandList$1$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((MsgPackFragment$CommandList$1$1$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

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
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            final Function1<MsgPackFragment.Command, Unit> function1 = this.$onCommandLongPress;
            final MsgPackFragment.Command command = this.$command;
            Function1<Offset, Unit> function12 = new Function1<Offset, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$CommandList$1$1$1$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(Offset offset) {
                    m903invokek4lQ0M(offset.packedValue);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m903invokek4lQ0M(long j) {
                    function1.invoke(command);
                }
            };
            final Function1<MsgPackFragment.Command, Unit> function13 = this.$onCommandClicked;
            final MsgPackFragment.Command command2 = this.$command;
            Function1<Offset, Unit> function14 = new Function1<Offset, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$CommandList$1$1$1$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(Offset offset) {
                    m904invokek4lQ0M(offset.packedValue);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m904invokek4lQ0M(long j) {
                    function13.invoke(command2);
                }
            };
            this.label = 1;
            if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, function12, null, function14, this, 5) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
