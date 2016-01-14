/**
 * 
 * Project 1
 * Professor: Dr. Simina Fluture
 * @author Justin Espejo
 * 		   ID: 12217389
 *
 */
public class BlueCollege {
	
    public static DormitoryBathroom dorm;
    public static Student students[];
    public static Teacher teacher;

	public static void main(String[] args) {
		students = new Student[10];
		teacher = new Teacher();
		dorm = new DormitoryBathroom();
		teacher.start();
		dorm.start();
		System.out.println("Number of students set to 10 and teacher set to 1.");
		System.out.println("A Day in the Dormitory Started:");
		for(int i = 0; i < students.length; i++){
			students[i] = new Student("Student-" + i, i);
			students[i].start();
		}
	}
	
	
}
