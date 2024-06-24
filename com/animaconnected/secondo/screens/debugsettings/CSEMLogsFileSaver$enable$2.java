package com.animaconnected.secondo.screens.debugsettings;

import android.content.Context;
import com.animaconnected.secondo.utils.debugging.FileWriter;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.fitness.CSEMLogs;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: CSEMLogsFileSaver.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$enable$2", f = "CSEMLogsFileSaver.kt", l = {32}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CSEMLogsFileSaver$enable$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public CSEMLogsFileSaver$enable$2(Continuation<? super CSEMLogsFileSaver$enable$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CSEMLogsFileSaver$enable$2(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CSEMLogs csemLogs;
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
            csemLogs = CSEMLogsFileSaver.INSTANCE.getCsemLogs();
            CommonFlow<String> data = csemLogs.data();
            FlowCollector<? super String> flowCollector = new FlowCollector() { // from class: com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$enable$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((String) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(String str, Continuation<? super Unit> continuation) {
                    FileWriter fileWriter;
                    Context context;
                    fileWriter = CSEMLogsFileSaver.fileWriter;
                    context = CSEMLogsFileSaver.INSTANCE.getContext();
                    fileWriter.append(context, str + '\n');
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (data.collect(flowCollector, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CSEMLogsFileSaver$enable$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
