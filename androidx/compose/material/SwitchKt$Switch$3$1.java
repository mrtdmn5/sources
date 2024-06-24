package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import com.google.common.collect.Platform;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SafeFlow;

/* compiled from: Switch.kt */
@DebugMetadata(c = "androidx.compose.material.SwitchKt$Switch$3$1", f = "Switch.kt", l = {126}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SwitchKt$Switch$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ AnchoredDraggableState<Boolean> $anchoredDraggableState;
    public final /* synthetic */ State<Boolean> $currentChecked$delegate;
    public final /* synthetic */ State<Function1<Boolean, Unit>> $currentOnCheckedChange$delegate;
    public final /* synthetic */ MutableState<Boolean> $forceAnimationCheck$delegate;
    public int label;

    /* compiled from: Switch.kt */
    @DebugMetadata(c = "androidx.compose.material.SwitchKt$Switch$3$1$2", f = "Switch.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.compose.material.SwitchKt$Switch$3$1$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        public final /* synthetic */ State<Boolean> $currentChecked$delegate;
        public final /* synthetic */ State<Function1<Boolean, Unit>> $currentOnCheckedChange$delegate;
        public final /* synthetic */ MutableState<Boolean> $forceAnimationCheck$delegate;
        public /* synthetic */ boolean Z$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(State<Boolean> state, State<? extends Function1<? super Boolean, Unit>> state2, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$currentChecked$delegate = state;
            this.$currentOnCheckedChange$delegate = state2;
            this.$forceAnimationCheck$delegate = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$currentChecked$delegate, this.$currentOnCheckedChange$delegate, this.$forceAnimationCheck$delegate, continuation);
            anonymousClass2.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(Boolean.valueOf(bool.booleanValue()), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            ResultKt.throwOnFailure(obj);
            boolean z = this.Z$0;
            float f = SwitchKt.TrackWidth;
            if (this.$currentChecked$delegate.getValue().booleanValue() != z) {
                Function1<Boolean, Unit> value = this.$currentOnCheckedChange$delegate.getValue();
                if (value != null) {
                    value.invoke(Boolean.valueOf(z));
                }
                this.$forceAnimationCheck$delegate.setValue(Boolean.valueOf(!r2.getValue().booleanValue()));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SwitchKt$Switch$3$1(AnchoredDraggableState<Boolean> anchoredDraggableState, State<Boolean> state, State<? extends Function1<? super Boolean, Unit>> state2, MutableState<Boolean> mutableState, Continuation<? super SwitchKt$Switch$3$1> continuation) {
        super(2, continuation);
        this.$anchoredDraggableState = anchoredDraggableState;
        this.$currentChecked$delegate = state;
        this.$currentOnCheckedChange$delegate = state2;
        this.$forceAnimationCheck$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SwitchKt$Switch$3$1(this.$anchoredDraggableState, this.$currentChecked$delegate, this.$currentOnCheckedChange$delegate, this.$forceAnimationCheck$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SwitchKt$Switch$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final AnchoredDraggableState<Boolean> anchoredDraggableState = this.$anchoredDraggableState;
            SafeFlow snapshotFlow = Platform.snapshotFlow(new Function0<Boolean>() { // from class: androidx.compose.material.SwitchKt$Switch$3$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return anchoredDraggableState.getCurrentValue();
                }
            });
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$currentChecked$delegate, this.$currentOnCheckedChange$delegate, this.$forceAnimationCheck$delegate, null);
            this.label = 1;
            if (FlowKt.collectLatest(snapshotFlow, anonymousClass2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
