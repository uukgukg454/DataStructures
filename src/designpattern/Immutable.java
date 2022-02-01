package designpattern;

public class Immutable {

    public static void main(String [] args) {
        MutableCompany company = new MutableCompany(1, "Yahoo");
        ImmutableEmployee employee = new ImmutableEmployee(11,"Ujjwal", company);
        System.out.println("employeeCompany:"+employee.getCompany());
        company.setId(2);
        company.setName("Verizon Media");
        System.out.println("employeeCompany:"+employee.getCompany());
    }
}

class ImmutableEmployee {

    private final int id;
    private final String name;
    private final MutableCompany company;


    public ImmutableEmployee(int id, String name, MutableCompany company) {
        this.id = id;
        this.name = name;
        this.company = new MutableCompany(company.getId(), company.getName());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MutableCompany getCompany() {
        return new MutableCompany(this.company.getId(), this.company.getName());
    }
}

class MutableCompany {
    int id;
    String name;

    public MutableCompany(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MutableCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
