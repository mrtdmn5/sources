package io.ktor.utils.io.core;

import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;
import java.io.EOFException;

/* compiled from: Buffer.kt */
/* loaded from: classes3.dex */
public final class BufferKt {
    public static final void commitWrittenFailed(int r4, int r5) {
        throw new EOFException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("Unable to discard ", r4, " bytes: only ", r5, " available for writing"));
    }

    public static final void discardFailed(int r4, int r5) {
        throw new EOFException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("Unable to discard ", r4, " bytes: only ", r5, " available for reading"));
    }
}
