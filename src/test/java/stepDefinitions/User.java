package stepDefinitions;

import lombok.Builder;
import lombok.Data;


@Builder
public class User {
   private String name;
   private String job;

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
