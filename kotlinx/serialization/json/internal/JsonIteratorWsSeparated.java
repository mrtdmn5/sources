package kotlinx.serialization.json.internal;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: JsonIterator.kt */
/* loaded from: classes4.dex */
public final class JsonIteratorWsSeparated<T> implements Iterator<T>, KMappedMarker {
    public final DeserializationStrategy<T> deserializer;
    public final Json json;
    public final ReaderJsonLexer lexer;

    public JsonIteratorWsSeparated(Json json, ReaderJsonLexer readerJsonLexer, KSerializer kSerializer) {
        this.json = json;
        this.lexer = readerJsonLexer;
        this.deserializer = kSerializer;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.lexer.peekNextToken() != 10) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        Json json = this.json;
        WriteMode writeMode = WriteMode.OBJ;
        ReaderJsonLexer readerJsonLexer = this.lexer;
        DeserializationStrategy<T> deserializationStrategy = this.deserializer;
        return (T) new StreamingJsonDecoder(json, writeMode, readerJsonLexer, deserializationStrategy.getDescriptor(), null).decodeSerializableValue$1(deserializationStrategy);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
