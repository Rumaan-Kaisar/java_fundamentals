
public class JV_ch1_1_2_First_Oop_Team{
    Member member;
    // Team() is a method
    public JV_ch1_1_2_First_Oop_Team(Member member){
        this.member = member;
    }

    /* The "main" method inside the "JV_ch1_1_2_First_Oop_Team class" is the 'entry point 'to our program. Without the "main" method, we cannot tell the "Java Virtual Machine (JVM)" from where to begin execution of the program */
    public static void main(String[] args){
        Member myMember = new Member("Aumi", "water", 10, 7);
        JV_ch1_1_2_First_Oop_Team myTeam = new JV_ch1_1_2_First_Oop_Team(myMember);
        // Calling the getter functions inside println
        System.out.println(myTeam.member.getName());
        System.out.println(myTeam.member.getType());
        System.out.println(myTeam.member.getLevel());
        System.out.println(myTeam.member.getRank());
    }

}

// Member() is a class
class Member {
    private String name;
    private String type;
    private int level;
    private int rank;

    // Member() is a method of Member class
    public Member(String name, String type, int level, int rank){
        this.name = name;
        this.type = type;
        this.level = level;
        this.rank = rank;
    }
    /* let's define our getter functions here */
    public String getName() { // what is your name?
        return this.name; // my name is ...
        }
        public String getType() { // what is your type?
        return this.type; // my type is ...
        }
        public int getLevel() { // what is your level?
        return this.level; // my level is ...
        }
        public int getRank() { // what is your rank?
        return this.rank; // my rank is
        }
}



// javac JV_ch1_1_2_First_Oop_Team.java
// java JV_ch1_1_2_First_Oop_Team
