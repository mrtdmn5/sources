package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.internal.Preconditions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class ProcessUtils {
    public static String zza;
    public static int zzb;

    public static String getMyProcessName() {
        String str;
        String str2;
        StrictMode.ThreadPolicy allowThreadDiskReads;
        if (zza == null) {
            int r1 = zzb;
            if (r1 == 0) {
                r1 = Process.myPid();
                zzb = r1;
            }
            String str3 = null;
            BufferedReader bufferedReader = null;
            BufferedReader bufferedReader2 = null;
            if (r1 > 0) {
                try {
                    str2 = "/proc/" + r1 + "/cmdline";
                    allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                } catch (IOException unused) {
                    str = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(new FileReader(str2));
                    try {
                        String readLine = bufferedReader3.readLine();
                        Preconditions.checkNotNull(readLine);
                        str = readLine.trim();
                    } catch (IOException unused2) {
                        str = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader3;
                        IOUtils.closeQuietly(bufferedReader2);
                        throw th;
                    }
                    bufferedReader = bufferedReader3;
                    IOUtils.closeQuietly(bufferedReader);
                    str3 = str;
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                }
            }
            zza = str3;
        }
        return zza;
    }
}
