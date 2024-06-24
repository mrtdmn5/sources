package kotlin.jvm.internal;

/* loaded from: classes.dex */
public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    public MutablePropertyReference1Impl(Class cls, String str, String str2, int r10) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, r10);
    }

    public Object get(Object obj) {
        getGetter();
        throw null;
    }
}
