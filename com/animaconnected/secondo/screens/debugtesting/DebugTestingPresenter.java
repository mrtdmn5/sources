package com.animaconnected.secondo.screens.debugtesting;

import android.content.Context;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter;
import com.animaconnected.watch.WatchProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugTestingPresenter.kt */
/* loaded from: classes3.dex */
public final class DebugTestingPresenter extends BaseTestingPresenter {
    private final DebugTestingView debugView;
    private boolean runningPerpetual;
    private boolean runningTimeSpeedup;
    private final WatchProvider watchProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "DebugTestingPresenter";

    /* compiled from: DebugTestingPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: DebugTestingPresenter.kt */
    /* loaded from: classes3.dex */
    public interface DebugTestingView extends BaseTestingPresenter.BaseTestingView {
        void setCoilStatus(String str);

        void setPerpetualStatus(String str);

        void setTimeSpeedup(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugTestingPresenter(DebugTestingView debugView, Context context) {
        super(debugView, context);
        Intrinsics.checkNotNullParameter(debugView, "debugView");
        Intrinsics.checkNotNullParameter(context, "context");
        this.debugView = debugView;
        this.watchProvider = ProviderFactory.getWatch();
    }

    public final void onStart() {
        this.debugView.setCoilStatus("Test coil");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007e A[Catch: Exception -> 0x002c, TryCatch #0 {Exception -> 0x002c, blocks: (B:11:0x0028, B:12:0x0067, B:13:0x0078, B:15:0x007e, B:17:0x0086, B:19:0x009a, B:21:0x00bd, B:22:0x00ac, B:25:0x00c8, B:26:0x00cc, B:29:0x00cd), top: B:10:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Type inference failed for: r2v11, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onTestCoilClicked(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter.onTestCoilClicked(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|90|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x006f, code lost:            r0 = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x014b, code lost:            r0 = r13;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0022. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x018f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0179 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0142 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.Continuation, com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter$onTestPerpetualBackAndForthClicked$1] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onTestPerpetualBackAndForthClicked(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter.onTestPerpetualBackAndForthClicked(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onTestTimeSpeedupClicked(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter$onTestTimeSpeedupClicked$1
            if (r0 == 0) goto L13
            r0 = r11
            com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter$onTestTimeSpeedupClicked$1 r0 = (com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter$onTestTimeSpeedupClicked$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter$onTestTimeSpeedupClicked$1 r0 = new com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter$onTestTimeSpeedupClicked$1
            r0.<init>(r10, r11)
        L18:
            r9 = r0
            java.lang.Object r11 = r9.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            java.lang.Object r0 = r9.L$0
            com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter r0 = (com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L8a
            goto L86
        L2c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L34:
            kotlin.ResultKt.throwOnFailure(r11)
            com.animaconnected.watch.device.WatchIODebug r11 = r10.getDebugFunctions()
            r1 = 0
            if (r11 != 0) goto L4e
            android.content.Context r11 = r10.getContext()
            java.lang.String r0 = "No device!"
            android.widget.Toast r11 = android.widget.Toast.makeText(r11, r0, r1)
            r11.show()
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L4e:
            com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter$DebugTestingView r11 = r10.debugView
            java.lang.String r3 = "Wait for response..."
            r11.setTimeSpeedup(r3)
            boolean r11 = r10.runningTimeSpeedup
            if (r11 == 0) goto L6a
            r10.runningTimeSpeedup = r1
            com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter$DebugTestingView r11 = r10.debugView
            java.lang.String r0 = "Stopped. Click to run again"
            r11.setTimeSpeedup(r0)
            com.animaconnected.watch.WatchProvider r11 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            r11.setDeviceTime()
            goto L91
        L6a:
            r10.runningTimeSpeedup = r2
            com.animaconnected.watch.device.WatchIODebug r1 = r10.getDebugFunctions()     // Catch: java.lang.Exception -> L89
            r11 = 0
            r3 = 0
            r4 = 1
            r5 = 1
            r6 = 60
            r7 = 200(0xc8, float:2.8E-43)
            r8 = 0
            r9.L$0 = r10     // Catch: java.lang.Exception -> L89
            r9.label = r2     // Catch: java.lang.Exception -> L89
            r2 = r11
            java.lang.Object r11 = r1.writeDebugConfig(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L89
            if (r11 != r0) goto L85
            return r0
        L85:
            r0 = r10
        L86:
            java.lang.String r11 = "Success! Press to stop"
            goto L8c
        L89:
            r0 = r10
        L8a:
            java.lang.String r11 = "Failed test"
        L8c:
            com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter$DebugTestingView r0 = r0.debugView
            r0.setTimeSpeedup(r11)
        L91:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter.onTestTimeSpeedupClicked(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
