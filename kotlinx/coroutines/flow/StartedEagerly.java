package kotlinx.coroutines.flow;

/* compiled from: SharingStarted.kt */
/* loaded from: classes4.dex */
public final class StartedEagerly implements SharingStarted {
    @Override // kotlinx.coroutines.flow.SharingStarted
    public final Flow<SharingCommand> command(StateFlow<Integer> stateFlow) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(SharingCommand.START);
    }

    public final String toString() {
        return "SharingStarted.Eagerly";
    }
}
