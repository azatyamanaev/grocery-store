package ru.itis.grocerystore.services;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import ru.itis.grocerystore.models.FtlEnum;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MessageConvertorServiceImpl implements MessageConvertorService {

    @Autowired
    private Configuration freemarkerConfig;

    @Override
    public String fromEmailToFtl(String confirmCode, FtlEnum ftlEnum) {
        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates/");
        Map<String, String> map = new HashMap<>();
        String link = "";
        if (ftlEnum.equals(FtlEnum.CONFIRM))
            link = "http://localhost:8080/confirm/" + confirmCode;
        else if (ftlEnum.equals(FtlEnum.RESET))
            link = "http://localhost:8080/user/changePassword?id=" + confirmCode;
        map.put("code", link);
        Template t;
        String html;
        try {
            t = freemarkerConfig.getTemplate("email.ftl");
            html = FreeMarkerTemplateUtils.processTemplateIntoString(t, map);
        } catch (IOException | TemplateException e) {
            throw new IllegalArgumentException(e);
        }

        return html;
    }
}
