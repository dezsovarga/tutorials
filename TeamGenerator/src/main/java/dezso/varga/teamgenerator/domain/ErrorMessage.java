package dezso.varga.teamgenerator.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by varga on 25.10.2015.
 */
@XmlRootElement
public class ErrorMessage {

    private String errorMessage;
    private int statucsCode;
    private String documentation;

    public ErrorMessage() {
    }

    public ErrorMessage(String errorMessage, int statucsCode, String documentation) {
        super();
        this.errorMessage = errorMessage;
        this.statucsCode = statucsCode;
        this.documentation = documentation;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public int getStatucsCode() {
        return statucsCode;
    }

    public void setStatucsCode(int statucsCode) {
        this.statucsCode = statucsCode;
    }
}
