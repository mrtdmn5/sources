package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.util.Comparator;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportPersistence$$ExternalSyntheticLambda2 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((File) obj2).getName().compareTo(((File) obj).getName());
    }
}
