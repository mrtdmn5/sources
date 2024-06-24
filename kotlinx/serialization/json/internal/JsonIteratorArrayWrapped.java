package kotlinx.serialization.json.internal;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: JsonIterator.kt */
/* loaded from: classes4.dex */
public final class JsonIteratorArrayWrapped<T> implements Iterator<T>, KMappedMarker {
    public final DeserializationStrategy<T> deserializer;
    public boolean first = true;
    public final Json json;
    public final ReaderJsonLexer lexer;

    public JsonIteratorArrayWrapped(Json json, ReaderJsonLexer readerJsonLexer, KSerializer kSerializer) {
        this.json = json;
        this.lexer = readerJsonLexer;
        this.deserializer = kSerializer;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        ReaderJsonLexer readerJsonLexer = this.lexer;
        boolean z = true;
        boolean z2 = false;
        if (readerJsonLexer.peekNextToken() == 9) {
            readerJsonLexer.consumeNextToken((byte) 9);
            if (readerJsonLexer.peekNextToken() == 10) {
                z = false;
            }
            if (z) {
                if (readerJsonLexer.peekNextToken() != 8) {
                    readerJsonLexer.expectEof();
                } else {
                    AbstractJsonLexer.fail$default(readerJsonLexer, "There is a start of the new array after the one parsed to sequence. ARRAY_WRAPPED mode doesn't merge consecutive arrays.\nIf you need to parse a stream of arrays, please use WHITESPACE_SEPARATED mode instead.", 0, null, 6);
                    throw null;
                }
            }
            return false;
        }
        if (readerJsonLexer.peekNextToken() != 10) {
            z2 = true;
        }
        if (z2) {
            return true;
        }
        readerJsonLexer.fail$kotlinx_serialization_json((byte) 9);
        throw null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (this.first) {
            this.first = false;
        } else {
            this.lexer.consumeNextToken(',');
        }
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
