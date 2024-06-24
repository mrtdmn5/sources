package com.google.firebase.installations.local;

import com.amazonaws.services.s3.internal.Constants;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class PersistedInstallation {
    public File dataFile;
    public final FirebaseApp firebaseApp;

    /* loaded from: classes3.dex */
    public enum RegistrationStatus {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public PersistedInstallation(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    public final File getDataFile() {
        if (this.dataFile == null) {
            synchronized (this) {
                if (this.dataFile == null) {
                    FirebaseApp firebaseApp = this.firebaseApp;
                    firebaseApp.checkNotDeleted();
                    this.dataFile = new File(firebaseApp.applicationContext.getFilesDir(), "PersistedInstallation." + this.firebaseApp.getPersistenceKey() + ".json");
                }
            }
        }
        return this.dataFile;
    }

    public final void insertOrUpdatePersistedInstallationEntry(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", autoValue_PersistedInstallationEntry.firebaseInstallationId);
            jSONObject.put("Status", autoValue_PersistedInstallationEntry.registrationStatus.ordinal());
            jSONObject.put("AuthToken", autoValue_PersistedInstallationEntry.authToken);
            jSONObject.put("RefreshToken", autoValue_PersistedInstallationEntry.refreshToken);
            jSONObject.put("TokenCreationEpochInSecs", autoValue_PersistedInstallationEntry.tokenCreationEpochInSecs);
            jSONObject.put("ExpiresInSecs", autoValue_PersistedInstallationEntry.expiresInSecs);
            jSONObject.put("FisError", autoValue_PersistedInstallationEntry.fisError);
            FirebaseApp firebaseApp = this.firebaseApp;
            firebaseApp.checkNotDeleted();
            File createTempFile = File.createTempFile("PersistedInstallation", "tmp", firebaseApp.applicationContext.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes(Constants.DEFAULT_ENCODING));
            fileOutputStream.close();
            if (!createTempFile.renameTo(getDataFile())) {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
    }

    public final AutoValue_PersistedInstallationEntry readPersistedInstallationEntryValue() {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[DfuBaseService.ERROR_CONNECTION_MASK];
        try {
            FileInputStream fileInputStream = new FileInputStream(getDataFile());
            while (true) {
                try {
                    int read = fileInputStream.read(bArr, 0, DfuBaseService.ERROR_CONNECTION_MASK);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused) {
            jSONObject = new JSONObject();
        }
        String optString = jSONObject.optString("Fid", null);
        RegistrationStatus registrationStatus = RegistrationStatus.ATTEMPT_MIGRATION;
        int optInt = jSONObject.optInt("Status", registrationStatus.ordinal());
        String optString2 = jSONObject.optString("AuthToken", null);
        String optString3 = jSONObject.optString("RefreshToken", null);
        long optLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long optLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        String optString4 = jSONObject.optString("FisError", null);
        int r2 = PersistedInstallationEntry.$r8$clinit;
        AutoValue_PersistedInstallationEntry.Builder builder = new AutoValue_PersistedInstallationEntry.Builder();
        builder.tokenCreationEpochInSecs = 0L;
        builder.setRegistrationStatus(registrationStatus);
        builder.expiresInSecs = 0L;
        builder.firebaseInstallationId = optString;
        builder.setRegistrationStatus(RegistrationStatus.values()[optInt]);
        builder.authToken = optString2;
        builder.refreshToken = optString3;
        builder.tokenCreationEpochInSecs = Long.valueOf(optLong);
        builder.expiresInSecs = Long.valueOf(optLong2);
        builder.fisError = optString4;
        return builder.build();
    }
}
