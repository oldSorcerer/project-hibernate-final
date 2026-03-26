package io.sancta.sanctorum.redis;

import io.sancta.sanctorum.domain.Continent;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CityCountry {

    Integer id;

    String name;

    String district;

    Integer population;

    String countryCode;

    String alternativeCountryCode;

    String countryName;

    Continent continent;

    String countryRegion;

    BigDecimal countrySurfaceArea;

    Integer countryPopulation;

    Set<Language> languages;

}
