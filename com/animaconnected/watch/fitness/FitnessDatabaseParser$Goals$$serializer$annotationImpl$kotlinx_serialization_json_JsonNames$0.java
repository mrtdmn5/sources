package com.animaconnected.watch.fitness;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonNames;

/* compiled from: FitnessDatabaseParser.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class FitnessDatabaseParser$Goals$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0 implements JsonNames {
    private final /* synthetic */ String[] names;

    public FitnessDatabaseParser$Goals$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(String[] names) {
        Intrinsics.checkNotNullParameter(names, "names");
        this.names = names;
    }

    @Override // java.lang.annotation.Annotation
    public final /* synthetic */ Class annotationType() {
        return JsonNames.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (!(obj instanceof JsonNames) || !Arrays.equals(names(), ((JsonNames) obj).names())) {
            return false;
        }
        return true;
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return Arrays.hashCode(this.names) ^ 397397176;
    }

    @Override // kotlinx.serialization.json.JsonNames
    public final /* synthetic */ String[] names() {
        return this.names;
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("@kotlinx.serialization.json.JsonNames(names="), Arrays.toString(this.names), ')');
    }
}
