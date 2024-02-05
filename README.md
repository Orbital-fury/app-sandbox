# Swagger
http://localhost:8080/api/v1/swagger-ui/index.html<br>
Original is: http://localhost:8080/swagger-ui/index.html

# H2 in-memory DB
http://localhost:8080/api/v1/h2-console<br>
DB created and populated with sql script, not with JPA Entity<br>
Original is: http://localhost:8080/h2-console

# Explanations
- Spring @Transactional example [here](https://stackoverflow.com/questions/8490852/spring-transactional-isolation-propagation)

# Questions
- Is it ok to do this ? (to map with a function 'fromDto' // is it okay to have function in dto classes?)
```@Data
@AllArgsConstructor
@ToString
public class PcConstraintWithoutValue {
    private int id;
    private String name;
    private String code;
    private PcConstraintType type;

    public static PcConstraintWithoutValue fromEntity(PcConstraintEntity pcConstraintEntity) {
        return new PcConstraintWithoutValue(pcConstraintEntity.getId(), pcConstraintEntity.getName(),
                pcConstraintEntity.getCode(), pcConstraintEntity.getType());
    }
}
```
