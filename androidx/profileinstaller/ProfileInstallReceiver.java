package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.profileinstaller.ProfileInstaller;
import java.io.File;

/* loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    /* loaded from: classes.dex */
    public class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        public ResultDiagnostics() {
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public final void onDiagnosticReceived() {
            Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public final void onResultReceived(int r2, Object obj) {
            ProfileInstaller.LOG_DIAGNOSTICS.onResultReceived(r2, obj);
            ProfileInstallReceiver.this.setResultCode(r2);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            ProfileInstaller.writeProfile(context, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new ResultDiagnostics(), true);
            return;
        }
        boolean equals = "androidx.profileinstaller.action.SKIP_FILE".equals(action);
        ProfileInstaller.AnonymousClass2 anonymousClass2 = ProfileInstaller.LOG_DIAGNOSTICS;
        if (equals) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if ("WRITE_SKIP_FILE".equals(string)) {
                    try {
                        ProfileInstaller.noteProfileWrittenFor(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                        anonymousClass2.onResultReceived(10, null);
                        setResultCode(10);
                        return;
                    } catch (PackageManager.NameNotFoundException e) {
                        anonymousClass2.onResultReceived(7, e);
                        setResultCode(7);
                        return;
                    }
                }
                if ("DELETE_SKIP_FILE".equals(string)) {
                    new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                    anonymousClass2.onResultReceived(11, null);
                    setResultCode(11);
                    return;
                }
                return;
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            Process.sendSignal(Process.myPid(), 10);
            anonymousClass2.onResultReceived(12, null);
            setResultCode(12);
        } else if ("androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) && (extras = intent.getExtras()) != null) {
            if ("DROP_SHADER_CACHE".equals(extras.getString("EXTRA_BENCHMARK_OPERATION"))) {
                if (BenchmarkOperation.deleteFilesRecursively(context.createDeviceProtectedStorageContext().getCodeCacheDir())) {
                    anonymousClass2.onResultReceived(14, null);
                    setResultCode(14);
                    return;
                } else {
                    anonymousClass2.onResultReceived(15, null);
                    setResultCode(15);
                    return;
                }
            }
            anonymousClass2.onResultReceived(16, null);
            setResultCode(16);
        }
    }
}
