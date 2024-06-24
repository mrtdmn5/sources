package com.google.firebase.crashlytics;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List<Component<?>> getComponents() {
        Component.Builder builder = Component.builder(FirebaseCrashlytics.class);
        builder.name = "fire-cls";
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.required(FirebaseInstallationsApi.class));
        builder.add(new Dependency(0, 2, CrashlyticsNativeComponent.class));
        builder.add(new Dependency(0, 2, AnalyticsConnector.class));
        builder.factory = new ComponentFactory() { // from class: com.google.firebase.crashlytics.CrashlyticsRegistrar$$ExternalSyntheticLambda0
            /* JADX WARN: Removed duplicated region for block: B:104:0x04be  */
            /* JADX WARN: Removed duplicated region for block: B:134:0x0508  */
            /* JADX WARN: Removed duplicated region for block: B:136:0x035c  */
            /* JADX WARN: Removed duplicated region for block: B:145:0x02d4  */
            /* JADX WARN: Removed duplicated region for block: B:148:0x02e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:156:0x026f  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x013c  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0149  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x018b  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x01ad  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x0228  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x0244 A[EDGE_INSN: B:49:0x0244->B:50:0x0244 BREAK  A[LOOP:2: B:41:0x0221->B:47:0x023d], SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:53:0x0256 A[LOOP:3: B:51:0x0250->B:53:0x0256, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:57:0x026a  */
            /* JADX WARN: Removed duplicated region for block: B:72:0x034a  */
            /* JADX WARN: Removed duplicated region for block: B:78:0x03bc  */
            /* JADX WARN: Type inference failed for: r8v0, types: [com.google.firebase.crashlytics.AnalyticsDeferredProxy$$ExternalSyntheticLambda0] */
            /* JADX WARN: Type inference failed for: r9v0, types: [com.google.firebase.crashlytics.AnalyticsDeferredProxy$$ExternalSyntheticLambda1] */
            @Override // com.google.firebase.components.ComponentFactory
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object create(com.google.firebase.components.RestrictedComponentContainer r33) {
                /*
                    Method dump skipped, instructions count: 1307
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.CrashlyticsRegistrar$$ExternalSyntheticLambda0.create(com.google.firebase.components.RestrictedComponentContainer):java.lang.Object");
            }
        };
        builder.setInstantiation(2);
        return Arrays.asList(builder.build(), LibraryVersionComponent.create("fire-cls", "18.3.5"));
    }
}
