import java.util.HashMap;
import java.util.Map;

import ru.barbarbsich73.geo.GeoService;
import ru.barbarbsich73.geo.GeoServiceImpl;
import ru.barbarbsich73.i18n.LocalizationService;
import ru.barbarbsich73.i18n.LocalizationServiceImpl;
import ru.barbarbsich73.sender.MessageSender;
import ru.barbarbsich73.sender.MessageSenderImpl;

public class Main {

    //Тестовый пример
    public static void main(String[] args) {
        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        messageSender.send(headers);
    }
}