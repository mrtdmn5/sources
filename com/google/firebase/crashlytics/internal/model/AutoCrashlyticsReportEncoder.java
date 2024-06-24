package com.google.firebase.crashlytics.internal.model;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.secondo.screens.settings.WatchSettingsFragment;
import com.animaconnected.watch.fitness.FitnessDataKt;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class AutoCrashlyticsReportEncoder {
    public static final AutoCrashlyticsReportEncoder CONFIG = new AutoCrashlyticsReportEncoder();

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder implements ObjectEncoder<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> {
        public static final CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder INSTANCE = new CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder();
        public static final FieldDescriptor ARCH_DESCRIPTOR = FieldDescriptor.of("arch");
        public static final FieldDescriptor LIBRARYNAME_DESCRIPTOR = FieldDescriptor.of("libraryName");
        public static final FieldDescriptor BUILDID_DESCRIPTOR = FieldDescriptor.of("buildId");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch buildIdMappingForArch = (CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(ARCH_DESCRIPTOR, buildIdMappingForArch.getArch());
            objectEncoderContext2.add(LIBRARYNAME_DESCRIPTOR, buildIdMappingForArch.getLibraryName());
            objectEncoderContext2.add(BUILDID_DESCRIPTOR, buildIdMappingForArch.getBuildId());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportApplicationExitInfoEncoder implements ObjectEncoder<CrashlyticsReport.ApplicationExitInfo> {
        public static final CrashlyticsReportApplicationExitInfoEncoder INSTANCE = new CrashlyticsReportApplicationExitInfoEncoder();
        public static final FieldDescriptor PID_DESCRIPTOR = FieldDescriptor.of("pid");
        public static final FieldDescriptor PROCESSNAME_DESCRIPTOR = FieldDescriptor.of("processName");
        public static final FieldDescriptor REASONCODE_DESCRIPTOR = FieldDescriptor.of("reasonCode");
        public static final FieldDescriptor IMPORTANCE_DESCRIPTOR = FieldDescriptor.of("importance");
        public static final FieldDescriptor PSS_DESCRIPTOR = FieldDescriptor.of("pss");
        public static final FieldDescriptor RSS_DESCRIPTOR = FieldDescriptor.of("rss");
        public static final FieldDescriptor TIMESTAMP_DESCRIPTOR = FieldDescriptor.of(AnalyticsConstants.KEY_TIMESTAMP);
        public static final FieldDescriptor TRACEFILE_DESCRIPTOR = FieldDescriptor.of("traceFile");
        public static final FieldDescriptor BUILDIDMAPPINGFORARCH_DESCRIPTOR = FieldDescriptor.of("buildIdMappingForArch");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.ApplicationExitInfo applicationExitInfo = (CrashlyticsReport.ApplicationExitInfo) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(PID_DESCRIPTOR, applicationExitInfo.getPid());
            objectEncoderContext2.add(PROCESSNAME_DESCRIPTOR, applicationExitInfo.getProcessName());
            objectEncoderContext2.add(REASONCODE_DESCRIPTOR, applicationExitInfo.getReasonCode());
            objectEncoderContext2.add(IMPORTANCE_DESCRIPTOR, applicationExitInfo.getImportance());
            objectEncoderContext2.add(PSS_DESCRIPTOR, applicationExitInfo.getPss());
            objectEncoderContext2.add(RSS_DESCRIPTOR, applicationExitInfo.getRss());
            objectEncoderContext2.add(TIMESTAMP_DESCRIPTOR, applicationExitInfo.getTimestamp());
            objectEncoderContext2.add(TRACEFILE_DESCRIPTOR, applicationExitInfo.getTraceFile());
            objectEncoderContext2.add(BUILDIDMAPPINGFORARCH_DESCRIPTOR, applicationExitInfo.getBuildIdMappingForArch());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportCustomAttributeEncoder implements ObjectEncoder<CrashlyticsReport.CustomAttribute> {
        public static final CrashlyticsReportCustomAttributeEncoder INSTANCE = new CrashlyticsReportCustomAttributeEncoder();
        public static final FieldDescriptor KEY_DESCRIPTOR = FieldDescriptor.of(TransferTable.COLUMN_KEY);
        public static final FieldDescriptor VALUE_DESCRIPTOR = FieldDescriptor.of("value");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.CustomAttribute customAttribute = (CrashlyticsReport.CustomAttribute) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(KEY_DESCRIPTOR, customAttribute.getKey());
            objectEncoderContext2.add(VALUE_DESCRIPTOR, customAttribute.getValue());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportEncoder implements ObjectEncoder<CrashlyticsReport> {
        public static final CrashlyticsReportEncoder INSTANCE = new CrashlyticsReportEncoder();
        public static final FieldDescriptor SDKVERSION_DESCRIPTOR = FieldDescriptor.of("sdkVersion");
        public static final FieldDescriptor GMPAPPID_DESCRIPTOR = FieldDescriptor.of("gmpAppId");
        public static final FieldDescriptor PLATFORM_DESCRIPTOR = FieldDescriptor.of("platform");
        public static final FieldDescriptor INSTALLATIONUUID_DESCRIPTOR = FieldDescriptor.of("installationUuid");
        public static final FieldDescriptor BUILDVERSION_DESCRIPTOR = FieldDescriptor.of("buildVersion");
        public static final FieldDescriptor DISPLAYVERSION_DESCRIPTOR = FieldDescriptor.of("displayVersion");
        public static final FieldDescriptor SESSION_DESCRIPTOR = FieldDescriptor.of("session");
        public static final FieldDescriptor NDKPAYLOAD_DESCRIPTOR = FieldDescriptor.of("ndkPayload");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(SDKVERSION_DESCRIPTOR, crashlyticsReport.getSdkVersion());
            objectEncoderContext2.add(GMPAPPID_DESCRIPTOR, crashlyticsReport.getGmpAppId());
            objectEncoderContext2.add(PLATFORM_DESCRIPTOR, crashlyticsReport.getPlatform());
            objectEncoderContext2.add(INSTALLATIONUUID_DESCRIPTOR, crashlyticsReport.getInstallationUuid());
            objectEncoderContext2.add(BUILDVERSION_DESCRIPTOR, crashlyticsReport.getBuildVersion());
            objectEncoderContext2.add(DISPLAYVERSION_DESCRIPTOR, crashlyticsReport.getDisplayVersion());
            objectEncoderContext2.add(SESSION_DESCRIPTOR, crashlyticsReport.getSession());
            objectEncoderContext2.add(NDKPAYLOAD_DESCRIPTOR, crashlyticsReport.getNdkPayload());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportFilesPayloadEncoder implements ObjectEncoder<CrashlyticsReport.FilesPayload> {
        public static final CrashlyticsReportFilesPayloadEncoder INSTANCE = new CrashlyticsReportFilesPayloadEncoder();
        public static final FieldDescriptor FILES_DESCRIPTOR = FieldDescriptor.of("files");
        public static final FieldDescriptor ORGID_DESCRIPTOR = FieldDescriptor.of("orgId");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.FilesPayload filesPayload = (CrashlyticsReport.FilesPayload) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(FILES_DESCRIPTOR, filesPayload.getFiles());
            objectEncoderContext2.add(ORGID_DESCRIPTOR, filesPayload.getOrgId());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportFilesPayloadFileEncoder implements ObjectEncoder<CrashlyticsReport.FilesPayload.File> {
        public static final CrashlyticsReportFilesPayloadFileEncoder INSTANCE = new CrashlyticsReportFilesPayloadFileEncoder();
        public static final FieldDescriptor FILENAME_DESCRIPTOR = FieldDescriptor.of("filename");
        public static final FieldDescriptor CONTENTS_DESCRIPTOR = FieldDescriptor.of("contents");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.FilesPayload.File file = (CrashlyticsReport.FilesPayload.File) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(FILENAME_DESCRIPTOR, file.getFilename());
            objectEncoderContext2.add(CONTENTS_DESCRIPTOR, file.getContents());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionApplicationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Application> {
        public static final CrashlyticsReportSessionApplicationEncoder INSTANCE = new CrashlyticsReportSessionApplicationEncoder();
        public static final FieldDescriptor IDENTIFIER_DESCRIPTOR = FieldDescriptor.of(FitnessDataKt.oldJsonNameForHistoryDeviceId);
        public static final FieldDescriptor VERSION_DESCRIPTOR = FieldDescriptor.of(AnalyticsConstants.KEY_VERSION);
        public static final FieldDescriptor DISPLAYVERSION_DESCRIPTOR = FieldDescriptor.of("displayVersion");
        public static final FieldDescriptor ORGANIZATION_DESCRIPTOR = FieldDescriptor.of("organization");
        public static final FieldDescriptor INSTALLATIONUUID_DESCRIPTOR = FieldDescriptor.of("installationUuid");
        public static final FieldDescriptor DEVELOPMENTPLATFORM_DESCRIPTOR = FieldDescriptor.of("developmentPlatform");
        public static final FieldDescriptor DEVELOPMENTPLATFORMVERSION_DESCRIPTOR = FieldDescriptor.of("developmentPlatformVersion");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.Session.Application application = (CrashlyticsReport.Session.Application) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(IDENTIFIER_DESCRIPTOR, application.getIdentifier());
            objectEncoderContext2.add(VERSION_DESCRIPTOR, application.getVersion());
            objectEncoderContext2.add(DISPLAYVERSION_DESCRIPTOR, application.getDisplayVersion());
            objectEncoderContext2.add(ORGANIZATION_DESCRIPTOR, application.getOrganization());
            objectEncoderContext2.add(INSTALLATIONUUID_DESCRIPTOR, application.getInstallationUuid());
            objectEncoderContext2.add(DEVELOPMENTPLATFORM_DESCRIPTOR, application.getDevelopmentPlatform());
            objectEncoderContext2.add(DEVELOPMENTPLATFORMVERSION_DESCRIPTOR, application.getDevelopmentPlatformVersion());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionApplicationOrganizationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Application.Organization> {
        public static final CrashlyticsReportSessionApplicationOrganizationEncoder INSTANCE = new CrashlyticsReportSessionApplicationOrganizationEncoder();
        public static final FieldDescriptor CLSID_DESCRIPTOR = FieldDescriptor.of("clsId");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            ((CrashlyticsReport.Session.Application.Organization) obj).getClsId();
            objectEncoderContext.add(CLSID_DESCRIPTOR, (Object) null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionDeviceEncoder implements ObjectEncoder<CrashlyticsReport.Session.Device> {
        public static final CrashlyticsReportSessionDeviceEncoder INSTANCE = new CrashlyticsReportSessionDeviceEncoder();
        public static final FieldDescriptor ARCH_DESCRIPTOR = FieldDescriptor.of("arch");
        public static final FieldDescriptor MODEL_DESCRIPTOR = FieldDescriptor.of("model");
        public static final FieldDescriptor CORES_DESCRIPTOR = FieldDescriptor.of("cores");
        public static final FieldDescriptor RAM_DESCRIPTOR = FieldDescriptor.of("ram");
        public static final FieldDescriptor DISKSPACE_DESCRIPTOR = FieldDescriptor.of("diskSpace");
        public static final FieldDescriptor SIMULATOR_DESCRIPTOR = FieldDescriptor.of("simulator");
        public static final FieldDescriptor STATE_DESCRIPTOR = FieldDescriptor.of("state");
        public static final FieldDescriptor MANUFACTURER_DESCRIPTOR = FieldDescriptor.of("manufacturer");
        public static final FieldDescriptor MODELCLASS_DESCRIPTOR = FieldDescriptor.of("modelClass");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.Session.Device device = (CrashlyticsReport.Session.Device) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(ARCH_DESCRIPTOR, device.getArch());
            objectEncoderContext2.add(MODEL_DESCRIPTOR, device.getModel());
            objectEncoderContext2.add(CORES_DESCRIPTOR, device.getCores());
            objectEncoderContext2.add(RAM_DESCRIPTOR, device.getRam());
            objectEncoderContext2.add(DISKSPACE_DESCRIPTOR, device.getDiskSpace());
            objectEncoderContext2.add(SIMULATOR_DESCRIPTOR, device.isSimulator());
            objectEncoderContext2.add(STATE_DESCRIPTOR, device.getState());
            objectEncoderContext2.add(MANUFACTURER_DESCRIPTOR, device.getManufacturer());
            objectEncoderContext2.add(MODELCLASS_DESCRIPTOR, device.getModelClass());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionEncoder implements ObjectEncoder<CrashlyticsReport.Session> {
        public static final CrashlyticsReportSessionEncoder INSTANCE = new CrashlyticsReportSessionEncoder();
        public static final FieldDescriptor GENERATOR_DESCRIPTOR = FieldDescriptor.of("generator");
        public static final FieldDescriptor IDENTIFIER_DESCRIPTOR = FieldDescriptor.of(FitnessDataKt.oldJsonNameForHistoryDeviceId);
        public static final FieldDescriptor STARTEDAT_DESCRIPTOR = FieldDescriptor.of("startedAt");
        public static final FieldDescriptor ENDEDAT_DESCRIPTOR = FieldDescriptor.of("endedAt");
        public static final FieldDescriptor CRASHED_DESCRIPTOR = FieldDescriptor.of("crashed");
        public static final FieldDescriptor APP_DESCRIPTOR = FieldDescriptor.of("app");
        public static final FieldDescriptor USER_DESCRIPTOR = FieldDescriptor.of("user");
        public static final FieldDescriptor OS_DESCRIPTOR = FieldDescriptor.of("os");
        public static final FieldDescriptor DEVICE_DESCRIPTOR = FieldDescriptor.of("device");
        public static final FieldDescriptor EVENTS_DESCRIPTOR = FieldDescriptor.of("events");
        public static final FieldDescriptor GENERATORTYPE_DESCRIPTOR = FieldDescriptor.of("generatorType");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.Session session = (CrashlyticsReport.Session) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(GENERATOR_DESCRIPTOR, session.getGenerator());
            objectEncoderContext2.add(IDENTIFIER_DESCRIPTOR, session.getIdentifier().getBytes(CrashlyticsReport.UTF_8));
            objectEncoderContext2.add(STARTEDAT_DESCRIPTOR, session.getStartedAt());
            objectEncoderContext2.add(ENDEDAT_DESCRIPTOR, session.getEndedAt());
            objectEncoderContext2.add(CRASHED_DESCRIPTOR, session.isCrashed());
            objectEncoderContext2.add(APP_DESCRIPTOR, session.getApp());
            objectEncoderContext2.add(USER_DESCRIPTOR, session.getUser());
            objectEncoderContext2.add(OS_DESCRIPTOR, session.getOs());
            objectEncoderContext2.add(DEVICE_DESCRIPTOR, session.getDevice());
            objectEncoderContext2.add(EVENTS_DESCRIPTOR, session.getEvents());
            objectEncoderContext2.add(GENERATORTYPE_DESCRIPTOR, session.getGeneratorType());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionEventApplicationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application> {
        public static final CrashlyticsReportSessionEventApplicationEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationEncoder();
        public static final FieldDescriptor EXECUTION_DESCRIPTOR = FieldDescriptor.of("execution");
        public static final FieldDescriptor CUSTOMATTRIBUTES_DESCRIPTOR = FieldDescriptor.of("customAttributes");
        public static final FieldDescriptor INTERNALKEYS_DESCRIPTOR = FieldDescriptor.of("internalKeys");
        public static final FieldDescriptor BACKGROUND_DESCRIPTOR = FieldDescriptor.of("background");
        public static final FieldDescriptor UIORIENTATION_DESCRIPTOR = FieldDescriptor.of("uiOrientation");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.Session.Event.Application application = (CrashlyticsReport.Session.Event.Application) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(EXECUTION_DESCRIPTOR, application.getExecution());
            objectEncoderContext2.add(CUSTOMATTRIBUTES_DESCRIPTOR, application.getCustomAttributes());
            objectEncoderContext2.add(INTERNALKEYS_DESCRIPTOR, application.getInternalKeys());
            objectEncoderContext2.add(BACKGROUND_DESCRIPTOR, application.getBackground());
            objectEncoderContext2.add(UIORIENTATION_DESCRIPTOR, application.getUiOrientation());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> {
        public static final CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder();
        public static final FieldDescriptor BASEADDRESS_DESCRIPTOR = FieldDescriptor.of("baseAddress");
        public static final FieldDescriptor SIZE_DESCRIPTOR = FieldDescriptor.of("size");
        public static final FieldDescriptor NAME_DESCRIPTOR = FieldDescriptor.of("name");
        public static final FieldDescriptor UUID_DESCRIPTOR = FieldDescriptor.of("uuid");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            byte[] bArr;
            CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage = (CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(BASEADDRESS_DESCRIPTOR, binaryImage.getBaseAddress());
            objectEncoderContext2.add(SIZE_DESCRIPTOR, binaryImage.getSize());
            objectEncoderContext2.add(NAME_DESCRIPTOR, binaryImage.getName());
            String uuid = binaryImage.getUuid();
            if (uuid != null) {
                bArr = uuid.getBytes(CrashlyticsReport.UTF_8);
            } else {
                bArr = null;
            }
            objectEncoderContext2.add(UUID_DESCRIPTOR, bArr);
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionEventApplicationExecutionEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution> {
        public static final CrashlyticsReportSessionEventApplicationExecutionEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionEncoder();
        public static final FieldDescriptor THREADS_DESCRIPTOR = FieldDescriptor.of("threads");
        public static final FieldDescriptor EXCEPTION_DESCRIPTOR = FieldDescriptor.of("exception");
        public static final FieldDescriptor APPEXITINFO_DESCRIPTOR = FieldDescriptor.of("appExitInfo");
        public static final FieldDescriptor SIGNAL_DESCRIPTOR = FieldDescriptor.of("signal");
        public static final FieldDescriptor BINARIES_DESCRIPTOR = FieldDescriptor.of("binaries");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.Session.Event.Application.Execution execution = (CrashlyticsReport.Session.Event.Application.Execution) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(THREADS_DESCRIPTOR, execution.getThreads());
            objectEncoderContext2.add(EXCEPTION_DESCRIPTOR, execution.getException());
            objectEncoderContext2.add(APPEXITINFO_DESCRIPTOR, execution.getAppExitInfo());
            objectEncoderContext2.add(SIGNAL_DESCRIPTOR, execution.getSignal());
            objectEncoderContext2.add(BINARIES_DESCRIPTOR, execution.getBinaries());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Exception> {
        public static final CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder();
        public static final FieldDescriptor TYPE_DESCRIPTOR = FieldDescriptor.of("type");
        public static final FieldDescriptor REASON_DESCRIPTOR = FieldDescriptor.of("reason");
        public static final FieldDescriptor FRAMES_DESCRIPTOR = FieldDescriptor.of("frames");
        public static final FieldDescriptor CAUSEDBY_DESCRIPTOR = FieldDescriptor.of("causedBy");
        public static final FieldDescriptor OVERFLOWCOUNT_DESCRIPTOR = FieldDescriptor.of("overflowCount");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.Session.Event.Application.Execution.Exception exception = (CrashlyticsReport.Session.Event.Application.Execution.Exception) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(TYPE_DESCRIPTOR, exception.getType());
            objectEncoderContext2.add(REASON_DESCRIPTOR, exception.getReason());
            objectEncoderContext2.add(FRAMES_DESCRIPTOR, exception.getFrames());
            objectEncoderContext2.add(CAUSEDBY_DESCRIPTOR, exception.getCausedBy());
            objectEncoderContext2.add(OVERFLOWCOUNT_DESCRIPTOR, exception.getOverflowCount());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionEventApplicationExecutionSignalEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Signal> {
        public static final CrashlyticsReportSessionEventApplicationExecutionSignalEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionSignalEncoder();
        public static final FieldDescriptor NAME_DESCRIPTOR = FieldDescriptor.of("name");
        public static final FieldDescriptor CODE_DESCRIPTOR = FieldDescriptor.of(AnalyticsConstants.KEY_CODE);
        public static final FieldDescriptor ADDRESS_DESCRIPTOR = FieldDescriptor.of(WatchSettingsFragment.addressBundleKey);

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.Session.Event.Application.Execution.Signal signal = (CrashlyticsReport.Session.Event.Application.Execution.Signal) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(NAME_DESCRIPTOR, signal.getName());
            objectEncoderContext2.add(CODE_DESCRIPTOR, signal.getCode());
            objectEncoderContext2.add(ADDRESS_DESCRIPTOR, signal.getAddress());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionEventApplicationExecutionThreadEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread> {
        public static final CrashlyticsReportSessionEventApplicationExecutionThreadEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionThreadEncoder();
        public static final FieldDescriptor NAME_DESCRIPTOR = FieldDescriptor.of("name");
        public static final FieldDescriptor IMPORTANCE_DESCRIPTOR = FieldDescriptor.of("importance");
        public static final FieldDescriptor FRAMES_DESCRIPTOR = FieldDescriptor.of("frames");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.Session.Event.Application.Execution.Thread thread = (CrashlyticsReport.Session.Event.Application.Execution.Thread) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(NAME_DESCRIPTOR, thread.getName());
            objectEncoderContext2.add(IMPORTANCE_DESCRIPTOR, thread.getImportance());
            objectEncoderContext2.add(FRAMES_DESCRIPTOR, thread.getFrames());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> {
        public static final CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder INSTANCE = new CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder();
        public static final FieldDescriptor PC_DESCRIPTOR = FieldDescriptor.of(AnalyticsConstants.KEY_PC);
        public static final FieldDescriptor SYMBOL_DESCRIPTOR = FieldDescriptor.of("symbol");
        public static final FieldDescriptor FILE_DESCRIPTOR = FieldDescriptor.of("file");
        public static final FieldDescriptor OFFSET_DESCRIPTOR = FieldDescriptor.of("offset");
        public static final FieldDescriptor IMPORTANCE_DESCRIPTOR = FieldDescriptor.of("importance");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(PC_DESCRIPTOR, frame.getPc());
            objectEncoderContext2.add(SYMBOL_DESCRIPTOR, frame.getSymbol());
            objectEncoderContext2.add(FILE_DESCRIPTOR, frame.getFile());
            objectEncoderContext2.add(OFFSET_DESCRIPTOR, frame.getOffset());
            objectEncoderContext2.add(IMPORTANCE_DESCRIPTOR, frame.getImportance());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionEventDeviceEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Device> {
        public static final CrashlyticsReportSessionEventDeviceEncoder INSTANCE = new CrashlyticsReportSessionEventDeviceEncoder();
        public static final FieldDescriptor BATTERYLEVEL_DESCRIPTOR = FieldDescriptor.of("batteryLevel");
        public static final FieldDescriptor BATTERYVELOCITY_DESCRIPTOR = FieldDescriptor.of("batteryVelocity");
        public static final FieldDescriptor PROXIMITYON_DESCRIPTOR = FieldDescriptor.of("proximityOn");
        public static final FieldDescriptor ORIENTATION_DESCRIPTOR = FieldDescriptor.of("orientation");
        public static final FieldDescriptor RAMUSED_DESCRIPTOR = FieldDescriptor.of("ramUsed");
        public static final FieldDescriptor DISKUSED_DESCRIPTOR = FieldDescriptor.of("diskUsed");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.Session.Event.Device device = (CrashlyticsReport.Session.Event.Device) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(BATTERYLEVEL_DESCRIPTOR, device.getBatteryLevel());
            objectEncoderContext2.add(BATTERYVELOCITY_DESCRIPTOR, device.getBatteryVelocity());
            objectEncoderContext2.add(PROXIMITYON_DESCRIPTOR, device.isProximityOn());
            objectEncoderContext2.add(ORIENTATION_DESCRIPTOR, device.getOrientation());
            objectEncoderContext2.add(RAMUSED_DESCRIPTOR, device.getRamUsed());
            objectEncoderContext2.add(DISKUSED_DESCRIPTOR, device.getDiskUsed());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionEventEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event> {
        public static final CrashlyticsReportSessionEventEncoder INSTANCE = new CrashlyticsReportSessionEventEncoder();
        public static final FieldDescriptor TIMESTAMP_DESCRIPTOR = FieldDescriptor.of(AnalyticsConstants.KEY_TIMESTAMP);
        public static final FieldDescriptor TYPE_DESCRIPTOR = FieldDescriptor.of("type");
        public static final FieldDescriptor APP_DESCRIPTOR = FieldDescriptor.of("app");
        public static final FieldDescriptor DEVICE_DESCRIPTOR = FieldDescriptor.of("device");
        public static final FieldDescriptor LOG_DESCRIPTOR = FieldDescriptor.of("log");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.Session.Event event = (CrashlyticsReport.Session.Event) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(TIMESTAMP_DESCRIPTOR, event.getTimestamp());
            objectEncoderContext2.add(TYPE_DESCRIPTOR, event.getType());
            objectEncoderContext2.add(APP_DESCRIPTOR, event.getApp());
            objectEncoderContext2.add(DEVICE_DESCRIPTOR, event.getDevice());
            objectEncoderContext2.add(LOG_DESCRIPTOR, event.getLog());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionEventLogEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Log> {
        public static final CrashlyticsReportSessionEventLogEncoder INSTANCE = new CrashlyticsReportSessionEventLogEncoder();
        public static final FieldDescriptor CONTENT_DESCRIPTOR = FieldDescriptor.of("content");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(CONTENT_DESCRIPTOR, ((CrashlyticsReport.Session.Event.Log) obj).getContent());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionOperatingSystemEncoder implements ObjectEncoder<CrashlyticsReport.Session.OperatingSystem> {
        public static final CrashlyticsReportSessionOperatingSystemEncoder INSTANCE = new CrashlyticsReportSessionOperatingSystemEncoder();
        public static final FieldDescriptor PLATFORM_DESCRIPTOR = FieldDescriptor.of("platform");
        public static final FieldDescriptor VERSION_DESCRIPTOR = FieldDescriptor.of(AnalyticsConstants.KEY_VERSION);
        public static final FieldDescriptor BUILDVERSION_DESCRIPTOR = FieldDescriptor.of("buildVersion");
        public static final FieldDescriptor JAILBROKEN_DESCRIPTOR = FieldDescriptor.of("jailbroken");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.Session.OperatingSystem operatingSystem = (CrashlyticsReport.Session.OperatingSystem) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(PLATFORM_DESCRIPTOR, operatingSystem.getPlatform());
            objectEncoderContext2.add(VERSION_DESCRIPTOR, operatingSystem.getVersion());
            objectEncoderContext2.add(BUILDVERSION_DESCRIPTOR, operatingSystem.getBuildVersion());
            objectEncoderContext2.add(JAILBROKEN_DESCRIPTOR, operatingSystem.isJailbroken());
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashlyticsReportSessionUserEncoder implements ObjectEncoder<CrashlyticsReport.Session.User> {
        public static final CrashlyticsReportSessionUserEncoder INSTANCE = new CrashlyticsReportSessionUserEncoder();
        public static final FieldDescriptor IDENTIFIER_DESCRIPTOR = FieldDescriptor.of(FitnessDataKt.oldJsonNameForHistoryDeviceId);

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(IDENTIFIER_DESCRIPTOR, ((CrashlyticsReport.Session.User) obj).getIdentifier());
        }
    }

    public final void configure(EncoderConfig<?> encoderConfig) {
        CrashlyticsReportEncoder crashlyticsReportEncoder = CrashlyticsReportEncoder.INSTANCE;
        JsonDataEncoderBuilder jsonDataEncoderBuilder = (JsonDataEncoderBuilder) encoderConfig;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.class, crashlyticsReportEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport.class, crashlyticsReportEncoder);
        CrashlyticsReportSessionEncoder crashlyticsReportSessionEncoder = CrashlyticsReportSessionEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.class, crashlyticsReportSessionEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session.class, crashlyticsReportSessionEncoder);
        CrashlyticsReportSessionApplicationEncoder crashlyticsReportSessionApplicationEncoder = CrashlyticsReportSessionApplicationEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.Application.class, crashlyticsReportSessionApplicationEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_Application.class, crashlyticsReportSessionApplicationEncoder);
        CrashlyticsReportSessionApplicationOrganizationEncoder crashlyticsReportSessionApplicationOrganizationEncoder = CrashlyticsReportSessionApplicationOrganizationEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.Application.Organization.class, crashlyticsReportSessionApplicationOrganizationEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_Application_Organization.class, crashlyticsReportSessionApplicationOrganizationEncoder);
        CrashlyticsReportSessionUserEncoder crashlyticsReportSessionUserEncoder = CrashlyticsReportSessionUserEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.User.class, crashlyticsReportSessionUserEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_User.class, crashlyticsReportSessionUserEncoder);
        CrashlyticsReportSessionOperatingSystemEncoder crashlyticsReportSessionOperatingSystemEncoder = CrashlyticsReportSessionOperatingSystemEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.OperatingSystem.class, crashlyticsReportSessionOperatingSystemEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_OperatingSystem.class, crashlyticsReportSessionOperatingSystemEncoder);
        CrashlyticsReportSessionDeviceEncoder crashlyticsReportSessionDeviceEncoder = CrashlyticsReportSessionDeviceEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.Device.class, crashlyticsReportSessionDeviceEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_Device.class, crashlyticsReportSessionDeviceEncoder);
        CrashlyticsReportSessionEventEncoder crashlyticsReportSessionEventEncoder = CrashlyticsReportSessionEventEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.Event.class, crashlyticsReportSessionEventEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_Event.class, crashlyticsReportSessionEventEncoder);
        CrashlyticsReportSessionEventApplicationEncoder crashlyticsReportSessionEventApplicationEncoder = CrashlyticsReportSessionEventApplicationEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.Event.Application.class, crashlyticsReportSessionEventApplicationEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application.class, crashlyticsReportSessionEventApplicationEncoder);
        CrashlyticsReportSessionEventApplicationExecutionEncoder crashlyticsReportSessionEventApplicationExecutionEncoder = CrashlyticsReportSessionEventApplicationExecutionEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.class, crashlyticsReportSessionEventApplicationExecutionEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class, crashlyticsReportSessionEventApplicationExecutionEncoder);
        CrashlyticsReportSessionEventApplicationExecutionThreadEncoder crashlyticsReportSessionEventApplicationExecutionThreadEncoder = CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Thread.class, crashlyticsReportSessionEventApplicationExecutionThreadEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class, crashlyticsReportSessionEventApplicationExecutionThreadEncoder);
        CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder = CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.class, crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class, crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder);
        CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder crashlyticsReportSessionEventApplicationExecutionExceptionEncoder = CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Exception.class, crashlyticsReportSessionEventApplicationExecutionExceptionEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class, crashlyticsReportSessionEventApplicationExecutionExceptionEncoder);
        CrashlyticsReportApplicationExitInfoEncoder crashlyticsReportApplicationExitInfoEncoder = CrashlyticsReportApplicationExitInfoEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.ApplicationExitInfo.class, crashlyticsReportApplicationExitInfoEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_ApplicationExitInfo.class, crashlyticsReportApplicationExitInfoEncoder);
        CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder = CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.class, crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch.class, crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder);
        CrashlyticsReportSessionEventApplicationExecutionSignalEncoder crashlyticsReportSessionEventApplicationExecutionSignalEncoder = CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Signal.class, crashlyticsReportSessionEventApplicationExecutionSignalEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class, crashlyticsReportSessionEventApplicationExecutionSignalEncoder);
        CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder = CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.class, crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class, crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder);
        CrashlyticsReportCustomAttributeEncoder crashlyticsReportCustomAttributeEncoder = CrashlyticsReportCustomAttributeEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.CustomAttribute.class, crashlyticsReportCustomAttributeEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_CustomAttribute.class, crashlyticsReportCustomAttributeEncoder);
        CrashlyticsReportSessionEventDeviceEncoder crashlyticsReportSessionEventDeviceEncoder = CrashlyticsReportSessionEventDeviceEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.Event.Device.class, crashlyticsReportSessionEventDeviceEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Device.class, crashlyticsReportSessionEventDeviceEncoder);
        CrashlyticsReportSessionEventLogEncoder crashlyticsReportSessionEventLogEncoder = CrashlyticsReportSessionEventLogEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.Session.Event.Log.class, crashlyticsReportSessionEventLogEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Log.class, crashlyticsReportSessionEventLogEncoder);
        CrashlyticsReportFilesPayloadEncoder crashlyticsReportFilesPayloadEncoder = CrashlyticsReportFilesPayloadEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.FilesPayload.class, crashlyticsReportFilesPayloadEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_FilesPayload.class, crashlyticsReportFilesPayloadEncoder);
        CrashlyticsReportFilesPayloadFileEncoder crashlyticsReportFilesPayloadFileEncoder = CrashlyticsReportFilesPayloadFileEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(CrashlyticsReport.FilesPayload.File.class, crashlyticsReportFilesPayloadFileEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_CrashlyticsReport_FilesPayload_File.class, crashlyticsReportFilesPayloadFileEncoder);
    }
}
