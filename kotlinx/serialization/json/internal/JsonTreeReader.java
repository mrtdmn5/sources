package kotlinx.serialization.json.internal;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.Constants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveKt;
import kotlin.DeepRecursiveScope;
import kotlin.DeepRecursiveScopeImpl;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: JsonTreeReader.kt */
/* loaded from: classes4.dex */
public final class JsonTreeReader {
    public final boolean isLenient;
    public final AbstractJsonLexer lexer;
    public int stackDepth;

    public JsonTreeReader(JsonConfiguration configuration, AbstractJsonLexer lexer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        this.lexer = lexer;
        this.isLenient = configuration.isLenient;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0084 -> B:10:0x008a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$readObject(kotlinx.serialization.json.internal.JsonTreeReader r13, kotlin.DeepRecursiveScope r14, kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonTreeReader.access$readObject(kotlinx.serialization.json.internal.JsonTreeReader, kotlin.DeepRecursiveScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final JsonElement read() {
        JsonElement jsonObject;
        String consumeString;
        Object obj;
        Object invoke;
        Continuation intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2;
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        byte peekNextToken = abstractJsonLexer.peekNextToken();
        if (peekNextToken == 1) {
            return readValue(true);
        }
        if (peekNextToken == 0) {
            return readValue(false);
        }
        if (peekNextToken == 6) {
            int r1 = this.stackDepth + 1;
            this.stackDepth = r1;
            if (r1 == 200) {
                JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this, null);
                Unit unit = Unit.INSTANCE;
                CoroutineSingletons coroutineSingletons = DeepRecursiveKt.UNDEFINED_RESULT;
                DeepRecursiveScopeImpl deepRecursiveScopeImpl = new DeepRecursiveScopeImpl(unit, jsonTreeReader$readDeepRecursive$1);
                while (true) {
                    obj = deepRecursiveScopeImpl.result;
                    Continuation<Object> continuation = deepRecursiveScopeImpl.cont;
                    if (continuation == null) {
                        break;
                    }
                    CoroutineSingletons coroutineSingletons2 = DeepRecursiveKt.UNDEFINED_RESULT;
                    if (Intrinsics.areEqual(coroutineSingletons2, obj)) {
                        try {
                            Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function3 = deepRecursiveScopeImpl.function;
                            Object obj2 = deepRecursiveScopeImpl.value;
                            if (!(function3 instanceof BaseContinuationImpl)) {
                                Intrinsics.checkNotNullParameter(function3, "<this>");
                                CoroutineContext context = continuation.getContext();
                                if (context == EmptyCoroutineContext.INSTANCE) {
                                    intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2 = new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1(continuation);
                                } else {
                                    intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2 = new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2(continuation, context);
                                }
                                TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, function3);
                                invoke = function3.invoke(deepRecursiveScopeImpl, obj2, intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2);
                            } else {
                                TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, function3);
                                invoke = function3.invoke(deepRecursiveScopeImpl, obj2, continuation);
                            }
                            if (invoke != CoroutineSingletons.COROUTINE_SUSPENDED) {
                                continuation.resumeWith(invoke);
                            }
                        } catch (Throwable th) {
                            continuation.resumeWith(ResultKt.createFailure(th));
                        }
                    } else {
                        deepRecursiveScopeImpl.result = coroutineSingletons2;
                        continuation.resumeWith(obj);
                    }
                }
                ResultKt.throwOnFailure(obj);
                jsonObject = (JsonElement) obj;
            } else {
                byte consumeNextToken = abstractJsonLexer.consumeNextToken((byte) 6);
                if (abstractJsonLexer.peekNextToken() != 4) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    while (true) {
                        if (!abstractJsonLexer.canConsumeValue()) {
                            break;
                        }
                        if (this.isLenient) {
                            consumeString = abstractJsonLexer.consumeStringLenient();
                        } else {
                            consumeString = abstractJsonLexer.consumeString();
                        }
                        abstractJsonLexer.consumeNextToken((byte) 5);
                        linkedHashMap.put(consumeString, read());
                        consumeNextToken = abstractJsonLexer.consumeNextToken();
                        if (consumeNextToken != 4) {
                            if (consumeNextToken != 7) {
                                AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected end of the object or comma", 0, null, 6);
                                throw null;
                            }
                        }
                    }
                    if (consumeNextToken == 6) {
                        abstractJsonLexer.consumeNextToken((byte) 7);
                    } else if (consumeNextToken == 4) {
                        AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected trailing comma", 0, null, 6);
                        throw null;
                    }
                    jsonObject = new JsonObject(linkedHashMap);
                } else {
                    AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected leading comma", 0, null, 6);
                    throw null;
                }
            }
            this.stackDepth--;
            return jsonObject;
        }
        if (peekNextToken == 8) {
            return readArray();
        }
        AbstractJsonLexer.fail$default(abstractJsonLexer, SubMenuBuilder$$ExternalSyntheticOutline0.m("Cannot begin reading element, unexpected token: ", peekNextToken), 0, null, 6);
        throw null;
    }

    public final JsonArray readArray() {
        boolean z;
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        byte consumeNextToken = abstractJsonLexer.consumeNextToken();
        if (abstractJsonLexer.peekNextToken() != 4) {
            ArrayList arrayList = new ArrayList();
            while (abstractJsonLexer.canConsumeValue()) {
                arrayList.add(read());
                consumeNextToken = abstractJsonLexer.consumeNextToken();
                if (consumeNextToken != 4) {
                    if (consumeNextToken == 9) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int r8 = abstractJsonLexer.currentPosition;
                    if (!z) {
                        AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected end of the array or comma", r8, null, 4);
                        throw null;
                    }
                }
            }
            if (consumeNextToken == 8) {
                abstractJsonLexer.consumeNextToken((byte) 9);
            } else if (consumeNextToken == 4) {
                AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected trailing comma", 0, null, 6);
                throw null;
            }
            return new JsonArray(arrayList);
        }
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected leading comma", 0, null, 6);
        throw null;
    }

    public final JsonPrimitive readValue(boolean z) {
        String consumeStringLenient;
        boolean z2 = this.isLenient;
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        if (!z2 && z) {
            consumeStringLenient = abstractJsonLexer.consumeString();
        } else {
            consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        }
        if (!z && Intrinsics.areEqual(consumeStringLenient, Constants.NULL_VERSION_ID)) {
            return JsonNull.INSTANCE;
        }
        return new JsonLiteral(consumeStringLenient, z);
    }
}
