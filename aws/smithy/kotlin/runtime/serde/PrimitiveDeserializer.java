package aws.smithy.kotlin.runtime.serde;

/* compiled from: Deserializer.kt */
/* loaded from: classes.dex */
public interface PrimitiveDeserializer {
    boolean deserializeBoolean();

    int deserializeInt();

    String deserializeString();
}
