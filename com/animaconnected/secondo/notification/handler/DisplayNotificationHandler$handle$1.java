package com.animaconnected.secondo.notification.handler;

import android.service.notification.StatusBarNotification;
import com.animaconnected.secondo.R;
import com.animaconnected.watch.DisplayWatch;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DisplayNotificationHandler.kt */
@DebugMetadata(c = "com.animaconnected.secondo.notification.handler.DisplayNotificationHandler$handle$1", f = "DisplayNotificationHandler.kt", l = {117, R.styleable.AppTheme_stepsHistoryLegendColorActivity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DisplayNotificationHandler$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StatusBarNotification $sbn;
    final /* synthetic */ DisplayWatch $watch;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DisplayNotificationHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayNotificationHandler$handle$1(StatusBarNotification statusBarNotification, DisplayNotificationHandler displayNotificationHandler, DisplayWatch displayWatch, Continuation<? super DisplayNotificationHandler$handle$1> continuation) {
        super(2, continuation);
        this.$sbn = statusBarNotification;
        this.this$0 = displayNotificationHandler;
        this.$watch = displayWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DisplayNotificationHandler$handle$1 displayNotificationHandler$handle$1 = new DisplayNotificationHandler$handle$1(this.$sbn, this.this$0, this.$watch, continuation);
        displayNotificationHandler$handle$1.L$0 = obj;
        return displayNotificationHandler$handle$1;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:1|(1:(1:(5:5|6|7|8|9)(2:15|16))(1:17))(2:53|(2:55|56)(9:57|(5:59|(5:62|(1:64)(1:71)|(3:66|67|68)(1:70)|69|60)|72|73|(1:75))|22|23|24|25|(5:29|(1:31)(1:43)|(1:42)|35|(4:37|(1:39)|8|9)(2:40|41))|49|50))|18|(2:20|21)|22|23|24|25|(7:27|29|(0)(0)|(1:33)|42|35|(0)(0))|44|46|29|(0)(0)|(0)|42|35|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01ad, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01ae, code lost:            r4 = r0;        r2 = r9;     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010e A[Catch: Exception -> 0x01ad, TryCatch #0 {Exception -> 0x01ad, blocks: (B:24:0x00da, B:27:0x00f0, B:29:0x0104, B:31:0x010e, B:33:0x0119, B:35:0x0129, B:37:0x0176, B:40:0x018c, B:42:0x0125, B:44:0x00f6, B:46:0x00fc, B:49:0x019a), top: B:23:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0119 A[Catch: Exception -> 0x01ad, TryCatch #0 {Exception -> 0x01ad, blocks: (B:24:0x00da, B:27:0x00f0, B:29:0x0104, B:31:0x010e, B:33:0x0119, B:35:0x0129, B:37:0x0176, B:40:0x018c, B:42:0x0125, B:44:0x00f6, B:46:0x00fc, B:49:0x019a), top: B:23:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0176 A[Catch: Exception -> 0x01ad, TryCatch #0 {Exception -> 0x01ad, blocks: (B:24:0x00da, B:27:0x00f0, B:29:0x0104, B:31:0x010e, B:33:0x0119, B:35:0x0129, B:37:0x0176, B:40:0x018c, B:42:0x0125, B:44:0x00f6, B:46:0x00fc, B:49:0x019a), top: B:23:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018c A[Catch: Exception -> 0x01ad, TryCatch #0 {Exception -> 0x01ad, blocks: (B:24:0x00da, B:27:0x00f0, B:29:0x0104, B:31:0x010e, B:33:0x0119, B:35:0x0129, B:37:0x0176, B:40:0x018c, B:42:0x0125, B:44:0x00f6, B:46:0x00fc, B:49:0x019a), top: B:23:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0116  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.notification.handler.DisplayNotificationHandler$handle$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DisplayNotificationHandler$handle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
