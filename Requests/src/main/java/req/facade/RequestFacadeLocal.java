package req.facade;

import req.entities.Request;

import javax.ejb.Local;
import java.util.List;

@Local
public interface RequestFacadeLocal {

    void create(Request request);

    void edit(Request request);

    void remove(Request request);

    Request find(Object id);

    List<Request> findAll();

    List<Request> findRange(int[] range);

    int count();
}
