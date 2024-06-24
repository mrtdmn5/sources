package kotlinx.serialization;

/* compiled from: SerialFormat.kt */
/* loaded from: classes4.dex */
public interface StringFormat extends SerialFormat {
    Object decodeFromString(KSerializer kSerializer, String str);

    String encodeToString(KSerializer kSerializer, Object obj);
}
