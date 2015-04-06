package controllers;

import models.Artist;
import play.data.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;

public class ApplicationController extends Controller
{

    public static Result login()
    {
        return ok(login.render(Form.form(Login.class)));
    }

    public static Result authenticate()
    {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("email", loginForm.get().email);
            return redirect(routes.ArtistController.listArtists());
        }

    }


    public static class Login
    {
        public String email;
        public String password;

        public String validate() {
            if (Artist.authenticate(email, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }

    }
}
