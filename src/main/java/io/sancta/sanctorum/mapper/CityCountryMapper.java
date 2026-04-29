package io.sancta.sanctorum.mapper;

import io.sancta.sanctorum.domain.City;
import io.sancta.sanctorum.redis.CityCountry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityCountryMapper {

    CityCountryMapper INSTANCE = Mappers.getMapper(CityCountryMapper.class);

    @Mapping(source = "country.code", target = "countryCode")
    @Mapping(source = "country.alternativeCode", target = "alternativeCountryCode")
    @Mapping(source = "country.name", target = "countryName")
    @Mapping(source = "country.continent", target = "continent")
    @Mapping(source = "country.region", target = "countryRegion")
    @Mapping(source = "country.surfaceArea", target = "countrySurfaceArea")
    @Mapping(source = "country.population", target = "countryPopulation")
    @Mapping(source = "country.languages", target = "languages")
    CityCountry cityToCityCountry(City city);

    List<CityCountry> citiesToCityCountries(List<City> cities);

}
