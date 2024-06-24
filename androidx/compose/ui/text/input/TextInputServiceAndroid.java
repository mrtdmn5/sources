package androidx.compose.ui.text.input;

import android.graphics.Rect;
import android.view.Choreographer;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import androidx.compose.foundation.text.TextFieldDelegate$Companion$restartInput$1;
import androidx.compose.foundation.text.TextFieldState$onImeActionPerformed$1;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.JobKt;

/* compiled from: TextInputServiceAndroid.android.kt */
/* loaded from: classes.dex */
public final class TextInputServiceAndroid implements PlatformTextInputService {
    public final Lazy baseInputConnection$delegate;
    public Rect focusedRect;
    public TextInputServiceAndroid$$ExternalSyntheticLambda0 frameCallback;
    public final ArrayList ics;
    public ImeOptions imeOptions;
    public final Executor inputCommandProcessorExecutor;
    public final InputMethodManager inputMethodManager;
    public Function1<? super List<? extends EditCommand>, Unit> onEditCommand;
    public Function1<? super ImeAction, Unit> onImeActionPerformed;
    public final PlatformTextInput platformTextInput;
    public TextFieldValue state;
    public final MutableVector<TextInputCommand> textInputCommandQueue;
    public final View view;

    /* compiled from: TextInputServiceAndroid.android.kt */
    /* loaded from: classes.dex */
    public enum TextInputCommand {
        StartInput,
        StopInput,
        ShowKeyboard,
        HideKeyboard
    }

