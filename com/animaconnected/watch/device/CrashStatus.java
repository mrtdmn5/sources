package com.animaconnected.watch.device;

import com.animaconnected.info.ByteUtils;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CrashStatus.kt */
@Serializable
/* loaded from: classes3.dex */
public final class CrashStatus {
    public static final Companion Companion = new Companion(null);
    private AppInfo appInfo;
    private int hw_reason;
    private Registers registers;
    private boolean remoteCrash;
    private String timestamp;
    private String type;

    /* compiled from: CrashStatus.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class AppInfo {
        public static final Companion Companion = new Companion(null);
        private long errorCode;
        private String errorCodeString;
        private String filename;
        private int lineNumber;
        private int sP;
        private String sPString;

        /* compiled from: CrashStatus.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<AppInfo> serializer() {
                return CrashStatus$AppInfo$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public AppInfo() {
        }

        public static final /* synthetic */ void write$Self$watch_release(AppInfo appInfo, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4 = false;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || appInfo.filename != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, appInfo.filename);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || appInfo.lineNumber != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                compositeEncoder.encodeIntElement(1, appInfo.lineNumber, serialDescriptor);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || appInfo.errorCodeString != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, appInfo.errorCodeString);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || appInfo.sPString != null) {
                z4 = true;
            }
            if (z4) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, appInfo.sPString);
            }
        }

        public final long getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorCodeString() {
            return this.errorCodeString;
        }

        public final String getFilename() {
            return this.filename;
        }

        public final int getLineNumber() {
            return this.lineNumber;
        }

        public final int getSP() {
            return this.sP;
        }

        public final String getSPString() {
            return this.sPString;
        }

        public final void setErrorCode(long j) {
            this.errorCode = j;
            CharsKt__CharKt.checkRadix(16);
            String l = Long.toString(j, 16);
            Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
            this.errorCodeString = "0x".concat(l);
        }

        public final void setFilename(String str) {
            this.filename = str;
        }

        public final void setLineNumber(int r1) {
            this.lineNumber = r1;
        }

        public final void setSP(int r2) {
            this.sP = r2;
            this.sPString = CrashStatus.Companion.intToAddress(r2);
        }

        public String toString() {
            String trimMargin;
            trimMargin = StringsKt__IndentKt.trimMargin("  AppInfo(\n                |    filename=" + this.filename + ", lineNumber=" + this.lineNumber + ", \n                |    errorCode=" + this.errorCode + ", errorCodeString='" + this.errorCodeString + "', \n                |    sP=" + this.sP + ", sPString='" + this.sPString + "')", "|");
            return trimMargin;
        }

        public /* synthetic */ AppInfo(int r3, String str, int r5, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if ((r3 & 0) != 0) {
                zzac.throwMissingFieldException(r3, 0, CrashStatus$AppInfo$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            if ((r3 & 1) == 0) {
                this.filename = null;
            } else {
                this.filename = str;
            }
            if ((r3 & 2) == 0) {
                this.lineNumber = 0;
            } else {
                this.lineNumber = r5;
            }
            if ((r3 & 4) == 0) {
                this.errorCodeString = null;
            } else {
                this.errorCodeString = str2;
            }
            this.errorCode = 0L;
            if ((r3 & 8) == 0) {
                this.sPString = null;
            } else {
                this.sPString = str3;
            }
            this.sP = 0;
        }

        public static /* synthetic */ void getErrorCode$annotations() {
        }

        public static /* synthetic */ void getErrorCodeString$annotations() {
        }

        public static /* synthetic */ void getLineNumber$annotations() {
        }

        public static /* synthetic */ void getSP$annotations() {
        }

        public static /* synthetic */ void getSPString$annotations() {
        }
    }

    /* compiled from: CrashStatus.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String intToAddress(int r2) {
            return ByteUtils.toHexString(r2, 8);
        }

        public final KSerializer<CrashStatus> serializer() {
            return CrashStatus$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* compiled from: CrashStatus.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class Registers {
        public static final Companion Companion = new Companion(null);
        private int lr;
        private String lrString;
        private int pc;
        private String pcString;
        private int psr;
        private String psrString;
        private int r0;
        private String r0String;
        private int r1;
        private int r12;
        private String r12String;
        private String r1String;
        private int r2;
        private String r2String;
        private int r3;
        private String r3String;
        private String sPString;
        private int sp;

        /* compiled from: CrashStatus.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Registers> serializer() {
                return CrashStatus$Registers$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public Registers() {
        }

        public static final /* synthetic */ void write$Self$watch_release(Registers registers, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9 = false;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || registers.r0String != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, registers.r0String);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || registers.r1String != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, registers.r1String);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || registers.r2String != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, registers.r2String);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || registers.r3String != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, registers.r3String);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || registers.r12String != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, registers.r12String);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || registers.sPString != null) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, registers.sPString);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || registers.lrString != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, registers.lrString);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || registers.pcString != null) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, registers.pcString);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || registers.psrString != null) {
                z9 = true;
            }
            if (z9) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, registers.psrString);
            }
        }

        public final int getLr() {
            return this.lr;
        }

        public final String getLrString() {
            return this.lrString;
        }

        public final int getPc() {
            return this.pc;
        }

        public final String getPcString() {
            return this.pcString;
        }

        public final int getPsr() {
            return this.psr;
        }

        public final String getPsrString() {
            return this.psrString;
        }

        public final int getR0() {
            return this.r0;
        }

        public final String getR0String() {
            return this.r0String;
        }

        public final int getR1() {
            return this.r1;
        }

        public final int getR12() {
            return this.r12;
        }

        public final String getR12String() {
            return this.r12String;
        }

        public final String getR1String() {
            return this.r1String;
        }

        public final int getR2() {
            return this.r2;
        }

        public final String getR2String() {
            return this.r2String;
        }

        public final int getR3() {
            return this.r3;
        }

        public final String getR3String() {
            return this.r3String;
        }

        public final String getSPString() {
            return this.sPString;
        }

        public final int getSp() {
            return this.sp;
        }

        public final void setLr(int r2) {
            this.lr = r2;
            this.lrString = CrashStatus.Companion.intToAddress(r2);
        }

        public final void setPc(int r2) {
            this.pc = r2;
            this.pcString = CrashStatus.Companion.intToAddress(r2);
        }

        public final void setPsr(int r2) {
            this.psr = r2;
            this.psrString = CrashStatus.Companion.intToAddress(r2);
        }

        public final void setR0(int r2) {
            this.r0 = r2;
            this.r0String = CrashStatus.Companion.intToAddress(r2);
        }

        public final void setR1(int r2) {
            this.r1 = r2;
            this.r1String = CrashStatus.Companion.intToAddress(r2);
        }

        public final void setR12(int r2) {
            this.r12 = r2;
            this.r12String = CrashStatus.Companion.intToAddress(r2);
        }

        public final void setR2(int r2) {
            this.r2 = r2;
            this.r2String = CrashStatus.Companion.intToAddress(r2);
        }

        public final void setR3(int r2) {
            this.r3 = r2;
            this.r3String = CrashStatus.Companion.intToAddress(r2);
        }

        public final void setSp(int r2) {
            this.sp = r2;
            this.sPString = CrashStatus.Companion.intToAddress(r2);
        }

        public String toString() {
            String trimMargin;
            trimMargin = StringsKt__IndentKt.trimMargin("  Registers(\n                |    r0=" + this.r0 + ", r0String='" + this.r0String + "', r1=" + this.r1 + ", r1String='" + this.r1String + "', r2=" + this.r2 + ", r2String='" + this.r2String + "',\n                |    r3=" + this.r3 + ", r3String='" + this.r3String + "', r12=" + this.r12 + ", r12String='" + this.r12String + "', \n                |    sp=" + this.sp + ", sPString='" + this.sPString + "', lr=" + this.lr + ", lrString='" + this.lrString + "', \n                |    pc=" + this.pc + ", pcString='" + this.pcString + "', psr=" + this.psr + ", psrString='" + this.psrString + "')", "|");
            return trimMargin;
        }

        public /* synthetic */ Registers(int r3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, SerializationConstructorMarker serializationConstructorMarker) {
            if ((r3 & 0) != 0) {
                zzac.throwMissingFieldException(r3, 0, CrashStatus$Registers$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            if ((r3 & 1) == 0) {
                this.r0String = null;
            } else {
                this.r0String = str;
            }
            this.r0 = 0;
            if ((r3 & 2) == 0) {
                this.r1String = null;
            } else {
                this.r1String = str2;
            }
            this.r1 = 0;
            if ((r3 & 4) == 0) {
                this.r2String = null;
            } else {
                this.r2String = str3;
            }
            this.r2 = 0;
            if ((r3 & 8) == 0) {
                this.r3String = null;
            } else {
                this.r3String = str4;
            }
            this.r3 = 0;
            if ((r3 & 16) == 0) {
                this.r12String = null;
            } else {
                this.r12String = str5;
            }
            this.r12 = 0;
            if ((r3 & 32) == 0) {
                this.sPString = null;
            } else {
                this.sPString = str6;
            }
            this.sp = 0;
            if ((r3 & 64) == 0) {
                this.lrString = null;
            } else {
                this.lrString = str7;
            }
            this.lr = 0;
            if ((r3 & 128) == 0) {
                this.pcString = null;
            } else {
                this.pcString = str8;
            }
            this.pc = 0;
            if ((r3 & 256) == 0) {
                this.psrString = null;
            } else {
                this.psrString = str9;
            }
            this.psr = 0;
        }

        public static /* synthetic */ void getLr$annotations() {
        }

        public static /* synthetic */ void getLrString$annotations() {
        }

        public static /* synthetic */ void getPc$annotations() {
        }

        public static /* synthetic */ void getPcString$annotations() {
        }

        public static /* synthetic */ void getPsr$annotations() {
        }

        public static /* synthetic */ void getPsrString$annotations() {
        }

        public static /* synthetic */ void getR0$annotations() {
        }

        public static /* synthetic */ void getR0String$annotations() {
        }

        public static /* synthetic */ void getR1$annotations() {
        }

        public static /* synthetic */ void getR12$annotations() {
        }

        public static /* synthetic */ void getR12String$annotations() {
        }

        public static /* synthetic */ void getR1String$annotations() {
        }

        public static /* synthetic */ void getR2$annotations() {
        }

        public static /* synthetic */ void getR2String$annotations() {
        }

        public static /* synthetic */ void getR3$annotations() {
        }

        public static /* synthetic */ void getR3String$annotations() {
        }

        public static /* synthetic */ void getSPString$annotations() {
        }

        public static /* synthetic */ void getSp$annotations() {
        }
    }

    public /* synthetic */ CrashStatus(int r3, Registers registers, AppInfo appInfo, int r6, boolean z, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((r3 & 0) != 0) {
            zzac.throwMissingFieldException(r3, 0, CrashStatus$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        if ((r3 & 1) == 0) {
            this.registers = null;
        } else {
            this.registers = registers;
        }
        if ((r3 & 2) == 0) {
            this.appInfo = null;
        } else {
            this.appInfo = appInfo;
        }
        if ((r3 & 4) == 0) {
            this.hw_reason = 0;
        } else {
            this.hw_reason = r6;
        }
        if ((r3 & 8) == 0) {
            this.remoteCrash = false;
        } else {
            this.remoteCrash = z;
        }
        if ((r3 & 16) == 0) {
            this.type = null;
        } else {
            this.type = str;
        }
        if ((r3 & 32) == 0) {
            this.timestamp = "";
        } else {
            this.timestamp = str2;
        }
    }

    public static final /* synthetic */ void write$Self$watch_release(CrashStatus crashStatus, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = false;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || crashStatus.registers != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, CrashStatus$Registers$$serializer.INSTANCE, crashStatus.registers);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || crashStatus.appInfo != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, CrashStatus$AppInfo$$serializer.INSTANCE, crashStatus.appInfo);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || crashStatus.hw_reason != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            compositeEncoder.encodeIntElement(2, crashStatus.hw_reason, serialDescriptor);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || crashStatus.remoteCrash) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 3, crashStatus.remoteCrash);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || crashStatus.type != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, crashStatus.type);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(crashStatus.timestamp, "")) {
            z6 = true;
        }
        if (z6) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, crashStatus.timestamp);
        }
    }

    public final AppInfo getAppInfo() {
        return this.appInfo;
    }

    public final int getHw_reason() {
        return this.hw_reason;
    }

    public final Registers getRegisters() {
        return this.registers;
    }

    public final boolean getRemoteCrash() {
        return this.remoteCrash;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getType() {
        return this.type;
    }

    public final void setAppInfo(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    public final void setHw_reason(int r1) {
        this.hw_reason = r1;
    }

    public final void setRegisters(Registers registers) {
        this.registers = registers;
    }

    public final void setRemoteCrash(boolean z) {
        this.remoteCrash = z;
    }

    public final void setTimestamp(String str) {
        this.timestamp = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        String trimMargin;
        trimMargin = StringsKt__IndentKt.trimMargin("CrashStatus(\n            |  registers=" + this.registers + ", \n            |  appInfo=" + this.appInfo + ", \n            |  hWReason=" + this.hw_reason + ", \n            |  remoteCrash=" + this.remoteCrash + ", type=" + this.type + ')', "|");
        return trimMargin;
    }

    public CrashStatus() {
        this.timestamp = "";
    }

    public CrashStatus(String str, int r3, CrashInfo crashInfo, boolean z, String timestamp) {
        Intrinsics.checkNotNullParameter(crashInfo, "crashInfo");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.type = str;
        this.timestamp = timestamp;
        this.hw_reason = r3;
        this.remoteCrash = z;
        Registers registers = new Registers();
        registers.setR0(crashInfo.getR0());
        registers.setR1(crashInfo.getR1());
        registers.setR2(crashInfo.getR2());
        registers.setR3(crashInfo.getR3());
        registers.setR12(crashInfo.getR12());
        registers.setSp(crashInfo.getSp());
        registers.setLr(crashInfo.getLr());
        registers.setPc(crashInfo.getPc());
        registers.setPsr(crashInfo.getPsr());
        this.registers = registers;
        AppInfo appInfo = new AppInfo();
        appInfo.setFilename(crashInfo.getFilename());
        appInfo.setLineNumber(crashInfo.getLineNumber());
        appInfo.setErrorCode(crashInfo.getErrorCode());
        appInfo.setSP(crashInfo.getSp());
        this.appInfo = appInfo;
    }

    public static /* synthetic */ void getRemoteCrash$annotations() {
    }
}
