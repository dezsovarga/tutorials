package dezso.varga.teamgenerator;

/**
 * Created by dezsovarga on 5/7/15.
 */
public class Player {

    String name;
    int skill;

    public Player(String name, int skill) {
        this.name = name;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public String toString(){
        return name /*+ " - " + skill*/+", ";
    }
}
