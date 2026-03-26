package io.sancta.sanctorum.redis;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Language {

    String language;

    Boolean isOfficial;

    BigDecimal percentage;

}
