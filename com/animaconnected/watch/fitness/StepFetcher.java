package com.animaconnected.watch.fitness;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.fitness.sync.FitnessSyncIO;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StepFetcher.kt */
/* loaded from: classes3.dex */
public final class StepFetcher {
    private final FitnessQueries db;
    private boolean saving;

    public StepFetcher(FitnessQueries db) {
        Intrinsics.checkNotNullParameter(db, "db");
        this.db = db;
    }

    private final boolean checkDayMatch(int r3, int r4) {
        if (r4 == DateTimeUtilsKt.getLocalDateTime$default(null, null, 3, null).getDayOfMonth() - r3) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object fetch$default(StepFetcher stepFetcher, FitnessSyncIO fitnessSyncIO, Function0 function0, Continuation continuation, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: com.animaconnected.watch.fitness.StepFetcher$fetch$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        return stepFetcher.fetch(fitnessSyncIO, function0, continuation);
    }

    public static /* synthetic */ Object save$default(StepFetcher stepFetcher, FitnessSyncIO fitnessSyncIO, int r8, int r9, Function0 function0, Continuation continuation, int r12, Object obj) {
        if ((r12 & 8) != 0) {
            function0 = new Function0<Unit>() { // from class: com.animaconnected.watch.fitness.StepFetcher$save$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        return stepFetcher.save(fitnessSyncIO, r8, r9, function0, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|7|(1:(4:(1:(1:12)(2:17|18))(1:19)|13|14|15)(4:20|21|22|23))(4:41|42|43|(1:45)(1:46))|24|(2:26|27)(4:28|(2:30|(1:32))(2:33|(2:35|(1:37)))|14|15)))|50|6|7|(0)(0)|24|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0041, code lost:            r1 = r10;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071 A[Catch: Exception -> 0x0041, TryCatch #2 {Exception -> 0x0041, blocks: (B:13:0x003c, B:24:0x006d, B:26:0x0071, B:28:0x0074, B:30:0x007b, B:33:0x00a2, B:35:0x00a9), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074 A[Catch: Exception -> 0x0041, TryCatch #2 {Exception -> 0x0041, blocks: (B:13:0x003c, B:24:0x006d, B:26:0x0071, B:28:0x0074, B:30:0x007b, B:33:0x00a2, B:35:0x00a9), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetch(com.animaconnected.watch.fitness.sync.FitnessSyncIO r10, kotlin.jvm.functions.Function0<kotlin.Unit> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.StepFetcher.fetch(com.animaconnected.watch.fitness.sync.FitnessSyncIO, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final FitnessQueries getDb() {
        return this.db;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:3|(12:5|6|7|(1:(1:(2:11|(2:13|(6:15|16|17|18|19|(3:21|22|(1:24)(4:26|27|28|(5:30|31|32|33|34)(4:35|(1:37)(1:49)|38|(4:47|48|19|(5:62|31|32|33|34)(0))(4:41|42|43|(1:45)(4:46|18|19|(0)(0))))))(0))(2:64|65))(6:66|67|68|27|28|(0)(0)))(4:69|70|71|72))(5:79|80|81|82|83))(2:84|(2:86|87)(8:88|89|91|92|(1:94)(1:131)|95|96|(9:118|119|120|121|122|123|32|33|34)(6:98|99|100|101|102|(2:104|(1:106)(3:107|82|83))(2:108|(2:110|(1:112)(2:113|72))(2:114|115)))))|73|(1:75)|76|(3:78|22|(0)(0))|31|32|33|34))|140|6|7|(0)(0)|73|(0)|76|(0)|31|32|33|34|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x00a4, code lost:            r0 = th;     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x023c, code lost:            r11 = r12;     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x00f2, code lost:            r0 = th;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x032f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0340 A[Catch: all -> 0x043a, CancellationException -> 0x043e, TryCatch #10 {CancellationException -> 0x043e, all -> 0x043a, blocks: (B:28:0x0339, B:35:0x0340, B:37:0x0351, B:38:0x0361, B:41:0x03a4, B:49:0x035a), top: B:27:0x0339 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0045  */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x03f7 -> B:18:0x03fd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0424 -> B:19:0x0408). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object save(com.animaconnected.watch.fitness.sync.FitnessSyncIO r40, int r41, int r42, kotlin.jvm.functions.Function0<kotlin.Unit> r43, kotlin.coroutines.Continuation<? super kotlin.Unit> r44) {
        /*
            Method dump skipped, instructions count: 1111
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.StepFetcher.save(com.animaconnected.watch.fitness.sync.FitnessSyncIO, int, int, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
