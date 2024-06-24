package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composers.kt */
/* loaded from: classes4.dex */
public class Composer {
    public final JsonWriter writer;
    public boolean writingFirst;

    public Composer(JsonWriter writer) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.writer = writer;
        this.writingFirst = true;
    }

    public void indent() {
        this.writingFirst = true;
    }

    public void nextItem() {
        this.writingFirst = false;
    }

    public final void print(char c) {
        this.writer.writeChar(c);
    }

    public void printQuoted(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.writer.writeQuoted(value);
    }

    public final void print(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.writer.write(v);
    }

    public void print(byte b) {
        this.writer.writeLong(b);
    }

    public void print(short s) {
        this.writer.writeLong(s);
    }

    public void print(int r4) {
        this.writer.writeLong(r4);
    }

    public void print(long j) {
        this.writer.writeLong(j);
    }

    public void space() {
    }

    public void unIndent() {
    }
}
