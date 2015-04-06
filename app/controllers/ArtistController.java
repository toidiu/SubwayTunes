package controllers;

import java.util.List;

import models.Artist;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class ArtistController extends Controller
{

    @Transactional
    public static Result listArtists()
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

}
