package androidx.compose.material;

import androidx.compose.material.SnackbarHostKt;
import androidx.compose.ui.platform.AccessibilityManager;
import com.animaconnected.secondo.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: SnackbarHost.kt */
@DebugMetadata(c = "androidx.compose.material.SnackbarHostKt$SnackbarHost$1", f = "SnackbarHost.kt", l = {R.styleable.AppTheme_tabTextColor}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SnackbarHostKt$SnackbarHost$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ AccessibilityManager $accessibilityManager;
    public final /* synthetic */ SnackbarData $currentSnackbarData;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnackbarHostKt$SnackbarHost$1(SnackbarData snackbarData, AccessibilityManager accessibilityManager, Continuation<? super SnackbarHostKt$SnackbarHost$1> continuation) {
        super(2, continuation);
        this.$currentSnackbarData = snackbarData;
        this.$accessibilityManager = accessibilityManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SnackbarHostKt$SnackbarHost$1(this.$currentSnackbarData, this.$accessibilityManager, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SnackbarHostKt$SnackbarHost$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        long j;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        SnackbarData snackbarData = this.$currentSnackbarData;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            if (snackbarData != null) {
                SnackbarDuration duration = snackbarData.getDuration();
                if (snackbarData.getActionLabel() != null) {
                    z = true;
                } else {
                    z = false;
                }
                Intrinsics.checkNotNullParameter(duration, "<this>");
                int r7 = SnackbarHostKt.WhenMappings.$EnumSwitchMapping$0[duration.ordinal()];
                if (r7 != 1) {
                    if (r7 != 2) {
                        if (r7 == 3) {
                            j = 4000;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        j = 10000;
                    }
                } else {
                    j = Long.MAX_VALUE;
                }
                AccessibilityManager accessibilityManager = this.$accessibilityManager;
                if (accessibilityManager != null) {
                    j = accessibilityManager.calculateRecommendedTimeoutMillis(j, z);
                }
                this.label = 1;
                if (DelayKt.delay(j, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
        snackbarData.dismiss();
        return Unit.INSTANCE;
    }
}
