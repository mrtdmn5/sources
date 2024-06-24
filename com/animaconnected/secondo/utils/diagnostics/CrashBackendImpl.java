package com.animaconnected.secondo.utils.diagnostics;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat$Builder;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.future.FailCallback;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.info.ByteUtils;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.animaconnected.watch.device.CrashBackend;
import com.animaconnected.watch.device.CrashFile;
import com.animaconnected.watch.device.diagnostics.DiagnosticsBinaryData;
import com.animaconnected.watch.utils.WatchLibException;
import com.animaconnected.watch.utils.WatchLibResult;
import com.kronaby.watch.app.R;
import j$.time.format.DateTimeFormatter;
import java.io.File;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: CrashBackendImpl.kt */
/* loaded from: classes3.dex */
public final class CrashBackendImpl implements CrashBackend {
    public static final int $stable = 8;
    private final Context context;
    private final String tag;

    public CrashBackendImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        String simpleName = Reflection.getOrCreateKotlinClass(CrashBackendImpl.class).getSimpleName();
        this.tag = simpleName == null ? "CrashBackendImpl" : simpleName;
    }

    private final String crashDir(Context context) {
        return context.getDir("crash_dump", 0).getPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WatchLibResult.Failure<Unit, WatchLibException> failResult(String str) {
        return new WatchLibResult.Failure<>(WatchLibException.Companion.getDefaultErrorException(str));
    }

    private final void showCrashNotification(Context context, String str, CrashFile crashFile, boolean z) {
        NotificationManager notificationManager;
        Object systemService = context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        if (systemService instanceof NotificationManager) {
            notificationManager = (NotificationManager) systemService;
        } else {
            notificationManager = null;
        }
        if (notificationManager == null) {
            return;
        }
        LocalDateTime localDate = crashFile.getLocalDate();
        TimeZone.Companion.getClass();
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(TimeZoneKt.toInstant(localDate, TimeZone.UTC), TimeZone.Companion.currentSystemDefault());
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd");
        j$.time.LocalDateTime localDateTime2 = localDateTime.value;
        String format = localDateTime2.format(ofPattern);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("vnd.android.cursor.dir/email");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"slask@festina.com"});
        intent.putExtra("android.intent.extra.SUBJECT", context.getString(R.string.notification_crash_email_subject));
        intent.putExtra("android.intent.extra.TEXT", context.getString(R.string.notification_crash_email_description, format, str, Boolean.valueOf(z)));
        intent.setFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, AppUtils.getPendingIntentFlag());
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(context, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setContentTitle(context.getString(R.string.notification_crash_title, format));
        createNotificationBuilder.setContentText(context.getString(R.string.notification_crash_description));
        createNotificationBuilder.mContentIntent = activity;
        createNotificationBuilder.setFlag(16, true);
        notificationManager.notify(localDateTime2.getMinute() + (localDateTime2.getHour() * 100) + 235230000, createNotificationBuilder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WatchLibResult.Success<Unit, WatchLibException> successResult() {
        return new WatchLibResult.Success<>(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadStoredCrashes$lambda$0(CrashBackendImpl this$0, CrashFile crashFile, File file, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(crashFile, "$crashFile");
        if (RemoteConfigController.Companion.getInstance(this$0.context).getCrashNotificationEnable()) {
            Context context = this$0.context;
            if (str == null) {
                str = "<missing>";
            }
            this$0.showCrashNotification(context, str, crashFile, ProviderFactory.getWatch().isRunningFota());
        }
        file.delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadStoredCrashes$lambda$1(CrashBackendImpl this$0, Throwable th) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LogKt.debug$default((Object) this$0, "Failed saving crash file in cloud.", this$0.tag, th, false, 8, (Object) null);
    }

    @Override // com.animaconnected.watch.device.CrashBackend
    public String calculateSha1(String seed) {
        Intrinsics.checkNotNullParameter(seed, "seed");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            Charset defaultCharset = Charset.defaultCharset();
            Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset(...)");
            byte[] bytes = seed.getBytes(defaultCharset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            Intrinsics.checkNotNull(digest);
            return ByteUtils.toHex(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getTag() {
        return this.tag;
    }

    @Override // com.animaconnected.watch.device.CrashBackend
    public Object storeCrashFiles(List<DiagnosticsBinaryData> list, CrashFile crashFile, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new CrashBackendImpl$storeCrashFiles$2(crashDir(this.context) + '/' + crashFile.getFileName(), this, list, null), continuation);
    }

    @Override // com.animaconnected.watch.device.CrashBackend
    public Object uploadStoredCrashes(Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        File file = new File(crashDir(this.context));
        if (!file.isDirectory()) {
            return failResult("Missing crash dir");
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return failResult("Failed to read files on crash dir");
        }
        for (final File file2 : listFiles) {
            if (file2.isFile()) {
                String name = file2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (StringsKt__StringsJVMKt.endsWith(name, ".zip", false)) {
                    CrashFile.Companion companion = CrashFile.Companion;
                    String name2 = file2.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    final CrashFile fromFileName = companion.fromFileName(name2);
                    if (fromFileName != null) {
                        LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.diagnostics.CrashBackendImpl$uploadStoredCrashes$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Uploading " + file2.getName() + " to S3 bucket";
                            }
                        }, 6, (Object) null);
                        ProviderFactory.getCloudProvider().uploadDeviceCrash(file2, fromFileName.getS3UploadUrl()).success(new SuccessCallback() { // from class: com.animaconnected.secondo.utils.diagnostics.CrashBackendImpl$$ExternalSyntheticLambda0
                            @Override // com.animaconnected.future.SuccessCallback
                            public final void onSuccess(Object obj) {
                                CrashBackendImpl.uploadStoredCrashes$lambda$0(CrashBackendImpl.this, fromFileName, file2, (String) obj);
                            }
                        }).fail(new FailCallback() { // from class: com.animaconnected.secondo.utils.diagnostics.CrashBackendImpl$$ExternalSyntheticLambda1
                            @Override // com.animaconnected.future.FailCallback
                            public final void onFail(Throwable th) {
                                CrashBackendImpl.uploadStoredCrashes$lambda$1(CrashBackendImpl.this, th);
                            }
                        });
                    }
                }
            }
        }
        return successResult();
    }
}
