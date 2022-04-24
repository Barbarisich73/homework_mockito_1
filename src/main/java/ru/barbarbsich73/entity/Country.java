package ru.barbarbsich73.entity;

import ru.barbarbsich73.i18n.LocalizationService;

public enum Country implements LocalizationService {
    RUSSIA,
    GERMANY,
    USA,
    BRAZIL;

    @Override
    public String locale(Country country) {
        return null;
    }
}
