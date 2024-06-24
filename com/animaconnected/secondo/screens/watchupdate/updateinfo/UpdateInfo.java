package com.animaconnected.secondo.screens.watchupdate.updateinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.animaconnected.watch.DeviceInterface;
import com.animaconnected.watch.device.FirmwareUpdate;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdateInfo.kt */
/* loaded from: classes3.dex */
public final class UpdateInfo implements DeviceInterface.FirmwareInfoListener {
    public static final int $stable = 8;
    private final UpdateInfoStorage storage;

    /* compiled from: UpdateInfo.kt */
    @SuppressLint({"CommitPrefEdits"})
    /* loaded from: classes3.dex */
    public final class UpdateInfoStorage {
        private final String keyDownloadedFirmwareRevision;
        private final String keyNewFirmwareRevision;
        private final String keyPreviousFirmwareRevision;
        private final SharedPreferences prefs;
        final /* synthetic */ UpdateInfo this$0;
        private final String updateInfoStorage;

        public UpdateInfoStorage(UpdateInfo updateInfo, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = updateInfo;
            this.updateInfoStorage = "updateInfo";
            this.keyPreviousFirmwareRevision = "previousFirmwareRevision";
            this.keyNewFirmwareRevision = "newFirmwareRevision";
            this.keyDownloadedFirmwareRevision = "downloadedFirmwareRevision";
            SharedPreferences sharedPreferences = context.getSharedPreferences("updateInfo", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            this.prefs = sharedPreferences;
        }

        public final String getDownloadedFirmwareRevision() {
            return this.prefs.getString(this.keyDownloadedFirmwareRevision, null);
        }

        public final String getNewFirmwareRevision() {
            return this.prefs.getString(this.keyNewFirmwareRevision, null);
        }

        public final SharedPreferences getPrefs() {
            return this.prefs;
        }

        public final String getPreviousFirmwareRevision() {
            return this.prefs.getString(this.keyPreviousFirmwareRevision, null);
        }

        public final void setDownloadedFirmwareRevision(String str) {
            this.prefs.edit().putString(this.keyDownloadedFirmwareRevision, str).apply();
        }

        public final void setNewFirmwareRevision(String str) {
            this.prefs.edit().putString(this.keyNewFirmwareRevision, str).apply();
        }

        public final void setPreviousFirmwareRevision(String str) {
            this.prefs.edit().putString(this.keyPreviousFirmwareRevision, str).apply();
        }
    }

    public UpdateInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.storage = new UpdateInfoStorage(this, context);
    }

    public final void clearInfo() {
        this.storage.setNewFirmwareRevision(null);
        this.storage.setPreviousFirmwareRevision(null);
    }

    public final List<Update> getCompletedUpdates(FirmwareUpdate firmwareUpdate) {
        Date firmwareRevisionToDate = UpdateHelper.firmwareRevisionToDate(this.storage.getNewFirmwareRevision());
        List<Update> updatesBetweenDates = UpdateHelper.getUpdatesBetweenDates(Update.Companion.getUpdates(firmwareUpdate), UpdateHelper.firmwareRevisionToDate(this.storage.getPreviousFirmwareRevision()), firmwareRevisionToDate);
        Intrinsics.checkNotNullExpressionValue(updatesBetweenDates, "getUpdatesBetweenDates(...)");
        return updatesBetweenDates;
    }

    public final List<Update> getDownloadedUpdates(String str, FirmwareUpdate firmwareUpdate) {
        List<Update> updatesBetweenDates = UpdateHelper.getUpdatesBetweenDates(Update.Companion.getUpdates(firmwareUpdate), UpdateHelper.firmwareRevisionToDate(str), UpdateHelper.firmwareRevisionToDate(this.storage.getDownloadedFirmwareRevision()));
        Intrinsics.checkNotNullExpressionValue(updatesBetweenDates, "getUpdatesBetweenDates(...)");
        return updatesBetweenDates;
    }

    public final boolean hasUpdateCompletedInfo() {
        if (this.storage.getNewFirmwareRevision() != null) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.DeviceInterface.FirmwareInfoListener
    public void onFirmwareChanged(String str, String str2, boolean z) {
        if (z) {
            this.storage.setNewFirmwareRevision(str2);
            this.storage.setPreviousFirmwareRevision(str);
        }
    }

    public final void setDownloadedFirmwareRevision(String str) {
        this.storage.setDownloadedFirmwareRevision(str);
    }
}
