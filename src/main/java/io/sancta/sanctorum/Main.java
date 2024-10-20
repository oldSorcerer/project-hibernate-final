package io.sancta.sanctorum;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.lettuce.core.RedisClient;
import io.sancta.sanctorum.dao.CityDAO;
import io.sancta.sanctorum.dao.CountryDAO;
import io.sancta.sanctorum.domain.City;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Main {

    SessionFactory sessionFactory;
    CityDAO cityDAO;
    CountryDAO countryDAO;

    RedisClient redisClient;
    ObjectMapper mapper;

    public Main() {
        sessionFactory = prepareRelationalDatabase();
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);

        redisClient = prepareRedisClient();
        mapper = new ObjectMapper();
    }

    public static void main(String[] args) {
        Main main = new Main();
        List<City> allCities = main.fetchData(main);
        System.out.println(allCities.size());
        main.shutdown();
    }

    private SessionFactory prepareRelationalDatabase() {
        return new Configuration().configure().buildSessionFactory();
    }

    private RedisClient prepareRedisClient() {
        return RedisClient.create();
    }

    private void shutdown() {
        if (Objects.nonNull(sessionFactory)) sessionFactory.close();

        if (Objects.nonNull(redisClient)) redisClient.shutdown();
    }

    private List<City> fetchData(Main main) {

        try (Session session = main.sessionFactory.getCurrentSession()) {
            List<City> allCities = new ArrayList<>();

            session.beginTransaction();

            int totalCount = main.cityDAO.getTotalCount();
            int step = 500;
            for (int i = 0; i < totalCount; i += step) {
                allCities.addAll(main.cityDAO.getItems(i, step));
            }

            session.getTransaction().commit();
            return allCities;
        }
    }
}