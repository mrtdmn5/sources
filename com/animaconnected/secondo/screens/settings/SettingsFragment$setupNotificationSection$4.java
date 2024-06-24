package com.animaconnected.secondo.screens.settings;

import com.animaconnected.future.Future;
import com.animaconnected.future.FutureCoroutineKt;
import com.animaconnected.secondo.provider.ImportantAppsProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SettingsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.SettingsFragment$setupNotificationSection$4", f = "SettingsFragment.kt", l = {219}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SettingsFragment$setupNotificationSection$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImportantAppsProvider $provider;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsFragment$setupNotificationSection$4(ImportantAppsProvider importantAppsProvider, Continuation<? super SettingsFragment$setupNotificationSection$4> continuation) {
        super(2, continuation);
        this.$provider = importantAppsProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsFragment$setupNotificationSection$4(this.$provider, continuation);
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
            Future fetchAllInstalledApps$default = ImportantAppsProvider.fetchAllInstalledApps$default(this.$provider, null, 1, null);
            this.label = 1;
            if (FutureCoroutineKt.getSuspending(fetchAllInstalledApps$default, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsFragment$setupNotificationSection$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
