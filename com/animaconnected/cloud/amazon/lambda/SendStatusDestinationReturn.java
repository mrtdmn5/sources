package com.animaconnected.cloud.amazon.lambda;

import com.animaconnected.cloud.util.CloudStatus;
import com.animaconnected.cloud.util.CloudStatusResponse;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SendStatusDestinationReturn {
    private Application application;
    private Device device;

    /* loaded from: classes.dex */
    public class Application {
        private String status;
        private String url;

        public Application() {
        }

        public String getStatus() {
            return this.status;
        }
    }

    /* loaded from: classes.dex */
    public class Device {
        private FWUpdate fwUpdate;
        private String status;

        /* loaded from: classes.dex */
        public class FWUpdate {
            private String itemId;
            private String region;
            private String revision;
            private String s3Bucket;
            private String s3Key;

            public FWUpdate() {
            }

            public String getItemId() {
                return this.itemId;
            }

            public String getRegion() {
                return this.region;
            }

            public String getRevision() {
                return this.revision;
            }

            public String getS3Bucket() {
                return this.s3Bucket;
            }

            public String getS3Key() {
                return this.s3Key;
            }
        }

        public Device() {
        }

        public FWUpdate getFwUpdate() {
            return this.fwUpdate;
        }

        public String getStatus() {
            return this.status;
        }
    }

    private CloudStatusResponse.STATUS_E getStatus(String str) {
        if (str == null) {
            return CloudStatusResponse.STATUS_E.UNKNOWN;
        }
        return CloudStatus.String2Status(str);
    }

    public CloudStatusResponse.STATUS_E getAppStatus() {
        return getStatus(this.application.getStatus());
    }

    public CloudStatusResponse.STATUS_E getDeviceStatus() {
        return getStatus(this.device.getStatus());
    }

    public Map<String, String> getDownloadInfo() {
        HashMap hashMap = new HashMap();
        Device.FWUpdate fwUpdate = this.device.getFwUpdate();
        if (fwUpdate != null) {
            hashMap.put("s3Bucket", fwUpdate.getS3Bucket());
            hashMap.put("s3Key", fwUpdate.getS3Key());
            hashMap.put("region", fwUpdate.getRegion());
        }
        return hashMap;
    }

    public String getItemId() {
        if (this.device.getFwUpdate() != null) {
            return this.device.getFwUpdate().getItemId();
        }
        return null;
    }

    public String getRevision() {
        if (this.device.getFwUpdate() != null) {
            return this.device.getFwUpdate().getRevision();
        }
        return null;
    }
}