    /* compiled from: TextInputServiceAndroid.android.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[TextInputCommand.values().length];
            try {
                r0[TextInputCommand.StartInput.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[TextInputCommand.StopInput.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[TextInputCommand.ShowKeyboard.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[TextInputCommand.HideKeyboard.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public TextInputServiceAndroid(AndroidComposeView view, PlatformTextInput platformTextInput) {
        Intrinsics.checkNotNullParameter(view, "view");
        InputMethodManagerImpl inputMethodManagerImpl = new InputMethodManagerImpl(view);
        final Choreographer choreographer = Choreographer.getInstance();
        Intrinsics.checkNotNullExpressionValue(choreographer, "getInstance()");
        Executor executor = new Executor() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(final Runnable runnable) {
                Choreographer this_asExecutor = choreographer;
                Intrinsics.checkNotNullParameter(this_asExecutor, "$this_asExecutor");
                this_asExecutor.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1
                    @Override // android.view.Choreographer.FrameCallback
                    public final void doFrame(long j) {
                        runnable.run();
                    }
                });
            }
        };
        this.view = view;
        this.inputMethodManager = inputMethodManagerImpl;
        this.platformTextInput = platformTextInput;
        this.inputCommandProcessorExecutor = executor;
        this.onEditCommand = new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$onEditCommand$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(List<? extends EditCommand> list) {
                List<? extends EditCommand> it = list;
                Intrinsics.checkNotNullParameter(it, "it");
                return Unit.INSTANCE;
            }
        };
        this.onImeActionPerformed = new Function1<ImeAction, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$onImeActionPerformed$1
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(ImeAction imeAction) {
                int r1 = imeAction.value;
                return Unit.INSTANCE;
            }
        };
        this.state = new TextFieldValue("", TextRange.Zero, 4);
        this.imeOptions = ImeOptions.Default;
        this.ics = new ArrayList();
        this.baseInputConnection$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new Function0<BaseInputConnection>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$baseInputConnection$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BaseInputConnection invoke() {
                return new BaseInputConnection(TextInputServiceAndroid.this.view, false);
            }
        });
        this.textInputCommandQueue = new MutableVector<>(new TextInputCommand[16]);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void hideSoftwareKeyboard() {
        sendInputCommand(TextInputCommand.HideKeyboard);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void notifyFocusedRect(androidx.compose.ui.geometry.Rect rect) {
        Rect rect2;
        this.focusedRect = new Rect(MathKt__MathJVMKt.roundToInt(rect.left), MathKt__MathJVMKt.roundToInt(rect.top), MathKt__MathJVMKt.roundToInt(rect.right), MathKt__MathJVMKt.roundToInt(rect.bottom));
        if (this.ics.isEmpty() && (rect2 = this.focusedRect) != null) {
            this.view.requestRectangleOnScreen(new Rect(rect2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Runnable, androidx.compose.ui.text.input.TextInputServiceAndroid$$ExternalSyntheticLambda0] */
    public final void sendInputCommand(TextInputCommand textInputCommand) {
        this.textInputCommandQueue.add(textInputCommand);
        if (this.frameCallback == null) {
            ?? r2 = new Runnable() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$$ExternalSyntheticLambda0
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r8v2, types: [T, java.lang.Boolean] */
                /* JADX WARN: Type inference failed for: r8v3, types: [T, java.lang.Boolean] */
                /* JADX WARN: Type inference failed for: r8v4, types: [T, java.lang.Boolean] */
                @Override // java.lang.Runnable
                public final void run() {
                    TextInputServiceAndroid this$0 = TextInputServiceAndroid.this;
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    this$0.frameCallback = null;
                    boolean isFocused = this$0.view.isFocused();
                    MutableVector<TextInputServiceAndroid.TextInputCommand> mutableVector = this$0.textInputCommandQueue;
                    if (!isFocused) {
                        mutableVector.clear();
                        return;
                    }
                    Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    int r4 = mutableVector.size;
                    if (r4 > 0) {
                        TextInputServiceAndroid.TextInputCommand[] textInputCommandArr = mutableVector.content;
                        int r7 = 0;
                        do {
                            TextInputServiceAndroid.TextInputCommand textInputCommand2 = textInputCommandArr[r7];
                            int r9 = TextInputServiceAndroid.WhenMappings.$EnumSwitchMapping$0[textInputCommand2.ordinal()];
                            boolean z = true;
                            if (r9 != 1) {
                                if (r9 != 2) {
                                    if ((r9 == 3 || r9 == 4) && !Intrinsics.areEqual(ref$ObjectRef.element, Boolean.FALSE)) {
                                        if (textInputCommand2 != TextInputServiceAndroid.TextInputCommand.ShowKeyboard) {
                                            z = false;
                                        }
                                        ref$ObjectRef2.element = Boolean.valueOf(z);
                                    }
                                } else {
                                    ?? r8 = Boolean.FALSE;
                                    ref$ObjectRef.element = r8;
                                    ref$ObjectRef2.element = r8;
                                }
                            } else {
                                ?? r82 = Boolean.TRUE;
                                ref$ObjectRef.element = r82;
                                ref$ObjectRef2.element = r82;
                            }
                            r7++;
                        } while (r7 < r4);
                    }
                    mutableVector.clear();
                    boolean areEqual = Intrinsics.areEqual(ref$ObjectRef.element, Boolean.TRUE);
                    InputMethodManager inputMethodManager = this$0.inputMethodManager;
                    if (areEqual) {
                        inputMethodManager.restartInput();
                    }
                    Boolean bool = (Boolean) ref$ObjectRef2.element;
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            inputMethodManager.showSoftInput();
                        } else {
                            inputMethodManager.hideSoftInput();
                        }
                    }
                    if (Intrinsics.areEqual(ref$ObjectRef.element, Boolean.FALSE)) {
                        inputMethodManager.restartInput();
                    }
                }
            };
            this.inputCommandProcessorExecutor.execute(r2);
            this.frameCallback = r2;
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void showSoftwareKeyboard() {
        sendInputCommand(TextInputCommand.ShowKeyboard);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void startInput(TextFieldValue value, ImeOptions imeOptions, TextFieldDelegate$Companion$restartInput$1 textFieldDelegate$Companion$restartInput$1, TextFieldState$onImeActionPerformed$1 textFieldState$onImeActionPerformed$1) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        PlatformTextInput platformTextInput = this.platformTextInput;
        if (platformTextInput != null) {
            platformTextInput.requestInputFocus();
        }
        this.state = value;
        this.imeOptions = imeOptions;
        this.onEditCommand = textFieldDelegate$Companion$restartInput$1;
        this.onImeActionPerformed = textFieldState$onImeActionPerformed$1;
        sendInputCommand(TextInputCommand.StartInput);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void stopInput() {
        PlatformTextInput platformTextInput = this.platformTextInput;
        if (platformTextInput != null) {
            platformTextInput.releaseInputFocus();
        }
        this.onEditCommand = new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(List<? extends EditCommand> list) {
                List<? extends EditCommand> it = list;
                Intrinsics.checkNotNullParameter(it, "it");
                return Unit.INSTANCE;
            }
        };
        this.onImeActionPerformed = new Function1<ImeAction, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$2
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(ImeAction imeAction) {
                int r1 = imeAction.value;
                return Unit.INSTANCE;
            }
        };
        this.focusedRect = null;
        sendInputCommand(TextInputCommand.StopInput);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        boolean z;
        int r1;
        int r14;
        int r0;
        long j = this.state.selection;
        long j2 = textFieldValue2.selection;
        boolean m521equalsimpl0 = TextRange.m521equalsimpl0(j, j2);
        boolean z2 = true;
        TextRange textRange = textFieldValue2.composition;
        if (m521equalsimpl0 && Intrinsics.areEqual(this.state.composition, textRange)) {
            z = false;
        } else {
            z = true;
        }
        this.state = textFieldValue2;
        ArrayList arrayList = this.ics;
        int size = arrayList.size();
        for (int r8 = 0; r8 < size; r8++) {
            RecordingInputConnection recordingInputConnection = (RecordingInputConnection) ((WeakReference) arrayList.get(r8)).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.mTextFieldValue = textFieldValue2;
            }
        }
        boolean areEqual = Intrinsics.areEqual(textFieldValue, textFieldValue2);
        InputMethodManager inputMethodManager = this.inputMethodManager;
        int r9 = -1;
        if (areEqual) {
            if (z) {
                int m525getMinimpl = TextRange.m525getMinimpl(j2);
                int m524getMaximpl = TextRange.m524getMaximpl(j2);
                TextRange textRange2 = this.state.composition;
                if (textRange2 != null) {
                    r0 = TextRange.m525getMinimpl(textRange2.packedValue);
                } else {
                    r0 = -1;
                }
                TextRange textRange3 = this.state.composition;
                if (textRange3 != null) {
                    r9 = TextRange.m524getMaximpl(textRange3.packedValue);
                }
                inputMethodManager.updateSelection(m525getMinimpl, m524getMaximpl, r0, r9);
                return;
            }
            return;
        }
        if (textFieldValue == null || (Intrinsics.areEqual(textFieldValue.annotatedString.text, textFieldValue2.annotatedString.text) && (!TextRange.m521equalsimpl0(textFieldValue.selection, j2) || Intrinsics.areEqual(textFieldValue.composition, textRange)))) {
            z2 = false;
        }
        if (z2) {
            inputMethodManager.restartInput();
            return;
        }
        int size2 = arrayList.size();
        for (int r4 = 0; r4 < size2; r4++) {
            RecordingInputConnection recordingInputConnection2 = (RecordingInputConnection) ((WeakReference) arrayList.get(r4)).get();
            if (recordingInputConnection2 != null) {
                TextFieldValue state = this.state;
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(inputMethodManager, "inputMethodManager");
                if (recordingInputConnection2.isActive) {
                    recordingInputConnection2.mTextFieldValue = state;
                    if (recordingInputConnection2.extractedTextMonitorMode) {
                        inputMethodManager.updateExtractedText(recordingInputConnection2.currentExtractedTextRequestToken, JobKt.toExtractedText(state));
                    }
                    TextRange textRange4 = state.composition;
                    if (textRange4 != null) {
                        r1 = TextRange.m525getMinimpl(textRange4.packedValue);
                    } else {
                        r1 = -1;
                    }
                    if (textRange4 != null) {
                        r14 = TextRange.m524getMaximpl(textRange4.packedValue);
                    } else {
                        r14 = -1;
                    }
                    long j3 = state.selection;
                    inputMethodManager.updateSelection(TextRange.m525getMinimpl(j3), TextRange.m524getMaximpl(j3), r1, r14);
                }
            }
        }
    }
}
