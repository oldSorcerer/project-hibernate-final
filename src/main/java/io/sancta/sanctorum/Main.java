package io.sancta.sanctorum;

import io.sancta.sanctorum.dao.CityDAO;
import io.sancta.sanctorum.domain.City;
import io.sancta.sanctorum.domain.CountryLanguage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        GeoController controller = new GeoController();
        controller.run();

       // testPostgresData(List.of(1));
    }

    public static void testPostgresData(List<Integer> ids) {
        try (SessionFactory sessionFactory = new Configuration().configure("postgres-hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            CityDAO cityDAO = new CityDAO(sessionFactory);

            session.beginTransaction();
            for (Integer id : ids) {
                City city = cityDAO.getById(id);
                Set<CountryLanguage> languages = city.getCountry().getLanguages();
            }
            session.getTransaction().commit();
            System.out.println("finish");
        }
    }

}