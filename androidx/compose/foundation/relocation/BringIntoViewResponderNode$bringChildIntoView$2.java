package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import com.animaconnected.secondo.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: BringIntoViewResponder.kt */
@DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringChildIntoView$2", f = "BringIntoViewResponder.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BringIntoViewResponderNode$bringChildIntoView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    public final /* synthetic */ Function0<Rect> $boundsProvider;
    public final /* synthetic */ LayoutCoordinates $childCoordinates;
    public final /* synthetic */ Function0<Rect> $parentRect;
    public /* synthetic */ Object L$0;
    public final /* synthetic */ BringIntoViewResponderNode this$0;

    /* compiled from: BringIntoViewResponder.kt */
    @DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringChildIntoView$2$1", f = "BringIntoViewResponder.kt", l = {170}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringChildIntoView$2$1 */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function0<Rect> $boundsProvider;
        public final /* synthetic */ LayoutCoordinates $childCoordinates;
        public int label;
        public final /* synthetic */ BringIntoViewResponderNode this$0;

        /* compiled from: BringIntoViewResponder.kt */
        /* renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringChildIntoView$2$1$1 */
        /* loaded from: classes.dex */
        public /* synthetic */ class C00111 extends FunctionReferenceImpl implements Function0<Rect> {
            public final /* synthetic */ Function0<Rect> $boundsProvider;
            public final /* synthetic */ LayoutCoordinates $childCoordinates;
            public final /* synthetic */ BringIntoViewResponderNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00111(BringIntoViewResponderNode bringIntoViewResponderNode, LayoutCoordinates layoutCoordinates, Function0<Rect> function0) {
                super(0, Intrinsics.Kotlin.class, "localRect", "bringChildIntoView$localRect(Landroidx/compose/foundation/relocation/BringIntoViewResponderNode;Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/geometry/Rect;", 0);
                this.this$0 = bringIntoViewResponderNode;
                this.$childCoordinates = layoutCoordinates;
                this.$boundsProvider = function0;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Rect invoke() {
                return BringIntoViewResponderNode.access$bringChildIntoView$localRect(this.this$0, this.$childCoordinates, this.$boundsProvider);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BringIntoViewResponderNode bringIntoViewResponderNode, LayoutCoordinates layoutCoordinates, Function0<Rect> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = bringIntoViewResponderNode;
            this.$childCoordinates = layoutCoordinates;
            this.$boundsProvider = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$childCoordinates, this.$boundsProvider, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                BringIntoViewResponderNode bringIntoViewResponderNode = this.this$0;
                BringIntoViewResponder bringIntoViewResponder = bringIntoViewResponderNode.responder;
                C00111 c00111 = new C00111(bringIntoViewResponderNode, this.$childCoordinates, this.$boundsProvider);
                this.label = 1;
                if (bringIntoViewResponder.bringChildIntoView(c00111, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: BringIntoViewResponder.kt */
    @DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringChildIntoView$2$2", f = "BringIntoViewResponder.kt", l = {R.styleable.AppTheme_workoutDetailColorBackground}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringChildIntoView$2$2 */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function0<Rect> $parentRect;
        public int label;
        public final /* synthetic */ BringIntoViewResponderNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(BringIntoViewResponderNode bringIntoViewResponderNode, Function0<Rect> function0, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = bringIntoViewResponderNode;
            this.$parentRect = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$parentRect, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                BringIntoViewResponderNode bringIntoViewResponderNode = this.this$0;
                bringIntoViewResponderNode.getClass();
                BringIntoViewParent bringIntoViewParent = (BringIntoViewParent) bringIntoViewResponderNode.getCurrent(BringIntoViewKt.ModifierLocalBringIntoViewParent);
                if (bringIntoViewParent == null) {
                    bringIntoViewParent = bringIntoViewResponderNode.defaultParent;
                }
                LayoutCoordinates layoutCoordinates = bringIntoViewResponderNode.getLayoutCoordinates();
                if (layoutCoordinates == null) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                if (bringIntoViewParent.bringChildIntoView(layoutCoordinates, this.$parentRect, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BringIntoViewResponderNode$bringChildIntoView$2(BringIntoViewResponderNode bringIntoViewResponderNode, LayoutCoordinates layoutCoordinates, Function0<Rect> function0, Function0<Rect> function02, Continuation<? super BringIntoViewResponderNode$bringChildIntoView$2> continuation) {
        super(2, continuation);
        this.this$0 = bringIntoViewResponderNode;
        this.$childCoordinates = layoutCoordinates;
        this.$boundsProvider = function0;
        this.$parentRect = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BringIntoViewResponderNode$bringChildIntoView$2 bringIntoViewResponderNode$bringChildIntoView$2 = new BringIntoViewResponderNode$bringChildIntoView$2(this.this$0, this.$childCoordinates, this.$boundsProvider, this.$parentRect, continuation);
        bringIntoViewResponderNode$bringChildIntoView$2.L$0 = obj;
        return bringIntoViewResponderNode$bringChildIntoView$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
        return ((BringIntoViewResponderNode$bringChildIntoView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        BringIntoViewResponderNode bringIntoViewResponderNode = this.this$0;
        BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass1(bringIntoViewResponderNode, this.$childCoordinates, this.$boundsProvider, null), 3);
        return BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass2(bringIntoViewResponderNode, this.$parentRect, null), 3);
    }
}
