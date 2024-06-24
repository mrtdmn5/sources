package io.ktor.utils.io;

/* compiled from: WriterSession.kt */
/* loaded from: classes3.dex */
public interface HasWriteSession {
    WriterSuspendSession beginWriteSession();

    void endWriteSession(int r1);
}
