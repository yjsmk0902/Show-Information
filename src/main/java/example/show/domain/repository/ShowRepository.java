package example.show.domain.repository;

import example.show.domain.entity.Show;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShowRepository {
    private static final Map<Long, Show> store = new HashMap<>();
    private static long sequence = 0L;

    public Show save(Show show) {
        show.setId(++sequence);
        store.put(show.getId(), show);
        return show;
    }

    public Show findById(Long id) {
        return store.get(id);
    }

    public List<Show> findAll() {
        return new ArrayList<>(store.values());
    }
}
