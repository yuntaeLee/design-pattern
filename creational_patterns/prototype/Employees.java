package creational_patterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {
    
    private List<String> empList;

    public Employees() {
        empList = new ArrayList<String>();
    }

    public Employees(List<String> empList) {
        this.empList = empList;
    }

    public void loadData() {
        empList.addAll(List.of("Pankaj", "Raj", "David", "Lisa"));
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
	public Object clone() throws CloneNotSupportedException{
        List<String> copyList = new ArrayList<String>(this.empList);
        return new Employees(copyList);
	}
}
