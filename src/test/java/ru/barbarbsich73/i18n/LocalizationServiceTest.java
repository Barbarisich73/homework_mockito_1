package ru.barbarbsich73.i18n;

import org.junit.Test;
import ru.barbarbsich73.entity.Country;

import static org.junit.Assert.assertEquals;

public class LocalizationServiceTest {

    @Test
    public void testLocaleForRussia() {
        LocalizationService instance = new LocalizationServiceImpl();
        String expResult = "Добро пожаловать";
        String result = instance.locale(Country.RUSSIA);
        assertEquals(expResult, result);
    }

    @Test
    public void testLocaleForUsa() {
        LocalizationService instance = new LocalizationServiceImpl();
        String expResult = "Welcome";
        String result = instance.locale(Country.USA);
        assertEquals(expResult, result);
    }

}