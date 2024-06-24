package androidx.compose.ui.text.input;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: EditProcessor.kt */
/* loaded from: classes.dex */
public final class EditProcessor {
    public EditingBuffer mBuffer;
    public TextFieldValue mBufferState;

    public EditProcessor() {
        TextFieldValue textFieldValue = new TextFieldValue(AnnotatedStringKt.EmptyAnnotatedString, TextRange.Zero, (TextRange) null);
        this.mBufferState = textFieldValue;
        this.mBuffer = new EditingBuffer(textFieldValue.annotatedString, textFieldValue.selection);
    }

    public final TextFieldValue apply(List<? extends EditCommand> editCommands) {
        EditCommand editCommand;
        Exception e;
        final EditCommand editCommand2;
        Intrinsics.checkNotNullParameter(editCommands, "editCommands");
        try {
            int size = editCommands.size();
            int r2 = 0;
            editCommand = null;
            while (r2 < size) {
                try {
                    editCommand2 = editCommands.get(r2);
                    try {
                        editCommand2.applyTo(this.mBuffer);
                        r2++;
                        editCommand = editCommand2;
                    } catch (Exception e2) {
                        e = e2;
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder("Error while applying EditCommand batch to buffer (length=");
                        sb2.append(this.mBuffer.getLength$ui_text_release());
                        sb2.append(", composition=");
                        sb2.append(this.mBuffer.m541getCompositionMzsxiRA$ui_text_release());
                        sb2.append(", selection=");
                        EditingBuffer editingBuffer = this.mBuffer;
                        sb2.append((Object) TextRange.m527toStringimpl(TextRangeKt.TextRange(editingBuffer.selectionStart, editingBuffer.selectionEnd)));
                        sb2.append("):");
                        sb.append(sb2.toString());
                        sb.append('\n');
                        CollectionsKt___CollectionsKt.joinTo$default(editCommands, sb, "\n", new Function1<EditCommand, CharSequence>() { // from class: androidx.compose.ui.text.input.EditProcessor$generateBatchErrorMessage$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final CharSequence invoke(EditCommand editCommand3) {
                                String str;
                                String concat;
                                EditCommand it = editCommand3;
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (EditCommand.this == it) {
                                    str = " > ";
                                } else {
                                    str = "   ";
                                }
                                StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str);
                                this.getClass();
                                if (it instanceof CommitTextCommand) {
                                    StringBuilder sb3 = new StringBuilder("CommitTextCommand(text.length=");
                                    CommitTextCommand commitTextCommand = (CommitTextCommand) it;
                                    sb3.append(commitTextCommand.annotatedString.text.length());
                                    sb3.append(", newCursorPosition=");
                                    concat = AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb3, commitTextCommand.newCursorPosition, ')');
                                } else if (it instanceof SetComposingTextCommand) {
                                    StringBuilder sb4 = new StringBuilder("SetComposingTextCommand(text.length=");
                                    SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) it;
                                    sb4.append(setComposingTextCommand.annotatedString.text.length());
                                    sb4.append(", newCursorPosition=");
                                    concat = AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb4, setComposingTextCommand.newCursorPosition, ')');
                                } else if (it instanceof SetComposingRegionCommand) {
                                    concat = it.toString();
                                } else if (it instanceof DeleteSurroundingTextCommand) {
                                    concat = it.toString();
                                } else if (it instanceof DeleteSurroundingTextInCodePointsCommand) {
                                    concat = it.toString();
                                } else if (it instanceof SetSelectionCommand) {
                                    concat = it.toString();
                                } else if (it instanceof FinishComposingTextCommand) {
                                    concat = it.toString();
                                } else if (it instanceof DeleteAllCommand) {
                                    concat = it.toString();
                                } else {
                                    String simpleName = Reflection.getOrCreateKotlinClass(it.getClass()).getSimpleName();
                                    if (simpleName == null) {
                                        simpleName = "{anonymous EditCommand}";
                                    }
                                    concat = "Unknown EditCommand: ".concat(simpleName);
                                }
                                m.append(concat);
                                return m.toString();
                            }
                        }, 60);
                        String sb3 = sb.toString();
                        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
                        throw new RuntimeException(sb3, e);
                    }
                } catch (Exception e3) {
                    e = e3;
                    editCommand2 = editCommand;
                    StringBuilder sb4 = new StringBuilder();
                    StringBuilder sb22 = new StringBuilder("Error while applying EditCommand batch to buffer (length=");
                    sb22.append(this.mBuffer.getLength$ui_text_release());
                    sb22.append(", composition=");
                    sb22.append(this.mBuffer.m541getCompositionMzsxiRA$ui_text_release());
                    sb22.append(", selection=");
                    EditingBuffer editingBuffer2 = this.mBuffer;
                    sb22.append((Object) TextRange.m527toStringimpl(TextRangeKt.TextRange(editingBuffer2.selectionStart, editingBuffer2.selectionEnd)));
                    sb22.append("):");
                    sb4.append(sb22.toString());
                    sb4.append('\n');
                    CollectionsKt___CollectionsKt.joinTo$default(editCommands, sb4, "\n", new Function1<EditCommand, CharSequence>() { // from class: androidx.compose.ui.text.input.EditProcessor$generateBatchErrorMessage$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final CharSequence invoke(EditCommand editCommand3) {
                            String str;
                            String concat;
                            EditCommand it = editCommand3;
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (EditCommand.this == it) {
                                str = " > ";
                            } else {
                                str = "   ";
                            }
                            StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str);
                            this.getClass();
                            if (it instanceof CommitTextCommand) {
                                StringBuilder sb32 = new StringBuilder("CommitTextCommand(text.length=");
                                CommitTextCommand commitTextCommand = (CommitTextCommand) it;
                                sb32.append(commitTextCommand.annotatedString.text.length());
                                sb32.append(", newCursorPosition=");
                                concat = AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb32, commitTextCommand.newCursorPosition, ')');
                            } else if (it instanceof SetComposingTextCommand) {
                                StringBuilder sb42 = new StringBuilder("SetComposingTextCommand(text.length=");
                                SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) it;
                                sb42.append(setComposingTextCommand.annotatedString.text.length());
                                sb42.append(", newCursorPosition=");
                                concat = AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb42, setComposingTextCommand.newCursorPosition, ')');
                            } else if (it instanceof SetComposingRegionCommand) {
                                concat = it.toString();
                            } else if (it instanceof DeleteSurroundingTextCommand) {
                                concat = it.toString();
                            } else if (it instanceof DeleteSurroundingTextInCodePointsCommand) {
                                concat = it.toString();
                            } else if (it instanceof SetSelectionCommand) {
                                concat = it.toString();
                            } else if (it instanceof FinishComposingTextCommand) {
                                concat = it.toString();
                            } else if (it instanceof DeleteAllCommand) {
                                concat = it.toString();
                            } else {
                                String simpleName = Reflection.getOrCreateKotlinClass(it.getClass()).getSimpleName();
                                if (simpleName == null) {
                                    simpleName = "{anonymous EditCommand}";
                                }
                                concat = "Unknown EditCommand: ".concat(simpleName);
                            }
                            m.append(concat);
                            return m.toString();
                        }
                    }, 60);
                    String sb32 = sb4.toString();
                    Intrinsics.checkNotNullExpressionValue(sb32, "StringBuilder().apply(builderAction).toString()");
                    throw new RuntimeException(sb32, e);
                }
            }
            AnnotatedString annotatedString = new AnnotatedString(this.mBuffer.toString(), null, 6);
            EditingBuffer editingBuffer3 = this.mBuffer;
            TextFieldValue textFieldValue = new TextFieldValue(annotatedString, TextRangeKt.TextRange(editingBuffer3.selectionStart, editingBuffer3.selectionEnd), this.mBuffer.m541getCompositionMzsxiRA$ui_text_release());
            this.mBufferState = textFieldValue;
            return textFieldValue;
        } catch (Exception e4) {
            editCommand = null;
            e = e4;
        }
    }
}
