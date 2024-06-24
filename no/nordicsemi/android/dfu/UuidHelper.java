package no.nordicsemi.android.dfu;

import android.content.Intent;
import android.os.ParcelUuid;
import android.os.Parcelable;
import java.util.UUID;

/* loaded from: classes4.dex */
class UuidHelper {
    public static void assignCustomUuids(Intent intent) {
        UUID r0;
        UUID r7;
        UUID r1;
        UUID r02;
        UUID r12;
        UUID r03;
        UUID r13;
        UUID r14;
        UUID r04;
        UUID r5;
        UUID r52;
        UUID r53;
        UUID r05;
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU);
        if (parcelableArrayExtra != null && parcelableArrayExtra.length == 4) {
            Parcelable parcelable = parcelableArrayExtra[0];
            if (parcelable != null) {
                r5 = ((ParcelUuid) parcelable).getUuid();
            } else {
                r5 = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            }
            LegacyDfuImpl.DFU_SERVICE_UUID = r5;
            Parcelable parcelable2 = parcelableArrayExtra[1];
            if (parcelable2 != null) {
                r52 = ((ParcelUuid) parcelable2).getUuid();
            } else {
                r52 = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            }
            LegacyDfuImpl.DFU_CONTROL_POINT_UUID = r52;
            Parcelable parcelable3 = parcelableArrayExtra[2];
            if (parcelable3 != null) {
                r53 = ((ParcelUuid) parcelable3).getUuid();
            } else {
                r53 = LegacyDfuImpl.DEFAULT_DFU_PACKET_UUID;
            }
            LegacyDfuImpl.DFU_PACKET_UUID = r53;
            Parcelable parcelable4 = parcelableArrayExtra[3];
            if (parcelable4 != null) {
                r05 = ((ParcelUuid) parcelable4).getUuid();
            } else {
                r05 = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
            }
            LegacyDfuImpl.DFU_VERSION_UUID = r05;
            LegacyButtonlessDfuImpl.DFU_SERVICE_UUID = LegacyDfuImpl.DFU_SERVICE_UUID;
            LegacyButtonlessDfuImpl.DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DFU_CONTROL_POINT_UUID;
            LegacyButtonlessDfuImpl.DFU_VERSION_UUID = LegacyDfuImpl.DFU_VERSION_UUID;
        } else {
            UUID r06 = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            LegacyDfuImpl.DFU_SERVICE_UUID = r06;
            UUID r54 = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            LegacyDfuImpl.DFU_CONTROL_POINT_UUID = r54;
            LegacyDfuImpl.DFU_PACKET_UUID = LegacyDfuImpl.DEFAULT_DFU_PACKET_UUID;
            UUID r6 = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
            LegacyDfuImpl.DFU_VERSION_UUID = r6;
            LegacyButtonlessDfuImpl.DFU_SERVICE_UUID = r06;
            LegacyButtonlessDfuImpl.DFU_CONTROL_POINT_UUID = r54;
            LegacyButtonlessDfuImpl.DFU_VERSION_UUID = r6;
        }
        Parcelable[] parcelableArrayExtra2 = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU);
        if (parcelableArrayExtra2 != null && parcelableArrayExtra2.length == 3) {
            Parcelable parcelable5 = parcelableArrayExtra2[0];
            if (parcelable5 != null) {
                r13 = ((ParcelUuid) parcelable5).getUuid();
            } else {
                r13 = SecureDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            }
            SecureDfuImpl.DFU_SERVICE_UUID = r13;
            Parcelable parcelable6 = parcelableArrayExtra2[1];
            if (parcelable6 != null) {
                r14 = ((ParcelUuid) parcelable6).getUuid();
            } else {
                r14 = SecureDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            }
            SecureDfuImpl.DFU_CONTROL_POINT_UUID = r14;
            Parcelable parcelable7 = parcelableArrayExtra2[2];
            if (parcelable7 != null) {
                r04 = ((ParcelUuid) parcelable7).getUuid();
            } else {
                r04 = SecureDfuImpl.DEFAULT_DFU_PACKET_UUID;
            }
            SecureDfuImpl.DFU_PACKET_UUID = r04;
        } else {
            SecureDfuImpl.DFU_SERVICE_UUID = SecureDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            SecureDfuImpl.DFU_CONTROL_POINT_UUID = SecureDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            SecureDfuImpl.DFU_PACKET_UUID = SecureDfuImpl.DEFAULT_DFU_PACKET_UUID;
        }
        Parcelable[] parcelableArrayExtra3 = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU);
        if (parcelableArrayExtra3 != null && parcelableArrayExtra3.length == 2) {
            Parcelable parcelable8 = parcelableArrayExtra3[0];
            if (parcelable8 != null) {
                r12 = ((ParcelUuid) parcelable8).getUuid();
            } else {
                r12 = ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID;
            }
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID = r12;
            Parcelable parcelable9 = parcelableArrayExtra3[1];
            if (parcelable9 != null) {
                r03 = ((ParcelUuid) parcelable9).getUuid();
            } else {
                r03 = ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_UUID;
            }
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_UUID = r03;
        } else {
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID = ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID;
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_UUID = ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_UUID;
        }
        Parcelable[] parcelableArrayExtra4 = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING);
        if (parcelableArrayExtra4 != null && parcelableArrayExtra4.length == 2) {
            Parcelable parcelable10 = parcelableArrayExtra4[0];
            if (parcelable10 != null) {
                r1 = ((ParcelUuid) parcelable10).getUuid();
            } else {
                r1 = ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
            }
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = r1;
            Parcelable parcelable11 = parcelableArrayExtra4[1];
            if (parcelable11 != null) {
                r02 = ((ParcelUuid) parcelable11).getUuid();
            } else {
                r02 = ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
            }
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_UUID = r02;
        } else {
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_UUID = ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
        }
        Parcelable[] parcelableArrayExtra5 = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING);
        if (parcelableArrayExtra5 != null && parcelableArrayExtra5.length == 2) {
            Parcelable parcelable12 = parcelableArrayExtra5[0];
            if (parcelable12 != null) {
                r0 = ((ParcelUuid) parcelable12).getUuid();
            } else {
                r0 = ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
            }
            ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = r0;
            Parcelable parcelable13 = parcelableArrayExtra5[1];
            if (parcelable13 != null) {
                r7 = ((ParcelUuid) parcelable13).getUuid();
            } else {
                r7 = ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
            }
            ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_UUID = r7;
            return;
        }
        ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
        ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_UUID = ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
    }
}
