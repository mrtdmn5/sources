package com.animaconnected.secondo.app;

import android.companion.AssociationInfo;
import android.companion.CompanionDeviceService;
import android.net.MacAddress;
import com.animaconnected.logger.LogKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompanionService.kt */
/* loaded from: classes.dex */
public final class CompanionService extends CompanionDeviceService {
    public static final int $stable = 0;
    private final String tag = "CompanionService";

    public final String getTag() {
        return this.tag;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LogKt.info$default((Object) this, this.tag, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.CompanionService$onCreate$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onCreate";
            }
        }, 2, (Object) null);
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogKt.info$default((Object) this, this.tag, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.CompanionService$onDestroy$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onDestroy";
            }
        }, 2, (Object) null);
        super.onDestroy();
    }

    public void onDeviceAppeared(final String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        super.onDeviceAppeared(address);
        LogKt.info$default((Object) this, this.tag, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.CompanionService$onDeviceAppeared$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onDeviceAppeared: " + address;
            }
        }, 2, (Object) null);
        DeviceService.Companion.start(this);
    }

    public void onDeviceDisappeared(final String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        super.onDeviceDisappeared(address);
        LogKt.info$default((Object) this, this.tag, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.CompanionService$onDeviceDisappeared$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onDeviceDisappeared: " + address;
            }
        }, 2, (Object) null);
    }

    public void onDeviceDisappeared(final AssociationInfo associationInfo) {
        Intrinsics.checkNotNullParameter(associationInfo, "associationInfo");
        super.onDeviceDisappeared(associationInfo);
        LogKt.info$default((Object) this, this.tag, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.CompanionService$onDeviceDisappeared$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                MacAddress deviceMacAddress;
                StringBuilder sb = new StringBuilder("onDeviceDisappeared: (AssociationInfo): ");
                deviceMacAddress = associationInfo.getDeviceMacAddress();
                sb.append(deviceMacAddress);
                return sb.toString();
            }
        }, 2, (Object) null);
    }

    public void onDeviceAppeared(final AssociationInfo associationInfo) {
        Intrinsics.checkNotNullParameter(associationInfo, "associationInfo");
        super.onDeviceAppeared(associationInfo);
        LogKt.info$default((Object) this, this.tag, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.CompanionService$onDeviceAppeared$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                MacAddress deviceMacAddress;
                StringBuilder sb = new StringBuilder("onDeviceAppeared (AssociationInfo): ");
                deviceMacAddress = associationInfo.getDeviceMacAddress();
                sb.append(deviceMacAddress);
                return sb.toString();
            }
        }, 2, (Object) null);
    }
}
