package cat.lasallegracia.repositories;

import cat.lasallegracia.rateable.Rateable;

import java.util.List;

public interface ListRepository<T extends Rateable> {
    List<T> query(String query, int limit, int offset);
}
