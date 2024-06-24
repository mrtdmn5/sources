package com.animaconnected.secondo.behaviour.call;

import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.app.ImportantContactKt;
import com.animaconnected.watch.CallHelper;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.DisplayWatchJvm;
import com.animaconnected.watch.device.CallState;
import com.animaconnected.watch.filter.ImportantContact;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CallsWatchAppAndroid.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid$onCallStateChanged$3", f = "CallsWatchAppAndroid.kt", l = {108, 118}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CallsWatchAppAndroid$onCallStateChanged$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ImportantContact> $contacts;
    final /* synthetic */ String $number;
    final /* synthetic */ CallState $state;
    final /* synthetic */ DisplayWatch $watch;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CallsWatchAppAndroid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallsWatchAppAndroid$onCallStateChanged$3(List<ImportantContact> list, CallState callState, CallsWatchAppAndroid callsWatchAppAndroid, String str, DisplayWatch displayWatch, Continuation<? super CallsWatchAppAndroid$onCallStateChanged$3> continuation) {
        super(2, continuation);
        this.$contacts = list;
        this.$state = callState;
        this.this$0 = callsWatchAppAndroid;
        this.$number = str;
        this.$watch = displayWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CallsWatchAppAndroid$onCallStateChanged$3 callsWatchAppAndroid$onCallStateChanged$3 = new CallsWatchAppAndroid$onCallStateChanged$3(this.$contacts, this.$state, this.this$0, this.$number, this.$watch, continuation);
        callsWatchAppAndroid$onCallStateChanged$3.L$0 = obj;
        return callsWatchAppAndroid$onCallStateChanged$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        final Exception e;
        CoroutineScope coroutineScope2;
        Set set;
        String str;
        int r5;
        Set set2;
        String str2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        boolean z = true;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e2) {
                        e = e2;
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e3) {
                e = e3;
                coroutineScope = coroutineScope2;
            }
            str2 = this.this$0.tag;
            LogKt.debug$default((Object) coroutineScope, str2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid$onCallStateChanged$3.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Could not send a call notification, "));
                }
            }, 6, (Object) null);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
        try {
            List<ImportantContact> list = this.$contacts;
            this.L$0 = coroutineScope3;
            this.label = 1;
            Object allowNotifyForCalls = ImportantContactKt.allowNotifyForCalls(list, this);
            if (allowNotifyForCalls == coroutineSingletons) {
                return coroutineSingletons;
            }
            coroutineScope2 = coroutineScope3;
            obj = allowNotifyForCalls;
        } catch (Exception e4) {
            coroutineScope = coroutineScope3;
            e = e4;
        }
        if (!((Boolean) obj).booleanValue()) {
            return Unit.INSTANCE;
        }
        if (this.$state == CallState.OffHook) {
            set2 = this.this$0.activeCalls;
            set2.add(this.$number);
        }
        set = this.this$0.activeCalls;
        if (set.size() > 1) {
            str = StringsExtensionsKt.getFirmwareString(Key.calls_multiple);
        } else {
            ImportantContact importantContact = (ImportantContact) CollectionsKt___CollectionsKt.firstOrNull((List) this.$contacts);
            if (importantContact == null || (str = importantContact.getDisplayName()) == null) {
                str = this.$number;
            }
        }
        String str3 = str;
        DisplayWatch displayWatch = this.$watch;
        r5 = this.this$0.callId;
        CallState callState = this.$state;
        CallHelper callHelper = CallHelper.INSTANCE;
        boolean canAnswerCalls = callHelper.canAnswerCalls();
        if (!callHelper.canEndCalls() && !CallHelper.shouldMuteCalls()) {
            z = false;
        }
        this.L$0 = coroutineScope2;
        this.label = 2;
        if (DisplayWatchJvm.setCallStatus(displayWatch, r5, callState, str3, canAnswerCalls, z, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CallsWatchAppAndroid$onCallStateChanged$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
