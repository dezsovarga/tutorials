package dezso.varga.teamgenerator.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by dezsovarga on 5/7/15.
 */
@XmlRootElement
public class Player {

    String name;
    int skill;
    int initSkill;

    public Player(){

    }

    public Player(String name, int skill) {
        this.name = name;
        this.skill = skill;
    }

    public Player(String name, int skill, int initSkill) {
        this.name = name;
        this.skill = skill;
        this.initSkill = initSkill;
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

    public int getInitSkill() {
        return initSkill;
    }

    public void setInitSkill(int initSkill) {
        this.initSkill = initSkill;
    }

    public String toString(){
        return name /*+ " - " + skill*/+", ";
    }
}
