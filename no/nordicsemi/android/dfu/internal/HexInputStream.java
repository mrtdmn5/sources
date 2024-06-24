package no.nordicsemi.android.dfu.internal;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;

/* loaded from: classes4.dex */
public class HexInputStream extends FilterInputStream {
    private final int LINE_LENGTH;
    private final int MBRSize;
    private final int available;
    private int bytesRead;
    private int lastAddress;
    private final byte[] localBuf;
    private int localPos;
    private int pos;
    private int size;

    public HexInputStream(InputStream inputStream, int r3) throws HexFileValidationException, IOException {
        super(new BufferedInputStream(inputStream));
        this.LINE_LENGTH = 128;
        byte[] bArr = new byte[128];
        this.localBuf = bArr;
        this.localPos = 128;
        this.size = bArr.length;
        this.lastAddress = 0;
        this.MBRSize = r3;
        this.available = calculateBinSize(r3);
    }

    private int asciiToInt(int r2) {
        if (r2 >= 65) {
            return r2 - 55;
        }
        if (r2 >= 48) {
            return r2 - 48;
        }
        return -1;
    }

    private int calculateBinSize(int r11) throws HexFileValidationException, IOException {
        int readAddress;
        InputStream inputStream = ((FilterInputStream) this).in;
        inputStream.mark(inputStream.available());
        try {
            int read = inputStream.read();
            int r2 = 0;
            int r3 = 0;
            while (true) {
                checkComma(read);
                int readByte = readByte(inputStream);
                int readAddress2 = readAddress(inputStream);
                int readByte2 = readByte(inputStream);
                if (readByte2 != 0) {
                    if (readByte2 != 1) {
                        if (readByte2 != 2) {
                            if (readByte2 == 4) {
                                int readAddress3 = readAddress(inputStream);
                                if (r3 > 0 && readAddress3 != (r2 >> 16) + 1) {
                                    return r3;
                                }
                                readAddress = readAddress3 << 16;
                                skip(inputStream, 2L);
                            }
                        } else {
                            readAddress = readAddress(inputStream) << 4;
                            if (r3 > 0 && (readAddress >> 16) != (r2 >> 16) + 1) {
                                return r3;
                            }
                            skip(inputStream, 2L);
                        }
                        r2 = readAddress;
                        while (true) {
                            read = inputStream.read();
                            if (read != 10 || read == 13) {
                            }
                        }
                    } else {
                        return r3;
                    }
                } else if (readAddress2 + r2 >= r11) {
                    r3 += readByte;
                }
                skip(inputStream, (readByte * 2) + 2);
                while (true) {
                    read = inputStream.read();
                    if (read != 10) {
                    }
                }
            }
        } finally {
            inputStream.reset();
        }
    }

    private void checkComma(int r2) throws HexFileValidationException {
        if (r2 == 58) {
        } else {
            throw new HexFileValidationException("Not a HEX file");
        }
    }

    private int readAddress(InputStream inputStream) throws IOException {
        return readByte(inputStream) | (readByte(inputStream) << 8);
    }

    private int readByte(InputStream inputStream) throws IOException {
        return asciiToInt(inputStream.read()) | (asciiToInt(inputStream.read()) << 4);
    }

    private int readLine() throws IOException {
        if (this.pos == -1) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        while (true) {
            int read = inputStream.read();
            this.pos++;
            if (read != 10 && read != 13) {
                checkComma(read);
                int readByte = readByte(inputStream);
                this.pos += 2;
                int readAddress = readAddress(inputStream);
                this.pos += 4;
                int readByte2 = readByte(inputStream);
                int r9 = this.pos + 2;
                this.pos = r9;
                if (readByte2 != 0) {
                    if (readByte2 != 1) {
                        if (readByte2 != 2) {
                            if (readByte2 != 4) {
                                this.pos = (int) (r9 + skip(inputStream, (readByte * 2) + 2));
                            } else {
                                int readAddress2 = readAddress(inputStream);
                                int r92 = this.pos + 4;
                                this.pos = r92;
                                if (this.bytesRead > 0 && readAddress2 != (this.lastAddress >> 16) + 1) {
                                    return 0;
                                }
                                this.lastAddress = readAddress2 << 16;
                                this.pos = (int) (r92 + skip(inputStream, 2L));
                            }
                        } else {
                            int readAddress3 = readAddress(inputStream) << 4;
                            int r93 = this.pos + 4;
                            this.pos = r93;
                            if (this.bytesRead > 0 && (readAddress3 >> 16) != (this.lastAddress >> 16) + 1) {
                                return 0;
                            }
                            this.lastAddress = readAddress3;
                            this.pos = (int) (r93 + skip(inputStream, 2L));
                        }
                    } else {
                        this.pos = -1;
                        return 0;
                    }
                } else if (this.lastAddress + readAddress < this.MBRSize) {
                    this.pos = (int) (r9 + skip(inputStream, (readByte * 2) + 2));
                    readByte2 = -1;
                }
                if (readByte2 == 0) {
                    for (int r2 = 0; r2 < this.localBuf.length && r2 < readByte; r2++) {
                        int readByte3 = readByte(inputStream);
                        this.pos += 2;
                        this.localBuf[r2] = (byte) readByte3;
                    }
                    this.pos = (int) (this.pos + skip(inputStream, 2L));
                    this.localPos = 0;
                    return readByte;
                }
            }
        }
    }

    private long skip(InputStream inputStream, long j) throws IOException {
        long skip = inputStream.skip(j);
        if (skip < j) {
            return skip + inputStream.skip(j - skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.available - this.bytesRead;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r1) {
        try {
            super.mark(((FilterInputStream) this).in.available());
        } catch (IOException unused) {
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    public int readPacket(byte[] bArr) throws IOException {
        int r0 = 0;
        while (r0 < bArr.length) {
            int r1 = this.localPos;
            if (r1 < this.size) {
                byte[] bArr2 = this.localBuf;
                this.localPos = r1 + 1;
                bArr[r0] = bArr2[r1];
                r0++;
            } else {
                int r12 = this.bytesRead;
                int readLine = readLine();
                this.size = readLine;
                this.bytesRead = r12 + readLine;
                if (readLine == 0) {
                    break;
                }
            }
        }
        return r0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.pos = 0;
        this.bytesRead = 0;
        this.localPos = 128;
    }

    public int sizeInBytes() {
        return this.available;
    }

    public int sizeInPackets(int r3) {
        int r32;
        int sizeInBytes = sizeInBytes();
        int r1 = sizeInBytes / r3;
        if (sizeInBytes % r3 > 0) {
            r32 = 1;
        } else {
            r32 = 0;
        }
        return r1 + r32;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return readPacket(bArr);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int r2, int r3) {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    public HexInputStream(byte[] bArr, int r3) throws HexFileValidationException, IOException {
        super(new ByteArrayInputStream(bArr));
        this.LINE_LENGTH = 128;
        byte[] bArr2 = new byte[128];
        this.localBuf = bArr2;
        this.localPos = 128;
        this.size = bArr2.length;
        this.lastAddress = 0;
        this.MBRSize = r3;
        this.available = calculateBinSize(r3);
    }
}
