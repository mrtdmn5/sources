package kotlin.collections;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SlidingWindow.kt */
/* loaded from: classes.dex */
public final class RingBuffer$iterator$1<T> extends AbstractIterator<T> {
    public int count;
    public int index;
    public final /* synthetic */ RingBuffer<T> this$0;

    public RingBuffer$iterator$1(RingBuffer<T> ringBuffer) {
        this.this$0 = ringBuffer;
        this.count = ringBuffer.getSize();
        this.index = ringBuffer.startIndex;
    }
}
