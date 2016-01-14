import java.util.LinkedList;
import java.util.Random;


public class Student extends Thread {
	public static long time = System.currentTimeMillis();
	public Random rand = new Random();
	public boolean bathroomUsed = false;
	public LinkedList<String> classesAttended = new LinkedList<String>();
	public int studentNumber;

	
	Student(String name, int studentNumber){
		this.studentNumber = studentNumber;
		setName(name);
	}
	
	public void run(){
		msg("started");
		try {
			sleep(randFiveThousand());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		msg("Awake and headed to the bathroom:");
		BlueCollege.dorm.addBathroomQueue(this);
		while(!bathroomUsed) yield(); //busy waiting
		msg("is done using the bathroom.");
		while(BlueCollege.teacher.schoolInSession){
			//go to the auditorium
			if(BlueCollege.teacher.classDoorOpen) {
				BlueCollege.teacher.addClassLine(this);
				msg("waiting in the auditorium for the class to start.");
				while(BlueCollege.teacher.classDoorOpen) yield();
				msg("is attending the class.");
				try {
					sleep(100000);
				} catch (InterruptedException e) {
					msg("is interrupted by the teacher and will exit the class.");
				}
				try {
					sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.setPriority(MAX_PRIORITY);
				msg("sets the priority to max priority and will now have some fun.");
				try {
					sleep(randFiveThousand());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				msg("is done having fun and is now setting priority back to default.");
				this.setPriority(NORM_PRIORITY);
			} else {
				msg("could not make the class, so is walking around the campus and doing some errands.");
				try {
					sleep(randFiveThousand());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				msg("will try to join a class again.");
			}
			
		}
		if(studentNumber == 0) msg("realizes school has ended.");
		else {
			msg("realizes school has ended, so they will join student-" + (studentNumber-1) + " to go home.");
			try {
				BlueCollege.students[studentNumber-1].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		msg("is leaving for home.");
		msg("Total number of classes take: " + classesAttended.size() + " : " + classesAttended);
		
	}
	
	public void msg(String m) {
		System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+": "+m);
	}
	
	private int randFiveThousand(){
		return rand.nextInt(5000);
	}

}
