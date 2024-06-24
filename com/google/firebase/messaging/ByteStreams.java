package com.google.firebase.messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes3.dex */
public final class ByteStreams {
    public static byte[] combineBuffers(ArrayDeque arrayDeque, int r7) {
        if (arrayDeque.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) arrayDeque.remove();
        if (bArr.length == r7) {
            return bArr;
        }
        int length = r7 - bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, r7);
        while (length > 0) {
            byte[] bArr2 = (byte[]) arrayDeque.remove();
            int min = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, copyOf, r7 - length, min);
            length -= min;
        }
        return copyOf;
    }

    public static byte[] toByteArray(LimitedInputStream limitedInputStream) throws IOException {
        int r2;
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int min = Math.min(DfuBaseService.ERROR_REMOTE_MASK, Math.max(128, Integer.highestOneBit(0) * 2));
        int r4 = 0;
        while (r4 < 2147483639) {
            int min2 = Math.min(min, 2147483639 - r4);
            byte[] bArr = new byte[min2];
            arrayDeque.add(bArr);
            int r8 = 0;
            while (r8 < min2) {
                int read = limitedInputStream.read(bArr, r8, min2 - r8);
                if (read == -1) {
                    return combineBuffers(arrayDeque, r4);
                }
                r8 += read;
                r4 += read;
            }
            long j = min;
            if (min < 4096) {
                r2 = 4;
            } else {
                r2 = 2;
            }
            long j2 = j * r2;
            if (j2 > 2147483647L) {
                min = Integer.MAX_VALUE;
            } else if (j2 < -2147483648L) {
                min = Integer.MIN_VALUE;
            } else {
                min = (int) j2;
            }
        }
        if (limitedInputStream.read() == -1) {
            return combineBuffers(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    /* loaded from: classes3.dex */
    public static final class LimitedInputStream extends FilterInputStream {
        public long left;
        public long mark;

        public LimitedInputStream(InputStream inputStream) {
            super(inputStream);
            this.mark = -1L;
            this.left = 1048577L;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.left);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final synchronized void mark(int r3) {
            ((FilterInputStream) this).in.mark(r3);
            this.mark = this.left;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read() throws IOException {
            if (this.left == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read();
            if (read != -1) {
                this.left--;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final synchronized void reset() throws IOException {
            if (((FilterInputStream) this).in.markSupported()) {
                if (this.mark != -1) {
                    ((FilterInputStream) this).in.reset();
                    this.left = this.mark;
                } else {
                    throw new IOException("Mark not set");
                }
            } else {
                throw new IOException("Mark not supported");
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final long skip(long j) throws IOException {
            long skip = ((FilterInputStream) this).in.skip(Math.min(j, this.left));
            this.left -= skip;
            return skip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read(byte[] bArr, int r8, int r9) throws IOException {
            long j = this.left;
            if (j == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read(bArr, r8, (int) Math.min(r9, j));
            if (read != -1) {
                this.left -= read;
            }
            return read;
        }
    }
}
