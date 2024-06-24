package com.animaconnected.secondo.screens.debugsettings;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.device.WatchIO;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: DebugSettingsPresenter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$fetchPostMortem$2", f = "DebugSettingsPresenter.kt", l = {343}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugSettingsPresenter$fetchPostMortem$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DebugSettingsPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugSettingsPresenter$fetchPostMortem$2(DebugSettingsPresenter debugSettingsPresenter, Continuation<? super DebugSettingsPresenter$fetchPostMortem$2> continuation) {
        super(2, continuation);
        this.this$0 = debugSettingsPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DebugSettingsPresenter$fetchPostMortem$2 debugSettingsPresenter$fetchPostMortem$2 = new DebugSettingsPresenter$fetchPostMortem$2(this.this$0, continuation);
        debugSettingsPresenter$fetchPostMortem$2.L$0 = obj;
        return debugSettingsPresenter$fetchPostMortem$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v3 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DebugUiState value;
        DebugUiState debugUiState;
        DebugUiState value2;
        DebugUiState debugUiState2;
        DebugUiState value3;
        DebugUiState debugUiState3;
        Object readPostMortemData;
        MutableStateFlow<DebugUiState> uiState;
        DebugUiState value4;
        DebugUiState debugUiState4;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Object obj2 = this.label;
        String str = null;
        try {
            try {
            } catch (Exception e) {
                LogKt.warn$default(obj2, DebugSettingsPresenter.TAG, (Throwable) e, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$fetchPostMortem$2.3
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed reading post mortem data";
                    }
                }, 4, (Object) null);
                MutableStateFlow<DebugUiState> uiState2 = this.this$0.getUiState();
                do {
                    value2 = uiState2.getValue();
                    debugUiState2 = value2;
                } while (!uiState2.compareAndSet(value2, DebugUiState.copy$default(debugUiState2, null, null, null, null, null, null, DebugLoadingState.copy$default(debugUiState2.getLoadingStates(), false, false, false, 6, null), null, false, 447, null)));
            }
            if (obj2 != 0) {
                if (obj2 == 1) {
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    readPostMortemData = obj;
                    obj2 = coroutineScope;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                MutableStateFlow<DebugUiState> uiState3 = this.this$0.getUiState();
                do {
                    value3 = uiState3.getValue();
                    debugUiState3 = value3;
                } while (!uiState3.compareAndSet(value3, DebugUiState.copy$default(debugUiState3, null, null, null, null, null, null, DebugLoadingState.copy$default(debugUiState3.getLoadingStates(), true, false, false, 6, null), null, false, 447, null)));
                WatchIO io2 = this.this$0.watchProvider.getWatch().getIo();
                if (io2 != null) {
                    this.L$0 = coroutineScope2;
                    this.label = 1;
                    readPostMortemData = io2.readPostMortemData(this);
                    obj2 = coroutineScope2;
                    if (readPostMortemData == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                uiState = this.this$0.getUiState();
                do {
                    value4 = uiState.getValue();
                    debugUiState4 = value4;
                } while (!uiState.compareAndSet(value4, DebugUiState.copy$default(debugUiState4, null, null, null, null, null, null, DebugLoadingState.copy$default(debugUiState4.getLoadingStates(), false, false, false, 6, null), null, false, 447, null)));
                return str;
            }
            byte[] bArr = (byte[]) readPostMortemData;
            if (bArr != null) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                str = new String(bArr, UTF_8);
            }
            uiState = this.this$0.getUiState();
            do {
                value4 = uiState.getValue();
                debugUiState4 = value4;
            } while (!uiState.compareAndSet(value4, DebugUiState.copy$default(debugUiState4, null, null, null, null, null, null, DebugLoadingState.copy$default(debugUiState4.getLoadingStates(), false, false, false, 6, null), null, false, 447, null)));
            return str;
        } catch (Throwable th) {
            MutableStateFlow<DebugUiState> uiState4 = this.this$0.getUiState();
            do {
                value = uiState4.getValue();
                debugUiState = value;
            } while (!uiState4.compareAndSet(value, DebugUiState.copy$default(debugUiState, null, null, null, null, null, null, DebugLoadingState.copy$default(debugUiState.getLoadingStates(), false, false, false, 6, null), null, false, 447, null)));
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((DebugSettingsPresenter$fetchPostMortem$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
