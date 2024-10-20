package io.sancta.sanctorum.dao;

import io.sancta.sanctorum.domain.City;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CityDAO {

    SessionFactory sessionFactory;

    public List<City> getItems(int offset, int limit) {
        String hql = "select c from City as c";
        Query<City> query = sessionFactory.getCurrentSession().createQuery(hql, City.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    public int getTotalCount() {
        String hql = "select count(c) from City as c";
        Query<Long> query = sessionFactory.getCurrentSession().createQuery(hql, Long.class);
        return Math.toIntExact(query.uniqueResult());
    }
}
