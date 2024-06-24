package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.Base64;
import android.util.JsonReader;
import androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticOutline0;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.secondo.screens.settings.WatchSettingsFragment;
import com.animaconnected.watch.fitness.FitnessDataKt;
import com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_CustomAttribute;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Log;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_OperatingSystem;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_User;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class CrashlyticsReportJsonTransform {
    public static final JsonDataEncoderBuilder.AnonymousClass1 CRASHLYTICS_REPORT_JSON_ENCODER;

    /* loaded from: classes3.dex */
    public interface ObjectParser<T> {
        T parse(JsonReader jsonReader) throws IOException;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0057 A[SYNTHETIC] */
    /* renamed from: $r8$lambda$4s8CoJuYX6GniCnSQ9blv-x0UAE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame m1647$r8$lambda$4s8CoJuYX6GniCnSQ9blvx0UAE(android.util.JsonReader r4) {
        /*
            com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame$Builder r0 = new com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame$Builder
            r0.<init>()
            r4.beginObject()
        L8:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L95
            java.lang.String r1 = r4.nextName()
            r1.getClass()
            int r2 = r1.hashCode()
            r3 = -1
            switch(r2) {
                case -1019779949: goto L4a;
                case -887523944: goto L3f;
                case 3571: goto L34;
                case 3143036: goto L29;
                case 2125650548: goto L1e;
                default: goto L1d;
            }
        L1d:
            goto L54
        L1e:
            java.lang.String r2 = "importance"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L27
            goto L54
        L27:
            r3 = 4
            goto L54
        L29:
            java.lang.String r2 = "file"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L32
            goto L54
        L32:
            r3 = 3
            goto L54
        L34:
            java.lang.String r2 = "pc"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L3d
            goto L54
        L3d:
            r3 = 2
            goto L54
        L3f:
            java.lang.String r2 = "symbol"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L48
            goto L54
        L48:
            r3 = 1
            goto L54
        L4a:
            java.lang.String r2 = "offset"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L53
            goto L54
        L53:
            r3 = 0
        L54:
            switch(r3) {
                case 0: goto L89;
                case 1: goto L78;
                case 2: goto L6d;
                case 3: goto L66;
                case 4: goto L5b;
                default: goto L57;
            }
        L57:
            r4.skipValue()
            goto L8
        L5b:
            int r1 = r4.nextInt()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.importance = r1
            goto L8
        L66:
            java.lang.String r1 = r4.nextString()
            r0.file = r1
            goto L8
        L6d:
            long r1 = r4.nextLong()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0.pc = r1
            goto L8
        L78:
            java.lang.String r1 = r4.nextString()
            if (r1 == 0) goto L81
            r0.symbol = r1
            goto L8
        L81:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r0 = "Null symbol"
            r4.<init>(r0)
            throw r4
        L89:
            long r1 = r4.nextLong()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0.offset = r1
            goto L8
        L95:
            r4.endObject()
            com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame r4 = r0.build()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.m1647$r8$lambda$4s8CoJuYX6GniCnSQ9blvx0UAE(android.util.JsonReader):com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame");
    }

    public static AutoValue_CrashlyticsReport_CustomAttribute $r8$lambda$xcqRtqatafHDts0kwSCvKzZoURs(JsonReader jsonReader) {
        String str;
        jsonReader.beginObject();
        String str2 = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (!nextName.equals(TransferTable.COLUMN_KEY)) {
                if (!nextName.equals("value")) {
                    jsonReader.skipValue();
                } else {
                    str3 = jsonReader.nextString();
                    if (str3 == null) {
                        throw new NullPointerException("Null value");
                    }
                }
            } else {
                str2 = jsonReader.nextString();
                if (str2 == null) {
                    throw new NullPointerException("Null key");
                }
            }
        }
        jsonReader.endObject();
        if (str2 == null) {
            str = " key";
        } else {
            str = "";
        }
        if (str3 == null) {
            str = str.concat(" value");
        }
        if (str.isEmpty()) {
            return new AutoValue_CrashlyticsReport_CustomAttribute(str2, str3);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    static {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        AutoCrashlyticsReportEncoder.CONFIG.configure(jsonDataEncoderBuilder);
        jsonDataEncoderBuilder.ignoreNullValues = true;
        CRASHLYTICS_REPORT_JSON_ENCODER = new JsonDataEncoderBuilder.AnonymousClass1();
    }

    public static <T> ImmutableList<T> parseArray(JsonReader jsonReader, ObjectParser<T> objectParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(objectParser.parse(jsonReader));
        }
        jsonReader.endArray();
        return new ImmutableList<>(arrayList);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:102:0x01d3. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:74:0x012a. Please report as an issue. */
    public static AutoValue_CrashlyticsReport_Session_Event parseEvent(JsonReader jsonReader) throws IOException {
        char c;
        char c2;
        String str;
        char c3;
        char c4;
        String str2;
        char c5;
        char c6;
        AutoValue_CrashlyticsReport_Session_Event.Builder builder = new AutoValue_CrashlyticsReport_Session_Event.Builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c7 = 3;
            char c8 = 4;
            char c9 = 1;
            switch (nextName.hashCode()) {
                case -1335157162:
                    if (nextName.equals("device")) {
                        c = 0;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c = 1;
                        break;
                    }
                    break;
                case 107332:
                    if (nextName.equals("log")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c = 3;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals(AnalyticsConstants.KEY_TIMESTAMP)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            c = 65535;
            if (c != 0) {
                String str3 = "";
                String str4 = null;
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c != 4) {
                                jsonReader.skipValue();
                            } else {
                                builder.timestamp = Long.valueOf(jsonReader.nextLong());
                            }
                        } else {
                            String nextString = jsonReader.nextString();
                            if (nextString != null) {
                                builder.type = nextString;
                            } else {
                                throw new NullPointerException("Null type");
                            }
                        }
                    } else {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.getClass();
                            if (!nextName2.equals("content")) {
                                jsonReader.skipValue();
                            } else {
                                str4 = jsonReader.nextString();
                                if (str4 == null) {
                                    throw new NullPointerException("Null content");
                                }
                            }
                        }
                        jsonReader.endObject();
                        if (str4 == null) {
                            str3 = " content";
                        }
                        if (str3.isEmpty()) {
                            builder.log = new AutoValue_CrashlyticsReport_Session_Event_Log(str4);
                        } else {
                            throw new IllegalStateException("Missing required properties:".concat(str3));
                        }
                    }
                } else {
                    jsonReader.beginObject();
                    Integer num = null;
                    AutoValue_CrashlyticsReport_Session_Event_Application_Execution autoValue_CrashlyticsReport_Session_Event_Application_Execution = null;
                    ImmutableList immutableList = null;
                    ImmutableList immutableList2 = null;
                    Boolean bool = null;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        nextName3.getClass();
                        switch (nextName3.hashCode()) {
                            case -1332194002:
                                if (nextName3.equals("background")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case -1090974952:
                                if (nextName3.equals("execution")) {
                                    c2 = c9;
                                    break;
                                }
                                break;
                            case -80231855:
                                if (nextName3.equals("internalKeys")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 555169704:
                                if (nextName3.equals("customAttributes")) {
                                    c2 = c7;
                                    break;
                                }
                                break;
                            case 928737948:
                                if (nextName3.equals("uiOrientation")) {
                                    c2 = c8;
                                    break;
                                }
                                break;
                        }
                        c2 = 65535;
                        switch (c2) {
                            case 0:
                                bool = Boolean.valueOf(jsonReader.nextBoolean());
                                c7 = 3;
                                c8 = 4;
                                c9 = 1;
                            case 1:
                                jsonReader.beginObject();
                                ImmutableList immutableList3 = null;
                                AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception = null;
                                AutoValue_CrashlyticsReport_ApplicationExitInfo autoValue_CrashlyticsReport_ApplicationExitInfo = null;
                                AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal = null;
                                ImmutableList immutableList4 = null;
                                while (jsonReader.hasNext()) {
                                    String nextName4 = jsonReader.nextName();
                                    nextName4.getClass();
                                    switch (nextName4.hashCode()) {
                                        case -1375141843:
                                            if (nextName4.equals("appExitInfo")) {
                                                c3 = 0;
                                                break;
                                            }
                                            break;
                                        case -1337936983:
                                            if (nextName4.equals("threads")) {
                                                c3 = c9;
                                                break;
                                            }
                                            break;
                                        case -902467928:
                                            if (nextName4.equals("signal")) {
                                                c3 = 2;
                                                break;
                                            }
                                            break;
                                        case 937615455:
                                            if (nextName4.equals("binaries")) {
                                                c3 = c7;
                                                break;
                                            }
                                            break;
                                        case 1481625679:
                                            if (nextName4.equals("exception")) {
                                                c3 = c8;
                                                break;
                                            }
                                            break;
                                    }
                                    c3 = 65535;
                                    switch (c3) {
                                        case 0:
                                            AutoValue_CrashlyticsReport_ApplicationExitInfo.Builder builder2 = new AutoValue_CrashlyticsReport_ApplicationExitInfo.Builder();
                                            jsonReader.beginObject();
                                            while (jsonReader.hasNext()) {
                                                String nextName5 = jsonReader.nextName();
                                                nextName5.getClass();
                                                switch (nextName5.hashCode()) {
                                                    case -1516200806:
                                                        if (nextName5.equals("buildIdMappingForArch")) {
                                                            c4 = 0;
                                                            break;
                                                        }
                                                        break;
                                                    case 110987:
                                                        if (nextName5.equals("pid")) {
                                                            c4 = 1;
                                                            break;
                                                        }
                                                        break;
                                                    case 111312:
                                                        if (nextName5.equals("pss")) {
                                                            c4 = 2;
                                                            break;
                                                        }
                                                        break;
                                                    case 113234:
                                                        if (nextName5.equals("rss")) {
                                                            c4 = 3;
                                                            break;
                                                        }
                                                        break;
                                                    case 55126294:
                                                        if (nextName5.equals(AnalyticsConstants.KEY_TIMESTAMP)) {
                                                            c4 = 4;
                                                            break;
                                                        }
                                                        break;
                                                    case 202325402:
                                                        if (nextName5.equals("processName")) {
                                                            c4 = 5;
                                                            break;
                                                        }
                                                        break;
                                                    case 722137681:
                                                        if (nextName5.equals("reasonCode")) {
                                                            c4 = 6;
                                                            break;
                                                        }
                                                        break;
                                                    case 723857505:
                                                        if (nextName5.equals("traceFile")) {
                                                            c4 = 7;
                                                            break;
                                                        }
                                                        break;
                                                    case 2125650548:
                                                        if (nextName5.equals("importance")) {
                                                            c4 = '\b';
                                                            break;
                                                        }
                                                        break;
                                                }
                                                c4 = 65535;
                                                switch (c4) {
                                                    case 0:
                                                        builder2.buildIdMappingForArch = parseArray(jsonReader, new CrashlyticsReportJsonTransform$$ExternalSyntheticLambda3());
                                                        break;
                                                    case 1:
                                                        builder2.pid = Integer.valueOf(jsonReader.nextInt());
                                                        break;
                                                    case 2:
                                                        builder2.pss = Long.valueOf(jsonReader.nextLong());
                                                        break;
                                                    case 3:
                                                        builder2.rss = Long.valueOf(jsonReader.nextLong());
                                                        break;
                                                    case 4:
                                                        builder2.timestamp = Long.valueOf(jsonReader.nextLong());
                                                        break;
                                                    case 5:
                                                        String nextString2 = jsonReader.nextString();
                                                        if (nextString2 != null) {
                                                            builder2.processName = nextString2;
                                                            break;
                                                        } else {
                                                            throw new NullPointerException("Null processName");
                                                        }
                                                    case 6:
                                                        builder2.reasonCode = Integer.valueOf(jsonReader.nextInt());
                                                        break;
                                                    case 7:
                                                        builder2.traceFile = jsonReader.nextString();
                                                        break;
                                                    case '\b':
                                                        builder2.importance = Integer.valueOf(jsonReader.nextInt());
                                                        break;
                                                    default:
                                                        jsonReader.skipValue();
                                                        break;
                                                }
                                            }
                                            jsonReader.endObject();
                                            autoValue_CrashlyticsReport_ApplicationExitInfo = builder2.build();
                                            c7 = 3;
                                            c8 = 4;
                                            c9 = 1;
                                        case 1:
                                            immutableList3 = parseArray(jsonReader, new BottomSheetScaffoldKt$$ExternalSyntheticOutline0());
                                            c7 = 3;
                                            c8 = 4;
                                            c9 = 1;
                                        case 2:
                                            jsonReader.beginObject();
                                            String str5 = null;
                                            String str6 = null;
                                            Long l = null;
                                            while (jsonReader.hasNext()) {
                                                String nextName6 = jsonReader.nextName();
                                                nextName6.getClass();
                                                switch (nextName6.hashCode()) {
                                                    case -1147692044:
                                                        if (nextName6.equals(WatchSettingsFragment.addressBundleKey)) {
                                                            c5 = 0;
                                                            break;
                                                        }
                                                        break;
                                                    case 3059181:
                                                        if (nextName6.equals(AnalyticsConstants.KEY_CODE)) {
                                                            c5 = c9;
                                                            break;
                                                        }
                                                        break;
                                                    case 3373707:
                                                        if (nextName6.equals("name")) {
                                                            c5 = 2;
                                                            break;
                                                        }
                                                        break;
                                                }
                                                c5 = 65535;
                                                switch (c5) {
                                                    case 0:
                                                        l = Long.valueOf(jsonReader.nextLong());
                                                        break;
                                                    case 1:
                                                        str6 = jsonReader.nextString();
                                                        if (str6 == null) {
                                                            throw new NullPointerException("Null code");
                                                        }
                                                        break;
                                                    case 2:
                                                        str5 = jsonReader.nextString();
                                                        if (str5 == null) {
                                                            throw new NullPointerException("Null name");
                                                        }
                                                        break;
                                                    default:
                                                        jsonReader.skipValue();
                                                        break;
                                                }
                                            }
                                            jsonReader.endObject();
                                            if (str5 != null) {
                                                str2 = "";
                                            } else {
                                                str2 = " name";
                                            }
                                            if (str6 == null) {
                                                str2 = str2.concat(" code");
                                            }
                                            if (l == null) {
                                                str2 = ComposableInvoker$$ExternalSyntheticOutline0.m(str2, " address");
                                            }
                                            if (str2.isEmpty()) {
                                                autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(str5, str6, l.longValue());
                                                c7 = 3;
                                                c8 = 4;
                                                c9 = 1;
                                            } else {
                                                throw new IllegalStateException("Missing required properties:".concat(str2));
                                            }
                                        case 3:
                                            immutableList4 = parseArray(jsonReader, new ConstraintWidget$$ExternalSyntheticOutline0());
                                        case 4:
                                            autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception = parseEventExecutionException(jsonReader);
                                        default:
                                            jsonReader.skipValue();
                                    }
                                }
                                jsonReader.endObject();
                                if (autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal != null) {
                                    str = "";
                                } else {
                                    str = " signal";
                                }
                                if (immutableList4 == null) {
                                    str = str.concat(" binaries");
                                }
                                if (str.isEmpty()) {
                                    autoValue_CrashlyticsReport_Session_Event_Application_Execution = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(immutableList3, autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception, autoValue_CrashlyticsReport_ApplicationExitInfo, autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal, immutableList4);
                                    c7 = 3;
                                    c8 = 4;
                                    c9 = 1;
                                } else {
                                    throw new IllegalStateException("Missing required properties:".concat(str));
                                }
                            case 2:
                                ArrayList arrayList = new ArrayList();
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    arrayList.add($r8$lambda$xcqRtqatafHDts0kwSCvKzZoURs(jsonReader));
                                }
                                jsonReader.endArray();
                                immutableList2 = new ImmutableList(arrayList);
                            case 3:
                                ArrayList arrayList2 = new ArrayList();
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    arrayList2.add($r8$lambda$xcqRtqatafHDts0kwSCvKzZoURs(jsonReader));
                                }
                                jsonReader.endArray();
                                immutableList = new ImmutableList(arrayList2);
                            case 4:
                                num = Integer.valueOf(jsonReader.nextInt());
                            default:
                                jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    if (autoValue_CrashlyticsReport_Session_Event_Application_Execution == null) {
                        str3 = " execution";
                    }
                    if (num == null) {
                        str3 = str3.concat(" uiOrientation");
                    }
                    if (str3.isEmpty()) {
                        builder.f141app = new AutoValue_CrashlyticsReport_Session_Event_Application(autoValue_CrashlyticsReport_Session_Event_Application_Execution, immutableList, immutableList2, bool, num.intValue());
                    } else {
                        throw new IllegalStateException("Missing required properties:".concat(str3));
                    }
                }
            } else {
                AutoValue_CrashlyticsReport_Session_Event_Device.Builder builder3 = new AutoValue_CrashlyticsReport_Session_Event_Device.Builder();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName7 = jsonReader.nextName();
                    nextName7.getClass();
                    switch (nextName7.hashCode()) {
                        case -1708606089:
                            if (nextName7.equals("batteryLevel")) {
                                c6 = 0;
                                break;
                            }
                            break;
                        case -1455558134:
                            if (nextName7.equals("batteryVelocity")) {
                                c6 = 1;
                                break;
                            }
                            break;
                        case -1439500848:
                            if (nextName7.equals("orientation")) {
                                c6 = 2;
                                break;
                            }
                            break;
                        case 279795450:
                            if (nextName7.equals("diskUsed")) {
                                c6 = 3;
                                break;
                            }
                            break;
                        case 976541947:
                            if (nextName7.equals("ramUsed")) {
                                c6 = 4;
                                break;
                            }
                            break;
                        case 1516795582:
                            if (nextName7.equals("proximityOn")) {
                                c6 = 5;
                                break;
                            }
                            break;
                    }
                    c6 = 65535;
                    switch (c6) {
                        case 0:
                            builder3.batteryLevel = Double.valueOf(jsonReader.nextDouble());
                            break;
                        case 1:
                            builder3.batteryVelocity = Integer.valueOf(jsonReader.nextInt());
                            break;
                        case 2:
                            builder3.orientation = Integer.valueOf(jsonReader.nextInt());
                            break;
                        case 3:
                            builder3.diskUsed = Long.valueOf(jsonReader.nextLong());
                            break;
                        case 4:
                            builder3.ramUsed = Long.valueOf(jsonReader.nextLong());
                            break;
                        case 5:
                            builder3.proximityOn = Boolean.valueOf(jsonReader.nextBoolean());
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                builder.device = builder3.build();
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception parseEventExecutionException(android.util.JsonReader r8) throws java.io.IOException {
        /*
            r8.beginObject()
            r0 = 0
            r2 = r0
            r3 = r2
            r4 = r3
            r5 = r4
        L8:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L8b
            java.lang.String r1 = r8.nextName()
            r1.getClass()
            r1.hashCode()
            r6 = -1
            int r7 = r1.hashCode()
            switch(r7) {
                case -1266514778: goto L4d;
                case -934964668: goto L42;
                case 3575610: goto L37;
                case 91997906: goto L2c;
                case 581754413: goto L21;
                default: goto L20;
            }
        L20:
            goto L57
        L21:
            java.lang.String r7 = "overflowCount"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L2a
            goto L57
        L2a:
            r6 = 4
            goto L57
        L2c:
            java.lang.String r7 = "causedBy"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L35
            goto L57
        L35:
            r6 = 3
            goto L57
        L37:
            java.lang.String r7 = "type"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L40
            goto L57
        L40:
            r6 = 2
            goto L57
        L42:
            java.lang.String r7 = "reason"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L4b
            goto L57
        L4b:
            r6 = 1
            goto L57
        L4d:
            java.lang.String r7 = "frames"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L56
            goto L57
        L56:
            r6 = 0
        L57:
            switch(r6) {
                case 0: goto L80;
                case 1: goto L7b;
                case 2: goto L6c;
                case 3: goto L67;
                case 4: goto L5e;
                default: goto L5a;
            }
        L5a:
            r8.skipValue()
            goto L8
        L5e:
            int r0 = r8.nextInt()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L8
        L67:
            com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception r5 = parseEventExecutionException(r8)
            goto L8
        L6c:
            java.lang.String r2 = r8.nextString()
            if (r2 == 0) goto L73
            goto L8
        L73:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r0 = "Null type"
            r8.<init>(r0)
            throw r8
        L7b:
            java.lang.String r3 = r8.nextString()
            goto L8
        L80:
            com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0 r1 = new com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0
            r1.<init>()
            com.google.firebase.crashlytics.internal.model.ImmutableList r4 = parseArray(r8, r1)
            goto L8
        L8b:
            r8.endObject()
            if (r2 != 0) goto L93
            java.lang.String r8 = " type"
            goto L95
        L93:
            java.lang.String r8 = ""
        L95:
            if (r4 != 0) goto L9d
            java.lang.String r1 = " frames"
            java.lang.String r8 = r8.concat(r1)
        L9d:
            if (r0 != 0) goto La5
            java.lang.String r1 = " overflowCount"
            java.lang.String r8 = androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0.m(r8, r1)
        La5:
            boolean r1 = r8.isEmpty()
            if (r1 == 0) goto Lb6
            com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception r8 = new com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception
            int r6 = r0.intValue()
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            return r8
        Lb6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Missing required properties:"
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.parseEventExecutionException(android.util.JsonReader):com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0084. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x00af. Please report as an issue. */
    public static AutoValue_CrashlyticsReport parseReport(JsonReader jsonReader) throws IOException {
        char c;
        char c2;
        char c3;
        char c4;
        String str;
        char c5;
        String str2;
        Charset charset = CrashlyticsReport.UTF_8;
        AutoValue_CrashlyticsReport.Builder builder = new AutoValue_CrashlyticsReport.Builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName.hashCode()) {
                case -2118372775:
                    if (nextName.equals("ndkPayload")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1962630338:
                    if (nextName.equals("sdkVersion")) {
                        c = 1;
                        break;
                    }
                    break;
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c = 2;
                        break;
                    }
                    break;
                case 344431858:
                    if (nextName.equals("gmpAppId")) {
                        c = 3;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1984987798:
                    if (nextName.equals("session")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            c = 65535;
            String str3 = "";
            switch (c) {
                case 0:
                    jsonReader.beginObject();
                    ImmutableList immutableList = null;
                    String str4 = null;
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.getClass();
                        if (!nextName2.equals("files")) {
                            if (!nextName2.equals("orgId")) {
                                jsonReader.skipValue();
                            } else {
                                str4 = jsonReader.nextString();
                            }
                        } else {
                            immutableList = parseArray(jsonReader, new CrashlyticsReportJsonTransform$$ExternalSyntheticLambda0());
                        }
                    }
                    jsonReader.endObject();
                    if (immutableList == null) {
                        str3 = " files";
                    }
                    String str5 = str3;
                    if (str5.isEmpty()) {
                        builder.ndkPayload = new AutoValue_CrashlyticsReport_FilesPayload(immutableList, str4);
                    } else {
                        throw new IllegalStateException("Missing required properties:".concat(str5));
                    }
                case 1:
                    String nextString = jsonReader.nextString();
                    if (nextString != null) {
                        builder.sdkVersion = nextString;
                    } else {
                        throw new NullPointerException("Null sdkVersion");
                    }
                case 2:
                    String nextString2 = jsonReader.nextString();
                    if (nextString2 != null) {
                        builder.buildVersion = nextString2;
                    } else {
                        throw new NullPointerException("Null buildVersion");
                    }
                case 3:
                    String nextString3 = jsonReader.nextString();
                    if (nextString3 != null) {
                        builder.gmpAppId = nextString3;
                    } else {
                        throw new NullPointerException("Null gmpAppId");
                    }
                case 4:
                    String nextString4 = jsonReader.nextString();
                    if (nextString4 != null) {
                        builder.installationUuid = nextString4;
                    } else {
                        throw new NullPointerException("Null installationUuid");
                    }
                case 5:
                    builder.platform = Integer.valueOf(jsonReader.nextInt());
                case 6:
                    String nextString5 = jsonReader.nextString();
                    if (nextString5 != null) {
                        builder.displayVersion = nextString5;
                    } else {
                        throw new NullPointerException("Null displayVersion");
                    }
                case 7:
                    AutoValue_CrashlyticsReport_Session.Builder builder2 = new AutoValue_CrashlyticsReport_Session.Builder();
                    builder2.crashed = Boolean.FALSE;
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        nextName3.getClass();
                        switch (nextName3.hashCode()) {
                            case -2128794476:
                                if (nextName3.equals("startedAt")) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1618432855:
                                if (nextName3.equals(FitnessDataKt.oldJsonNameForHistoryDeviceId)) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1606742899:
                                if (nextName3.equals("endedAt")) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1335157162:
                                if (nextName3.equals("device")) {
                                    c2 = 3;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1291329255:
                                if (nextName3.equals("events")) {
                                    c2 = 4;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3556:
                                if (nextName3.equals("os")) {
                                    c2 = 5;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 96801:
                                if (nextName3.equals("app")) {
                                    c2 = 6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3599307:
                                if (nextName3.equals("user")) {
                                    c2 = 7;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 286956243:
                                if (nextName3.equals("generator")) {
                                    c2 = '\b';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1025385094:
                                if (nextName3.equals("crashed")) {
                                    c2 = '\t';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2047016109:
                                if (nextName3.equals("generatorType")) {
                                    c2 = '\n';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        switch (c2) {
                            case 0:
                                builder2.startedAt = Long.valueOf(jsonReader.nextLong());
                                break;
                            case 1:
                                builder2.identifier = new String(Base64.decode(jsonReader.nextString(), 2), CrashlyticsReport.UTF_8);
                                break;
                            case 2:
                                builder2.endedAt = Long.valueOf(jsonReader.nextLong());
                                break;
                            case 3:
                                AutoValue_CrashlyticsReport_Session_Device.Builder builder3 = new AutoValue_CrashlyticsReport_Session_Device.Builder();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String nextName4 = jsonReader.nextName();
                                    nextName4.getClass();
                                    switch (nextName4.hashCode()) {
                                        case -1981332476:
                                            if (nextName4.equals("simulator")) {
                                                c3 = 0;
                                                break;
                                            }
                                            break;
                                        case -1969347631:
                                            if (nextName4.equals("manufacturer")) {
                                                c3 = 1;
                                                break;
                                            }
                                            break;
                                        case 112670:
                                            if (nextName4.equals("ram")) {
                                                c3 = 2;
                                                break;
                                            }
                                            break;
                                        case 3002454:
                                            if (nextName4.equals("arch")) {
                                                c3 = 3;
                                                break;
                                            }
                                            break;
                                        case 81784169:
                                            if (nextName4.equals("diskSpace")) {
                                                c3 = 4;
                                                break;
                                            }
                                            break;
                                        case 94848180:
                                            if (nextName4.equals("cores")) {
                                                c3 = 5;
                                                break;
                                            }
                                            break;
                                        case 104069929:
                                            if (nextName4.equals("model")) {
                                                c3 = 6;
                                                break;
                                            }
                                            break;
                                        case 109757585:
                                            if (nextName4.equals("state")) {
                                                c3 = 7;
                                                break;
                                            }
                                            break;
                                        case 2078953423:
                                            if (nextName4.equals("modelClass")) {
                                                c3 = '\b';
                                                break;
                                            }
                                            break;
                                    }
                                    c3 = 65535;
                                    switch (c3) {
                                        case 0:
                                            builder3.simulator = Boolean.valueOf(jsonReader.nextBoolean());
                                            break;
                                        case 1:
                                            String nextString6 = jsonReader.nextString();
                                            if (nextString6 != null) {
                                                builder3.manufacturer = nextString6;
                                                break;
                                            } else {
                                                throw new NullPointerException("Null manufacturer");
                                            }
                                        case 2:
                                            builder3.ram = Long.valueOf(jsonReader.nextLong());
                                            break;
                                        case 3:
                                            builder3.arch = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case 4:
                                            builder3.diskSpace = Long.valueOf(jsonReader.nextLong());
                                            break;
                                        case 5:
                                            builder3.cores = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case 6:
                                            String nextString7 = jsonReader.nextString();
                                            if (nextString7 != null) {
                                                builder3.model = nextString7;
                                                break;
                                            } else {
                                                throw new NullPointerException("Null model");
                                            }
                                        case 7:
                                            builder3.state = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case '\b':
                                            String nextString8 = jsonReader.nextString();
                                            if (nextString8 != null) {
                                                builder3.modelClass = nextString8;
                                                break;
                                            } else {
                                                throw new NullPointerException("Null modelClass");
                                            }
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                builder2.device = builder3.build();
                                break;
                            case 4:
                                ArrayList arrayList = new ArrayList();
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    arrayList.add(parseEvent(jsonReader));
                                }
                                jsonReader.endArray();
                                builder2.events = new ImmutableList<>(arrayList);
                                break;
                            case 5:
                                AutoValue_CrashlyticsReport_Session_OperatingSystem.Builder builder4 = new AutoValue_CrashlyticsReport_Session_OperatingSystem.Builder();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String nextName5 = jsonReader.nextName();
                                    nextName5.getClass();
                                    switch (nextName5.hashCode()) {
                                        case -911706486:
                                            if (nextName5.equals("buildVersion")) {
                                                c4 = 0;
                                                break;
                                            }
                                            break;
                                        case -293026577:
                                            if (nextName5.equals("jailbroken")) {
                                                c4 = 1;
                                                break;
                                            }
                                            break;
                                        case 351608024:
                                            if (nextName5.equals(AnalyticsConstants.KEY_VERSION)) {
                                                c4 = 2;
                                                break;
                                            }
                                            break;
                                        case 1874684019:
                                            if (nextName5.equals("platform")) {
                                                c4 = 3;
                                                break;
                                            }
                                            break;
                                    }
                                    c4 = 65535;
                                    switch (c4) {
                                        case 0:
                                            String nextString9 = jsonReader.nextString();
                                            if (nextString9 != null) {
                                                builder4.buildVersion = nextString9;
                                                break;
                                            } else {
                                                throw new NullPointerException("Null buildVersion");
                                            }
                                        case 1:
                                            builder4.jailbroken = Boolean.valueOf(jsonReader.nextBoolean());
                                            break;
                                        case 2:
                                            String nextString10 = jsonReader.nextString();
                                            if (nextString10 != null) {
                                                builder4.version = nextString10;
                                                break;
                                            } else {
                                                throw new NullPointerException("Null version");
                                            }
                                        case 3:
                                            builder4.platform = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                builder2.os = builder4.build();
                                break;
                            case 6:
                                jsonReader.beginObject();
                                String str6 = null;
                                String str7 = null;
                                String str8 = null;
                                String str9 = null;
                                String str10 = null;
                                String str11 = null;
                                while (jsonReader.hasNext()) {
                                    String nextName6 = jsonReader.nextName();
                                    nextName6.getClass();
                                    switch (nextName6.hashCode()) {
                                        case -1618432855:
                                            if (nextName6.equals(FitnessDataKt.oldJsonNameForHistoryDeviceId)) {
                                                c5 = 0;
                                                break;
                                            }
                                            break;
                                        case -519438642:
                                            if (nextName6.equals("developmentPlatform")) {
                                                c5 = 1;
                                                break;
                                            }
                                            break;
                                        case 213652010:
                                            if (nextName6.equals("developmentPlatformVersion")) {
                                                c5 = 2;
                                                break;
                                            }
                                            break;
                                        case 351608024:
                                            if (nextName6.equals(AnalyticsConstants.KEY_VERSION)) {
                                                c5 = 3;
                                                break;
                                            }
                                            break;
                                        case 719853845:
                                            if (nextName6.equals("installationUuid")) {
                                                c5 = 4;
                                                break;
                                            }
                                            break;
                                        case 1975623094:
                                            if (nextName6.equals("displayVersion")) {
                                                c5 = 5;
                                                break;
                                            }
                                            break;
                                    }
                                    c5 = 65535;
                                    switch (c5) {
                                        case 0:
                                            str6 = jsonReader.nextString();
                                            if (str6 == null) {
                                                throw new NullPointerException("Null identifier");
                                            }
                                            break;
                                        case 1:
                                            str10 = jsonReader.nextString();
                                            break;
                                        case 2:
                                            str11 = jsonReader.nextString();
                                            break;
                                        case 3:
                                            str7 = jsonReader.nextString();
                                            if (str7 == null) {
                                                throw new NullPointerException("Null version");
                                            }
                                            break;
                                        case 4:
                                            str9 = jsonReader.nextString();
                                            break;
                                        case 5:
                                            str8 = jsonReader.nextString();
                                            break;
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                if (str6 != null) {
                                    str = "";
                                } else {
                                    str = " identifier";
                                }
                                if (str7 == null) {
                                    str = str.concat(" version");
                                }
                                if (str.isEmpty()) {
                                    builder2.f139app = new AutoValue_CrashlyticsReport_Session_Application(str6, str7, str8, str9, str10, str11);
                                    break;
                                } else {
                                    throw new IllegalStateException("Missing required properties:".concat(str));
                                }
                            case 7:
                                jsonReader.beginObject();
                                String str12 = null;
                                while (jsonReader.hasNext()) {
                                    String nextName7 = jsonReader.nextName();
                                    nextName7.getClass();
                                    if (!nextName7.equals(FitnessDataKt.oldJsonNameForHistoryDeviceId)) {
                                        jsonReader.skipValue();
                                    } else {
                                        str12 = jsonReader.nextString();
                                        if (str12 == null) {
                                            throw new NullPointerException("Null identifier");
                                        }
                                    }
                                }
                                jsonReader.endObject();
                                if (str12 != null) {
                                    str2 = "";
                                } else {
                                    str2 = " identifier";
                                }
                                if (str2.isEmpty()) {
                                    builder2.user = new AutoValue_CrashlyticsReport_Session_User(str12);
                                    break;
                                } else {
                                    throw new IllegalStateException("Missing required properties:".concat(str2));
                                }
                            case '\b':
                                String nextString11 = jsonReader.nextString();
                                if (nextString11 != null) {
                                    builder2.generator = nextString11;
                                    break;
                                } else {
                                    throw new NullPointerException("Null generator");
                                }
                            case '\t':
                                builder2.crashed = Boolean.valueOf(jsonReader.nextBoolean());
                                break;
                            case '\n':
                                builder2.generatorType = Integer.valueOf(jsonReader.nextInt());
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    builder.session = builder2.build();
                default:
                    jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static AutoValue_CrashlyticsReport reportFromJson(String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                AutoValue_CrashlyticsReport parseReport = parseReport(jsonReader);
                jsonReader.close();
                return parseReport;
            } finally {
            }
        } catch (IllegalStateException e) {
            throw new IOException(e);
        }
    }
}
