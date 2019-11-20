package dale.springboot.controller;

import org.flywaydb.core.Flyway;

/**
 * @author xueneng on 2019/11/20.
 *         Description:
 */
public class App {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/community?serverTimezone=UTC","root","123456").load();
        flyway.baseline();
        //start the migration
        flyway.migrate();
    }
}
