package kotlinx.coroutines.flow;

/* compiled from: SharingStarted.kt */
/* loaded from: classes4.dex */
public final class StartedLazily implements SharingStarted {
    @Override // kotlinx.coroutines.flow.SharingStarted
    public final Flow<SharingCommand> command(StateFlow<Integer> stateFlow) {
        return new SafeFlow(new StartedLazily$command$1(stateFlow, null));
    }

    public final String toString() {
        return "SharingStarted.Lazily";
    }
}
