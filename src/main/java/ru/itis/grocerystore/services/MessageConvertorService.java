package ru.itis.grocerystore.services;

import ru.itis.grocerystore.models.FtlEnum;

public interface MessageConvertorService {
    String fromEmailToFtl(String email, FtlEnum ftlEnum);
}
