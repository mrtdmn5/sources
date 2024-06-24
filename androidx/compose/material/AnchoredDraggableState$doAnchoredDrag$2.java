package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import java.util.Iterator;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: AnchoredDraggable.kt */
@DebugMetadata(c = "androidx.compose.material.AnchoredDraggableState$doAnchoredDrag$2", f = "AnchoredDraggable.kt", l = {441}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AnchoredDraggableState$doAnchoredDrag$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function3<AnchoredDragScope, Map<Object, Float>, Continuation<? super Unit>, Object> $block;
    public final /* synthetic */ MutatePriority $dragPriority;
    public final /* synthetic */ Object $targetValue;
    public int label;
    public final /* synthetic */ AnchoredDraggableState<Object> this$0;

    /* compiled from: AnchoredDraggable.kt */
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableState$doAnchoredDrag$2$1", f = "AnchoredDraggable.kt", l = {443}, m = "invokeSuspend")
    /* renamed from: androidx.compose.material.AnchoredDraggableState$doAnchoredDrag$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function3<AnchoredDragScope, Map<Object, Float>, Continuation<? super Unit>, Object> $block;
        public final /* synthetic */ Object $targetValue;
        public int label;
        public final /* synthetic */ AnchoredDraggableState<Object> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Object obj, AnchoredDraggableState<Object> anchoredDraggableState, Function3<? super AnchoredDragScope, ? super Map<Object, Float>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$targetValue = obj;
            this.this$0 = anchoredDraggableState;
            this.$block = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$targetValue, this.this$0, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
                AnchoredDraggableState<Object> anchoredDraggableState = this.this$0;
                Object obj2 = this.$targetValue;
                if (obj2 != null) {
                    anchoredDraggableState.animationTarget$delegate.setValue(obj2);
                }
                AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = anchoredDraggableState.anchoredDragScope;
                Map<Object, Float> anchors$material_release = anchoredDraggableState.getAnchors$material_release();
                this.label = 1;
                if (this.$block.invoke(anchoredDraggableState$anchoredDragScope$1, anchors$material_release, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AnchoredDraggableState$doAnchoredDrag$2(Object obj, AnchoredDraggableState<Object> anchoredDraggableState, MutatePriority mutatePriority, Function3<? super AnchoredDragScope, ? super Map<Object, Float>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super AnchoredDraggableState$doAnchoredDrag$2> continuation) {
        super(2, continuation);
        this.$targetValue = obj;
        this.this$0 = anchoredDraggableState;
        this.$dragPriority = mutatePriority;
        this.$block = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnchoredDraggableState$doAnchoredDrag$2(this.$targetValue, this.this$0, this.$dragPriority, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnchoredDraggableState$doAnchoredDrag$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        boolean z;
        Object obj3;
        boolean z2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        Object obj4 = this.$targetValue;
        Object obj5 = null;
        AnchoredDraggableState<Object> anchoredDraggableState = this.this$0;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (obj4 != null && !anchoredDraggableState.getAnchors$material_release().containsKey(obj4)) {
                    if (anchoredDraggableState.confirmValueChange.invoke(obj4).booleanValue()) {
                        anchoredDraggableState.currentValue$delegate.setValue(obj4);
                    }
                    return Unit.INSTANCE;
                }
                InternalMutatorMutex internalMutatorMutex = anchoredDraggableState.dragMutex;
                MutatePriority mutatePriority = this.$dragPriority;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(obj4, anchoredDraggableState, this.$block, null);
                this.label = 1;
                internalMutatorMutex.getClass();
                if (CoroutineScopeKt.coroutineScope(new InternalMutatorMutex$mutate$2(mutatePriority, internalMutatorMutex, anonymousClass1, null), this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            if (obj4 != null) {
                anchoredDraggableState.animationTarget$delegate.setValue(null);
            }
            Iterator<T> it = anchoredDraggableState.getAnchors$material_release().entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj3 = it.next();
                    if (Math.abs(((Number) ((Map.Entry) obj3).getValue()).floatValue() - anchoredDraggableState.getOffset()) < 0.5f) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        break;
                    }
                } else {
                    obj3 = null;
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) obj3;
            if (entry != null) {
                obj5 = entry.getKey();
            }
            if (obj5 != null && anchoredDraggableState.confirmValueChange.invoke(obj5).booleanValue()) {
                anchoredDraggableState.currentValue$delegate.setValue(obj5);
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            if (obj4 != null) {
                anchoredDraggableState.animationTarget$delegate.setValue(null);
            }
            Iterator<T> it2 = anchoredDraggableState.getAnchors$material_release().entrySet().iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj2 = it2.next();
                    if (Math.abs(((Number) ((Map.Entry) obj2).getValue()).floatValue() - anchoredDraggableState.getOffset()) < 0.5f) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            Map.Entry entry2 = (Map.Entry) obj2;
            if (entry2 != null) {
                obj5 = entry2.getKey();
            }
            if (obj5 != null && anchoredDraggableState.confirmValueChange.invoke(obj5).booleanValue()) {
                anchoredDraggableState.currentValue$delegate.setValue(obj5);
            }
            throw th;
        }
    }
}
