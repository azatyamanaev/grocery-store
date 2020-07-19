package ru.itis.grocerystore.services;

import ru.itis.grocerystore.models.FtlEnum;

import java.util.Map;

public interface MessageConvertorService {
    String fromEmailToFtl(String email, FtlEnum ftlEnum);
    String inviteToFtl(Map<String, String> map);
}
