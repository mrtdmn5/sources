package kotlinx.serialization.json.internal;

import kotlin.DeepRecursiveScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.serialization.json.JsonElement;

/* compiled from: JsonTreeReader.kt */
@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", l = {112}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, JsonElement>, Unit, Continuation<? super JsonElement>, Object> {
    public /* synthetic */ DeepRecursiveScope L$0;
    public int label;
    public final /* synthetic */ JsonTreeReader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readDeepRecursive$1(JsonTreeReader jsonTreeReader, Continuation<? super JsonTreeReader$readDeepRecursive$1> continuation) {
        super(3, continuation);
        this.this$0 = jsonTreeReader;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope, Unit unit, Continuation<? super JsonElement> continuation) {
        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this.this$0, continuation);
        jsonTreeReader$readDeepRecursive$1.L$0 = deepRecursiveScope;
        return jsonTreeReader$readDeepRecursive$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            DeepRecursiveScope deepRecursiveScope = this.L$0;
            JsonTreeReader jsonTreeReader = this.this$0;
            byte peekNextToken = jsonTreeReader.lexer.peekNextToken();
            if (peekNextToken == 1) {
                return jsonTreeReader.readValue(true);
            }
            if (peekNextToken == 0) {
                return jsonTreeReader.readValue(false);
            }
            if (peekNextToken == 6) {
                this.label = 1;
                obj = JsonTreeReader.access$readObject(jsonTreeReader, deepRecursiveScope, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (peekNextToken == 8) {
                    return jsonTreeReader.readArray();
                }
                AbstractJsonLexer.fail$default(jsonTreeReader.lexer, "Can't begin reading element, unexpected token", 0, null, 6);
                throw null;
            }
        }
        return (JsonElement) obj;
    }
}
