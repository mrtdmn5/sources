package aws.smithy.kotlin.runtime.serde.json;

/* compiled from: JsonStreamReader.kt */
/* loaded from: classes.dex */
public interface JsonStreamReader {
    JsonToken nextToken();

    JsonToken peek();

    void skipNext();
}
