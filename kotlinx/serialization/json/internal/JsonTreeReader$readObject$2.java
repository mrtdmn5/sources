package kotlinx.serialization.json.internal;

import java.util.LinkedHashMap;
import kotlin.DeepRecursiveScope;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: JsonTreeReader.kt */
@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader", f = "JsonTreeReader.kt", l = {23}, m = "readObject")
/* loaded from: classes4.dex */
public final class JsonTreeReader$readObject$2 extends ContinuationImpl {
    public DeepRecursiveScope L$0;
    public JsonTreeReader L$1;
    public LinkedHashMap L$2;
    public String L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ JsonTreeReader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readObject$2(JsonTreeReader jsonTreeReader, Continuation<? super JsonTreeReader$readObject$2> continuation) {
        super(continuation);
        this.this$0 = jsonTreeReader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return JsonTreeReader.access$readObject(this.this$0, null, this);
    }
}
