package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.ProfileInstaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class DeviceProfileWriter {
    public final String mApkName;
    public final File mCurProfile;
    public final byte[] mDesiredVersion;
    public boolean mDeviceSupportsAotProfile = false;
    public final ProfileInstaller.DiagnosticsCallback mDiagnostics;
    public final Executor mExecutor;
    public DexProfileData[] mProfile;
    public byte[] mTranscodedProfile;

    public DeviceProfileWriter(AssetManager assetManager, Executor executor, ProfileInstaller.DiagnosticsCallback diagnosticsCallback, String str, File file) {
        byte[] bArr;
        this.mExecutor = executor;
        this.mDiagnostics = diagnosticsCallback;
        this.mApkName = str;
        this.mCurProfile = file;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 <= 33) {
            switch (r1) {
                case 24:
                case 25:
                    bArr = ProfileVersion.V001_N;
                    break;
                case 26:
                    bArr = ProfileVersion.V005_O;
                    break;
                case 27:
                    bArr = ProfileVersion.V009_O_MR1;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = ProfileVersion.V010_P;
                    break;
                case 31:
                case 32:
                case 33:
                    bArr = ProfileVersion.V015_S;
                    break;
            }
            this.mDesiredVersion = bArr;
        }
        bArr = null;
        this.mDesiredVersion = bArr;
    }

    public final FileInputStream openStreamFromAssets(AssetManager assetManager, String str) throws IOException {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message != null && message.contains("compressed")) {
                this.mDiagnostics.onDiagnosticReceived();
            }
            return null;
        }
    }

    public final void result(final int r2, final Serializable serializable) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.profileinstaller.DeviceProfileWriter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DeviceProfileWriter.this.mDiagnostics.onResultReceived(r2, serializable);
            }
        });
    }
}
