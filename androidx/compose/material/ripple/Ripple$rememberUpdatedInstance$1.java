package androidx.compose.material.ripple;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.DragInteraction$Stop;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Cancel;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.foundation.interaction.PressInteraction$Release;
import androidx.compose.runtime.State;
import com.animaconnected.secondo.R;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlowImpl;

/* compiled from: Ripple.kt */
@DebugMetadata(c = "androidx.compose.material.ripple.Ripple$rememberUpdatedInstance$1", f = "Ripple.kt", l = {R.styleable.AppTheme_stepsHistoryColumnColorDetail}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class Ripple$rememberUpdatedInstance$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ RippleIndicationInstance $instance;
    public final /* synthetic */ InteractionSource $interactionSource;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ripple$rememberUpdatedInstance$1(InteractionSource interactionSource, RippleIndicationInstance rippleIndicationInstance, Continuation<? super Ripple$rememberUpdatedInstance$1> continuation) {
        super(2, continuation);
        this.$interactionSource = interactionSource;
        this.$instance = rippleIndicationInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Ripple$rememberUpdatedInstance$1 ripple$rememberUpdatedInstance$1 = new Ripple$rememberUpdatedInstance$1(this.$interactionSource, this.$instance, continuation);
        ripple$rememberUpdatedInstance$1.L$0 = obj;
        return ripple$rememberUpdatedInstance$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Ripple$rememberUpdatedInstance$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            SharedFlowImpl interactions = this.$interactionSource.getInteractions();
            final RippleIndicationInstance rippleIndicationInstance = this.$instance;
            FlowCollector<Interaction> flowCollector = new FlowCollector<Interaction>() { // from class: androidx.compose.material.ripple.Ripple$rememberUpdatedInstance$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Interaction interaction, Continuation continuation) {
                    TweenSpec<Float> tweenSpec;
                    float f;
                    TweenSpec<Float> tweenSpec2;
                    Interaction interaction2 = interaction;
                    boolean z = interaction2 instanceof PressInteraction$Press;
                    CoroutineScope scope = coroutineScope;
                    RippleIndicationInstance rippleIndicationInstance2 = RippleIndicationInstance.this;
                    if (z) {
                        rippleIndicationInstance2.addRipple((PressInteraction$Press) interaction2, scope);
                    } else if (interaction2 instanceof PressInteraction$Release) {
                        rippleIndicationInstance2.removeRipple(((PressInteraction$Release) interaction2).press);
                    } else if (interaction2 instanceof PressInteraction$Cancel) {
                        rippleIndicationInstance2.removeRipple(((PressInteraction$Cancel) interaction2).press);
                    } else {
                        rippleIndicationInstance2.getClass();
                        Intrinsics.checkNotNullParameter(interaction2, "interaction");
                        Intrinsics.checkNotNullParameter(scope, "scope");
                        StateLayer stateLayer = rippleIndicationInstance2.stateLayer;
                        stateLayer.getClass();
                        boolean z2 = interaction2 instanceof HoverInteraction$Enter;
                        ArrayList arrayList = stateLayer.interactions;
                        if (z2) {
                            arrayList.add(interaction2);
                        } else if (interaction2 instanceof HoverInteraction$Exit) {
                            arrayList.remove(((HoverInteraction$Exit) interaction2).enter);
                        } else if (interaction2 instanceof FocusInteraction$Focus) {
                            arrayList.add(interaction2);
                        } else if (interaction2 instanceof FocusInteraction$Unfocus) {
                            arrayList.remove(((FocusInteraction$Unfocus) interaction2).focus);
                        } else if (interaction2 instanceof DragInteraction$Start) {
                            arrayList.add(interaction2);
                        } else if (interaction2 instanceof DragInteraction$Stop) {
                            arrayList.remove(((DragInteraction$Stop) interaction2).start);
                        } else if (interaction2 instanceof DragInteraction$Cancel) {
                            arrayList.remove(((DragInteraction$Cancel) interaction2).start);
                        }
                        Interaction interaction3 = (Interaction) CollectionsKt___CollectionsKt.lastOrNull(arrayList);
                        if (!Intrinsics.areEqual(stateLayer.currentInteraction, interaction3)) {
                            if (interaction3 != null) {
                                State<RippleAlpha> state = stateLayer.rippleAlpha;
                                if (z2) {
                                    f = state.getValue().hoveredAlpha;
                                } else if (interaction2 instanceof FocusInteraction$Focus) {
                                    f = state.getValue().focusedAlpha;
                                } else if (interaction2 instanceof DragInteraction$Start) {
                                    f = state.getValue().draggedAlpha;
                                } else {
                                    f = 0.0f;
                                }
                                TweenSpec<Float> tweenSpec3 = RippleKt.DefaultTweenSpec;
                                if (!(interaction3 instanceof HoverInteraction$Enter)) {
                                    if (interaction3 instanceof FocusInteraction$Focus) {
                                        tweenSpec2 = new TweenSpec<>(45, 0, EasingKt.LinearEasing, 2);
                                    } else if (interaction3 instanceof DragInteraction$Start) {
                                        tweenSpec2 = new TweenSpec<>(45, 0, EasingKt.LinearEasing, 2);
                                    }
                                    BuildersKt.launch$default(scope, null, null, new StateLayer$handleInteraction$1(stateLayer, f, tweenSpec2, null), 3);
                                }
                                tweenSpec2 = RippleKt.DefaultTweenSpec;
                                BuildersKt.launch$default(scope, null, null, new StateLayer$handleInteraction$1(stateLayer, f, tweenSpec2, null), 3);
                            } else {
                                Interaction interaction4 = stateLayer.currentInteraction;
                                TweenSpec<Float> tweenSpec4 = RippleKt.DefaultTweenSpec;
                                if (!(interaction4 instanceof HoverInteraction$Enter) && !(interaction4 instanceof FocusInteraction$Focus) && (interaction4 instanceof DragInteraction$Start)) {
                                    tweenSpec = new TweenSpec<>(R.styleable.AppTheme_stepsHistoryHintRoundnessDetail, 0, EasingKt.LinearEasing, 2);
                                } else {
                                    tweenSpec = RippleKt.DefaultTweenSpec;
                                }
                                BuildersKt.launch$default(scope, null, null, new StateLayer$handleInteraction$2(stateLayer, tweenSpec, null), 3);
                            }
                            stateLayer.currentInteraction = interaction3;
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            interactions.getClass();
            if (SharedFlowImpl.collect$suspendImpl(interactions, flowCollector, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
