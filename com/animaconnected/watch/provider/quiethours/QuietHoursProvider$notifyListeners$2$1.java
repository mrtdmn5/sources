package com.animaconnected.watch.provider.quiethours;

import com.animaconnected.watch.provider.quiethours.QuietHoursProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: QuietHoursProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.quiethours.QuietHoursProvider$notifyListeners$2$1", f = "QuietHoursProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class QuietHoursProvider$notifyListeners$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ int $endHour;
    final /* synthetic */ int $endMinutes;
    final /* synthetic */ QuietHoursProvider.QuietHoursChangedListener $it;
    final /* synthetic */ int $startHour;
    final /* synthetic */ int $startMinutes;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuietHoursProvider$notifyListeners$2$1(QuietHoursProvider.QuietHoursChangedListener quietHoursChangedListener, boolean z, int r3, int r4, int r5, int r6, Continuation<? super QuietHoursProvider$notifyListeners$2$1> continuation) {
        super(2, continuation);
        this.$it = quietHoursChangedListener;
        this.$enabled = z;
        this.$startHour = r3;
        this.$startMinutes = r4;
        this.$endHour = r5;
        this.$endMinutes = r6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QuietHoursProvider$notifyListeners$2$1(this.$it, this.$enabled, this.$startHour, this.$startMinutes, this.$endHour, this.$endMinutes, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$it.onQuietHoursChanged(this.$enabled, this.$startHour, this.$startMinutes, this.$endHour, this.$endMinutes);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QuietHoursProvider$notifyListeners$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
