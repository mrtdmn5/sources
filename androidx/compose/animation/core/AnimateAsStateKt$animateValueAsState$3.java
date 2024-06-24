package androidx.compose.animation.core;

import androidx.compose.runtime.State;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;

/* compiled from: AnimateAsState.kt */
@DebugMetadata(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3", f = "AnimateAsState.kt", l = {419}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AnimateAsStateKt$animateValueAsState$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ State<AnimationSpec<Object>> $animSpec$delegate;
    public final /* synthetic */ Animatable<Object, Object> $animatable;
    public final /* synthetic */ Channel<Object> $channel;
    public final /* synthetic */ State<Function1<Object, Unit>> $listener$delegate;
    public /* synthetic */ Object L$0;
    public ChannelIterator L$1;
    public int label;

    /* compiled from: AnimateAsState.kt */
    @DebugMetadata(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1", f = "AnimateAsState.kt", l = {428}, m = "invokeSuspend")
    /* renamed from: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ State<AnimationSpec<Object>> $animSpec$delegate;
        public final /* synthetic */ Animatable<Object, Object> $animatable;
        public final /* synthetic */ State<Function1<Object, Unit>> $listener$delegate;
        public final /* synthetic */ Object $newTarget;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Object obj, Animatable<Object, Object> animatable, State<? extends AnimationSpec<Object>> state, State<? extends Function1<Object, Unit>> state2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$newTarget = obj;
            this.$animatable = animatable;
            this.$animSpec$delegate = state;
            this.$listener$delegate = state2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$newTarget, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            Animatable<Object, Object> animatable = this.$animatable;
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (!Intrinsics.areEqual(this.$newTarget, animatable.targetValue$delegate.getValue())) {
                    Animatable<Object, Object> animatable2 = this.$animatable;
                    Object obj2 = this.$newTarget;
                    SpringSpec<Float> springSpec = AnimateAsStateKt.defaultAnimation;
                    AnimationSpec<Object> value = this.$animSpec$delegate.getValue();
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable2, obj2, value, null, this, 12) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return Unit.INSTANCE;
            }
            SpringSpec<Float> springSpec2 = AnimateAsStateKt.defaultAnimation;
            Function1<Object, Unit> value2 = this.$listener$delegate.getValue();
            if (value2 != null) {
                value2.invoke(animatable.getValue());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AnimateAsStateKt$animateValueAsState$3(Channel<Object> channel, Animatable<Object, Object> animatable, State<? extends AnimationSpec<Object>> state, State<? extends Function1<Object, Unit>> state2, Continuation<? super AnimateAsStateKt$animateValueAsState$3> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$animatable = animatable;
        this.$animSpec$delegate = state;
        this.$listener$delegate = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnimateAsStateKt$animateValueAsState$3 animateAsStateKt$animateValueAsState$3 = new AnimateAsStateKt$animateValueAsState$3(this.$channel, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, continuation);
        animateAsStateKt$animateValueAsState$3.L$0 = obj;
        return animateAsStateKt$animateValueAsState$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnimateAsStateKt$animateValueAsState$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0048  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003d -> B:5:0x0040). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L20
            if (r2 != r3) goto L18
            kotlinx.coroutines.channels.ChannelIterator r2 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r18)
            r6 = r18
            r5 = r0
            goto L40
        L18:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L20:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlinx.coroutines.channels.Channel<java.lang.Object> r4 = r0.$channel
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
            r5 = r0
            r16 = r4
            r4 = r2
            r2 = r16
        L33:
            r5.L$0 = r4
            r5.L$1 = r2
            r5.label = r3
            java.lang.Object r6 = r2.hasNext(r5)
            if (r6 != r1) goto L40
            return r1
        L40:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L70
            java.lang.Object r6 = r2.next()
            kotlinx.coroutines.channels.Channel<java.lang.Object> r7 = r5.$channel
            java.lang.Object r7 = r7.mo1700tryReceivePtdJZtk()
            boolean r8 = r7 instanceof kotlinx.coroutines.channels.ChannelResult.Failed
            r9 = 0
            if (r8 != 0) goto L58
            goto L59
        L58:
            r7 = r9
        L59:
            if (r7 != 0) goto L5d
            r11 = r6
            goto L5e
        L5d:
            r11 = r7
        L5e:
            androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1 r6 = new androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1
            androidx.compose.animation.core.Animatable<java.lang.Object, java.lang.Object> r12 = r5.$animatable
            androidx.compose.runtime.State<androidx.compose.animation.core.AnimationSpec<java.lang.Object>> r13 = r5.$animSpec$delegate
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>> r14 = r5.$listener$delegate
            r15 = 0
            r10 = r6
            r10.<init>(r11, r12, r13, r14, r15)
            r7 = 3
            kotlinx.coroutines.BuildersKt.launch$default(r4, r9, r9, r6, r7)
            goto L33
        L70:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
