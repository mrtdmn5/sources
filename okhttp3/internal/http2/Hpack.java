package okhttp3.internal.http2;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.animaconnected.secondo.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.http2.Huffman;
import okio.Buffer;
import okio.ByteString;
import okio.Okio;
import okio.RealBufferedSource;

/* compiled from: Hpack.kt */
/* loaded from: classes4.dex */
public final class Hpack {
    public static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    public static final Header[] STATIC_HEADER_TABLE;

    /* compiled from: Hpack.kt */
    /* loaded from: classes4.dex */
    public static final class Reader {
        public int dynamicTableByteCount;
        public int headerCount;
        public final RealBufferedSource source;
        public final int headerTableSizeSetting = 4096;
        public int maxDynamicTableByteCount = 4096;
        public final ArrayList headerList = new ArrayList();
        public Header[] dynamicTable = new Header[8];
        public int nextHeaderIndex = 7;

        public Reader(Http2Reader.ContinuationSource continuationSource) {
            this.source = Okio.buffer(continuationSource);
        }

        public final int evictToRecoverBytes(int r5) {
            int r2;
            int r0 = 0;
            if (r5 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    r2 = this.nextHeaderIndex;
                    if (length < r2 || r5 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header);
                    int r22 = header.hpackSize;
                    r5 -= r22;
                    this.dynamicTableByteCount -= r22;
                    this.headerCount--;
                    r0++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, r2 + 1, headerArr, r2 + 1 + r0, this.headerCount);
                this.nextHeaderIndex += r0;
            }
            return r0;
        }

        public final ByteString getName(int r5) throws IOException {
            boolean z;
            if (r5 >= 0 && r5 <= Hpack.STATIC_HEADER_TABLE.length - 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return Hpack.STATIC_HEADER_TABLE[r5].name;
            }
            int length = this.nextHeaderIndex + 1 + (r5 - Hpack.STATIC_HEADER_TABLE.length);
            if (length >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (length < headerArr.length) {
                    Header header = headerArr[length];
                    Intrinsics.checkNotNull(header);
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (r5 + 1));
        }

        public final void insertIntoDynamicTable(Header header) {
            this.headerList.add(header);
            int r0 = this.maxDynamicTableByteCount;
            int r2 = header.hpackSize;
            if (r2 > r0) {
                ArraysKt___ArraysJvmKt.fill$default(this.dynamicTable, null);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + r2) - r0);
            int r02 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (r02 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int r03 = this.nextHeaderIndex;
            this.nextHeaderIndex = r03 - 1;
            this.dynamicTable[r03] = header;
            this.headerCount++;
            this.dynamicTableByteCount += r2;
        }

        public final ByteString readByteString() throws IOException {
            boolean z;
            int r5;
            RealBufferedSource source = this.source;
            byte readByte = source.readByte();
            byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
            int r1 = readByte & 255;
            int r4 = 0;
            if ((r1 & 128) == 128) {
                z = true;
            } else {
                z = false;
            }
            long readInt = readInt(r1, R.styleable.AppTheme_statusTextH5);
            if (z) {
                Buffer buffer = new Buffer();
                int[] r2 = Huffman.CODES;
                Intrinsics.checkNotNullParameter(source, "source");
                Huffman.Node node = Huffman.root;
                Huffman.Node node2 = node;
                int r3 = 0;
                for (long j = 0; j < readInt; j++) {
                    byte readByte2 = source.readByte();
                    byte[] bArr2 = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                    r4 = (r4 << 8) | (readByte2 & 255);
                    r3 += 8;
                    while (r3 >= 8) {
                        int r10 = r3 - 8;
                        Huffman.Node[] nodeArr = node2.children;
                        Intrinsics.checkNotNull(nodeArr);
                        node2 = nodeArr[(r4 >>> r10) & 255];
                        Intrinsics.checkNotNull(node2);
                        if (node2.children == null) {
                            buffer.m1734writeByte(node2.symbol);
                            r3 -= node2.terminalBitCount;
                            node2 = node;
                        } else {
                            r3 = r10;
                        }
                    }
                }
                while (r3 > 0) {
                    Huffman.Node[] nodeArr2 = node2.children;
                    Intrinsics.checkNotNull(nodeArr2);
                    Huffman.Node node3 = nodeArr2[(r4 << (8 - r3)) & 255];
                    Intrinsics.checkNotNull(node3);
                    if (node3.children != null || (r5 = node3.terminalBitCount) > r3) {
                        break;
                    }
                    buffer.m1734writeByte(node3.symbol);
                    r3 -= r5;
                    node2 = node;
                }
                return buffer.readByteString();
            }
            return source.readByteString(readInt);
        }

        public final int readInt(int r3, int r4) throws IOException {
            int r32 = r3 & r4;
            if (r32 < r4) {
                return r32;
            }
            int r33 = 0;
            while (true) {
                byte readByte = this.source.readByte();
                byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                int r0 = readByte & 255;
                if ((r0 & 128) != 0) {
                    r4 += (r0 & R.styleable.AppTheme_statusTextH5) << r33;
                    r33 += 7;
                } else {
                    return r4 + (r0 << r33);
                }
            }
        }
    }

    /* compiled from: Hpack.kt */
    /* loaded from: classes4.dex */
    public static final class Writer {
        public int dynamicTableByteCount;
        public boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public final Buffer out;
        public final boolean useCompression = true;
        public int smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
        public int maxDynamicTableByteCount = 4096;
        public Header[] dynamicTable = new Header[8];
        public int nextHeaderIndex = 7;

        public Writer(Buffer buffer) {
            this.out = buffer;
        }

