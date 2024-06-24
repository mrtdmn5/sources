package com.animaconnected.secondo.screens.debugsettings;

import android.content.Context;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.debugging.FileWriter;
import com.animaconnected.watch.fitness.CSEMLogs;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.Job;

/* compiled from: CSEMLogsFileSaver.kt */
/* loaded from: classes3.dex */
public final class CSEMLogsFileSaver {
    public static final int $stable;
    private static Job collectJob;
    private static final FileWriter fileWriter;
    public static final CSEMLogsFileSaver INSTANCE = new CSEMLogsFileSaver();
    private static final Lazy csemLogs$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CSEMLogs>() { // from class: com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$csemLogs$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CSEMLogs invoke() {
            return ProviderFactory.getWatch().getWatchManager().getCsemLogs();
        }
    });
    private static final Lazy context$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Context>() { // from class: com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$context$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Context invoke() {
            return KronabyApplication.Companion.getContext();
        }
    });

    static {
        int r1 = Duration.$r8$clinit;
        fileWriter = new FileWriter("csem", null, 26214400, 20, DurationKt.toDuration(10, DurationUnit.SECONDS), ".csv", 2, null);
        $stable = 8;
    }

    private CSEMLogsFileSaver() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        return (Context) context$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CSEMLogs getCsemLogs() {
        return (CSEMLogs) csemLogs$delegate.getValue();
    }

    public final void clear() {
        fileWriter.delete(getContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object disable(com.animaconnected.watch.device.WatchIODebug r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$disable$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$disable$1 r0 = (com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$disable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$disable$1 r0 = new com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$disable$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L66
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            java.lang.Object r6 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver r6 = (com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4d
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.fitness.CSEMLogs r7 = r5.getCsemLogs()
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r7.disable(r6, r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r6 = r5
        L4d:
            kotlinx.coroutines.Job r7 = com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver.collectJob
            r2 = 0
            if (r7 == 0) goto L55
            r7.cancel(r2)
        L55:
            com.animaconnected.secondo.utils.debugging.FileWriter r7 = com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver.fileWriter
            android.content.Context r6 = r6.getContext()
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r7.saveToFile(r6, r0)
            if (r6 != r1) goto L66
            return r1
        L66:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver.disable(com.animaconnected.watch.device.WatchIODebug, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object enable(com.animaconnected.watch.device.WatchIODebug r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$enable$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$enable$1 r0 = (com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$enable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$enable$1 r0 = new com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$enable$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver r5 = (com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            com.animaconnected.watch.fitness.CSEMLogs r6 = r4.getCsemLogs()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.enable(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r5 = r4
        L46:
            java.lang.String r6 = (java.lang.String) r6
            com.animaconnected.secondo.utils.debugging.FileWriter r0 = com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver.fileWriter
            android.content.Context r1 = r5.getContext()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r6 = 10
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r0.append(r1, r6)
            com.animaconnected.watch.fitness.CSEMLogs r5 = r5.getCsemLogs()
            kotlinx.coroutines.CoroutineScope r5 = r5.getScope()
            kotlinx.coroutines.scheduling.DefaultIoScheduler r6 = kotlinx.coroutines.Dispatchers.IO
            com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$enable$2 r0 = new com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver$enable$2
            r1 = 0
            r0.<init>(r1)
            r2 = 2
            kotlinx.coroutines.StandaloneCoroutine r5 = kotlinx.coroutines.BuildersKt.launch$default(r5, r6, r1, r0, r2)
            com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver.collectJob = r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver.enable(com.animaconnected.watch.device.WatchIODebug, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final long size() {
        return fileWriter.size(getContext());
    }

    public final File zip() {
        return fileWriter.zip(getContext(), "CSEMLogs.zip");
    }
}
