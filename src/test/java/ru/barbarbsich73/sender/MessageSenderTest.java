package ru.barbarbsich73.sender;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.barbarbsich73.entity.Country;
import ru.barbarbsich73.entity.Location;
import ru.barbarbsich73.geo.GeoService;
import ru.barbarbsich73.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;


public class MessageSenderTest {
    Map<String, String> headers = new HashMap<>();

    @Test
    public void test_Send_On_Russia_Mockito() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(Mockito.startsWith("172.")))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.34.11");
        String result = messageSender.send(headers);
        String expResult = "Добро пожаловать";

        Assertions.assertEquals(result, expResult);
    }

    @Test
    public void test_Send_On_English_Mockito() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(Mockito.startsWith("96.")))
                .thenReturn(new Location("New York", Country.USA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String result = messageSender.send(headers);
        String expResult = "Welcome";

        Assertions.assertEquals(result, expResult);
    }

}