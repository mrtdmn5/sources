package com.google.firebase.crashlytics.internal.model;

import com.amazonaws.services.s3.internal.Constants;
import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application;
import java.nio.charset.Charset;

@AutoValue
/* loaded from: classes3.dex */
public abstract class CrashlyticsReport {
    public static final Charset UTF_8 = Charset.forName(Constants.DEFAULT_ENCODING);

    @AutoValue
    /* loaded from: classes3.dex */
    public static abstract class ApplicationExitInfo {

        @AutoValue
        /* loaded from: classes3.dex */
        public static abstract class BuildIdMappingForArch {
            public abstract String getArch();

            public abstract String getBuildId();

            public abstract String getLibraryName();
        }

        @AutoValue.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder {
        }

        public abstract ImmutableList<BuildIdMappingForArch> getBuildIdMappingForArch();

        public abstract int getImportance();

        public abstract int getPid();

        public abstract String getProcessName();

        public abstract long getPss();

        public abstract int getReasonCode();

        public abstract long getRss();

        public abstract long getTimestamp();

        public abstract String getTraceFile();
    }

    @AutoValue.Builder
    /* loaded from: classes3.dex */
    public static abstract class Builder {
    }

    @AutoValue
    /* loaded from: classes3.dex */
    public static abstract class CustomAttribute {
        public abstract String getKey();

        public abstract String getValue();
    }

    @AutoValue
    /* loaded from: classes3.dex */
    public static abstract class FilesPayload {

        @AutoValue
        /* loaded from: classes3.dex */
        public static abstract class File {
            public abstract byte[] getContents();

            public abstract String getFilename();
        }

        public abstract ImmutableList<File> getFiles();

        public abstract String getOrgId();
    }

    @AutoValue
    /* loaded from: classes3.dex */
    public static abstract class Session {

        @AutoValue
        /* loaded from: classes3.dex */
        public static abstract class Application {

            @AutoValue
            /* loaded from: classes3.dex */
            public static abstract class Organization {
                public abstract void getClsId();
            }

            public abstract String getDevelopmentPlatform();

            public abstract String getDevelopmentPlatformVersion();

            public abstract String getDisplayVersion();

            public abstract String getIdentifier();

            public abstract String getInstallationUuid();

            public abstract Organization getOrganization();

            public abstract String getVersion();
        }

        @AutoValue.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder {
        }

        @AutoValue
        /* loaded from: classes3.dex */
        public static abstract class Device {

            @AutoValue.Builder
            /* loaded from: classes3.dex */
            public static abstract class Builder {
            }

            public abstract int getArch();

            public abstract int getCores();

            public abstract long getDiskSpace();

            public abstract String getManufacturer();

            public abstract String getModel();

            public abstract String getModelClass();

            public abstract long getRam();

            public abstract int getState();

            public abstract boolean isSimulator();
        }

        @AutoValue
        /* loaded from: classes3.dex */
        public static abstract class Event {

            @AutoValue
            /* loaded from: classes3.dex */
            public static abstract class Application {

                @AutoValue.Builder
                /* loaded from: classes3.dex */
                public static abstract class Builder {
                }

                @AutoValue
                /* loaded from: classes3.dex */
                public static abstract class Execution {

                    @AutoValue
                    /* loaded from: classes3.dex */
                    public static abstract class BinaryImage {

                        @AutoValue.Builder
                        /* loaded from: classes3.dex */
                        public static abstract class Builder {
                        }

                        public abstract long getBaseAddress();

                        public abstract String getName();

                        public abstract long getSize();

                        public abstract String getUuid();
                    }

                    @AutoValue
                    /* loaded from: classes3.dex */
                    public static abstract class Exception {
                        public abstract Exception getCausedBy();

                        public abstract ImmutableList<Thread.Frame> getFrames();

                        public abstract int getOverflowCount();

                        public abstract String getReason();

                        public abstract String getType();
                    }

                    @AutoValue
                    /* loaded from: classes3.dex */
                    public static abstract class Signal {
                        public abstract long getAddress();

                        public abstract String getCode();

                        public abstract String getName();
                    }

                    @AutoValue
                    /* loaded from: classes3.dex */
                    public static abstract class Thread {

