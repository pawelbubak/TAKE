package req.facade;

import req.entities.Request;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RequestFacade extends AbstractFacade<Request> implements RequestFacadeLocal {

    @PersistenceContext(unitName = "RequestsPU")
    private EntityManager em;

    public RequestFacade() {
        super(Request.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

