package com.animaconnected.secondo.app;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.animaconnected.secondo.utils.UIUtility;
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

/* compiled from: DeviceService.kt */
@DebugMetadata(c = "com.animaconnected.secondo.app.DeviceService$onChange$1", f = "DeviceService.kt", l = {337}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DeviceService$onChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NotificationCompat$Builder $builder;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceService$onChange$1(DeviceService deviceService, NotificationCompat$Builder notificationCompat$Builder, Continuation<? super DeviceService$onChange$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceService;
        this.$builder = notificationCompat$Builder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceService$onChange$1 deviceService$onChange$1 = new DeviceService$onChange$1(this.this$0, this.$builder, continuation);
        deviceService$onChange$1.L$0 = obj;
        return deviceService$onChange$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Exception exc;
        CoroutineScope coroutineScope2;
        NotificationManager notificationManager;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    exc = e;
                    coroutineScope = coroutineScope2;
                    String str = DeviceService.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    LogKt.err$default((Object) coroutineScope, str, (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.DeviceService$onChange$1.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to update status notification";
                        }
                    }, 4, (Object) null);
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            try {
                DeviceService deviceService = this.this$0;
                Application application = deviceService.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
                boolean isNightMode = NotificationUtils.isNightMode(application);
                this.L$0 = coroutineScope3;
                this.label = 1;
                Object formatDeviceSettingsString = UIUtility.getFormatDeviceSettingsString(deviceService, isNightMode, this);
                if (formatDeviceSettingsString == coroutineSingletons) {
                    return coroutineSingletons;
                }
                coroutineScope2 = coroutineScope3;
                obj = formatDeviceSettingsString;
            } catch (Exception e2) {
                coroutineScope = coroutineScope3;
                exc = e2;
                String str2 = DeviceService.TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                LogKt.err$default((Object) coroutineScope, str2, (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.DeviceService$onChange$1.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to update status notification";
                    }
                }, 4, (Object) null);
                return Unit.INSTANCE;
            }
        }
        NotificationCompat$Builder notificationCompat$Builder = this.$builder;
        Context applicationContext = this.this$0.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        NotificationUtils.setIconAndColor(notificationCompat$Builder, applicationContext);
        NotificationCompat$Builder notificationCompat$Builder2 = this.$builder;
        NotificationCompat$BigTextStyle notificationCompat$BigTextStyle = new NotificationCompat$BigTextStyle();
        notificationCompat$BigTextStyle.bigText((CharSequence) obj);
        notificationCompat$Builder2.setStyle(notificationCompat$BigTextStyle);
        notificationManager = this.this$0.getNotificationManager();
        notificationManager.notify(803, this.$builder.build());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceService$onChange$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
