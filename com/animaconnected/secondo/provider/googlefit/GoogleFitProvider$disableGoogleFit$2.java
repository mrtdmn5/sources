package com.animaconnected.secondo.provider.googlefit;

import android.content.Context;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zbn;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GoogleFitProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$disableGoogleFit$2", f = "GoogleFitProvider.kt", l = {118}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class GoogleFitProvider$disableGoogleFit$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GoogleFitProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitProvider$disableGoogleFit$2(GoogleFitProvider googleFitProvider, Continuation<? super GoogleFitProvider$disableGoogleFit$2> continuation) {
        super(2, continuation);
        this.this$0 = googleFitProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GoogleFitProvider$disableGoogleFit$2 googleFitProvider$disableGoogleFit$2 = new GoogleFitProvider$disableGoogleFit$2(this.this$0, continuation);
        googleFitProvider$disableGoogleFit$2.L$0 = obj;
        return googleFitProvider$disableGoogleFit$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context context;
        GoogleSignInAccount googleSignInAccount;
        CoroutineScope coroutineScope;
        Exception e;
        Object disableFitWithFallback;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        boolean z = true;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e2) {
                    e = e2;
                    LogKt.debug$default((Object) coroutineScope, Model$$ExternalSyntheticOutline0.m("disableGoogleFit: failed ", e), (String) null, (Throwable) null, false, 14, (Object) null);
                    z = false;
                    return Boolean.valueOf(z);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            LogKt.debug$default((Object) coroutineScope2, "disableGoogleFit", (String) null, (Throwable) null, false, 14, (Object) null);
            context = this.this$0.context;
            zbn zbc = zbn.zbc(context);
            synchronized (zbc) {
                googleSignInAccount = zbc.zbb;
            }
            if (googleSignInAccount == null) {
                LogKt.debug$default((Object) coroutineScope2, "Failed: No signed in account", (String) null, (Throwable) null, false, 14, (Object) null);
                this.this$0.updateUiState();
                return Boolean.FALSE;
            }
            try {
                GoogleFitProvider googleFitProvider = this.this$0;
                this.L$0 = coroutineScope2;
                this.label = 1;
                disableFitWithFallback = googleFitProvider.disableFitWithFallback(this);
                if (disableFitWithFallback == coroutineSingletons) {
                    return coroutineSingletons;
                }
                coroutineScope = coroutineScope2;
            } catch (Exception e3) {
                coroutineScope = coroutineScope2;
                e = e3;
                LogKt.debug$default((Object) coroutineScope, Model$$ExternalSyntheticOutline0.m("disableGoogleFit: failed ", e), (String) null, (Throwable) null, false, 14, (Object) null);
                z = false;
                return Boolean.valueOf(z);
            }
        }
        ProviderFactory.getAppAnalytics().sendAction("google_fit_disabled");
        return Boolean.valueOf(z);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((GoogleFitProvider$disableGoogleFit$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
