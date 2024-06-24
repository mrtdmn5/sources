package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import no.nordicsemi.android.dfu.DfuBaseService$5$$ExternalSyntheticApiModelOutline0;
import no.nordicsemi.android.dfu.DfuServiceInitiator$$ExternalSyntheticApiModelOutline0;

/* loaded from: classes.dex */
public final class AppCompatTextClassifierHelper {
    public TextClassifier mTextClassifier;
    public final TextView mTextView;

    public AppCompatTextClassifierHelper(TextView textView) {
        textView.getClass();
        this.mTextView = textView;
    }

    public final TextClassifier getTextClassifier() {
        TextClassifier textClassifier;
        TextClassifier textClassifier2;
        TextClassifier textClassifier3 = this.mTextClassifier;
        if (textClassifier3 == null) {
            TextClassificationManager m = DfuServiceInitiator$$ExternalSyntheticApiModelOutline0.m(this.mTextView.getContext().getSystemService(DfuBaseService$5$$ExternalSyntheticApiModelOutline0.m()));
            if (m != null) {
                textClassifier2 = m.getTextClassifier();
                return textClassifier2;
            }
            textClassifier = TextClassifier.NO_OP;
            return textClassifier;
        }
        return textClassifier3;
    }
}
