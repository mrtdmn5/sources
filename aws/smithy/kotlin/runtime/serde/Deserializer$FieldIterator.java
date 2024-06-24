package aws.smithy.kotlin.runtime.serde;

/* compiled from: Deserializer.kt */
/* loaded from: classes.dex */
public interface Deserializer$FieldIterator extends PrimitiveDeserializer {
    Integer findNextFieldIndex();

    void skipValue();
}
