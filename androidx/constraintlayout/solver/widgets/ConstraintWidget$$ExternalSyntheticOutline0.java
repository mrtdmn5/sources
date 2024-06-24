package androidx.constraintlayout.solver.widgets;

import com.animaconnected.future.MapCallback;
import com.animaconnected.secondo.provider.notification.NotificationProvider;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import java.util.HashMap;
import java.util.List;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class ConstraintWidget$$ExternalSyntheticOutline0 implements MapCallback, CrashlyticsReportJsonTransform.ObjectParser {
    public static String m(StringBuilder sb, int r1, String str) {
        sb.append(r1);
        sb.append(str);
        return sb.toString();
    }

    @Override // com.animaconnected.future.MapCallback
    public Object onResult(Object obj) {
        HashMap lambda$getFilterNotificationConfig$36;
        lambda$getFilterNotificationConfig$36 = NotificationProvider.lambda$getFilterNotificationConfig$36((List) obj);
        return lambda$getFilterNotificationConfig$36;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0051 A[SYNTHETIC] */
    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object parse(android.util.JsonReader r6) {
        /*
            r5 = this;
            com.google.firebase.encoders.json.JsonDataEncoderBuilder$1 r0 = com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.CRASHLYTICS_REPORT_JSON_ENCODER
            com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage$Builder r0 = new com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage$Builder
            r0.<init>()
            r6.beginObject()
        La:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L8e
            java.lang.String r1 = r6.nextName()
            r1.getClass()
            int r2 = r1.hashCode()
            r3 = 2
            r4 = -1
            switch(r2) {
                case 3373707: goto L44;
                case 3530753: goto L38;
                case 3601339: goto L2c;
                case 1153765347: goto L21;
                default: goto L20;
            }
        L20:
            goto L4e
        L21:
            java.lang.String r2 = "baseAddress"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L2a
            goto L4e
        L2a:
            r4 = 3
            goto L4e
        L2c:
            java.lang.String r2 = "uuid"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L36
            goto L4e
        L36:
            r4 = r3
            goto L4e
        L38:
            java.lang.String r2 = "size"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L42
            goto L4e
        L42:
            r4 = 1
            goto L4e
        L44:
            java.lang.String r2 = "name"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L4d
            goto L4e
        L4d:
            r4 = 0
        L4e:
            switch(r4) {
                case 0: goto L7d;
                case 1: goto L72;
                case 2: goto L60;
                case 3: goto L55;
                default: goto L51;
            }
        L51:
            r6.skipValue()
            goto La
        L55:
            long r1 = r6.nextLong()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0.baseAddress = r1
            goto La
        L60:
            java.lang.String r1 = r6.nextString()
            byte[] r1 = android.util.Base64.decode(r1, r3)
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.firebase.crashlytics.internal.model.CrashlyticsReport.UTF_8
            r2.<init>(r1, r3)
            r0.uuid = r2
            goto La
        L72:
            long r1 = r6.nextLong()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0.size = r1
            goto La
        L7d:
            java.lang.String r1 = r6.nextString()
            if (r1 == 0) goto L86
            r0.name = r1
            goto La
        L86:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r0 = "Null name"
            r6.<init>(r0)
            throw r6
        L8e:
            r6.endObject()
            com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage r6 = r0.build()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0.parse(android.util.JsonReader):java.lang.Object");
    }
}
