package com.animaconnected.watch.device;

import com.animaconnected.watch.utils.WatchLibResult;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: WatchIO.kt */
/* loaded from: classes3.dex */
public interface WatchIODebug {

    /* compiled from: WatchIO.kt */
    /* loaded from: classes3.dex */
    public interface DumpUartProgressCallback {
        void onProgress(String str, int r2, int r3);
    }

    Object enableCSEMLogs(boolean z, Continuation<? super Unit> continuation);

    boolean isDebugEnabled();

    Object readCSEMLogsHeaders(Continuation<? super List<String>> continuation);

    Object readCoil(Continuation<? super List<Integer>> continuation);

    Object readDumpUart(DumpUartProgressCallback dumpUartProgressCallback, Continuation<? super Unit> continuation);

    Object readFcte(Continuation<? super List<Integer>> continuation);

    Object readValues(String str, String str2, Continuation<? super WatchLibResult<String, ? extends Exception>> continuation);

    void setDebugEnabled(boolean z);

    Object writeComplicationMode(int r1, int r2, Continuation<? super Unit> continuation);

    Object writeComplicationMode(int r1, Continuation<? super Unit> continuation);

    Object writeComplicationMode(int[] r1, Continuation<? super Unit> continuation);

    Object writeComplicationModes(int r1, int r2, int r3, int r4, int r5, int r6, Continuation<? super Unit> continuation);

    Object writeComplicationModes(int r1, int r2, int r3, Continuation<? super Unit> continuation);

    Object writeComplicationModes(int[] r1, Continuation<? super Unit> continuation);

    Object writeDebugAppError(int r1, Continuation<? super Unit> continuation);

    Object writeDebugConfig(List<Integer> list, Continuation<? super Unit> continuation);

    Object writeDebugConfig(boolean z, boolean z2, boolean z3, boolean z4, int r5, int r6, boolean z5, Continuation<? super Unit> continuation);

    Object writeEnterBatterySim(int r1, Continuation<? super Unit> continuation);

    Object writeMotor(int r1, int r2, Continuation<? super Unit> continuation);

    Object writeSpeedRead(int r1, int r2, String str, Continuation<? super Unit> continuation);

    Object writeStartVibratorWithBuiltinTestPattern(Continuation<? super Unit> continuation);

    Object writeStepperExecPredef(int r1, int r2, int r3, int r4, Continuation<? super Unit> continuation);

    Object writeValues(String str, String str2, Continuation<? super WatchLibResult<Boolean, ? extends Exception>> continuation);

    Object writeVbatSim(int r1, Continuation<? super Unit> continuation);
}
