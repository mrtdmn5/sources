package androidx.compose.ui.viewinterop;

import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidViewHolder.android.kt */
@DebugMetadata(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1", f = "AndroidViewHolder.android.kt", l = {522, 527}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AndroidViewHolder$onNestedFling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ boolean $consumed;
    public final /* synthetic */ long $viewVelocity;
    public int label;
    public final /* synthetic */ AndroidViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder$onNestedFling$1(boolean z, AndroidViewHolder androidViewHolder, long j, Continuation<? super AndroidViewHolder$onNestedFling$1> continuation) {
        super(2, continuation);
        this.$consumed = z;
        this.this$0 = androidViewHolder;
        this.$viewVelocity = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidViewHolder$onNestedFling$1(this.$consumed, this.this$0, this.$viewVelocity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidViewHolder$onNestedFling$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1 && r1 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            boolean z = this.$consumed;
            AndroidViewHolder androidViewHolder = this.this$0;
            if (!z) {
                NestedScrollDispatcher nestedScrollDispatcher = androidViewHolder.dispatcher;
                int r11 = Velocity.$r8$clinit;
                long j = Velocity.Zero;
                long j2 = this.$viewVelocity;
                this.label = 1;
                if (nestedScrollDispatcher.m403dispatchPostFlingRZ2iAVY(j, j2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                NestedScrollDispatcher nestedScrollDispatcher2 = androidViewHolder.dispatcher;
                long j3 = this.$viewVelocity;
                int r112 = Velocity.$r8$clinit;
                long j4 = Velocity.Zero;
                this.label = 2;
                if (nestedScrollDispatcher2.m403dispatchPostFlingRZ2iAVY(j3, j4, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
