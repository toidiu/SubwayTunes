package models;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Query;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.jpa.JPA;

/**
 * Created by toidiu on 4/5/15.
 */
@Entity public class Artist
{

    @Id
    @GeneratedValue
    public Long id;

    @Constraints.Required
    @Formats.NonEmpty
    public String name;

    private static EntityManager getEm()
    {
        return JPA.em();
    }

    public static List<Artist> all()
    {
        Query query = getEm().createQuery("SELECT e FROM Artist e");
        return query.getResultList();
    }

    public static void create(Artist artist)
    {
        getEm().persist(artist);
    }

    public static Artist update(Artist artist)
    {
        return getEm().merge(artist);
    }


}
