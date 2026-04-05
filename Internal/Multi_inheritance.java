interface PersonalInfo {
    void showName();
}
interface AcademicInfo {
    void showCollege();
}
class Student implements PersonalInfo, AcademicInfo {
    String name = "Arigela Tejasri";
    String college = "Aditya University";
    @Override
    public void showName() {
        System.out.println("Student Name: " + name);
    }
    @Override
    public void showCollege() {
        System.out.println("University: " + college);
    }
}
public class Multi_inheritance {
    public static void main(String[] args) {
        Student s = new Student();
        s.showName();
        s.showCollege();
    }
}
