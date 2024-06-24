package com.google.android.gms.auth.api.signin.internal;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
/* loaded from: classes3.dex */
public final class zbb implements Runnable {
    public static final Logger zba = new Logger("RevokeAccessOperation", new String[0]);
    public final String zbb;
    public final StatusPendingResult zbc;

    public zbb(String str) {
        Preconditions.checkNotEmpty(str);
        this.zbb = str;
        this.zbc = new StatusPendingResult(null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Logger logger = zba;
        Status status = Status.RESULT_INTERNAL_ERROR;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/revoke?token=" + this.zbb).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.RESULT_SUCCESS;
            } else {
                logger.getClass();
                Log.e(logger.zza, logger.zzb.concat("Unable to revoke access!"));
            }
            logger.d("Response Code: " + responseCode, new Object[0]);
        } catch (IOException e) {
            String concat = "IOException when revoking access: ".concat(String.valueOf(e.toString()));
            logger.getClass();
            Log.e(logger.zza, logger.zzb.concat(concat));
        } catch (Exception e2) {
            String concat2 = "Exception when revoking access: ".concat(String.valueOf(e2.toString()));
            logger.getClass();
            Log.e(logger.zza, logger.zzb.concat(concat2));
        }
        this.zbc.setResult((StatusPendingResult) status);
    }
}
