package com.animaconnected.watch.device.diagnostics;

import com.animaconnected.watch.device.CrashStatus;
import com.animaconnected.watch.device.CrashStatus$$serializer;
import com.google.android.gms.tasks.zzac;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DiagnosticsBaseItem.kt */
@Serializable
/* loaded from: classes3.dex */
public class DiagnosticsBaseItem {
    public static final Companion Companion = new Companion(null);
    private final String appVersion;
    private final ArrayList<DiagnosticsBinaryData> binaries;
    private final CrashStatus crashStatus;
    private final String date;
    private final String device;
    private final String deviceItemId;
    private final String serialnumber;
    private final String sha1;
    private final String type;
    private final String watch;

    /* compiled from: DiagnosticsBaseItem.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<DiagnosticsBaseItem> serializer() {
            return DiagnosticsBaseItem$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ DiagnosticsBaseItem(int r2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CrashStatus crashStatus, SerializationConstructorMarker serializationConstructorMarker) {
        if (511 != (r2 & 511)) {
            zzac.throwMissingFieldException(r2, 511, DiagnosticsBaseItem$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.date = str;
        this.device = str2;
        this.serialnumber = str3;
        this.watch = str4;
        this.sha1 = str5;
        this.type = str6;
        this.deviceItemId = str7;
        this.appVersion = str8;
        this.crashStatus = crashStatus;
        this.binaries = new ArrayList<>();
    }

    public static final /* synthetic */ void write$Self(DiagnosticsBaseItem diagnosticsBaseItem, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeStringElement(serialDescriptor, 0, diagnosticsBaseItem.date);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, diagnosticsBaseItem.device);
        compositeEncoder.encodeStringElement(serialDescriptor, 2, diagnosticsBaseItem.serialnumber);
        compositeEncoder.encodeStringElement(serialDescriptor, 3, diagnosticsBaseItem.watch);
        compositeEncoder.encodeStringElement(serialDescriptor, 4, diagnosticsBaseItem.sha1);
        compositeEncoder.encodeStringElement(serialDescriptor, 5, diagnosticsBaseItem.type);
        compositeEncoder.encodeStringElement(serialDescriptor, 6, diagnosticsBaseItem.deviceItemId);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, diagnosticsBaseItem.appVersion);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, CrashStatus$$serializer.INSTANCE, diagnosticsBaseItem.crashStatus);
    }

    public final void addBinary(DiagnosticsBinaryData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.binaries.add(data);
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final ArrayList<DiagnosticsBinaryData> getBinaries() {
        return this.binaries;
    }

    public final CrashStatus getCrashStatus() {
        return this.crashStatus;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getDevice() {
        return this.device;
    }

    public final String getDeviceItemId() {
        return this.deviceItemId;
    }

    public final String getSerialnumber() {
        return this.serialnumber;
    }

    public final String getSha1() {
        return this.sha1;
    }

    public final String getType() {
        return this.type;
    }

    public final String getWatch() {
        return this.watch;
    }

    public DiagnosticsBaseItem(String date, String device, String serialnumber, String watch, String sha1, String type, String deviceItemId, String str, CrashStatus crashStatus) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(serialnumber, "serialnumber");
        Intrinsics.checkNotNullParameter(watch, "watch");
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(deviceItemId, "deviceItemId");
        this.date = date;
        this.device = device;
        this.serialnumber = serialnumber;
        this.watch = watch;
        this.sha1 = sha1;
        this.type = type;
        this.deviceItemId = deviceItemId;
        this.appVersion = str;
        this.crashStatus = crashStatus;
        this.binaries = new ArrayList<>();
    }

    public static /* synthetic */ void getAppVersion$annotations() {
    }

    public static /* synthetic */ void getBinaries$annotations() {
    }

    public static /* synthetic */ void getCrashStatus$annotations() {
    }

    public static /* synthetic */ void getDeviceItemId$annotations() {
    }
}
