package com.amplifyframework.geo;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.geo.models.Coordinates;
import com.amplifyframework.geo.models.MapStyle;
import com.amplifyframework.geo.models.MapStyleDescriptor;
import com.amplifyframework.geo.options.GeoSearchByCoordinatesOptions;
import com.amplifyframework.geo.options.GeoSearchByTextOptions;
import com.amplifyframework.geo.options.GetMapStyleDescriptorOptions;
import com.amplifyframework.geo.result.GeoSearchResult;
import java.util.Collection;

/* loaded from: classes.dex */
public final class GeoCategory extends Category<GeoCategoryPlugin<?>> implements GeoCategoryBehavior {
    @Override // com.amplifyframework.geo.GeoCategoryBehavior
    public void getAvailableMaps(Consumer<Collection<MapStyle>> consumer, Consumer<GeoException> consumer2) {
        getSelectedPlugin().getAvailableMaps(consumer, consumer2);
    }

    @Override // com.amplifyframework.core.category.CategoryTypeable
    public CategoryType getCategoryType() {
        return CategoryType.GEO;
    }

    @Override // com.amplifyframework.geo.GeoCategoryBehavior
    public void getDefaultMap(Consumer<MapStyle> consumer, Consumer<GeoException> consumer2) {
        getSelectedPlugin().getDefaultMap(consumer, consumer2);
    }

    @Override // com.amplifyframework.geo.GeoCategoryBehavior
    public void getMapStyleDescriptor(Consumer<MapStyleDescriptor> consumer, Consumer<GeoException> consumer2) {
        getSelectedPlugin().getMapStyleDescriptor(consumer, consumer2);
    }

    @Override // com.amplifyframework.geo.GeoCategoryBehavior
    public void searchByCoordinates(Coordinates coordinates, Consumer<GeoSearchResult> consumer, Consumer<GeoException> consumer2) {
        getSelectedPlugin().searchByCoordinates(coordinates, consumer, consumer2);
    }

    @Override // com.amplifyframework.geo.GeoCategoryBehavior
    public void searchByText(String str, Consumer<GeoSearchResult> consumer, Consumer<GeoException> consumer2) {
        getSelectedPlugin().searchByText(str, consumer, consumer2);
    }

    @Override // com.amplifyframework.geo.GeoCategoryBehavior
    public void getMapStyleDescriptor(GetMapStyleDescriptorOptions getMapStyleDescriptorOptions, Consumer<MapStyleDescriptor> consumer, Consumer<GeoException> consumer2) {
        getSelectedPlugin().getMapStyleDescriptor(getMapStyleDescriptorOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.geo.GeoCategoryBehavior
    public void searchByCoordinates(Coordinates coordinates, GeoSearchByCoordinatesOptions geoSearchByCoordinatesOptions, Consumer<GeoSearchResult> consumer, Consumer<GeoException> consumer2) {
        getSelectedPlugin().searchByCoordinates(coordinates, geoSearchByCoordinatesOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.geo.GeoCategoryBehavior
    public void searchByText(String str, GeoSearchByTextOptions geoSearchByTextOptions, Consumer<GeoSearchResult> consumer, Consumer<GeoException> consumer2) {
        getSelectedPlugin().searchByText(str, geoSearchByTextOptions, consumer, consumer2);
    }
}
