package ru.barbarbsich73.i18n;

import ru.barbarbsich73.entity.Country;

public interface LocalizationService {

    String locale(Country country);
}