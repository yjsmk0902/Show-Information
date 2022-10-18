package example.show.domain.repository;

import example.show.domain.entity.Place;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PlaceRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Place place) {
        em.persist(place);
    }

    public Place findOne(Long id) {
        return em.find(Place.class, id);
    }

    public List<Place> findAll() {
        return em.createQuery("select p from Place p", Place.class)
                .getResultList();
    }

    public List<Place> findByName(String name) {
        return em.createQuery("select p from Place p where p.name = :name", Place.class)
                .setParameter("name", name)
                .getResultList();
    }
}
