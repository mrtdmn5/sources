package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferedChannel.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class BufferedChannelKt$createSegmentFunction$1 extends FunctionReferenceImpl implements Function2<Long, ChannelSegment<Object>, ChannelSegment<Object>> {
    public static final BufferedChannelKt$createSegmentFunction$1 INSTANCE = new BufferedChannelKt$createSegmentFunction$1();

    public BufferedChannelKt$createSegmentFunction$1() {
        super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ChannelSegment<Object> invoke(Long l, ChannelSegment<Object> channelSegment) {
        long longValue = l.longValue();
        ChannelSegment<Object> channelSegment2 = channelSegment;
        ChannelSegment<Object> channelSegment3 = BufferedChannelKt.NULL_SEGMENT;
        BufferedChannel<Object> bufferedChannel = channelSegment2._channel;
        Intrinsics.checkNotNull(bufferedChannel);
        return new ChannelSegment<>(longValue, channelSegment2, bufferedChannel, 0);
    }
}
