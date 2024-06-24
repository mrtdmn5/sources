package androidx.compose.material;

import androidx.compose.runtime.ComposerImpl;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class BottomSheetScaffoldKt$$ExternalSyntheticOutline0 implements CrashlyticsReportJsonTransform.ObjectParser {
    public static Object m(ComposerImpl composerImpl, int r1, int r2) {
        composerImpl.startReplaceableGroup(r1);
        composerImpl.startReplaceableGroup(r2);
        return composerImpl.nextSlot();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0042 A[SYNTHETIC] */
    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object parse(android.util.JsonReader r7) {
        /*
            r6 = this;
            r7.beginObject()
            r0 = 0
            r1 = r0
            r2 = r1
        L6:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L68
            java.lang.String r3 = r7.nextName()
            r3.getClass()
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case -1266514778: goto L35;
                case 3373707: goto L2a;
                case 2125650548: goto L1f;
                default: goto L1e;
            }
        L1e:
            goto L3f
        L1f:
            java.lang.String r5 = "importance"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L28
            goto L3f
        L28:
            r4 = 2
            goto L3f
        L2a:
            java.lang.String r5 = "name"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L33
            goto L3f
        L33:
            r4 = 1
            goto L3f
        L35:
            java.lang.String r5 = "frames"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L3e
            goto L3f
        L3e:
            r4 = 0
        L3f:
            switch(r4) {
                case 0: goto L5e;
                case 1: goto L4f;
                case 2: goto L46;
                default: goto L42;
            }
        L42:
            r7.skipValue()
            goto L6
        L46:
            int r1 = r7.nextInt()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L6
        L4f:
            java.lang.String r0 = r7.nextString()
            if (r0 == 0) goto L56
            goto L6
        L56:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "Null name"
            r7.<init>(r0)
            throw r7
        L5e:
            com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0 r2 = new com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0
            r2.<init>()
            com.google.firebase.crashlytics.internal.model.ImmutableList r2 = com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.parseArray(r7, r2)
            goto L6
        L68:
            r7.endObject()
            if (r0 != 0) goto L70
            java.lang.String r7 = " name"
            goto L72
        L70:
            java.lang.String r7 = ""
        L72:
            if (r1 != 0) goto L7a
            java.lang.String r3 = " importance"
            java.lang.String r7 = r7.concat(r3)
        L7a:
            if (r2 != 0) goto L82
            java.lang.String r3 = " frames"
            java.lang.String r7 = androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0.m(r7, r3)
        L82:
            boolean r3 = r7.isEmpty()
            if (r3 == 0) goto L92
            com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread r7 = new com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread
            int r1 = r1.intValue()
            r7.<init>(r0, r1, r2)
            return r7
        L92:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Missing required properties:"
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticOutline0.parse(android.util.JsonReader):java.lang.Object");
    }
}
