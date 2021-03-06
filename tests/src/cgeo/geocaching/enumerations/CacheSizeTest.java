package cgeo.geocaching.enumerations;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.Locale;

import junit.framework.TestCase;

public class CacheSizeTest extends TestCase {

    public static void testOrder() {
        assertThat(CacheSize.MICRO.comparable).isLessThan(CacheSize.SMALL.comparable);
        assertThat(CacheSize.SMALL.comparable).isLessThan(CacheSize.REGULAR.comparable);
        assertThat(CacheSize.REGULAR.comparable).isLessThan(CacheSize.LARGE.comparable);
    }

    public static void testGetById() {
        assertThat(CacheSize.getById("")).isEqualTo(CacheSize.UNKNOWN);
        assertThat(CacheSize.getById(null)).isEqualTo(CacheSize.UNKNOWN);
        assertThat(CacheSize.getById("random garbage")).isEqualTo(CacheSize.UNKNOWN);
        assertThat(CacheSize.getById("large")).isEqualTo(CacheSize.LARGE);
        assertThat(CacheSize.getById("LARGE")).isEqualTo(CacheSize.LARGE);
    }

    public static void testGetByIdComplete() {
        for (final CacheSize size : CacheSize.values()) {
            assertThat(CacheSize.getById(size.id)).isEqualTo(size);
            assertThat(CacheSize.getById(size.id.toLowerCase(Locale.US))).isEqualTo(size);
            assertThat(CacheSize.getById(size.id.toUpperCase(Locale.US))).isEqualTo(size);
        }
    }

    public static void testGetByIdNumeric() {
        assertThat(CacheSize.getById("3")).isEqualTo(CacheSize.REGULAR);
        assertThat(CacheSize.getById("-1")).isEqualTo(CacheSize.UNKNOWN);
    }

    public static void testGetByIdVeryLarge() throws Exception {
        assertThat(CacheSize.getById("Very large")).isEqualTo(CacheSize.VERY_LARGE);
        assertThat(CacheSize.getById("very_large")).as("size from website icon").isEqualTo(CacheSize.VERY_LARGE);
    }

}
