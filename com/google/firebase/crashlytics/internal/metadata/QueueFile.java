package com.google.firebase.crashlytics.internal.metadata;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class QueueFile implements Closeable {
    public static final Logger LOGGER = Logger.getLogger(QueueFile.class.getName());
    public final byte[] buffer;
    public int elementCount;
    public int fileLength;
    public Element first;
    public Element last;
    public final RandomAccessFile raf;

    /* loaded from: classes3.dex */
    public static class Element {
        public static final Element NULL = new Element(0, 0);
        public final int length;
        public final int position;

        public Element(int r1, int r2) {
            this.position = r1;
            this.length = r2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Element.class.getSimpleName());
            sb.append("[position = ");
            sb.append(this.position);
            sb.append(", length = ");
            return ConstraintWidget$$ExternalSyntheticOutline0.m(sb, this.length, "]");
        }
    }

    public QueueFile(File file) throws IOException {
        byte[] bArr = new byte[16];
        this.buffer = bArr;
        if (!file.exists()) {
            File file2 = new File(file.getPath() + ".tmp");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
            try {
                randomAccessFile.setLength(4096L);
                randomAccessFile.seek(0L);
                byte[] bArr2 = new byte[16];
                int[] r11 = {4096, 0, 0, 0};
                int r12 = 0;
                int r13 = 0;
                for (int r6 = 4; r12 < r6; r6 = 4) {
                    int r14 = r11[r12];
                    bArr2[r13] = (byte) (r14 >> 24);
                    bArr2[r13 + 1] = (byte) (r14 >> 16);
                    bArr2[r13 + 2] = (byte) (r14 >> 8);
                    bArr2[r13 + 3] = (byte) r14;
                    r13 += 4;
                    r12++;
                }
                randomAccessFile.write(bArr2);
                randomAccessFile.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        }
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
        this.raf = randomAccessFile2;
        randomAccessFile2.seek(0L);
        randomAccessFile2.readFully(bArr);
        int readInt = readInt(0, bArr);
        this.fileLength = readInt;
        if (readInt <= randomAccessFile2.length()) {
            this.elementCount = readInt(4, bArr);
            int readInt2 = readInt(8, bArr);
            int readInt3 = readInt(12, bArr);
            this.first = readElement(readInt2);
            this.last = readElement(readInt3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.fileLength + ", Actual length: " + randomAccessFile2.length());
    }

    public static int readInt(int r2, byte[] bArr) {
        return ((bArr[r2] & 255) << 24) + ((bArr[r2 + 1] & 255) << 16) + ((bArr[r2 + 2] & 255) << 8) + (bArr[r2 + 3] & 255);
    }

    public final void add(byte[] bArr) throws IOException {
        boolean z;
        int wrapPosition;
        int r10;
        int length = bArr.length;
        synchronized (this) {
            if ((length | 0) >= 0) {
                if (length <= bArr.length - 0) {
                    expandIfNecessary(length);
                    synchronized (this) {
                        if (this.elementCount == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                }
            }
            throw new IndexOutOfBoundsException();
        }
        if (z) {
            wrapPosition = 16;
        } else {
            Element element = this.last;
            wrapPosition = wrapPosition(element.position + 4 + element.length);
        }
        Element element2 = new Element(wrapPosition, length);
        byte[] bArr2 = this.buffer;
        bArr2[0] = (byte) (length >> 24);
        bArr2[1] = (byte) (length >> 16);
        bArr2[2] = (byte) (length >> 8);
        bArr2[3] = (byte) length;
        ringWrite(wrapPosition, 4, bArr2);
        ringWrite(wrapPosition + 4, length, bArr);
        if (z) {
            r10 = wrapPosition;
        } else {
            r10 = this.first.position;
        }
        writeHeader(this.fileLength, this.elementCount + 1, r10, wrapPosition);
        this.last = element2;
        this.elementCount++;
        if (z) {
            this.first = element2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.raf.close();
    }

    public final void expandIfNecessary(int r12) throws IOException {
        int r122 = r12 + 4;
        int usedBytes = this.fileLength - usedBytes();
        if (usedBytes >= r122) {
            return;
        }
        int r1 = this.fileLength;
        do {
            usedBytes += r1;
            r1 <<= 1;
        } while (usedBytes < r122);
        RandomAccessFile randomAccessFile = this.raf;
        randomAccessFile.setLength(r1);
        randomAccessFile.getChannel().force(true);
        Element element = this.last;
        int wrapPosition = wrapPosition(element.position + 4 + element.length);
        if (wrapPosition < this.first.position) {
            FileChannel channel = randomAccessFile.getChannel();
            channel.position(this.fileLength);
            long j = wrapPosition - 4;
            if (channel.transferTo(16L, j, channel) != j) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int r123 = this.last.position;
        int r0 = this.first.position;
        if (r123 < r0) {
            int r2 = (this.fileLength + r123) - 16;
            writeHeader(r1, this.elementCount, r0, r2);
            this.last = new Element(r2, this.last.length);
        } else {
            writeHeader(r1, this.elementCount, r0, r123);
        }
        this.fileLength = r1;
    }

    public final Element readElement(int r4) throws IOException {
        if (r4 == 0) {
            return Element.NULL;
        }
        RandomAccessFile randomAccessFile = this.raf;
        randomAccessFile.seek(r4);
        return new Element(r4, randomAccessFile.readInt());
    }

    public final synchronized void remove() throws IOException {
        int r0;
        boolean z;
        try {
            synchronized (this) {
                r0 = this.elementCount;
                if (r0 == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return;
        } catch (Throwable th) {
            throw th;
        }
        if (!z) {
            if (r0 == 1) {
                synchronized (this) {
                    writeHeader(4096, 0, 0, 0);
                    this.elementCount = 0;
                    Element element = Element.NULL;
                    this.first = element;
                    this.last = element;
                    if (this.fileLength > 4096) {
                        RandomAccessFile randomAccessFile = this.raf;
                        randomAccessFile.setLength(4096);
                        randomAccessFile.getChannel().force(true);
                    }
                    this.fileLength = 4096;
                }
            } else {
                Element element2 = this.first;
                int wrapPosition = wrapPosition(element2.position + 4 + element2.length);
                ringRead(wrapPosition, 0, 4, this.buffer);
                int readInt = readInt(0, this.buffer);
                writeHeader(this.fileLength, this.elementCount - 1, wrapPosition, this.last.position);
                this.elementCount--;
                this.first = new Element(wrapPosition, readInt);
            }
            return;
        }
        throw new NoSuchElementException();
    }

    public final void ringRead(int r6, int r7, int r8, byte[] bArr) throws IOException {
        int wrapPosition = wrapPosition(r6);
        int r0 = wrapPosition + r8;
        int r1 = this.fileLength;
        RandomAccessFile randomAccessFile = this.raf;
        if (r0 <= r1) {
            randomAccessFile.seek(wrapPosition);
            randomAccessFile.readFully(bArr, r7, r8);
            return;
        }
        int r12 = r1 - wrapPosition;
        randomAccessFile.seek(wrapPosition);
        randomAccessFile.readFully(bArr, r7, r12);
        randomAccessFile.seek(16L);
        randomAccessFile.readFully(bArr, r7 + r12, r8 - r12);
    }

    public final void ringWrite(int r7, int r8, byte[] bArr) throws IOException {
        int wrapPosition = wrapPosition(r7);
        int r0 = wrapPosition + r8;
        int r1 = this.fileLength;
        RandomAccessFile randomAccessFile = this.raf;
        if (r0 <= r1) {
            randomAccessFile.seek(wrapPosition);
            randomAccessFile.write(bArr, 0, r8);
            return;
        }
        int r12 = r1 - wrapPosition;
        randomAccessFile.seek(wrapPosition);
        randomAccessFile.write(bArr, 0, r12);
        randomAccessFile.seek(16L);
        randomAccessFile.write(bArr, 0 + r12, r8 - r12);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("QueueFile[fileLength=");
        sb.append(this.fileLength);
        sb.append(", size=");
        sb.append(this.elementCount);
        sb.append(", first=");
        sb.append(this.first);
        sb.append(", last=");
        sb.append(this.last);
        sb.append(", element lengths=[");
        try {
            synchronized (this) {
                int r1 = this.first.position;
                boolean z = true;
                for (int r4 = 0; r4 < this.elementCount; r4++) {
                    Element readElement = readElement(r1);
                    new ElementInputStream(readElement);
                    int r5 = readElement.length;
                    if (z) {
                        z = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(r5);
                    r1 = wrapPosition(readElement.position + 4 + readElement.length);
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    public final int usedBytes() {
        if (this.elementCount == 0) {
            return 16;
        }
        Element element = this.last;
        int r2 = element.position;
        int r3 = this.first.position;
        if (r2 >= r3) {
            return (r2 - r3) + 4 + element.length + 16;
        }
        return (((r2 + 4) + element.length) + this.fileLength) - r3;
    }

    public final int wrapPosition(int r2) {
        int r0 = this.fileLength;
        if (r2 >= r0) {
            return (r2 + 16) - r0;
        }
        return r2;
    }

    public final void writeHeader(int r5, int r6, int r7, int r8) throws IOException {
        int[] r52 = {r5, r6, r7, r8};
        int r62 = 0;
        int r72 = 0;
        while (true) {
            byte[] bArr = this.buffer;
            if (r62 < 4) {
                int r1 = r52[r62];
                bArr[r72] = (byte) (r1 >> 24);
                bArr[r72 + 1] = (byte) (r1 >> 16);
                bArr[r72 + 2] = (byte) (r1 >> 8);
                bArr[r72 + 3] = (byte) r1;
                r72 += 4;
                r62++;
            } else {
                RandomAccessFile randomAccessFile = this.raf;
                randomAccessFile.seek(0L);
                randomAccessFile.write(bArr);
                return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class ElementInputStream extends InputStream {
        public int position;
        public int remaining;

        public ElementInputStream(Element element) {
            this.position = QueueFile.this.wrapPosition(element.position + 4);
            this.remaining = element.length;
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int r4, int r5) throws IOException {
            if (bArr != null) {
                if ((r4 | r5) >= 0 && r5 <= bArr.length - r4) {
                    int r0 = this.remaining;
                    if (r0 <= 0) {
                        return -1;
                    }
                    if (r5 > r0) {
                        r5 = r0;
                    }
                    int r02 = this.position;
                    QueueFile queueFile = QueueFile.this;
                    queueFile.ringRead(r02, r4, r5, bArr);
                    this.position = queueFile.wrapPosition(this.position + r5);
                    this.remaining -= r5;
                    return r5;
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            throw new NullPointerException("buffer");
        }

        @Override // java.io.InputStream
        public final int read() throws IOException {
            if (this.remaining == 0) {
                return -1;
            }
            QueueFile queueFile = QueueFile.this;
            queueFile.raf.seek(this.position);
            int read = queueFile.raf.read();
            this.position = queueFile.wrapPosition(this.position + 1);
            this.remaining--;
            return read;
        }
    }
}
