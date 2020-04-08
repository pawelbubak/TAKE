package req.backing;

import req.entities.Request;
import req.facade.RequestFacadeLocal;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Named(value = "requestsList")
@RequestScoped
public class RequestsList {
    
    @Inject
    private RequestFacadeLocal requestFacade;
    @Size(min = 3, max = 60, message = "{request.size}")
    private String newRequest;
    private HtmlDataTable requestsDataTable;

    public RequestsList() {
    }

    public List<Request> getAllRequests() {
        return requestFacade.findAll();
    }

    public String addRequest() {
        Request request = new Request();
        request.setRequestDate(LocalDate.now());
        request.setRequestText(newRequest);
        requestFacade.create(request);
        setNewRequest("");
        return null;
    }

    public String deleteRequest() {
        Request request = (Request) getRequestsDataTable().getRowData();
        requestFacade.remove(request);
        return null;
    }

    public HtmlDataTable getRequestsDataTable() {
        return requestsDataTable;
    }

    public void setRequestsDataTable(HtmlDataTable requestsDataTable) {
        this.requestsDataTable = requestsDataTable;
    }

    public String getNewRequest() {
        return newRequest;
    }

    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }
}

