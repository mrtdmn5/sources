package androidx.compose.ui.graphics;

import android.graphics.Shader;

/* compiled from: Paint.kt */
/* loaded from: classes.dex */
public interface Paint {
    android.graphics.Paint asFrameworkPaint();

    float getAlpha();

    /* renamed from: getBlendMode-0nO6VwU */
    int mo292getBlendMode0nO6VwU();

    /* renamed from: getColor-0d7_KjU */
    long mo293getColor0d7_KjU();

    ColorFilter getColorFilter();

    /* renamed from: getFilterQuality-f-v9h1I */
    int mo294getFilterQualityfv9h1I();

    Shader getShader();

    void setAlpha(float f);

    /* renamed from: setBlendMode-s9anfk8 */
    void mo297setBlendModes9anfk8(int r1);

    /* renamed from: setColor-8_81llA */
    void mo298setColor8_81llA(long j);

    void setColorFilter(ColorFilter colorFilter);

    /* renamed from: setFilterQuality-vDHp3xo */
    void mo299setFilterQualityvDHp3xo(int r1);

    void setShader(Shader shader);
}
