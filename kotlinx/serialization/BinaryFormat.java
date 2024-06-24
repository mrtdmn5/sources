package kotlinx.serialization;

/* compiled from: SerialFormat.kt */
/* loaded from: classes4.dex */
public interface BinaryFormat extends SerialFormat {
    Object decodeFromByteArray();

    byte[] encodeToByteArray();
}
