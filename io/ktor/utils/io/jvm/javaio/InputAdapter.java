package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;

/* compiled from: Blocking.kt */
/* loaded from: classes3.dex */
public final class InputAdapter extends InputStream {
    public final ByteReadChannel channel;
    public final JobImpl context;
    public final InputAdapter$loop$1 loop;
    public byte[] single;

    public InputAdapter(ByteReadChannel channel, Job job) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.context = new JobImpl(job);
        this.loop = new InputAdapter$loop$1(job, this);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.channel.getAvailableForRead();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        super.close();
        ByteReadChannel byteReadChannel = this.channel;
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        byteReadChannel.cancel(null);
        if (!this.context.isCompleted()) {
            this.context.cancel(null);
        }
        InputAdapter$loop$1 inputAdapter$loop$1 = this.loop;
        DisposableHandle disposableHandle = inputAdapter$loop$1.disposable;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
        inputAdapter$loop$1.end.resumeWith(ResultKt.createFailure(new CancellationException("Stream closed")));
    }

    @Override // java.io.InputStream
    public final synchronized int read() {
        byte[] bArr = this.single;
        if (bArr == null) {
            bArr = new byte[1];
            this.single = bArr;
        }
        int submitAndAwait = this.loop.submitAndAwait(bArr, 0, 1);
        if (submitAndAwait == -1) {
            return -1;
        }
        if (submitAndAwait == 1) {
            return bArr[0] & 255;
        }
        throw new IllegalStateException(("Expected a single byte or EOF. Got " + submitAndAwait + " bytes.").toString());
    }

    @Override // java.io.InputStream
    public final synchronized int read(byte[] bArr, int r3, int r4) {
        InputAdapter$loop$1 inputAdapter$loop$1;
        inputAdapter$loop$1 = this.loop;
        Intrinsics.checkNotNull(bArr);
        return inputAdapter$loop$1.submitAndAwait(bArr, r3, r4);
    }
}
