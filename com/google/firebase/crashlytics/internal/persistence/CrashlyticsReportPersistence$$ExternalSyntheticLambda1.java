package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.util.Comparator;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportPersistence$$ExternalSyntheticLambda1 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        String name = ((File) obj).getName();
        int r0 = CrashlyticsReportPersistence.EVENT_NAME_LENGTH;
        return name.substring(0, r0).compareTo(((File) obj2).getName().substring(0, r0));
    }
}
