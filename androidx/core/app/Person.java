package androidx.core.app;

import android.app.Person;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public final class Person {
    public final IconCompat mIcon;
    public final boolean mIsBot;
    public final boolean mIsImportant;
    public final String mKey;
    public final CharSequence mName;
    public final String mUri;

    /* loaded from: classes.dex */
    public static class Api28Impl {
        public static Person fromAndroidPerson(android.app.Person person) {
            IconCompat iconCompat;
            Builder builder = new Builder();
            builder.mName = person.getName();
            IconCompat iconCompat2 = null;
            if (person.getIcon() != null) {
                Icon icon = person.getIcon();
                PorterDuff.Mode mode = IconCompat.DEFAULT_TINT_MODE;
                icon.getClass();
                int type = IconCompat.Api23Impl.getType(icon);
                if (type != 2) {
                    if (type != 4) {
                        if (type != 6) {
                            iconCompat2 = new IconCompat(-1);
                            iconCompat2.mObj1 = icon;
                        } else {
                            Uri uri = IconCompat.Api23Impl.getUri(icon);
                            uri.getClass();
                            String uri2 = uri.toString();
                            uri2.getClass();
                            iconCompat = new IconCompat(6);
                            iconCompat.mObj1 = uri2;
                        }
                    } else {
                        Uri uri3 = IconCompat.Api23Impl.getUri(icon);
                        uri3.getClass();
                        String uri4 = uri3.toString();
                        uri4.getClass();
                        iconCompat = new IconCompat(4);
                        iconCompat.mObj1 = uri4;
                    }
                    iconCompat2 = iconCompat;
                } else {
                    iconCompat2 = IconCompat.createWithResource(null, IconCompat.Api23Impl.getResPackage(icon), IconCompat.Api23Impl.getResId(icon));
                }
            }
            builder.mIcon = iconCompat2;
            builder.mUri = person.getUri();
            builder.mKey = person.getKey();
            builder.mIsBot = person.isBot();
            builder.mIsImportant = person.isImportant();
            return new Person(builder);
        }

        public static android.app.Person toAndroidPerson(Person person) {
            Person.Builder name = new Person.Builder().setName(person.mName);
            Icon icon = null;
            IconCompat iconCompat = person.mIcon;
            if (iconCompat != null) {
                iconCompat.getClass();
                icon = IconCompat.Api23Impl.toIcon(iconCompat, null);
            }
            return name.setIcon(icon).setUri(person.mUri).setKey(person.mKey).setBot(person.mIsBot).setImportant(person.mIsImportant).build();
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public IconCompat mIcon;
        public boolean mIsBot;
        public boolean mIsImportant;
        public String mKey;
        public CharSequence mName;
        public String mUri;
    }

    public Person(Builder builder) {
        this.mName = builder.mName;
        this.mIcon = builder.mIcon;
        this.mUri = builder.mUri;
        this.mKey = builder.mKey;
        this.mIsBot = builder.mIsBot;
        this.mIsImportant = builder.mIsImportant;
    }
}
