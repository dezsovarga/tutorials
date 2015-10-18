package dezso.varga.teamgenerator.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by varga on 18.08.2015.
 */
@XmlRootElement
public class TeamPair {

    private Team team1;
    private Team team2;
    private int teamDiff;

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public TeamPair(){

    }

    public TeamPair(Team team1, Team team2) {

        this.team1 = team1;
        this.team2 = team2;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getTeamDiff(){

        return Math.abs(team1.getSkillSum() - team2.getSkillSum());
    }

    public String toString(){

        return "Team diff: " + getTeamDiff() + "\n" + team1 + "\n" + team2 + "\n";
    }
}
