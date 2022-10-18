package example.show.domain.repository;

import example.show.domain.entity.Actor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ActorRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Actor actor) {
        em.persist(actor);
    }

    public Actor findOne(Long id) {
        return em.find(Actor.class, id);
    }

    public List<Actor> findAll() {
        return em.createQuery("select a from Actor a", Actor.class)
                .getResultList();
    }

    public List<Actor> findByName(String name){
        return em.createQuery("select a from Actor a where a.name = :name", Actor.class)
                .setParameter("name", name)
                .getResultList();
    }
}
