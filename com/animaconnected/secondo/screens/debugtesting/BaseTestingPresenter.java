package com.animaconnected.secondo.screens.debugtesting;

import android.content.Context;
import android.widget.Toast;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.device.WatchIO;
import com.animaconnected.watch.device.WatchIODebug;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* compiled from: BaseTestingPresenter.kt */
/* loaded from: classes3.dex */
public class BaseTestingPresenter {
    private Job batteryJob;
    private final Context context;
    private final WatchIODebug debugFunctions;
    private final BaseTestingView view;
    private final WatchIO watchFunctions;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "BaseTestingPresenter";

    /* compiled from: BaseTestingPresenter.kt */
    /* loaded from: classes3.dex */
    public interface BaseTestingView {
        void setFcteStatus(String str);

        void setMovementTestStatus(String str);

        void setRssiStatus(String str);

        void setVibratorStatus(String str);
    }

    /* compiled from: BaseTestingPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BaseTestingPresenter(BaseTestingView view, Context context) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = view;
        this.context = context;
        this.debugFunctions = ProviderFactory.getWatch().getWatch().getDebugIo();
        this.watchFunctions = ProviderFactory.getWatch().getWatch().getIo();
    }

    public final Context getContext() {
        return this.context;
    }

    public final WatchIODebug getDebugFunctions() {
        return this.debugFunctions;
    }

    public final void onDepleteBatteriesClicked(LifecycleCoroutineScope lifecycleScope) {
        Intrinsics.checkNotNullParameter(lifecycleScope, "lifecycleScope");
        Job job = this.batteryJob;
        if (job != null) {
            job.cancel(null);
            this.batteryJob = null;
            this.view.setVibratorStatus("Stopped");
        } else if (this.debugFunctions == null) {
            Toast.makeText(this.context, "No device!", 0).show();
        } else {
            this.batteryJob = BuildersKt.launch$default(lifecycleScope, null, null, new BaseTestingPresenter$onDepleteBatteriesClicked$2(this, lifecycleScope, null), 3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onTestFcteClicked(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter.onTestFcteClicked(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|(1:(1:(1:(6:12|13|14|15|16|(10:18|(1:20)|22|(1:24)|25|(1:27)|14|15|16|(2:28|29)(0))(0))(2:31|32))(8:33|34|25|(0)|14|15|16|(0)(0)))(10:35|36|22|(0)|25|(0)|14|15|16|(0)(0)))(2:37|(2:39|40)(3:41|16|(0)(0)))))|43|6|7|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cd, code lost:            r7.append(r2);        r7.append(" Fail. ");        r8.view.setMovementTestStatus(r7.toString());     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0084 A[Catch: Exception -> 0x00cd, TRY_ENTER, TryCatch #0 {Exception -> 0x00cd, blocks: (B:13:0x0034, B:14:0x00bb, B:18:0x0084, B:22:0x0097, B:25:0x00aa, B:34:0x004b, B:36:0x0059), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00b8 -> B:14:0x00bb). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onTestMovementClicked(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter.onTestMovementClicked(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[Catch: Exception -> 0x002d, TryCatch #1 {Exception -> 0x002d, blocks: (B:11:0x0029, B:12:0x0064, B:15:0x007c, B:19:0x006c, B:21:0x0074), top: B:10:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onTestRssiClicked(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "Test rssi. Current: "
            boolean r1 = r6 instanceof com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$onTestRssiClicked$1
            if (r1 == 0) goto L15
            r1 = r6
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$onTestRssiClicked$1 r1 = (com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$onTestRssiClicked$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$onTestRssiClicked$1 r1 = new com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$onTestRssiClicked$1
            r1.<init>(r5, r6)
        L1a:
            java.lang.Object r6 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L37
            if (r3 != r4) goto L2f
            java.lang.Object r1 = r1.L$0
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter r1 = (com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter) r1
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L2d
            goto L64
        L2d:
            r6 = move-exception
            goto L90
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            com.animaconnected.watch.device.WatchIODebug r6 = r5.debugFunctions
            if (r6 != 0) goto L4d
            android.content.Context r6 = r5.context
            java.lang.String r0 = "No device!"
            r1 = 0
            android.widget.Toast r6 = android.widget.Toast.makeText(r6, r0, r1)
            r6.show()
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L4d:
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$BaseTestingView r6 = r5.view
            java.lang.String r3 = "Wait for result..."
            r6.setRssiStatus(r3)
            com.animaconnected.watch.device.WatchIO r6 = r5.watchFunctions     // Catch: java.lang.Exception -> L8e
            if (r6 == 0) goto L67
            r1.L$0 = r5     // Catch: java.lang.Exception -> L8e
            r1.label = r4     // Catch: java.lang.Exception -> L8e
            java.lang.Object r6 = r6.readRssi(r1)     // Catch: java.lang.Exception -> L8e
            if (r6 != r2) goto L63
            return r2
        L63:
            r1 = r5
        L64:
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch: java.lang.Exception -> L2d
            goto L69
        L67:
            r6 = 0
            r1 = r5
        L69:
            if (r6 != 0) goto L6c
            goto L7c
        L6c:
            int r2 = r6.intValue()     // Catch: java.lang.Exception -> L2d
            r3 = 128(0x80, float:1.8E-43)
            if (r2 != r3) goto L7c
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$BaseTestingView r6 = r1.view     // Catch: java.lang.Exception -> L2d
            java.lang.String r0 = "Try again."
            r6.setRssiStatus(r0)     // Catch: java.lang.Exception -> L2d
            goto Laf
        L7c:
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$BaseTestingView r2 = r1.view     // Catch: java.lang.Exception -> L2d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2d
            r3.<init>(r0)     // Catch: java.lang.Exception -> L2d
            r3.append(r6)     // Catch: java.lang.Exception -> L2d
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Exception -> L2d
            r2.setRssiStatus(r6)     // Catch: java.lang.Exception -> L2d
            goto Laf
        L8e:
            r6 = move-exception
            r1 = r5
        L90:
            java.lang.String r0 = com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "onFail() called with: error = ["
            r2.<init>(r3)
            r2.append(r6)
            r3 = 93
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r0, r2, r6)
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$BaseTestingView r6 = r1.view
            java.lang.String r0 = "RSSI failed!. Try again."
            r6.setRssiStatus(r0)
        Laf:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter.onTestRssiClicked(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onTestVibratorClicked(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$onTestVibratorClicked$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$onTestVibratorClicked$1 r0 = (com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$onTestVibratorClicked$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$onTestVibratorClicked$1 r0 = new com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$onTestVibratorClicked$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter r0 = (com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L2b
            goto L57
        L2b:
            r5 = move-exception
            goto L61
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            com.animaconnected.watch.device.WatchIODebug r5 = r4.debugFunctions
            if (r5 != 0) goto L4b
            android.content.Context r5 = r4.context
            java.lang.String r0 = "No device!"
            r1 = 0
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r0, r1)
            r5.show()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L4b:
            r0.L$0 = r4     // Catch: java.lang.Exception -> L5f
            r0.label = r3     // Catch: java.lang.Exception -> L5f
            java.lang.Object r5 = r5.writeStartVibratorWithBuiltinTestPattern(r0)     // Catch: java.lang.Exception -> L5f
            if (r5 != r1) goto L56
            return r1
        L56:
            r0 = r4
        L57:
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$BaseTestingView r5 = r0.view     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = "Vibration sent, click to send again"
            r5.setVibratorStatus(r1)     // Catch: java.lang.Exception -> L2b
            goto L78
        L5f:
            r5 = move-exception
            r0 = r4
        L61:
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$BaseTestingView r0 = r0.view
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Vibration failed: "
            r1.<init>(r2)
            java.lang.String r5 = r5.getLocalizedMessage()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.setVibratorStatus(r5)
        L78:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter.onTestVibratorClicked(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
