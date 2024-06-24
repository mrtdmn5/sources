package kotlinx.coroutines;

import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.Job;

/* loaded from: classes4.dex */
public final class JobKt {
    public static JobImpl Job$default() {
        return new JobImpl(null);
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        int r0 = Job.$r8$clinit;
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null && !job.isActive()) {
            throw job.getCancellationException();
        }
    }

    public static final Job getJob(CoroutineContext coroutineContext) {
        int r0 = Job.$r8$clinit;
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        int r0 = Job.$r8$clinit;
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    public static final ExtractedText toExtractedText(TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "<this>");
        ExtractedText extractedText = new ExtractedText();
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        String str = annotatedString.text;
        extractedText.text = str;
        extractedText.startOffset = 0;
        extractedText.partialEndOffset = str.length();
        extractedText.partialStartOffset = -1;
        long j = textFieldValue.selection;
        extractedText.selectionStart = TextRange.m525getMinimpl(j);
        extractedText.selectionEnd = TextRange.m524getMaximpl(j);
        extractedText.flags = !StringsKt__StringsKt.contains$default(annotatedString.text, '\n') ? 1 : 0;
        return extractedText;
    }
}
