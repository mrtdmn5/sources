package androidx.compose.ui.text.input;

import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import com.animaconnected.secondo.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: AndroidTextInputServicePlugin.kt */
/* loaded from: classes.dex */
public final class AndroidTextInputServicePlugin implements PlatformTextInputPlugin<Adapter> {
    public static final AndroidTextInputServicePlugin INSTANCE = new AndroidTextInputServicePlugin();

    /* compiled from: AndroidTextInputServicePlugin.kt */
    /* loaded from: classes.dex */
    public static final class Adapter implements PlatformTextInputAdapter {
        public final TextInputServiceAndroid androidService;
        public final TextInputService service;

        public Adapter(TextInputService textInputService, TextInputServiceAndroid textInputServiceAndroid) {
            this.service = textInputService;
            this.androidService = textInputServiceAndroid;
        }

        @Override // androidx.compose.ui.text.input.PlatformTextInputAdapter
        public final RecordingInputConnection createInputConnection(EditorInfo outAttrs) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            int r8;
            boolean z9;
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            boolean z15;
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z20;
            boolean z21;
            boolean z22;
            boolean z23;
            Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
            TextInputServiceAndroid textInputServiceAndroid = this.androidService;
            textInputServiceAndroid.getClass();
            ImeOptions imeOptions = textInputServiceAndroid.imeOptions;
            TextFieldValue textFieldValue = textInputServiceAndroid.state;
            Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
            Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
            int r7 = imeOptions.imeAction;
            if (r7 == 1) {
                z = true;
            } else {
                z = false;
            }
            boolean z24 = imeOptions.singleLine;
            if (z) {
                if (!z24) {
                    r8 = 0;
                }
                r8 = 6;
            } else {
                if (r7 == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    r8 = 1;
                } else {
                    if (r7 == 2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        r8 = 2;
                    } else {
                        if (r7 == 6) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            r8 = 5;
                        } else {
                            if (r7 == 5) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                r8 = 7;
                            } else {
                                if (r7 == 3) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if (z6) {
                                    r8 = 3;
                                } else {
                                    if (r7 == 4) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    if (z7) {
                                        r8 = 4;
                                    } else {
                                        if (r7 == 7) {
                                            z8 = true;
                                        } else {
                                            z8 = false;
                                        }
                                        if (!z8) {
                                            throw new IllegalStateException("invalid ImeAction".toString());
                                        }
                                        r8 = 6;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            outAttrs.imeOptions = r8;
            int r5 = imeOptions.keyboardType;
            if (r5 == 1) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z9) {
                outAttrs.inputType = 1;
            } else {
                if (r5 == 2) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    outAttrs.inputType = 1;
                    outAttrs.imeOptions = Integer.MIN_VALUE | r8;
                } else {
                    if (r5 == 3) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        outAttrs.inputType = 2;
                    } else {
                        if (r5 == 4) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            outAttrs.inputType = 3;
                        } else {
                            if (r5 == 5) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            if (z13) {
                                outAttrs.inputType = 17;
                            } else {
                                if (r5 == 6) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                if (z14) {
                                    outAttrs.inputType = 33;
                                } else {
                                    if (r5 == 7) {
                                        z15 = true;
                                    } else {
                                        z15 = false;
                                    }
                                    if (z15) {
                                        outAttrs.inputType = R.styleable.AppTheme_statusTopStripeImportant;
                                    } else {
                                        if (r5 == 8) {
                                            z16 = true;
                                        } else {
                                            z16 = false;
                                        }
                                        if (z16) {
                                            outAttrs.inputType = 18;
                                        } else {
                                            if (r5 == 9) {
                                                z17 = true;
                                            } else {
                                                z17 = false;
                                            }
                                            if (z17) {
                                                outAttrs.inputType = 8194;
                                            } else {
                                                throw new IllegalStateException("Invalid Keyboard Type".toString());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!z24) {
                int r52 = outAttrs.inputType;
                if ((r52 & 1) == 1) {
                    z22 = true;
                } else {
                    z22 = false;
                }
                if (z22) {
                    outAttrs.inputType = r52 | 131072;
                    if (r7 == 1) {
                        z23 = true;
                    } else {
                        z23 = false;
                    }
                    if (z23) {
                        outAttrs.imeOptions |= 1073741824;
                    }
                }
            }
            int r53 = outAttrs.inputType;
            if ((r53 & 1) == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                int r72 = imeOptions.capitalization;
                if (r72 == 1) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    outAttrs.inputType = r53 | 4096;
                } else {
                    if (r72 == 2) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    if (z20) {
                        outAttrs.inputType = r53 | DfuBaseService.ERROR_REMOTE_MASK;
                    } else {
                        if (r72 == 3) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        if (z21) {
                            outAttrs.inputType = r53 | DfuBaseService.ERROR_CONNECTION_MASK;
                        }
                    }
                }
                if (imeOptions.autoCorrect) {
                    outAttrs.inputType |= DfuBaseService.ERROR_CONNECTION_STATE_MASK;
                }
            }
            int r3 = TextRange.$r8$clinit;
            long j = textFieldValue.selection;
            outAttrs.initialSelStart = (int) (j >> 32);
            outAttrs.initialSelEnd = TextRange.m523getEndimpl(j);
            EditorInfoCompat.setInitialSurroundingText(outAttrs, textFieldValue.annotatedString.text);
            outAttrs.imeOptions |= 33554432;
            if (EmojiCompat.isConfigured()) {
                EmojiCompat.get().updateEditorInfo(outAttrs);
            }
            RecordingInputConnection recordingInputConnection = new RecordingInputConnection(textInputServiceAndroid.state, new InputEventCallback2() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$createInputConnection$1
                public TextInputServiceAndroid$createInputConnection$1() {
                }

                @Override // androidx.compose.ui.text.input.InputEventCallback2
                public final void onConnectionClosed(RecordingInputConnection ic) {
                    Intrinsics.checkNotNullParameter(ic, "ic");
                    TextInputServiceAndroid textInputServiceAndroid2 = TextInputServiceAndroid.this;
                    int size = textInputServiceAndroid2.ics.size();
                    for (int r2 = 0; r2 < size; r2++) {
                        ArrayList arrayList = textInputServiceAndroid2.ics;
                        if (Intrinsics.areEqual(((WeakReference) arrayList.get(r2)).get(), ic)) {
                            arrayList.remove(r2);
                            return;
                        }
                    }
                }

                @Override // androidx.compose.ui.text.input.InputEventCallback2
                public final void onEditCommands(ArrayList arrayList) {
                    TextInputServiceAndroid.this.onEditCommand.invoke(arrayList);
                }

                @Override // androidx.compose.ui.text.input.InputEventCallback2
                /* renamed from: onImeAction-KlQnJC8 */
                public final void mo543onImeActionKlQnJC8(int r32) {
                    TextInputServiceAndroid.this.onImeActionPerformed.invoke(new ImeAction(r32));
                }

                @Override // androidx.compose.ui.text.input.InputEventCallback2
                public final void onKeyEvent(KeyEvent event) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    ((BaseInputConnection) TextInputServiceAndroid.this.baseInputConnection$delegate.getValue()).sendKeyEvent(event);
                }
            }, textInputServiceAndroid.imeOptions.autoCorrect);
            textInputServiceAndroid.ics.add(new WeakReference(recordingInputConnection));
            return recordingInputConnection;
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputPlugin
    public final Adapter createAdapter(AndroidComposeView view, PlatformTextInput platformTextInput) {
        Intrinsics.checkNotNullParameter(platformTextInput, "platformTextInput");
        Intrinsics.checkNotNullParameter(view, "view");
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(view, platformTextInput);
        return new Adapter(new TextInputService(textInputServiceAndroid), textInputServiceAndroid);
    }
}
