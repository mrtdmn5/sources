package com.animaconnected.secondo.provider.googlefit;

import android.content.Context;
import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureCoroutineKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.googlefit.GoogleFitProvider;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceInfo;
import com.google.android.gms.fitness.data.Device;
import com.kronaby.watch.app.R;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: GoogleFitProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$onConnectionChanged$1", f = "GoogleFitProvider.kt", l = {188}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class GoogleFitProvider$onConnectionChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GoogleFitProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitProvider$onConnectionChanged$1(GoogleFitProvider googleFitProvider, Continuation<? super GoogleFitProvider$onConnectionChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = googleFitProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GoogleFitProvider$onConnectionChanged$1 googleFitProvider$onConnectionChanged$1 = new GoogleFitProvider$onConnectionChanged$1(this.this$0, continuation);
        googleFitProvider$onConnectionChanged$1.L$0 = obj;
        return googleFitProvider$onConnectionChanged$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        final Exception e;
        WatchProvider watchProvider;
        CoroutineScope coroutineScope2;
        Context context;
        String str;
        String str2;
        MutableStateFlow mutableStateFlow;
        Object value;
        Device device;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e2) {
                        e = e2;
                        coroutineScope = coroutineScope2;
                        LogKt.debug$default((Object) coroutineScope, FutureCoroutineKt.TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$onConnectionChanged$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("onConnectionChanged error: "));
                            }
                        }, 6, (Object) null);
                        this.this$0.isUploading = false;
                        return Unit.INSTANCE;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                try {
                    watchProvider = this.this$0.watchProvider;
                    Future<Map<DeviceInfo, String>> deviceInformation = watchProvider.getDeviceInformation();
                    this.L$0 = coroutineScope3;
                    this.label = 1;
                    Object suspending = FutureCoroutineKt.getSuspending(deviceInformation, this);
                    if (suspending == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    coroutineScope2 = coroutineScope3;
                    obj = suspending;
                } catch (Exception e3) {
                    coroutineScope = coroutineScope3;
                    e = e3;
                    LogKt.debug$default((Object) coroutineScope, FutureCoroutineKt.TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$onConnectionChanged$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("onConnectionChanged error: "));
                        }
                    }, 6, (Object) null);
                    this.this$0.isUploading = false;
                    return Unit.INSTANCE;
                }
            }
            Map map = (Map) obj;
            GoogleFitProvider.Companion companion = GoogleFitProvider.Companion;
            context = this.this$0.context;
            String string = context.getString(R.string.secondo_app_name);
            String str3 = (String) map.get(DeviceInfo.HardwareRevision);
            if (str3 == null) {
                str = "";
            } else {
                str = str3;
            }
            String str4 = (String) map.get(DeviceInfo.SerialNumber);
            if (str4 == null) {
                str2 = "";
            } else {
                str2 = str4;
            }
            GoogleFitProvider.device = new Device(3, 0, string, str, str2);
            mutableStateFlow = this.this$0.deviceFlow;
            do {
                value = mutableStateFlow.getValue();
                device = GoogleFitProvider.device;
            } while (!mutableStateFlow.compareAndSet(value, device));
            this.this$0.onHourly();
            this.this$0.isUploading = false;
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.this$0.isUploading = false;
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GoogleFitProvider$onConnectionChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
