package com.animaconnected.secondo.behaviour.distress.permission;

import android.content.SharedPreferences;
import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0 implements CrashlyticsReportJsonTransform.ObjectParser {
    public static void m(SharedPreferences sharedPreferences, String str, boolean z) {
        sharedPreferences.edit().putBoolean(str, z).apply();
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    public Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.m1647$r8$lambda$4s8CoJuYX6GniCnSQ9blvx0UAE(jsonReader);
    }
}
