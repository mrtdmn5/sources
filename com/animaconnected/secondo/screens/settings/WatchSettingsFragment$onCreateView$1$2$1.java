package com.animaconnected.secondo.screens.settings;

import androidx.fragment.app.FragmentActivity;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.WatchProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchSettingsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.WatchSettingsFragment$onCreateView$1$2$1", f = "WatchSettingsFragment.kt", l = {116}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchSettingsFragment$onCreateView$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WatchSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchSettingsFragment$onCreateView$1$2$1(WatchSettingsFragment watchSettingsFragment, Continuation<? super WatchSettingsFragment$onCreateView$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = watchSettingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchSettingsFragment$onCreateView$1$2$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
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
            this.this$0.justActivatedWatch = true;
            WatchProvider watch = ProviderFactory.getWatch();
            str = this.this$0.address;
            if (str != null) {
                this.label = 1;
                if (watch.changeDevice(str, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException(WatchSettingsFragment.addressBundleKey);
                throw null;
            }
        }
        ProviderFactory.getWatchDfuProvider().clear();
        ProviderFactory.getWatchFotaProvider().clear();
        ProviderFactory.getWatchUpdateProvider().clear();
        ProviderFactory.getWatchAppUpdateProvider().clear();
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.recreate();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchSettingsFragment$onCreateView$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
