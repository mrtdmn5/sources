package com.animaconnected.cloud.util;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import java.util.Map;

/* loaded from: classes.dex */
public class CloudStatusResponse {
    private final STATUS_E mAppStatus;
    private final Map<String, String> mDeviceDownloadInfo;
    private final String mDeviceRevision;
    private final STATUS_E mDeviceStatus;
    private final String mItemId;

    /* loaded from: classes.dex */
    public enum STATUS_E {
        LATEST,
        UPDATE_AVAILABLE,
        UPDATE_REQUIRED,
        UNSUPPORTED,
        EOL,
        UNKNOWN
    }

    public CloudStatusResponse(STATUS_E status_e, STATUS_E status_e2, Map<String, String> map, String str, String str2) {
        this.mAppStatus = status_e;
        this.mDeviceStatus = status_e2;
        this.mDeviceDownloadInfo = map;
        this.mDeviceRevision = str;
        this.mItemId = str2;
    }

    public STATUS_E getAppStatus() {
        return this.mAppStatus;
    }

    public Map<String, String> getDeviceDownloadInfo() {
        return this.mDeviceDownloadInfo;
    }

    public String getDeviceFWRevision() {
        return this.mDeviceRevision;
    }

    public STATUS_E getDeviceStatus() {
        return this.mDeviceStatus;
    }

    public String getItemId() {
        return this.mItemId;
    }

    public void selectUpdateZip(String str) {
        String str2;
        Map<String, String> map = this.mDeviceDownloadInfo;
        if (map != null && (str2 = map.get("s3Key")) != null) {
            this.mDeviceDownloadInfo.put("s3Key", str2.replace("update.zip", str));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CloudStatusResponse {mAppStatus: ");
        sb.append(this.mAppStatus);
        sb.append(" mDeviceStatus: ");
        sb.append(this.mDeviceStatus);
        sb.append(" mDeviceDownloadInfo: {");
        for (Map.Entry<String, String> entry : this.mDeviceDownloadInfo.entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            sb.append(entry.getValue());
            sb.append(" ");
        }
        sb.append("} mDeviceRevision: ");
        sb.append(this.mDeviceRevision);
        sb.append(" mItemId: ");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.mItemId, "}");
    }
}
