package com.animaconnected.secondo.screens.settings.displaynotifications;

import com.animaconnected.secondo.screens.notification.picker.AppInfo;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DisplayNotificationViewModel.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel$fetchAllInstalledAppsUncached$2", f = "DisplayNotificationViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DisplayNotificationViewModel$fetchAllInstalledAppsUncached$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AppState>>, Object> {
    final /* synthetic */ List<AppInfo> $installedApps;
    int label;
    final /* synthetic */ DisplayNotificationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayNotificationViewModel$fetchAllInstalledAppsUncached$2(DisplayNotificationViewModel displayNotificationViewModel, List<AppInfo> list, Continuation<? super DisplayNotificationViewModel$fetchAllInstalledAppsUncached$2> continuation) {
        super(2, continuation);
        this.this$0 = displayNotificationViewModel;
        this.$installedApps = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DisplayNotificationViewModel$fetchAllInstalledAppsUncached$2(this.this$0, this.$installedApps, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends AppState>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<AppState>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List appState;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            appState = this.this$0.toAppState(this.$installedApps);
            return appState;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<AppState>> continuation) {
        return ((DisplayNotificationViewModel$fetchAllInstalledAppsUncached$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
