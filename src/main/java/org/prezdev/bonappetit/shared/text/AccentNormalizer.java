package org.prezdev.bonappetit.shared.text;

import java.text.Normalizer;
import org.springframework.stereotype.Component;

@Component
public class AccentNormalizer {

    public String normalize(String input) {
        if (input == null) {
            return null;
        }
        
        String nfd = Normalizer.normalize(input, Normalizer.Form.NFD);
        String withoutMarks = nfd.replaceAll("\\p{M}", "");
        String collapsed = withoutMarks.replaceAll("\\s+", " ").trim();

        return collapsed.toLowerCase();
    }
}
