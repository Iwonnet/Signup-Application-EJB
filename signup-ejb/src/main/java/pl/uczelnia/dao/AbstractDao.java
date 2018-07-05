package pl.uczelnia.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T> {

    @PersistenceContext(unitName = "Signup")
    protected EntityManager entityManager;


    protected abstract Class<T> getType();

    static <R> Optional<R> checkForSingleResult(List<R> resultList) {
        return resultList.isEmpty() ? Optional.empty() : Optional.of(resultList.get(0));
    }

    public void create(T object) {
        entityManager.persist(object);
    }

    public T merge(T object) {

        return entityManager.merge(object);
    }

    public void remove(Object id) {
        T o = entityManager.find(getType(), id);

        entityManager.remove(o);
    }

    public List<T> all() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getType());

        cq.select(cq.from(getType()));
        return entityManager.createQuery(cq).getResultList();
    }

    public List<T> list(int offset, int limit) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getType());

        cq.select(cq.from(getType()));
        return entityManager.createQuery(cq).setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public Optional<T> get(Object id) {
        T t = entityManager.find(getType(), id);
        return t == null ? Optional.empty() : Optional.of(t);
    }
}

