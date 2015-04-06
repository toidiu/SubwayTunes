package controllers;

import java.util.List;

import models.Artist;
import models.PlayTime;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller
{

    @Transactional
    public static Result index()
    {

        Artist artist = new Artist();
        artist.name = "test";
        Artist.create(artist);

        List<Artist> all = Artist.all();
        return ok(index.render("Artists", all));
    }

    @Transactional
    public static Result addArtist()
    {
        Form<Artist> form = Form.form(Artist.class).bindFromRequest();
        Artist.create(form.get());
        return ok();
    }

    @Transactional
    public static Result addPlay()
    {
        Form<PlayTime> form = Form.form(PlayTime.class).bindFromRequest();
//        PlayTime.create(form.get());
        return ok();
    }

}
