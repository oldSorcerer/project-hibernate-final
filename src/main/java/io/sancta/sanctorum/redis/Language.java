package io.sancta.sanctorum.redis;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Language {

    String language;

    Boolean isOfficial;

    BigDecimal percentage;

}
