package androidx.compose.ui.text.input;

import android.R;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.compose.ui.text.TextRange;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;
import org.slf4j.helpers.NormalizedParameters;

/* compiled from: RecordingInputConnection.android.kt */
/* loaded from: classes.dex */
public final class RecordingInputConnection implements InputConnection {
    public final boolean autoCorrect;
    public int batchDepth;
    public int currentExtractedTextRequestToken;
    public final ArrayList editCommands;
    public final InputEventCallback2 eventCallback;
    public boolean extractedTextMonitorMode;
    public boolean isActive;
    public TextFieldValue mTextFieldValue;

    public RecordingInputConnection(TextFieldValue initState, TextInputServiceAndroid$createInputConnection$1 textInputServiceAndroid$createInputConnection$1, boolean z) {
        Intrinsics.checkNotNullParameter(initState, "initState");
        this.eventCallback = textInputServiceAndroid$createInputConnection$1;
        this.autoCorrect = z;
        this.mTextFieldValue = initState;
        this.editCommands = new ArrayList();
        this.isActive = true;
    }

    public final void addEditCommandWithBatch(EditCommand editCommand) {
        this.batchDepth++;
        try {
            this.editCommands.add(editCommand);
        } finally {
            endBatchEditInternal();
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean beginBatchEdit() {
        boolean z = this.isActive;
        if (z) {
            this.batchDepth++;
            return true;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean clearMetaKeyStates(int r1) {
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final void closeConnection() {
        this.editCommands.clear();
        this.batchDepth = 0;
        this.isActive = false;
        this.eventCallback.onConnectionClosed(this);
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitCompletion(CompletionInfo completionInfo) {
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int r2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inputContentInfo, "inputContentInfo");
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean z = this.isActive;
        if (z) {
            return this.autoCorrect;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence charSequence, int r4) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new CommitTextCommand(String.valueOf(charSequence), r4));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int r2, int r3) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new DeleteSurroundingTextCommand(r2, r3));
            return true;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int r2, int r3) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new DeleteSurroundingTextInCodePointsCommand(r2, r3));
            return true;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean endBatchEdit() {
        return endBatchEditInternal();
    }

    public final boolean endBatchEditInternal() {
        int r0 = this.batchDepth - 1;
        this.batchDepth = r0;
        if (r0 == 0) {
            ArrayList arrayList = this.editCommands;
            if (!arrayList.isEmpty()) {
                this.eventCallback.onEditCommands(CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList));
                arrayList.clear();
            }
        }
        if (this.batchDepth > 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean finishComposingText() {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new FinishComposingTextCommand());
            return true;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final int getCursorCapsMode(int r5) {
        TextFieldValue textFieldValue = this.mTextFieldValue;
        return TextUtils.getCapsMode(textFieldValue.annotatedString.text, TextRange.m525getMinimpl(textFieldValue.selection), r5);
    }

    @Override // android.view.inputmethod.InputConnection
    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int r4) {
        boolean z = true;
        int r1 = 0;
        if ((r4 & 1) == 0) {
            z = false;
        }
        this.extractedTextMonitorMode = z;
        if (z) {
            if (extractedTextRequest != null) {
                r1 = extractedTextRequest.token;
            }
            this.currentExtractedTextRequestToken = r1;
        }
        return JobKt.toExtractedText(this.mTextFieldValue);
    }

    @Override // android.view.inputmethod.InputConnection
    public final Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getSelectedText(int r3) {
        if (TextRange.m522getCollapsedimpl(this.mTextFieldValue.selection)) {
            return null;
        }
        return NormalizedParameters.getSelectedText(this.mTextFieldValue).text;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getTextAfterCursor(int r1, int r2) {
        return NormalizedParameters.getTextAfterSelection(this.mTextFieldValue, r1).text;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getTextBeforeCursor(int r1, int r2) {
        return NormalizedParameters.getTextBeforeSelection(this.mTextFieldValue, r1).text;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.inputmethod.InputConnection
    public final boolean performContextMenuAction(int r3) {
        boolean z = this.isActive;
        if (z) {
            z = false;
            switch (r3) {
                case R.id.selectAll:
                    addEditCommandWithBatch(new SetSelectionCommand(0, this.mTextFieldValue.annotatedString.text.length()));
                    break;
                case R.id.cut:
                    sendSynthesizedKeyEvent(277);
                    break;
                case R.id.copy:
                    sendSynthesizedKeyEvent(278);
                    break;
                case R.id.paste:
                    sendSynthesizedKeyEvent(279);
                    break;
            }
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean performEditorAction(int r4) {
        int r42;
        boolean z = this.isActive;
        if (z) {
            z = true;
            if (r4 != 0) {
                switch (r4) {
                    case 2:
                        r42 = 2;
                        break;
                    case 3:
                        r42 = 3;
                        break;
                    case 4:
                        r42 = 4;
                        break;
                    case 5:
                        r42 = 6;
                        break;
                    case 6:
                        r42 = 7;
                        break;
                    case 7:
                        r42 = 5;
                        break;
                    default:
                        Log.w("RecordingIC", "IME sends unsupported Editor Action: " + r4);
                        break;
                }
                this.eventCallback.mo543onImeActionKlQnJC8(r42);
            }
            r42 = 1;
            this.eventCallback.mo543onImeActionKlQnJC8(r42);
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean performPrivateCommand(String str, Bundle bundle) {
        boolean z = this.isActive;
        if (z) {
            return true;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean reportFullscreenMode(boolean z) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean requestCursorUpdates(int r2) {
        boolean z = this.isActive;
        if (z) {
            Log.w("RecordingIC", "requestCursorUpdates is not supported");
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z = this.isActive;
        if (z) {
            this.eventCallback.onKeyEvent(event);
            return true;
        }
        return z;
    }

    public final void sendSynthesizedKeyEvent(int r3) {
        sendKeyEvent(new KeyEvent(0, r3));
        sendKeyEvent(new KeyEvent(1, r3));
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setComposingRegion(int r3, int r4) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new SetComposingRegionCommand(r3, r4));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence, int r4) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new SetComposingTextCommand(String.valueOf(charSequence), r4));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setSelection(int r2, int r3) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new SetSelectionCommand(r2, r3));
            return true;
        }
        return z;
    }
}