        public final void evictToRecoverBytes(int r5) {
            int r2;
            if (r5 > 0) {
                int length = this.dynamicTable.length - 1;
                int r1 = 0;
                while (true) {
                    r2 = this.nextHeaderIndex;
                    if (length < r2 || r5 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header);
                    r5 -= header.hpackSize;
                    int r22 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header2);
                    this.dynamicTableByteCount = r22 - header2.hpackSize;
                    this.headerCount--;
                    r1++;
                    length--;
                }
                Header[] headerArr = this.dynamicTable;
                int r23 = r2 + 1;
                System.arraycopy(headerArr, r23, headerArr, r23 + r1, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int r0 = this.nextHeaderIndex + 1;
                Arrays.fill(headerArr2, r0, r0 + r1, (Object) null);
                this.nextHeaderIndex += r1;
            }
        }

        public final void insertIntoDynamicTable(Header header) {
            int r0 = this.maxDynamicTableByteCount;
            int r2 = header.hpackSize;
            if (r2 > r0) {
                ArraysKt___ArraysJvmKt.fill$default(this.dynamicTable, null);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + r2) - r0);
            int r02 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (r02 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int r03 = this.nextHeaderIndex;
            this.nextHeaderIndex = r03 - 1;
            this.dynamicTable[r03] = header;
            this.headerCount++;
            this.dynamicTableByteCount += r2;
        }

        public final void writeByteString(ByteString data) throws IOException {
            Intrinsics.checkNotNullParameter(data, "data");
            boolean z = this.useCompression;
            Buffer buffer = this.out;
            if (z) {
                int[] r0 = Huffman.CODES;
                int size$okio = data.getSize$okio();
                long j = 0;
                for (int r6 = 0; r6 < size$okio; r6++) {
                    byte internalGet$okio = data.internalGet$okio(r6);
                    byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                    j += Huffman.CODE_BIT_COUNTS[internalGet$okio & 255];
                }
                if (((int) ((j + 7) >> 3)) < data.getSize$okio()) {
                    Buffer buffer2 = new Buffer();
                    int[] r62 = Huffman.CODES;
                    int size$okio2 = data.getSize$okio();
                    long j2 = 0;
                    int r4 = 0;
                    for (int r3 = 0; r3 < size$okio2; r3++) {
                        byte internalGet$okio2 = data.internalGet$okio(r3);
                        byte[] bArr2 = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                        int r5 = internalGet$okio2 & 255;
                        int r9 = Huffman.CODES[r5];
                        byte b = Huffman.CODE_BIT_COUNTS[r5];
                        j2 = (j2 << b) | r9;
                        r4 += b;
                        while (r4 >= 8) {
                            r4 -= 8;
                            buffer2.m1734writeByte((int) (j2 >> r4));
                        }
                    }
                    if (r4 > 0) {
                        buffer2.m1734writeByte((int) ((255 >>> r4) | (j2 << (8 - r4))));
                    }
                    ByteString readByteString = buffer2.readByteString();
                    writeInt(readByteString.getSize$okio(), R.styleable.AppTheme_statusTextH5, 128);
                    buffer.m1732write(readByteString);
                    return;
                }
            }
            writeInt(data.getSize$okio(), R.styleable.AppTheme_statusTextH5, 0);
            buffer.m1732write(data);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00b8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void writeHeaders(java.util.ArrayList r13) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 256
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.writeHeaders(java.util.ArrayList):void");
        }

        public final void writeInt(int r2, int r3, int r4) {
            Buffer buffer = this.out;
            if (r2 < r3) {
                buffer.m1734writeByte(r2 | r4);
                return;
            }
            buffer.m1734writeByte(r4 | r3);
            int r22 = r2 - r3;
            while (r22 >= 128) {
                buffer.m1734writeByte(128 | (r22 & R.styleable.AppTheme_statusTextH5));
                r22 >>>= 7;
            }
            buffer.m1734writeByte(r22);
        }
    }

    static {
        Header header = new Header("", Header.TARGET_AUTHORITY);
        ByteString byteString = Header.TARGET_METHOD;
        Header header2 = new Header("GET", byteString);
        Header header3 = new Header("POST", byteString);
        ByteString byteString2 = Header.TARGET_PATH;
        Header header4 = new Header("/", byteString2);
        Header header5 = new Header("/index.html", byteString2);
        ByteString byteString3 = Header.TARGET_SCHEME;
        Header header6 = new Header("http", byteString3);
        Header header7 = new Header("https", byteString3);
        ByteString byteString4 = Header.RESPONSE_STATUS;
        Header[] headerArr = {header, header2, header3, header4, header5, header6, header7, new Header("200", byteString4), new Header("204", byteString4), new Header("206", byteString4), new Header("304", byteString4), new Header("400", byteString4), new Header("404", byteString4), new Header("500", byteString4), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header(TransferTable.COLUMN_ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        STATIC_HEADER_TABLE = headerArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int r3 = 0; r3 < 61; r3++) {
            if (!linkedHashMap.containsKey(headerArr[r3].name)) {
                linkedHashMap.put(headerArr[r3].name, Integer.valueOf(r3));
            }
        }
        Map<ByteString, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(result)");
        NAME_TO_FIRST_INDEX = unmodifiableMap;
    }

    public static void checkLowercase(ByteString name) throws IOException {
        boolean z;
        Intrinsics.checkNotNullParameter(name, "name");
        int size$okio = name.getSize$okio();
        for (int r2 = 0; r2 < size$okio; r2++) {
            byte b = (byte) 65;
            byte b2 = (byte) 90;
            byte internalGet$okio = name.internalGet$okio(r2);
            if (b <= internalGet$okio && internalGet$okio <= b2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(name.utf8()));
            }
        }
    }
}
