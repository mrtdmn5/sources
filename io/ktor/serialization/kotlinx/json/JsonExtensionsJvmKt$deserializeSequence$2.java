package io.ktor.serialization.kotlinx.json;

import com.google.android.gms.internal.fitness.zzaa;
import io.ktor.serialization.kotlinx.SerializerLookupKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import io.ktor.utils.io.jvm.javaio.InputAdapter;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.DecodeSequenceMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.internal.JavaStreamSerialReader;
import kotlinx.serialization.json.internal.JsonIteratorArrayWrapped;
import kotlinx.serialization.json.internal.JsonIteratorKt$WhenMappings;
import kotlinx.serialization.json.internal.JsonIteratorWsSeparated;
import kotlinx.serialization.json.internal.ReaderJsonLexer;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: JsonExtensionsJvm.kt */
@DebugMetadata(c = "io.ktor.serialization.kotlinx.json.JsonExtensionsJvmKt$deserializeSequence$2", f = "JsonExtensionsJvm.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class JsonExtensionsJvmKt$deserializeSequence$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Sequence<? extends Object>>, Object> {
    public final /* synthetic */ ByteReadChannel $content;
    public final /* synthetic */ Json $format;
    public final /* synthetic */ TypeInfo $typeInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonExtensionsJvmKt$deserializeSequence$2(TypeInfo typeInfo, ByteReadChannel byteReadChannel, Continuation continuation, Json json) {
        super(2, continuation);
        this.$content = byteReadChannel;
        this.$typeInfo = typeInfo;
        this.$format = json;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new JsonExtensionsJvmKt$deserializeSequence$2(this.$typeInfo, this.$content, continuation, this.$format);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Sequence<? extends Object>> continuation) {
        return ((JsonExtensionsJvmKt$deserializeSequence$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DecodeSequenceMode decodeSequenceMode;
        final Iterator jsonIteratorWsSeparated;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        SynchronizedLazyImpl synchronizedLazyImpl = BlockingKt.ADAPTER_LOGGER$delegate;
        ByteReadChannel byteReadChannel = this.$content;
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        InputAdapter inputAdapter = new InputAdapter(byteReadChannel, null);
        TypeInfo argumentTypeInfo = zzaa.argumentTypeInfo(this.$typeInfo);
        Json json = this.$format;
        KSerializer<?> serializerForTypeInfo = SerializerLookupKt.serializerForTypeInfo(json.serializersModule, argumentTypeInfo);
        DecodeSequenceMode format = DecodeSequenceMode.AUTO_DETECT;
        Intrinsics.checkNotNullParameter(format, "format");
        ReaderJsonLexer readerJsonLexer = new ReaderJsonLexer(new JavaStreamSerialReader(inputAdapter), new char[DfuBaseService.ERROR_CONNECTION_MASK]);
        int[] r4 = JsonIteratorKt$WhenMappings.$EnumSwitchMapping$0;
        int r3 = r4[format.ordinal()];
        if (r3 != 1) {
            boolean z = false;
            if (r3 != 2) {
                if (r3 == 3) {
                    if (readerJsonLexer.peekNextToken() == 8) {
                        readerJsonLexer.consumeNextToken((byte) 8);
                        z = true;
                    }
                    if (z) {
                        decodeSequenceMode = DecodeSequenceMode.ARRAY_WRAPPED;
                    } else {
                        decodeSequenceMode = DecodeSequenceMode.WHITESPACE_SEPARATED;
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (readerJsonLexer.peekNextToken() == 8) {
                    readerJsonLexer.consumeNextToken((byte) 8);
                    z = true;
                }
                if (z) {
                    decodeSequenceMode = DecodeSequenceMode.ARRAY_WRAPPED;
                } else {
                    readerJsonLexer.fail$kotlinx_serialization_json((byte) 8);
                    throw null;
                }
            }
        } else {
            decodeSequenceMode = DecodeSequenceMode.WHITESPACE_SEPARATED;
        }
        int r1 = r4[decodeSequenceMode.ordinal()];
        if (r1 != 1) {
            if (r1 != 2) {
                if (r1 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new IllegalStateException("AbstractJsonLexer.determineFormat must be called beforehand.".toString());
            }
            jsonIteratorWsSeparated = new JsonIteratorArrayWrapped(json, readerJsonLexer, serializerForTypeInfo);
        } else {
            jsonIteratorWsSeparated = new JsonIteratorWsSeparated(json, readerJsonLexer, serializerForTypeInfo);
        }
        Sequence<Object> sequence = new Sequence<Object>() { // from class: kotlinx.serialization.json.internal.JsonStreamsKt$decodeToSequenceByReader$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public final Iterator<Object> iterator() {
                return jsonIteratorWsSeparated;
            }
        };
        if (!(sequence instanceof ConstrainedOnceSequence)) {
            return new ConstrainedOnceSequence(sequence);
        }
        return sequence;
    }
}
