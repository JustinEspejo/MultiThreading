import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class Teacher extends Thread {
	public static long time = System.currentTimeMillis();
	public Random rand = new Random();
    public Queue<Student> classLine = new LinkedList<Student>();
    public boolean classDoorOpen = true;
    public boolean schoolInSession = true;

	
	Teacher(){
		setName("Teacher");
	}
	
	public void run(){
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		msg("Class 1 will now start.");
		classDoorOpen = false;
		
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//mark all students that attended the class present
		msg("Class 1 has ended.");

		while(!classLine.isEmpty()){
			Student s = classLine.remove();
			s.classesAttended.add("Class 1");
			s.interrupt();
		}
		try {
			sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		classDoorOpen = true;
		try {
			sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		msg("Class 2 will now start.");
		classDoorOpen = false;

		//mark all students that attended the class present
		
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		msg("Class 2 has ended.");
		while(!classLine.isEmpty()){
			Student s = classLine.remove();
			s.classesAttended.add("Class 2");
			s.interrupt();
		}
		try {
			sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		classDoorOpen = true;

		try {
			sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		msg("Class 3 will now start.");
		classDoorOpen = false;

		//mark all students that attended the class present
		
		
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		msg("Class 3 has ended.");
		while(!classLine.isEmpty()){
			Student s = classLine.remove();
			s.classesAttended.add("Class 3");
			s.interrupt();
		}
		
//		classDoorOpen = true;

		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		schoolInSession = false;
		msg("Teacher is going home.");
	}
	
	public void msg(String m) {
	System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+": "+m);
	}
	
	public synchronized void addClassLine(Student student){ 
		classLine.add(student); 
	}
	
	

}
