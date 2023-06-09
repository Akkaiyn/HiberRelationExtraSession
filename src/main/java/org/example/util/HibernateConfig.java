package org.example.util;

import jakarta.persistence.EntityManager;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;




import static org.hibernate.cfg.AvailableSettings.*;


public class HibernateConfig {
    public static EntityManager getEntityManager(){
        Configuration configuration = new Configuration();
        configuration.setProperty(DRIVER, "org.postgresql.Driver");
        configuration.setProperty(URL, "jdbc:postgresql://localhost:5432/Hibernate");
        configuration.setProperty(USER, "postgres");
        configuration.setProperty(PASS, "qwert");
        configuration.setProperty(HBM2DDL_AUTO, "update");
        configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty(SHOW_SQL, "true");

      configuration.addAnnotatedClass(Course.class);
      configuration.addAnnotatedClass(Instructor.class);
      configuration.addAnnotatedClass(Lesson.class);
      configuration.addAnnotatedClass(Task.class);
      return   configuration.buildSessionFactory().createEntityManager();

    }
}
