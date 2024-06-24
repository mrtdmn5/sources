package kotlinx.coroutines.flow;

/* compiled from: SharingStarted.kt */
/* loaded from: classes4.dex */
public interface SharingStarted {

    /* compiled from: SharingStarted.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final StartedEagerly Eagerly = new StartedEagerly();
        public static final StartedLazily Lazily = new StartedLazily();

        public static StartedWhileSubscribed WhileSubscribed$default() {
            return new StartedWhileSubscribed(0L, Long.MAX_VALUE);
        }
    }

    Flow<SharingCommand> command(StateFlow<Integer> stateFlow);
}
