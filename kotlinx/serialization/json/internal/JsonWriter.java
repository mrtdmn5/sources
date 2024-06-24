package kotlinx.serialization.json.internal;

/* compiled from: JsonStreams.kt */
/* loaded from: classes4.dex */
public interface JsonWriter {
    void write(String str);

    void writeChar(char c);

    void writeLong(long j);

    void writeQuoted(String str);
}
