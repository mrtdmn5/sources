package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BytePacketBuilder.kt */
/* loaded from: classes3.dex */
public final class BytePacketBuilder extends Output {
    public BytePacketBuilder() {
        this(null);
    }

    public final ByteReadPacket build() {
        int r0 = get_size();
        ChunkBuffer stealAll$ktor_io = stealAll$ktor_io();
        if (stealAll$ktor_io == null) {
            ByteReadPacket byteReadPacket = ByteReadPacket.Empty;
            return ByteReadPacket.Empty;
        }
        return new ByteReadPacket(stealAll$ktor_io, r0, this.pool);
    }

    @Override // io.ktor.utils.io.core.Output
    /* renamed from: flush-62zg_DM, reason: not valid java name */
    public final void mo1656flush62zg_DM(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
    }

    public final String toString() {
        return "BytePacketBuilder(" + get_size() + " bytes written)";
    }

    public BytePacketBuilder(Object obj) {
        super(ChunkBuffer.Pool);
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c) {
        super.append(c);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    public final BytePacketBuilder append(int r1, int r2, CharSequence charSequence) {
        Output append = super.append(r1, r2, charSequence);
        Intrinsics.checkNotNull(append, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return (BytePacketBuilder) append;
    }

    @Override // io.ktor.utils.io.core.Output
    public final void closeDestination() {
    }
}
