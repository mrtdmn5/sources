package io.ktor.util.pipeline;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;

/* compiled from: PipelinePhase.kt */
/* loaded from: classes3.dex */
public final class PipelinePhase {
    public final String name;

    public PipelinePhase(String str) {
        this.name = str;
    }

    public final String toString() {
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("Phase('"), this.name, "')");
    }
}
