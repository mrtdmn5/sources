package aws.smithy.kotlin.runtime.serde.json;

/* compiled from: LexerState.kt */
/* loaded from: classes.dex */
public enum LexerState {
    Initial,
    ArrayFirstValueOrEnd,
    ArrayNextValueOrEnd,
    ObjectFirstKeyOrEnd,
    ObjectNextKeyOrEnd,
    ObjectFieldValue
}
