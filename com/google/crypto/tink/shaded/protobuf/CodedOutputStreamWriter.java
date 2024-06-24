package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class CodedOutputStreamWriter {
    public final CodedOutputStream output;

    public CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        Charset charset = Internal.UTF_8;
        if (codedOutputStream != null) {
            this.output = codedOutputStream;
            codedOutputStream.wrapper = this;
            return;
        }
        throw new NullPointerException("output");
    }

    public final void writeBool(int r2, boolean z) throws IOException {
        this.output.writeBool(r2, z);
    }

    public final void writeBytes(int r2, ByteString byteString) throws IOException {
        this.output.writeBytes(r2, byteString);
    }

    public final void writeDouble(int r2, double d) throws IOException {
        CodedOutputStream codedOutputStream = this.output;
        codedOutputStream.getClass();
        codedOutputStream.writeFixed64(r2, Double.doubleToRawLongBits(d));
    }

    public final void writeEnum(int r2, int r3) throws IOException {
        this.output.writeInt32(r2, r3);
    }

    public final void writeFixed32(int r2, int r3) throws IOException {
        this.output.writeFixed32(r2, r3);
    }

    public final void writeFixed64(int r2, long j) throws IOException {
        this.output.writeFixed64(r2, j);
    }

    public final void writeFloat(float f, int r3) throws IOException {
        CodedOutputStream codedOutputStream = this.output;
        codedOutputStream.getClass();
        codedOutputStream.writeFixed32(r3, Float.floatToRawIntBits(f));
    }

    public final void writeGroup(int r3, Schema schema, Object obj) throws IOException {
        CodedOutputStream codedOutputStream = this.output;
        codedOutputStream.writeTag(r3, 3);
        schema.writeTo((MessageLite) obj, codedOutputStream.wrapper);
        codedOutputStream.writeTag(r3, 4);
    }

    public final void writeInt32(int r2, int r3) throws IOException {
        this.output.writeInt32(r2, r3);
    }

    public final void writeInt64(int r2, long j) throws IOException {
        this.output.writeUInt64(r2, j);
    }

    public final void writeMessage(int r2, Schema schema, Object obj) throws IOException {
        this.output.writeMessage(r2, (MessageLite) obj, schema);
    }

    public final void writeMessageSetItem(int r3, Object obj) throws IOException {
        boolean z = obj instanceof ByteString;
        CodedOutputStream codedOutputStream = this.output;
        if (z) {
            codedOutputStream.writeRawMessageSetExtension(r3, (ByteString) obj);
        } else {
            codedOutputStream.writeMessageSetExtension(r3, (MessageLite) obj);
        }
    }

    public final void writeSFixed32(int r2, int r3) throws IOException {
        this.output.writeFixed32(r2, r3);
    }

    public final void writeSFixed64(int r2, long j) throws IOException {
        this.output.writeFixed64(r2, j);
    }

    public final void writeSInt32(int r2, int r3) throws IOException {
        this.output.writeUInt32(r2, (r3 >> 31) ^ (r3 << 1));
    }

    public final void writeSInt64(int r4, long j) throws IOException {
        this.output.writeUInt64(r4, (j >> 63) ^ (j << 1));
    }

    public final void writeUInt32(int r2, int r3) throws IOException {
        this.output.writeUInt32(r2, r3);
    }

    public final void writeUInt64(int r2, long j) throws IOException {
        this.output.writeUInt64(r2, j);
    }
}
