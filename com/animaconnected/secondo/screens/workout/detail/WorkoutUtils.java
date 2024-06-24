package com.animaconnected.secondo.screens.workout.detail;

/* compiled from: WorkoutUtils.kt */
/* loaded from: classes3.dex */
public final class WorkoutUtils {
    public static final int $stable = 0;
    public static final WorkoutUtils INSTANCE = new WorkoutUtils();

    private WorkoutUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object shareTcxFile(android.content.Context r6, com.animaconnected.watch.fitness.Session r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.animaconnected.secondo.screens.workout.detail.WorkoutUtils$shareTcxFile$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.secondo.screens.workout.detail.WorkoutUtils$shareTcxFile$1 r0 = (com.animaconnected.secondo.screens.workout.detail.WorkoutUtils$shareTcxFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.workout.detail.WorkoutUtils$shareTcxFile$1 r0 = new com.animaconnected.secondo.screens.workout.detail.WorkoutUtils$shareTcxFile$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r6 = r0.L$0
            android.content.Context r6 = (android.content.Context) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L49
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.scheduling.DefaultIoScheduler r8 = kotlinx.coroutines.Dispatchers.IO
            com.animaconnected.secondo.screens.workout.detail.WorkoutUtils$shareTcxFile$fileUri$1 r2 = new com.animaconnected.secondo.screens.workout.detail.WorkoutUtils$shareTcxFile$fileUri$1
            r4 = 0
            r2.<init>(r7, r6, r4)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L49
            return r1
        L49:
            android.net.Uri r8 = (android.net.Uri) r8
            android.content.Intent r7 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.SEND"
            r7.<init>(r0)
            java.lang.String r0 = "android.intent.extra.STREAM"
            r7.putExtra(r0, r8)
            java.lang.String r8 = "text/*"
            r7.setType(r8)
            r7.addFlags(r3)
            java.lang.String r8 = "Share File"
            android.content.Intent r7 = android.content.Intent.createChooser(r7, r8)
            r6.startActivity(r7)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.detail.WorkoutUtils.shareTcxFile(android.content.Context, com.animaconnected.watch.fitness.Session, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
