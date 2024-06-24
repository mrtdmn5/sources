package com.google.firebase.crashlytics.internal.model.serialization;

import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportJsonTransform$$ExternalSyntheticLambda3 implements CrashlyticsReportJsonTransform.ObjectParser {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0042 A[SYNTHETIC] */
    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object parse(android.util.JsonReader r7) {
        /*
            r6 = this;
            r7.beginObject()
            r0 = 0
            r1 = r0
            r2 = r1
        L6:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L73
            java.lang.String r3 = r7.nextName()
            r3.getClass()
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case -609862170: goto L35;
                case 3002454: goto L2a;
                case 230943785: goto L1f;
                default: goto L1e;
            }
        L1e:
            goto L3f
        L1f:
            java.lang.String r5 = "buildId"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L28
            goto L3f
        L28:
            r4 = 2
            goto L3f
        L2a:
            java.lang.String r5 = "arch"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L33
            goto L3f
        L33:
            r4 = 1
            goto L3f
        L35:
            java.lang.String r5 = "libraryName"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L3e
            goto L3f
        L3e:
            r4 = 0
        L3f:
            switch(r4) {
                case 0: goto L64;
                case 1: goto L55;
                case 2: goto L46;
                default: goto L42;
            }
        L42:
            r7.skipValue()
            goto L6
        L46:
            java.lang.String r2 = r7.nextString()
            if (r2 == 0) goto L4d
            goto L6
        L4d:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "Null buildId"
            r7.<init>(r0)
            throw r7
        L55:
            java.lang.String r0 = r7.nextString()
            if (r0 == 0) goto L5c
            goto L6
        L5c:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "Null arch"
            r7.<init>(r0)
            throw r7
        L64:
            java.lang.String r1 = r7.nextString()
            if (r1 == 0) goto L6b
            goto L6
        L6b:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "Null libraryName"
            r7.<init>(r0)
            throw r7
        L73:
            r7.endObject()
            if (r0 != 0) goto L7b
            java.lang.String r7 = " arch"
            goto L7d
        L7b:
            java.lang.String r7 = ""
        L7d:
            if (r1 != 0) goto L85
            java.lang.String r3 = " libraryName"
            java.lang.String r7 = r7.concat(r3)
        L85:
            if (r2 != 0) goto L8d
            java.lang.String r3 = " buildId"
            java.lang.String r7 = androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0.m(r7, r3)
        L8d:
            boolean r3 = r7.isEmpty()
            if (r3 == 0) goto L99
            com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch r7 = new com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch
            r7.<init>(r0, r1, r2)
            return r7
        L99:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Missing required properties:"
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$$ExternalSyntheticLambda3.parse(android.util.JsonReader):java.lang.Object");
    }
}
