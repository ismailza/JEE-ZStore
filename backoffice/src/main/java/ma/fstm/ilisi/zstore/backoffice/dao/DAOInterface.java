package ma.fstm.ilisi.zstore.backoffice.dao;

import java.util.Collection;

public interface DAOInterface<T> {
    Collection<T> retrieve();
    boolean create(T t);
    boolean update(T t);
    boolean delete(T t);

}