                        @AutoValue
                        /* loaded from: classes3.dex */
                        public static abstract class Frame {

                            @AutoValue.Builder
                            /* loaded from: classes3.dex */
                            public static abstract class Builder {
                            }

                            public abstract String getFile();

                            public abstract int getImportance();

                            public abstract long getOffset();

                            public abstract long getPc();

                            public abstract String getSymbol();
                        }

                        public abstract ImmutableList<Frame> getFrames();

                        public abstract int getImportance();

                        public abstract String getName();
                    }

                    public abstract ApplicationExitInfo getAppExitInfo();

                    public abstract ImmutableList<BinaryImage> getBinaries();

                    public abstract Exception getException();

                    public abstract Signal getSignal();

                    public abstract ImmutableList<Thread> getThreads();
                }

                public abstract Boolean getBackground();

                public abstract ImmutableList<CustomAttribute> getCustomAttributes();

                public abstract Execution getExecution();

                public abstract ImmutableList<CustomAttribute> getInternalKeys();

                public abstract int getUiOrientation();

                public abstract AutoValue_CrashlyticsReport_Session_Event_Application.Builder toBuilder();
            }

            @AutoValue.Builder
            /* loaded from: classes3.dex */
            public static abstract class Builder {
            }

            @AutoValue
            /* loaded from: classes3.dex */
            public static abstract class Device {

                @AutoValue.Builder
                /* loaded from: classes3.dex */
                public static abstract class Builder {
                }

                public abstract Double getBatteryLevel();

                public abstract int getBatteryVelocity();

                public abstract long getDiskUsed();

                public abstract int getOrientation();

                public abstract long getRamUsed();

                public abstract boolean isProximityOn();
            }

            @AutoValue
            /* loaded from: classes3.dex */
            public static abstract class Log {
                public abstract String getContent();
            }

            public abstract Application getApp();

            public abstract Device getDevice();

            public abstract Log getLog();

            public abstract long getTimestamp();

            public abstract String getType();
        }

        @AutoValue
        /* loaded from: classes3.dex */
        public static abstract class OperatingSystem {

            @AutoValue.Builder
            /* loaded from: classes3.dex */
            public static abstract class Builder {
            }

            public abstract String getBuildVersion();

            public abstract int getPlatform();

            public abstract String getVersion();

            public abstract boolean isJailbroken();
        }

        @AutoValue
        /* loaded from: classes3.dex */
        public static abstract class User {
            public abstract String getIdentifier();
        }

        public abstract Application getApp();

        public abstract Device getDevice();

        public abstract Long getEndedAt();

        public abstract ImmutableList<Event> getEvents();

        public abstract String getGenerator();

        public abstract int getGeneratorType();

        public abstract String getIdentifier();

        public abstract OperatingSystem getOs();

        public abstract long getStartedAt();

        public abstract User getUser();

        public abstract boolean isCrashed();

        public abstract AutoValue_CrashlyticsReport_Session.Builder toBuilder();
    }

    public abstract String getBuildVersion();

    public abstract String getDisplayVersion();

    public abstract String getGmpAppId();

    public abstract String getInstallationUuid();

    public abstract FilesPayload getNdkPayload();

    public abstract int getPlatform();

    public abstract String getSdkVersion();

    public abstract Session getSession();

    public final AutoValue_CrashlyticsReport withSessionEndFields(String str, long j, boolean z) {
        AutoValue_CrashlyticsReport autoValue_CrashlyticsReport = (AutoValue_CrashlyticsReport) this;
        AutoValue_CrashlyticsReport.Builder builder = new AutoValue_CrashlyticsReport.Builder(autoValue_CrashlyticsReport);
        Session session = autoValue_CrashlyticsReport.session;
        if (session != null) {
            AutoValue_CrashlyticsReport_Session.Builder builder2 = session.toBuilder();
            builder2.endedAt = Long.valueOf(j);
            builder2.crashed = Boolean.valueOf(z);
            if (str != null) {
                builder2.user = new AutoValue_CrashlyticsReport_Session_User(str);
            }
            builder.session = builder2.build();
        }
        return builder.build();
    }
}
