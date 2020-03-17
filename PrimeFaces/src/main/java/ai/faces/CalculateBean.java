package ai.faces;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.Date;

@Named(value = "calculateBean")
@RequestScoped
public class CalculateBean {
    private int firstVariable;
    private int secondVariable;
    private int result;
    private Date date = new Date();

    public CalculateBean() {
    }

    public void calculate() {
        result = firstVariable + secondVariable;
        FacesMessage message = new FacesMessage("Successful",
                firstVariable + " + " + secondVariable + " = " + result);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public int getFirstVariable() {
        return firstVariable;
    }

    public void setFirstVariable(int firstVariable) {
        this.firstVariable = firstVariable;
    }

    public int getSecondVariable() {
        return secondVariable;
    }

    public void setSecondVariable(int secondVariable) {
        this.secondVariable = secondVariable;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
