package ma.fstm.ilisi.zstore.backoffice.service;

import java.util.Collection;

public interface ServiceInterface<T> {
    Collection<T> retrieve();
    boolean create(T t);
    boolean update(T t);
    boolean delete(T t);
}
