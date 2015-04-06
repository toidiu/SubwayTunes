package models;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.jpa.JPA;

/**
 * Created by toidiu on 4/5/15.
 */
@Entity
public class PlayTime
{

    @Id
    @GeneratedValue
    public Long id;

    @Constraints.Required
    @Formats.NonEmpty
    public Long artistId;

    @Constraints.Required
    @Formats.NonEmpty
    public Integer time;


//    public static List<PlayTime> all()
//    {
//        return find.all();
//    }
//
//    public static void create(PlayTime play)
//    {
//        play.save();
//    }
}
