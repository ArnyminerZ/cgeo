package cgeo.geocaching.apps.navi;

import cgeo.geocaching.R;
import cgeo.geocaching.models.Geocache;
import cgeo.geocaching.models.Waypoint;

import android.content.Context;
import android.support.annotation.NonNull;

class StaticMapApp extends AbstractStaticMapsApp {

    StaticMapApp() {
        super(getString(R.string.cache_menu_map_static));
    }

    @Override
    public boolean isEnabled(@NonNull final Geocache cache) {
        return cache.isOffline() && cache.hasStaticMap();
    }

    @Override
    public boolean isEnabled(@NonNull final Waypoint waypoint) {
        return hasStaticMap(waypoint);
    }

    @Override
    public void navigate(@NonNull final Context context, @NonNull final Geocache cache) {
        invokeStaticMaps(context, cache, null, false);
    }

    @Override
    public void navigate(@NonNull final Context context, @NonNull final Waypoint waypoint) {
        invokeStaticMaps(context, null, waypoint, false);
    }
}
