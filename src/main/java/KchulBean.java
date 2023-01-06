import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class KchulBean {

    public List<Zoo> WetWAnimals() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost/zoo?user=root&password=");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("""
                    select ote.jmeno, count(z.id), group_concat(z.jmeno order by z.jmeno)
                    from osetrovatele as ote
                    	join osetruje as oje on(ote.id = oje.osetrovatel)
                        join zvirata as z on(oje.zvire = z.id)
                    group by ote.id;    
                    """);
            ArrayList<Zoo> getWetWAnimals = new ArrayList<>();
            while (resultSet.next())
                getWetWAnimals.add(new Zoo(resultSet.getString(1), resultSet.getInt(2), resultSet.getString(3 )));

            return getWetWAnimals;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
