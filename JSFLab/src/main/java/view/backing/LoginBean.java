package view.backing;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import java.util.ResourceBundle;

@Named(value = "loginBean")
@RequestScoped
public class LoginBean {
    private String username;
    private String password;
    private HtmlSelectBooleanCheckbox acceptCheckbox;
    private HtmlCommandButton loginButton;

    public LoginBean() {
    }

    public void activateButton(ValueChangeEvent e) {
        if (acceptCheckbox.isSelected()) {
            loginButton.setDisabled(false);
        } else {
            loginButton.setDisabled(true);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
    }

    public String login() {
        if (isDatabaseUser()) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage(ResourceBundle.getBundle("ApplicationMessages").getString(
                    "validation.dbuser"));
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, message);
            return null;
        } else if (username.equals(password)) {
            return "success";
        } else {
            return "failure";
        }
    }

    private boolean isDatabaseUser() {
        return "scott".equalsIgnoreCase(username) && "tiger".equalsIgnoreCase(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HtmlSelectBooleanCheckbox getAcceptCheckbox() {
        return acceptCheckbox;
    }

    public void setAcceptCheckbox(HtmlSelectBooleanCheckbox acceptCheckbox) {
        this.acceptCheckbox = acceptCheckbox;
    }

    public HtmlCommandButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(HtmlCommandButton loginButton) {
        this.loginButton = loginButton;
    }
}
