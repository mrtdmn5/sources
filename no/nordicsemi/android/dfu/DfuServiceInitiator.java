package no.nordicsemi.android.dfu;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.appcompat.widget.AppCompatTextHelper$$ExternalSyntheticApiModelOutline1;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import java.security.InvalidParameterException;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class DfuServiceInitiator {
    public static final int DEFAULT_MBR_SIZE = 4096;
    public static final int DEFAULT_PRN_VALUE = 12;
    public static final long DEFAULT_SCAN_TIMEOUT = 5000;
    public static final int SCOPE_APPLICATION = 2;
    public static final int SCOPE_SYSTEM_COMPONENTS = 1;
    private Parcelable[] buttonlessDfuWithBondSharingUuids;
    private Parcelable[] buttonlessDfuWithoutBondSharingUuids;
    private final String deviceAddress;
    private String deviceName;
    private Parcelable[] experimentalButtonlessDfuUuids;
    private String filePath;
    private int fileResId;
    private Uri fileUri;
    private String initFilePath;
    private int initFileResId;
    private Uri initFileUri;
    private boolean keepBond;
    private Parcelable[] legacyDfuUuids;
    private String mimeType;
    private Boolean packetReceiptNotificationsEnabled;
    private boolean restoreBond;
    private Parcelable[] secureDfuUuids;
    private boolean disableNotification = false;
    private boolean startAsForegroundService = true;
    private int fileType = -1;
    private boolean forceDfu = false;
    private boolean forceScanningForNewAddressInLegacyDfu = false;
    private boolean enableUnsafeExperimentalButtonlessDfu = false;
    private boolean disableResume = false;
    private int numberOfRetries = 0;
    private int mbrSize = 4096;
    private long dataObjectDelay = 0;
    private long rebootTime = 0;
    private long scanTimeout = DEFAULT_SCAN_TIMEOUT;
    private int numberOfPackets = 12;
    private int mtu = 517;
    private int currentMtu = 23;

    public DfuServiceInitiator(String str) {
        this.deviceAddress = str;
    }

    public static void createDfuNotificationChannel(Context context, String str, String str2, boolean z) {
        NotificationChannel m = AppCompatTextHelper$$ExternalSyntheticApiModelOutline1.m(str);
        m.setDescription(str2);
        m.setShowBadge(z);
        m.setLockscreenVisibility(1);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(m);
        }
    }

    private DfuServiceInitiator init(Uri uri, String str, int r5) {
        if (!DfuBaseService.MIME_TYPE_ZIP.equals(this.mimeType)) {
            this.initFileUri = uri;
            this.initFilePath = str;
            this.initFileResId = r5;
            return this;
        }
        throw new InvalidParameterException("Init file must be located inside the ZIP");
    }

    public DfuServiceInitiator disableMtuRequest() {
        this.mtu = 0;
        return this;
    }

    public DfuServiceInitiator disableResume() {
        this.disableResume = true;
        return this;
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int r7, Uri uri) {
        if (r7 != 0) {
            return init(uri, null, 0, r7, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    public DfuServiceInitiator setCurrentMtu(int r1) {
        this.currentMtu = r1;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForButtonlessDfuWithBondSharing(UUID r4, UUID r5) {
        ParcelUuid parcelUuid;
        ParcelUuid[] parcelUuidArr = new ParcelUuid[2];
        ParcelUuid parcelUuid2 = null;
        if (r4 != null) {
            parcelUuid = new ParcelUuid(r4);
        } else {
            parcelUuid = null;
        }
        parcelUuidArr[0] = parcelUuid;
        if (r5 != null) {
            parcelUuid2 = new ParcelUuid(r5);
        }
        parcelUuidArr[1] = parcelUuid2;
        this.buttonlessDfuWithBondSharingUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForButtonlessDfuWithoutBondSharing(UUID r4, UUID r5) {
        ParcelUuid parcelUuid;
        ParcelUuid[] parcelUuidArr = new ParcelUuid[2];
        ParcelUuid parcelUuid2 = null;
        if (r4 != null) {
            parcelUuid = new ParcelUuid(r4);
        } else {
            parcelUuid = null;
        }
        parcelUuidArr[0] = parcelUuid;
        if (r5 != null) {
            parcelUuid2 = new ParcelUuid(r5);
        }
        parcelUuidArr[1] = parcelUuid2;
        this.buttonlessDfuWithoutBondSharingUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForExperimentalButtonlessDfu(UUID r4, UUID r5) {
        ParcelUuid parcelUuid;
        ParcelUuid[] parcelUuidArr = new ParcelUuid[2];
        ParcelUuid parcelUuid2 = null;
        if (r4 != null) {
            parcelUuid = new ParcelUuid(r4);
        } else {
            parcelUuid = null;
        }
        parcelUuidArr[0] = parcelUuid;
        if (r5 != null) {
            parcelUuid2 = new ParcelUuid(r5);
        }
        parcelUuidArr[1] = parcelUuid2;
        this.experimentalButtonlessDfuUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForLegacyDfu(UUID r4, UUID r5, UUID r6, UUID r7) {
        ParcelUuid parcelUuid;
        ParcelUuid parcelUuid2;
        ParcelUuid parcelUuid3;
        ParcelUuid[] parcelUuidArr = new ParcelUuid[4];
        ParcelUuid parcelUuid4 = null;
        if (r4 != null) {
            parcelUuid = new ParcelUuid(r4);
        } else {
            parcelUuid = null;
        }
        parcelUuidArr[0] = parcelUuid;
        if (r5 != null) {
            parcelUuid2 = new ParcelUuid(r5);
        } else {
            parcelUuid2 = null;
        }
        parcelUuidArr[1] = parcelUuid2;
        if (r6 != null) {
            parcelUuid3 = new ParcelUuid(r6);
        } else {
            parcelUuid3 = null;
        }
        parcelUuidArr[2] = parcelUuid3;
        if (r7 != null) {
            parcelUuid4 = new ParcelUuid(r7);
        }
        parcelUuidArr[3] = parcelUuid4;
        this.legacyDfuUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForSecureDfu(UUID r4, UUID r5, UUID r6) {
        ParcelUuid parcelUuid;
        ParcelUuid parcelUuid2;
        ParcelUuid[] parcelUuidArr = new ParcelUuid[3];
        ParcelUuid parcelUuid3 = null;
        if (r4 != null) {
            parcelUuid = new ParcelUuid(r4);
        } else {
            parcelUuid = null;
        }
        parcelUuidArr[0] = parcelUuid;
        if (r5 != null) {
            parcelUuid2 = new ParcelUuid(r5);
        } else {
            parcelUuid2 = null;
        }
        parcelUuidArr[1] = parcelUuid2;
        if (r6 != null) {
            parcelUuid3 = new ParcelUuid(r6);
        }
        parcelUuidArr[2] = parcelUuid3;
        this.secureDfuUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setDeviceName(String str) {
        this.deviceName = str;
        return this;
    }

    public DfuServiceInitiator setDisableNotification(boolean z) {
        this.disableNotification = z;
        return this;
    }

    public DfuServiceInitiator setForceDfu(boolean z) {
        this.forceDfu = z;
        return this;
    }

    public DfuServiceInitiator setForceScanningForNewAddressInLegacyDfu(boolean z) {
        this.forceScanningForNewAddressInLegacyDfu = z;
        return this;
    }

    public DfuServiceInitiator setForeground(boolean z) {
        this.startAsForegroundService = z;
        return this;
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(Uri uri) {
        return init(uri, null, 0);
    }

    public DfuServiceInitiator setKeepBond(boolean z) {
        this.keepBond = z;
        return this;
    }

    public DfuServiceInitiator setMbrSize(int r1) {
        this.mbrSize = r1;
        return this;
    }

    public DfuServiceInitiator setMtu(int r1) {
        this.mtu = r1;
        return this;
    }

    public DfuServiceInitiator setNumberOfRetries(int r1) {
        this.numberOfRetries = r1;
        return this;
    }

    public DfuServiceInitiator setPacketsReceiptNotificationsEnabled(boolean z) {
        this.packetReceiptNotificationsEnabled = Boolean.valueOf(z);
        return this;
    }

    public DfuServiceInitiator setPacketsReceiptNotificationsValue(int r1) {
        if (r1 <= 0) {
            r1 = 12;
        }
        this.numberOfPackets = r1;
        return this;
    }

    public DfuServiceInitiator setPrepareDataObjectDelay(long j) {
        this.dataObjectDelay = j;
        return this;
    }

    public DfuServiceInitiator setRebootTime(long j) {
        this.rebootTime = j;
        return this;
    }

    public DfuServiceInitiator setRestoreBond(boolean z) {
        this.restoreBond = z;
        return this;
    }

    public DfuServiceInitiator setScanTimeout(long j) {
        this.scanTimeout = j;
        return this;
    }

    public DfuServiceInitiator setScope(int r3) {
        if (DfuBaseService.MIME_TYPE_ZIP.equals(this.mimeType)) {
            if (r3 == 2) {
                this.fileType = 4;
            } else if (r3 == 1) {
                this.fileType = 3;
            } else if (r3 == 3) {
                this.fileType = 0;
            } else {
                throw new UnsupportedOperationException("Unknown scope");
            }
            return this;
        }
        throw new UnsupportedOperationException("Scope can be set only for a ZIP file");
    }

    public DfuServiceInitiator setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(boolean z) {
        this.enableUnsafeExperimentalButtonlessDfu = z;
        return this;
    }

    public DfuServiceInitiator setZip(Uri uri) {
        return init(uri, null, 0, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    public DfuServiceController start(Context context, Class<? extends DfuBaseService> cls) {
        if (this.fileType != -1) {
            Intent intent = new Intent(context, cls);
            intent.putExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS, this.deviceAddress);
            intent.putExtra(DfuBaseService.EXTRA_DEVICE_NAME, this.deviceName);
            intent.putExtra(DfuBaseService.EXTRA_DISABLE_NOTIFICATION, this.disableNotification);
            intent.putExtra(DfuBaseService.EXTRA_FOREGROUND_SERVICE, this.startAsForegroundService);
            intent.putExtra(DfuBaseService.EXTRA_FILE_MIME_TYPE, this.mimeType);
            intent.putExtra(DfuBaseService.EXTRA_FILE_TYPE, this.fileType);
            intent.putExtra(DfuBaseService.EXTRA_FILE_URI, this.fileUri);
            intent.putExtra(DfuBaseService.EXTRA_FILE_PATH, this.filePath);
            intent.putExtra(DfuBaseService.EXTRA_FILE_RES_ID, this.fileResId);
            intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_URI, this.initFileUri);
            intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_PATH, this.initFilePath);
            intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_RES_ID, this.initFileResId);
            intent.putExtra(DfuBaseService.EXTRA_KEEP_BOND, this.keepBond);
            intent.putExtra(DfuBaseService.EXTRA_RESTORE_BOND, this.restoreBond);
            intent.putExtra(DfuBaseService.EXTRA_FORCE_DFU, this.forceDfu);
            intent.putExtra(DfuBaseService.EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU, this.forceScanningForNewAddressInLegacyDfu);
            intent.putExtra(DfuBaseService.EXTRA_DISABLE_RESUME, this.disableResume);
            intent.putExtra(DfuBaseService.EXTRA_MAX_DFU_ATTEMPTS, this.numberOfRetries);
            intent.putExtra(DfuBaseService.EXTRA_MBR_SIZE, this.mbrSize);
            intent.putExtra(DfuBaseService.EXTRA_DATA_OBJECT_DELAY, this.dataObjectDelay);
            intent.putExtra(DfuBaseService.EXTRA_SCAN_TIMEOUT, this.scanTimeout);
            intent.putExtra(DfuBaseService.EXTRA_SCAN_DELAY, this.rebootTime);
            int r5 = this.mtu;
            if (r5 > 0) {
                intent.putExtra(DfuBaseService.EXTRA_MTU, r5);
            }
            intent.putExtra(DfuBaseService.EXTRA_CURRENT_MTU, this.currentMtu);
            intent.putExtra(DfuBaseService.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU, this.enableUnsafeExperimentalButtonlessDfu);
            Boolean bool = this.packetReceiptNotificationsEnabled;
            if (bool != null) {
                intent.putExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED, bool);
                intent.putExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE, this.numberOfPackets);
            }
            Parcelable[] parcelableArr = this.legacyDfuUuids;
            if (parcelableArr != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU, parcelableArr);
            }
            Parcelable[] parcelableArr2 = this.secureDfuUuids;
            if (parcelableArr2 != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU, parcelableArr2);
            }
            Parcelable[] parcelableArr3 = this.experimentalButtonlessDfuUuids;
            if (parcelableArr3 != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU, parcelableArr3);
            }
            Parcelable[] parcelableArr4 = this.buttonlessDfuWithoutBondSharingUuids;
            if (parcelableArr4 != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING, parcelableArr4);
            }
            Parcelable[] parcelableArr5 = this.buttonlessDfuWithBondSharingUuids;
            if (parcelableArr5 != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING, parcelableArr5);
            }
            if (Build.VERSION.SDK_INT >= 26 && this.startAsForegroundService) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
            return new DfuServiceController(context);
        }
        throw new UnsupportedOperationException("You must specify the firmware file before starting the service");
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(String str) {
        return init(null, str, 0);
    }

    public DfuServiceInitiator setZip(String str) {
        return init(null, str, 0, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int r7, String str) {
        if (r7 != 0) {
            return init(null, str, 0, r7, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(int r2) {
        return init(null, null, r2);
    }

    public DfuServiceInitiator setZip(int r7) {
        return init(null, null, r7, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(Uri uri, String str) {
        return init(uri, str, 0);
    }

    public DfuServiceInitiator setZip(Uri uri, String str) {
        return init(uri, str, 0, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int r7, Uri uri, String str) {
        if (r7 != 0) {
            return init(uri, str, 0, r7, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    private DfuServiceInitiator init(Uri uri, String str, int r3, int r4, String str2) {
        this.fileUri = uri;
        this.filePath = str;
        this.fileResId = r3;
        this.fileType = r4;
        this.mimeType = str2;
        if (DfuBaseService.MIME_TYPE_ZIP.equals(str2)) {
            this.initFileUri = null;
            this.initFilePath = null;
            this.initFileResId = 0;
        }
        return this;
    }

    public static void createDfuNotificationChannel(Context context) {
        createDfuNotificationChannel(context, context.getString(R.string.dfu_channel_name), context.getString(R.string.dfu_channel_description), false);
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int r7, int r8) {
        if (r7 != 0) {
            return init(null, null, r8, r7, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }
}
