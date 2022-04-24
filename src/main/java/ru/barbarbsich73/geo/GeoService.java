package ru.barbarbsich73.geo;

import ru.barbarbsich73.entity.Location;

public interface GeoService {

    Location byIp(String ip);

    Location byCoordinates(double latitude, double longitude);
}
