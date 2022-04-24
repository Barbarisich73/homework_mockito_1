package ru.barbarbsich73.geo;

import org.junit.Test;
import ru.barbarbsich73.entity.Country;
import ru.barbarbsich73.entity.Location;

import static org.junit.Assert.assertEquals;

public class GeoServiceTest {

    @Test
    public void testByIpForRussia() {
        GeoService instance = new GeoServiceImpl();
        String expResult = String.valueOf(new Location("Moscow", Country.RUSSIA, "Lenina", 15).getCountry());
        String result = String.valueOf(instance.byIp("172.0.32.11").getCountry());
        assertEquals(expResult, result);
    }

    @Test
    public void testByIpForUsa() {
        GeoService instance = new GeoServiceImpl();
        String expResult = String.valueOf(new Location("New York", Country.USA, "10th Avenue", 32).getCountry());
        String result = String.valueOf(instance.byIp("96.44.183.149").getCountry());
        assertEquals(expResult, result);
    }
}
