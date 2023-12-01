package pl.akademiaqa.url.dto.task.request;

import lombok.Data;

@Data //generuje gettery, settery, konstrukto, nadpisza się wszystkie metody eqal, hashcode, i metoda toString
public class CreateTaskRequestDto {

    private String name;
    private String description;
    private String status;
    private String priority;
    private String parent;
    private String timeEstimate;
    private String assignees;
    private boolean archived;

}
