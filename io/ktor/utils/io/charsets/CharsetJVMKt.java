package io.ktor.utils.io.charsets;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CharsetJVM.kt */
/* loaded from: classes3.dex */
public final class CharsetJVMKt {
    public static final ByteBuffer EmptyByteBuffer;
    public static final CharBuffer EmptyCharBuffer = CharBuffer.allocate(0);

    static {
        ByteBuffer allocate = ByteBuffer.allocate(0);
        Intrinsics.checkNotNull(allocate);
        EmptyByteBuffer = allocate;
    }

    public static final boolean encodeComplete(CharsetEncoder charsetEncoder, ChunkBuffer chunkBuffer) {
        int r0 = chunkBuffer.writePosition;
        int r1 = chunkBuffer.limit - r0;
        ByteBuffer byteBuffer = Memory.Empty;
        ByteBuffer sliceSafe = MemoryJvmKt.sliceSafe(chunkBuffer.memory, r0, r1);
        boolean z = true;
        CoderResult encode = charsetEncoder.encode(EmptyCharBuffer, sliceSafe, true);
        if (encode.isMalformed() || encode.isUnmappable()) {
            throwExceptionWrapped(encode);
        }
        boolean isUnderflow = encode.isUnderflow();
        if (sliceSafe.limit() != r1) {
            z = false;
        }
        if (z) {
            chunkBuffer.commitWritten(sliceSafe.position());
            return isUnderflow;
        }
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
    }

    public static final int encodeImpl(CharsetEncoder charsetEncoder, CharSequence input, int r5, int r6, ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(input, "input");
        CharBuffer wrap = CharBuffer.wrap(input, r5, r6);
        int remaining = wrap.remaining();
        int r62 = chunkBuffer.writePosition;
        int r0 = chunkBuffer.limit - r62;
        ByteBuffer byteBuffer = Memory.Empty;
        ByteBuffer sliceSafe = MemoryJvmKt.sliceSafe(chunkBuffer.memory, r62, r0);
        boolean z = false;
        CoderResult encode = charsetEncoder.encode(wrap, sliceSafe, false);
        if (encode.isMalformed() || encode.isUnmappable()) {
            throwExceptionWrapped(encode);
        }
        if (sliceSafe.limit() == r0) {
            z = true;
        }
        if (z) {
            chunkBuffer.commitWritten(sliceSafe.position());
            return remaining - wrap.remaining();
        }
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:            if (r1 != false) goto L20;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final byte[] encodeToByteArray(java.nio.charset.CharsetEncoder r2, java.lang.CharSequence r3, int r4) {
        /*
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r3 instanceof java.lang.String
            r1 = 0
            if (r0 == 0) goto L39
            int r0 = r3.length()
            if (r4 != r0) goto L20
            java.lang.String r3 = (java.lang.String) r3
            java.nio.charset.Charset r2 = r2.charset()
            byte[] r2 = r3.getBytes(r2)
            java.lang.String r3 = "input as java.lang.String).getBytes(charset())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            return r2
        L20:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = r3.substring(r1, r4)
            java.lang.String r4 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.nio.charset.Charset r2 = r2.charset()
            byte[] r2 = r3.getBytes(r2)
            java.lang.String r3 = "input.substring(fromInde…ring).getBytes(charset())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            return r2
        L39:
            java.nio.CharBuffer r3 = java.nio.CharBuffer.wrap(r3, r1, r4)
            java.nio.ByteBuffer r2 = r2.encode(r3)
            boolean r3 = r2.hasArray()
            if (r3 == 0) goto L5c
            int r3 = r2.arrayOffset()
            if (r3 != 0) goto L5c
            byte[] r3 = r2.array()
            int r4 = r3.length
            int r0 = r2.remaining()
            if (r4 != r0) goto L59
            r1 = 1
        L59:
            if (r1 == 0) goto L5c
            goto L5d
        L5c:
            r3 = 0
        L5d:
            if (r3 != 0) goto L68
            int r3 = r2.remaining()
            byte[] r3 = new byte[r3]
            r2.get(r3)
        L68:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.CharsetJVMKt.encodeToByteArray(java.nio.charset.CharsetEncoder, java.lang.CharSequence, int):byte[]");
    }

    public static final String getName(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "<this>");
        String name = charset.name();
        Intrinsics.checkNotNullExpressionValue(name, "name()");
        return name;
    }

    public static final void throwExceptionWrapped(CoderResult coderResult) {
        try {
            coderResult.throwException();
        } catch (java.nio.charset.MalformedInputException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Failed to decode bytes";
            }
            throw new MalformedInputException(message);
        }
    }
}
